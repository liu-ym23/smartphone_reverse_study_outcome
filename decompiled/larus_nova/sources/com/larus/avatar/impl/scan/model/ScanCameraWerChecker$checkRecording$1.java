package com.larus.avatar.impl.scan.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.scan.model.ScanCameraWerChecker", f = "ScanCameraWerChecker.kt", i = {}, l = {36, 43}, m = "checkRecording", n = {}, s = {})
public final class ScanCameraWerChecker$checkRecording$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanCameraWerChecker this$0;

    public ScanCameraWerChecker$checkRecording$1(ScanCameraWerChecker r100, Continuation<? super ScanCameraWerChecker$checkRecording$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
