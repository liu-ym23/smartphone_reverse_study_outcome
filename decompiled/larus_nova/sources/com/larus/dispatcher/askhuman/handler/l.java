package com.larus.dispatcher.askhuman.handler;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class l implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f330899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f330900b;

    public /* synthetic */ l(String r100, int r101) {
        this.f330899a = r100;
        this.f330900b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f330899a;
        int r102 = this.f330900b;
        Map r103 = (Map) r100;
        Intrinsics.checkNotNullParameter(r103, "it");
        Pair[] r104 = new Pair[1];
        StringBuilder r105 = new StringBuilder();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r105.append(r101);
        r105.append('-');
        r105.append(r102);
        r104[0] = TuplesKt.to("quick_reply_click_index_info", r105.toString());
        return com.larus.utils.h.c(r103, r104);
    }
}
