package com.larksuite.component.universe_design.badge.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/badge/compose/UDBadgeAnchorAlign;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "LeftTop", "LeftBottom", "Right", "RightTop", "RightBottom", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDBadgeAnchorAlign extends Enum<UDBadgeAnchorAlign> {
    public static final UDBadgeAnchorAlign Left = null;
    public static final UDBadgeAnchorAlign LeftBottom = null;
    public static final UDBadgeAnchorAlign LeftTop = null;
    public static final UDBadgeAnchorAlign Right = null;
    public static final UDBadgeAnchorAlign RightBottom = null;
    public static final UDBadgeAnchorAlign RightTop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDBadgeAnchorAlign[] f284537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284538b = null;

    public static EnumEntries<UDBadgeAnchorAlign> getEntries() {
        return f284538b;
    }

    static {
        UDBadgeAnchorAlign r100 = new UDBadgeAnchorAlign("Left", 0);
        Left = r100;
        UDBadgeAnchorAlign r101 = new UDBadgeAnchorAlign("LeftTop", 1);
        LeftTop = r101;
        UDBadgeAnchorAlign r102 = new UDBadgeAnchorAlign("LeftBottom", 2);
        LeftBottom = r102;
        UDBadgeAnchorAlign r103 = new UDBadgeAnchorAlign("Right", 3);
        Right = r103;
        UDBadgeAnchorAlign r104 = new UDBadgeAnchorAlign("RightTop", 4);
        RightTop = r104;
        UDBadgeAnchorAlign r105 = new UDBadgeAnchorAlign("RightBottom", 5);
        RightBottom = r105;
        UDBadgeAnchorAlign[] r110 = {r100, r101, r102, r103, r104, r105};
        f284537a = r110;
        f284538b = EnumEntriesKt.enumEntries(r110);
    }

    public static UDBadgeAnchorAlign[] values() {
        return (UDBadgeAnchorAlign[]) f284537a.clone();
    }

    public static UDBadgeAnchorAlign valueOf(String r100) {
        return (UDBadgeAnchorAlign) r27.a.a(UDBadgeAnchorAlign.class, r100);
    }

    public UDBadgeAnchorAlign(String r100, int r101) {
        super(r100, r101);
    }
}
