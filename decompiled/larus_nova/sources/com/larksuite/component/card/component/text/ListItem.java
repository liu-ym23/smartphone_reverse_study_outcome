package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larksuite/component/card/component/text/ListItem;", "", "level", "", "type", "", "items", "", "Lcom/larksuite/component/card/component/text/ContentProps;", "order", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getLevel", "()I", "getType", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/larksuite/component/card/component/text/ListItem;", "equals", "", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListItem {
    private final List<ContentProps> items;
    private final int level;
    private final Integer order;
    private final String type;

    public ListItem() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListItem copy$default(ListItem r100, int r101, String r102, List r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.items;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.order;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.type;
    }

    public final List<ContentProps> component3() {
        return this.items;
    }

    public final Integer component4() {
        return this.order;
    }

    public final ListItem copy(int r100, String r101, List<ContentProps> r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "items");
        return new ListItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ListItem) == true) goto L8;
        return false;
    L8:
        ListItem r101 = (ListItem) r100;
        if (this.level == r101.level) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.order, r101.order) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.level * 31) + this.type.hashCode()) * 31) + this.items.hashCode()) * 31;
        Integer r101 = this.order;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ListItem(level=" + this.level + ", type=" + this.type + ", items=" + this.items + ", order=" + this.order + ')';
    }

    public final List<ContentProps> getItems() {
        return this.items;
    }

    public final int getLevel() {
        return this.level;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getType() {
        return this.type;
    }

    public ListItem(int r100, String r101, List<ContentProps> r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "items");
        this.level = r100;
        this.type = r101;
        this.items = r102;
        this.order = r103;
    }

    public /* synthetic */ ListItem(int r100, String r101, List r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
