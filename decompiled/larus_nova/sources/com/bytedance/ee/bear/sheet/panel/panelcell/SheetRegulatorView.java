package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SheetRegulatorView extends SheetListItemView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f238283r = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f238284o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UDButton f238285p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public UDButton f238286q;

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void b() {
        super.b();
        findViewById(R.id.regulator_container).setVisibility(0);
        this.f238285p = (UDButton) findViewById(R.id.regulator_minus);
        this.f238286q = (UDButton) findViewById(R.id.regulator_add);
        f(this.f238285p);
        f(this.f238286q);
    }

    public SheetRegulatorView(Context r100) {
        this(r100, null);
    }

    public final void f(UDButton r100) {
        Drawable r101 = r100.getCompoundDrawablesRelative()[0];
        if (r101 == null) goto L6;
        int r102 = getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        int r103 = r101.getIntrinsicWidth();
        int r104 = (r103 - r102) / 2;
        int r105 = (r101.getIntrinsicHeight() - r102) / 2;
        r101.setBounds(r104, r105, r104 + r102, r102 + r105);
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView, com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(final SheetItem r100) {
        super.update(r100);
        this.f238284o = r100.getId();
        TextView r101 = (TextView) findViewById(R.id.regulator_value);
        r101.setText(r100.getValue());
        Resources r102 = getResources();
        if (r100.isEnable() == false) goto L5;
        int r103 = R.color.sheet_item_text_normal;
    L6:
        r101.setTextColor(r102.getColor(r103));
        int r104 = r100.getCurrentIndex();
        boolean r105 = false;
        if (r100.isEnable() == false) goto L20;
        if (r104 < 0) goto L20;
        if (r104 >= r100.valueRange()) goto L20;
        UDButton r106 = this.f238285p;
        if (r104 <= 0) goto L15;
        boolean r107 = true;
    L16:
        r106.setEnabled(r107);
        UDButton r108 = this.f238286q;
        if (r104 >= (r100.valueRange() - 1)) goto L19;
        r105 = true;
    L19:
        r108.setEnabled(r105);
    L21:
        this.f238285p.setOnClickListener(new b(this, r100));
        this.f238286q.setOnClickListener(new c(this, r100));
        this.f238267d.setOnClickListener(null);
        return;
    L15:
        r107 = false;
    L20:
        this.f238285p.setEnabled(false);
        this.f238286q.setEnabled(false);
        goto L21
    L5:
        r103 = R.color.sheet_item_text_disable;
        goto L6
    }

    public SheetRegulatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void c(SheetItem.GroupPosition r100, boolean r101) {
        super.c(r100, false);
    }

    public final void e(SheetItem r100, boolean r101) {
        if (this.f238264a == null) goto L13;
        int r102 = r100.getCurrentIndex();
        if (r102 >= 0) goto L7;
        return;
    L7:
        if (r102 >= r100.valueRange()) goto L15;
        if (r101 == false) goto L10;
        int r103 = r102 + 1;
    L11:
        this.f238264a.a(this.f238284o, r100.valueAt(r103));
        return;
    L10:
        r103 = r102 - 1;
        goto L11
    L15:
        return;
    }

    public SheetRegulatorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
