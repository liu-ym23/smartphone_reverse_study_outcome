package com.bytedance.ee.bear.contract;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.connection.NetworkDetector;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.connection.rust.NetStateChangeRustManager;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements ConnectionService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f217089b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f217090a = null;

        static {
            f217090a = new j();
        }
    }

    public final void b() {
        if (this.f217089b == true) goto L10;
        this.f217089b = true;
        tt5.a.h("ConnectionServiceImp", "init rustEnable: true");
        Context r100 = this.f217088a;
        int r101 = fw4.c.f479006a;
        NetStateChangeRustManager r102 = NetStateChangeRustManager.f216713e;
        if (r100 == null) goto L7;
        r102.getClass();
        Context r103 = r100.getApplicationContext();
    L8:
        r102.f479004b = r103;
        Object r104 = LarkNetworkLevelManager.f439693d;
        LarkNetworkLevelManager.a.a().w0((NetworkLevelListener) NetStateChangeRustManager.f216714f.getValue());
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.contract.ConnectionService
    public final ConnectionService.NetworkState getNetworkState() {
        return c(fw4.d.b(this.f217088a));
    }

    public j() {
        this.f217089b = false;
        this.f217088a = eu5.b.a();
    }

    @Override // com.bytedance.ee.bear.contract.ConnectionService
    public final LiveData<ConnectionService.NetworkState> a() {
        b();
        return Transformations.map(new NetworkDetector(this.f217088a), new i(this));
    }

    public final void finalize() throws Throwable {
        b();
        int r100 = fw4.c.f479006a;
        NetStateChangeRustManager.f216713e.getClass();
        Object r101 = LarkNetworkLevelManager.f439693d;
        LarkNetworkLevelManager.a.a().x0((NetworkLevelListener) NetStateChangeRustManager.f216714f.getValue());
        super.finalize();
    }

    public static ConnectionService.NetworkState c(NetworkType r100) {
        if (r100 != NetworkType.NETWORK_2G) goto L6;
        int r101 = 4;
    L22:
        return new ConnectionService.NetworkState(r101);
    L6:
        if (r100 != NetworkType.NETWORK_3G) goto L9;
        r101 = 3;
        goto L22
    L9:
        if (r100 != NetworkType.NETWORK_4G) goto L12;
        r101 = 2;
        goto L22
    L12:
        if (r100 != NetworkType.NETWORK_MOBILE) goto L15;
        r101 = 5;
        goto L22
    L15:
        if (r100 != NetworkType.NETWORK_WIFI) goto L18;
        r101 = 1;
        goto L22
    L18:
        if (r100 != NetworkType.NETWORK_UNKNOWN) goto L20;
        r101 = 0;
        goto L22
    L20:
        r101 = 6;
        goto L22
    }
}
