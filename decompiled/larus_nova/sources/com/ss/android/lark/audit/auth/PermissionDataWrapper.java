package com.ss.android.lark.audit.auth;

import android.text.TextUtils;
import com.ss.android.lark.pb.authorization.AllPermissionData;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionDataWrapper implements Serializable {
    public AllPermissionData mAllPermissionData;
    public String mUserId;
    public String mVersion;

    public boolean isValid() {
        if (TextUtils.isEmpty(this.mUserId) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mVersion == null) goto L9;
        if (this.mAllPermissionData == null) goto L9;
        return true;
    }

    public static boolean isValid(PermissionDataWrapper r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isValid() == false) goto L6;
        return true;
    }

    public PermissionDataWrapper(String r100, String r101, AllPermissionData r102) {
        this.mUserId = r100;
        this.mVersion = r101;
        this.mAllPermissionData = r102;
    }
}
