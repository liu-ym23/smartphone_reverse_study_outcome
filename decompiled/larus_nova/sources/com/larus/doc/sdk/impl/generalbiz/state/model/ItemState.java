package com.larus.doc.sdk.impl.generalbiz.state.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/ItemState;", "", "<init>", "()V", "editMenuItems", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/MenuItem;", "getEditMenuItems", "()Ljava/util/List;", "setEditMenuItems", "(Ljava/util/List;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemState {

    @SerializedName("editMenuItems")
    private List<MenuItem> editMenuItems;

    public ItemState() {
    }

    public final List<MenuItem> getEditMenuItems() {
        return this.editMenuItems;
    }

    public final void setEditMenuItems(List<MenuItem> r100) {
        this.editMenuItems = r100;
    }
}
