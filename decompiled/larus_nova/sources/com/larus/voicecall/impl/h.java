package com.larus.voicecall.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h {
    public h() {
    }

    public final void a(String r100, ouc.d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r102.reportEvent(r100, com.larus.voicecall.impl.util.d.d(r101));
    }
}
