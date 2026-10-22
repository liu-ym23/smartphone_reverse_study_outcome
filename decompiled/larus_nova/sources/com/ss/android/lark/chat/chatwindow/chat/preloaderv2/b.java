package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends c0c.b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f413490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f413491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<d> f413492d;

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d
    public final <S> Object B6(w3b.d<S> r100, Continuation<? super Result<? extends S>> r101) {
        Object r102 = this.f413490b.B6(r100, r101);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r102;
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), d.class), d.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f413490b = r103.b();
        this.f413491c = r101;
        this.f413492d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("DataPreloaderV2", "preparing IChatLauncherV2");
        v r102 = this.f413491c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        d r104 = (d) k.b(r102.c(r103), d.class);
        this.f413492d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
