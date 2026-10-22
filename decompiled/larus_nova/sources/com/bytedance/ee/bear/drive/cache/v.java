package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class v extends c0c.b implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f224068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f224069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<w> f224070d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void E8() {
        Intrinsics.checkNotNullParameter("DriveDatabaseManager-Migration78", "logKey");
        this.f224068b.E8();
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void F8(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "logKey");
        Intrinsics.checkNotNullParameter(r101, "fileId");
        this.f224068b.F8(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void J6(String r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-put", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileId");
        this.f224068b.J6(r100);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void Z3() {
        Intrinsics.checkNotNullParameter("DriveDataService-cleanTempFileWhenInit", "logKey");
        this.f224068b.Z3();
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void i6(List r100) {
        Intrinsics.checkNotNullParameter("DriveDataService-removeAll", "logKey");
        Intrinsics.checkNotNullParameter(r100, "fileIds");
        this.f224068b.i6(r100);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void j0(List<? extends LocalSaveEntity> r100) {
        this.f224068b.j0(r100);
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void onDestroy() {
        this.f224068b.onDestroy();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("DriveCacheServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f224070d.c().onDestroy();
    }

    public v(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<w> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), w.class), w.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f224068b = r103.b();
        this.f224069c = r101;
        this.f224070d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("DriveCacheServiceProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r102 = this.f224069c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        w r104 = (w) e0c.k.b(r102.c(r103), w.class);
        this.f224070d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
