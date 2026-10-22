package com.larksuite.component.universe_design.icon.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/icon/compose/UDIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Outlined", "Filled", "Colorful", "Other", "universe-ui-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDIconStyle extends Enum<UDIconStyle> {
    public static final UDIconStyle Colorful = null;
    public static final UDIconStyle Filled = null;
    public static final UDIconStyle Other = null;
    public static final UDIconStyle Outlined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDIconStyle[] f285042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285043b = null;

    public static EnumEntries<UDIconStyle> getEntries() {
        return f285043b;
    }

    static {
        UDIconStyle r100 = new UDIconStyle("Outlined", 0);
        Outlined = r100;
        UDIconStyle r101 = new UDIconStyle("Filled", 1);
        Filled = r101;
        UDIconStyle r102 = new UDIconStyle("Colorful", 2);
        Colorful = r102;
        UDIconStyle r103 = new UDIconStyle("Other", 3);
        Other = r103;
        UDIconStyle[] r104 = {r100, r101, r102, r103};
        f285042a = r104;
        f285043b = EnumEntriesKt.enumEntries(r104);
    }

    public static UDIconStyle[] values() {
        return (UDIconStyle[]) f285042a.clone();
    }

    public static UDIconStyle valueOf(String r100) {
        return (UDIconStyle) r27.a.a(UDIconStyle.class, r100);
    }

    public UDIconStyle(String r100, int r101) {
        super(r100, r101);
    }
}
