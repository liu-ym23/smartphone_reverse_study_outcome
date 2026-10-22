package com.larus.drive.sdk.impl;

import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveLocalFilePreviewDelegate$prepare$2", f = "DriveLocalFilePreviewDelegate.kt", i = {0, 0}, l = {35}, m = "invokeSuspend", n = {"$this$withContext", "office"}, s = {"L$0", "L$1"})
public final class DriveLocalFilePreviewDelegate$prepare$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public DriveLocalFilePreviewDelegate$prepare$2(Continuation<? super DriveLocalFilePreviewDelegate$prepare$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DriveLocalFilePreviewDelegate$prepare$2 r102 = new DriveLocalFilePreviewDelegate$prepare$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((DriveLocalFilePreviewDelegate$prepare$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = false;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        IOfficeSdkServiceV2 r104 = (IOfficeSdkServiceV2) this.L$1;
        CoroutineScope r105 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        boolean r106 = ((Boolean) r100).booleanValue();
        CoroutineScopeKt.ensureActive(r105);
        if (r106 == false) goto L25;
        gk5.e r107 = r104.q0();
        if (r107 == null) goto L21;
        com.bytedance.ee.drive.preview.d r108 = r107.Y2();
    L22:
        if (r108 == null) goto L25;
        r103 = true;
        goto L25
    L21:
        r108 = null;
    L25:
        return Boxing.boxBoolean(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r105 = (CoroutineScope) this.L$0;
        IOfficeSdkServiceV2 r109 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r109 == null) goto L11;
        IOfficeSdkServiceV2.a.b(r109, true, "pc_local_file_preview", 4);
        this.L$0 = r105;
        this.L$1 = r109;
        this.label = 1;
        Object r110 = r109.n0(15000, this);
        if (r110 != r101) goto L15;
        return r101;
    L15:
        r104 = r109;
        r100 = r110;
        goto L16
    L11:
        return Boxing.boxBoolean(false);
    }
}
