package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.SellingPointInfoStruct;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InnerFeedSellingPointView;", "Lcom/bytedance/android/shopping/feed/widget/HorizontalSplitTextViewGroup;", "Lcom/bytedance/android/ec/model/response/anchorv3/SellingPointInfoStruct;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedSellingPointView extends HorizontalSplitTextViewGroup<SellingPointInfoStruct> implements com.bytedance.android.shopping.feed.view.c {
    public InnerFeedSellingPointView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InnerFeedSellingPointView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.feed.widget.HorizontalSplitTextViewGroup
    public final void b(List<? extends SellingPointInfoStruct> r9) {
        super.b(r9);
        if (r9 == null) goto L13;
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L17;
        SellingPointInfoStruct r0 = (SellingPointInfoStruct) r10.next();
        TextView r1 = getServiceView();
        r1.setIncludeFontPadding(false);
        r1.setGravity(17);
        Resources r5 = Resources.getSystem();
        r1.setLayoutParams(new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())))));
        float r3 = 4;
        Resources r4 = Resources.getSystem();
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        Resources r7 = Resources.getSystem();
        r1.setPadding(r6, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()))), 0);
        r1.setTextColor(ag4.a.b(2131101196));
        r1.setTextSize(1, 11.0f);
        r1.setSingleLine();
        r1.setBackgroundResource(2131233482);
        String r8 = null;
        if ((r0 instanceof SellingPointInfoStruct) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        r8 = r0.getContent();
    L12:
        r1.setText(r8);
        addView(r1);
        goto L6
    L17:
        return;
    }

    public InnerFeedSellingPointView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setDividerDrawable(ag4.a.c(2131233479));
        Resources r5 = Resources.getSystem();
        setDividerPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()))));
    }

    public /* synthetic */ InnerFeedSellingPointView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
