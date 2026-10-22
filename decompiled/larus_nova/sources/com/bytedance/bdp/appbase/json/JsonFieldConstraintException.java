package com.bytedance.bdp.appbase.json;

import s94.a;

/* JADX INFO: loaded from: classes11.dex */
public class JsonFieldConstraintException extends Exception {
    private final a constraint;
    private final String jsonPath;

    public a getConstraint() {
        return null;
    }

    public String getJsonPath() {
        return this.jsonPath;
    }

    public JsonFieldConstraintException(a r100, String r101, String r102) {
        super(r102);
        this.jsonPath = r101;
    }
}
