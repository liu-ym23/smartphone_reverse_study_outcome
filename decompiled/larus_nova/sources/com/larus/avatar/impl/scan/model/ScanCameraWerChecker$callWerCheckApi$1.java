package com.larus.avatar.impl.scan.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.scan.model.ScanCameraWerChecker", f = "ScanCameraWerChecker.kt", i = {}, l = {96}, m = "callWerCheckApi", n = {}, s = {})
public final class ScanCameraWerChecker$callWerCheckApi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanCameraWerChecker this$0;

    public ScanCameraWerChecker$callWerCheckApi$1(ScanCameraWerChecker r100, Continuation<? super ScanCameraWerChecker$callWerCheckApi$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ScanCameraWerChecker r101 = this.this$0;
        int r102 = ScanCameraWerChecker.f291029a;
        return r101.a(null, this);
    }
}
