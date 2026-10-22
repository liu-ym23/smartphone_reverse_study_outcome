package com.bytedance.ee.bear.list.folder.complaint;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public class SendComplaintResult extends Result {
    private int complaintId;

    public SendComplaintResult() {
    }

    public int getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(int r100) {
        this.complaintId = r100;
    }
}
