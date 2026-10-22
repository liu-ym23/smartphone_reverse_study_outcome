package com.ss.android.lark.doc.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class Icon implements Serializable {
    private int type;
    private String value;

    public Icon() {
        this.type = 0;
        this.value = "";
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }
}
