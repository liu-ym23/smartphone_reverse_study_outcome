package com.larus.office.base.plugins.toolbar.model;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0010J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J'\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\r2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010#\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0006\u0010%\u001a\u00020\u0018J\b\u0010&\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/Toolbar;", "", "<init>", "()V", "items", "", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "[Lcom/larus/office/base/plugins/toolbar/model/Item;", "type", "", "showingItemId", "", "initFromJsBridge", "", "supportedItems", "Lcom/larus/office/base/plugins/toolbar/model/ItemId$PrimaryItemId;", "([Lcom/larus/office/base/plugins/toolbar/model/ItemId$PrimaryItemId;)V", "initIds", "findItemId", "Lcom/larus/office/base/plugins/toolbar/model/ItemId;", MapController.ITEM_LAYER_TAG, "findRange", "(Lcom/larus/office/base/plugins/toolbar/model/Item;[Lcom/larus/office/base/plugins/toolbar/model/ItemId;)Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "contains", "", "id", "itemId", "(Lcom/larus/office/base/plugins/toolbar/model/ItemId;[Lcom/larus/office/base/plugins/toolbar/model/ItemId;)Z", "getItems", "()[Lcom/larus/office/base/plugins/toolbar/model/Item;", "setItems", "([Lcom/larus/office/base/plugins/toolbar/model/Item;)V", "getType", "setType", "getShowingItemId", "setShowingItemId", "supportSubToolbar", "shouldShowSubToolbar", "toString", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f360933a = 0;

    @SerializedName("items")
    private Item[] items;

    @SerializedName("showingItemId")
    private String showingItemId;

    @SerializedName("type")
    private int type;

    /* JADX INFO: renamed from: com.larus.office.base.plugins.toolbar.model.a$a, reason: collision with other inner class name */
    public static final class C4435a {
    }

    static {
    }

    public final String toString() {
        return "ToolbarV2{items=" + Arrays.toString(this.items) + ", type=" + this.type + ", showingItemId='" + this.showingItemId + "'}";
    }

    public a() {
        this.type = 2;
    }

    public final Item[] a() {
        return this.items;
    }

    public final String b() {
        return this.showingItemId;
    }

    public final int getType() {
        return this.type;
    }
}
