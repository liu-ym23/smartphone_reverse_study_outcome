package com.larus.office.base.plugins.titlebar;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/larus/office/base/plugins/titlebar/MenuData;", "", "<init>", "()V", "items", "", "Lcom/larus/office/base/plugins/titlebar/MenuItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuData {

    @SerializedName("items")
    private List<MenuItem> items;

    public MenuData() {
    }

    public String toString() {
        return "NavigationMenu{items=" + this.items + '}';
    }

    public final List<MenuItem> getItems() {
        return this.items;
    }

    public final void setItems(List<MenuItem> r100) {
        this.items = r100;
    }
}
