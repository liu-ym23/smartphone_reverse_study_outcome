package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class TitleBarRedDotView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUIBadgeView f417136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f417137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f417138c;

    public View getIconView() {
        return this.f417137b;
    }

    public TitleBarRedDotView(Context r100) {
        super(r100);
        R5(r100, null);
    }

    public void setBadgeDrawable(int r100) {
        LKUIBadgeView r101 = this.f417136a;
        r101.b(r100);
        r101.a();
    }

    public void setBadgeSize(int r100) {
        this.f417138c = r100;
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) this.f417136a.getLayoutParams();
        int r102 = this.f417138c;
        if (r102 <= 0) goto L5;
        ((ViewGroup.MarginLayoutParams) r101).width = r102;
        ((ViewGroup.MarginLayoutParams) r101).height = r102;
    L5:
        this.f417136a.setLayoutParams(r101);
    }

    public void setIconDrawable(Drawable r100) {
        this.f417137b.setImageDrawable(r100);
    }

    public TitleBarRedDotView(Context r100, AttributeSet r101) {
        super(r100, r101);
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        if (r101 == null) goto L4;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.badgeRightOffset, R.attr.badgeSize, R.attr.badgeTopOffset});
        this.f417138c = r102.getDimensionPixelSize(1, 0);
        r102.recycle();
    L4:
        ViewGroup.inflate(getContext(), R.layout.chat_red_dot_view, this);
        this.f417136a = (LKUIBadgeView) findViewById(R.id.iv_badge);
        this.f417137b = (ImageView) findViewById(R.id.iv_icon);
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) this.f417136a.getLayoutParams();
        int r104 = this.f417138c;
        if (r104 <= 0) goto L8;
        ((ViewGroup.MarginLayoutParams) r103).width = r104;
        ((ViewGroup.MarginLayoutParams) r103).height = r104;
        return;
    }

    public TitleBarRedDotView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
