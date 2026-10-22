package com.larus.bmhome.chat.component.bottom.multimodal;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel$handleUploadResultCode$2$1", f = "MultimodalInputComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultimodalInputComponentViewModel$handleUploadResultCode$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j1 $this_run;
    int label;

    public MultimodalInputComponentViewModel$handleUploadResultCode$2$1(j1 r100, Continuation<? super MultimodalInputComponentViewModel$handleUploadResultCode$2$1> r101) {
        this.$this_run = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MultimodalInputComponentViewModel$handleUploadResultCode$2$1(this.$this_run, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MultimodalInputComponentViewModel$handleUploadResultCode$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (this.$this_run.f299799c == false) goto L7;
        t19.s r101 = t19.s.f544207a;
        Application r102 = AppHost.f326268a.getApplication();
        r101.getClass();
        t19.s.s(r102, R.string.larus_image_oversize);
    L9:
        return Unit.INSTANCE;
    L7:
        t19.s r103 = t19.s.f544207a;
        Application r104 = AppHost.f326268a.getApplication();
        r103.getClass();
        t19.s.s(r104, R.string.larus_file_size_exceeds_limit);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
