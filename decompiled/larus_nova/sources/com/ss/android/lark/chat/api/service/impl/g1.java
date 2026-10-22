package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g1 extends c0c.b implements a2b.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2b.h f411592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a2b.h> f411594d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.h
    public final Object S0(List<String> r100, PrivateDescriptionSource r101, Strategy r102, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r103) {
        Object r104 = this.f411592b.S0(r100, r101, r102, r103);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r104;
    }

    public g1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.h> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), a2b.h.class), a2b.h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411592b = r103.b();
        this.f411593c = r101;
        this.f411594d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("PrivateDescriptionServiceProxy", "preparing IPrivateDescriptionService");
        com.ss.android.lark.passportc.internal.v r102 = this.f411593c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a2b.h r104 = (a2b.h) e0c.k.b(r102.c(r103), a2b.h.class);
        this.f411594d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
