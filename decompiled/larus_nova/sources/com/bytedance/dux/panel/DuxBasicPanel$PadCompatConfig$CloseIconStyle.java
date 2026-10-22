package com.bytedance.dux.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/dux/panel/DuxBasicPanel$PadCompatConfig$CloseIconStyle", "", "Lcom/bytedance/dux/panel/DuxBasicPanel$PadCompatConfig$CloseIconStyle;", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "AUTO_SWITCH_DAY_NIGHT", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum DuxBasicPanel$PadCompatConfig$CloseIconStyle extends Enum<DuxBasicPanel$PadCompatConfig$CloseIconStyle> {
    public static final DuxBasicPanel$PadCompatConfig$CloseIconStyle AUTO_SWITCH_DAY_NIGHT = null;
    public static final DuxBasicPanel$PadCompatConfig$CloseIconStyle BLACK_NO_BG = null;
    public static final DuxBasicPanel$PadCompatConfig$CloseIconStyle BLACK_WITH_BG = null;
    public static final DuxBasicPanel$PadCompatConfig$CloseIconStyle WHITE_WITH_BG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DuxBasicPanel$PadCompatConfig$CloseIconStyle[] f205322a = null;

    public static DuxBasicPanel$PadCompatConfig$CloseIconStyle valueOf(String r100) {
        return (DuxBasicPanel$PadCompatConfig$CloseIconStyle) r27.a.a(DuxBasicPanel$PadCompatConfig$CloseIconStyle.class, r100);
    }

    public static DuxBasicPanel$PadCompatConfig$CloseIconStyle[] values() {
        return (DuxBasicPanel$PadCompatConfig$CloseIconStyle[]) f205322a.clone();
    }

    static {
        DuxBasicPanel$PadCompatConfig$CloseIconStyle r100 = new DuxBasicPanel$PadCompatConfig$CloseIconStyle("BLACK_NO_BG", 0);
        BLACK_NO_BG = r100;
        DuxBasicPanel$PadCompatConfig$CloseIconStyle r101 = new DuxBasicPanel$PadCompatConfig$CloseIconStyle("WHITE_WITH_BG", 1);
        WHITE_WITH_BG = r101;
        DuxBasicPanel$PadCompatConfig$CloseIconStyle r102 = new DuxBasicPanel$PadCompatConfig$CloseIconStyle("BLACK_WITH_BG", 2);
        BLACK_WITH_BG = r102;
        DuxBasicPanel$PadCompatConfig$CloseIconStyle r103 = new DuxBasicPanel$PadCompatConfig$CloseIconStyle("AUTO_SWITCH_DAY_NIGHT", 3);
        AUTO_SWITCH_DAY_NIGHT = r103;
        f205322a = new DuxBasicPanel$PadCompatConfig$CloseIconStyle[]{r100, r101, r102, r103};
    }

    public DuxBasicPanel$PadCompatConfig$CloseIconStyle(String r100, int r101) {
        super(r100, r101);
    }
}
