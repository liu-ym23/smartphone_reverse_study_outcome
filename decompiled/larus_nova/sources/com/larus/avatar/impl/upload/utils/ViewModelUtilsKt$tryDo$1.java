package com.larus.avatar.impl.upload.utils;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.utils.ViewModelUtilsKt", f = "ViewModelUtils.kt", i = {0, 0, 0}, l = {37}, m = "tryDo", n = {"block", "$this$tryDo", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0", "I$1"})
public final class ViewModelUtilsKt$tryDo$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ViewModelUtilsKt$tryDo$1(Continuation<? super ViewModelUtilsKt$tryDo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ViewModelUtilsKt.c(0, null, this);
    }
}
