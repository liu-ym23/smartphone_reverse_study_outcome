package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a8 extends b<String> {
    public a8() {
    }

    @Override // com.bytedance.salamander.anniex.b
    public final void d(Map<String, j8> r100) {
        Intrinsics.checkNotNullParameter(r100, "rules");
        ValidationAction r101 = ValidationAction.None;
        com.bytedance.rts.foundation.m.e(r100, "sdk_version", new j8("sdk_version", 100, r101));
        ValidationAction r102 = ValidationAction.CutOff;
        com.bytedance.rts.foundation.m.e(r100, "bid", new j8("bid", 64, r102));
        com.bytedance.rts.foundation.m.e(r100, "pid", new j8("pid", 100, r102));
        ValidationAction r103 = ValidationAction.Exception;
        com.bytedance.rts.foundation.m.e(r100, "js_base_release", new j8("js_base_release", 100, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_base_env", new j8("js_base_env", 100, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_base_context_key", new j8("js_base_context_key", 64, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_base_context_value", new j8("js_base_context_value", 128, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_exception_js_info_exception", new j8("js_exception_js_info_exception", 10000, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_exception_native_info_error_msg", new j8("js_exception_native_info_error_msg", 10000, r103));
        com.bytedance.rts.foundation.m.e(r100, "js_exception_root_cause", new j8("js_exception_native_info_root_cause", 1000, r103));
        com.bytedance.rts.foundation.m.e(r100, "jsb_perf_info_jsb_name", new j8("jsb_perf_info_jsb_name", 100, r101));
        com.bytedance.rts.foundation.m.e(r100, "jsb_error_bridge_name", new j8("jsb_error_bridge_name", 100, r101));
        com.bytedance.rts.foundation.m.e(r100, "jsb_error_error_message", new j8("jsb_error_error_message", 1000, r102));
        com.bytedance.rts.foundation.m.e(r100, "jsb_error_jsb_params", new j8("jsb_error_jsb_params", 1000, ValidationAction.Discard));
        com.bytedance.rts.foundation.m.e(r100, "schema", new j8("schema", 4000, r102));
        com.bytedance.rts.foundation.m.e(r100, "url", new j8("url", 4000, r102));
        com.bytedance.rts.foundation.m.e(r100, "end_to_end_error_msg", new j8("end_to_end_error_msg", 4000, r102));
        com.bytedance.rts.foundation.m.e(r100, "fetch_error_url", new j8("fetch_error_url", 1000, r102));
        com.bytedance.rts.foundation.m.e(r100, "fetch_error_request_error_msg", new j8("fetch_error_request_error_msg", 1000, r102));
        com.bytedance.rts.foundation.m.e(r100, "custom_category_key", new j8("custom_category_key", 80, r102));
        com.bytedance.rts.foundation.m.e(r100, "custom_category_value", new j8("custom_category_value", 500, r102));
    }

    @Override // com.bytedance.salamander.anniex.b
    public final o4<String> b(String r100, j8 r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276366p);
        int r103 = com.bytedance.rts.foundation.v.f267594a;
        if ((r102 instanceof String) == false) goto L11;
        int r104 = r102.length();
        int r105 = r101.f268166a;
        if (r104 > r105) goto L8;
        String r106 = r102;
    L10:
        return new o4(r102.length(), r106);
    L8:
        r106 = com.bytedance.rts.foundation.r.e(r102, 0, r105);
        goto L10
    L11:
        return new o4(0, "");
    }
}
