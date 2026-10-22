package com.larus.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f375385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConnectivityManager f375386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f375387c = null;

    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            Handler r101 = e0.f375385a;
            r101.removeCallbacksAndMessages(null);
            r101.postDelayed(new d0(true), 300);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            Handler r101 = e0.f375385a;
            r101.removeCallbacksAndMessages(null);
            r101.postDelayed(new d0(false), 300);
        }
    }

    public e0() {
    }

    static {
        f375385a = new Handler(Looper.getMainLooper());
        Object r100 = AppHost.f326268a.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r101 = (ConnectivityManager) r100;
        f375386b = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        NetworkInfo r103 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        boolean r104 = r103.isConnected();     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L9
    L11:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = r106;
    L14:
        f375387c = new MutableLiveData(r105);
        f375386b.registerNetworkCallback(new NetworkRequest.Builder().build(), new a());     // Catch: Exception -> L17
        return;
    L22:
        return;
    L6:
        r104 = false;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
