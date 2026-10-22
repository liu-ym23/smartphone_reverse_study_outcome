package com.bytedance.ee.bear.account.container.impl;

import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;

/* JADX INFO: loaded from: classes15.dex */
public class UserInfoResult implements Serializable, NonProguard {
    String departmentId;
    String domain;
    boolean hasLeader;
    boolean isSingleproduct;
    boolean isSuperAdmin;

    public UserInfoResult() {
        this.departmentId = "";
        this.domain = "";
        this.hasLeader = true;
    }
}
