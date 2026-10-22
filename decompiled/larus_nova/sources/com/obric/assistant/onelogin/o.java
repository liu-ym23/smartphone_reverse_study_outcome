package com.obric.assistant.onelogin;

import android.net.ConnectivityManager;
import android.net.Network;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.login.f0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends ConnectivityManager.NetworkCallback {
    public o() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        FLogger.f375446a.i("ObricOneLoginImpl", "network onAvailable, check account is same or not");
        f0.f390252a.getClass();
        f0.a("logout_by_check_account_network_available");
    }
}
