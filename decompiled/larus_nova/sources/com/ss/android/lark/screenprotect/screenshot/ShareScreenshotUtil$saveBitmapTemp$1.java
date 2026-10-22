package com.ss.android.lark.screenprotect.screenshot;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.screenprotect.screenshot.ShareScreenshotUtil", f = "ShareScreenshotUtil.kt", i = {}, l = {79}, m = "saveBitmapTemp", n = {}, s = {})
final class ShareScreenshotUtil$saveBitmapTemp$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareScreenshotUtil this$0;

    public ShareScreenshotUtil$saveBitmapTemp$1(ShareScreenshotUtil r100, Continuation<? super ShareScreenshotUtil$saveBitmapTemp$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ShareScreenshotUtil.b(this.this$0, null, this);
    }
}
