package com.ss.android.lark.coremd.base.parse;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final <T extends com.ss.android.lark.coremd.ext.f> b a(com.ss.android.lark.coremd.ext.h<T> r100, Function2<? super T, ? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.ss.android.lark.coremd.impl.parse.a r102 = new com.ss.android.lark.coremd.impl.parse.a();
        com.ss.android.lark.coremd.ext.g.a(r102, r100, r101);
        return r102;
    }
}
