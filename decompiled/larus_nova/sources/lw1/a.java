package lw1;

import android.view.Choreographer;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f510993g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f510994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f510995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f510996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f510997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f510998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChoreographerFrameCallbackC6742a f510999f;

    /* JADX INFO: renamed from: lw1.a$a, reason: collision with other inner class name */
    public class ChoreographerFrameCallbackC6742a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f511000a;

        public ChoreographerFrameCallbackC6742a(a r100) {
            this.f511000a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            a r101 = this.f511000a;
            if (r101.f510997d == true) goto L6;
            return;
        L6:
            if (r101.f510995b > 0) goto L8;
            r101.f510995b = r100;
        L9:
            r101.f510994a = r100;
            Choreographer.getInstance().postFrameCallback(this);     // Catch: Throwable -> L14
            if (a.f510993g == false) goto L18;
            this.f511000a.a(true);     // Catch: Throwable -> L14
            return;
        L18:
            return;
        L14:
            this.f511000a.f510997d = false;
            return;
        L8:
            r101.f510996c++;
            goto L9
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f511001a = null;

        static {
            f511001a = new a();
        }
    }

    static {
        f510993g = Logger.debug();
    }

    public a() {
        this.f510998e = 0;
        this.f510999f = new ChoreographerFrameCallbackC6742a(this);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 1;
    L6:
        long r102 = this.f510996c;
        if (r102 < r101) goto L17;
        long r103 = this.f510994a;
        long r104 = this.f510995b;
        if (r103 <= r104) goto L18;
        float r105 = (r102 * 1.0E9f) / (r103 - r104);
        if (r100 == true) goto L14;
        String r106 = z0.f124605d;
        JSONObject r107 = new JSONObject();
        BaseMonitor.add(r107, "feed_fps", r105);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_list_fps_all", 0, r107);
        this.f510998e++;
    L14:
        if (f510993g == false) goto L19;
        Logger.d("FPSMonitor", "report: realTime = " + r100 + ", frameCount = " + this.f510996c + ", fps = " + r105);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r101 = 30;
        goto L6
    }

    public final void b(int r100) {
        if (r100 == 0) goto L29;
        boolean r101 = this.f510997d;
        if (r101 == false) goto L11;
    L16:
        if (r101 == true) goto L35;
        Choreographer.getInstance().removeFrameCallback(this.f510999f);     // Catch: Throwable -> L25
        if (this.f510997d == false) goto L31;
        a(false);     // Catch: Throwable -> L25
    L31:
        this.f510995b = 0;     // Catch: Throwable -> L23
        this.f510994a = 0;     // Catch: Throwable -> L23
        this.f510996c = 0;     // Catch: Throwable -> L23
        this.f510997d = true;     // Catch: Throwable -> L23
        Choreographer.getInstance().postFrameCallback(this.f510999f);     // Catch: Throwable -> L23
        return;
    L23:
        this.f510997d = false;
        return;
    L35:
        return;
    L11:
        if (this.f510998e <= 10) goto L16;
        if (f510993g == false) goto L33;
        Logger.d("FPSMonitor", "stop because over max count, cur count = " + this.f510998e);
        return;
    L33:
        return;
    L29:
        Choreographer.getInstance().removeFrameCallback(this.f510999f);     // Catch: Throwable -> L26
        if (this.f510997d == false) goto L7;
        a(false);     // Catch: Throwable -> L26
    L7:
        this.f510997d = false;
        this.f510995b = 0;
        this.f510994a = 0;
        this.f510996c = 0;
    }
}
