package com.bytedance.ee.util.glide;

import android.text.TextUtils;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;

/* JADX INFO: loaded from: classes19.dex */
public class BearGlideUrl extends GlideUrl {
    private boolean isValid;

    public boolean isValid() {
        return this.isValid;
    }

    public BearGlideUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r101 = "isValid";
    L6:
        super(r101);
        this.isValid = true;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        this.isValid = false;
        return;
    L10:
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public BearGlideUrl(String r100, Headers r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r102 = "isValid";
    L6:
        if (r101 != null) goto L8;
        Headers r103 = new LazyHeaders.Builder().build();
    L9:
        super(r102, r103);
        this.isValid = true;
        if (TextUtils.isEmpty(r100) == true) goto L12;
        if (r101 == null) goto L12;
        return;
    L12:
        this.isValid = false;
        return;
    L8:
        r103 = r101;
        goto L9
    L5:
        r102 = r100;
        goto L6
    }
}
