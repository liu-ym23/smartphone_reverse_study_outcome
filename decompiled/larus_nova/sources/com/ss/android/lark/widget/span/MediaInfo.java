package com.ss.android.lark.widget.span;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class MediaInfo extends SpanInfo {
    public BorderProperty borderProperty;
    public String cryptoToken;
    public String duration;
    public int durationMills;
    public int height;
    public String key;
    public int left;
    public transient Drawable mediaThumbnail;
    public String mimeType;
    public ImageInfo originImageInfo;
    public String originPath;
    public ResourceCleanScene resourceCleanScene;
    public int top;
    public String url;
    public int width;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.width), Integer.valueOf(this.height), this.borderProperty, this.duration, this.url, this.originPath, this.originImageInfo, Integer.valueOf(this.durationMills), this.mimeType, this.cryptoToken, this.resourceCleanScene});
    }

    public MediaInfo() {
        this.resourceCleanScene = null;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L44:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L44;
        if (super.equals(r100) == true) goto L13;
        return false;
    L13:
        MediaInfo r101 = (MediaInfo) r100;
        if (this.width == r101.width) goto L16;
    L42:
        return false;
    L16:
        if (this.height != r101.height) goto L42;
        if (this.left != r101.left) goto L42;
        if (this.top != r101.top) goto L42;
        if (Objects.equals(this.mediaThumbnail, r101.mediaThumbnail) == false) goto L42;
        if (Objects.equals(this.borderProperty, r101.borderProperty) == false) goto L42;
        if (TextUtils.equals(this.duration, r101.duration) == false) goto L42;
        if (TextUtils.equals(this.url, r101.url) == false) goto L42;
        if (TextUtils.equals(this.originPath, r101.originPath) == false) goto L42;
        if (Objects.equals(this.originImageInfo, r101.originImageInfo) == false) goto L42;
        if (Objects.equals(Integer.valueOf(this.durationMills), Integer.valueOf(r101.durationMills)) == false) goto L42;
        if (Objects.equals(this.mimeType, r101.mimeType) == false) goto L42;
        if (Objects.equals(this.cryptoToken, r101.cryptoToken) == false) goto L42;
        if (Objects.equals(this.resourceCleanScene, r101.resourceCleanScene) == false) goto L42;
        return true;
    }
}
