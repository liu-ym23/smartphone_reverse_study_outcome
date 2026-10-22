package xh5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements m {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // xh5.m
    public final Flowable<SimpleRequestResult> b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return null;
    }

    @Override // xh5.m
    public final Flowable<SimpleRequestResult> a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        JSONObject r5 = new JSONObject();
        r5.put("space_id", r3);
        r5.put("link_perm", 4);
        r5.put("allow_cross_tenant", Boolean.TRUE);
        NetService.f r6 = new NetService.f("/api/suite/permission/share_space/setting/update/");
        ((NetService.e) r6).c = 1;
        ((NetService.e) r6).j = r5.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r6);
    }
}
