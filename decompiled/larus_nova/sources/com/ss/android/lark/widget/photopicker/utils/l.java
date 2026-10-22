package com.ss.android.lark.widget.photopicker.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class l {
    public static String a(PhotoItem r100) {
        String r101 = r100.getOriginPicInfo().key;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = r100.getImageKey();
    L5:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public static List<PhotoItem> b(List<? extends ImageSet> r100) {
        return com.ss.android.lark.widget.photo.preview.utils.d.b(r100, "");
    }
}
