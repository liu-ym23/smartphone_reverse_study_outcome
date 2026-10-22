package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "APP_TYPE_NATIVE", "APP_TYPE_MINI", "APP_TYPE_WEB", "APP_TYPE_CUSTOM_NATIVE", "APP_TYPE_OPEN_APP", "APP_TYPE_URL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabAppType extends Enum<TabAppType> {
    public static final TabAppType APP_TYPE_CUSTOM_NATIVE = null;
    public static final TabAppType APP_TYPE_MINI = null;
    public static final TabAppType APP_TYPE_NATIVE = null;
    public static final TabAppType APP_TYPE_OPEN_APP = null;
    public static final TabAppType APP_TYPE_URL = null;
    public static final TabAppType APP_TYPE_WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabAppType[] f431597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431598b = null;
    private final int value;

    public static EnumEntries<TabAppType> getEntries() {
        return f431598b;
    }

    static {
        TabAppType r100 = new TabAppType("APP_TYPE_NATIVE", 0, 1);
        APP_TYPE_NATIVE = r100;
        TabAppType r101 = new TabAppType("APP_TYPE_MINI", 1, 2);
        APP_TYPE_MINI = r101;
        TabAppType r102 = new TabAppType("APP_TYPE_WEB", 2, 3);
        APP_TYPE_WEB = r102;
        TabAppType r103 = new TabAppType("APP_TYPE_CUSTOM_NATIVE", 3, 4);
        APP_TYPE_CUSTOM_NATIVE = r103;
        TabAppType r104 = new TabAppType("APP_TYPE_OPEN_APP", 4, 5);
        APP_TYPE_OPEN_APP = r104;
        TabAppType r110 = new TabAppType("APP_TYPE_URL", 5, 6);
        APP_TYPE_URL = r110;
        TabAppType[] r111 = {r100, r101, r102, r103, r104, r110};
        f431597a = r111;
        f431598b = EnumEntriesKt.enumEntries(r111);
    }

    public static TabAppType[] values() {
        return (TabAppType[]) f431597a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TabAppType valueOf(String r100) {
        return (TabAppType) r27.a.a(TabAppType.class, r100);
    }

    public TabAppType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
