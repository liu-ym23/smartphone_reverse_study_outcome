package com.bytedance.android.shopping.deepfeed;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "actionName", "", "params", "", "", FreqActions.ACTION_VIEW, "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductFragment$openScreenShotPopup$1 extends Lambda implements Function3<String, Map<String, ? extends Object>, View, Unit> {
    final /* synthetic */ DeepFeedProductFragment this$0;

    public DeepFeedProductFragment$openScreenShotPopup$1(DeepFeedProductFragment r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(String r3, Map<String, ? extends Object> r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        AbsDeepFeedProductVH r0 = this.this$0.v;
        if ((r0 instanceof DeepFeedProductSlcVH) == true) goto L5;
        r0 = null;
    L5:
        DeepFeedProductSlcVH r1 = (DeepFeedProductSlcVH) r0;
        if (r1 == null) goto L9;
        r1.F4(r3, r4, r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (Map) r2, (View) r3);
        return Unit.INSTANCE;
    }
}
