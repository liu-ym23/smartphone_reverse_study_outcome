package com.ss.android.lark.chat.api.service.impl.smartreply;

import a2b.j;
import c0c.b;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends b implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f411655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f411656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<j> f411657d;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.smartreply.a$a, reason: collision with other inner class name */
    public static final class C4789a {
    }

    static {
    }

    @Override // a2b.j
    public final MessageInfo u3(MessageInfo r100, Function0<? extends j.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        Intrinsics.checkNotNullParameter(r101, "getSmartApplyAnswerDependencyLoader");
        return this.f411655b.u3(r100, r101);
    }

    public a(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<j> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), j.class), j.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411655b = r103.b();
        this.f411656c = r101;
        this.f411657d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("SmartApplyAnswerCacheServiceProxy", "preparing ISmartApplyAnswerCacheServiceRepository");
        v r102 = this.f411656c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        j r104 = (j) k.b(r102.c(r103), j.class);
        this.f411657d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
