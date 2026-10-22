package com.ss.android.ugc.aweme.shortvideo.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class NetStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f454191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<NetChangeObserver> f454192b = null;

    static {
        f454191a = false;
        f454192b = new ArrayList();
    }

    public NetStateReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L5;
    L6:
        NetworkInfo[] r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getAllNetworkInfo();
        int r103 = 0;
        if (r102 == null) goto L15;
        int r104 = 0;
    L10:
        if (r104 >= r102.length) goto L15;
        if (r102[r104].getState() == NetworkInfo.State.CONNECTED) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L18;
        f454191a = false;
    L26:
        ArrayList<NetChangeObserver> r106 = f454192b;
        if (r106.isEmpty() == true) goto L44;
        int r107 = r106.size();
    L29:
        if (r103 >= r107) goto L45;
        NetChangeObserver r108 = (NetChangeObserver) ListProtector.get(f454192b, r103);
        if (r108 == null) goto L36;
        if (f454191a == false) goto L35;
        r108.b();
        goto L36
    L35:
        r108.a();
    L36:
        r103 = r103 + 1;
        goto L29
    L45:
        return;
    L44:
        return;
    L18:
        f454191a = true;
        NetworkInfo r109 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r109 == null) goto L26;
        if (NetUtils.a(r109) == null) goto L26;
        if (r109.getType() != 0) goto L26;
        NetUtils.a(r109).toLowerCase(Locale.getDefault()).equals("cmnet");
    L15:
        r105 = false;
        goto L16
    L5:
        if (r101.getAction().equalsIgnoreCase("com.ss.ugc.aweme.CONNECTIVITY_CHANGE") == true) goto L6;
    }
}
