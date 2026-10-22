package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class ResolvableApiException extends ApiException {
    public PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }

    public Intent getResolutionIntent() {
        return this.mStatus.getResolutionIntent();
    }

    public ResolvableApiException(ResponseErrorCode r100) {
        super(new Status(r100.getErrorCode(), r100.getErrorReason()));
        if (r100.hasResolution() == true) goto L5;
        return;
    L5:
        if ((r100.getParcelable() instanceof PendingIntent) == false) goto L8;
        this.mStatus.setPendingIntent((PendingIntent) r100.getParcelable());
        return;
    L8:
        if ((r100.getParcelable() instanceof Intent) == false) goto L13;
        this.mStatus.setIntent((Intent) r100.getParcelable());
        return;
    }

    public ResolvableApiException(Status r100) {
        super(r100);
    }

    public void startResolutionForResult(Activity r100, int r101) throws IntentSender.SendIntentException {
        this.mStatus.startResolutionForResult(r100, r101);
    }
}
