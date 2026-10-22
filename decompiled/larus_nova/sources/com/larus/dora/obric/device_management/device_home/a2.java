package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a2 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339171a = null;

        static {
            int[] r100 = new int[DoraObricDeviceModeEntryProduct.values().length];
            r100[DoraObricDeviceModeEntryProduct.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DoraObricDeviceModeEntryProduct.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DoraObricDeviceModeEntryProduct.G_AIR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraObricDeviceModeEntryProduct.G_PIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DoraObricDeviceModeEntryProduct.UNSUPPORTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f339171a = r100;
        }
    }

    public static final boolean a(DoraObricDeviceModeEntryProduct r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f339171a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 != 2) goto L7;
        return true;
    L7:
        if (r101 != 3) goto L9;
        return true;
    L9:
        if (r101 != 4) goto L11;
        return true;
    L11:
        if (r101 != 5) goto L14;
        return false;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
