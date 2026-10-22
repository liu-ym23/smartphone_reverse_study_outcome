package com.bytedance.ies.ezpermission.core.result;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000e\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Intent;", "intent", "Lkotlin/Function0;", "", "block", "", "key", "Lkotlin/Function2;", "", "transform", "Lkotlin/coroutines/Continuation;", "continuation", "", "startActivityForResultInner"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezpermission.core.result.ResultWrapper", f = "ResultWrapper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {58, 59, 60}, m = "startActivityForResultInner", n = {"this", "intent", "block", "key", "transform", "this", "intent", "block", "key", "transform"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ResultWrapper$startActivityForResultInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResultWrapper this$0;

    public ResultWrapper$startActivityForResultInner$1(ResultWrapper r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, this);
    }
}
