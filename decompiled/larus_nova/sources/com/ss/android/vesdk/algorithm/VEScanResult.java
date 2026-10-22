package com.ss.android.vesdk.algorithm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class VEScanResult {
    public static final int TYPE_DETECT_SCAN = 2;
    public static final int TYPE_FACE_DETECT_SCAN = 3;
    public static final int TYPE_OBJECT_SCAN = 1;
    public static final int TYPE_QR_SCAN = 0;
    private String reason;
    private int retCode;
    protected int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultType {
    }

    public VEScanResult() {
        this.retCode = 0;
    }

    public String getReason() {
        return this.reason;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getType() {
        return this.type;
    }

    public void setReason(String r100) {
        this.reason = r100;
    }

    public void setRetCode(int r100) {
        this.retCode = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
