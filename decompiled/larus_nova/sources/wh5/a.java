package wh5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<BatchDocUserPermission> {

    /* JADX INFO: renamed from: wh5.a$a, reason: collision with other inner class name */
    public static final class C8113a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L5
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "perms");     // Catch: Exception -> L5
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r101, "permissions_v2");     // Catch: Exception -> L5
        Object r104 = JSON.parse(r102.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");     // Catch: Exception -> L5
        Object r105 = JSON.parse(r103.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");     // Catch: Exception -> L5
        return new BatchDocUserPermission((Map) r104, (Map) r105);
    L5:
        e = move-exception;
        tt5.a.d("PublicShareParser", "parser error: " + e);
        return new BatchDocUserPermission(null, null, 3, null);
    }
}
