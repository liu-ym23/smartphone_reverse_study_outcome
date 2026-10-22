package com.larus.doc.sdk.impl.generalbiz.state.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocToolbar;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toolbarItems", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/DocToolbarItem;", "getToolbarItems", "()Ljava/util/List;", "setToolbarItems", "(Ljava/util/List;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocToolbar {

    @SerializedName("toolbarItems")
    private List<DocToolbarItem> toolbarItems;

    @SerializedName("type")
    private Integer type;

    public FlowDocToolbar() {
    }

    public final List<DocToolbarItem> getToolbarItems() {
        return this.toolbarItems;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setToolbarItems(List<DocToolbarItem> r100) {
        this.toolbarItems = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
