package com.larksuite.component.universe_design.dialog.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/UDDialogActionOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "Horizontal", "Vertical", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDDialogActionOrientation extends Enum<UDDialogActionOrientation> {
    public static final UDDialogActionOrientation Auto = null;
    public static final UDDialogActionOrientation Horizontal = null;
    public static final UDDialogActionOrientation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDDialogActionOrientation[] f284893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284894b = null;

    public static EnumEntries<UDDialogActionOrientation> getEntries() {
        return f284894b;
    }

    static {
        UDDialogActionOrientation r100 = new UDDialogActionOrientation("Auto", 0);
        Auto = r100;
        UDDialogActionOrientation r101 = new UDDialogActionOrientation("Horizontal", 1);
        Horizontal = r101;
        UDDialogActionOrientation r102 = new UDDialogActionOrientation("Vertical", 2);
        Vertical = r102;
        UDDialogActionOrientation[] r103 = {r100, r101, r102};
        f284893a = r103;
        f284894b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDDialogActionOrientation[] values() {
        return (UDDialogActionOrientation[]) f284893a.clone();
    }

    public static UDDialogActionOrientation valueOf(String r100) {
        return (UDDialogActionOrientation) r27.a.a(UDDialogActionOrientation.class, r100);
    }

    public UDDialogActionOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
