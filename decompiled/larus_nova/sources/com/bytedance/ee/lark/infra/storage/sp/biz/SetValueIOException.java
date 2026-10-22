package com.bytedance.ee.lark.infra.storage.sp.biz;

import java.io.IOException;

/* JADX INFO: loaded from: classes19.dex */
public class SetValueIOException extends IOException {
    public static final int ERROR_EXCEED_ITEM_SIZE = 10;
    public static final int ERROR_EXCEED_TOTAL_SIZE = 20;
    private int code;

    public int getCode() {
        return this.code;
    }

    public SetValueIOException(int r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
