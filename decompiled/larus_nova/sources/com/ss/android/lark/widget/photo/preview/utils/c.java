package com.ss.android.lark.widget.photo.preview.utils;

import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447153a = 0;

    static {
    }

    public static Image a(PhotoItem.PicInfo r100, boolean r101) {
        Image r102 = new Image();
        r102.setWidth(r100.width);
        r102.setHeight(r100.height);
        r102.setUrls(r100.urls);
        r102.setKey(r100.key);
        if (r101 == false) goto L5;
        r102.setType(Image.Type.ENCRYPTED);
    L6:
        return r102;
    L5:
        r102.setType(Image.Type.NORMAL);
        goto L6
    }
}
