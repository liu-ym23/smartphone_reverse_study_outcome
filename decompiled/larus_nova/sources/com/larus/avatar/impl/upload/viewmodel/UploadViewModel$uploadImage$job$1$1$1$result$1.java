package com.larus.avatar.impl.upload.viewmodel;

import android.util.Base64;
import com.larus.network.bean.BizResponse;
import com.larus.uaigc.avatar.api.DigitalAvatarApi;
import com.ss.android.lark.image.entity.LoadParams;
import ey9.j;
import ey9.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "Lcom/larus/uaigc/avatar/api/DigitalAvatarApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.viewmodel.UploadViewModel$uploadImage$job$1$1$1$result$1", f = "UploadViewModel.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class UploadViewModel$uploadImage$job$1$1$1$result$1 extends SuspendLambda implements Function2<DigitalAvatarApi, Continuation<? super BizResponse<k>>, Object> {
    final /* synthetic */ byte[] $imageByteArray;
    private /* synthetic */ Object L$0;
    int label;

    public UploadViewModel$uploadImage$job$1$1$1$result$1(byte[] r100, Continuation<? super UploadViewModel$uploadImage$job$1$1$1$result$1> r101) {
        this.$imageByteArray = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        UploadViewModel$uploadImage$job$1$1$1$result$1 r102 = new UploadViewModel$uploadImage$job$1$1$1$result$1(this.$imageByteArray, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DigitalAvatarApi r100, Continuation<? super BizResponse<k>> r101) {
        return ((UploadViewModel$uploadImage$job$1$1$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(DigitalAvatarApi r100, Continuation<? super BizResponse<k>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DigitalAvatarApi r103 = (DigitalAvatarApi) this.L$0;
        j r104 = new j(Base64.encodeToString(this.$imageByteArray, 0), new ey9.e(LoadParams.ImageFormat.JPEG));
        this.label = 1;
        r100 = r103.preGenDigitalAvatar(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
