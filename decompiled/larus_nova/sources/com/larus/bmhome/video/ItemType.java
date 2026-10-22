package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/video/ItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOAD_MORE", "UNDEFINED", "VIDEO", "IMAGES", "ARTICLE", "MUSIC", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType ARTICLE = null;
    public static final a Companion = null;
    public static final ItemType IMAGES = null;
    public static final ItemType LOAD_MORE = null;
    public static final ItemType MUSIC = null;
    public static final ItemType UNDEFINED = null;
    public static final ItemType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemType[] f315175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315176b = null;
    private final int value;

    public static EnumEntries<ItemType> getEntries() {
        return f315176b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.video.ItemType$a] */
    static {
        ItemType r100 = new ItemType("LOAD_MORE", 0, -1);
        LOAD_MORE = r100;
        ItemType r101 = new ItemType("UNDEFINED", 1, 0);
        UNDEFINED = r101;
        ItemType r102 = new ItemType("VIDEO", 2, 1);
        VIDEO = r102;
        ItemType r103 = new ItemType("IMAGES", 3, 2);
        IMAGES = r103;
        ItemType r104 = new ItemType("ARTICLE", 4, 3);
        ARTICLE = r104;
        ItemType r105 = new ItemType("MUSIC", 5, 4);
        MUSIC = r105;
        ItemType[] r110 = {r100, r101, r102, r103, r104, r105};
        f315175a = r110;
        f315176b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static ItemType[] values() {
        return (ItemType[]) f315175a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemType valueOf(String r100) {
        return (ItemType) r27.a.a(ItemType.class, r100);
    }

    public ItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
