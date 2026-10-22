package com.ss.android.lark.biz.im.api;

import com.alibaba.fastjson.annotation.JSONType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
@JSONType(typeName = "StickerContent")
public class StickerContent implements Serializable, y28.b<StickerContent> {
    private int height;
    private boolean isAdded;
    private String key;
    private int width;

    public boolean isContentSame(StickerContent r100) {
        return true;
    }

    public StickerContent() {
    }

    public int getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAdded() {
        return this.isAdded;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.getClass() == StickerContent.class) goto L10;
        return false;
    L10:
        return this.key.equals(((StickerContent) r100).getKey());
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((StickerContent) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((StickerContent) r100);
    }

    public void setAdded(boolean r100) {
        this.isAdded = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public boolean isItemSame(StickerContent r100) {
        return equals(r100);
    }

    public StickerContent(String r100, int r101, int r102) {
        this.key = r100;
        this.width = r101;
        this.height = r102;
    }
}
