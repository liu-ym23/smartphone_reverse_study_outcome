package com.larus.office.base.utils;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361171a = 0;

    static {
    }

    public static void a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 == null) goto L5;
        Bundle r102 = r100.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    L6:
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r102 == null) goto L14;
        r102.remove("android:support:fragments");
    L14:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("removeAndroidSupportFragments: source=");
        r106.append(r101);
        r106.append(", hasSavedInstanceState=");
        if (r100 == null) goto L17;
        boolean r107 = true;
    L18:
        r106.append(r107);
        r106.append(", hasStateRegistry=");
        if (r102 == null) goto L21;
        r103 = true;
    L21:
        r106.append(r103);
        r106.append(", removed=");
        r106.append(r104);
        r105.i("OfficeFragmentUtil", r106.toString());
        return;
    L17:
        r107 = false;
        goto L18
    L9:
        if (r102.containsKey("android:support:fragments") != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
