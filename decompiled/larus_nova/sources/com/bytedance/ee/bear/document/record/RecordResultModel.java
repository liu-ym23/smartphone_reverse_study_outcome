package com.bytedance.ee.bear.document.record;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RecordResultModel implements NonProguard {
    private static final int FAIL = 1;
    private static final int SUCCESS = 0;
    private int code;
    private RecordModel data;

    public static int getFAIL() {
        return 1;
    }

    public static int getSUCCESS() {
        return 0;
    }

    public String toString() {
        return "RecordResultModel{code=" + this.code + ", data=" + this.data + '}';
    }

    public int getCode() {
        return this.code;
    }

    public RecordModel getData() {
        return this.data;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(RecordModel r100) {
        this.data = r100;
    }

    public RecordResultModel(boolean r100, RecordModel r101) {
        this.code = !r100 ? 1 : 0;
        this.data = r101;
    }

    public RecordResultModel(int r100, RecordModel r101) {
        this.code = r100;
        this.data = r101;
    }
}
