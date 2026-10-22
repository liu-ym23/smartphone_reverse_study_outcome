package com.ss.android.lark.guide.ui.common.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/guide/ui/common/popup/OverlayType;", "", "<init>", "(Ljava/lang/String;I)V", "POPUP_WINDOW", "VIEW", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OverlayType extends Enum<OverlayType> {
    public static final OverlayType POPUP_WINDOW = null;
    public static final OverlayType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OverlayType[] f425772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425773b = null;

    public static EnumEntries<OverlayType> getEntries() {
        return f425773b;
    }

    static {
        OverlayType r100 = new OverlayType("POPUP_WINDOW", 0);
        POPUP_WINDOW = r100;
        OverlayType r101 = new OverlayType("VIEW", 1);
        VIEW = r101;
        OverlayType[] r102 = {r100, r101};
        f425772a = r102;
        f425773b = EnumEntriesKt.enumEntries(r102);
    }

    public static OverlayType[] values() {
        return (OverlayType[]) f425772a.clone();
    }

    public static OverlayType valueOf(String r100) {
        return (OverlayType) a.a(OverlayType.class, r100);
    }

    public OverlayType(String r100, int r101) {
        super(r100, r101);
    }
}
