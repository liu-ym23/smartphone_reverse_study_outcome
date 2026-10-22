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
import com.larus.nova.R;
import dy4.a;
import iy4.b;
import iy4.c;

/* JADX INFO: loaded from: classes16.dex */
public class HighlightView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f217725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f217726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f217727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f217728d;

    public HighlightView(Context r100) {
        this(r100, null);
    }

    public void setIconWidth(int r100) {
        ViewGroup.LayoutParams r101 = this.f217727c.getLayoutParams();
        r101.width = r100;
        this.f217727c.setLayoutParams(r101);
    }

    public void setMenuItem(final BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
        EMenuItemConfig r101 = EMenuItemConfig.getMenuItemConfigById(r100.getId());
        int r102 = r101.imageRes;
        if (r102 == (-1)) goto L5;
        this.f217725a.setImageResource(r102);
    L8:
        int r103 = r101.bgRes;
        if (r103 == (-1)) goto L11;
        this.f217727c.setBackgroundResource(r103);
    L11:
        this.f217727c.setEnabled(r100.isEnable());
        this.f217727c.setSelected(r100.isSelected());
        this.f217726b.setEnabled(r100.isEnable());
        this.f217726b.setSelected(r100.isSelected());
        ImageView r104 = this.f217725a;
        float r105 = 0.5f;
        if (r100.isEnable() == false) goto L14;
        float r106 = 1.0f;
    L15:
        r104.setAlpha(r106);
        ImageView r107 = this.f217726b;
        if (r100.isEnable() == false) goto L18;
        r105 = 1.0f;
    L18:
        r107.setAlpha(r105);
        Highlight.ColorRgba r108 = r100.getBackgroundColor();
        if (r108 == null) goto L21;
        int r109 = Color.argb((int) (r108.getA() * 255.0f), r108.getR(), r108.getG(), r108.getB());
        this.f217725a.setBackgroundTintList(ColorStateList.valueOf(r109));
    L21:
        Highlight.ColorRgba r110 = r100.getForegroundColor();
        if (r110 == null) goto L24;
        int r111 = Color.argb((int) (r110.getA() * 255.0f), r110.getR(), r110.getG(), r110.getB());
        this.f217725a.setImageTintList(ColorStateList.valueOf(r111));
    L24:
        f.f(this.f217727c, r101.iconStateColorList);
        f.f(this.f217726b, r101.backgroundStateColorList);
        this.f217727c.setOnClickListener(new b(this, r100));
        this.f217726b.setOnClickListener(new c(this, r100));
        return;
    L14:
        r106 = 0.5f;
        goto L15
    L5:
        Drawable r112 = r101.getImageDrawable(this.f217725a.getContext(), n.d(28));
        if (r112 == null) goto L8;
        this.f217725a.setImageDrawable(r112);
        goto L8
    }

    public void setOnClickHighlightItemListener(a r100) {
        this.f217728d = r100;
    }

    public HighlightView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public HighlightView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.doc_block_edit_panel_menu_item_highlight, this);
        this.f217725a = (ImageView) findViewById(R.id.iv_text_highlight);
        this.f217726b = (ImageView) findViewById(R.id.iv_arrow);
        this.f217727c = (FrameLayout) findViewById(R.id.fl_text_highlight);
    }
}
