package com.larus.uaigc.nowatermark;

import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.CreationNoWatermarkApi;
import com.larus.uaigc.api.i;
import com.larus.uaigc.api.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/GetResourceWithoutWatermarkData;", "Lcom/larus/uaigc/api/CreationNoWatermarkApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$fetchResources$result$1", f = "CreationNoWatermarkManager.kt", i = {}, l = {1418}, m = "invokeSuspend", n = {}, s = {})
public final class CreationNoWatermarkManager$fetchResources$result$1 extends SuspendLambda implements Function2<CreationNoWatermarkApi, Continuation<? super BizResponse<i>>, Object> {
    final /* synthetic */ List<String> $uris;
    final /* synthetic */ List<String> $vids;
    private /* synthetic */ Object L$0;
    int label;

    public CreationNoWatermarkManager$fetchResources$result$1(List<String> r100, List<String> r101, Continuation<? super CreationNoWatermarkManager$fetchResources$result$1> r102) {
        this.$uris = r100;
        this.$vids = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CreationNoWatermarkManager$fetchResources$result$1 r102 = new CreationNoWatermarkManager$fetchResources$result$1(this.$uris, this.$vids, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CreationNoWatermarkApi r100, Continuation<? super BizResponse<i>> r101) {
        return ((CreationNoWatermarkManager$fetchResources$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CreationNoWatermarkApi r100, Continuation<? super BizResponse<i>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L18:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CreationNoWatermarkApi r103 = (CreationNoWatermarkApi) this.L$0;
        List<String> r104 = this.$uris;
        List<String> r105 = null;
        if ((!r104.isEmpty()) == true) goto L12;
        r104 = null;
    L12:
        List<String> r106 = this.$vids;
        if ((!r106.isEmpty()) == false) goto L15;
        r105 = r106;
    L15:
        j r107 = new j(r104, r105);
        this.label = 1;
        r100 = r103.getResourceWithoutWatermark(r107, this);
        if (r100 != r101) goto L18;
        return r101;
    }
}
