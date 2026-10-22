package f3;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C5852a f475262c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f475263d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f475264e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f475265f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f475266g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f475267h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f475268i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f475269j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f475270k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f475271l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f475272m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f475273n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f475274o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f475275p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f475276q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f475277r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f475278s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f475279t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f475280u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f475281v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f475282w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f475283x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f475284y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f475285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475286b;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    public static final class C5852a {
        public C5852a() {
        }
    }

    static {
        f475262c = new C5852a();
        f475263d = new a(0, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        f475264e = new a(100, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        f475265f = new a(102, "internal error");
        f475266g = new a(103, "feature not support");
        f475267h = new a(104, "invalid parameter");
        f475268i = new a(105, "authentication fail");
        f475269j = new a(106, "system permission denied");
        f475270k = new a(107, "user permission denied");
        f475271l = new a(110, "API call prohibited");
        f475272m = new a(112, "invalid result");
        f475273n = new a(113, "bridge unavailable");
        f475274o = new a(114, "operation cancelled");
        f475275p = new a(115, "operation timeout");
        f475276q = new a(116, "resource not found");
        new a(117, "not implemented");
        f475277r = new a(118, "already exists");
        f475278s = new a(120, "too many requests");
        new a(201, "no read permission");
        new a(202, "no write permission");
        f475279t = new a(203, "file does not exist");
        new a(204, "file already exists");
        f475280u = new a(208, "total size limit exceeded");
        f475281v = new a(213, "invalid file path");
        new a(301, "network request cancelled");
        f475282w = new a(302, "connection timed out");
        f475283x = new a(303, "no network connection");
        f475284y = new a(305, "network failure");
        new a(307, "network SDK parameter error");
    }

    public final String toString() {
        return "AIBridgeApiErr(errNo=" + this.f475285a + ", errMsg='" + this.f475286b + "')";
    }

    public final int hashCode() {
        return this.f475285a;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f475285a != ((a) r100).f475285a) goto L7;
        return true;
    }

    public a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.f475285a = r100;
        this.f475286b = r101;
    }
}
