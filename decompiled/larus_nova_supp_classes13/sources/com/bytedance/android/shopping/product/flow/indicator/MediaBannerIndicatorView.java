package com.bytedance.android.shopping.product.flow.indicator;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaBannerIndicatorView extends LinearLayout implements c {
    public final TextView a;
    public final TextView b;
    public int c;
    public int d;
    public BannerView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MediaBannerIndicatorView a;

        public a(MediaBannerIndicatorView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MediaBannerIndicatorView r3 = this.a;
            if (r3.d <= 0) goto L10;
            BannerView r4 = r3.e;
            if (r4 == null) goto L11;
            RecyclerView r5 = r4.getViewPager();
            if (r5 == null) goto L12;
            r5.scrollToPosition(0);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MediaBannerIndicatorView a;

        public b(MediaBannerIndicatorView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            MediaBannerIndicatorView r3 = this.a;
            if (r3.d != 0) goto L10;
            BannerView r4 = r3.e;
            if (r4 == null) goto L11;
            RecyclerView r5 = r4.getViewPager();
            if (r5 == null) goto L12;
            r5.scrollToPosition(1);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public MediaBannerIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MediaBannerIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerView");
        this.e = r2;
    }

    public final void c(TextView r8) {
        ColorStateList r4 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        Resources r2 = Resources.getSystem();
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        Resources r3 = Resources.getSystem();
        int r0 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r8.setTextSize(11.0f);
        r8.setTextColor(r4);
        r8.setPadding(r1, r0, r1, r0);
    }

    @Override // yg3.c
    public final void a(int r6, int r7) {
        this.d = r6;
        this.c = r7 - 1;
        if (r6 != 0) goto L5;
        this.a.setSelected(true);
        this.b.setSelected(false);
        TextView r8 = this.b;
        int r3 = g1.a;
        r8.setText(g1.a.c(getContext(), 2131913785, new Object[]{1, Integer.valueOf(this.c)}));
        return;
    L5:
        this.a.setSelected(false);
        this.b.setSelected(true);
        TextView r4 = this.b;
        int r5 = g1.a;
        r4.setText(g1.a.c(getContext(), 2131913785, new Object[]{Integer.valueOf((r6 - 1) + 1), Integer.valueOf(this.c)}));
    }

    public MediaBannerIndicatorView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        setBackgroundResource(2131233419);
        TextView r9 = new TextView(r6);
        c(r9);
        r9.setText(r6.getResources().getString(2131913789));
        r9.setBackgroundResource(2131233444);
        r9.setOnClickListener(new a(this));
        addView(r9, new LinearLayout.LayoutParams(-2, -2));
        Unit r0 = Unit.INSTANCE;
        this.a = r9;
        TextView r10 = new TextView(r6);
        c(r10);
        int r1 = g1.a;
        r10.setText(g1.a.c(r6, 2131913785, new Object[]{1, 0}));
        r10.setBackgroundResource(2131233444);
        r10.setOnClickListener(new b(this));
        addView(r10, new LinearLayout.LayoutParams(-2, -2));
        this.b = r10;
    }

    public /* synthetic */ MediaBannerIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
