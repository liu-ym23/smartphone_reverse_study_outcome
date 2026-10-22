package com.ss.android.ugc.aweme.search.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class NetworkUtilsKt {
    public static final boolean a(Context r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L11
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r102 == null) goto L14;
        if (r102.isAvailable() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }
}
