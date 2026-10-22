package com.larus.larkfeed.impl.gallery;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.VideoData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1", f = "Message2GalleryItemExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ CreationItem $creationItem;
    int label;

    public Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1(CreationItem r100, Continuation<? super Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1> r101) {
        this.$creationItem = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1(this.$creationItem, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super String> r100) {
        return ((Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        VideoData r101 = this.$creationItem.video;
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.downloadUrl;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
