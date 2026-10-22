package com.larus.office.card.doc;

import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.office.card.doc.content.OfficeCardDocContentServiceDelegate;
import com.larus.platform.api.IFlowOfficeWikiTokenResolver;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.doc.DocumentCard$bindListener$1$1$result$1", f = "DocumentCard.kt", i = {}, l = {481, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_RANGE_SIZE}, m = "invokeSuspend", n = {}, s = {})
public final class DocumentCard$bindListener$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ ArtifactBlock $data;
    int label;

    public DocumentCard$bindListener$1$1$result$1(ArtifactBlock r100, Continuation<? super DocumentCard$bindListener$1$1$result$1> r101) {
        this.$data = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocumentCard$bindListener$1$1$result$1(this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((DocumentCard$bindListener$1$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L30:
        return (String) r100;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L23:
        String r103 = (String) r100;
    L25:
        if (r103 == null) goto L31;
        int r104 = com.larus.office.card.doc.content.b.f361370a;
        this.label = 2;
        r100 = OfficeCardDocContentServiceDelegate.f361365b.b(r103, -1, this);
        if (r100 != r101) goto L30;
        return r101;
    L31:
        return null;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = this.$data.getResourceId();
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        Integer r105 = this.$data.getResourceType();
        if (r105 == null) goto L25;
        if (r105.intValue() != 14) goto L25;
        IFlowOfficeWikiTokenResolver r106 = (IFlowOfficeWikiTokenResolver) ServiceManager.get().getService(IFlowOfficeWikiTokenResolver.class);
        if (r106 == null) goto L24;
        this.label = 1;
        r100 = r106.a(r103, this);
        if (r100 != r101) goto L23;
        return r101;
    L24:
        r103 = null;
        goto L25
    }
}
