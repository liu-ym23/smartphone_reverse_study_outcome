package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends com.bytedance.sdk.xbridge.cn.protocol.c<ReadableMap, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f269993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f269994c;

    public i() {
        this.f269993b = new g();
        this.f269994c = "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final com.bytedance.sdk.xbridge.cn.protocol.g<ReadableMap, Object> c() {
        return this.f269993b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final Object b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = this.f269994c;
        if (Intrinsics.areEqual(r102, "webcast") == false) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        HashMap r104 = new HashMap();
        r104.put("__msg_type", "callback");
        r104.put(com.heytap.mcssdk.constant.b.f276361k, 0);
        r104.put("__callback_id", "0");
        r104.put("code", Integer.valueOf(r100));
        JavaOnlyMap r105 = new JavaOnlyMap();
        r105.put("msg", r101);
        Unit r106 = Unit.INSTANCE;
        r104.put("data", r105);
        return JavaOnlyMap.from(r104);
    L9:
        HashMap r107 = new HashMap();
        r107.put("code", Integer.valueOf(r100));
        r107.put("msg", r101);
        return JavaOnlyMap.from(r107);
    L5:
        r103 = Intrinsics.areEqual(r102, "host");
        goto L7
    }
}
