package com.bytedance.ee.bear.document.record;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(RecordModel r1) {
        this.data = r1;
    }

    public RecordResultModel(boolean r1, RecordModel r2) {
        this.code = !r1 ? 1 : 0;
        this.data = r2;
    }

    public RecordResultModel(int r1, RecordModel r2) {
        this.code = r1;
        this.data = r2;
    }
}
