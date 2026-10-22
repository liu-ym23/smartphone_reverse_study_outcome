package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeFolderHeaderView extends FrameLayout {
    public Function0<Unit> a;
    public Function0<Unit> b;
    public Function1<? super View, Unit> c;
    public Function0<Unit> d;
    public String e;
    public boolean f;
    public final int g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final TextView k;
    public final TextView l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OfficeFolderHeaderView a;

        public a(OfficeFolderHeaderView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnCancelSelectionClick();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function1<View, Unit> a;
        public final /* synthetic */ ImageView b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super View, Unit> r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.invoke(this.b);
        }
    }

    public final Function0<Unit> getOnBackClick() {
        return this.a;
    }

    public final Function0<Unit> getOnCancelSelectionClick() {
        return this.d;
    }

    public final Function1<View, Unit> getOnMoreClick() {
        return this.c;
    }

    public final Function0<Unit> getOnSearchClick() {
        return this.b;
    }

    public OfficeFolderHeaderView(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13);
        this.e = "";
        int r0 = a(72);
        int r1 = a(104);
        int r2 = d.a;
        int r3 = Math.max(r0, r1);
        this.g = r3;
        ImageView r4 = b(2131244675, new OfficeFolderHeaderView$backButton$1(this));
        this.h = r4;
        ImageView r5 = b(2131244676, new OfficeFolderHeaderView$searchButton$1(this));
        this.i = r5;
        ImageView r6 = b(2131244683, new OfficeFolderHeaderView$moreButton$1(this));
        this.j = r6;
        TextView r7 = new TextView(r13);
        r7.setText(r13.getString(2131888904));
        r7.setGravity(17);
        r7.setTextColor(ContextCompat.getColor(r13, 2131106622));
        r7.setTextSize(16.0f);
        r7.setVisibility(8);
        r7.setClickable(true);
        r7.setOnClickListener(new a(this));
        this.k = r7;
        TextView r8 = new TextView(r13);
        r8.setGravity(17);
        r8.setMaxLines(1);
        r8.setEllipsize(TextUtils.TruncateAt.END);
        r8.setTextColor(ContextCompat.getColor(r13, 2131106622));
        r8.setTextSize(17.0f);
        r8.setTypeface(Typeface.DEFAULT_BOLD);
        this.l = r8;
        setBackgroundColor(ContextCompat.getColor(r13, 2131100548));
        setLayoutParams(new FrameLayout.LayoutParams(-1, a(60)));
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(a(40), a(40), 8388627);
        r14.setMarginStart(a(4));
        Unit r10 = Unit.INSTANCE;
        addView(r4, r14);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(a(64), -1, 8388627);
        r15.setMarginStart(a(4));
        addView(r7, r15);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, -1, 17);
        r16.setMarginStart(r3);
        r16.setMarginEnd(r3);
        addView(r8, r16);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(a(40), a(40), 8388629);
        r17.setMarginEnd(a(52));
        addView(r5, r17);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(a(40), a(40), 8388629);
        r18.setMarginEnd(a(12));
        addView(r6, r18);
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setOnBackClick(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void setOnCancelSelectionClick(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnMoreClick(Function1<? super View, Unit> r1) {
        this.c = r1;
    }

    public final void setOnSearchClick(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setSelectionMode(boolean r5) {
        if (this.f != r5) goto L5;
        return;
    L5:
        this.f = r5;
        TextView r0 = this.k;
        int r1 = 0;
        if (r5 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        ImageView r2 = this.h;
        if (r5 == false) goto L12;
        int r4 = 8;
    L13:
        r2.setVisibility(r4);
        ImageView r6 = this.i;
        if (r5 == false) goto L16;
        int r7 = 8;
    L17:
        r6.setVisibility(r7);
        ImageView r8 = this.j;
        if (r5 == false) goto L20;
        r1 = 8;
    L20:
        r8.setVisibility(r1);
        TextView r9 = this.l;
        if (r5 == false) goto L23;
        String r10 = "";
    L24:
        r9.setText(r10);
        return;
    L23:
        r10 = this.e;
        goto L24
    L16:
        r7 = 0;
        goto L17
    L12:
        r4 = 0;
        goto L13
    L8:
        r3 = 8;
        goto L9
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.e = r2;
        if (this.f == true) goto L6;
        this.l.setText(r2);
        return;
    }

    public final ImageView b(int r5, Function1<? super View, Unit> r6) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r5);
        r0.setColorFilter(ContextCompat.getColor(r0.getContext(), 2131106622));
        r0.setScaleType(ImageView.ScaleType.CENTER);
        r0.setPadding(a(8), a(8), a(8), a(8));
        r0.setClickable(true);
        r0.setOnClickListener(new b(r6, r0));
        return r0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        TextView r0 = this.l;
        int r1 = d.a;
        r0.setMaxWidth(RangesKt.coerceAtLeast(View.MeasureSpec.getSize(r4) - (this.g * 2), 0));
        super.onMeasure(r4, r5);
    }
}
