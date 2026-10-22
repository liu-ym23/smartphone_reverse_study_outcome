package com.bytedance.dux.infopanel.action;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/dux/infopanel/action/DuxInfoPanelDoubleBtnActionView$Style", "", "Lcom/bytedance/dux/infopanel/action/DuxInfoPanelDoubleBtnActionView$Style;", "PRIMARY_SECONDARY", "ONLY_SECONDARY", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum DuxInfoPanelDoubleBtnActionView$Style extends Enum<DuxInfoPanelDoubleBtnActionView$Style> {
    public static final DuxInfoPanelDoubleBtnActionView$Style ONLY_SECONDARY = null;
    public static final DuxInfoPanelDoubleBtnActionView$Style PRIMARY_SECONDARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DuxInfoPanelDoubleBtnActionView$Style[] f205236a = null;

    public static DuxInfoPanelDoubleBtnActionView$Style valueOf(String r100) {
        return (DuxInfoPanelDoubleBtnActionView$Style) a.a(DuxInfoPanelDoubleBtnActionView$Style.class, r100);
    }

    public static DuxInfoPanelDoubleBtnActionView$Style[] values() {
        return (DuxInfoPanelDoubleBtnActionView$Style[]) f205236a.clone();
    }

    static {
        DuxInfoPanelDoubleBtnActionView$Style r100 = new DuxInfoPanelDoubleBtnActionView$Style("PRIMARY_SECONDARY", 0);
        PRIMARY_SECONDARY = r100;
        DuxInfoPanelDoubleBtnActionView$Style r101 = new DuxInfoPanelDoubleBtnActionView$Style("ONLY_SECONDARY", 1);
        ONLY_SECONDARY = r101;
        f205236a = new DuxInfoPanelDoubleBtnActionView$Style[]{r100, r101};
    }

    public DuxInfoPanelDoubleBtnActionView$Style(String r100, int r101) {
        super(r100, r101);
    }
}
