package com.bytedance.ee.bear.drive.loader.impl;

import b85.d0;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.RustDownload;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SpaceFileLoader extends u75.a {
    public final DrivePluginHost c;
    public final BaseSpaceOpenEntity d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    @Override // u75.b
    public final void a() {
        if (this.c.c.getIFileModel() == null) goto L5;
        ((d0) this.e.getValue()).d(this.c.c.getIFileModel());
        return;
    L5:
        tt5.a.d("DriveComponent", "loadDirectly() error iFileModel null");
    }

    @Override // u75.b
    public final void onDetach() {
        this.b.a(InfoCode.OnDetach, null);
        tt5.a.h("SpaceFileLoader", "onDetach()");
        d0 r0 = (d0) this.e.getValue();
        r0.b.clear();
        RustDownload.shutdown(r0.f);
    }

    @Override // u75.a, u75.b
    public final void load() {
        super.load();
        ((d0) this.e.getValue()).c();
    }

    public SpaceFileLoader(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super(r2);
        this.c = r2;
        BaseOpenEntity r3 = r2.c.getOpenEntity();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
        this.d = (BaseSpaceOpenEntity) r3;
        this.e = LazyKt.lazy(new SpaceFileLoader$mPreviewExecutor$2(this));
    }

    public final void h(ErrCode r2) {
        Intrinsics.checkNotNullParameter(r2, "code");
        this.b.c(r2);
        d0 r3 = (d0) this.e.getValue();
        r3.b.clear();
        RustDownload.shutdown(r3.f);
    }
}
