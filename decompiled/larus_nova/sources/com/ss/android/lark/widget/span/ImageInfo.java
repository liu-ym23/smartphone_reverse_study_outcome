package com.ss.android.lark.widget.span;

import android.os.Bundle;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public class ImageInfo extends SpanInfo {
    public int bgColor;
    public BorderProperty borderProperty;
    public ByteString crypto;
    public transient Bundle extras;
    public String fsUnit;
    public boolean fullWidthMarker;
    public int height;
    public ByteString inlinePreview;
    public boolean isLargeImage;
    public int itemLeftMargin;
    public String key;
    public ResourceCleanScene resourceCleanScene;
    public String token;
    public String url;
    public int viewHeight;
    public int viewWidth;
    public int width;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.key, this.url, this.token, Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.viewWidth), Integer.valueOf(this.viewHeight), Integer.valueOf(this.bgColor), this.borderProperty, this.resourceCleanScene});
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public String toString() {
        return "ImageInfo{key='" + this.key + "', url='" + this.url + "', token='" + this.token + "', width=" + this.width + ", height=" + this.height + ", isLargeImage=" + this.isLargeImage + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + '}';
    }

    public ImageInfo() {
        this.itemLeftMargin = 0;
        this.fullWidthMarker = false;
        this.resourceCleanScene = null;
        this.extras = new Bundle();
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageInfo) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        ImageInfo r101 = (ImageInfo) r100;
        if (this.width == r101.width) goto L14;
    L34:
        return false;
    L14:
        if (this.height != r101.height) goto L34;
        if (this.viewWidth != r101.viewWidth) goto L34;
        if (this.viewHeight != r101.viewHeight) goto L34;
        if (this.isLargeImage != r101.isLargeImage) goto L34;
        if (this.bgColor != r101.bgColor) goto L34;
        if (Objects.equals(this.borderProperty, r101.borderProperty) == false) goto L34;
        if (Objects.equals(this.key, r101.key) == false) goto L34;
        if (Objects.equals(this.url, r101.url) == false) goto L34;
        if (Objects.equals(this.token, r101.token) == false) goto L34;
        if (Objects.equals(this.resourceCleanScene, r101.resourceCleanScene) == false) goto L34;
        return true;
    }
}
