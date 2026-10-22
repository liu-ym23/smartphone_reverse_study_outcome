package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaHideAssistData implements NonProguard {
    public static final String TARGET_ALL = "all";
    public static final String TARGET_SIGNATURE = "signature";
    public static final String TARGET_SUGGESTIONS = "suggestions";
    private String target;

    public FormulaHideAssistData() {
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String r100) {
        this.target = r100;
    }
}
