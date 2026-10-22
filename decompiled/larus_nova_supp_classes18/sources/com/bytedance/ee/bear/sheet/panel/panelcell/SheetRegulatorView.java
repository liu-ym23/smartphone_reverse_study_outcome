package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetRegulatorView extends SheetListItemView {
    public static final /* synthetic */ int r = 0;
    public String o;
    public UDButton p;
    public UDButton q;

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void b() {
        super.b();
        findViewById(2131384188).setVisibility(0);
        this.p = findViewById(2131384189);
        this.q = findViewById(2131384187);
        f(this.p);
        f(this.q);
    }

    public SheetRegulatorView(Context r2) {
        this(r2, null);
    }

    public final void f(UDButton r5) {
        Drawable r6 = r5.getCompoundDrawablesRelative()[0];
        if (r6 == null) goto L6;
        int r0 = getContext().getResources().getDimensionPixelSize(2131168315);
        int r1 = r6.getIntrinsicWidth();
        int r2 = (r1 - r0) / 2;
        int r3 = (r6.getIntrinsicHeight() - r0) / 2;
        r6.setBounds(r2, r3, r2 + r0, r0 + r3);
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView, com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(final SheetItem r6) {
        super.update(r6);
        this.o = r6.getId();
        TextView r0 = (TextView) findViewById(2131384190);
        r0.setText(r6.getValue());
        Resources r1 = getResources();
        if (r6.isEnable() == false) goto L5;
        int r2 = 2131105858;
    L6:
        r0.setTextColor(r1.getColor(r2));
        int r3 = r6.getCurrentIndex();
        boolean r4 = false;
        if (r6.isEnable() == false) goto L20;
        if (r3 < 0) goto L20;
        if (r3 >= r6.valueRange()) goto L20;
        UDButton r5 = this.p;
        if (r3 <= 0) goto L15;
        boolean r7 = true;
    L16:
        r5.setEnabled(r7);
        UDButton r8 = this.q;
        if (r3 >= (r6.valueRange() - 1)) goto L19;
        r4 = true;
    L19:
        r8.setEnabled(r4);
    L21:
        this.p.setOnClickListener(new b(this, r6));
        this.q.setOnClickListener(new c(this, r6));
        this.d.setOnClickListener(null);
        return;
    L15:
        r7 = false;
    L20:
        this.p.setEnabled(false);
        this.q.setEnabled(false);
        goto L21
    L5:
        r2 = 2131105857;
        goto L6
    }

    public SheetRegulatorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void c(SheetItem.GroupPosition r1, boolean r2) {
        super.c(r1, false);
    }

    public final void e(SheetItem r3, boolean r4) {
        if (this.a == null) goto L13;
        int r0 = r3.getCurrentIndex();
        if (r0 >= 0) goto L7;
        return;
    L7:
        if (r0 >= r3.valueRange()) goto L15;
        if (r4 == false) goto L10;
        int r1 = r0 + 1;
    L11:
        this.a.a(this.o, r3.valueAt(r1));
        return;
    L10:
        r1 = r0 - 1;
        goto L11
    L15:
        return;
    }

    public SheetRegulatorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
