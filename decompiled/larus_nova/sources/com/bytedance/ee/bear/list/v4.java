package com.bytedance.ee.bear.list;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class v4 {
    public static boolean a(Context r100, int r101) {
        if (r101 == 4210) goto L5;
        return false;
    L5:
        tt5.a.h("SpaceErrorCodeHandler", "handle unsupported space operation. errorCode=" + r101);
        if (r100 == null) goto L10;
        Toast.showFailureText(r100, r100.getString(R.string.LarkCCM_Drive_UnsupportedAction_Toast), 0);
        return true;
    L10:
        return true;
    }
}
