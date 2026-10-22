package com.ss.android.lark.contact.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContact implements Serializable {
    private static final long serialVersionUID = -1576990577080993273L;
    private String chatterId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f418868id;
    private boolean isDeleted;

    public ExternalContact() {
    }

    public String getChatterId() {
        return this.chatterId;
    }

    public String getId() {
        return this.f418868id;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setChatterId(String r100) {
        this.chatterId = r100;
    }

    public void setDeleted(boolean r100) {
        this.isDeleted = r100;
    }

    public void setId(String r100) {
        this.f418868id = r100;
    }
}
