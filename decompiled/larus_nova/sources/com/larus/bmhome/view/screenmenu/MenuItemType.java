package com.larus.bmhome.view.screenmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/MenuItemType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "BUTTON", "SECTION_DIVIDER", "HEADER", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MenuItemType extends Enum<MenuItemType> {
    public static final MenuItemType BUTTON = null;
    public static final MenuItemType DEFAULT = null;
    public static final MenuItemType HEADER = null;
    public static final MenuItemType SECTION_DIVIDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MenuItemType[] f317239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317240b = null;

    public static EnumEntries<MenuItemType> getEntries() {
        return f317240b;
    }

    static {
        MenuItemType r100 = new MenuItemType("DEFAULT", 0);
        DEFAULT = r100;
        MenuItemType r101 = new MenuItemType("BUTTON", 1);
        BUTTON = r101;
        MenuItemType r102 = new MenuItemType("SECTION_DIVIDER", 2);
        SECTION_DIVIDER = r102;
        MenuItemType r103 = new MenuItemType("HEADER", 3);
        HEADER = r103;
        MenuItemType[] r104 = {r100, r101, r102, r103};
        f317239a = r104;
        f317240b = EnumEntriesKt.enumEntries(r104);
    }

    public static MenuItemType[] values() {
        return (MenuItemType[]) f317239a.clone();
    }

    public static MenuItemType valueOf(String r100) {
        return (MenuItemType) r27.a.a(MenuItemType.class, r100);
    }

    public MenuItemType(String r100, int r101) {
        super(r100, r101);
    }
}
