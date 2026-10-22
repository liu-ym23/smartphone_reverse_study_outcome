package com.ss.android.lark.todo.impl.features.common.urlpreview;

import com.bytedance.lark.pb.basic.v1.PreviewEntityPair;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.features.common.urlpreview.UrlPreviewLoader", f = "UrlPreviewLoader.kt", i = {}, l = {51}, m = "loadUrlPreview", n = {}, s = {})
final class UrlPreviewLoader$loadUrlPreview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public UrlPreviewLoader$loadUrlPreview$1(a r100, Continuation<? super UrlPreviewLoader$loadUrlPreview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        UrlPreviewLoader$loadUrlPreview$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
    L18:
        return null;
    L9:
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r104);
        PreviewEntityPair r106 = (PreviewEntityPair) r104;
        if (r106 == null) goto L18;
        Map<String, UrlPreviewEntity> r107 = r106.preview_entity;
        if (r107 == null) goto L20;
        a.f442485a.putAll(r107);
        return r106;
    L20:
        return r106;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new UrlPreviewLoader$loadUrlPreview$1(r101, this);
        goto L6
    }
}
