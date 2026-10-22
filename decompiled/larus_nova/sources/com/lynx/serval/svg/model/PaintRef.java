package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes32.dex */
public class PaintRef {
    public static final int PAINT_COLOR = 1;
    public static final int PAINT_IRI = 2;
    public static final int PAINT_NONE = 0;
    public long mColor;
    public String mIri;
    public float mOpacity;
    public int mType;

    public PaintRef(int r100, long r101, float r102, String r103) {
        this.mType = r100;
        this.mColor = r101;
        this.mOpacity = r102;
        this.mIri = r103;
    }
}
