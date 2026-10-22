package com.larus.disk.impl;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3 extends FunctionReferenceImpl implements Function1<String, File> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3() {
        super(1, File.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ File invoke(String r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final File invoke2(String r100) {
        return new PolarisFileWrapper(r100);
    }
}
