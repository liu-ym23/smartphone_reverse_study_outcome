package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuBackgroundMode;", "", "<init>", "(Ljava/lang/String;I)V", "DIM", "BLUR_DIM", "NONE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScreenMenuBackgroundMode extends Enum<ScreenMenuBackgroundMode> {
    public static final ScreenMenuBackgroundMode BLUR_DIM = null;
    public static final ScreenMenuBackgroundMode DIM = null;
    public static final ScreenMenuBackgroundMode NONE = null;
    public static final /* synthetic */ ScreenMenuBackgroundMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ScreenMenuBackgroundMode> getEntries() {
        return b;
    }

    static {
        ScreenMenuBackgroundMode r0 = new ScreenMenuBackgroundMode("DIM", 0);
        DIM = r0;
        ScreenMenuBackgroundMode r1 = new ScreenMenuBackgroundMode("BLUR_DIM", 1);
        BLUR_DIM = r1;
        ScreenMenuBackgroundMode r3 = new ScreenMenuBackgroundMode("NONE", 2);
        NONE = r3;
        ScreenMenuBackgroundMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ScreenMenuBackgroundMode[] values() {
        return (ScreenMenuBackgroundMode[]) a.clone();
    }

    public static ScreenMenuBackgroundMode valueOf(String r1) {
        return (ScreenMenuBackgroundMode) r27.a.a(ScreenMenuBackgroundMode.class, r1);
    }

    public ScreenMenuBackgroundMode(String r1, int r2) {
        super(r1, r2);
    }
}
