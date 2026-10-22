package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SegmentStyle implements NonProguard, Cloneable {
    public static final String FONT_STYLE_ITALIC = "italic";
    public static final String FONT_STYLE_NORMAL = "normal";
    public static final int FONT_WEIGHT_BOLD = 700;
    public static final int FONT_WEIGHT_NORMAL = 400;
    public static final String LINE_THROUGH = "line-through";
    public static final String UNDERLINE = "underline";
    private String color;
    private String fontFamily;
    private int fontSize;
    private String fontStyle;
    private int fontWeight;
    private String textDecoration;

    public SegmentStyle() {
    }

    public SegmentStyle clone() throws CloneNotSupportedException {
        return (SegmentStyle) super.clone();
    }

    public String getColor() {
        return this.color;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }

    public int getFontWeight() {
        return this.fontWeight;
    }

    public String getTextDecoration() {
        return this.textDecoration;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8331clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setColor(String r100) {
        this.color = r100;
    }

    public void setFontFamily(String r100) {
        this.fontFamily = r100;
    }

    public void setFontSize(int r100) {
        this.fontSize = r100;
    }

    public void setFontStyle(String r100) {
        this.fontStyle = r100;
    }

    public void setFontWeight(int r100) {
        this.fontWeight = r100;
    }

    public void setTextDecoration(String r100) {
        this.textDecoration = r100;
    }
}
