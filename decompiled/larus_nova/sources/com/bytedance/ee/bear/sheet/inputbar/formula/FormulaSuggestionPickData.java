package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaSuggestionPickData implements NonProguard {
    private int index;
    private String requestId;

    public int getIndex() {
        return this.index;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public FormulaSuggestionPickData(String r100, int r101) {
        this.requestId = r100;
        this.index = r101;
    }
}
