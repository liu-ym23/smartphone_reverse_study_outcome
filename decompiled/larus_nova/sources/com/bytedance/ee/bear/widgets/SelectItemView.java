package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SelectItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f240129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDCheckBox f240130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f240131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f240132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f240133e;

    public UDCheckBox getCheckBox() {
        return this.f240130b;
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.f240129a;
    }

    public SelectItemView(Context r100) {
        this(r100, null);
    }

    public void setDescription(String r100) {
        this.f240132d.setText(r100);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        this.f240129a = r100;
        this.f240130b.setChecked(r100);
        if (r100 == true) goto L5;
    L7:
        this.f240132d.setVisibility(8);
        return;
    L5:
        if (TextUtils.isEmpty(this.f240132d.getText().toString()) == true) goto L7;
        this.f240132d.setVisibility(0);
    }

    public void setText(int r100) {
        this.f240131c.setText(r100);
    }

    public void setTextColor(int r100) {
        this.f240131c.setTextColor(r100);
    }

    public void setText(String r100) {
        this.f240131c.setText(r100);
    }

    public SelectItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SelectItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.share_list_link_share_item, this);
        this.f240130b = (UDCheckBox) r103.findViewById(R.id.share_checkbox);
        this.f240131c = (TextView) r103.findViewById(R.id.share_link_item_title);
        this.f240132d = (TextView) r103.findViewById(R.id.share_link_item_sub_title);
        this.f240133e = r103.findViewById(R.id.share_link_divider);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.description, R.attr.showBottomDivider, R.attr.subtitleMarginTop, R.attr.title});
        String r105 = r104.getString(3);
        if (TextUtils.isEmpty(r105) == true) goto L5;
        this.f240131c.setText(r105);
    L5:
        int r106 = 0;
        String r107 = r104.getString(0);
        if (TextUtils.isEmpty(r107) == true) goto L8;
        this.f240132d.setText(r107);
    L8:
        int r108 = (int) r104.getDimension(2, -1.0f);
        if (r108 != (-1)) goto L11;
    L13:
        boolean r109 = r104.getBoolean(1, true);
        View r110 = this.f240133e;
        if (r109 == true) goto L17;
        r106 = 8;
    L17:
        r110.setVisibility(r106);
        r104.recycle();
        return;
    L11:
        if ((this.f240132d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.f240132d.getLayoutParams();
        r111.setMargins(r111.leftMargin, r108, r111.rightMargin, r111.bottomMargin);
        goto L13
    }
}
