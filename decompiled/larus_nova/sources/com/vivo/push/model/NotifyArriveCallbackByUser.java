package com.vivo.push.model;

import android.content.Intent;

/* JADX INFO: loaded from: classes41.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }

    public NotifyArriveCallbackByUser(Intent r100, boolean r101) {
        this.mIntent = r100;
        this.mIsIntercept = r101;
    }
}
