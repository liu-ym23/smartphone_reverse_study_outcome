package com.bytedance.android.shopping.deepfeed.ui.vh;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "preTask", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductSlcVH$handleAdShow$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ DeepFeedProductSlcVH this$0;

    public DeepFeedProductSlcVH$handleAdShow$1(DeepFeedProductSlcVH r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(boolean r3) {
        if (r3 == false) goto L7;
        com.bytedance.android.shopping.deepfeed.data.repo.l r4 = this.this$0.i4().getResp();
        if (r4 == null) goto L8;
        r4.c(this.this$0.m, new AnonymousClass1(this));
        return;
    L8:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
