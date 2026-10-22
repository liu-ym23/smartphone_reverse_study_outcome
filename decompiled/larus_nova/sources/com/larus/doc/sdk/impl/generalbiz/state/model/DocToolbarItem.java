package com.larus.doc.sdk.impl.generalbiz.state.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/DocToolbarItem;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "state", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/ItemState;", "getState", "()Lcom/larus/doc/sdk/impl/generalbiz/state/model/ItemState;", "setState", "(Lcom/larus/doc/sdk/impl/generalbiz/state/model/ItemState;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocToolbarItem {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f331612id;

    @SerializedName("state")
    private ItemState state;

    public DocToolbarItem() {
    }

    public final String getId() {
        return this.f331612id;
    }

    public final ItemState getState() {
        return this.state;
    }

    public final void setId(String r100) {
        this.f331612id = r100;
    }

    public final void setState(ItemState r100) {
        this.state = r100;
    }
}
