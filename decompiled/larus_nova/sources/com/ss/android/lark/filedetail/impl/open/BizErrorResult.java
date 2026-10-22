package com.ss.android.lark.filedetail.impl.open;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes35.dex */
public class BizErrorResult extends ErrorResult {
    private int mShowMessage;

    public int getShowMessage() {
        return this.mShowMessage;
    }

    public void setShowMessage(int r100) {
        this.mShowMessage = r100;
    }

    public BizErrorResult(int r100, int r101) {
        super(r100);
        this.mShowMessage = r101;
    }
}
