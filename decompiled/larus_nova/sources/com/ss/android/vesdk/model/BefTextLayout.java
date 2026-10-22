package com.ss.android.vesdk.model;

import com.ss.android.ttve.nativePort.e;

/* JADX INFO: loaded from: classes40.dex */
public class BefTextLayout {
    long backColor;
    int charSize;
    String familyName;
    boolean isPlaceholder;
    int letterSpacing;
    int lineCount;
    float lineHeight;
    int lineWidth;
    int split;
    int textAlign;
    long textColor;
    int textIndent;

    public BefTextLayout() {
    }

    public String toString() {
        return "BefTextLayout{charSize=" + this.charSize + ", letterSpacing=" + this.letterSpacing + ", lineWidth=" + this.lineWidth + ", lineHeight=" + this.lineHeight + ", textAlign=" + this.textAlign + ", textIndent=" + this.textIndent + ", split=" + this.split + ", lineCount=" + this.lineCount + ", familyName='" + this.familyName + "', textColor=" + this.textColor + ", backColor=" + this.backColor + ", isPlaceholder=" + this.isPlaceholder + '}';
    }

    public long getBackColor() {
        return this.backColor;
    }

    public int getCharSize() {
        return this.charSize;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getLetterSpacing() {
        return this.letterSpacing;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public float getLineHeight() {
        return this.lineHeight;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public int getSplit() {
        return this.split;
    }

    public int getTextAlign() {
        return this.textAlign;
    }

    public long getTextColor() {
        return this.textColor;
    }

    public int getTextIndent() {
        return this.textIndent;
    }

    public boolean isPlaceholder() {
        return this.isPlaceholder;
    }

    public static BefTextLayout readFromByteArray(byte[][] r100) {
        e r101 = new e(r100[0]);
        BefTextLayout r102 = new BefTextLayout();
        r102.setBackColor(r101.e().longValue());
        r102.setCharSize(r101.c());
        r102.setFamilyName(r101.f());
        r102.setLetterSpacing(r101.c());
        r102.setLineCount(r101.c());
        r102.setLineHeight(r101.c());
        r102.setLineWidth(r101.c());
        r102.setPlaceholder(r101.a());
        r102.setSplit(r101.c());
        r102.setTextAlign(r101.c());
        r102.setTextColor(r101.e().longValue());
        r102.setTextIndent(r101.c());
        return r102;
    }

    public void setBackColor(long r100) {
        this.backColor = r100;
    }

    public void setCharSize(int r100) {
        this.charSize = r100;
    }

    public void setFamilyName(String r100) {
        this.familyName = r100;
    }

    public void setLetterSpacing(int r100) {
        this.letterSpacing = r100;
    }

    public void setLineCount(int r100) {
        this.lineCount = r100;
    }

    public void setLineHeight(float r100) {
        this.lineHeight = r100;
    }

    public void setLineWidth(int r100) {
        this.lineWidth = r100;
    }

    public void setPlaceholder(boolean r100) {
        this.isPlaceholder = r100;
    }

    public void setSplit(int r100) {
        this.split = r100;
    }

    public void setTextAlign(int r100) {
        this.textAlign = r100;
    }

    public void setTextColor(long r100) {
        this.textColor = r100;
    }

    public void setTextIndent(int r100) {
        this.textIndent = r100;
    }
}
