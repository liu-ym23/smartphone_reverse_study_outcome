package com.ss.android.lark.rustinfrabridge.store.service.impl.userscope;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.SetNetTypeRequest;
import com.bytedance.lark.pb.tool.v1.SetNetTypeResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class UserStoreService implements k3c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f439721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f439722b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439723a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[NetworkUtils.NetworkType.WIFI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f439723a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f439724a = null;

        static {
            f439724a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            x r101 = (x) r100;
            Log.i("UserStoreService", "update rust network state success ");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f439725a = null;

        static {
            f439725a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("UserStoreService", "update rust network state error:" + ((Throwable) r100));
        }
    }

    static {
    }

    @Inject
    public UserStoreService(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f439721a = r100;
    }

    @Override // k3c.a
    public final void B5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        NetworkUtils.NetworkType r101 = NetworkUtils.NetworkType.from(com.larksuite.framework.utils.NetworkUtils.b(r100));
        Log.i("UserStoreService", "update rust network state , networkState = " + r101);
        Intrinsics.checkNotNull(r101);
        hd(r101);
    }

    @Override // k3c.a
    public final void hd(NetworkUtils.NetworkType r110) {
        Intrinsics.checkNotNullParameter(r110, "networkState");
        int r111 = b.f439723a[r110.ordinal()];
        if (r111 != 1) goto L5;
        SetNetTypeRequest.NetType r112 = SetNetTypeRequest.NetType.ONLINE_2G;
    L17:
        SetNetTypeRequest.Builder r113 = new SetNetTypeRequest.Builder().net_type(r112);
        int r100 = this.f439722b;
        this.f439722b = r100 + 1;
        SetNetTypeRequest.Builder r101 = r113.invoke_order(Integer.valueOf(r100));
        Intrinsics.checkNotNull(r101);
        com.bytedance.lark.rustclient.api.d r114 = new com.bytedance.lark.rustclient.api.d(r101, SetNetTypeResponse.ADAPTER, Command.SET_NET_TYPE, null, null, null, null, 248);
        t.b(this.f439721a.h(r114).a()).subscribe(c.f439724a, d.f439725a);
        return;
    L5:
        if (r111 != 2) goto L7;
        r112 = SetNetTypeRequest.NetType.ONLINE_3G;
        goto L17
    L7:
        if (r111 != 3) goto L9;
    L14:
        r112 = SetNetTypeRequest.NetType.ONLINE_4G;
        goto L17
    L9:
        if (r111 == 4) goto L14;
        if (r111 == 5) goto L13;
        r112 = SetNetTypeRequest.NetType.OFFLINE;
        goto L17
    L13:
        r112 = SetNetTypeRequest.NetType.ONLINE_WIFI;
        goto L17
    }

    @Override // k3c.a
    public final void w1(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new UserStoreService$registerTimeZoneChangeReceiver$1(r100, this));
    }
}
