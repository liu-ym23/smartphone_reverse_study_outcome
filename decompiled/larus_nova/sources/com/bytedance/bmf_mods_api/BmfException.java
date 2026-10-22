package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public class BmfException extends Exception {
    public static final int INPUT_PARAM_INVALID = -100020;
    public static final int NOT_INITIALIZED = -100010;
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
