package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(OfficeSpaceConfig r7, OfficeSpaceTab r8, OfficeSpaceEnterContext r9, String r10) {
        if (r7.getListConfig().getDisplayMode() == OfficeListDisplayMode.FLOW) goto L5;
        return false;
    L5:
        String r0 = "";
        String r3 = null;
        if (r8 == OfficeSpaceTab.RECENT) goto L16;
        StringBuilder r11 = new StringBuilder("skip office space open timing, initial tab is ");
        r11.append(r8);
        r11.append(", runtime=");
        if (r10 == null) goto L10;
        r3 = StringsKt.takeLast(r10, 8);
    L10:
        if (r3 == null) goto L13;
        r0 = r3;
    L13:
        r11.append(r0);
        tt5.a.h("OfficeSpacePerformanceReporter", r11.toString());
        return false;
    L16:
        if (r9.getClickStartMs() <= 0) goto L18;
        return true;
    L18:
        if (r10 == null) goto L20;
        r3 = StringsKt.takeLast(r10, 8);
    L20:
        if (r3 == null) goto L23;
        r0 = r3;
    L23:
        tt5.a.h("OfficeSpacePerformanceReporter", "skip office space open timing, invalid click start, runtime=".concat(r0));
        return false;
    }
}
