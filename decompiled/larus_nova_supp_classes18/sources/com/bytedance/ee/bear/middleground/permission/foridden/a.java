package com.bytedance.ee.bear.middleground.permission.foridden;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.Flowable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.foridden.a$a, reason: collision with other inner class name */
    public static final class C0110a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final String c() {
        c r0 = c.a.a;
        String r1 = (String) r0.d("biz_domain_config", "");
        String r2 = (String) r0.d("tns_report_config", "");
        Intrinsics.checkNotNull(r1);
        String r3 = e(r1);
        Intrinsics.checkNotNull(r2);
        String r4 = f(r2);
        return new Uri.Builder().scheme("https").authority(r3).path(r4).appendEncodedPath("appeal").build().toString();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final Uri.Builder getReportHost() {
        c r0 = c.a.a;
        String r1 = (String) r0.d("biz_domain_config", "");
        String r2 = (String) r0.d("tns_report_config", "");
        Intrinsics.checkNotNull(r1);
        String r3 = e(r1);
        Intrinsics.checkNotNull(r2);
        String r4 = f(r2);
        Locale r5 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        return new Uri.Builder().scheme("https").authority(r3).path(r4).appendQueryParameter("lang", r5.getLanguage() + '-' + r5.getCountry());
    }

    public static String e(String r7) {
        String r3 = "";
        if (TextUtils.isEmpty(r7) == false) goto L21;
    L20:
        return r3;
    L21:
        JSONObject r2 = new JSONObject(r7);     // Catch: Throwable -> L19
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == false) goto L11;
        JSONArray r4 = r2.optJSONArray("tns_report_feishu");     // Catch: Throwable -> L19
        if (r4 == null) goto L17;
        String r5 = r4.optString(0);     // Catch: Throwable -> L19
        if (r5 == null) goto L17;
    L16:
        r3 = r5;
    L17:
        tt5.a.h("ComplainStateImpl", "getRetentionHost()...result = ".concat(r3));     // Catch: Throwable -> L19
        goto L20
    L11:
        JSONArray r6 = r2.optJSONArray("tns_report_lark");     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        r5 = r6.optString(0);     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
    L19:
        tt5.a.d("ComplainStateImpl", "parse retentionHost error,  domainConfigStr = " + r7);
        goto L20
    }

    public static String f(String r5) {
        String r3 = "";
        if (TextUtils.isEmpty(r5) == true) goto L10;
        r3 = new JSONObject(r5).optString("report_path");     // Catch: Throwable -> L6
        tt5.a.h("ComplainStateImpl", "getRetentionHost()...result = " + r3);     // Catch: Throwable -> L6
        return r3;
    L6:
        tt5.a.d("ComplainStateImpl", "parse retentionHost error,  domainConfigStr = " + r5);
        return r3;
    L10:
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final void b(Context r1) {
        if (r1 == null) goto L7;
        z9c.a r2 = (z9c.a) ApiUtils.getApi(z9c.a.class);
        if (r2 == null) goto L8;
        r2.a();
        return;
    L8:
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final String a(String r6, int r7, boolean r8) {
        c r0 = c.a.a;
        String r1 = (String) r0.d("biz_domain_config", "");
        String r2 = (String) r0.d("tns_report_config", "");
        Intrinsics.checkNotNull(r1);
        String r3 = e(r1);
        Intrinsics.checkNotNull(r2);
        String r4 = f(r2);
        Locale r5 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        Uri.Builder r9 = new Uri.Builder().scheme("https").authority(r3).path(r4).appendEncodedPath("appeal").appendQueryParameter("entity_id", r6 + ':' + r7).appendQueryParameter("entity_type", "ccm_web_id").appendQueryParameter("scene", "ccm_ban").appendQueryParameter("lang", r5.getLanguage() + '-' + r5.getCountry());
        if (r8 == false) goto L6;
        r9.appendEncodedPath("detail");
    L6:
        return r9.build().toString();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a
    public final Flowable<GetComplaintResult> d(int r3, String r4, boolean r5) {
        NetService.f r0 = new NetService.f("/space/api/platform/review/complaint/get/");
        r0.b("obj_type", String.valueOf(r3));
        r0.b(ResourceData.KEY_OBJ_TOKEN, r4);
        if (r5 == false) goto L6;
        r0.b("transit", String.valueOf(true));
    L6:
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b()).a(r0);
    }
}
