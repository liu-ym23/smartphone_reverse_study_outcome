package com.bytedance.ee.bear.document;

import com.alibaba.fastjson.JSON;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i5 implements com.bytedance.ee.bear.lynx.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vv4.k f219952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, tb5.m> f219953b;

    public static final class a {
    }

    static {
    }

    public i5(vv4.k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        this.f219952a = r100;
        this.f219953b = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.lynx.api.g
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        Intrinsics.checkNotNullParameter(r101, "params");
        tt5.a.b("LynxWebDelegateImpl", "callJSBridgeCallback, bridgeName = " + r100 + ", params = " + r101);
        tb5.m r102 = (tb5.m) ((LinkedHashMap) this.f219953b).get(r100);
        if (r102 == null) goto L6;
        r102.b(JSON.parseObject(r101));
        return;
    }

    public final void c(String r100, tb5.m r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        Intrinsics.checkNotNullParameter(r101, "callBackFunction");
        this.f219953b.put(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lynx.api.g
    public final void b(String r100, String r101, te5.b.a r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.b("LynxWebDelegateImpl", "execJSMethod, method = " + r100 + ", params = " + r101);
        this.f219952a.a(r100, JSON.parseObject(r101), r102);
    }
}
