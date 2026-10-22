package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setTarget(String r1) {
        this.target = r1;
    }
}
