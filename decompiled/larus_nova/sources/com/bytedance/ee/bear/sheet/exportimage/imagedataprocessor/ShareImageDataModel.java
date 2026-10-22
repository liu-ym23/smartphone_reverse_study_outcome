package com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ShareImageDataModel implements NonProguard {
    private int belongToCol;
    private int belongToRow;
    private int height;
    private String img;
    private boolean isLast;
    private boolean isLastInRow;
    private int width;

    public ShareImageDataModel() {
    }

    public String toString() {
        return "ShareImageDataModel{, isLast=" + this.isLast + ", width=" + this.width + ", height=" + this.height + ", belongToRow=" + this.belongToRow + ", belongToCol=" + this.belongToCol + ", isLastInRow=" + this.isLastInRow + '}';
    }

    public int getBelongToCol() {
        return this.belongToCol;
    }

    public int getBelongToRow() {
        return this.belongToRow;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImg() {
        return this.img;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isLastInRow() {
        return this.isLastInRow;
    }

    public void setBelongToCol(int r100) {
        this.belongToCol = r100;
    }

    public void setBelongToRow(int r100) {
        this.belongToRow = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setImg(String r100) {
        this.img = r100;
    }

    public void setLast(boolean r100) {
        this.isLast = r100;
    }

    public void setLastInRow(boolean r100) {
        this.isLastInRow = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
