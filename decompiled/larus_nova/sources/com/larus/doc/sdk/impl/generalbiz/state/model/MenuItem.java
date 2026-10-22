package com.larus.doc.sdk.impl.generalbiz.state.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/MenuItem;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "enable", "getEnable", "setEnable", "itemId", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId;", "getItemId", "()Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId;", "setItemId", "(Lcom/larus/doc/sdk/impl/generalbiz/state/model/EditMenuItemId;)V", "initItemId", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItem {

    @SerializedName("enable")
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f331616id;
    private EditMenuItemId itemId;

    @SerializedName("selected")
    private boolean selected;

    public final void initItemId() {
        this.itemId = EditMenuItemId.Companion.fromValue(this.f331616id);
    }

    public MenuItem() {
        this.enable = true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getId() {
        return this.f331616id;
    }

    public final EditMenuItemId getItemId() {
        return this.itemId;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setId(String r100) {
        this.f331616id = r100;
    }

    public final void setItemId(EditMenuItemId r100) {
        this.itemId = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }
}
