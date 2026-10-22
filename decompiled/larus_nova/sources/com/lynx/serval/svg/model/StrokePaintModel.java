package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes32.dex */
public class StrokePaintModel extends PaintRef {
    public float[] mStrokeDashArray;
    public float mStrokeDashOffset;
    public int mStrokeLineCap;
    public int mStrokeLineJoin;
    public float mStrokeMiterLimit;
    public int mVectorEffect;
    public float mWith;

    public StrokePaintModel(int r100, String r101, long r110, float r111, float r112, int r113, int r114, float r115, float r116, float[] r117, int r118) {
        super(r100, r110, r112, r101);
        this.mWith = r111;
        this.mStrokeLineCap = r113;
        this.mStrokeLineJoin = r114;
        this.mStrokeMiterLimit = r115;
        this.mStrokeDashOffset = r116;
        this.mStrokeDashArray = r117;
        this.mVectorEffect = r118;
    }
}
