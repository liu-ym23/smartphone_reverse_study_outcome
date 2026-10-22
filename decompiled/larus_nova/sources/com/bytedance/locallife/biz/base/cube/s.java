package com.bytedance.locallife.biz.base.cube;

import com.bytedance.locallife.model.constant.SaasHost;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f256551a = null;

    static {
        f256551a = new s();
    }

    public s() {
    }

    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter("local_service_opt_event", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.utils.c.a(r100, SaasHost.AWEME.getHostName());
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.d("local_service_opt_event", r100);
    }

    public final void a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        int r103 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, com.bytedance.locallife.biz.utils.c.b(r101, SaasHost.AWEME.getHostName()));
    }
}
