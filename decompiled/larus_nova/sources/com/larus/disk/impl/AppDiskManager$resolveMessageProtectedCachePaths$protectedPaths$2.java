package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2() {
        super(1, StringsKt.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return invoke2(r100);
    }
}
