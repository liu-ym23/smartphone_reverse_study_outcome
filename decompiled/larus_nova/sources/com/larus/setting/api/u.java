package com.larus.setting.api;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.network.HttpConst;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f367928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f367929b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f367930c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f367931d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f367932e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f367933f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f367934g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f367935h = null;

    public u() {
    }

    static {
        StringBuilder r100 = new StringBuilder();
        HttpConst r101 = HttpConst.f359979a;
        r101.getClass();
        String r102 = HttpConst.f359991g;
        r100.append(r102);
        r100.append("/legal/vulnerability");
        f367928a = r100.toString();
        StringBuilder r103 = new StringBuilder();
        r101.getClass();
        r103.append(r102);
        r103.append("/legal/community_guidelines");
        f367929b = r103.toString();
        StringBuilder r104 = new StringBuilder();
        r101.getClass();
        r104.append(r102);
        r104.append("/legal/ip_protection_guideline");
        f367930c = r104.toString();
        StringBuilder r105 = new StringBuilder();
        r101.getClass();
        r105.append(r102);
        r105.append("/ocean_legal/permissions");
        f367931d = r105.toString();
        StringBuilder r106 = new StringBuilder();
        r101.getClass();
        r106.append(r102);
        r106.append("/legal/third_parties");
        f367932e = r106.toString();
        f367933f = "https://www.volcengine.com/product/yunque?utm_campaign=doubao_app&utm_content=setting_button&utm_medium=setting_button&utm_source=external_cooperation&utm_term=doubao_app_setting_button";
        f367934g = "https://mp.oceancloudapi.com/api/gw/plugin/doaction_pass_query";
        f367935h = "https://mp.oceancloudapi.com/api/doubao/do_action_v2";
    }

    public static JSONObject a(String r100, JSONObject r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "funName");
        Intrinsics.checkNotNullParameter("FPA_Audio", "scene");
        Intrinsics.checkNotNullParameter("7367318881150451738", "botId");
        Intrinsics.checkNotNullParameter(r100, "apiName");
        JSONObject r103 = new JSONObject();
        r103.put("scene", "FPA_Audio");
        r103.put("bot_id", "7367318881150451738");
        r103.put("ext", new JSONObject());
        r103.put("trace_info", new JSONObject());
        JSONObject r104 = new JSONObject();
        r104.put("api_name", r100);
        if (r101 != null) goto L8;
        r101 = new JSONObject();
    L8:
        r104.put("params", r101.toString());
        Unit r105 = Unit.INSTANCE;
        r103.put(WsConstants.KEY_PAYLOAD, r104.toString());
        return r103;
    }
}
