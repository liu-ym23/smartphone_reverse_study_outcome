package com.obric.oui.header;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes34.dex */
public class HeaderInfoView extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f401061e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OImageAppIcon f401062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTextView f401063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OTextView f401064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f401065d;

    static {
        f401061e = new int[]{R.attr.padding, R.attr.paddingTop, R.attr.paddingBottom};
    }

    public FrameLayout getCustomContentContainer() {
        return this.f401065d;
    }

    public OImageAppIcon getIconView() {
        return this.f401062a;
    }

    public OTextView getSubtitleView() {
        return this.f401064c;
    }

    public OTextView getTitleView() {
        return this.f401063b;
    }

    public HeaderInfoView(Context r100) {
        this(r100, null);
    }

    public void setIcon(int r100) {
        this.f401062a.setImageResource(r100);
        OImageAppIcon r101 = this.f401062a;
        if (r100 != 0) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setImagePackageName(String r100) {
        if (r100 != null) goto L4;
    L8:
        setIcon(null);
        return;
    L4:
        if (r100.trim().isEmpty() == true) goto L8;
        this.f401062a.setImagePackageName(r100);
        this.f401062a.setVisibility(0);
    }

    public void setSubtitle(CharSequence r100) {
        this.f401064c.setText(r100);
        OTextView r101 = this.f401064c;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setSubtitleColor(int r100) {
        this.f401064c.setTextColor(r100);
    }

    public void setTitle(CharSequence r100) {
        this.f401063b.setText(r100);
        OTextView r101 = this.f401063b;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setTitleColor(int r100) {
        this.f401063b.setTextColor(r100);
    }

    public void setIcon(Drawable r100) {
        this.f401062a.setImageDrawable(r100);
        OImageAppIcon r101 = this.f401062a;
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public HeaderInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public HeaderInfoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.header_info_view_layout, this, true);
        setGravity(1);
        setOrientation(1);
        this.f401062a = (OImageAppIcon) findViewById(com.larus.nova.R.id.header_info_icon);
        this.f401063b = (OTextView) findViewById(com.larus.nova.R.id.header_info_title);
        this.f401064c = (OTextView) findViewById(com.larus.nova.R.id.header_info_subtitle);
        this.f401065d = (FrameLayout) findViewById(com.larus.nova.R.id.header_info_custom_content_container);
        TypedArray r103 = getContext().obtainStyledAttributes(r101, f401061e);
        boolean r104 = r103.hasValue(0);     // Catch: Throwable -> L39
        if (r104 == false) goto L6;
    L9:
        int r105 = getPaddingTop();     // Catch: Throwable -> L39
    L11:
        if (r104 == false) goto L13;
    L16:
        int r106 = getPaddingBottom();     // Catch: Throwable -> L39
    L17:
        setPadding(getPaddingLeft(), r105, getPaddingRight(), r106);     // Catch: Throwable -> L39
        r103.recycle();
        TypedArray r107 = getContext().obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.oui_headerInfo_icon, com.larus.nova.R.attr.oui_headerInfo_subtitle, com.larus.nova.R.attr.oui_headerInfo_subtitleColor, com.larus.nova.R.attr.oui_headerInfo_title, com.larus.nova.R.attr.oui_headerInfo_titleColor}, 0, 0);
    L36:
        th = move-exception;
        r107.recycle();
        throw th;
    L20:
        if (r107.hasValue(0) == false) goto L23;
        setIcon(r107.getDrawable(0));     // Catch: Throwable -> L36
    L23:
        if (r107.hasValue(3) == false) goto L26;
        setTitle(r107.getString(3));     // Catch: Throwable -> L36
    L26:
        if (r107.hasValue(4) == false) goto L29;
        setTitleColor(r107.getColor(4, this.f401063b.getCurrentTextColor()));     // Catch: Throwable -> L36
    L29:
        if (r107.hasValue(1) == false) goto L32;
        setSubtitle(r107.getString(1));     // Catch: Throwable -> L36
    L32:
        if (r107.hasValue(2) == false) goto L34;
        setSubtitleColor(r107.getColor(2, this.f401064c.getCurrentTextColor()));     // Catch: Throwable -> L36
    L34:
        r107.recycle();
        return;
    L13:
        if (r103.hasValue(2) == true) goto L16;
        Resources r108 = getResources();     // Catch: Throwable -> L39
        r106 = (int) TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));     // Catch: Throwable -> L39
        goto L17
    L6:
        if (r103.hasValue(1) == true) goto L9;
        Resources r109 = getResources();     // Catch: Throwable -> L39
        r105 = (int) TypedValue.applyDimension(1, 96, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()));     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r103.recycle();
        throw th;
    }
}
