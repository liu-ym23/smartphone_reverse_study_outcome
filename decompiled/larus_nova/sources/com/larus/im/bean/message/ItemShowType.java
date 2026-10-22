package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/ItemShowType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ITEM_SHOW_TYPE_NONE", "ITEM_SHOW_TYPE_AUTO", "ITEM_SHOW_TYPE_SLIDE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemShowType extends Enum<ItemShowType> {
    public static final ItemShowType ITEM_SHOW_TYPE_AUTO = null;
    public static final ItemShowType ITEM_SHOW_TYPE_NONE = null;
    public static final ItemShowType ITEM_SHOW_TYPE_SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemShowType[] f346657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346658b = null;
    private final String type;

    public static EnumEntries<ItemShowType> getEntries() {
        return f346658b;
    }

    static {
        ItemShowType r100 = new ItemShowType("ITEM_SHOW_TYPE_NONE", 0, "none");
        ITEM_SHOW_TYPE_NONE = r100;
        ItemShowType r101 = new ItemShowType("ITEM_SHOW_TYPE_AUTO", 1, "auto");
        ITEM_SHOW_TYPE_AUTO = r101;
        ItemShowType r102 = new ItemShowType("ITEM_SHOW_TYPE_SLIDE", 2, "slide");
        ITEM_SHOW_TYPE_SLIDE = r102;
        ItemShowType[] r103 = {r100, r101, r102};
        f346657a = r103;
        f346658b = EnumEntriesKt.enumEntries(r103);
    }

    public static ItemShowType[] values() {
        return (ItemShowType[]) f346657a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ItemShowType valueOf(String r100) {
        return (ItemShowType) r27.a.a(ItemShowType.class, r100);
    }

    public ItemShowType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
