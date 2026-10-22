package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends FrameLayout {
    public final ProgressBar a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final ImageView e;
    public Function0<Unit> f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public d(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        ProgressBar r0 = new ProgressBar(r8);
        r0.setIndeterminate(true);
        this.a = r0;
        ImageView r2 = new ImageView(r8);
        r2.setImageResource(2131244692);
        this.b = r2;
        ImageView r3 = new ImageView(r8);
        r3.setImageResource(2131244693);
        this.c = r3;
        TextView r4 = new TextView(r8);
        r4.setTextColor(ContextCompat.getColor(r8, 2131103959));
        r4.setTextSize(16.0f);
        r4.setTypeface(Typeface.DEFAULT_BOLD);
        r4.setIncludeFontPadding(false);
        r4.setMaxLines(1);
        this.d = r4;
        ImageView r5 = new ImageView(r8);
        r5.setImageResource(2131244688);
        r5.setContentDescription(null);
        this.e = r5;
        setBackground(ContextCompat.getDrawable(r8, 2131244662));
        setElevation(e.a(r8, 2));
        setVisibility(8);
        setClickable(true);
        addView(r0, a(18, 19));
        addView(r2, a(24, 16));
        addView(r3, a(24, 16));
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 16;
        r1.leftMargin = e.a(r8, 48);
        r1.rightMargin = e.a(r8, 48);
        Unit r6 = Unit.INSTANCE;
        addView(r4, r1);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(e.a(r8, 20), e.a(r8, 20));
        r7.gravity = 8388629;
        r7.rightMargin = e.a(r8, 16);
        addView(r5, r7);
        r5.setOnClickListener(new a(this));
    }

    public final void setOnBannerClickListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        setOnClickListener(new b(r2));
    }

    public final void setOnCloseClickListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f = r2;
    }

    public final FrameLayout.LayoutParams a(int r4, int r5) {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(e.a(getContext(), r4), e.a(getContext(), r4));
        r0.gravity = 16;
        r0.leftMargin = e.a(getContext(), r5);
        return r0;
    }
}
