package com.ss.android.lark.forwardv3.data;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardErrorResultV3 extends ErrorResult {
    private boolean mIsClose;
    private boolean mIsDialog;
    private String mMessage;
    private String mTitle;

    @Override // com.larksuite.framework.callback.Entity.ErrorResult, java.lang.Throwable
    public String getMessage() {
        return this.mMessage;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isIsDialog() {
        return this.mIsDialog;
    }

    public boolean isWillClose() {
        return this.mIsClose;
    }

    public ForwardErrorResultV3(String r100, boolean r101) {
        super(r100);
        this.mTitle = null;
        this.mMessage = r100;
        this.mIsClose = r101;
    }

    public ForwardErrorResultV3(String r100, String r101, boolean r102) {
        super(r101);
        this.mTitle = r100;
        this.mMessage = r101;
        this.mIsClose = r102;
        this.mIsDialog = true;
    }
}
