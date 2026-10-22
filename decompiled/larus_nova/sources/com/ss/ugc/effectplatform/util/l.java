package com.ss.ugc.effectplatform.util;

import android.content.Context;
import android.net.ConnectivityManager;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458042a = 0;

    static {
    }

    public static boolean a(Object r100) {
        if (r100 != null) goto L4;
    L11:
        return false;
    L4:
        if ((r100 instanceof Context) == false) goto L11;
        Object r101 = ((Context) r100).getSystemService("connectivity");     // Catch: Exception -> L13
        if (r101 == null) goto L10;
        return ((ConnectivityManager) r101).getActiveNetworkInfo().isConnected();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L13
    }
}
