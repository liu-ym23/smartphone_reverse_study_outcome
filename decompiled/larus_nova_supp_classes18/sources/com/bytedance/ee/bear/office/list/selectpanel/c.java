package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSelectPanelAction.values().length];
            r0[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public static OfficeSpaceEventSource a(OfficeSpaceTab r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        if (r3 == false) goto L5;
        OfficeListDisplayMode r4 = OfficeListDisplayMode.GRID;
    L7:
        return new OfficeSpaceEventSource(r2, r4, -1);
    L5:
        r4 = OfficeListDisplayMode.LIST;
        goto L7
    }
}
