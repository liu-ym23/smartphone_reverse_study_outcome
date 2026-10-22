package com.huawei.hms.push.plugin.notification;

import android.app.Activity;
import android.content.IntentSender;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public class NotificationStatus extends Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Packed
    private int f277655a;

    public NotificationStatus() {
        this.f277655a = -1;
    }

    public boolean hasResolution() {
        if (getStatus() != null) goto L5;
    L7:
        return false;
    L5:
        if (getStatus().hasResolution() == false) goto L7;
        return true;
    }

    public int getRetCode() {
        return this.f277655a;
    }

    public void setRetCode(int r100) {
        this.f277655a = r100;
    }

    public void startResolutionForResult(Activity r100, int r101) throws IntentSender.SendIntentException {
        if (getStatus() != null) goto L5;
        return;
    L5:
        if (getStatus().hasResolution() == false) goto L10;
        if (r100 == null) goto L11;
        getStatus().startResolutionForResult(r100, r101);
        return;
    L11:
        return;
    }
}
