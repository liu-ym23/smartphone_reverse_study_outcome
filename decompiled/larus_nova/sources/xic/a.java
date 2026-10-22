package xic;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f564015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager f564016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<c> f564017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f564018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f564019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RunnableC8244a f564020f;

    /* JADX INFO: renamed from: xic.a$a, reason: collision with other inner class name */
    public class RunnableC8244a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564021a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f564021a;     // Catch: Throwable -> L4
            r100.b(r100.f564019e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8244a(a r100) {
            this.f564021a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f564022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f564023b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f564023b.a(this.f564022a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, int r101) {
            this.f564023b = r100;
            this.f564022a = r101;
        }
    }

    public interface c {
        void onAudioFocusGain(boolean r100);

        void onAudioFocusLoss(boolean r100);
    }

    public final void a(int r100) {
        c r101 = this.f564017c.get();
        if (r101 != null) goto L12;
        this.f564016b.abandonAudioFocus(this);     // Catch: Exception -> L7
    L9:
        this.f564015a.removeCallbacksAndMessages(null);
        return;
    L7:
        e = move-exception;
        ajc.b.a("VideoAudioFocusController", "returnFocus error");
        e.printStackTrace();
        goto L9
    L12:
        if (r100 != (-2)) goto L14;
        r101.onAudioFocusLoss(true);
        return;
    L14:
        if (r100 != 1) goto L17;
        r101.onAudioFocusGain(true);
        return;
    L17:
        if (r100 != (-1)) goto L24;
        r101.onAudioFocusLoss(true);
        return;
    }

    public final void b(int r100) {
        c r101 = this.f564017c.get();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f564019e = r100;
        int r102 = this.f564016b.requestAudioFocus(this, 3, r100);     // Catch: Exception -> L8
    L11:
        if (r102 != 1) goto L13;
        this.f564018d = true;
        this.f564015a.removeCallbacksAndMessages(this.f564020f);
        r101.onAudioFocusGain(false);
        return;
    L13:
        if (this.f564018d == false) goto L15;
        this.f564018d = false;
        this.f564015a.removeCallbacksAndMessages(this.f564020f);
        this.f564015a.postDelayed(this.f564020f, 1000);
        return;
    L15:
        r101.onAudioFocusLoss(false);
        return;
    L8:
        e = move-exception;
        ajc.b.a("VideoAudioFocusController", "gainFocus error");
        e.printStackTrace();
        r102 = 0;
        goto L11
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int r100) {
        ajc.b.a("VideoAudioFocusController", "change audio:" + r100);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        this.f564015a.post(new b(this, r100));
        return;
    L5:
        a(r100);
    }

    public a(Context r100, c r101) {
        this.f564015a = new Handler(Looper.getMainLooper());
        this.f564018d = true;
        this.f564019e = 1;
        this.f564020f = new RunnableC8244a(this);
        this.f564016b = (AudioManager) r100.getApplicationContext().getSystemService("audio");
        this.f564017c = new WeakReference(r101);
    }
}
