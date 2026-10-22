package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class DepartmentMeta implements Serializable {
    private static final long serialVersionUID = 5756135315854813874L;
    private String mId;
    private String mName;

    public DepartmentMeta() {
        this.mId = "";
        this.mName = "";
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public DepartmentMeta(String r100, String r101) {
        this.mId = r100;
        this.mName = r101;
    }
}
