package com.larksuite.component.universe_design.button.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonIconPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "Center", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDButtonIconPlacement extends Enum<UDButtonIconPlacement> {
    public static final UDButtonIconPlacement Center = null;
    public static final UDButtonIconPlacement End = null;
    public static final UDButtonIconPlacement Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDButtonIconPlacement[] f284596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284597b = null;

    public static EnumEntries<UDButtonIconPlacement> getEntries() {
        return f284597b;
    }

    static {
        UDButtonIconPlacement r100 = new UDButtonIconPlacement("Start", 0);
        Start = r100;
        UDButtonIconPlacement r101 = new UDButtonIconPlacement("End", 1);
        End = r101;
        UDButtonIconPlacement r102 = new UDButtonIconPlacement("Center", 2);
        Center = r102;
        UDButtonIconPlacement[] r103 = {r100, r101, r102};
        f284596a = r103;
        f284597b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDButtonIconPlacement[] values() {
        return (UDButtonIconPlacement[]) f284596a.clone();
    }

    public static UDButtonIconPlacement valueOf(String r100) {
        return (UDButtonIconPlacement) r27.a.a(UDButtonIconPlacement.class, r100);
    }

    public UDButtonIconPlacement(String r100, int r101) {
        super(r100, r101);
    }
}
