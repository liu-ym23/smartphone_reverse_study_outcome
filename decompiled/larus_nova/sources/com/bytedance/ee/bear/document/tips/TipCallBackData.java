package com.bytedance.ee.bear.document.tips;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class TipCallBackData implements NonProguard {
    public static final String CANCEL = "cancel";
    public static final String CONFIRM = "confirm";
    public static final String RESULT = "result";

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f222037id;
    private boolean needSendLark;

    public TipCallBackData() {
    }

    public String getId() {
        return this.f222037id;
    }

    public boolean isNeedSendLark() {
        return this.needSendLark;
    }

    public void setId(String r100) {
        this.f222037id = r100;
    }

    public void setNeedSendLark(boolean r100) {
        this.needSendLark = r100;
    }

    public TipCallBackData(String r100, boolean r101) {
        this.f222037id = r100;
        this.needSendLark = r101;
    }
}
