package com.ss.android.lark.widget.photopicker.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.service.TranslateImageService;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes38.dex */
public final class n {
    public static String a(PhotoItem r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        PhotoItem.PicInfo r101 = r100.getOriginPicInfo();
        if (r101 != null) goto L8;
        return "";
    L8:
        String r102 = r101.key;
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r102 = r100.getImageKey();
    L12:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return "";
    L15:
        return r102.replace("origin:", "").replace("thumbnail:", "").replace("middle:", "");
    }

    public static Image c(com.bytedance.lark.pb.basic.v1.Image r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = new Image();
        r101.setKey(r100.key);
        r101.setWidth(r100.width.intValue());
        r101.setHeight(r100.height.intValue());
        r101.setUrls(new ArrayList(r100.urls));
        r101.setType(Image.Type.forNumber(r100.type.getValue()));
        r101.setFsUnit(r100.fs_unit);
        r101.setCrypto(r100.crypto);
        return r101;
    }

    public static ImageSet d(com.bytedance.lark.pb.basic.v1.ImageSet r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ImageSet r101 = new ImageSet();
        r101.setKey(r100.key);
        r101.setOrigin(c(r100.origin));
        r101.setThumbnail(c(r100.thumbnail));
        r101.setMiddle(c(r100.middle));
        r101.setInlinePreview(com.ss.android.lark.widget.photopicker.f.a().x());
        return r101;
    }

    public static PhotoItem b(ImageSet r100, boolean r101) {
        PhotoItem r102 = (PhotoItem) ListProtector.get(l.b(Collections.singletonList(r100)), 0);
        if (r101 == false) goto L5;
        TranslateImageService.INSTANCE.detectCanTranslate(r102);
    L5:
        return r102;
    }
}
