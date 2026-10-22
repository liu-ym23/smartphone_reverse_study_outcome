package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: classes32.dex */
public class CustomizedMessage {
    private String mData;
    private int mMark;
    private String mType;

    public String getData() {
        return this.mData;
    }

    public int getMark() {
        return this.mMark;
    }

    public String getType() {
        return this.mType;
    }

    public void setData(String r100) {
        this.mData = r100;
    }

    public void setMark(int r100) {
        this.mMark = r100;
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public CustomizedMessage(String r100, String r101) {
        this(r100, r101, -1);
    }

    public CustomizedMessage(String r100, String r101, int r102) {
        this.mType = r100;
        this.mData = r101;
        this.mMark = r102;
    }
}
