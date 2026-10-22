package com.larus.bmhome.chat.layout.item;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class w1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f304683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f304684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f304685c;

    public /* synthetic */ w1(z1 r100, double r101, double r102) {
        this.f304683a = r100;
        this.f304684b = r101;
        this.f304685c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        z1 r101 = this.f304683a;
        double r102 = this.f304684b;
        double r103 = this.f304685c;
        List<wq9.a> r104 = (List) r100;
        if (r104 == null) goto L7;
        com.larus.bmhome.chat.map.o r105 = r101.f304732y;
        if (r105 == null) goto L11;
        r105.b(r104);
    L11:
        return Unit.INSTANCE;
    L7:
        com.larus.bmhome.chat.map.o r106 = r101.f304732y;
        if (r106 == null) goto L11;
        r106.c(new wq9.a(r102, r103), new wq9.a(r101.f304733z, r101.A));
        goto L11
    }
}
