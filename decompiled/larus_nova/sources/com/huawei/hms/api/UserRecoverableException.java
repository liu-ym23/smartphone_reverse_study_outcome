package com.huawei.hms.api;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }

    public UserRecoverableException(String r100, Intent r101) {
        super(r100);
        this.mIntent = r101;
    }
}
