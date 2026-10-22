package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FormulaSuggestionPickData implements NonProguard {
    private int index;
    private String requestId;

    public int getIndex() {
        return this.index;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    public void setRequestId(String r1) {
        this.requestId = r1;
    }

    public FormulaSuggestionPickData(String r1, int r2) {
        this.requestId = r1;
        this.index = r2;
    }
}
