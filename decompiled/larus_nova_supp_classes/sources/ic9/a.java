package ic9;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.d;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.api.IApmConfigs;
import com.larus.apm.api.IApmTrace;
import com.larus.apm.api.IExtraParams;
import com.larus.bmhome.chat.screenshot.j;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.api.e1;
import com.larus.platform.api.n1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import ps3.b;
import x8a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements n1 {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.larus.platform.api.n1
    public final String a() {
        IApmConfigs r0 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.n1
    public final String b() {
        return IExtraParams.a.b();
    }

    @Override // com.larus.platform.api.n1
    public final void c() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        IApmTrace.a.g("NAVIGATION_LOCATING");
    }

    @Override // com.larus.platform.api.n1
    public final void d() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        IApmTrace.a.e("NAVIGATION_LOCATING");
    }

    @Override // com.larus.platform.api.n1
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        st3.a.b().c(r2);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (AppHost.a.isOversea() == true) goto L10;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = r0.h();
    L8:
        if (r1 == true) goto L10;
        return;
    L7:
        r1 = false;
    L10:
        EnsureManager.ensureNotReachHere(r2);
    }

    @Override // com.larus.platform.api.n1
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        st3.a.b().d(r2);
    }

    @Override // com.larus.platform.api.n1
    public final e1 h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        return new a(r2);
    }

    @Override // com.larus.platform.api.n1
    public final void i(j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Npth.registerCrashCallback(new b(r2), CrashType.ALL);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        if (AppHost.a.isOversea() == true) goto L10;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = r0.h();
    L8:
        if (r1 == true) goto L10;
        return;
    L7:
        r1 = false;
    L10:
        EnsureManager.ensureNotReachHere(r2);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (AppHost.a.isOversea() == true) goto L10;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = r0.h();
    L8:
        if (r1 == true) goto L10;
        return;
    L7:
        r1 = false;
    L10:
        EnsureManager.ensureNotReachHere(r2, r3);
    }

    @Override // com.larus.platform.api.n1
    public final void f(byte[] r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "payload");
        Intrinsics.checkNotNullParameter(r7, "msgHeaders");
        c r0 = c.b();
        r0.getClass();
        if (d.j() == false) goto L5;
        b.a(new String[]{"handleCloudMessage payload and headers"});
    L5:
        HashMap r8 = (HashMap) r7;
        if (r8.size() <= 0) goto L13;
        Iterator r1 = r8.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r3 = (String) r1.next();
        if ("ran".equals(r3) == false) goto L9;
        String r9 = com.bytedance.apm.util.c.a(r6, (String) r8.get(r3));
    L15:
        if (TextUtils.isEmpty(r9) == false) goto L31;
        r9 = com.bytedance.apm.util.c.a(r6, XmlPullParser.NO_NAMESPACE);
    L31:
        JSONObject r10 = new JSONObject(r9).optJSONObject("configs");     // Catch: JSONException -> L28
        if (r10 == null) goto L39;
        JSONArray r11 = r10.optJSONArray("cloud_commands");     // Catch: JSONException -> L28
        if (r11 == null) goto L40;
        int r12 = 0;
    L23:
        if (r12 >= r11.length()) goto L41;
        String r2 = r11.optString(r12);     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(r2) == true) goto L27;
        r0.c.execute(new x8a.a(r0, r2));     // Catch: JSONException -> L28
    L27:
        r12 = r12 + 1;
        goto L23
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r9 = XmlPullParser.NO_NAMESPACE;
        goto L15
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "selfDefineData");
        if (AppHost.a.isOversea() == true) goto L10;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = r0.h();
    L8:
        if (r1 == true) goto L10;
        return;
    L7:
        r1 = false;
    L10:
        EnsureManager.ensureNotReachHere(r2, r3, r4);
    }

    @Override // com.larus.platform.api.n1
    public final void monitorEventForSlardar(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ApmAgent.monitorEvent(r2, r3, r4, r5);
    }
}
