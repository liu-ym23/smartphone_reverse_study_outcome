package com.bytedance.ee.bear.contract;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.document.setting.DocumentSettingInfo;
import com.bytedance.ee.bear.document.setting.DocumentSettingRequest;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements com.bytedance.ee.bear.e {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    public final Flowable<DocumentSettingInfo> b(NetService r3) {
        Intrinsics.checkNotNullParameter(r3, "netService");
        NetService.f r0 = new NetService.f("/space/api/user_properties/get/");
        r0.c = 2;
        return r3.Vc(new com.bytedance.ee.bear.document.setting.i()).a(r0);
    }

    public final Flowable<DefaultResponse> a(DocumentSettingRequest r5, NetService r6) {
        Intrinsics.checkNotNullParameter(r5, "req");
        Intrinsics.checkNotNullParameter(r6, "netService");
        NetService.d r7 = r6.Vc(new ax4.a());
        NetService.f r0 = new NetService.f("/space/api/user_properties/set/");
        r0.i = false;
        r0.c = 1;
        r0.j = JSON.toJSONString(r5, new SerializerFeature[]{SerializerFeature.PrettyFormat});
        return r7.a(r0);
    }
}
