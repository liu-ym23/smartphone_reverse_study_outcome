package com.facebook.net;

import android.net.Uri;
import com.bytedance.ttnet.http.RequestContext;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class FrescoRequestContext extends RequestContext {
    private final List<Uri> mBackupUris;
    private final int mRetryCount;

    public FrescoRequestContext() {
        this.mBackupUris = null;
        this.mRetryCount = 0;
    }

    public List<Uri> getBackupUris() {
        return this.mBackupUris;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public FrescoRequestContext(List<Uri> r100) {
        this.mBackupUris = r100;
        this.mRetryCount = 0;
    }

    public FrescoRequestContext(List<Uri> r100, int r101) {
        this.mBackupUris = r100;
        this.mRetryCount = r101;
    }
}
