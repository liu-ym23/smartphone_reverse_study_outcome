package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235952a = 0;

    static {
    }

    public static boolean a(OfficeSpaceConfig r100, OfficeSpaceTab r101, OfficeSpaceEnterContext r102, String r110) {
        if (r100.getListConfig().getDisplayMode() == OfficeListDisplayMode.FLOW) goto L5;
        return false;
    L5:
        String r103 = "";
        String r104 = null;
        if (r101 == OfficeSpaceTab.RECENT) goto L16;
        StringBuilder r105 = new StringBuilder("skip office space open timing, initial tab is ");
        r105.append(r101);
        r105.append(", runtime=");
        if (r110 == null) goto L10;
        r104 = StringsKt.takeLast(r110, 8);
    L10:
        if (r104 == null) goto L13;
        r103 = r104;
    L13:
        r105.append(r103);
        tt5.a.h("OfficeSpacePerformanceReporter", r105.toString());
        return false;
    L16:
        if (r102.getClickStartMs() <= 0) goto L18;
        return true;
    L18:
        if (r110 == null) goto L20;
        r104 = StringsKt.takeLast(r110, 8);
    L20:
        if (r104 == null) goto L23;
        r103 = r104;
    L23:
        tt5.a.h("OfficeSpacePerformanceReporter", "skip office space open timing, invalid click start, runtime=".concat(r103));
        return false;
    }
}
