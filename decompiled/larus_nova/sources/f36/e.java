package f36;

import bolts.Task;
import com.bytedance.apm.util.i;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements et3.c.d, et3.c.InterfaceC5817c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f475402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f475403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f475404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a36.a f475405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Scenes f475406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f475407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f475408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f475409h;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f475402a = -1;
        this.f475403b = -1.0d;
    }

    @Override // et3.c.InterfaceC5817c
    public final void dropFrame(JSONObject r100) {
        this.f475404c = r100;
        JSONObject r101 = this.f475408g;
        if (r101 == null) goto L5;
        Object r102 = r101.opt("stage");
    L6:
        JSONObject r103 = this.f475409h;
        if (r103 == null) goto L9;
        Object r104 = r103.opt("stage");
    L10:
        if (r102 == null) goto L22;
        if (r104 == null) goto L22;
        if (Intrinsics.areEqual(r102, r104) == false) goto L22;
        if (this.f475402a < 0) goto L22;
        double r105 = this.f475403b;
        boolean r106 = false;
        if (r105 < 0) goto L22;
        if (r105 > i.f190670b) goto L22;
        if (this.f475404c == null) goto L22;
    L23:
        if (r106 == false) goto L25;
        BulletLogger.k("FluencyMonitor-mergeAndReport,stage is wrong and didn't report", null, null, 6);
        this.f475402a = -1;
        this.f475403b = -1.0d;
        this.f475404c = null;
        this.f475408g = null;
        this.f475409h = null;
        return;
    L25:
        Task.callInBackground(new f(this));
        return;
    L22:
        r106 = true;
        goto L23
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // et3.c.d
    public final void fpsCallBack(double r100) {
        this.f475403b = r100;
    }
}
