package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/api/ItemSourceApp;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DOUYIN", "TOUTIAO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemSourceApp extends Enum<ItemSourceApp> {
    public static final ItemSourceApp DOUYIN = null;
    public static final ItemSourceApp TOUTIAO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemSourceApp[] f364812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364813b = null;
    private final int value;

    public static EnumEntries<ItemSourceApp> getEntries() {
        return f364813b;
    }

    static {
        ItemSourceApp r100 = new ItemSourceApp("DOUYIN", 0, 0);
        DOUYIN = r100;
        ItemSourceApp r101 = new ItemSourceApp("TOUTIAO", 1, 1);
        TOUTIAO = r101;
        ItemSourceApp[] r102 = {r100, r101};
        f364812a = r102;
        f364813b = EnumEntriesKt.enumEntries(r102);
    }

    public static ItemSourceApp[] values() {
        return (ItemSourceApp[]) f364812a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemSourceApp valueOf(String r100) {
        return (ItemSourceApp) r27.a.a(ItemSourceApp.class, r100);
    }

    public ItemSourceApp(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
