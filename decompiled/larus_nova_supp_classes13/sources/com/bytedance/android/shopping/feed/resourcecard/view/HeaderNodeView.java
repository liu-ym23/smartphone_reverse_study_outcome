package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/widget/FrameLayout;", "Lyd3/f;", "a", "Lyd3/f;", "getHeaderNode", "()Lyd3/f;", "setHeaderNode", "(Lyd3/f;)V", "headerNode", "Lrd3/a;", "b", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HeaderNodeView extends FrameLayout {
    public yd3.f a;
    public rd3.a b;

    public HeaderNodeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final rd3.a getAnchorInflowFeedItem() {
        return this.b;
    }

    public final yd3.f getHeaderNode() {
        return this.a;
    }

    public void a(rd3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorInflowFeedItem");
        yd3.p r0 = r2.i();
        if (r0 == null) goto L5;
        yd3.f r1 = r0.h();
    L6:
        this.a = r1;
        this.b = r2;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setAnchorInflowFeedItem(rd3.a r1) {
        this.b = r1;
    }

    public final void setHeaderNode(yd3.f r1) {
        this.a = r1;
    }

    public HeaderNodeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        float r6 = 12;
        Resources r7 = Resources.getSystem();
        int r8 = MathKt.roundToInt(TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        Resources r0 = Resources.getSystem();
        setPadding(r8, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
