package com.tencent.connect;

import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* JADX INFO: loaded from: classes40.dex */
public class a {
    public static boolean a(String r100, IUiListener r101) {
        return a(r100, r101, -6, Constants.MSG_PERMISSION_NOT_GRANTED, Constants.MSG_PERMISSION_NOT_GRANTED);
    }

    public static boolean a(String r100, IUiListener r101, int r102, String r103, String r104) {
        if (Tencent.isPermissionNotGranted() == false) goto L9;
        SLog.i(r100, "permission not granted");
        if (r101 == null) goto L11;
        r101.onError(new UiError(r102, r103, r104));
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
