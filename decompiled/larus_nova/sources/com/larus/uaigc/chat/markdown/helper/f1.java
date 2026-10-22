package com.larus.uaigc.chat.markdown.helper;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class f1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rd8.b f370931a;

    public /* synthetic */ f1(rd8.b r100) {
        this.f370931a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        rd8.b r101 = this.f370931a;
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r102, "vid");
        if (r101 == null) goto L9;
        kh8.a r103 = r101.q3();
        if (r103 == null) goto L9;
        Integer r104 = r103.a(r102);
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L11:
        return Integer.valueOf(r105);
    L9:
        r105 = 0;
        goto L11
    }
}
