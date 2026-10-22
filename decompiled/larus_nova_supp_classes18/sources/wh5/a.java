package wh5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<BatchDocUserPermission> {

    /* JADX INFO: renamed from: wh5.a$a, reason: collision with other inner class name */
    public static final class C0323a {
    }

    static {
    }

    public a() {
    }

    public final Result parse(String r4) {
        JSONObject r5 = new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L5
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r5, "perms");     // Catch: Exception -> L5
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r5, "permissions_v2");     // Catch: Exception -> L5
        Object r2 = JSON.parse(r1.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");     // Catch: Exception -> L5
        Object r7 = JSON.parse(r6.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Int>");     // Catch: Exception -> L5
        return new BatchDocUserPermission((Map) r2, (Map) r7);
    L5:
        e = move-exception;
        tt5.a.d("PublicShareParser", "parser error: " + e);
        return new BatchDocUserPermission(null, null, 3, null);
    }
}
