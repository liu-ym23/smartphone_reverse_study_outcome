package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final boolean a() {
        Object r100 = LarkNetworkLevelManager.f439693d;
        if (b(LarkNetworkLevelManager.a.a().getCurNetWorkLevel()) == true) goto L20;
        Object r101 = LarkContext.getApplication().getSystemService("connectivity");
        if ((r101 instanceof ConnectivityManager) == false) goto L7;
        ConnectivityManager r102 = (ConnectivityManager) r101;
    L9:
        if (r102 == null) goto L15;
        NetworkInfo r103 = r102.getActiveNetworkInfo();
        if (r103 == null) goto L15;
        if (r103.isConnected() != true) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L21;
        return false;
    L21:
        return true;
    L15:
        r104 = false;
        goto L16
    L7:
        r102 = null;
        goto L9
    L20:
        return true;
    }

    public static final boolean b(NetworkLevelListener.NetworkLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != NetworkLevelListener.NetworkLevel.NET_UNAVAILABLE) goto L5;
    L10:
        return true;
    L5:
        if (r100 == NetworkLevelListener.NetworkLevel.SERVICE_UNAVAILABLE) goto L10;
        if (r100 == NetworkLevelListener.NetworkLevel.OFFLINE) goto L10;
        return false;
    }
}
