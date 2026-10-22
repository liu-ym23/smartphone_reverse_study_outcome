package com.ss.android.lark.profile.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class ProfileFinishResult implements Serializable {
    private static final long serialVersionUID = 3442091501736892805L;
    public boolean isBlocked;
    public boolean isFriend;
    public boolean isRequestUserApplied;
    public boolean isTargetUserApplied;
    public String userId;

    public ProfileFinishResult() {
    }

    public ProfileFinishResult(String r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.isBlocked = r101;
        this.userId = r100;
        this.isFriend = r102;
        this.isRequestUserApplied = r103;
        this.isTargetUserApplied = r104;
    }
}
