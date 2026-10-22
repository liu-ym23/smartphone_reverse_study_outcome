package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class NumberModel implements NonProguard {
    private String formatterValue;
    private Double numberValue;

    public NumberModel() {
    }

    public String getFormatterValue() {
        return this.formatterValue;
    }

    public Double getNumberValue() {
        return this.numberValue;
    }

    public void setFormatterValue(String r100) {
        this.formatterValue = r100;
    }

    public void setNumberValue(Double r100) {
        this.numberValue = r100;
    }

    public NumberModel(String r100, Double r101) {
        this.formatterValue = r100;
        this.numberValue = r101;
    }
}
