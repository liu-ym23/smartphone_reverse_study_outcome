package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public class BDMapStyleOptions {
    private boolean mEnable;
    private byte[] mStyleData;
    private byte[] mStyleDataOversea;
    private String mStyleDataOverseaPath;
    private String mStyleDataPath;
    private byte[] mStyleExtraData;
    private String mStyleExtraPath;
    private String mStyleId;
    private byte[] mStyleResData;
    private String mStyleResDataPath;
    private byte[] mStyleTextureData;
    private String mStyleTexturePath;

    public BDMapStyleOptions() {
        this.mEnable = false;
        this.mStyleId = null;
        this.mStyleDataPath = null;
        this.mStyleData = null;
        this.mStyleExtraPath = null;
        this.mStyleExtraData = null;
        this.mStyleTexturePath = null;
        this.mStyleTextureData = null;
        this.mStyleDataOverseaPath = null;
        this.mStyleDataOversea = null;
        this.mStyleResDataPath = null;
        this.mStyleResData = null;
    }

    public byte[] getStyleData() {
        return this.mStyleData;
    }

    public byte[] getStyleDataOversea() {
        return this.mStyleDataOversea;
    }

    public String getStyleDataOverseaPath() {
        return this.mStyleDataOverseaPath;
    }

    public String getStyleDataPath() {
        return this.mStyleDataPath;
    }

    public byte[] getStyleExtraData() {
        return this.mStyleExtraData;
    }

    public String getStyleExtraPath() {
        return this.mStyleExtraPath;
    }

    public String getStyleId() {
        return this.mStyleId;
    }

    public byte[] getStyleResData() {
        return this.mStyleResData;
    }

    public String getStyleResDataPath() {
        return this.mStyleResDataPath;
    }

    public byte[] getStyleTextureData() {
        return this.mStyleTextureData;
    }

    public String getStyleTexturePath() {
        return this.mStyleTexturePath;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public void setStyleData(byte[] r100) {
        this.mStyleData = r100;
    }

    public void setStyleDataOversea(byte[] r100) {
        this.mStyleDataOversea = r100;
    }

    public void setStyleDataOverseaPath(String r100) {
        this.mStyleDataOverseaPath = r100;
    }

    public void setStyleDataPath(String r100) {
        this.mStyleDataPath = r100;
    }

    public void setStyleExtraData(byte[] r100) {
        this.mStyleExtraData = r100;
    }

    public void setStyleExtraPath(String r100) {
        this.mStyleExtraPath = r100;
    }

    public void setStyleId(String r100) {
        this.mStyleId = r100;
    }

    public void setStyleResData(byte[] r100) {
        this.mStyleResData = r100;
    }

    public void setStyleResDataPath(String r100) {
        this.mStyleResDataPath = r100;
    }

    public void setStyleTextureData(byte[] r100) {
        this.mStyleTextureData = r100;
    }

    public void setStyleTexturePath(String r100) {
        this.mStyleTexturePath = r100;
    }
}
