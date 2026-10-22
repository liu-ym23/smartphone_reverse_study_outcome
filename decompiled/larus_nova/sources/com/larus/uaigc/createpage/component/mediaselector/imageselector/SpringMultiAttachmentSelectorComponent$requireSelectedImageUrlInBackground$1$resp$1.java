package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/FileUrlRespData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends FileUrlRespData>>, Object> {
    final /* synthetic */ String $tosKey;
    int label;

    public SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1(String r100, Continuation<? super SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1> r101) {
        this.$tosKey = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1(this.$tosKey, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.larus.network.http.a<? extends FileUrlRespData>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.larus.network.http.a<FileUrlRespData>> r101) {
        return ((SpringMultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        String r103 = this.$tosKey;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        List r104 = CollectionsKt.listOf(r103);
        UploadDataType r105 = UploadDataType.IMAGE;
        this.label = 1;
        r100 = com.larus.uaigc.api.o.b(r104, r105, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
