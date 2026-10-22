package com.oplus.ocs.base.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import com.oplus.ocs.base.common.constant.CommonStatusCodes;
import com.oplus.ocs.base.utils.e;

/* JADX INFO: loaded from: classes34.dex */
public class ConnectionResult {
    private int mErrorCode;
    private PendingIntent mPendingIntent;

    public String getErrorMessage() {
        return CommonStatusCodes.getStatusCodeString(this.mErrorCode);
    }

    public boolean hasResolution() {
        if (this.mErrorCode != 0) goto L5;
        return false;
    L5:
        if (this.mPendingIntent == null) goto L10;
        return true;
    L10:
        return false;
    }

    public String toString() {
        return e.a(this).a("statusCode", CommonStatusCodes.getStatusCodeString(this.mErrorCode)).toString();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public ConnectionResult(int r100) {
        this(r100, null);
    }

    public ConnectionResult(int r100, PendingIntent r101) {
        this.mErrorCode = r100;
        this.mPendingIntent = r101;
    }

    public void startResolutionForResult(Activity r100, int r110) throws IntentSender.SendIntentException {
        if (hasResolution() == false) goto L6;
        r100.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), r110, null, 0, 0, 0);
        return;
    }
}
