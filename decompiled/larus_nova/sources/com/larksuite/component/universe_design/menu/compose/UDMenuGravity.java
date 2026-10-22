package com.larksuite.component.universe_design.menu.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/menu/compose/UDMenuGravity;", "", "<init>", "(Ljava/lang/String;I)V", "Top", "Bottom", "Start", "End", "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDMenuGravity extends Enum<UDMenuGravity> {
    public static final UDMenuGravity Bottom = null;
    public static final UDMenuGravity End = null;
    public static final UDMenuGravity Start = null;
    public static final UDMenuGravity Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDMenuGravity[] f285104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285105b = null;

    public static EnumEntries<UDMenuGravity> getEntries() {
        return f285105b;
    }

    static {
        UDMenuGravity r100 = new UDMenuGravity("Top", 0);
        Top = r100;
        UDMenuGravity r101 = new UDMenuGravity("Bottom", 1);
        Bottom = r101;
        UDMenuGravity r102 = new UDMenuGravity("Start", 2);
        Start = r102;
        UDMenuGravity r103 = new UDMenuGravity("End", 3);
        End = r103;
        UDMenuGravity[] r104 = {r100, r101, r102, r103};
        f285104a = r104;
        f285105b = EnumEntriesKt.enumEntries(r104);
    }

    public static UDMenuGravity[] values() {
        return (UDMenuGravity[]) f285104a.clone();
    }

    public static UDMenuGravity valueOf(String r100) {
        return (UDMenuGravity) r27.a.a(UDMenuGravity.class, r100);
    }

    public UDMenuGravity(String r100, int r101) {
        super(r100, r101);
    }
}
