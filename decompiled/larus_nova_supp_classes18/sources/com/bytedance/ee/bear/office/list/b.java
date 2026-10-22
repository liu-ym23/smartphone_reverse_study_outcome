package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.office.export.space.OfficeFolderSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceTab.values().length];
            r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final OfficeFolderSource a(OfficeSpaceTab r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L12;
        return OfficeFolderSource.FAVORITE;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return OfficeFolderSource.SHARED;
    L19:
        return OfficeFolderSource.MINE;
    L16:
        return OfficeFolderSource.RECENT;
    }
}
