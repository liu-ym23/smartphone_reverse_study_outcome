package ic9;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.wschannel.WsConstants;
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
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f489256a = null;

    /* JADX INFO: renamed from: ic9.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes29.dex */
    public static final class C6253a implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ct3.b f489257a;

        @Override // com.larus.platform.api.e1
        public final void startTrace() {
            this.f489257a.b();
        }

        public C6253a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            this.f489257a = new ct3.b(r100);
        }

        @Override // com.larus.platform.api.e1
        public final void a(int r100) {
            this.f489257a.a(r100, -1);
        }

        @Override // com.larus.platform.api.e1
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spanName");
            ct3.f r101 = this.f489257a.f465314a;
            if (r101 == null) goto L6;
            r101.a("", r100);
            return;
        }

        @Override // com.larus.platform.api.e1
        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spanName");
            ct3.f r101 = this.f489257a.f465314a;
            if (r101 == null) goto L6;
            r101.d("", r100);
            return;
        }
    }

    static {
        f489256a = new a();
    }

    public a() {
    }

    @Override // com.larus.platform.api.n1
    public final String a() {
        IApmConfigs r100 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.n1
    public final String b() {
        return IExtraParams.f286942a.b();
    }

    @Override // com.larus.platform.api.n1
    public final void c() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        IApmTrace.f286937a.g("NAVIGATION_LOCATING");
    }

    @Override // com.larus.platform.api.n1
    public final void d() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        IApmTrace.f286937a.e("NAVIGATION_LOCATING");
    }

    @Override // com.larus.platform.api.n1
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        st3.a.b().c(r100);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (AppHost.f326268a.isOversea() == true) goto L10;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r101 = ISecPrivacyService.a.a();
        if (r101 == null) goto L7;
        boolean r102 = r101.h();
    L8:
        if (r102 == true) goto L10;
        return;
    L7:
        r102 = false;
    L10:
        EnsureManager.ensureNotReachHere(r100);
    }

    @Override // com.larus.platform.api.n1
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        st3.a.b().d(r100);
    }

    @Override // com.larus.platform.api.n1
    public final e1 h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return new C6253a(r100);
    }

    @Override // com.larus.platform.api.n1
    public final void i(j r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Npth.registerCrashCallback(new b(r100), CrashType.ALL);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        if (AppHost.f326268a.isOversea() == true) goto L10;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r101 = ISecPrivacyService.a.a();
        if (r101 == null) goto L7;
        boolean r102 = r101.h();
    L8:
        if (r102 == true) goto L10;
        return;
    L7:
        r102 = false;
    L10:
        EnsureManager.ensureNotReachHere(r100);
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (AppHost.f326268a.isOversea() == true) goto L10;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L7;
        boolean r103 = r102.h();
    L8:
        if (r103 == true) goto L10;
        return;
    L7:
        r103 = false;
    L10:
        EnsureManager.ensureNotReachHere(r100, r101);
    }

    @Override // com.larus.platform.api.n1
    public final void f(byte[] r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r101, "msgHeaders");
        x8a.c r102 = x8a.c.b();
        r102.getClass();
        if (com.bytedance.apm.d.j() == false) goto L5;
        ps3.b.a(new String[]{"handleCloudMessage payload and headers"});
    L5:
        HashMap r103 = (HashMap) r101;
        if (r103.size() <= 0) goto L13;
        Iterator r104 = r103.keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        String r105 = (String) r104.next();
        if ("ran".equals(r105) == false) goto L9;
        String r106 = com.bytedance.apm.util.c.a(r100, (String) r103.get(r105));
    L15:
        if (TextUtils.isEmpty(r106) == false) goto L31;
        r106 = com.bytedance.apm.util.c.a(r100, "");
    L31:
        JSONObject r107 = new JSONObject(r106).optJSONObject(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);     // Catch: JSONException -> L28
        if (r107 == null) goto L39;
        JSONArray r108 = r107.optJSONArray("cloud_commands");     // Catch: JSONException -> L28
        if (r108 == null) goto L40;
        int r109 = 0;
    L23:
        if (r109 >= r108.length()) goto L41;
        String r110 = r108.optString(r109);     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(r110) == true) goto L27;
        r102.f562945c.execute(new x8a.a(r102, r110));     // Catch: JSONException -> L28
    L27:
        r109 = r109 + 1;
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
        r106 = "";
        goto L15
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "selfDefineData");
        if (AppHost.f326268a.isOversea() == true) goto L10;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r103 = ISecPrivacyService.a.a();
        if (r103 == null) goto L7;
        boolean r104 = r103.h();
    L8:
        if (r104 == true) goto L10;
        return;
    L7:
        r104 = false;
    L10:
        EnsureManager.ensureNotReachHere(r100, r101, r102);
    }

    @Override // com.larus.platform.api.n1
    public final void monitorEventForSlardar(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ApmAgent.monitorEvent(r100, r101, r102, r103);
    }
}
