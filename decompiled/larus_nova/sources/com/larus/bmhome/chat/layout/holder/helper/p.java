package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.im.bean.message.ImageObj;

/* JADX INFO: loaded from: classes25.dex */
public final class p {
    public static final ImageEntity a(ImageObj r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new ImageEntity(r100.url, r100.getHeicUrl(), r100.width, r100.height, null, 16, null);
    }

    public static final CoverImageEntity b(ImageObj r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new CoverImageEntity(r100.url, r100.getHeicUrl(), r100.width, r100.height);
    }
}
