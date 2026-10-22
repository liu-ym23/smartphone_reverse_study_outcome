package com.bytedance.ee.bear.middleground.comment.image;

import android.text.TextUtils;
import com.bumptech.glide.load.model.GlideUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentImageGlideUrl extends GlideUrl {
    private boolean isValid;
    private String thumbnailUrl;

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

    public CommentImageGlideUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        String r0 = "isValid";
    L6:
        super(r0);
        this.isValid = false;
        this.thumbnailUrl = r2;
        this.isValid = !TextUtils.isEmpty(r2);
        return;
    L5:
        r0 = r2;
        goto L6
    }
}
