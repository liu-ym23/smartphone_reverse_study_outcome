package com.larus.office.base.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/office/base/service/BizMenuItem;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "doc_version", "", "docVersion", "getDocVersion", "()I", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BizMenuItem {
    private boolean disabled;
    private int doc_version;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f361070id;

    public BizMenuItem() {
        this.disabled = true;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final int getDocVersion() {
        return this.doc_version;
    }

    public final String getId() {
        return this.f361070id;
    }

    public final void setDisabled(boolean r100) {
        this.disabled = r100;
    }

    public final void setId(String r100) {
        this.f361070id = r100;
    }
}
