package com.bytedance.ee.bear.middleground_permission_export.model.forbidden;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public class GetComplaintResult extends Result<Integer> {
    int result;

    public GetComplaintResult() {
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int r100) {
        this.result = r100;
    }
}
