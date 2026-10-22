package com.larus.im.internal.legacy;

import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.callback.NativeIMCallback;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {
    public static final <ReceiveFromCpp, DispatchToJava> NativeIMCallback<ReceiveFromCpp, DispatchToJava> a(IIMCallback<DispatchToJava> r100, String r101, String r102, Function1<? super ReceiveFromCpp, ? extends DispatchToJava> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "reqLog");
        Intrinsics.checkNotNullParameter(r103, "converter");
        return new NativeIMCallback(r101, r102, r100, r103);
    }
}
