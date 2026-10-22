package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCommentItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedCommentItemView extends LinearLayout {
    public final TextView a;
    public final ECDraweeView b;

    public InflowFeedCommentItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowFeedCommentItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = View.MeasureSpec.getSize(r4);
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((View) r0.next()).getMeasuredWidth();
        goto L4
    L6:
        if (r1 <= r6) goto L10;
        TextView r2 = this.a;
        r2.measure(View.MeasureSpec.makeMeasureSpec(r6 - (r1 - r2.getMeasuredWidth()), 1073741824), r5);
        return;
    }

    public InflowFeedCommentItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560738, this, true);
    L6:
        this.a = (TextView) findViewById(2131375270);
        this.b = findViewById(2131375269);
        TextView r6 = (TextView) findViewById(2131375272);
        TextView r7 = (TextView) findViewById(2131375273);
        setGravity(16);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560738, this, true);
        goto L6
    }

    public /* synthetic */ InflowFeedCommentItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
