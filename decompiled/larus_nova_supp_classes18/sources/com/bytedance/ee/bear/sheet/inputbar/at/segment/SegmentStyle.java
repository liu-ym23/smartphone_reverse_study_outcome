package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public /* bridge */ /* synthetic */ Object m525clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setColor(String r1) {
        this.color = r1;
    }

    public void setFontFamily(String r1) {
        this.fontFamily = r1;
    }

    public void setFontSize(int r1) {
        this.fontSize = r1;
    }

    public void setFontStyle(String r1) {
        this.fontStyle = r1;
    }

    public void setFontWeight(int r1) {
        this.fontWeight = r1;
    }

    public void setTextDecoration(String r1) {
        this.textDecoration = r1;
    }
}
