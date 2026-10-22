package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final DriveThirdPartyPermissionVM f;
    public e g;
    public d h;
    public g i;
    public f j;
    public boolean k;

    public final void a() {
        com.bytedance.ee.space.sync.b r0 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        e r2 = this.g;
        if (r2 == null) goto L5;
        r0.Lc(r2);
        this.g = null;
    L5:
        d r3 = this.h;
        if (r3 == null) goto L8;
        r0.n8(r3);
        this.h = null;
    L8:
        g r4 = this.i;
        if (r4 == null) goto L11;
        r0.Lc(r4);
        this.i = null;
    L11:
        f r5 = this.j;
        if (r5 == null) goto L14;
        r0.n8(r5);
        this.j = null;
    L14:
        this.k = true;
    }

    public final void b() {
        if (this.k == false) goto L5;
        return;
    L5:
        this.f.fetchPermission(this.a, this.b, this.c);
    }

    public h(String r2, String r3, String r4, String r5, int r6, DriveThirdPartyPermissionVM r7) {
        Intrinsics.checkNotNullParameter(r2, "fileId");
        Intrinsics.checkNotNullParameter(r7, "permissionVM");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
