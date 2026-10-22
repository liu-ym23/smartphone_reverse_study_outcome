package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SectionEntity<T> implements Serializable {
    public String header;
    public boolean isHeader;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public T f273040t;

    public SectionEntity(T r100) {
        this.isHeader = false;
        this.header = null;
        this.f273040t = r100;
    }

    public SectionEntity(boolean r100, String r101) {
        this.isHeader = r100;
        this.header = r101;
        this.f273040t = null;
    }
}
