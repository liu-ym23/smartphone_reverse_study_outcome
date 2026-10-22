package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1() {
        super(1, StringsKt.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return StringsKt.trim(r100).toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
