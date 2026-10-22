package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006¨\u0006$"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "", "text", "", "setTitleText", "", "resId", "setTitleStyle", "", "size", "setTitleTextSize", "color", "setTitleTextColor", "Landroid/view/View;", "view", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "Lcom/obric/oui/text/OTextView;", "getEndDetail", "setDetailEndText", "Landroid/graphics/drawable/Drawable;", "drawable", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f402631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f402632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f402633c;

    public static final class a {
    }

    static {
    }

    public OSectionTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSectionTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View getCustomEndView() {
        if (this.f402632b.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f402632b.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r100 = getCustomEndView();
        if (r100 == null) goto L9;
        return (OTextView) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final void a(boolean r100) {
        int r101 = 8;
        if (this.f402632b.getChildCount() == 0) goto L8;
        FrameLayout r102 = this.f402632b;
        if (r100 == false) goto L7;
        r101 = 0;
    L7:
        r102.setVisibility(r101);
        return;
    L8:
        this.f402632b.setVisibility(8);
    }

    public final void b(boolean r100) {
        int r101 = 8;
        if (this.f402633c.getDrawable() == null) goto L8;
        ImageView r102 = this.f402633c;
        if (r100 == false) goto L7;
        r101 = 0;
    L7:
        r102.setVisibility(r101);
        return;
    L8:
        this.f402633c.setVisibility(8);
    }

    public final void setCustomEndView(int r100) {
        this.f402632b.removeAllViews();
        if (r100 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        LinearLayout.inflate(getContext(), r100, this.f402632b);     // Catch: Exception -> L8
    }

    public final void setDefaultCustomEndView(int r100) {
        this.f402632b.removeAllViews();
        if (r100 != 0) goto L5;
        setCustomEndView(R.layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r100) {
        if (r100 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R.drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L4:
        b(false);
    }

    public final void setDetailEndText(CharSequence r100) {
        setDefaultCustomEndView(0);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r101 = getCustomEndView();
        if (r101 == null) goto L8;
        ((OTextView) r101).setText(r100);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setTailIcon(int r100) {
        if (r100 == 0) goto L4;
        this.f402633c.setImageResource(r100);
        return;
    L4:
        this.f402633c.setImageDrawable(null);
        b(false);
    }

    public final void setTitleStyle(int r100) {
        this.f402631a.setTextAppearance(r100);
    }

    public final void setTitleText(CharSequence r100) {
        this.f402631a.setText(r100);
    }

    public final void setTitleTextColor(int r100) {
        this.f402631a.setTextColor(r100);
    }

    public final void setTitleTextSize(float r100) {
        this.f402631a.setTextSize(r100);
    }

    public final void setCustomEndView(View r100) {
        this.f402632b.removeAllViews();
        if (r100 == null) goto L5;
        this.f402632b.addView(r100);
        return;
    L5:
        a(false);
    }

    public final void setTailIcon(Drawable r100) {
        if (r100 == null) goto L4;
        this.f402633c.setImageDrawable(r100);
        return;
    L4:
        b(false);
    }

    public OSectionTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        LayoutInflater.from(r100).inflate(R.layout.o_section_title_bar, this, true);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.container);
        this.f402631a = (TextView) findViewById(R.id.titleTextView);
        this.f402632b = (FrameLayout) findViewById(R.id.custom_end_container);
        this.f402633c = (ImageView) findViewById(R.id.tail_icon);
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.sectionTitle_customEnd, R.attr.sectionTitle_defaultCustomEnd, R.attr.sectionTitle_defaultTail, R.attr.sectionTitle_detailEndText, R.attr.sectionTitle_showCustomEnd, R.attr.sectionTitle_showTail, R.attr.sectionTitle_tail, R.attr.sectionTitle_titleStyle, R.attr.sectionTitle_titleText}, 0, 0);
    L32:
        th = move-exception;
        r104.recycle();
        throw th;
    L4:
        if (r104.hasValue(8) == false) goto L7;
        setTitleText(r104.getString(8));     // Catch: Throwable -> L32
    L7:
        if (r104.hasValue(7) == false) goto L10;
        setTitleStyle(r104.getResourceId(7, R.style.OSectionTitleBar_S));     // Catch: Throwable -> L32
    L10:
        if (r104.hasValue(0) == false) goto L13;
        setCustomEndView(r104.getResourceId(0, 0));     // Catch: Throwable -> L32
    L13:
        if (r104.hasValue(1) == false) goto L16;
        setDefaultCustomEndView(r104.getInt(1, 0));     // Catch: Throwable -> L32
    L16:
        if (r104.hasValue(3) == false) goto L19;
        setDetailEndText(r104.getString(3));     // Catch: Throwable -> L32
    L19:
        if (r104.hasValue(4) == false) goto L22;
        a(r104.getBoolean(4, false));     // Catch: Throwable -> L32
    L22:
        if (r104.hasValue(6) == false) goto L25;
        setTailIcon(r104.getResourceId(6, 0));     // Catch: Throwable -> L32
    L25:
        if (r104.hasValue(2) == false) goto L28;
        setDefaultTailIcon(r104.getInt(2, 0));     // Catch: Throwable -> L32
    L28:
        if (r104.hasValue(5) == false) goto L30;
        b(r104.getBoolean(5, false));     // Catch: Throwable -> L32
    L30:
        r104.recycle();
    }

    public /* synthetic */ OSectionTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
