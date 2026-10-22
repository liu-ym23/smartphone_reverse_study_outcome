package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final String a;
    public final DriveMGPermissionVM b;
    public a c;
    public b d;
    public boolean e;

    public final void a() {
        a r0 = this.c;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r0);
    L5:
        b r1 = this.d;
        if (r1 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n8(r1);
        this.d = null;
    L8:
        this.e = true;
    }

    public c(String r2, DriveMGPermissionVM r3) {
        Intrinsics.checkNotNullParameter(r2, "fileId");
        Intrinsics.checkNotNullParameter(r3, "permissionVM");
        this.a = r2;
        this.b = r3;
    }
}
