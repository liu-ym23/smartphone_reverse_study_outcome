package com.bytedance.ee.bear.middleground.permission.collaborator;

import com.bytedance.ee.bear.contract.Result;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NotNotifyUserResult extends Result {
    private int limitCode;
    private List<NotNotifyUserEntity> notNotifyUsers;

    public NotNotifyUserResult() {
    }

    public int getLimitCode() {
        return this.limitCode;
    }

    public List<NotNotifyUserEntity> getNotNotifyUsers() {
        return this.notNotifyUsers;
    }

    public void setLimitCode(int r1) {
        this.limitCode = r1;
    }

    public void setNotNotifyUsers(List<NotNotifyUserEntity> r1) {
        this.notNotifyUsers = r1;
    }
}
