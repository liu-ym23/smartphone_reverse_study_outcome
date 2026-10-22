package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0012\u001a\u00020\r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "Landroid/widget/FrameLayout;", "", "", "resId", "", "setIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "url", "setIconUrl", "", "text", "setText", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "a", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getIcon", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "icon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTextTV", "()Landroid/widget/TextView;", "textTV", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InflowSimpleAbilityView extends FrameLayout {
    public final ECDraweeView a;
    public final TextView b;

    public InflowSimpleAbilityView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowSimpleAbilityView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ECDraweeView getIcon() {
        return this.a;
    }

    public final TextView getTextTV() {
        return this.b;
    }

    public final void setIcon(int r2) {
        this.a.setImageResource(r2);
    }

    public final void setIconUrl(ECUrlModel r3) {
        this.a.setAdjustMode(2000);
        y.a(this.a, r3);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b.setText(r2);
    }

    public InflowSimpleAbilityView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560728, this);
        ECDraweeView r5 = findViewById(2131383160);
        this.a = r5;
        TextView r6 = (TextView) findViewById(2131383161);
        this.b = r6;
        se3.a.c(r6, 2, 11.0f);
        se3.a.b(r5);
    }

    public /* synthetic */ InflowSimpleAbilityView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
