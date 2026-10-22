package com.ss.android.lark.todo.impl.features.common.urlpreview;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.features.common.urlpreview.UrlPreviewLoader", f = "UrlPreviewLoader.kt", i = {0}, l = {71}, m = "getPreviewEntityPair", n = {"id"}, s = {"L$0"})
final class UrlPreviewLoader$getPreviewEntityPair$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public UrlPreviewLoader$getPreviewEntityPair$1(a r100, Continuation<? super UrlPreviewLoader$getPreviewEntityPair$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        HashMap<String, UrlPreviewEntity> r102 = a.f442485a;
        return r101.b(null, this);
    }
}
