package com.bytedance.android.shopping.product.flow.indicator;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import cg4.a;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yg3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/NumberBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "", "description", "", "setDescription", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NumberBannerIndicatorView extends LinearLayout implements c {
    public final TextView a;
    public final TextView b;

    public NumberBannerIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NumberBannerIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerView");
    }

    public final void c(TextView r8) {
        ColorStateList r3 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        int r1 = ExtensionsKt.getDp(10);
        int r0 = ExtensionsKt.getDp(2);
        r8.setTextSize(11.0f);
        r8.setTextColor(r3);
        r8.setPadding(r1, r0, r1, r0);
    }

    public final void setDescription(String r2) {
        if (a.a(r2) == false) goto L10;
        TextView r0 = this.a;
        if (r0 == null) goto L7;
        r0.setText(r2);
    L7:
        TextView r3 = this.a;
        if (r3 == null) goto L14;
        ExtensionsKt.visible(r3);
        return;
    L14:
        return;
    L10:
        TextView r4 = this.a;
        if (r4 == null) goto L16;
        r4.setVisibility(4);
        return;
    }

    @Override // yg3.c
    public final void a(int r6, int r7) {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        int r1 = g1.a;
        r0.setText(g1.a.c(getContext(), 2131913787, new Object[]{"", Integer.valueOf(r6 + 1), Integer.valueOf(r7)}));
        return;
    }

    public NumberBannerIndicatorView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r5).aU(2131560742, this, true);
        TextView r8 = (TextView) findViewById(2131387067);
        TextView r1 = null;
        if (r8 == null) goto L5;
        c(r8);
        r8.setBackgroundResource(2131247914);
        r8.setVisibility(4);
        Unit r2 = Unit.INSTANCE;
    L6:
        this.a = r8;
        TextView r9 = (TextView) findViewById(2131375246);
        if (r9 == null) goto L9;
        c(r9);
        int r3 = g1.a;
        r9.setText(g1.a.c(r5, 2131913787, new Object[]{"", 1, 0}));
        r9.setBackgroundResource(2131247914);
        Unit r10 = Unit.INSTANCE;
        r1 = r9;
    L9:
        this.b = r1;
        return;
    L5:
        r8 = null;
        goto L6
    }

    public /* synthetic */ NumberBannerIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
