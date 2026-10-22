package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel", f = "OfficeCustomStickerModel.kt", i = {0, 0}, l = {114}, m = "uploadStickers-0E7RQCE", n = {"stickerPaths", "keepOrigin"}, s = {"L$0", "Z$0"})
public final class OfficeCustomStickerModel$uploadStickers$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeCustomStickerModel this$0;

    public OfficeCustomStickerModel$uploadStickers$1(OfficeCustomStickerModel r100, Continuation<? super OfficeCustomStickerModel$uploadStickers$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, false, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
