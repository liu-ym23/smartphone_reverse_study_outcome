package com.larus.uaigc.createpage.component.stylelist;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendResponse;", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1", f = "ImageStyleListComponent.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
public final class ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1 extends SuspendLambda implements Function2<ImageStyleRecommendApi, Continuation<? super BizResponse<ImageStyleRecommendApi.ImageStyleRecommendResponse>>, Object> {
    final /* synthetic */ String $languageCode;
    private /* synthetic */ Object L$0;
    int label;

    public ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1(String r100, Continuation<? super ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1> r101) {
        this.$languageCode = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1 r102 = new ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1(this.$languageCode, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ImageStyleRecommendApi r100, Continuation<? super BizResponse<ImageStyleRecommendApi.ImageStyleRecommendResponse>> r101) {
        return ((ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ImageStyleRecommendApi r100, Continuation<? super BizResponse<ImageStyleRecommendApi.ImageStyleRecommendResponse>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ImageStyleRecommendApi r103 = (ImageStyleRecommendApi) this.L$0;
        ImageStyleRecommendApi.f372472a.getClass();
        boolean r104 = false;
        if (ImageStyleRecommendApi.a.f372476b == false) goto L11;
        ImageStyleRecommendApi.a.f372476b = false;
        r104 = true;
    L11:
        ImageStyleRecommendApi.b r105 = new ImageStyleRecommendApi.b(Boxing.boxBoolean(r104), Boxing.boxInt(1), this.$languageCode);
        this.label = 1;
        r100 = r103.imageStyleRecommend(r105, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
