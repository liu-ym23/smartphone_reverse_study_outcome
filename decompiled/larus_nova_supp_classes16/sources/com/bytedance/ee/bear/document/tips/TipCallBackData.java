package com.bytedance.ee.bear.document.tips;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TipCallBackData implements NonProguard {
    public static final String CANCEL = "cancel";
    public static final String CONFIRM = "confirm";
    public static final String RESULT = "result";
    private String id;
    private boolean needSendLark;

    public TipCallBackData() {
    }

    public String getId() {
        return this.id;
    }

    public boolean isNeedSendLark() {
        return this.needSendLark;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setNeedSendLark(boolean r1) {
        this.needSendLark = r1;
    }

    public TipCallBackData(String r1, boolean r2) {
        this.id = r1;
        this.needSendLark = r2;
    }
}
