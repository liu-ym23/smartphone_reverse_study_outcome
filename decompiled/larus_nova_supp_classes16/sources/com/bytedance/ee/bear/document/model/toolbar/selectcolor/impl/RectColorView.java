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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RectColorView extends FrameLayout {
    public final Context a;
    public FrameLayout b;
    public ImageView c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RectColorType {
        public static final String TYPE_BACKGROUND = "background";
        public static final String TYPE_CLEAR = "clear";
        public static final String TYPE_TEXT = "text";
    }

    public RectColorView(Context r2) {
        this(r2, null);
    }

    public final int a(Highlight.ColorRgba r4) {
        int r0 = getResources().getColor(2131103546);
        if (r4 != null) goto L10;
        return r0;
    L10:
        return Color.rgb(r4.getR(), r4.getG(), r4.getB());
    L7:
        th = move-exception;
        a.f("RectColorView", th, false);
        return r0;
    }

    public RectColorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RectColorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = r1;
        LayoutInflater.from(r1).inflate(2131564275, this);
        this.b = (FrameLayout) findViewById(2131384063);
        this.c = (ImageView) findViewById(2131388367);
    }

    public final void b(String r6, Highlight.ColorItem r7, float[] r8) {
        Highlight.ColorRgba r0 = r7.getValue();
        boolean r1 = r7.isShowFontIcon();
        ColorDrawable r2 = new ColorDrawable(getResources().getColor(2131103546));
        if (RectColorType.TYPE_CLEAR.equals(r6) == false) goto L6;
        this.b.setBackground(r2);
        return;
    L6:
        if ("text".equals(r6) == false) goto L9;
        this.c.setColorFilter(a(r0));
        this.c.getDrawable().setAlpha((int) (r0.getA() * 255.0f));
        this.b.setBackground(lp5.a.c(UDColorUtils.getColor(this.a, 2131100549), r8));
        return;
    L9:
        if (RectColorType.TYPE_BACKGROUND.equals(r6) == false) goto L22;
        Drawable r9 = lp5.a.c(a(r0), r8).mutate();
        r9.setAlpha((int) (r0.getA() * 255.0f));
        if (EMenuItemButtonType.COLOR_CLEAR_BACKGROUND.name().equals(r7.getKey()) == false) goto L13;
        this.b.setBackgroundResource(2131233853);
    L14:
        ImageView r10 = this.c;
        if (r1 == false) goto L17;
        int r11 = 0;
    L18:
        r10.setVisibility(r11);
        this.c.setColorFilter(getResources().getColor(2131102418));
        return;
    L17:
        r11 = 8;
        goto L18
    L13:
        this.b.setBackground(r9);
        goto L14
    }
}
