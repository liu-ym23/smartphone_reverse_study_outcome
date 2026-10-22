package com.ss.android.lark.profile.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class DepartmentList implements Serializable {
    private static final long serialVersionUID = 4730343431625724394L;
    private List<DepartmentMeta> mDepartmentMetaList;

    public DepartmentList() {
    }

    public List<DepartmentMeta> getDepartmentMetaList() {
        return this.mDepartmentMetaList;
    }

    public void setDepartmentMetaList(List<DepartmentMeta> r100) {
        this.mDepartmentMetaList = r100;
    }
}
