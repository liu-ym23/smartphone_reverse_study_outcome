package com.larus.office.base.plugins.toolbar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0013\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00152\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\b\u0010&\u001a\u0004\u0018\u00010\u0011J\u0013\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000eJ\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0002J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/Item;", "Ljava/io/Serializable;", "<init>", "()V", "id", "Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "(Lcom/larus/office/base/plugins/toolbar/model/ItemId;)V", "", "itemId", "value", "list", "", "[Ljava/lang/String;", "enable", "", "selected", "children", "Lcom/larus/office/base/plugins/toolbar/model/Item$Children;", "adminLimit", "getId", "setItemId", "", "setId", "isEnable", "getList", "()[Ljava/lang/String;", "setList", "([Ljava/lang/String;)V", "valueIndexInList", "", "nextValueInList", "currentValue", "forward", "setEnable", "isSelected", "setSelected", "getValue", "setValue", "getChildren", "getChildrenItems", "()[Lcom/larus/office/base/plugins/toolbar/model/Item;", "setChildren", "isAdminLimit", "setAdminLimit", "equals", "o", "", "hashCode", "toString", "Children", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Item implements Serializable {

    @SerializedName("adminLimit")
    private boolean adminLimit;

    @SerializedName("children")
    private a children;

    @SerializedName("enable")
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f360907id;

    @SerializedName("itemId")
    private ItemId itemId;

    @SerializedName("list")
    private String[] list;

    @SerializedName("selected")
    private boolean selected;

    @SerializedName("value")
    private String value;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/Item$Children;", "", "<init>", "()V", "items", "", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "[Lcom/larus/office/base/plugins/toolbar/model/Item;", "count", "", "orientationType", "getItems", "()[Lcom/larus/office/base/plugins/toolbar/model/Item;", "setItems", "", "([Lcom/larus/office/base/plugins/toolbar/model/Item;)V", "getCount", "setCount", "getOrientationType", "setOrientationType", "isHorizontal", "", "equals", "o", "hashCode", "toString", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("count")
        private int count;

        @SerializedName("items")
        private Item[] items;

        @SerializedName("orientationType")
        private int orientationType;

        /* JADX INFO: renamed from: com.larus.office.base.plugins.toolbar.model.Item$a$a, reason: collision with other inner class name */
        public static final class C4434a {
        }

        static {
        }

        public a() {
        }

        public final boolean b() {
            if (this.orientationType != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final int hashCode() {
            return (((Arrays.hashCode(this.items) * 31) + Objects.hashCode(Integer.valueOf(this.count))) * 31) + Objects.hashCode(Integer.valueOf(this.orientationType));
        }

        public final String toString() {
            return "Children{items=" + Arrays.toString(this.items) + ", count:" + this.count + ", orientationType" + this.orientationType + '}';
        }

        public final Item[] a() {
            return this.items;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L19:
            return false;
        L8:
            if (Intrinsics.areEqual(a.class, r100.getClass()) == false) goto L19;
            a r101 = (a) r100;
            if (Arrays.equals(this.items, r101.items) == true) goto L13;
        L17:
            return false;
        L13:
            if (this.count != r101.count) goto L17;
            if (this.orientationType != r101.orientationType) goto L17;
            return true;
        }
    }

    public Item() {
    }

    public final int valueIndexInList() {
        return valueIndexInList$default(this, null, 1, null);
    }

    public final Item[] getChildrenItems() {
        a r100 = this.children;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.a() == null) goto L9;
        a r101 = this.children;
        Intrinsics.checkNotNull(r101);
        Item[] r102 = r101.a();
        Intrinsics.checkNotNull(r102);
        return r102;
    L9:
        return new Item[0];
    }

    public final String getId() {
        String r100 = this.f360907id;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final String[] getList() {
        String[] r100 = this.list;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final String getValue() {
        String r100 = this.value;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f360907id, this.itemId, this.value, Boolean.valueOf(this.enable), Boolean.valueOf(this.adminLimit), Boolean.valueOf(this.selected), this.children, this.list});
    }

    public final ItemId id() {
        ItemId r100 = this.itemId;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ItemId.ConstId.unknown;
    }

    public String toString() {
        String r100 = this.f360907id;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final a getChildren() {
        return this.children;
    }

    public final boolean isAdminLimit() {
        return this.adminLimit;
    }

    public final boolean isEnable() {
        return this.enable;
    }

    public final boolean isSelected() {
        return this.selected;
    }

    public Item(ItemId r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f360907id = r100.itemName();
        this.itemId = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L29:
        return false;
    L8:
        if (Intrinsics.areEqual(Item.class, r100.getClass()) == false) goto L29;
        Item r101 = (Item) r100;
        if (this.enable == r101.enable) goto L13;
    L27:
        return false;
    L13:
        if (this.adminLimit != r101.adminLimit) goto L27;
        if (this.selected != r101.selected) goto L27;
        if (Intrinsics.areEqual(this.f360907id, r101.f360907id) == false) goto L27;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == false) goto L27;
        if (Intrinsics.areEqual(this.value, r101.value) == false) goto L27;
        if (Arrays.equals(this.list, r101.list) == false) goto L27;
        if (Intrinsics.areEqual(this.children, r101.children) == false) goto L27;
        return true;
    }

    public final void setAdminLimit(boolean r100) {
        this.adminLimit = r100;
    }

    public final void setChildren(a r100) {
        this.children = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setId(String r100) {
        this.f360907id = r100;
    }

    public final void setItemId(ItemId r100) {
        this.itemId = r100;
    }

    public final void setList(String[] r100) {
        this.list = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setValue(String r100) {
        this.value = r100;
    }

    public final int valueIndexInList(String r100) {
        String[] r101 = this.list;
        if (r101 == null) goto L13;
        if (r100 == null) goto L17;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        String[] r104 = this.list;
        Intrinsics.checkNotNull(r104);
        if (Intrinsics.areEqual(r100, r104[r103]) == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return r103;
    L12:
        return 0;
    L17:
        return -1;
    L13:
        return -1;
    }

    public final String nextValueInList(String r100, boolean r101) {
        int r102 = valueIndexInList(r100);
        if (r102 >= 0) goto L5;
        return r100;
    L5:
        if (r101 == false) goto L7;
        int r103 = r102 + 1;
    L8:
        String[] r104 = getList();
        if (r103 >= 0) goto L11;
        return r100;
    L11:
        if (r103 < r104.length) goto L13;
        return r100;
    L13:
        return r104[r103];
    L7:
        r103 = r102 - 1;
        goto L8
    }

    public static /* synthetic */ int valueIndexInList$default(Item r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        return r100.valueIndexInList(r101);
    }
}
