package com.ss.android.lark.coremd.ext;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i {
    public static final <T extends f, R> R a(Class<T> r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "action");
        return r101.invoke((Object) k.a(r100));
    }
}
