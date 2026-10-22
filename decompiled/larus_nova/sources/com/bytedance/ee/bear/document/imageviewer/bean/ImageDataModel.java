package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;

/* JADX INFO: loaded from: classes16.dex */
public class ImageDataModel extends ImageData {
    private String from;
    private String source;

    @Override // com.bytedance.ee.bear.contract.imageviewer.bean.ImageData
    public String toString() {
        return "ImageDataModel{toolStatus=" + this.toolStatus + ", image=" + this.image + ", imageList=" + this.imageList + ", source=" + this.source + '}';
    }

    public ImageDataModel() {
    }

    public String getFrom() {
        return this.from;
    }

    public String getSource() {
        return this.source;
    }

    public void setFrom(String r100) {
        this.from = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }
}
