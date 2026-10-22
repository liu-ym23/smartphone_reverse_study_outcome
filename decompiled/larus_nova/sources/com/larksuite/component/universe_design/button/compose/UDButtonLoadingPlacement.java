package com.larksuite.component.universe_design.button.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonLoadingPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "TextStart", "TextEnd", "Center", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDButtonLoadingPlacement extends Enum<UDButtonLoadingPlacement> {
    public static final UDButtonLoadingPlacement Center = null;
    public static final UDButtonLoadingPlacement TextEnd = null;
    public static final UDButtonLoadingPlacement TextStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDButtonLoadingPlacement[] f284603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284604b = null;

    public static EnumEntries<UDButtonLoadingPlacement> getEntries() {
        return f284604b;
    }

    static {
        UDButtonLoadingPlacement r100 = new UDButtonLoadingPlacement("TextStart", 0);
        TextStart = r100;
        UDButtonLoadingPlacement r101 = new UDButtonLoadingPlacement("TextEnd", 1);
        TextEnd = r101;
        UDButtonLoadingPlacement r102 = new UDButtonLoadingPlacement("Center", 2);
        Center = r102;
        UDButtonLoadingPlacement[] r103 = {r100, r101, r102};
        f284603a = r103;
        f284604b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDButtonLoadingPlacement[] values() {
        return (UDButtonLoadingPlacement[]) f284603a.clone();
    }

    public static UDButtonLoadingPlacement valueOf(String r100) {
        return (UDButtonLoadingPlacement) r27.a.a(UDButtonLoadingPlacement.class, r100);
    }

    public UDButtonLoadingPlacement(String r100, int r101) {
        super(r100, r101);
    }
}
