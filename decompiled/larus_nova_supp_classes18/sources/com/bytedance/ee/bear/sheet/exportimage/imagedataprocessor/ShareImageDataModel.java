package com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setBelongToCol(int r1) {
        this.belongToCol = r1;
    }

    public void setBelongToRow(int r1) {
        this.belongToRow = r1;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setImg(String r1) {
        this.img = r1;
    }

    public void setLast(boolean r1) {
        this.isLast = r1;
    }

    public void setLastInRow(boolean r1) {
        this.isLastInRow = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
