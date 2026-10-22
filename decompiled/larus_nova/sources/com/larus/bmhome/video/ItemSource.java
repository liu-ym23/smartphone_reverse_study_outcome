package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/video/ItemSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "DOUBAO", "DOUYIN", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemSource extends Enum<ItemSource> {
    public static final a Companion = null;
    public static final ItemSource DOUBAO = null;
    public static final ItemSource DOUYIN = null;
    public static final ItemSource UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemSource[] f315171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315172b = null;
    private final int value;

    public static EnumEntries<ItemSource> getEntries() {
        return f315172b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.video.ItemSource$a] */
    static {
        ItemSource r100 = new ItemSource("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        ItemSource r101 = new ItemSource("DOUBAO", 1, 1);
        DOUBAO = r101;
        ItemSource r102 = new ItemSource("DOUYIN", 2, 2);
        DOUYIN = r102;
        ItemSource[] r103 = {r100, r101, r102};
        f315171a = r103;
        f315172b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ItemSource[] values() {
        return (ItemSource[]) f315171a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemSource valueOf(String r100) {
        return (ItemSource) r27.a.a(ItemSource.class, r100);
    }

    public ItemSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
