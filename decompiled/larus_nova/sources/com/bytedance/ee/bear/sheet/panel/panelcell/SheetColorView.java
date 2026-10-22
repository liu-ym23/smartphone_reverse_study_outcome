package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SheetColorView extends SheetListItemView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f238263o;

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView
    public final void b() {
        super.b();
        View r100 = findViewById(R.id.list_item_color_icon);
        this.f238263o = r100;
        r100.setVisibility(0);
    }

    public SheetColorView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView, com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(SheetItem r100) {
        super.update(r100);
        GradientDrawable r101 = (GradientDrawable) this.f238263o.getBackground().mutate();
        r101.setColor(ColorUtils.h(r100.getValue()));
        String r102 = r100.getValue();
        int r103 = 0;
        if (r102 == null) goto L12;
        int r104 = ColorUtils.h(r102);
        boolean r105 = ColorUtils.b(getContext());
        if (ColorUtils.e(r104) == false) goto L9;
        if (r105 == false) goto L9;
    L11:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        r103 = getResources().getDimensionPixelSize(R.dimen.space_kit_len_1);
    L15:
        r101.setStroke(r103, getResources().getColor(R.color.line_border_component));
        return;
    L9:
        if (ColorUtils.g(r104) == false) goto L12;
        if (r105 == false) goto L11;
    L12:
        r106 = false;
        goto L13
    }

    public SheetColorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SheetColorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
