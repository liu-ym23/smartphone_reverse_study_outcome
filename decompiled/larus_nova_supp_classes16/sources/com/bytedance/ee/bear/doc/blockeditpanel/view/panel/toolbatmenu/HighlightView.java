package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.f;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.util.ui.n;
import dy4.a;
import iy4.b;
import iy4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HighlightView extends LinearLayout {
    public final ImageView a;
    public final ImageView b;
    public final FrameLayout c;
    public a d;

    public HighlightView(Context r2) {
        this(r2, null);
    }

    public void setIconWidth(int r2) {
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        r0.width = r2;
        this.c.setLayoutParams(r0);
    }

    public void setMenuItem(final BlockEditPanelMenusModel.BlockEditPanelMenuItem r7) {
        EMenuItemConfig r0 = EMenuItemConfig.getMenuItemConfigById(r7.getId());
        int r1 = r0.imageRes;
        if (r1 == (-1)) goto L5;
        this.a.setImageResource(r1);
    L8:
        int r2 = r0.bgRes;
        if (r2 == (-1)) goto L11;
        this.c.setBackgroundResource(r2);
    L11:
        this.c.setEnabled(r7.isEnable());
        this.c.setSelected(r7.isSelected());
        this.b.setEnabled(r7.isEnable());
        this.b.setSelected(r7.isSelected());
        ImageView r3 = this.a;
        float r4 = 0.5f;
        if (r7.isEnable() == false) goto L14;
        float r5 = 1.0f;
    L15:
        r3.setAlpha(r5);
        ImageView r6 = this.b;
        if (r7.isEnable() == false) goto L18;
        r4 = 1.0f;
    L18:
        r6.setAlpha(r4);
        Highlight.ColorRgba r8 = r7.getBackgroundColor();
        if (r8 == null) goto L21;
        int r9 = Color.argb((int) (r8.getA() * 255.0f), r8.getR(), r8.getG(), r8.getB());
        this.a.setBackgroundTintList(ColorStateList.valueOf(r9));
    L21:
        Highlight.ColorRgba r10 = r7.getForegroundColor();
        if (r10 == null) goto L24;
        int r11 = Color.argb((int) (r10.getA() * 255.0f), r10.getR(), r10.getG(), r10.getB());
        this.a.setImageTintList(ColorStateList.valueOf(r11));
    L24:
        f.f(this.c, r0.iconStateColorList);
        f.f(this.b, r0.backgroundStateColorList);
        this.c.setOnClickListener(new b(this, r7));
        this.b.setOnClickListener(new c(this, r7));
        return;
    L14:
        r5 = 0.5f;
        goto L15
    L5:
        Drawable r12 = r0.getImageDrawable(this.a.getContext(), n.d(28));
        if (r12 == null) goto L8;
        this.a.setImageDrawable(r12);
        goto L8
    }

    public void setOnClickHighlightItemListener(a r1) {
        this.d = r1;
    }

    public HighlightView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public HighlightView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(2131560069, this);
        this.a = (ImageView) findViewById(2131376664);
        this.b = (ImageView) findViewById(2131375994);
        this.c = (FrameLayout) findViewById(2131372866);
    }
}
