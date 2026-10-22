package com.bytedance.ee.bear.document.restore.api;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes16.dex */
public final class WikiRestoreTaskPuller$WikiRestoreTaskResult implements NonProguard {

    @SerializedName("status")
    public int status;

    public WikiRestoreTaskPuller$WikiRestoreTaskResult() {
    }

    public boolean isFail() {
        int r100 = this.status;
        if (r100 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 4) goto L8;
        return false;
    }

    public boolean isFinish() {
        if (this.status != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
