package com.obric.oui.infopanel.action;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style", "", "Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "PRIMARY", "SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OInfoPanelSingleBtnActionView$Style extends Enum<OInfoPanelSingleBtnActionView$Style> {
    public static final OInfoPanelSingleBtnActionView$Style PRIMARY = null;
    public static final OInfoPanelSingleBtnActionView$Style SECONDARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OInfoPanelSingleBtnActionView$Style[] f401283a = null;

    public static OInfoPanelSingleBtnActionView$Style valueOf(String r100) {
        return (OInfoPanelSingleBtnActionView$Style) a.a(OInfoPanelSingleBtnActionView$Style.class, r100);
    }

    public static OInfoPanelSingleBtnActionView$Style[] values() {
        return (OInfoPanelSingleBtnActionView$Style[]) f401283a.clone();
    }

    static {
        OInfoPanelSingleBtnActionView$Style r100 = new OInfoPanelSingleBtnActionView$Style("PRIMARY", 0);
        PRIMARY = r100;
        OInfoPanelSingleBtnActionView$Style r101 = new OInfoPanelSingleBtnActionView$Style("SECONDARY", 1);
        SECONDARY = r101;
        f401283a = new OInfoPanelSingleBtnActionView$Style[]{r100, r101};
    }

    public OInfoPanelSingleBtnActionView$Style(String r100, int r101) {
        super(r100, r101);
    }
}
