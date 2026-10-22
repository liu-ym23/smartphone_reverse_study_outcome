package com.larus.disk.impl.handler;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ManagedCacheDirectoryHandler$4 extends FunctionReferenceImpl implements Function1<File, Long> {
    public ManagedCacheDirectoryHandler$4(Object r100) {
        super(1, r100, com.larus.disk.impl.i0.class, "lastObservedAccessTimeMs", "lastObservedAccessTimeMs(Ljava/io/File;)Ljava/lang/Long;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(File r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((com.larus.disk.impl.i0) this.receiver).getClass();
        return com.larus.disk.impl.i0.c(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(File r100) {
        return invoke2(r100);
    }
}
