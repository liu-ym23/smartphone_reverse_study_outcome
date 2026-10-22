package com.obric.oui.selection;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OSelectionSheet$Companion$TitleBarControlType extends Enum<OSelectionSheet$Companion$TitleBarControlType> {
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_AND_CONFIRM = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$TitleBarControlType[] f402794a = null;

    public static OSelectionSheet$Companion$TitleBarControlType valueOf(String r100) {
        return (OSelectionSheet$Companion$TitleBarControlType) a.a(OSelectionSheet$Companion$TitleBarControlType.class, r100);
    }

    public static OSelectionSheet$Companion$TitleBarControlType[] values() {
        return (OSelectionSheet$Companion$TitleBarControlType[]) f402794a.clone();
    }

    static {
        OSelectionSheet$Companion$TitleBarControlType r100 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_ONLY", 0);
        CLOSE_ONLY = r100;
        OSelectionSheet$Companion$TitleBarControlType r101 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_AND_CONFIRM", 1);
        CLOSE_AND_CONFIRM = r101;
        f402794a = new OSelectionSheet$Companion$TitleBarControlType[]{r100, r101};
    }

    public OSelectionSheet$Companion$TitleBarControlType(String r100, int r101) {
        super(r100, r101);
    }
}
