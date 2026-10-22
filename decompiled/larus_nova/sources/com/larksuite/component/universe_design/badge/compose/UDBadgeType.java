package com.larksuite.component.universe_design.badge.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/badge/compose/UDBadgeType;", "", "<init>", "(Ljava/lang/String;I)V", "Dot", "Text", "Icon", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDBadgeType extends Enum<UDBadgeType> {
    public static final UDBadgeType Dot = null;
    public static final UDBadgeType Icon = null;
    public static final UDBadgeType Text = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDBadgeType[] f284545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284546b = null;

    public static EnumEntries<UDBadgeType> getEntries() {
        return f284546b;
    }

    static {
        UDBadgeType r100 = new UDBadgeType("Dot", 0);
        Dot = r100;
        UDBadgeType r101 = new UDBadgeType("Text", 1);
        Text = r101;
        UDBadgeType r102 = new UDBadgeType("Icon", 2);
        Icon = r102;
        UDBadgeType[] r103 = {r100, r101, r102};
        f284545a = r103;
        f284546b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDBadgeType[] values() {
        return (UDBadgeType[]) f284545a.clone();
    }

    public static UDBadgeType valueOf(String r100) {
        return (UDBadgeType) r27.a.a(UDBadgeType.class, r100);
    }

    public UDBadgeType(String r100, int r101) {
        super(r100, r101);
    }
}
