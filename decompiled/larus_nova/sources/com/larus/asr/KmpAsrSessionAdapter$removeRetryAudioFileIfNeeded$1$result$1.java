package com.larus.asr;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpAsrSessionAdapter$removeRetryAudioFileIfNeeded$1$result$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public KmpAsrSessionAdapter$removeRetryAudioFileIfNeeded$1$result$1(Object r100) {
        super(1, r100, b68.b.class, "deleteFile", "deleteFile(Ljava/lang/String;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Boolean.valueOf(((b68.b) this.receiver).a(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return invoke2(r100);
    }
}
