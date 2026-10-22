package xh5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements m {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // xh5.m
    public final Flowable<SimpleRequestResult> b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        NetService.f r0 = new NetService.f("/space/api/suite/permission/space/setting/update.v2/");
        ((NetService.e) r0).j = r4.toJSONString();
        ((NetService.e) r0).c = 1;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r0);
    }

    @Override // xh5.m
    public final Flowable<SimpleRequestResult> a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_TOKEN, r3);
        r1.put(ResourceData.KEY_TYPE, Integer.valueOf(r4));
        r1.put("link_share_entity", 4);
        return b(r1);
    }
}
