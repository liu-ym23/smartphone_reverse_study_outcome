package com.bytedance.ee.bear.middleground.permission.collaborator;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class PermShareUserInfo implements NonProguard {
    private boolean hasPullSuc;
    private ShareUserInfoResult result;

    public boolean hasCollborate() {
        ShareUserInfoResult r100 = this.result;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getUserInfoList() != null) goto L7;
        return false;
    L7:
        if (this.result.getUserInfoList().size() <= 1) goto L12;
        return true;
    L12:
        return false;
    }

    public ShareUserInfoResult getResult() {
        return this.result;
    }

    public boolean isHasPullSuc() {
        return this.hasPullSuc;
    }

    public void setHasPullSuc(boolean r100) {
        this.hasPullSuc = r100;
    }

    public void setResult(ShareUserInfoResult r100) {
        this.result = r100;
    }

    public PermShareUserInfo(boolean r100, ShareUserInfoResult r101) {
        this.hasPullSuc = r100;
        this.result = r101;
    }
}
