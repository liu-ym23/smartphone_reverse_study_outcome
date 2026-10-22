package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.ui.ColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetColorView extends SheetListItemView {
    public View o;

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void b() {
        super.b();
        View r0 = findViewById(2131378132);
        this.o = r0;
        r0.setVisibility(0);
    }

    public SheetColorView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView, com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(SheetItem r5) {
        super.update(r5);
        GradientDrawable r0 = (GradientDrawable) this.o.getBackground().mutate();
        r0.setColor(ColorUtils.h(r5.getValue()));
        String r6 = r5.getValue();
        int r1 = 0;
        if (r6 == null) goto L12;
        int r7 = ColorUtils.h(r6);
        boolean r2 = ColorUtils.b(getContext());
        if (ColorUtils.e(r7) == false) goto L9;
        if (r2 == false) goto L9;
    L11:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        r1 = getResources().getDimensionPixelSize(2131168297);
    L15:
        r0.setStroke(r1, getResources().getColor(2131103352));
        return;
    L9:
        if (ColorUtils.g(r7) == false) goto L12;
        if (r2 == false) goto L11;
    L12:
        r8 = false;
        goto L13
    }

    public SheetColorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SheetColorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
