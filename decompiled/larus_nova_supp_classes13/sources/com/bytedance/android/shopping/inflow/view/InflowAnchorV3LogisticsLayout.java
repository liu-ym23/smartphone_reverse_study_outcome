package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InflowAnchorV3LogisticsLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "weight", "", "setFontWeight", "color", "setTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowAnchorV3LogisticsLayout extends FrameLayout implements com.bytedance.android.shopping.feed.view.c {
    public final ECDraweeView a;
    public final TextView b;

    public InflowAnchorV3LogisticsLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowAnchorV3LogisticsLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void setFontWeight(int r3) {
        TextView r4 = this.b;
        ViewExtensionsKt.e(r4, r4.getPaint(), 500);
    }

    public final void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

    public InflowAnchorV3LogisticsLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        View r6 = ShoppingAsyncCacheInflater.a.a(r2).aU(2131560460, this, true);
    L6:
        ECDraweeView r7 = r6.findViewById(2131362643);
        this.a = r7;
        TextView r8 = (TextView) r6.findViewById(2131362644);
        this.b = r8;
        se3.a.c(r8, 2, 14.0f);
        se3.a.b(r7);
        return;
    L5:
        r6 = u63.a.a(r2, 2131560460, this, true);
        goto L6
    }

    public /* synthetic */ InflowAnchorV3LogisticsLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
