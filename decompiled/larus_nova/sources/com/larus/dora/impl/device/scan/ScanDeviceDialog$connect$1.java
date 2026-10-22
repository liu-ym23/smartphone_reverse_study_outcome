package com.larus.dora.impl.device.scan;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog", f = "ScanDeviceDialog.kt", i = {0}, l = {185, 188}, m = "connect", n = {"device"}, s = {"L$0"})
final class ScanDeviceDialog$connect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanDeviceDialog this$0;

    public ScanDeviceDialog$connect$1(ScanDeviceDialog r100, Continuation<? super ScanDeviceDialog$connect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ScanDeviceDialog.S90(this.this$0, null, this);
    }
}
