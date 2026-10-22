package en6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.model.constant.SaasHost;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements mq6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f473175a = null;

    static {
        f473175a = new l();
    }

    public l() {
    }

    public final void b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        int r103 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, com.bytedance.locallife.biz.utils.c.b(r101, SaasHost.AWEME.getHostName()));
    }

    public final void c(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        int r102 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.utils.c.a(r101, SaasHost.AWEME.getHostName());
        int r103 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.d(r100, r101);
    }

    public final void a(String r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        HostServiceUtilsKt.l().monitorEvent(r100, r101, r102, null);
    }
}
