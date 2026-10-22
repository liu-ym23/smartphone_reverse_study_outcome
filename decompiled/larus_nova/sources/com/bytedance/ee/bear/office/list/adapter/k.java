package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235794a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235795a = null;

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
            f235795a = r100;
        }
    }

    static {
    }
}
