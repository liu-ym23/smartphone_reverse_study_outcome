package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.office.export.space.OfficeFolderSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235885a = null;

        static {
            int[] r100 = new int[OfficeSpaceTab.values().length];
            r100[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f235885a = r100;
        }
    }

    public static final OfficeFolderSource a(OfficeSpaceTab r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f235885a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
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
