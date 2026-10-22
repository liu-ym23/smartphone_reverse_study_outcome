package com.larus.canvas.feature.component.resultdisplay.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/CanvasSaveActionPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE_RIGHT", "IMAGE_OVERLAY_BOTTOM_START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasSaveActionPlacement extends Enum<CanvasSaveActionPlacement> {
    public static final CanvasSaveActionPlacement IMAGE_OVERLAY_BOTTOM_START = null;
    public static final CanvasSaveActionPlacement TITLE_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CanvasSaveActionPlacement[] f323527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323528b = null;

    public static EnumEntries<CanvasSaveActionPlacement> getEntries() {
        return f323528b;
    }

    static {
        CanvasSaveActionPlacement r100 = new CanvasSaveActionPlacement("TITLE_RIGHT", 0);
        TITLE_RIGHT = r100;
        CanvasSaveActionPlacement r101 = new CanvasSaveActionPlacement("IMAGE_OVERLAY_BOTTOM_START", 1);
        IMAGE_OVERLAY_BOTTOM_START = r101;
        CanvasSaveActionPlacement[] r102 = {r100, r101};
        f323527a = r102;
        f323528b = EnumEntriesKt.enumEntries(r102);
    }

    public static CanvasSaveActionPlacement[] values() {
        return (CanvasSaveActionPlacement[]) f323527a.clone();
    }

    public static CanvasSaveActionPlacement valueOf(String r100) {
        return (CanvasSaveActionPlacement) r27.a.a(CanvasSaveActionPlacement.class, r100);
    }

    public CanvasSaveActionPlacement(String r100, int r101) {
        super(r100, r101);
    }
}
