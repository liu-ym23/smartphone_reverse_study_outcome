package com.ss.android.ugc.aweme.shortvideo.sticker;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.sticker.model.FaceStickerBean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class CoreStickerUtil {
    public static boolean a(FaceStickerBean r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getSdkExtra()) == true) goto L18;
        String r101 = r100.getSdkExtra();
        if (TextUtils.isEmpty(r101) == true) goto L19;
        return "effectControlGame".equals(new JSONObject(r101).optString("type"));
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        return false;
    L18:
        return false;
    }
}
