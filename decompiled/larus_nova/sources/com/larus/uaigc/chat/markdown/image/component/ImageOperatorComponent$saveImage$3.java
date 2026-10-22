package com.larus.uaigc.chat.markdown.image.component;

import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent$saveImage$3", f = "ImageOperatorComponent.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class ImageOperatorComponent$saveImage$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreationFromIM $creationFromIM;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ String $messageId;
    int label;

    public ImageOperatorComponent$saveImage$3(UserCreationFromIM r100, String r101, String r102, Continuation<? super ImageOperatorComponent$saveImage$3> r103) {
        this.$creationFromIM = r100;
        this.$creationTaskId = r101;
        this.$messageId = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ImageOperatorComponent$saveImage$3(this.$creationFromIM, this.$creationTaskId, this.$messageId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((ImageOperatorComponent$saveImage$3) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L18;
        r103.w();
        k1 r104 = k1.f346194a;
        UserCreationFromIM r105 = this.$creationFromIM;
        if (r105 == null) goto L13;
        String r106 = r105.getCreationId();
    L14:
        String r107 = this.$creationTaskId;
        String r108 = this.$messageId;
        this.label = 1;
        if (r104.h1(r106, r107, r108, this) != r101) goto L18;
        return r101;
    L13:
        r106 = null;
        goto L14
    }
}
