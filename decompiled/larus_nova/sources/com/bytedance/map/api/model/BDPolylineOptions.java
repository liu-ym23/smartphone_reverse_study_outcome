package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class BDPolylineOptions {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;
    public static final int LINE_CAP_ARROW = 2;
    public static final int LINE_CAP_BUTT = 0;
    public static final int LINE_CAP_ROUND = 3;
    public static final int LINE_CAP_SQUARE = 1;
    public static final int LINE_JOIN_BEVEL = 0;
    public static final int LINE_JOIN_MITER = 1;
    public static final int LINE_JOIN_ROUND = 2;
    private float mAlpha;
    private boolean mCollideWithPoi;
    private int mColor;
    private List<Integer> mColorList;
    private Bitmap mCustomTexture;
    private List<Bitmap> mCustomTextureList;
    private int mDottedLineType;
    private boolean mEnableReducePoint;
    private String mId;
    private boolean mIsDottedLine;
    private boolean mIsUseTexture;
    private List<BDLatLng> mLatLngs;
    private int mLineCapType;
    private int mLineJoinType;
    private List<Integer> mTextureIndexList;
    private float mWidth;
    private float mZIndex;

    public int getWidth() {
        return (int) this.mWidth;
    }

    public BDPolylineOptions() {
        this.mColor = Color.argb(255, 0, 0, 0);
        this.mWidth = 10.0f;
        this.mIsDottedLine = false;
        this.mEnableReducePoint = true;
        this.mCollideWithPoi = false;
        this.mAlpha = 1.0f;
        this.mZIndex = 0.0f;
        this.mIsUseTexture = false;
        this.mLineCapType = 3;
        this.mLineJoinType = 0;
        this.mDottedLineType = 0;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<Integer> getColorList() {
        return this.mColorList;
    }

    public Bitmap getCustomTexture() {
        return this.mCustomTexture;
    }

    public List<Bitmap> getCustomTextureList() {
        return this.mCustomTextureList;
    }

    public int getDottedLineType() {
        return this.mDottedLineType;
    }

    public boolean getEnableReducePoint() {
        return this.mEnableReducePoint;
    }

    public String getId() {
        return this.mId;
    }

    public List<BDLatLng> getLatLngs() {
        return this.mLatLngs;
    }

    public int getLineCapType() {
        return this.mLineCapType;
    }

    public int getLineJoinType() {
        return this.mLineJoinType;
    }

    public List<Integer> getTextureIndexList() {
        return this.mTextureIndexList;
    }

    public float getWidthFloat() {
        return this.mWidth;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isCollideWithPoi() {
        return this.mCollideWithPoi;
    }

    public boolean isDottedLine() {
        return this.mIsDottedLine;
    }

    public boolean isUseTexture() {
        return this.mIsUseTexture;
    }

    public void setAlpha(float r100) {
        this.mAlpha = r100;
    }

    public void setCollideWithPoi(boolean r100) {
        this.mCollideWithPoi = r100;
    }

    public void setColor(int r100) {
        this.mColor = r100;
    }

    public void setColorList(List<Integer> r100) {
        this.mColorList = r100;
    }

    public void setCustomTexture(Bitmap r100) {
        this.mCustomTexture = r100;
        if (r100 == null) goto L6;
        this.mIsUseTexture = true;
        return;
    }

    public void setCustomTextureList(List<Bitmap> r100) {
        this.mCustomTextureList = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L9;
        this.mIsUseTexture = true;
        return;
    }

    public void setDottedLine(boolean r100) {
        this.mIsDottedLine = r100;
    }

    public void setDottedLineType(int r100) {
        this.mDottedLineType = r100;
    }

    public void setEnableReducePoint(boolean r100) {
        this.mEnableReducePoint = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setLatLngs(List<BDLatLng> r100) {
        this.mLatLngs = r100;
    }

    public void setLineCapType(int r100) {
        this.mLineCapType = r100;
    }

    public void setLineJoinType(int r100) {
        this.mLineJoinType = r100;
    }

    public void setTextureIndexList(List<Integer> r100) {
        this.mTextureIndexList = r100;
    }

    public void setUseTexture(boolean r100) {
        this.mIsUseTexture = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }

    public void setWidthFloat(float r100) {
        this.mWidth = r100;
    }

    public void setZIndex(float r100) {
        this.mZIndex = r100;
    }

    public BDPolylineOptions(String r110, List<BDLatLng> r111, int r112, int r113, float r114, boolean r115, float r116, Bitmap r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, 3, 0);
    }

    public BDPolylineOptions(String r100, List<BDLatLng> r101, int r102, int r103, float r104, boolean r105, float r106, Bitmap r110, int r111, int r112) {
        Color.argb(255, 0, 0, 0);
        this.mEnableReducePoint = true;
        this.mCollideWithPoi = false;
        this.mIsUseTexture = false;
        this.mDottedLineType = 0;
        this.mId = r100;
        this.mLatLngs = r101;
        this.mWidth = r102;
        this.mColor = r103;
        this.mAlpha = r104;
        this.mIsDottedLine = r105;
        this.mZIndex = r106;
        this.mLineCapType = r111;
        this.mLineJoinType = r112;
        if (r110 == null) goto L6;
        this.mCustomTexture = r110;
        this.mIsUseTexture = true;
        return;
    }
}
