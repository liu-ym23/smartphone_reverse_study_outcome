package com.larus.home.impl.main.side_bar.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SidebarTitleIsBoldDisplay;", "", "value", "", "<init>", "(Ljava/lang/String;IZ)V", "getValue", "()Z", "V2", "V3", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidebarTitleIsBoldDisplay extends Enum<SidebarTitleIsBoldDisplay> {
    public static final SidebarTitleIsBoldDisplay V2 = null;
    public static final SidebarTitleIsBoldDisplay V3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SidebarTitleIsBoldDisplay[] f344852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344853b = null;
    private final boolean value;

    public static EnumEntries<SidebarTitleIsBoldDisplay> getEntries() {
        return f344853b;
    }

    static {
        SidebarTitleIsBoldDisplay r100 = new SidebarTitleIsBoldDisplay("V2", 0);
        V2 = r100;
        SidebarTitleIsBoldDisplay r101 = new SidebarTitleIsBoldDisplay("V3", 1);
        V3 = r101;
        SidebarTitleIsBoldDisplay[] r102 = {r100, r101};
        f344852a = r102;
        f344853b = EnumEntriesKt.enumEntries(r102);
    }

    public static SidebarTitleIsBoldDisplay[] values() {
        return (SidebarTitleIsBoldDisplay[]) f344852a.clone();
    }

    public final boolean getValue() {
        return this.value;
    }

    public static SidebarTitleIsBoldDisplay valueOf(String r100) {
        return (SidebarTitleIsBoldDisplay) r27.a.a(SidebarTitleIsBoldDisplay.class, r100);
    }

    public SidebarTitleIsBoldDisplay(String r100, int r101) {
        super(r100, r101);
        this.value = false;
    }
}
