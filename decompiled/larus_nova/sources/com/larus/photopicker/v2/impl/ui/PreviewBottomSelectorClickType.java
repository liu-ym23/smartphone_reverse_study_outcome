package com.larus.photopicker.v2.impl.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/PreviewBottomSelectorClickType;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_ITEM", "DEL_ITEM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewBottomSelectorClickType extends Enum<PreviewBottomSelectorClickType> {
    public static final PreviewBottomSelectorClickType CLICK_ITEM = null;
    public static final PreviewBottomSelectorClickType DEL_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewBottomSelectorClickType[] f364686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364687b = null;

    public static EnumEntries<PreviewBottomSelectorClickType> getEntries() {
        return f364687b;
    }

    static {
        PreviewBottomSelectorClickType r100 = new PreviewBottomSelectorClickType("CLICK_ITEM", 0);
        CLICK_ITEM = r100;
        PreviewBottomSelectorClickType r101 = new PreviewBottomSelectorClickType("DEL_ITEM", 1);
        DEL_ITEM = r101;
        PreviewBottomSelectorClickType[] r102 = {r100, r101};
        f364686a = r102;
        f364687b = EnumEntriesKt.enumEntries(r102);
    }

    public static PreviewBottomSelectorClickType[] values() {
        return (PreviewBottomSelectorClickType[]) f364686a.clone();
    }

    public static PreviewBottomSelectorClickType valueOf(String r100) {
        return (PreviewBottomSelectorClickType) a.a(PreviewBottomSelectorClickType.class, r100);
    }

    public PreviewBottomSelectorClickType(String r100, int r101) {
        super(r100, r101);
    }
}
