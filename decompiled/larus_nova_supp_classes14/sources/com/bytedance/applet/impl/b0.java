package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements IHostNetworkDepend {

    public static final class a implements IAppletRetrofit {
        public final /* synthetic */ XIRetrofit a;

        public a(XIRetrofit r1) {
            this.a = r1;
        }

        public final <T> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            return (T) this.a.create(r2);
        }
    }

    public b0() {
    }

    public final IAppletRetrofit createRetrofit(String r3, boolean r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "baseUrl");
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        Map r6 = MapsKt.plus(r5, TuplesKt.to("flowAppletNetworkInterceptor", com.bytedance.applet.impl.a.a));
        XBaseRuntime r0 = XBaseRuntime.a;
        r0.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.f r1 = XBaseRuntime.k;
        if (r1 == null) goto L10;
        XIRetrofit r7 = r1.createRetrofit(r3, r4, r6);
        if (r7 == null) goto L10;
    L17:
        return new a(r7);
    L10:
        r0.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend r8 = XBaseRuntime.j;
        if (r8 == null) goto L13;
        r7 = r8.createRetrofit(r3, r4);
    L14:
        if (r7 != null) goto L17;
        return null;
    L13:
        r7 = null;
        goto L14
    }
}
