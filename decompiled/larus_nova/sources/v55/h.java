package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f553261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f553262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DriveThirdPartyPermissionVM f553263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f553264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f553265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f553266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f553267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f553268k;

    public final void a() {
        com.bytedance.ee.space.sync.b r100 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        e r101 = this.f553264g;
        if (r101 == null) goto L5;
        r100.Lc(r101);
        this.f553264g = null;
    L5:
        d r102 = this.f553265h;
        if (r102 == null) goto L8;
        r100.n8(r102);
        this.f553265h = null;
    L8:
        g r103 = this.f553266i;
        if (r103 == null) goto L11;
        r100.Lc(r103);
        this.f553266i = null;
    L11:
        f r104 = this.f553267j;
        if (r104 == null) goto L14;
        r100.n8(r104);
        this.f553267j = null;
    L14:
        this.f553268k = true;
    }

    public final void b() {
        if (this.f553268k == false) goto L5;
        return;
    L5:
        this.f553263f.fetchPermission(this.f553258a, this.f553259b, this.f553260c);
    }

    public h(String r100, String r101, String r102, String r103, int r104, DriveThirdPartyPermissionVM r105) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        Intrinsics.checkNotNullParameter(r105, "permissionVM");
        this.f553258a = r100;
        this.f553259b = r101;
        this.f553260c = r102;
        this.f553261d = r103;
        this.f553262e = r104;
        this.f553263f = r105;
    }
}
