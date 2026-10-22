package com.obric.sva.sdk.data;

import com.obric.sva.sdk.utils.LogUtils;

/* JADX INFO: loaded from: classes6.dex */
public class UserModel implements IUserModel {
    private final String TAG;
    private int mUserId;
    private String mUserName;

    @Override // com.obric.sva.sdk.data.IUserModel
    public int getUserId() {
        return this.mUserId;
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public String getUserName() {
        return this.mUserName;
    }

    public UserModel(String r100) {
        this.TAG = "UserModel";
        this.mUserId = -1;
        this.mUserName = r100;
    }

    private String maskUserIdForLog(int r100) {
        String r101 = String.valueOf(r100);
        return "****" + r101.substring(Math.max(0, r101.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public void setUserId(int r100) {
        LogUtils.d(this.TAG, "setUserId: userId = " + maskUserIdForLog(r100), new Object[0]);
        if (r100 >= (-1)) goto L6;
        LogUtils.d(this.TAG, "setUserId: invalid userId", new Object[0]);
        return;
    L6:
        this.mUserId = r100;
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public void setUserName(String r100) {
        this.mUserName = r100;
    }
}
