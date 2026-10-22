package com.obric.oui.selection;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$ItemStyle", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OSelectionSheet$Companion$ItemStyle extends Enum<OSelectionSheet$Companion$ItemStyle> {
    public static final OSelectionSheet$Companion$ItemStyle ICON_AND_TEXT = null;
    public static final OSelectionSheet$Companion$ItemStyle TEXT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$ItemStyle[] f402792a = null;

    public static OSelectionSheet$Companion$ItemStyle valueOf(String r100) {
        return (OSelectionSheet$Companion$ItemStyle) a.a(OSelectionSheet$Companion$ItemStyle.class, r100);
    }

    public static OSelectionSheet$Companion$ItemStyle[] values() {
        return (OSelectionSheet$Companion$ItemStyle[]) f402792a.clone();
    }

    static {
        OSelectionSheet$Companion$ItemStyle r100 = new OSelectionSheet$Companion$ItemStyle("TEXT_ONLY", 0);
        TEXT_ONLY = r100;
        OSelectionSheet$Companion$ItemStyle r101 = new OSelectionSheet$Companion$ItemStyle("ICON_AND_TEXT", 1);
        ICON_AND_TEXT = r101;
        f402792a = new OSelectionSheet$Companion$ItemStyle[]{r100, r101};
    }

    public OSelectionSheet$Companion$ItemStyle(String r100, int r101) {
        super(r100, r101);
    }
}
