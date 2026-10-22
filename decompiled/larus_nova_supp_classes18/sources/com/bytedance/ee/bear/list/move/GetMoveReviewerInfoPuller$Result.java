package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetMoveReviewerInfoPuller$Result implements NonProguard {
    public GetMoveReviewerInfoPuller$Entities entities;
    public boolean not_need_apply;
    public String reviewer;

    public GetMoveReviewerInfoPuller$Result() {
    }

    public String toString() {
        return "Result{reviewer='" + yu5.c.j(this.reviewer) + "', not_need_apply=" + this.not_need_apply + ", entities=" + this.entities + '}';
    }
}
