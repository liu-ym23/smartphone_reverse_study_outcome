package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SectionMultiEntity<T> implements Serializable, MultiItemEntity {
    public String header;
    public boolean isHeader;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public T f273041t;

    public SectionMultiEntity(T r100) {
        this.isHeader = false;
        this.header = null;
        this.f273041t = r100;
    }

    public SectionMultiEntity(boolean r100, String r101) {
        this.isHeader = r100;
        this.header = r101;
        this.f273041t = null;
    }
}
