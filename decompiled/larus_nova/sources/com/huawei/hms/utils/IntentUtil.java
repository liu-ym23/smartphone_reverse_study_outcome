package com.huawei.hms.utils;

import android.content.Intent;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes23.dex */
public class IntentUtil {
    public IntentUtil() {
    }

    public static Intent modifyIntentBehaviorsSafe(Intent r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getAction();
        if ("android.intent.action.SEND".equals(r101) == false) goto L8;
    L15:
        r100.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
    L16:
        r100.setFlags((((r100.getFlags() & (-129)) & (-65)) & (-2)) & (-3));
        return r100;
    L8:
        if ("android.intent.action.SEND_MULTIPLE".equals(r101) == true) goto L15;
        if ("android.media.action.IMAGE_CAPTURE".equals(r101) == true) goto L15;
        if ("android.media.action.IMAGE_CAPTURE_SECURE".equals(r101) == true) goto L15;
        if ("android.media.action.VIDEO_CAPTURE".equals(r101) == false) goto L16;
        goto L15
    }
}
