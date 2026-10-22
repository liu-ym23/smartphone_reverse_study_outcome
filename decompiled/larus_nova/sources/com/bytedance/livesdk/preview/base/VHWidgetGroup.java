package com.bytedance.livesdk.preview.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/livesdk/preview/base/VHWidgetGroup;", "", "NO_GROUP_ID", "EXTEND_BOTTOM_AREA", "BOTTOM_BAR_AREA", "EXTEND_TOP_AREA", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VHWidgetGroup extends Enum<VHWidgetGroup> {
    public static final VHWidgetGroup BOTTOM_BAR_AREA = null;
    public static final VHWidgetGroup EXTEND_BOTTOM_AREA = null;
    public static final VHWidgetGroup EXTEND_TOP_AREA = null;
    public static final VHWidgetGroup NO_GROUP_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VHWidgetGroup[] f256411a = null;

    static {
        VHWidgetGroup r100 = new VHWidgetGroup("NO_GROUP_ID", 0);
        NO_GROUP_ID = r100;
        VHWidgetGroup r101 = new VHWidgetGroup("EXTEND_BOTTOM_AREA", 1);
        EXTEND_BOTTOM_AREA = r101;
        VHWidgetGroup r102 = new VHWidgetGroup("BOTTOM_BAR_AREA", 2);
        BOTTOM_BAR_AREA = r102;
        VHWidgetGroup r103 = new VHWidgetGroup("EXTEND_TOP_AREA", 3);
        EXTEND_TOP_AREA = r103;
        f256411a = new VHWidgetGroup[]{r100, r101, r102, r103};
    }

    public static VHWidgetGroup valueOf(String r100) {
        return (VHWidgetGroup) r27.a.a(VHWidgetGroup.class, r100);
    }

    public static VHWidgetGroup[] values() {
        return (VHWidgetGroup[]) f256411a.clone();
    }

    public VHWidgetGroup(String r100, int r101) {
        super(r100, r101);
    }
}
