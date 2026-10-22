package com.relax.relaxreact;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", MapController.ITEM_LAYER_TAG, "Lcom/relax/relaxreact/BaseGesture;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BaseGesture$__externalWaitFor$1 extends Lambda implements Function1<BaseGesture, Unit> {
    final /* synthetic */ BaseGesture this$0;

    public BaseGesture$__externalWaitFor$1(BaseGesture r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BaseGesture r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        BaseGesture r101 = this.this$0;
        if (r100 == r101) goto L6;
        r101.b("waitFor", r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BaseGesture r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
