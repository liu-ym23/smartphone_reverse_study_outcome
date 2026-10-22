package com.bytedance.android.shopping.feed.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "Landroid/widget/LinearLayout;", "", "count", "", "setImageSlideListProgressBar", "Lkotlin/Function1;", "", "d", "Lkotlin/jvm/functions/Function1;", "getOnProgressBarSelected", "()Lkotlin/jvm/functions/Function1;", "setOnProgressBarSelected", "(Lkotlin/jvm/functions/Function1;)V", "onProgressBarSelected", "e", "Z", "getMIsClickEnabled", "()Z", "setMIsClickEnabled", "(Z)V", "mIsClickEnabled", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageSlideListProgressBar extends LinearLayout {
    public final Context a;
    public int b;
    public final int c;
    public Function1<? super Boolean, Unit> d;
    public boolean e;

    public ImageSlideListProgressBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageSlideListProgressBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getMIsClickEnabled() {
        return this.e;
    }

    public final Function1<Boolean, Unit> getOnProgressBarSelected() {
        return this.d;
    }

    public final void setImageSlideListProgressBar(int r7) {
        removeAllViews();
        this.b = 0;
        if (r7 > 1) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L15;
        ImageSlideProgressBar r2 = new ImageSlideProgressBar(this.a, null, 6, 0);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        if (r1 == (r7 - 1)) goto L11;
        r3.setMargins(0, 0, this.c, 0);
    L11:
        r2.setLayoutParams(r3);
        if (this.e == false) goto L14;
        r2.setOnClickListener(new a(this, r1));
    L14:
        addView(r2);
        r1 = r1 + 1;
        goto L7
    }

    public final void setMIsClickEnabled(boolean r1) {
        this.e = r1;
    }

    public final void setOnProgressBarSelected(Function1<? super Boolean, Unit> r1) {
        this.d = r1;
    }

    public ImageSlideListProgressBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2, r3, r4);
        this.a = getContext();
        Resources r5 = Resources.getSystem();
        this.c = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 5.0d, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
    }

    public /* synthetic */ ImageSlideListProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
