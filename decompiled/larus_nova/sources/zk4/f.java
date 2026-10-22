package zk4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.larus.dora.api.model.FlowDoraConnectReason;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements vk4.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f572630f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final al4.a f572631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vk4.i f572632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f572633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f572634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f572635e;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f572636a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 10000) goto L6;
            pk4.j.d("DoraWifiSoftAp", "handleTimeout: MSG_REQUEST_SOFT_AP_TIMEOUT");
            k r101 = f.f572630f;
            r101.a("SoftApRequestApTimeout");
            r101.f572646g = FlowDoraConnectReason.SOFT_AP_HOTSPOT_OPEN_TIMEOUT;
            r101.f572651l = SystemClock.elapsedRealtime();
            this.f572636a.f572633c.c(5, DoraWifiEventReason.MSG_REQUEST_SOFT_AP_TIMEOUT);
            return;
        }

        public a(f r100, Looper r101) {
            this.f572636a = r100;
            super(r101);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f572637a = null;

        static {
            f572637a = new f();
        }
    }

    @Override // vk4.g
    public final String c() {
        return "success";
    }

    static {
        f572630f = new k();
    }

    public f() {
        al4.a r100 = al4.a.C0080a.f4130a;
        this.f572631a = r100;
        this.f572635e = new a(this, dl4.a.f469113a.getLooper());
        l r101 = new l(f572630f);
        this.f572633c = r101;
        r101.f572659c = new zk4.a(this);
        al4.b r102 = new zk4.b(this);
        ((CopyOnWriteArraySet) r100.f4128a).add(r102);
    }

    public static String d(f r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r101.length();
        if (r102 <= 1) goto L13;
        if (r101.charAt(0) != '\"') goto L13;
        int r103 = r102 - 1;
        if (r101.charAt(r103) != '\"') goto L13;
        r101 = r101.substring(1, r103);
    L13:
        return r101;
    }

    @Override // vk4.g
    public final void a(final String r100, final DoraWifiScene r101) {
        dl4.a.a(new e(this, r100, r101));
    }

    @Override // vk4.g
    public final void b(final String r100, final DoraWifiScene r101) {
        dl4.a.a(new c(this, r101, r100));
    }
}
