package com.bytedance.map.api.model;

import android.graphics.Typeface;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class BDTextPathOptions {
    private String mId;
    private List<BDLatLng> mPoints;
    private String mText;
    private int mTextBorderColor;
    private int mTextBorderWidth;
    private int mTextColor;
    private int mTextSize;
    private Typeface mTypeface;
    private float mZIndex;

    public BDTextPathOptions() {
        this.mTextColor = -16777216;
        this.mTextBorderColor = -16777216;
        this.mTextBorderWidth = 0;
        this.mTextSize = 12;
    }

    public String getId() {
        return this.mId;
    }

    public List<BDLatLng> getPoints() {
        return this.mPoints;
    }

    public String getText() {
        return this.mText;
    }

    public int getTextBorderColor() {
        return this.mTextBorderColor;
    }

    public int getTextBorderWidth() {
        return this.mTextBorderWidth;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public BDTextPathOptions points(List<BDLatLng> r100) {
        this.mPoints = r100;
        return this;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public BDTextPathOptions text(String r100) {
        this.mText = r100;
        return this;
    }

    public BDTextPathOptions textBorderColor(int r100) {
        this.mTextBorderColor = r100;
        return this;
    }

    public BDTextPathOptions textBorderWidth(int r100) {
        this.mTextBorderWidth = r100;
        return this;
    }

    public BDTextPathOptions textColor(int r100) {
        this.mTextColor = r100;
        return this;
    }

    public BDTextPathOptions textSize(int r100) {
        this.mTextSize = r100;
        return this;
    }

    public BDTextPathOptions typeface(Typeface r100) {
        this.mTypeface = r100;
        return this;
    }

    public BDTextPathOptions zIndex(float r100) {
        this.mZIndex = r100;
        return this;
    }
}
