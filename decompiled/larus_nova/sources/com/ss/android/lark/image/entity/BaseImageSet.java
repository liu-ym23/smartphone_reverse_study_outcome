package com.ss.android.lark.image.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class BaseImageSet implements Serializable {
    protected String key;
    protected Image middle;
    protected Image origin;
    protected Image thumbnail;

    public BaseImageSet() {
    }

    public String getKey() {
        return this.key;
    }

    public Image getMiddle() {
        return this.middle;
    }

    public Image getOrigin() {
        return this.origin;
    }

    public Image getThumbnail() {
        return this.thumbnail;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setMiddle(Image r100) {
        this.middle = r100;
    }

    public void setOrigin(Image r100) {
        this.origin = r100;
    }

    public void setThumbnail(Image r100) {
        this.thumbnail = r100;
    }

    public BaseImageSet(String r100, Image r101, Image r102) {
        this.key = r100;
        this.origin = r101;
        this.thumbnail = r102;
    }
}
