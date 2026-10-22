package d25;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.document.offline.base.OfflineResultModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import io.reactivex.Flowable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Set<String>> f466514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, JSONObject> f466515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f466516c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f466517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f466518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f466519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f466520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f466521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f466522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f466523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static BearUrl f466524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f466525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f466526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f466527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f466528o;

    static {
        f466514a = new HashMap();
        f466515b = new HashMap();
        f466516c = new CopyOnWriteArrayList();
        sbb.e r100 = sbb.e.f541294e;
        f466519f = r100.f541317b;
        f466520g = r100.getType();
        f466521h = r100.getType();
        f466524k = null;
        r100.getClass();
        r100.getType();
        f466525l = false;
        f466526m = false;
    }

    public static String d() {
        BearUrl r100 = f466524k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f222577r;
    }

    public static void i() {
        tt5.a.b("OfflineUtils", "resetPreloadAnalyticData");
        f466525l = false;
        f466526m = false;
        f466527n = null;
        f466528o = null;
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("OfflineUtils", e, false);
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0061: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777313), block:B:27:0x0061 */
    public static String b(InputStream r100) {
        StringBuffer r101 = new StringBuffer();
        Closeable r102 = null;
        if (r100 != null) goto L33;
    L20:
        tt5.a.d("OfflineUtils", "convertString()... steam is invalid");     // Catch: Throwable -> L16 IOException -> L18
        String r103 = r101.toString();     // Catch: Throwable -> L16 IOException -> L18
        a(r100);
        return r103;
    L33:
    L18:
        e = move-exception;
        BufferedReader r104 = null;
        IOException e100 = e;
    L24:
        tt5.a.f("OfflineUtils", e100, false);     // Catch: Throwable -> L12
    L25:
        a(r100);
        a(r104);
        return r101.toString();
    L16:
        th = th;
    L28:
        a(r100);
        a(r102);
        throw th;
    L5:
        if (r100.available() <= 0) goto L20;
        r104 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L16 IOException -> L18
    L31:
        String r105 = r104.readLine();     // Catch: Throwable -> L12 IOException -> L14
        if (r105 == null) goto L25;
        r101.append(r105 + System.getProperty("line.separator"));     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e100 = e;
    L12:
        th = th;
        r102 = r3;
        goto L28
    }

    public static String c(String r100) {
        String r101 = UriProtector.parse(r100).getPath();
        if (r101 != null) goto L5;
    L23:
        return "text/html";
    L5:
        if (r101.endsWith(".css") == false) goto L8;
        return "text/css";
    L8:
        if (r101.endsWith(".js") == false) goto L11;
        return "application/x-javascript";
    L11:
        if (r101.endsWith(".jpg") == false) goto L13;
    L22:
        return "image/*";
    L13:
        if (r101.endsWith(EffectConstants.GIF_FILE_SUFFIX) == true) goto L22;
        if (r101.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == true) goto L22;
        if (r101.endsWith(".jpeg") == true) goto L22;
        if (r101.endsWith(".webp") == true) goto L22;
        if (r101.endsWith(".bmp") == false) goto L23;
        goto L22
    }

    public static org.json.JSONObject e(String r100) {
        return new org.json.JSONObject(r100).optJSONObject("data").optJSONObject("collab_client_vars").optJSONObject("resources");
    L4:
        e = move-exception;
        tt5.a.d("OfflineUtils", "getResourcesByClientVar()... e = " + e);
        return null;
    }

    public static void k(String r100) {
        f466518e = r100;
        tt5.a.h("OfflineUtils", "setOpeningObjToken " + du5.b.g(r100));
    }

    public static void l(BearUrl r100) {
        f466524k = r100;
        if (r100 != null) goto L5;
    L7:
        sbb.e r101 = sbb.e.f541294e;
        r101.getClass();
        r101.getType();
        f466522i = null;
        f466523j = null;
        return;
    L5:
        if (TextUtils.isEmpty(r100.f222560a) == true) goto L7;
        sbb.e.g(r100.f222560a);
        f466522i = r100.f222561b;
        f466523j = r100.f222573n;
    }

    public static void n(String r100) {
        tt5.a.b("OfflineUtils", "updateClientVarUnusedReason");
        if (f466528o == null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        f466528o = r100;
        return;
    L10:
        if (f466526m == false) goto L12;
        f466528o = "memory_cache_unread";
        return;
    L12:
        f466528o = "no_cache";
    }

    public static void o(String r100) {
        tt5.a.b("OfflineUtils", "updateSsrUnusedReason");
        if (f466527n == null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        f466527n = r100;
        return;
    L10:
        if (f466525l == false) goto L12;
        f466527n = "memory_cache_unread";
        return;
    L12:
        f466527n = "no_cache";
    }

    public static void f(final OfflineResultModel r100, final m r101) {
        final long r102 = System.currentTimeMillis();
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new b(r100, r102, r101), new c(r101));
    }

    public static void g(String r100, m r101) {
        tt5.a.b("OfflineUtils", "onJsFailCallback()... errorMsg = " + r100);
        f(new OfflineResultModel(false, r100, ""), r101);
    }

    public static void h(String r100, m r101) {
        tt5.a.b("OfflineUtils", "onJsSuccessCallback()...");
        f(new OfflineResultModel(true, "", r100), r101);
    }

    public static void j(BearUrl r100, String r101) {
        if (r100 != null) goto L5;
    L10:
        sbb.e r102 = sbb.e.f541294e;
        f466519f = r102.f541317b;
        f466520g = r102.getType();
        f466517d = null;
        f466521h = r102.getType();
        f466518e = null;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl null");
        return;
    L5:
        if (TextUtils.isEmpty(r100.f222560a) == true) goto L10;
        f466519f = sbb.e.g(r100.f222560a);
        f466520g = r100.f222560a;
        String r103 = r100.f222561b;
        f466517d = r103;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl " + du5.b.g(r103));
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = r100.f222561b;
    L9:
        k(r101);
    }

    public static void m(String r100, String r101) {
        if (r100 != null) goto L18;
        return;
    L18:
        JSONArray r102 = new org.json.JSONObject(r100).optJSONArray("prefetchKeys");     // Catch: JSONException -> L15
        HashSet r103 = new HashSet();     // Catch: JSONException -> L15
        int r104 = 0;
    L6:
        if (r104 >= r102.length()) goto L12;
        if (JSONArrayProtectorUtils.getString(r102, r104) == null) goto L10;
        r103.add(JSONArrayProtectorUtils.getString(r102, r104));     // Catch: JSONException -> L15
    L10:
        r104 = r104 + 1;     // Catch: JSONException -> L15
        goto L6
    L12:
        if (r103.size() <= 0) goto L24;
        ((HashMap) f466514a).put(r101, r103);     // Catch: JSONException -> L15
        return;
    L24:
        return;
    L15:
        e = move-exception;
        tt5.a.f("OfflineUtils", e, false);
    }
}
