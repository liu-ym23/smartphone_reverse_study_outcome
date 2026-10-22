package dwa;

import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f470355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f470356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f470357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pools.SynchronizedPool<C5718a> f470358d;

    /* JADX INFO: renamed from: dwa.a$a, reason: collision with other inner class name */
    public static class C5718a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f470359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f470360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ViewGroup f470361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f470362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f470363e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f470364f;

        public C5718a() {
            this.f470359a = 0;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C5718a f470365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f470366b;

        public final void a() {
            if (this.f470366b.f470357c == false) goto L5;
        L12:
            long r100 = SystemClock.currentThreadTimeMillis();
            C5718a r101 = this.f470365a;
            if (r101 != null) goto L38;
            return;
        L38:
        L23:
            e = move-exception;
            Log.e("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e, true);
            if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == true) goto L37;
            if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L37;
        L28:
            Log.d("AsyncLayoutInflater", "InflateRunnable cost：" + r101.f470362d + HTTP.URL_DEFAULT + (SystemClock.currentThreadTimeMillis() - r100));
            d r102 = r101.f470364f;
            if ((r102 instanceof e) == false) goto L31;
            ((e) r102).a(r101.f470363e, r101.f470362d);
        L31:
            d r103 = r101.f470364f;
            if ((r103 instanceof c) == false) goto L34;
            ((c) r103).b(r101.f470363e);
        L34:
            a r104 = this.f470366b;
            r104.getClass();
            r101.f470364f = null;
            r101.f470360b = null;
            r101.f470361c = null;
            r101.f470362d = 0;
            r101.f470363e = null;
            r101.f470359a = 0;
            r104.f470358d.release(r101);
            return;
        L37:
            throw new RuntimeException("Failed to inflate resource in the background! Retrying on the UI thread", e);
        L17:
            if (r101.f470359a == 1) goto L19;
            r101.f470363e = r101.f470360b.inflate(r101.f470362d, r101.f470361c, false);     // Catch: RuntimeException -> L23
            goto L28
        L19:
            f r105 = r101.f470360b;     // Catch: RuntimeException -> L23
            if (r105.f470371d != null) goto L41;
            r105.a(r105.getContext());     // Catch: RuntimeException -> L23
            throw null;     // Catch: RuntimeException -> L23
        L41:
            throw null;     // Catch: RuntimeException -> L23
        L5:
            if (Build.VERSION.SDK_INT > 22) goto L12;
            a r106 = this.f470366b;
            r106.getClass();
            Field r107 = Looper.class.getDeclaredField("sThreadLocal");     // Catch: Throwable -> L9
            r107.setAccessible(true);     // Catch: Throwable -> L9
            ((ThreadLocal) r107.get(null)).set(Looper.getMainLooper());     // Catch: Throwable -> L9
            Log.i("AsyncLayoutInflater", "setMainLooper success");     // Catch: Throwable -> L9
        L11:
            r106.f470357c = true;
        L9:
            th = move-exception;
            Log.e("AsyncLayoutInflater", "setMainLooper exception", th);
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, C5718a r101) {
            this.f470366b = r100;
            this.f470365a = r101;
        }
    }

    public interface c extends d {
        void b(View r100);
    }

    public interface d {
    }

    public interface e extends d {
        void a(View r100, int r101);
    }

    public a(dwa.e r100, ExecutorService r101) {
        this.f470358d = new Pools.SynchronizedPool(25);
        this.f470356b = r101;
        this.f470355a = new f(r100, LayoutInflater.from(r100));
    }
}
