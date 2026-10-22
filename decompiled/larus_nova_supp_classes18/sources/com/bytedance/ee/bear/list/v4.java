package com.bytedance.ee.bear.list;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v4 {
    public static boolean a(Context r3, int r4) {
        if (r4 == 4210) goto L5;
        return false;
    L5:
        tt5.a.h("SpaceErrorCodeHandler", "handle unsupported space operation. errorCode=" + r4);
        if (r3 == null) goto L10;
        Toast.showFailureText(r3, r3.getString(2131889467), 0);
        return true;
    L10:
        return true;
    }
}
