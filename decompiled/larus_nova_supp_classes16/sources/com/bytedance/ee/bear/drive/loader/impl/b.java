package com.bytedance.ee.bear.drive.loader.impl;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends u75.a {
    public final DrivePluginHost c;
    public final LocalOpenEntity d;
    public final CompositeDisposable e;

    public static final class a {
    }

    static {
    }

    @Override // u75.b
    public final void a() {
        tt5.a.k("DriveComponent", "loadDirectly() not support for localFileLoader");
        this.b.c(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW);
    }

    @Override // u75.b
    public final void onDetach() {
        this.b.a(InfoCode.OnDetach, null);
        tt5.a.h("LocalFileLoader", "onDetach()");
        this.e.clear();
    }

    @Override // u75.a, u75.b
    public final void load() {
        super.load();
        if (this.d != null) goto L5;
    L9:
        tt5.a.d("LocalFileLoader", "load() mOpenEntity=" + this.d);
        this.b.c(ErrCode.FILE_NOT_FOUND);
        return;
    L5:
        if (ay4.d.a().i(this.d.getLocalFilePath()).exists() == false) goto L9;
        LocalOpenEntity r0 = this.d;
        tt5.a.h("LocalFileLoader", "exe1 start.");
        this.e.add(Flowable.just("").map(new c(this, r0)).flatMap(e.a).observeOn(fo5.d.d()).subscribe(new f(this, r0), g.a));
    }

    public b(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super(r2);
        this.c = r2;
        BaseOpenEntity r3 = r2.c.getOpenEntity();
        if ((r3 instanceof LocalOpenEntity) == false) goto L5;
        LocalOpenEntity r4 = (LocalOpenEntity) r3;
    L6:
        this.d = r4;
        this.e = new CompositeDisposable();
        return;
    L5:
        r4 = null;
        goto L6
    }
}
