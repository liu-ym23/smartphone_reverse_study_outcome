package com.ss.android.lark.chat.export.offlineCacheClean;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends c0c.b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f415417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f415418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a> f415419d;

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Ib(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f415417b.Ib(r100);
    }

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Wa(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f415417b.Wa(r100);
    }

    public e(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), a.class), a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "holder");
        super(r100);
        this.f415417b = r103.b();
        this.f415418c = r101;
        this.f415419d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f415418c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a r104 = (a) k.b(r102.c(r103), a.class);
        this.f415419d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
