package com.larus.office.base.plugins.titlebar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/office/base/plugins/titlebar/MenuItem;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "docVersion", "", "getDocVersion", "()I", "setDocVersion", "(I)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItem {

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("doc_version")
    private int docVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f360779id;

    @SerializedName("name")
    private String name;

    public MenuItem() {
        this.disabled = true;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final int getDocVersion() {
        return this.docVersion;
    }

    public final String getId() {
        return this.f360779id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setDisabled(boolean r100) {
        this.disabled = r100;
    }

    public final void setDocVersion(int r100) {
        this.docVersion = r100;
    }

    public final void setId(String r100) {
        this.f360779id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }
}
