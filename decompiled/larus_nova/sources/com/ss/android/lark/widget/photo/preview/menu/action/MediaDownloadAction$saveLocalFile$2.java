package com.ss.android.lark.widget.photo.preview.menu.action;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.menu.action.MediaDownloadAction$saveLocalFile$2", f = "MediaDownloadAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaDownloadAction$saveLocalFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaExtra $mediaExtra;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ MediaDownloadAction this$0;

    public MediaDownloadAction$saveLocalFile$2(MediaExtra r100, String r101, MediaDownloadAction r102, Continuation<? super MediaDownloadAction$saveLocalFile$2> r103) {
        this.$mediaExtra = r100;
        this.$path = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaDownloadAction$saveLocalFile$2(this.$mediaExtra, this.$path, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MediaDownloadAction$saveLocalFile$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        MediaStoreUtil.c(new PolarisFileWrapper(this.$mediaExtra.getFilePath()), Uri.fromFile(new PolarisFileWrapper(this.$path)), this.this$0.f446808a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
