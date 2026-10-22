package com.ss.android.lark.qrcode.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/TabletState;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "ROTATION_90", "ROTATION_270", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabletState extends Enum<TabletState> {
    public static final TabletState NULL = null;
    public static final TabletState ROTATION_270 = null;
    public static final TabletState ROTATION_90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabletState[] f439037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439038b = null;

    public static EnumEntries<TabletState> getEntries() {
        return f439038b;
    }

    static {
        TabletState r100 = new TabletState("NULL", 0);
        NULL = r100;
        TabletState r101 = new TabletState("ROTATION_90", 1);
        ROTATION_90 = r101;
        TabletState r102 = new TabletState("ROTATION_270", 2);
        ROTATION_270 = r102;
        TabletState[] r103 = {r100, r101, r102};
        f439037a = r103;
        f439038b = EnumEntriesKt.enumEntries(r103);
    }

    public static TabletState[] values() {
        return (TabletState[]) f439037a.clone();
    }

    public static TabletState valueOf(String r100) {
        return (TabletState) r27.a.a(TabletState.class, r100);
    }

    public TabletState(String r100, int r101) {
        super(r100, r101);
    }
}
