package oh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Flowable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Flowable<CreateInstanceResult> a(String r7, int r8, String r9, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "escapeSetting");
        Intrinsics.checkNotNullParameter(r10, "escapeReason");
        Intrinsics.checkNotNullParameter(r12, "permReqParam");
        NetService.d r1 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new c());
        NetService.f r2 = new NetService.f("/space/api/sec_label/escape_rule/approval/instance/create/");
        ((NetService.e) r2).c = 1;
        ((NetService.e) r2).j = GsonProtectorUtils.toJson(new Gson(), MapsKt.mapOf(new Pair[]{TuplesKt.to(ResourceData.KEY_TOKEN, r7), TuplesKt.to(ResourceData.KEY_TYPE, Integer.valueOf(r8)), TuplesKt.to("escape_setting", r9), TuplesKt.to("escape_reason", r10), TuplesKt.to("perm_req_type", Integer.valueOf(r11)), TuplesKt.to("perm_req_param", r12)}));
        return r1.a(r2);
    }
}
