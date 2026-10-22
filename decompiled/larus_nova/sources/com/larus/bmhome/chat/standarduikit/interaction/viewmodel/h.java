package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f309361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f309362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f309363c;

    public /* synthetic */ h(j r100, String r101, k r102) {
        this.f309361a = r100;
        this.f309362b = r101;
        this.f309363c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        j r101 = this.f309361a;
        String r102 = this.f309362b;
        Function1 r103 = this.f309363c;
        com.larus.bmhome.taskskill.service.k r104 = (com.larus.bmhome.taskskill.service.k) r100;
        Intrinsics.checkNotNullParameter(r104, "event");
        if ((r104 instanceof com.larus.bmhome.taskskill.service.k.h) == false) goto L5;
        r101.f309370e = null;
        r101.c(r102, false);
    L5:
        r103.invoke(r104);
        return Unit.INSTANCE;
    }
}
