package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.util.ui.l;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ToolbarItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f238095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f238096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBadgeView f238097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f238098d;

    public int getBadgeVisibility() {
        return this.f238097c.getVisibility();
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.f238095a.isSelected();
    }

    public ToolbarItemView(Context r100) {
        this(r100, null);
    }

    public void setBadgeVisibility(int r100) {
        this.f238097c.setVisibility(r100);
    }

    public void setIconDrawable(Drawable r100) {
        this.f238096b.setVisibility(8);
        this.f238095a.setVisibility(0);
        if (r100 == null) goto L5;
        this.f238095a.setImageDrawable(r100);
    L5:
        l.c(this.f238095a, R.color.icon_n1);
    }

    public void setIconTint(int r100) {
        ColorStateList r101 = getResources().getColorStateList(r100);
        this.f238095a.setImageTintList(r101);
    }

    public void setLeadingDividerVisible(boolean r100) {
        View r101 = this.f238098d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        this.f238095a.setSelected(r100);
        int r101 = R.color.colorful_blue;
        if (r100 == false) goto L5;
        int r102 = R.color.colorful_blue;
    L6:
        setIconTint(r102);
        TextView r103 = this.f238096b;
        Resources r104 = getResources();
        if (r100 == true) goto L10;
        r101 = R.color.ud_N800;
    L10:
        r103.setTextColor(r104.getColor(r101));
        return;
    L5:
        r102 = R.color.ud_N800;
        goto L6
    }

    public void setText(String r100) {
        this.f238095a.setVisibility(8);
        this.f238096b.setVisibility(0);
        this.f238096b.setGravity(17);
        this.f238096b.setText(r100);
        this.f238096b.setTextColor(getResources().getColor(R.color.icon_n1));
    }

    public ToolbarItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ToolbarItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.itemIcon});
        Drawable r104 = r103.getDrawable(0);
        r103.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.sheet_toolbar_item_layout, this, true);
        this.f238095a = (AppCompatImageView) findViewById(R.id.item_icon);
        this.f238096b = (TextView) findViewById(R.id.item_text);
        this.f238097c = (UDBadgeView) findViewById(R.id.item_badge);
        this.f238098d = findViewById(R.id.item_leading_divider);
        setIconDrawable(r104);
        setIconTint(R.color.ud_N800);
        l.c(this.f238095a, R.color.icon_n1);
        StateListDrawable r105 = new StateListDrawable();
        r105.addState(new int[]{android.R.attr.state_pressed}, ResourcesCompat.getDrawable(getResources(), R.drawable.doc_toolbar_v2_subitem_all_pressed, null));
        this.f238095a.setBackgroundDrawable(r105);
        StateListDrawable r106 = new StateListDrawable();
        r106.addState(new int[]{android.R.attr.state_pressed}, ResourcesCompat.getDrawable(getResources(), R.drawable.doc_toolbar_pressed_no_radius, null));
        this.f238096b.setBackground(r106);
    }
}
