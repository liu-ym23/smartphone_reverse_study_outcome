package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class CustomProfileField implements Serializable {
    private static final long serialVersionUID = 849543819999452231L;
    private String herf;
    private boolean isUrl;
    private String key;
    private String name;
    private String value;

    public CustomProfileField() {
        this.key = "";
        this.name = "";
        this.value = "";
        this.herf = "";
    }

    public String getHerf() {
        return this.herf;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isUrl() {
        return this.isUrl;
    }

    public void setHerf(String r100) {
        this.herf = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setUrl(boolean r100) {
        this.isUrl = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public CustomProfileField(String r100, String r101, String r102) {
        this.key = r100;
        this.value = r101;
        this.herf = r102;
    }
}
