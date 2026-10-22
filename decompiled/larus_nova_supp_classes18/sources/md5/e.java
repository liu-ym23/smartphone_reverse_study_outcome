package md5;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Flowable<OwnerType> a(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "objToken");
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/explorer/v2/entity/info/");
        ((NetService.e) r1).c = 1;
        JSONObject r2 = new JSONObject();
        r2.put(ResourceData.KEY_OBJ_TOKEN, r5);
        r2.put("obj_type", Integer.valueOf(r6));
        JSONArray r3 = new JSONArray();
        r3.add(r2);
        JSONObject r4 = new JSONObject();
        r4.put("entities", r3);
        ((NetService.e) r1).j = r4.toJSONString();
        return r0.Vc(new f(r6, r5)).a(r1);
    }
}
