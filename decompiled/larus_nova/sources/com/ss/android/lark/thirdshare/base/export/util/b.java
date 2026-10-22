package com.ss.android.lark.thirdshare.base.export.util;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static void a(String r100) {
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L5;
        ViewUtils.showToastLong(r100);
    L5:
        Log.e("ThirdShare", r100);
    }
}
