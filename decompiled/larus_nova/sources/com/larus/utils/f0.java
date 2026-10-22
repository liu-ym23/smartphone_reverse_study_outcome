package com.larus.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375390a = 0;

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (NetworkUtils.isNetworkAvailable(r100) == true) goto L6;
        FLogger.f375446a.i("NetworkUtilsExt", "isNetworkAvailableAndValid false, NetworkUtils unavailable");
        return false;
    L6:
        boolean r101 = true;
        if (Build.VERSION.SDK_INT >= 23) goto L41;
        FLogger.f375446a.i("NetworkUtilsExt", "isNetworkAvailableAndValid true, skip validated capability below M");
        return true;
    L41:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L33
        Object r103 = r100.getSystemService("connectivity");     // Catch: Throwable -> L33
        if ((r103 instanceof ConnectivityManager) == false) goto L13;
        ConnectivityManager r104 = (ConnectivityManager) r103;     // Catch: Throwable -> L33
    L14:
        if (r104 != null) goto L16;
        return false;
    L16:
        NetworkInfo r105 = r104.getActiveNetworkInfo();     // Catch: Throwable -> L33
        if (r105 != null) goto L19;
    L21:
        r101 = false;
    L22:
        if (r101 == true) goto L25;
        FLogger.f375446a.i("NetworkUtilsExt", "isNetworkAvailableAndValid false, activeNetworkInfo not connected");     // Catch: Throwable -> L33
        return false;
    L25:
        Network r106 = r104.getActiveNetwork();     // Catch: Throwable -> L33
        if (r106 != null) goto L28;
        return false;
    L28:
        NetworkCapabilities r107 = r104.getNetworkCapabilities(r106);     // Catch: Throwable -> L33
        if (r107 != null) goto L31;
        return false;
    L31:
        boolean r108 = r107.hasCapability(16);     // Catch: Throwable -> L33
        FLogger.f375446a.i("NetworkUtilsExt", "isNetworkAvailableAndValid valid:" + r108);     // Catch: Throwable -> L33
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L33
    L35:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L40;
        FLogger.f375446a.e("NetworkUtilsExt", "isNetworkAvailableAndValid error", r110);
        r109 = Boolean.FALSE;
    L40:
        return ((Boolean) r109).booleanValue();
    L19:
        if (r105.isConnected() != true) goto L21;
    L13:
        r104 = null;
    L33:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    }
}
