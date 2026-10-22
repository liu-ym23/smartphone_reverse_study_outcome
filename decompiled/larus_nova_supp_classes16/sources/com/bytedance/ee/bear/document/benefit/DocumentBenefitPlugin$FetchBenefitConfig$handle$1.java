package com.bytedance.ee.bear.document.benefit;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tb5.m;
import tt5.a;
import w05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.benefit.DocumentBenefitPlugin$FetchBenefitConfig$handle$1", f = "DocumentBenefitPlugin.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
final class DocumentBenefitPlugin$FetchBenefitConfig$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ String $objToken;
    final /* synthetic */ int $objType;
    final /* synthetic */ String $ownerId;
    int label;
    final /* synthetic */ DocumentBenefitPlugin this$0;

    public DocumentBenefitPlugin$FetchBenefitConfig$handle$1(String r1, int r2, String r3, DocumentBenefitPlugin r4, m r5, Continuation<? super DocumentBenefitPlugin$FetchBenefitConfig$handle$1> r6) {
        this.$objToken = r1;
        this.$objType = r2;
        this.$ownerId = r3;
        this.this$0 = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DocumentBenefitPlugin$FetchBenefitConfig$handle$1(this.$objToken, this.$objType, this.$ownerId, this.this$0, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        BenefitStore r11 = (BenefitStore) r10;
        a.h(DocumentBenefitPlugin.access$getTAG$cp(), "asyncGetResourceBenefits success, size is " + r11.getBenefitMap().size());
        DocViewModel r2 = DocumentBenefitPlugin.access$getDocViewModel(this.this$0);
        if (r2 == null) goto L18;
        i r3 = r2.getDocumentInfoProvider();
        if (r3 == null) goto L18;
        MutableLiveData<BenefitStore> r4 = r3.f();
        if (r4 == null) goto L18;
        r4.setValue(r11);
    L18:
        this.$callback.onCallBack(r11.getSourceBenefit());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        BenefitManagerAPI r5 = (BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6);
        String r6 = this.$objToken;
        int r7 = this.$objType;
        String r8 = this.$ownerId;
        this.label = 1;
        r10 = r5.d8(r6, r7, r8, BenefitManagerAPI.CacheType.OWNER_ID, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
