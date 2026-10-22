package com.larksuite.component.universe_design.button.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonSize;", "", "<init>", "(Ljava/lang/String;I)V", "Column", "Big", "Middle", "Small", "Custom", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDButtonSize extends Enum<UDButtonSize> {
    public static final UDButtonSize Big = null;
    public static final UDButtonSize Column = null;
    public static final UDButtonSize Custom = null;
    public static final UDButtonSize Middle = null;
    public static final UDButtonSize Small = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDButtonSize[] f284607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284608b = null;

    public static EnumEntries<UDButtonSize> getEntries() {
        return f284608b;
    }

    static {
        UDButtonSize r100 = new UDButtonSize("Column", 0);
        Column = r100;
        UDButtonSize r101 = new UDButtonSize("Big", 1);
        Big = r101;
        UDButtonSize r102 = new UDButtonSize("Middle", 2);
        Middle = r102;
        UDButtonSize r103 = new UDButtonSize("Small", 3);
        Small = r103;
        UDButtonSize r104 = new UDButtonSize("Custom", 4);
        Custom = r104;
        UDButtonSize[] r105 = {r100, r101, r102, r103, r104};
        f284607a = r105;
        f284608b = EnumEntriesKt.enumEntries(r105);
    }

    public static UDButtonSize[] values() {
        return (UDButtonSize[]) f284607a.clone();
    }

    public static UDButtonSize valueOf(String r100) {
        return (UDButtonSize) r27.a.a(UDButtonSize.class, r100);
    }

    public UDButtonSize(String r100, int r101) {
        super(r100, r101);
    }
}
