package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocShareUserInfo implements NonProguard {
    private boolean hasPullSuc;
    private ShareUserInfoResult result;

    public boolean hasCollaborate() {
        ShareUserInfoResult r0 = this.result;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getUserInfoList() != null) goto L7;
        return false;
    L7:
        if (this.result.getUserInfoList().size() <= 1) goto L12;
        return true;
    L12:
        return false;
    }

    public String toString() {
        return "DocShareUserInfo{hasPullSuc: " + this.hasPullSuc + ", result: " + this.result + "}";
    }

    public ShareUserInfoResult getResult() {
        return this.result;
    }

    public boolean isHasPullSuc() {
        return this.hasPullSuc;
    }

    public void setHasPullSuc(boolean r1) {
        this.hasPullSuc = r1;
    }

    public void setResult(ShareUserInfoResult r1) {
        this.result = r1;
    }

    public DocShareUserInfo(boolean r1, ShareUserInfoResult r2) {
        this.hasPullSuc = r1;
        this.result = r2;
    }
}
