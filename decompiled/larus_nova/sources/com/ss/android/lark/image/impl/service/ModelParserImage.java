package com.ss.android.lark.image.impl.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public class ModelParserImage {
    private static boolean isThumbnailWepEnable;

    static {
        isThumbnailWepEnable = FeatureGatingModule.getFeatureGatingService().isEnable("lark.chat.thumbnail.webp.enable");
    }

    public static Image getImage(com.bytedance.lark.pb.basic.v1.Image r100) {
        Image r101 = new Image();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.setKey(r100.key);
        if (r100.exif_orientation.intValue() < 5) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        Integer r103 = r100.height;
    L12:
        r101.setWidth(r103.intValue());
        if (r102 == false) goto L15;
        Integer r104 = r100.width;
    L16:
        r101.setHeight(r104.intValue());
        r101.setUrls(new ArrayList(r100.urls));
        r101.setType(Image.Type.forNumber(r100.type.getValue()));
        r101.setCrypto(r100.crypto);
        r101.setFsUnit(r100.fs_unit);
        return r101;
    L15:
        r104 = r100.height;
        goto L16
    L11:
        r103 = r100.width;
        goto L12
    L8:
        r102 = false;
        goto L9
    }

    public static ByteString getInlinePreviewFromPb(ImageSet r100) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.picture.placeholder.push") == true) goto L5;
        return null;
    L5:
        if (r100 == null) goto L13;
        ByteString r101 = r100.inline_preview;
        if (r101 == null) goto L13;
        if (r101.size() == 0) goto L13;
        return r100.inline_preview;
    L13:
        return null;
    }

    public static Image getMiddleFromPb(ImageSet r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (isThumbnailWepEnable == false) goto L14;
        com.bytedance.lark.pb.basic.v1.Image r101 = r100.middle_webp;
        if (r101 == null) goto L14;
        if (TextUtils.isEmpty(r101.key) == true) goto L14;
        return getImage(r100.middle_webp);
    L14:
        return getImage(r100.middle);
    }

    public static Image getThumbnailFromPb(ImageSet r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (isThumbnailWepEnable == false) goto L14;
        com.bytedance.lark.pb.basic.v1.Image r101 = r100.thumbnail_webp;
        if (r101 == null) goto L14;
        if (TextUtils.isEmpty(r101.key) == true) goto L14;
        return getImage(r100.thumbnail_webp);
    L14:
        return getImage(r100.thumbnail);
    }
}
