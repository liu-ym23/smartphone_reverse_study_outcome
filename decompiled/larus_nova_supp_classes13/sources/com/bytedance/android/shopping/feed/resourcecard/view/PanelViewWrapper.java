package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelViewWrapper;", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "b", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "getPanelViewImpl", "()Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "setPanelViewImpl", "(Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;)V", "panelViewImpl", "", "c", "Ljava/lang/Integer;", "getCurPanelType", "()Ljava/lang/Integer;", "setCurPanelType", "(Ljava/lang/Integer;)V", "curPanelType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelViewWrapper extends RoundedFrameLayout {
    public BasePanelView b;
    public Integer c;

    public PanelViewWrapper(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PanelViewWrapper(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Integer getCurPanelType() {
        return this.c;
    }

    public final BasePanelView getPanelViewImpl() {
        return this.b;
    }

    public final void setCurPanelType(Integer r1) {
        this.c = r1;
    }

    public final void setPanelViewImpl(BasePanelView r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(rd3.a r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "anchorInflowFeedItem");
        yd3.p r0 = r9.i();
        if (r0 == null) goto L68;
        int r1 = r0.getType();
        yd3.p r2 = r9.i();
        if (r2 == null) goto L9;
        yd3.m r3 = r2.l();
        if (r3 == null) goto L9;
        Integer r4 = r3.f();
    L10:
        Integer r5 = this.c;
        if (r5 != null) goto L14;
    L15:
        this.c = Integer.valueOf(r1);
        removeAllViews();
        if (r4 != null) goto L19;
    L20:
        if (r4 != null) goto L23;
    L25:
        int r6 = PanelView.i;
        Context r7 = getContext();
        Intrinsics.checkNotNullParameter(r7, "context");
        if (ld3.b.a() == true) goto L66;
        PanelView r8 = new PanelView(r7, null, 6, 0);
    L36:
        this.b = r8;
        addView(r8, -1, -1);
    L62:
        BasePanelView r11 = this.b;
        if (r11 == null) goto L69;
        r11.a(r9, r10);
        return;
    L69:
        return;
    L66:
        Map r12 = ShoppingAsyncCacheInflater.d;     // Catch: Exception -> L34
        View r13 = ShoppingAsyncCacheInflater.a.a(r7).b("ec_panel_view", null);     // Catch: Exception -> L34
        if ((r13 instanceof PanelView) == true) goto L30;
        r13 = null;
    L30:
        r8 = (PanelView) r13;     // Catch: Exception -> L34
        if (r8 != null) goto L36;
        r8 = new PanelView(r7, null, 6, 0);     // Catch: Exception -> L34
    L34:
        r8 = new PanelView(r7, null, 6, 0);
        goto L36
    L23:
        if (r4.intValue() != 4) goto L25;
    L37:
        yd3.p r14 = r9.i();
        if (r14 == null) goto L42;
        yd3.m r15 = r14.l();
        if (r15 == null) goto L42;
        Integer r16 = Integer.valueOf(r15.b());
    L43:
        if (r16 != null) goto L46;
    L48:
        if (r16 != null) goto L51;
    L57:
        int r17 = RowPanelView.f;
        Context r18 = getContext();
        Intrinsics.checkNotNullParameter(r18, "context");
        if (ld3.b.a() == false) goto L60;
        Map r19 = ShoppingAsyncCacheInflater.d;
        BasePanelView r20 = (RowPanelView) ShoppingAsyncCacheInflater.a.a(r18).b("ec_row_panel_view", new l());
    L61:
        this.b = r20;
        addView(r20, -1, -2);
        Resources r21 = Resources.getSystem();
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()))));
        goto L62
    L60:
        BasePanelView r22 = new RowPanelView(r18, null, 6, 0);
    L56:
        r20 = r22;
        goto L61
    L51:
        if (r16.intValue() != 7) goto L57;
    L52:
        int r23 = RowPanelViewStyle67.f;
        Context r24 = getContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        if (ld3.b.a() == false) goto L55;
        Map r25 = ShoppingAsyncCacheInflater.d;
        r20 = (RowPanelViewStyle67) ShoppingAsyncCacheInflater.a.a(r24).b("ec_row_panel_view_style67", new m());
        goto L61
    L55:
        r22 = new RowPanelViewStyle67(r24, null, 6, 0);
        goto L56
    L46:
        if (r16.intValue() != 6) goto L48;
    L42:
        r16 = null;
        goto L43
    L19:
        if (r4.intValue() == 3) goto L37;
    L14:
        if (r5.intValue() == r1) goto L62;
    L9:
        r4 = null;
        goto L10
    }

    public PanelViewWrapper(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = Resources.getSystem();
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()))));
    }

    public /* synthetic */ PanelViewWrapper(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
