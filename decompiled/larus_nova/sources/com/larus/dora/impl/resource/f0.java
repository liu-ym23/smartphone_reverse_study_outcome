package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f337872a = null;

        static {
            int[] r100 = new int[DoraEnableScope.values().length];
            r100[DoraEnableScope.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DoraEnableScope.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DoraEnableScope.G_SERIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f337872a = r100;
        }
    }

    public static final String a(DoraEnableScope r100) {
        int r101 = a.f337872a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1;
    L5:
        if (r101 != 2) goto L7;
        return DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2;
    L7:
        if (r101 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("G_SERIES is not a device grant".toString());
    }
}
