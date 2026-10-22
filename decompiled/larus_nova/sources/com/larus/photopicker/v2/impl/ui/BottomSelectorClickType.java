package com.larus.photopicker.v2.impl.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/BottomSelectorClickType;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_ITEM", "DEL_ITEM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BottomSelectorClickType extends Enum<BottomSelectorClickType> {
    public static final BottomSelectorClickType CLICK_ITEM = null;
    public static final BottomSelectorClickType DEL_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomSelectorClickType[] f364611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364612b = null;

    public static EnumEntries<BottomSelectorClickType> getEntries() {
        return f364612b;
    }

    static {
        BottomSelectorClickType r100 = new BottomSelectorClickType("CLICK_ITEM", 0);
        CLICK_ITEM = r100;
        BottomSelectorClickType r101 = new BottomSelectorClickType("DEL_ITEM", 1);
        DEL_ITEM = r101;
        BottomSelectorClickType[] r102 = {r100, r101};
        f364611a = r102;
        f364612b = EnumEntriesKt.enumEntries(r102);
    }

    public static BottomSelectorClickType[] values() {
        return (BottomSelectorClickType[]) f364611a.clone();
    }

    public static BottomSelectorClickType valueOf(String r100) {
        return (BottomSelectorClickType) a.a(BottomSelectorClickType.class, r100);
    }

    public BottomSelectorClickType(String r100, int r101) {
        super(r100, r101);
    }
}
