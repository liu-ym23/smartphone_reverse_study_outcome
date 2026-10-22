package ws7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.api.IDTFacade;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.AndroidDocConfig;
import com.dtf.face.config.Coll;
import com.dtf.face.config.IConstValues;
import com.dtf.face.config.Protocol;
import com.dtf.face.config.ProtocolContent;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.FaceLoadingActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Object> f561088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f561089b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Resources f561090c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f561091d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f561092e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<String, Object> f561093f;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f561094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f561095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f561096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f561097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ File f561098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f561099f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f561100g;

        public final void a() {
            Pair<File, String> r100 = e.b(this.f561094a, this.f561095b.getCacheDir() + "/dtf/lang/", this.f561096c, null, 0);
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L9:
            if (r101 == true) goto L11;
            h.b(String.format("%s_%s", new Object[]{this.f561100g, this.f561099f}), true);
            RecordService.getInstance().recordEvent(4, "MultiLanException", new String[]{"downloadErrMsg", this.f561094a});
            return;
        L11:
            if ("v000000".equals(this.f561097d) == false) goto L22;
            File r102 = this.f561098e;
            JSONObject r103 = p.e(r102);     // Catch: JSONException -> L26
            if (r103.containsKey("version") == false) goto L18;
            String r104 = r103.getString("version");     // Catch: JSONException -> L26
            if (r102.renameTo(new PolarisFileWrapper(r102.getAbsolutePath().replace("v000000", r104))) == false) goto L18;
        L20:
            if (t.a(r104) == true) goto L23;
            p.a(this.f561095b, this.f561099f, r104, this.f561100g);
        L23:
            h.b(String.format("%s_%s", new Object[]{this.f561100g, this.f561099f}), false);
            return;
        L18:
            r104 = "";
            goto L20
        L22:
            p.a(this.f561095b, this.f561099f, this.f561097d, this.f561100g);
            goto L23
        L5:
            if (r100.first == null) goto L7;
            r101 = true;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, Context r101, String r102, String r103, PolarisFileWrapper r104, String r105, String r106) {
            this.f561094a = r100;
            this.f561095b = r101;
            this.f561096c = r102;
            this.f561097d = r103;
            this.f561098e = r104;
            this.f561099f = r105;
            this.f561100g = r106;
        }
    }

    public p() {
    }

    public static JSONObject e(File r100) {
    L6:
        e = move-exception;
        RecordService.getInstance().recordEvent(4, "MultiLanException", new String[]{"errMsg", RecordService.getStackTraceString(e)});
    L9:
        return new JSONObject();
    L3:
        if (r100.exists() == false) goto L9;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L6
        JSONObject r102 = JSON.parseObject(g.a(r101));     // Catch: Exception -> L6
        r101.close();     // Catch: Exception -> L6
        return r102;
    }

    public static List<String> l(Context r100) {
        if (f561089b != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f561089b != null) goto L9;
        f561089b = Arrays.asList(s.g(r100));     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return f561089b;
    }

    public static String m(String r100) {
        return r100.substring(0, r100.lastIndexOf(".")).substring(r100.lastIndexOf("_") + 1);
    L5:
        e = move-exception;
        RecordService.getInstance().recordEvent(4, "MultiLanException", new String[]{"errMsg", RecordService.getStackTraceString(e)});
        return "";
    }

    public static void o(Context r100) {
        String r101 = hs7.a.h().e();
        Iterator<String> r102 = l(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        boolean r104 = false;
        String r105 = String.format("%s_%s", new Object[]{r103, r101});
        SharedPreferences r106 = h.f561075a;
        if (r106 == null) goto L11;
        if (r105 == null) goto L11;
        r104 = r106.getBoolean(r105, false);
    L11:
        if (r104 == false) goto L13;
    L14:
        c(r100, "v000000", r101, r103);
    L16:
        if (n(r100, null, "en", r103) == true) goto L4;
        c(r100, "v000000", "en", r103);
        goto L4
    L13:
        if (n(r100, null, r101, r103) == true) goto L16;
    }

    public static void p(FaceLoadingActivity r100) {
        String r101 = hs7.a.h().e();
        Iterator<String> r102 = l(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        String r103 = r102.next();
        AndroidClientConfig r104 = hs7.a.h().c();
        if (r104 == null) goto L12;
        Coll r105 = r104.getColl();
        if (r105 == null) goto L12;
        String r106 = r105.multiLangVer;
        if (TextUtils.isEmpty(r106) == true) goto L12;
    L25:
        c(r100, r106, r101, r103);
        if ("en".equals(r101) == true) goto L4;
        c(r100, r106, "en", r103);
    L12:
        Protocol r107 = hs7.a.h().f486994f;
        if (r107 == null) goto L19;
        ProtocolContent r108 = r107.protocolContent;
        if (r108 == null) goto L19;
        AndroidDocConfig r109 = r108.docConfig;
        if (r109 == null) goto L19;
    L20:
        if (r109 == null) goto L24;
        Coll r110 = r109.getColl();
        if (r110 == null) goto L24;
        r106 = r110.multiLangVer;
    L24:
        r106 = "";
    L19:
        r109 = null;
        goto L20
    }

    public static void b(Map<String, Object> r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.containsKey(IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE) == false) goto L35;
        Object r102 = r100.get(IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE);
        if ((r102 instanceof String) == false) goto L36;
        String r103 = (String) r102;
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return;
    L10:
        if ("en".equals(r103) == false) goto L12;
    L25:
        boolean r104 = true;
    L26:
        RecordService r105 = RecordService.getInstance();
        String[] r106 = new String[8];
        r106[0] = "status";
        r106[1] = "init";
        r106[2] = "caller";
        r106[3] = r101;
        r106[4] = "acceptConfig";
        if (r104 == false) goto L29;
        String r107 = "1";
    L30:
        r106[5] = r107;
        r106[6] = "value";
        r106[7] = r103;
        r105.recordEvent(4, "zimLan", r106);
        if (r104 == false) goto L38;
        f561092e = r103;
        hs7.a.h().f487014z = r103;
        return;
    L38:
        return;
    L29:
        r107 = "0";
        goto L30
    L12:
        if ("in".equals(r103) == true) goto L25;
        if (IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA.equals(r103) == true) goto L25;
        if (IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO.equals(r103) == true) goto L25;
        if ("zh-CN".equals(r103) == true) goto L25;
        if (IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK.equals(r103) == true) goto L25;
        if (IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW.equals(r103) == true) goto L25;
        r104 = false;
        goto L26
    L36:
        return;
    }

    public static void d(JSONObject r100, String r101) {
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        f561088a.put(r101 + "_" + r103, r104);
        goto L4
    L7:
        JSONObject r105 = (JSONObject) r104;
        if (f561088a == null) goto L4;
        Iterator<Map.Entry<String, Object>> r106 = r105.getInnerMap().entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L4;
        Map.Entry<String, Object> r107 = r106.next();
        f561088a.put(r101 + "_" + r107.getKey(), r107.getValue());
        goto L11
    }

    public static String j(String r100, String r101) {
        if (r100.contains(r101) == false) goto L8;
        String r102 = r100.replace("DTF_" + r101 + "_", "");
        int r103 = r102.lastIndexOf("_");
        if (r103 <= 0) goto L8;
        return r102.substring(0, r103);
    L8:
        return "";
    }

    public static String f(Context r100, String r101, int r102) {
        Map<String, Object> r103 = f561093f;
        if (r103 == null) goto L9;
        if (((HashMap) r103).containsKey(r101) == false) goto L9;
        return String.valueOf(((HashMap) f561093f).get(r101));
    L9:
        return k(r100, r101, r102);
    }

    public static String g(Context r100, String r101, int r102) {
        String r103 = "FACE_".concat(r101);
        if (hs7.a.h().f486997i != null) goto L7;
        return f(r100, r103, r102);
    L7:
        return k(r100, r103, r102);
    }

    public static String h(Context r100, int r101, String r102) {
        String r103 = "GUIDE_".concat(r102);
        if (hs7.a.h().f486997i != null) goto L7;
        return f(r100, r103, r101);
    L7:
        return k(r100, r103, r101);
    }

    public static String i(Context r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return "";
    L5:
        File[] r103 = new PolarisFileWrapper(r100.getCacheDir(), "/dtf/lang/").listFiles();
        if (r103 == null) goto L14;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        String r106 = r103[r105].getName();
        if (r101.toUpperCase().equals(j(r106, r102)) == true) goto L12;
        r105 = r105 + 1;
        goto L8
    L12:
        return m(r106);
    L14:
        return "";
    }

    public static String k(Context r110, String r111, int r112) {
        if (TextUtils.isEmpty(r111) == true) goto L47;
        Map<String, Object> r100 = f561088a;
        if (r100 != null) goto L39;
        if (r100 == null) goto L8;
    L17:
        String r101 = hs7.a.h().e();
        Iterator<String> r102 = l(r110).iterator();
    L19:
        if (r102.hasNext() == false) goto L26;
        String r103 = r102.next();
        String r113 = i(r110, r101, r103);
        if (t.a(r113) == false) goto L24;
        r101 = "en";
        r113 = i(r110, "en", r103);
    L24:
        if (t.a(r113) == false) goto L19;
        boolean r104 = false;
    L27:
        new JSONObject();
        if (r104 == false) goto L39;
        if (r110 == null) goto L39;
        Iterator<String> r105 = l(r110).iterator();
    L32:
        if (r105.hasNext() == false) goto L39;
        String r106 = r105.next();
        String r114 = i(r110, r101, r106);     // Catch: JSONException -> L38
        d(e(new PolarisFileWrapper(r110.getCacheDir() + "/dtf/lang/", String.format("DTF_%s_%s_%s.json", new Object[]{r106, r101.toUpperCase(), r114}))), r106);     // Catch: JSONException -> L38
        goto L32
    L26:
        r104 = true;
        goto L27
    L8:
        monitor-enter(p.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f561088a != null) goto L12;
        f561088a = new HashMap();     // Catch: Throwable -> L14
    L12:
        monitor-exit(p.class);     // Catch: Throwable -> L14
    L39:
        Map<String, Object> r107 = f561088a;
        if (r107 == null) goto L47;
        if (((HashMap) r107).containsKey(r111) == false) goto L47;
        return ((HashMap) f561088a).get(r111).toString();
    L47:
        if (r112 != (-1)) goto L49;
        return "";
    L49:
        if (f561091d == true) goto L70;
        if (f561090c != null) goto L70;
        String r108 = hs7.a.h().e();
        if (r108 != null) goto L55;
    L68:
        f561091d = true;
        goto L70
    L55:
        if (r108.equals(j.b()) == true) goto L68;
        String r109 = hs7.a.h().e();
        Resources r115 = null;
        if (r110 != null) goto L86;
    L67:
        f561090c = r115;
        goto L70
    L86:
        if (r109.contains("-") == false) goto L63;
        String[] r116 = r109.split("-");     // Catch: Throwable -> L81
        String r117 = r116[0];     // Catch: Throwable -> L81
        String r118 = r116[1];     // Catch: Throwable -> L81
        r109 = r117;
    L66:
        RecordService.getInstance().recordEvent(4, "zimLan", new String[]{"status", "create", IConstValues.LANGUAGE, r109, EffectConfiguration.KEY_REGION, r118});     // Catch: Throwable -> L81
        Configuration r119 = new Configuration(r110.getResources().getConfiguration());     // Catch: Throwable -> L81
        r119.setLocale(new Locale(r109, r118));     // Catch: Throwable -> L81
        Context r120 = r110.createConfigurationContext(r119);     // Catch: Throwable -> L81
        NewMiraResourcesManager.getInstance().install(r120);     // Catch: Throwable -> L81
        r115 = r120.getResources();     // Catch: Throwable -> L81
        goto L67
    L63:
        r118 = "";
    L70:
        if (f561091d == true) goto L72;
        Resources r121 = f561090c;
        if (r121 != null) goto L78;
        return "";
    L78:
        return r121.getString(r112);
    L72:
        return s.f(r110, r112);
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        if (r100 == null) goto L19;
        File[] r104 = new PolarisFileWrapper(r100.getCacheDir(), "/dtf/lang/").listFiles();
        if (r104 == null) goto L14;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L20;
        File r107 = r104[r106];
        String r108 = r107.getName();
        String r109 = m(r108);
        String r110 = j(r108, r103);
        if (r101.toUpperCase().equals(r110) == false) goto L13;
        if (r109.equals(r102) == true) goto L13;
        f.f(r107);
    L13:
        r106 = r106 + 1;
        goto L7
    L20:
        return;
    L14:
        return;
    }

    public static void c(Context r110, String r111, String r112, String r113) {
        if (t.a(r111) == false) goto L5;
        r111 = "v000000";
    L5:
        String r100 = r111;
        if (n(r110, r100, r112, r113) == true) goto L22;
        if (r110 == null) goto L23;
        String r114 = s.f(r110, R.string.dtf_multi_lan_download_url);
        if (TextUtils.isEmpty(r114) == false) goto L11;
        return;
    L11:
        String r101 = String.format("DTF_%s_%s_%s.json", new Object[]{r113, r112.toUpperCase(), r100});
        String r102 = String.format(r114, new Object[]{r113.toLowerCase(), r112});
        PolarisFileWrapper r115 = new PolarisFileWrapper(r110.getCacheDir() + "/dtf/lang/");
        if (r115.exists() == true) goto L14;
        r115.mkdirs();
    L14:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r115.getAbsolutePath(), r101);
        ts7.c.c(new a(r102, r110, r101, r100, r116, r112, r113));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        f.f(r116);
        RecordService.getInstance().recordEvent(4, "MultiLanException", new String[]{"DownloadErrMsg", e.getMessage()});
        h.b(String.format("%s_%s", new Object[]{r113, r112}), true);
        return;
    L23:
        return;
    }

    public static boolean n(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (t.a(r101) == false) goto L8;
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getCacheDir() + "/dtf/lang/");
        if (r104.exists() == true) goto L15;
        return false;
    L15:
        File[] r105 = r104.listFiles();
        if (r105 == null) goto L23;
        int r106 = r105.length;
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L23;
        if (j(r105[r107].getName(), r103).equals(r102.toUpperCase()) == true) goto L21;
        r107 = r107 + 1;
        goto L18
    L21:
        return true;
    L23:
        return false;
    L8:
        if ("v000000".equals(r101) == true) goto L12;
        return new PolarisFileWrapper(r100.getCacheDir() + "/dtf/lang/", String.format("DTF_%s_%s_%s.json", new Object[]{r103, r102.toUpperCase(), r101})).exists();
    }
}
