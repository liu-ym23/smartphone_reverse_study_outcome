package com.bytedance.bmf_mods_lite_api.exception;

/* JADX INFO: loaded from: classes45.dex */
public class BmfException extends Exception {
    public static final int HARDWARE_BUFFER_OP_FAILED = -100701;
    public static final int INPUT_PARAM_INVALID = -100020;
    public static final int NOT_INITIALIZED = -100010;
    public static final int PROCESS_FAILED_BASE = -200000;
    private int mCode;

    public BmfException() {
        this.mCode = -1;
    }

    public int getCode() {
        return this.mCode;
    }

    public BmfException(String r100) {
        super(r100);
        this.mCode = -1;
    }

    public BmfException(int r100, String r101) {
        super(r101);
        this.mCode = r100;
    }
}
