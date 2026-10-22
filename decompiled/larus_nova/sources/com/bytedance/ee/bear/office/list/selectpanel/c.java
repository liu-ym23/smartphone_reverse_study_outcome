package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f236020a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236021a = null;

        static {
            int[] r100 = new int[OfficeSelectPanelAction.values().length];
            r100[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f236021a = r100;
        }
    }

    static {
    }

    public static OfficeSpaceEventSource a(OfficeSpaceTab r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (r101 == false) goto L5;
        OfficeListDisplayMode r102 = OfficeListDisplayMode.GRID;
    L7:
        return new OfficeSpaceEventSource(r100, r102, -1);
    L5:
        r102 = OfficeListDisplayMode.LIST;
        goto L7
    }
}
