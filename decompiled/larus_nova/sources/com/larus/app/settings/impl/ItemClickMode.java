package com.larus.app.settings.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/app/settings/impl/ItemClickMode;", "", "<init>", "(Ljava/lang/String;I)V", "DIRECT", "DEBOUNCE", "STICKY_DEBOUNCE_1S", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemClickMode extends Enum<ItemClickMode> {
    public static final ItemClickMode DEBOUNCE = null;
    public static final ItemClickMode DIRECT = null;
    public static final ItemClickMode STICKY_DEBOUNCE_1S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemClickMode[] f286998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286999b = null;

    public static EnumEntries<ItemClickMode> getEntries() {
        return f286999b;
    }

    static {
        ItemClickMode r100 = new ItemClickMode("DIRECT", 0);
        DIRECT = r100;
        ItemClickMode r101 = new ItemClickMode("DEBOUNCE", 1);
        DEBOUNCE = r101;
        ItemClickMode r102 = new ItemClickMode("STICKY_DEBOUNCE_1S", 2);
        STICKY_DEBOUNCE_1S = r102;
        ItemClickMode[] r103 = {r100, r101, r102};
        f286998a = r103;
        f286999b = EnumEntriesKt.enumEntries(r103);
    }

    public static ItemClickMode[] values() {
        return (ItemClickMode[]) f286998a.clone();
    }

    public static ItemClickMode valueOf(String r100) {
        return (ItemClickMode) r27.a.a(ItemClickMode.class, r100);
    }

    public ItemClickMode(String r100, int r101) {
        super(r100, r101);
    }
}
