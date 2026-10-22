package com.bytedance.security.android.aopcheck.settings;

import android.os.Build;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.sdk.open.douyin.settings.f;
import com.bytedance.security.android.aopcheck.env.AOPEnvironment;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.agilelogger.ALog;
import h37.b;
import h37.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingsRequestServiceImpl;", "Lh37/b;", "", "executeSettingGet", "Lh37/c;", "request", "Lorg/json/JSONObject;", "o", "", "isApiSuccess", "<init>", "()V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 4, 0})
public final class SettingsRequestServiceImpl implements b {
    private static String BASE_URL = null;
    public static final Companion Companion = null;
    private static final String TAG = "SettingsRequestService";
    private static final INetworkApi ttnetClient = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingsRequestServiceImpl$Companion;", "", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "setBASE_URL", "(Ljava/lang/String;)V", "TAG", "ttnetClient", "Lcom/bytedance/ttnet/INetworkApi;", "kotlin.jvm.PlatformType", "execGet", "relativePath", "queryMap", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public final String getBASE_URL() {
            return SettingsRequestServiceImpl.access$getBASE_URL$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setBASE_URL(String r100) {
            SettingsRequestServiceImpl.access$setBASE_URL$cp(r100);
        }

        public final String execGet(String r100, Map<String, String> r110) {
            if (SettingsRequestServiceImpl.access$getTtnetClient$cp() == null) goto L13;
            LinkedList r101 = new LinkedList();
            return SettingsRequestServiceImpl.access$getTtnetClient$cp().doGet(false, BmLocated.ALIGN_RIGHT_BOTTOM, r100, r110, r101, null).execute().body();
        L7:
            e = move-exception;
            e.printStackTrace();
            return null;
        L13:
            return null;
        }
    }

    public SettingsRequestServiceImpl() {
    }

    static {
        Companion = new Companion(null);
        BASE_URL = "https://is.snssdk.com/";
        ttnetClient = (INetworkApi) RetrofitUtils.createSsService("https://is.snssdk.com/", INetworkApi.class);
    }

    private final String executeSettingGet() {
        HashMap r100 = new HashMap();     // Catch: Throwable -> L5
        r100.put(Constant.KEY_CALL_NAME, Constant.SETTING_NAME);     // Catch: Throwable -> L5
        JSONObject r101 = AOPEnvironment.INSTANCE.getHeaderInfo();     // Catch: Throwable -> L5
        r100.put("host_aid", r101.optString("host_aid"));     // Catch: Throwable -> L5
        r100.put("app_id", r101.optString("host_aid"));     // Catch: Throwable -> L5
        r100.put("device_id", r101.optString("device_id"));     // Catch: Throwable -> L5
        r100.put("device_platform", "android");     // Catch: Throwable -> L5
        r100.put("device_type", "Android");     // Catch: Throwable -> L5
        r100.put("update_version_code", r101.optString("update_version_code"));     // Catch: Throwable -> L5
        r100.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L5
        r100.put("os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: Throwable -> L5
        r100.put("device_model", Build.MODEL);     // Catch: Throwable -> L5
        r100.put("device_brand", Build.BRAND);     // Catch: Throwable -> L5
        r100.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L5
        r100.put("version_code", r101.optString("app_version"));     // Catch: Throwable -> L5
        r100.put(Constant.KEY_AOP_CHECK_SDK_VERSION, r101.optString(Constant.KEY_AOP_CHECK_SDK_VERSION));     // Catch: Throwable -> L5
        r100.put("channel", r101.optString("channel"));     // Catch: Throwable -> L5
        return Companion.execGet("service/settings/v3/", r100);
    L5:
        th = move-exception;
        th.getMessage();
        th.printStackTrace();
        return null;
    }

    @Override // h37.b
    public c request() {
        c r100 = new c();
        String r101 = executeSettingGet();     // Catch: Throwable -> L20 JSONException -> L22
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return r100;
    L12:
        ALog.i(TAG, "Settings response: " + r101);     // Catch: Throwable -> L20 JSONException -> L22
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L20 JSONException -> L22
        if (isApiSuccess(r103) == true) goto L15;
        return r100;
    L15:
        JSONObject r104 = r103.optJSONObject("data");     // Catch: Throwable -> L20 JSONException -> L22
        if (r104 == null) goto L19;
        SettingsData r105 = new SettingsData(r104.optJSONObject("settings").optJSONObject("sdk_key_mobius_sdk"), null);     // Catch: Throwable -> L20 JSONException -> L22
        c r106 = new c();     // Catch: Throwable -> L20 JSONException -> L22
        r106.f483722b = r105;     // Catch: Throwable -> L20 JSONException -> L22
        r106.f483723c = r104.optJSONObject(f.f269710g);     // Catch: Throwable -> L20 JSONException -> L22
        r106.f483724d = r104.optString("ctx_infos");     // Catch: Throwable -> L20 JSONException -> L22
        r106.f483721a = true;     // Catch: Throwable -> L20 JSONException -> L22
    L27:
        return r106;
    L19:
        return r100;
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
    L22:
        e = move-exception;
        ALog.e(TAG, "Cannot approach here" + e);
        return r100;
    L20:
        th = move-exception;
        ALog.e(TAG, "Cannot approach here" + th);
        return r100;
    }

    public static final /* synthetic */ String access$getBASE_URL$cp() {
        return BASE_URL;
    }

    public static final /* synthetic */ INetworkApi access$getTtnetClient$cp() {
        return ttnetClient;
    }

    public static final /* synthetic */ void access$setBASE_URL$cp(String r100) {
        BASE_URL = r100;
    }

    public final boolean isApiSuccess(JSONObject r100) throws JSONException {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Intrinsics.areEqual("success", r100.optString("message")) == false) goto L6;
        return true;
    }
}
