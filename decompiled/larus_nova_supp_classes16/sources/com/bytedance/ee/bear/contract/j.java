package com.bytedance.ee.bear.contract;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.connection.NetworkDetector;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.connection.rust.NetStateChangeRustManager;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements ConnectionService {
    public final Context a;
    public boolean b;

    public static class a {
        public static final j a = null;

        static {
            a = new j();
        }
    }

    public final void b() {
        if (this.b == true) goto L10;
        this.b = true;
        tt5.a.h("ConnectionServiceImp", "init rustEnable: true");
        Context r0 = this.a;
        int r1 = fw4.c.a;
        NetStateChangeRustManager r2 = NetStateChangeRustManager.e;
        if (r0 == null) goto L7;
        r2.getClass();
        Context r3 = r0.getApplicationContext();
    L8:
        r2.b = r3;
        Object r4 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().w0((NetworkLevelListener) NetStateChangeRustManager.f.getValue());
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.contract.ConnectionService
    public final ConnectionService.NetworkState getNetworkState() {
        return c(fw4.d.b(this.a));
    }

    public j() {
        this.b = false;
        this.a = eu5.b.a();
    }

    @Override // com.bytedance.ee.bear.contract.ConnectionService
    public final LiveData<ConnectionService.NetworkState> a() {
        b();
        return Transformations.map(new NetworkDetector(this.a), new i(this));
    }

    public final void finalize() throws Throwable {
        b();
        int r0 = fw4.c.a;
        NetStateChangeRustManager.e.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().x0((NetworkLevelListener) NetStateChangeRustManager.f.getValue());
        super.finalize();
    }

    public static ConnectionService.NetworkState c(NetworkType r1) {
        if (r1 != NetworkType.NETWORK_2G) goto L6;
        int r2 = 4;
    L22:
        return new ConnectionService.NetworkState(r2);
    L6:
        if (r1 != NetworkType.NETWORK_3G) goto L9;
        r2 = 3;
        goto L22
    L9:
        if (r1 != NetworkType.NETWORK_4G) goto L12;
        r2 = 2;
        goto L22
    L12:
        if (r1 != NetworkType.NETWORK_MOBILE) goto L15;
        r2 = 5;
        goto L22
    L15:
        if (r1 != NetworkType.NETWORK_WIFI) goto L18;
        r2 = 1;
        goto L22
    L18:
        if (r1 != NetworkType.NETWORK_UNKNOWN) goto L20;
        r2 = 0;
        goto L22
    L20:
        r2 = 6;
        goto L22
    }
}
