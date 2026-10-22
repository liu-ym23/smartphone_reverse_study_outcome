package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

/* JADX INFO: loaded from: classes23.dex */
public class ResolvableApiException extends ApiException {
    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public ResolvableApiException(Status r100) {
        super(r100);
    }

    public void startResolutionForResult(Activity r100, int r101) throws IntentSender.SendIntentException {
        getStatus().startResolutionForResult(r100, r101);
    }
}
