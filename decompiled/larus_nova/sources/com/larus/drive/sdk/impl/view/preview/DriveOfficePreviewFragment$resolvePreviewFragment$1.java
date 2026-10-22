package com.larus.drive.sdk.impl.view.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.DriveOfficePreviewFragment", f = "DriveOfficePreviewFragment.kt", i = {0, 0}, l = {184}, m = "resolvePreviewFragment", n = {"request", "officeSdkService"}, s = {"L$0", "L$1"})
final class DriveOfficePreviewFragment$resolvePreviewFragment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveOfficePreviewFragment this$0;

    public DriveOfficePreviewFragment$resolvePreviewFragment$1(DriveOfficePreviewFragment r100, Continuation<? super DriveOfficePreviewFragment$resolvePreviewFragment$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DriveOfficePreviewFragment.S90(this.this$0, null, this);
    }
}
