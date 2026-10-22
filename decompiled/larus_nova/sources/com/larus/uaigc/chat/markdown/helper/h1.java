package com.larus.uaigc.chat.markdown.helper;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class h1 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rd8.b f370937a;

    public /* synthetic */ h1(rd8.b r100) {
        this.f370937a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        rd8.b r102 = this.f370937a;
        String r103 = (String) r100;
        boolean r104 = ((Boolean) r101).booleanValue();
        if (r102 == null) goto L8;
        kh8.a r105 = r102.q3();
        if (r105 == null) goto L8;
        r105.j(r103, r104);
    L8:
        return Unit.INSTANCE;
    }
}
