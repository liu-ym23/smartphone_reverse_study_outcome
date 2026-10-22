package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m7a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/ECTabKitView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Landroid/view/ViewGroup;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitView extends UISimpleView<ViewGroup> {
    public ECTabKitView(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new FrameLayout(getLynxContext());
    }

    public final void M(float r3, float r4) {
        a r5 = new a(getSign(), "SplitModalScroll", MapsKt.mapOf(new Pair[]{TuplesKt.to("offset", Float.valueOf(r3)), TuplesKt.to("max_offset", Float.valueOf(r4))}));
        LynxContext r6 = getLynxContext();
        if (r6 == null) goto L8;
        EventEmitter r7 = r6.getEventEmitter();
        if (r7 == null) goto L9;
        r7.sendCustomEvent(r5);
        return;
    L9:
        return;
    }

    public final void N(float r3, float r4) {
        a r5 = new a(getSign(), "TabContainerScroll", MapsKt.mapOf(new Pair[]{TuplesKt.to("offset", Float.valueOf(r3)), TuplesKt.to("max_offset", Float.valueOf(r4))}));
        LynxContext r6 = getLynxContext();
        if (r6 == null) goto L8;
        EventEmitter r7 = r6.getEventEmitter();
        if (r7 == null) goto L9;
        r7.sendCustomEvent(r5);
        return;
    L9:
        return;
    }
}
