package com.larksuite.component.universe_design.badge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadgeAlign;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "LEFT_TOP", "LEFT_BOTTOM", "RIGHT", "RIGHT_TOP", "RIGHT_BOTTOM", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDBadgeAlign extends Enum<UDBadgeAlign> {
    public static final UDBadgeAlign LEFT = null;
    public static final UDBadgeAlign LEFT_BOTTOM = null;
    public static final UDBadgeAlign LEFT_TOP = null;
    public static final UDBadgeAlign RIGHT = null;
    public static final UDBadgeAlign RIGHT_BOTTOM = null;
    public static final UDBadgeAlign RIGHT_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDBadgeAlign[] f284520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284521b = null;

    public static EnumEntries<UDBadgeAlign> getEntries() {
        return f284521b;
    }

    static {
        UDBadgeAlign r100 = new UDBadgeAlign("LEFT", 0);
        LEFT = r100;
        UDBadgeAlign r101 = new UDBadgeAlign("LEFT_TOP", 1);
        LEFT_TOP = r101;
        UDBadgeAlign r102 = new UDBadgeAlign("LEFT_BOTTOM", 2);
        LEFT_BOTTOM = r102;
        UDBadgeAlign r103 = new UDBadgeAlign("RIGHT", 3);
        RIGHT = r103;
        UDBadgeAlign r104 = new UDBadgeAlign("RIGHT_TOP", 4);
        RIGHT_TOP = r104;
        UDBadgeAlign r105 = new UDBadgeAlign("RIGHT_BOTTOM", 5);
        RIGHT_BOTTOM = r105;
        UDBadgeAlign[] r110 = {r100, r101, r102, r103, r104, r105};
        f284520a = r110;
        f284521b = EnumEntriesKt.enumEntries(r110);
    }

    public static UDBadgeAlign[] values() {
        return (UDBadgeAlign[]) f284520a.clone();
    }

    public static UDBadgeAlign valueOf(String r100) {
        return (UDBadgeAlign) a.a(UDBadgeAlign.class, r100);
    }

    public UDBadgeAlign(String r100, int r101) {
        super(r100, r101);
    }
}
