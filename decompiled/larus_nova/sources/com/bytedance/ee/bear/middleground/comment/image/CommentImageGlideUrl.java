package com.bytedance.ee.bear.middleground.comment.image;

import android.text.TextUtils;
import com.bumptech.glide.load.model.GlideUrl;

/* JADX INFO: loaded from: classes18.dex */
public class CommentImageGlideUrl extends GlideUrl {
    private boolean isValid;
    private String thumbnailUrl;

    @Override // com.bumptech.glide.load.model.GlideUrl
    public String getCacheKey() {
        if (TextUtils.isEmpty(this.thumbnailUrl) == false) goto L6;
        return "";
    L6:
        return this.thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public CommentImageGlideUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r101 = "isValid";
    L6:
        super(r101);
        this.isValid = false;
        this.thumbnailUrl = r100;
        this.isValid = !TextUtils.isEmpty(r100);
        return;
    L5:
        r101 = r100;
        goto L6
    }
}
