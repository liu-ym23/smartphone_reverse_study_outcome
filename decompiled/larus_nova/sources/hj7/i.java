package hj7;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.map.api.monitor.MonitorValueConst;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.js.spec.JsbridgeEventHelper;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.bytedance.ug.sdk.luckycat.impl.utils.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f485454a;

    public class a implements com.bytedance.ug.sdk.luckycat.impl.utils.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f485455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485456b;

        public final void a(boolean r100) {
            if (r100 == false) goto L5;
            this.f485455a.put("error_code", 1);     // Catch: JSONException -> L7
            this.f485455a.put("error_msg", "success");     // Catch: JSONException -> L7
            this.f485456b.callback(hj7.a.a(1, this.f485455a, "success"));     // Catch: JSONException -> L7
        L9:
            return;
        L5:
            this.f485455a.put("error_code", -1);     // Catch: JSONException -> L7
            this.f485455a.put("error_msg", "save image failed");     // Catch: JSONException -> L7
            this.f485456b.callback(hj7.a.a(-1, this.f485455a, "failed"));     // Catch: JSONException -> L7
        L7:
            this.f485456b.callback(hj7.a.a(-1, this.f485455a, "failed"));
        }

        public a(JSONObject r100, IBridgeContext r101) {
            this.f485455a = r100;
            this.f485456b = r101;
        }
    }

    public i() {
    }

    @BridgeMethod("appCommonParams")
    public void addCommonParams(@BridgeContext IBridgeContext r100) {
        HashMap r101 = new HashMap();
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.w(r101);
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: JSONException -> L8
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: JSONException -> L8
    L10:
        r100.callback(hj7.a.a(1, r102, "success"));
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @BridgeMethod("checkClipboard")
    public void checkClipboard(@BridgeContext IBridgeContext r100) {
        Context r101 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
        if (r101 == null) goto L5;
        String r102 = com.bytedance.ug.sdk.luckycat.impl.utils.e.g(r101);
    L6:
        JSONObject r103 = new JSONObject();
        r103.put("text", r102);     // Catch: Exception -> L9
        r100.callback(hj7.a.a(1, r103, "success"));     // Catch: Exception -> L9
    L11:
        r100.callback(hj7.a.a(0, r103, "fail"));
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        r102 = "";
        goto L6
    }

    @BridgeMethod("luckycatAppCommonParams")
    public void luckycatAddCommonParams(@BridgeContext IBridgeContext r100) {
        HashMap r101 = new HashMap();
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.w(r101);
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: JSONException -> L9
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: JSONException -> L9
        goto L5
    L7:
        r100.callback(hj7.a.a(1, r102, "success"));     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        r100.callback(hj7.a.a(0, r102, e.toString()));
    }

    @BridgeMethod("openTreasureBox")
    public void openTreasureBox(@BridgeContext IBridgeContext r100) {
        vj7.b.C8014b.f555426a.a("openTreasureBox");
        r100.callback(hj7.a.a(1, null, ""));
    }

    @BridgeMethod("signIn")
    public void signIn(@BridgeContext IBridgeContext r100) {
        vj7.b.C8014b.f555426a.a("signIn");
        r100.callback(hj7.a.a(1, null, ""));
    }

    public final void a(boolean r100, WebView r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("code", 1);     // Catch: Exception -> L8
        r102.put("message", "success");     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("bridge_version", "3.0");     // Catch: Exception -> L8
        r102.put("data", r103);     // Catch: Exception -> L8
        c(r103, r100);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        String r104 = "visible";
    L6:
        JsbridgeEventHelper.INSTANCE.sendEvent(r104, r103, r101);     // Catch: Exception -> L8
        return;
    L5:
        r104 = "invisible";
    }

    public final void b(boolean r100, WebView r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("code", 1);     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("bridge_version", "3.0");     // Catch: Exception -> L8
        r102.put("data", r103);     // Catch: Exception -> L8
        c(r103, r100);     // Catch: Exception -> L8
        r102.put("message", "success");     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        String r104 = "luckycatVisible";
    L6:
        JsbridgeEventHelper.INSTANCE.sendEvent(r104, r103, r101);     // Catch: Exception -> L8
        return;
    L5:
        r104 = "luckycatInvisible";
    }

    public final void c(JSONObject r100, boolean r101) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f485454a == false) goto L6;
        int r102 = 1;
    L7:
        r100.put("is_task_tab", r102);     // Catch: JSONException -> L11
        r100.put("is_selected_tab", 0);     // Catch: JSONException -> L11
        if (r101 == false) goto L16;
        Set<String> r103 = to7.a.f546943k;     // Catch: JSONException -> L11
        to7.a r104 = to7.a.d.f546961a;     // Catch: JSONException -> L11
        r100.put("page_name", r104.f546953j);     // Catch: JSONException -> L11
        String r105 = r104.f546953j;     // Catch: JSONException -> L11
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatCommonBridge", "pre_activity_name:" + r104.f546953j);     // Catch: JSONException -> L11
        return;
    L16:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @BridgeMethod("luckycatCacheShareToken")
    public void cacheShareToken(@BridgeContext IBridgeContext r100, @BridgeParam("token") String r101) {
        JSONObject r102 = new JSONObject();
    L14:
        r100.callback(hj7.a.a(-1, r102, "failed"));
        return;
    L5:
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f() != null) goto L9;
        r102.put("error_code", -1);     // Catch: Throwable -> L14
        r102.put("error_msg", MonitorValueConst.TYPE_CONTEXT_NULL);     // Catch: Throwable -> L14
        r100.callback(hj7.a.a(-1, r102, "failed"));     // Catch: Throwable -> L14
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        r102.put("error_code", -1);     // Catch: Throwable -> L14
        r102.put("error_msg", "token is empty");     // Catch: Throwable -> L14
        r100.callback(hj7.a.a(-1, r102, "failed"));     // Catch: Throwable -> L14
        return;
    L12:
        r102.put("error_code", -1);     // Catch: Throwable -> L14
        r102.put("error_msg", "cache failed");     // Catch: Throwable -> L14
        r100.callback(hj7.a.a(-1, r102, "failed"));     // Catch: Throwable -> L14
    }

    @BridgeMethod("luckycatCheckAppsInfo")
    public void checkAppsInfo(@BridgeContext IBridgeContext r110, @BridgeParam("pkg_list") JSONArray r111) {
        Context r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
        if (r100 != null) goto L6;
        r110.callback(hj7.a.a(0, null, MonitorValueConst.TYPE_CONTEXT_NULL));
        return;
    L6:
        JSONObject r101 = new JSONObject();
        if (r111 != null) goto L35;
    L30:
        r110.callback(hj7.a.a(1, r101, "success"));     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        r110.callback(hj7.a.a(0, r101, th.toString()));
        return;
    L35:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L32
        int r103 = 0;
    L10:
        if (r103 >= r111.length()) goto L29;
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L32
        String r105 = JSONArrayProtectorUtils.getString(r111, r103);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r105) == true) goto L28;
        PackageInfo r106 = r100.getPackageManager().getPackageInfo(r105, 0);     // Catch: Exception -> L27 Throwable -> L32
        if (r106 != null) goto L17;
        r104.put("is_install", 0);     // Catch: Exception -> L27 Throwable -> L32
        goto L28
    L17:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        r104.put("version_code", r106.getLongVersionCode());     // Catch: Exception -> L27 Throwable -> L32
    L20:
        r104.put("version_name", r106.versionName);     // Catch: Exception -> L27 Throwable -> L32
        if (r106.applicationInfo.enabled == false) goto L23;
        int r107 = 1;
    L24:
        r104.put("is_install", r107);     // Catch: Exception -> L27 Throwable -> L32
        goto L28
    L23:
        r107 = 0;
        goto L24
    L19:
        r104.put("version_code", r106.versionCode);     // Catch: Exception -> L27 Throwable -> L32
        goto L20
    L27:
        r104.put("is_install", 0);     // Catch: Throwable -> L32
    L28:
        r102.put(r105, r104);     // Catch: Throwable -> L32
        r103 = r103 + 1;     // Catch: Throwable -> L32
        goto L10
    L29:
        r101.put("apps_info", r102);     // Catch: Throwable -> L32
        goto L30
    }

    @BridgeMethod("luckycatCheckAppsInstalled")
    public void checkAppsInstalled(@BridgeContext IBridgeContext r100, @BridgeParam("pkg_list") JSONArray r101) {
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L18;
    L13:
        r100.callback(hj7.a.a(1, r102, "success"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        r100.callback(hj7.a.a(0, r102, th.toString()));
        return;
    L18:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L15
        int r104 = 0;
    L6:
        if (r104 >= r101.length()) goto L12;
        String r105 = JSONArrayProtectorUtils.getString(r101, r104);     // Catch: Throwable -> L15
        if (w.b(r105) == false) goto L10;
        int r106 = 1;
    L11:
        r103.put(r105, r106);     // Catch: Throwable -> L15
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L6
    L10:
        r106 = 0;
        goto L11
    L12:
        r102.put("apps_installed", r103);     // Catch: Throwable -> L15
        goto L13
    }

    @BridgeMethod("check_apps_installed")
    public void checkAppsInstalledForHelo(@BridgeContext IBridgeContext r100, @BridgeParam("pkg_list") JSONArray r101) {
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L12;
        int r103 = 0;
    L17:
    L14:
        th = move-exception;
        th.getMessage();
        return;
    L6:
        if (r103 >= r101.length()) goto L12;
        String r104 = JSONArrayProtectorUtils.getString(r101, r103);     // Catch: Throwable -> L14
        if (w.b(r104) == false) goto L10;
        int r105 = 1;
    L11:
        r102.put(r104, r105);     // Catch: Throwable -> L14
        r103 = r103 + 1;     // Catch: Throwable -> L14
        goto L17
    L10:
        r105 = 0;
    L12:
        r102.put("code", 0);     // Catch: Throwable -> L14
        r100.callback(hj7.a.a(0, r102, "success"));     // Catch: Throwable -> L14
    }

    @BridgeMethod("luckycatCheckClipboard")
    public void checkClipboard(@BridgeContext IBridgeContext r100, @BridgeParam(defaultBoolean = true, value = "is_forced") boolean r101) {
        if (r101 == true) goto L4;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
    L4:
        String r103 = com.bytedance.ug.sdk.luckycat.impl.utils.e.g(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f());
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L7
        r104.put("text", r103);     // Catch: Throwable -> L7
        r100.callback(hj7.a.a(1, r104, "success"));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r100.callback(hj7.a.a(0, null, th.toString()));
    }

    @BridgeMethod("toast")
    public void oldToast(@BridgeParam("text") String r100, @BridgeParam("icon_type") String r101) {
        Activity r102 = to7.c.b();
        if (r102 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.x(r102, r100);
        return;
    }

    @BridgeMethod("page_state_change")
    public void pageStateChange(@BridgeParam("type") String r100, @BridgeParam("status") int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        r100.getClass();
        if (r100.equals("task_action") == true) goto L9;
        return;
    L9:
        if (r101 != 1) goto L31;
        JSONObject r102 = new JSONObject();
        r102.put("code", "1");     // Catch: JSONException -> L24
        r102.put("from_tab", this.f485454a);     // Catch: JSONException -> L24
        com.bytedance.ug.sdk.luckycat.impl.manager.q r103 = com.bytedance.ug.sdk.luckycat.impl.manager.q.b.f271365a;     // Catch: JSONException -> L24
        com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.m();     // Catch: JSONException -> L24
        if (TextUtils.isEmpty("visible") == true) goto L32;
        WeakReference<WebView> r104 = r103.f271359d;     // Catch: JSONException -> L24
        if (r104 == null) goto L33;
        WebView r105 = r104.get();     // Catch: JSONException -> L24
        if (r105 == null) goto L34;
        r102.put("bridge_version", "3.0");     // Catch: JSONException -> L20
    L22:
        JsbridgeEventHelper.INSTANCE.sendEvent("visible", r102, r105);     // Catch: JSONException -> L24
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L24
        goto L22
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @BridgeMethod("luckycatSendRedDot")
    public void sendRedDot(@BridgeContext IBridgeContext r100, @BridgeParam("key") String r101) {
        vj7.b.C8014b.f555426a.a(r101);
        r100.callback(hj7.a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatScanQrcode")
    public void startQrScan(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101) {
        if (r100.getActivity() != null) goto L6;
        r100.callback(hj7.a.a(0, null, "context null"));
        return;
    L6:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
    }

    @BridgeMethod("luckycatSyncTime")
    public void syncTime(@BridgeContext IBridgeContext r100, @BridgeParam("scene") String r101) {
        TextUtils.isEmpty(r101);
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        r100.callback(hj7.a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatUpdateInviteCode")
    public void updateInviteCode(@BridgeContext IBridgeContext r100, @BridgeParam("invite_code") String r101) {
        u.a().g("self_invite_code", r101);
        r100.callback(hj7.a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatWebViewSettings")
    public void updateWebViewSetting(@BridgeContext IBridgeContext r100, @BridgeParam("text_zoom") int r101) {
        WebView r102 = r100.getWebView();
        if (r102 == null) goto L5;
        r102.getSettings().setTextZoom(r101);
    L5:
        r100.callback(hj7.a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatActivate")
    public void activate(@BridgeContext IBridgeContext r100, @BridgeParam("scene") String r101, @BridgeParam("status") int r102) {
        com.bytedance.ug.sdk.luckycat.impl.manager.m r103 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        r100.callback(hj7.a.a(1, null, "success"));
    }

    @BridgeMethod("awardToast")
    public void awardToast(@BridgeContext IBridgeContext r100, @BridgeParam("text") String r101, @BridgeParam("show_short") boolean r102) {
        com.bytedance.ug.sdk.luckycat.impl.manager.m r103 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        Context r104 = r103.f();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        if (r104 == null) goto L6;
        r103.x(r104, r101);
    L6:
        r100.callback(hj7.a.a(1, null, ""));
    }

    @BridgeMethod("copyToClipboard")
    public void copyToClipboard(@BridgeContext IBridgeContext r100, @BridgeParam("content") String r101, @BridgeParam("is_append_end") boolean r102) {
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r102 == false) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.utils.e.b(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f(), r101);
    L7:
        int r103 = 1;
    L9:
        JSONObject r104 = new JSONObject();
        r104.put("code", r103);     // Catch: JSONException -> L12
    L14:
        r100.callback(hj7.a.a(1, r104, "success"));
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L6:
        com.bytedance.ug.sdk.luckycat.impl.utils.e.a((ClipboardManager) com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f().getSystemService(DataType.CLIPBOARD), ClipData.newPlainText("", r101));
        goto L7
    L8:
        r103 = 0;
        goto L9
    }

    @BridgeMethod("luckycatSaveImageToAlbum")
    public void saveImageToAlbum(@BridgeContext IBridgeContext r100, @BridgeParam("base64Code") String r101, @BridgeParam(defaultBoolean = false, value = "is_cached") boolean r102) {
        JSONObject r103 = new JSONObject();
    L9:
        r100.callback(hj7.a.a(-1, r103, "failed"));
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r103.put("error_code", -1);     // Catch: Throwable -> L9
        r103.put("error_msg", "base64Code is empty");     // Catch: Throwable -> L9
        r100.callback(hj7.a.a(-1, r103, "failed"));     // Catch: Throwable -> L9
        return;
    L7:
        com.bytedance.ug.sdk.luckycat.impl.utils.j.a(r100.getActivity(), r101, r102, new a(r103, r100));     // Catch: Throwable -> L9
    }

    @BridgeMethod("luckycatCopyToClipboard")
    public void copyToClipboard(@BridgeContext IBridgeContext r100, @BridgeParam("text") String r101, @BridgeParam("is_append_end") boolean r102, @BridgeParam(defaultBoolean = true, value = "is_forced") boolean r103) {
        if (r103 == true) goto L4;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r104 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
    L4:
        if (r102 == false) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.utils.e.b(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f(), r101);
    L7:
        r100.callback(hj7.a.a(1, null, "success"));
        return;
    L6:
        com.bytedance.ug.sdk.luckycat.impl.utils.e.a((ClipboardManager) com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f().getSystemService(DataType.CLIPBOARD), ClipData.newPlainText("", r101));
        goto L7
    }
}
