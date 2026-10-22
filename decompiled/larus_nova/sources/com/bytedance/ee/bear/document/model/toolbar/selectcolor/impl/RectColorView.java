package com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemButtonType;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class RectColorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f220282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f220283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f220284c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RectColorType {
        public static final String TYPE_BACKGROUND = "background";
        public static final String TYPE_CLEAR = "clear";
        public static final String TYPE_TEXT = "text";
    }

    public RectColorView(Context r100) {
        this(r100, null);
    }

    public final int a(Highlight.ColorRgba r100) {
        int r101 = getResources().getColor(R.color.lkui_transparent);
        if (r100 != null) goto L10;
        return r101;
    L10:
        return Color.rgb(r100.getR(), r100.getG(), r100.getB());
    L7:
        th = move-exception;
        a.f("RectColorView", th, false);
        return r101;
    }

    public RectColorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RectColorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f220282a = r100;
        LayoutInflater.from(r100).inflate(R.layout.rect_color_view, this);
        this.f220283b = (FrameLayout) findViewById(R.id.rect_layout);
        this.f220284c = (ImageView) findViewById(R.id.text);
    }

    public final void b(String r100, Highlight.ColorItem r101, float[] r102) {
        Highlight.ColorRgba r103 = r101.getValue();
        boolean r104 = r101.isShowFontIcon();
        ColorDrawable r105 = new ColorDrawable(getResources().getColor(R.color.lkui_transparent));
        if ("clear".equals(r100) == false) goto L6;
        this.f220283b.setBackground(r105);
        return;
    L6:
        if ("text".equals(r100) == false) goto L9;
        this.f220284c.setColorFilter(a(r103));
        this.f220284c.getDrawable().setAlpha((int) (r103.getA() * 255.0f));
        this.f220283b.setBackground(lp5.a.c(UDColorUtils.getColor(this.f220282a, R.color.bg_body_overlay), r102));
        return;
    L9:
        if ("background".equals(r100) == false) goto L22;
        Drawable r106 = lp5.a.c(a(r103), r102).mutate();
        r106.setAlpha((int) (r103.getA() * 255.0f));
        if (EMenuItemButtonType.COLOR_CLEAR_BACKGROUND.name().equals(r101.getKey()) == false) goto L13;
        this.f220283b.setBackgroundResource(R.drawable.doc_rect_color_clear);
    L14:
        ImageView r107 = this.f220284c;
        if (r104 == false) goto L17;
        int r108 = 0;
    L18:
        r107.setVisibility(r108);
        this.f220284c.setColorFilter(getResources().getColor(R.color.icon_n1));
        return;
    L17:
        r108 = 8;
        goto L18
    L13:
        this.f220283b.setBackground(r106);
        goto L14
    }
}
