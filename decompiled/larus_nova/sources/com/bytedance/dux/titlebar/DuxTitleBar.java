package com.bytedance.dux.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.largefont.a;
import com.larus.nova.R;
import em4.g;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes15.dex */
public abstract class DuxTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DuxComponent f205810d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f205811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f205813c;

    public abstract void setDividerLineBackground(int r100);

    static {
        f205810d = DuxComponent.TITLE_BAR;
    }

    public TextView getTitleView() {
        return this.f205811a;
    }

    public DuxTitleBar(Context r100) {
        super(r100);
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205812b = DuxLargeFontHelper.a(f205810d, null);
        this.f205813c = false;
    }

    public final int a(int r100) {
        if (this.f205812b == false) goto L9;
        if (this.f205813c == false) goto L11;
        return a.b(Integer.valueOf(r100));
    L11:
        return g.f(r100);
    L9:
        return g.c(r100);
    }

    public final void b(View... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ViewGroup.LayoutParams r103 = r100[r102].getLayoutParams();
        r103.width = a(24) + (g.c(10) * 2);
        r102 = r102 + 1;
        goto L3
    }

    public final void c(TextView... r100) {
        if (this.f205812b == true) goto L5;
        return;
    L5:
        if (this.f205813c == false) goto L11;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L12;
        TextView r103 = r100[r102];
        r103.setTextSize(0, a.d(Float.valueOf(r103.getTextSize())));
        r102 = r102 + 1;
        goto L7
    L12:
        return;
    }

    public void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205812b = DuxLargeFontHelper.a(f205810d, r100);
    }

    public void setTitle(int r100) {
        TextView r101 = this.f205811a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public void setTitleColor(int r100) {
        TextView r101 = this.f205811a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextColor(r100);
    }

    public void setTitleSize(float r100) {
        TextView r101 = this.f205811a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextSize(r100);
    }

    public void setTitleSizePixel(float r100) {
        TextView r101 = this.f205811a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextSize(0, r100);
    }

    public void setTitle(CharSequence r100) {
        TextView r101 = this.f205811a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public DuxTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        Lazy r102 = DuxLargeFontHelper.f205243a;
        this.f205812b = DuxLargeFontHelper.a(f205810d, null);
        this.f205813c = false;
    }

    public DuxTitleBar(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null);
    }

    public DuxTitleBar(Context r100, AttributeSet r101, int r102, Boolean r103) {
        super(r100, r101, r102);
        Lazy r104 = DuxLargeFontHelper.f205243a;
        this.f205812b = DuxLargeFontHelper.a(f205810d, null);
        this.f205813c = false;
        setAdaptLargeFont(r103);
        if (r101 == null) goto L10;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.duxBgColor, R.attr.duxDividerColor, R.attr.duxTextColor, R.attr.limitLargeFontScale});
        if (r105.hasValue(0) == false) goto L8;
        setAdaptLargeFont(Boolean.valueOf(r105.getBoolean(0, false)));
    L8:
        this.f205813c = r105.getBoolean(4, false);
        r105.recycle();
    L10:
        if (getBackground() != null) goto L13;
        setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        return;
    }
}
