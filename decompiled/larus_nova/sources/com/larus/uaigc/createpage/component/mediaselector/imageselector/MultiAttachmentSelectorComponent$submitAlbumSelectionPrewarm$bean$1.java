package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResourceItemBean>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ Uri $uri;
    int label;

    public MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(Uri r100, String r101, Continuation<? super MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1> r102) {
        this.$uri = r100;
        this.$identifier = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(this.$uri, this.$identifier, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ResourceItemBean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ResourceItemBean> r101) {
        return ((MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        ResourceItemBean r101 = com.larus.uaigc.helper.o0.c(this.$uri, this.$identifier);
        if (r101 == null) goto L13;
        if (r101.getResourceType() != ResourceType.VIDEO) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return r101;
    L9:
        r102 = false;
    L13:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
