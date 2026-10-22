package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/ItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TYPE_CARD_IMAGE_TEXT", "TYPE_CARD_VIDEO", "TYPE_CARD_MORE", "TYPE_CARD_SKELETON", "TYPE_CARD_IMAGE", "TYPE_CARD_MIXED_MEDIA", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType TYPE_CARD_IMAGE = null;
    public static final ItemType TYPE_CARD_IMAGE_TEXT = null;
    public static final ItemType TYPE_CARD_MIXED_MEDIA = null;
    public static final ItemType TYPE_CARD_MORE = null;
    public static final ItemType TYPE_CARD_SKELETON = null;
    public static final ItemType TYPE_CARD_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemType[] f346659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346660b = null;
    private final int type;

    public static EnumEntries<ItemType> getEntries() {
        return f346660b;
    }

    static {
        ItemType r100 = new ItemType("TYPE_CARD_IMAGE_TEXT", 0, 0);
        TYPE_CARD_IMAGE_TEXT = r100;
        ItemType r101 = new ItemType("TYPE_CARD_VIDEO", 1, 1);
        TYPE_CARD_VIDEO = r101;
        ItemType r102 = new ItemType("TYPE_CARD_MORE", 2, 2);
        TYPE_CARD_MORE = r102;
        ItemType r103 = new ItemType("TYPE_CARD_SKELETON", 3, 3);
        TYPE_CARD_SKELETON = r103;
        ItemType r104 = new ItemType("TYPE_CARD_IMAGE", 4, 4);
        TYPE_CARD_IMAGE = r104;
        ItemType r105 = new ItemType("TYPE_CARD_MIXED_MEDIA", 5, 5);
        TYPE_CARD_MIXED_MEDIA = r105;
        ItemType[] r110 = {r100, r101, r102, r103, r104, r105};
        f346659a = r110;
        f346660b = EnumEntriesKt.enumEntries(r110);
    }

    public static ItemType[] values() {
        return (ItemType[]) f346659a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ItemType valueOf(String r100) {
        return (ItemType) r27.a.a(ItemType.class, r100);
    }

    public ItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
