package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v extends c0c.b implements w {
    public final /* synthetic */ w b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<w> d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void E8() {
        Intrinsics.checkNotNullParameter("DriveDatabaseManager-Migration78", "logKey");
        this.b.E8();
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void F8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileId");
        this.b.F8(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r3) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileId");
        this.b.J6(r3);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
        this.b.Z3();
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r3) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r3, "fileIds");
        this.b.i6(r3);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void j0(List<? extends LocalSaveEntity> r2) {
        this.b.j0(r2);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void onDestroy() {
        this.b.onDestroy();
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("DriveCacheServiceProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
        ((w) this.d.c()).onDestroy();
    }

    public v(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<w> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), w.class), w.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (w) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        tt5.a.h("DriveCacheServiceProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        w r6 = (w) e0c.k.b(r4.c(r5), w.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
