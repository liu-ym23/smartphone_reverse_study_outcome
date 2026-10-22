package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class AutoNumberModel implements NonProguard {
    private String number;
    private String sequence;

    public AutoNumberModel() {
    }

    public String getNumber() {
        return this.number;
    }

    public String getSequence() {
        return this.sequence;
    }

    public void setNumber(String r100) {
        this.number = r100;
    }

    public void setSequence(String r100) {
        this.sequence = r100;
    }

    public AutoNumberModel(String r100, String r101) {
        this.sequence = r100;
        this.number = r101;
    }
}
