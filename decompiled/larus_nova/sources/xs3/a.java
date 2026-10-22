package xs3;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.apm.d;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IHttpService;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import ff7.e;
import ff7.g;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f564946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f564947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f564948c;

    /* JADX INFO: renamed from: xs3.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class RunnableC8266a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f564949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f564950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f564951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f564952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f564953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JSONObject f564954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f564955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f564956h;

        public final void a() {
            a r100 = this.f564956h;
            String r101 = this.f564949a;
            String r102 = this.f564950b;
            String r103 = this.f564951c;
            List r104 = this.f564952d;
            String r105 = this.f564953e;
            JSONObject r106 = this.f564954f;
            e r107 = this.f564955g;
            r100.getClass();
            IHttpService r108 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L34
            if (r108 != null) goto L6;
            r108 = d.f190522j;     // Catch: Exception -> L34
        L6:
            g r109 = r108.buildMultipartUpload(a.f564946a, "UTF-8", false);     // Catch: Exception -> L34
            r109.a("aid", r101);     // Catch: Exception -> L34
            r109.a("device_id", r102);     // Catch: Exception -> L34
            r109.a("os", "Android");     // Catch: Exception -> L34
            r109.a("process_name", PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Exception -> L34
            Iterator r110 = r104.iterator();     // Catch: Exception -> L34
        L8:
            String r111 = null;
            if (r110.hasNext() == false) goto L13;
            PolarisFileWrapper r112 = new PolarisFileWrapper((String) r110.next());     // Catch: Exception -> L34
            if (r112.exists() == false) goto L8;
            HashMap r113 = new HashMap();     // Catch: Exception -> L34
            r113.put("logtype", r103);     // Catch: Exception -> L34
            r113.put("scene", r105);     // Catch: Exception -> L34
            r113.put("env", "params.txt");     // Catch: Exception -> L34
            r109.b(r112.getName(), r112, null, r113);     // Catch: Exception -> L34
            goto L8
        L13:
            HashMap r114 = new HashMap();     // Catch: Exception -> L34
            r114.put("filetype", "common_params");     // Catch: Exception -> L34
            r114.put("logtype", "env");     // Catch: Exception -> L34
            if (r106 == null) goto L18;
            r111 = r106.toString();     // Catch: Exception -> L34
        L18:
            if (TextUtils.isEmpty(r111) == false) goto L22;
            JSONObject r115 = new JSONObject();     // Catch: Exception -> L34
            r115.put("defaultData", "none commonParams");     // Catch: JSONException -> L38 Exception -> L34
        L21:
            r111 = r115.toString();     // Catch: Exception -> L34
        L22:
            r109.c(r111, r114);     // Catch: Exception -> L34
            String r116 = new String(r109.finish().f476669c);     // Catch: Exception -> L34
            int r117 = -1;
            r117 = new JSONObject(r116).optInt(LKBaseResponseModel.ERROR_NO_KEY, -1);     // Catch: JSONException -> L26 Exception -> L34
        L28:
            if (r107 != null) goto L30;
            return;
        L30:
            if (r117 != 200) goto L32;
            r107.onSuccess();     // Catch: Exception -> L34
            return;
        L32:
            r107.onFail(r116);     // Catch: Exception -> L34
            return;
        L26:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L34
        L34:
            e = move-exception;
            if (r107 == null) goto L51;
            r107.onFail(e.getMessage());
            return;
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

        public RunnableC8266a(a r100, String r101, String r102, String r103, List r104, String r105, JSONObject r106, e r107) {
            this.f564956h = r100;
            this.f564949a = r101;
            this.f564950b = r102;
            this.f564951c = r103;
            this.f564952d = r104;
            this.f564953e = r105;
            this.f564954f = r106;
            this.f564955g = r107;
        }
    }

    public a() {
    }

    public static void b(String r100) {
        f564947b = "https://" + r100 + "/monitor/collect/c/code_coverage";
    }

    public static void d(String r110, String r111, String r112, String r113, String r114, String r115, e r116) {
        bt3.b.d.f20539a.j(new c(r110, r111, r112, r113, r114, r115, r116));
    }

    public final void c(String r110, String r111, String r112, List<String> r113, String r114, JSONObject r115, e r116) {
        bt3.b.d.f20539a.j(new RunnableC8266a(this, r110, r111, r112, r113, r114, r115, r116));
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, JSONObject r110, String r111, e r112) {
        File r105 = null;
        String r106 = null;
        r105 = null;
        IHttpService r107 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        if (r107 != null) goto L6;
        r107 = d.f190522j;     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
    L6:
        g r108 = r107.buildMultipartUpload(f564947b, "UTF-8", false);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        r108.a("aid", r100);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        r108.a("os", "Android");     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        r108.a("update_version_code", r101);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        r108.a("channel", r102);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        r108.a("release_build", r103);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        if (TextUtils.isEmpty(r111) == true) goto L9;
        r108.a("device_id", r111);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
    L9:
        r108.a(MonitorConstants.EXTRA_MONITOR_VERSION, "5.0.21.46-alpha.1");     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        PolarisFileWrapper r109 = new PolarisFileWrapper(r104);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        if (r109.exists() == false) goto L19;
        String r113 = r109.getParent() + HTTP.URL_DEFAULT + (com.bytedance.apm.util.g.d(r109) + ".zip");     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        com.bytedance.apm.util.g.b(r113, new String[]{r104});     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
        File r114 = new PolarisFileWrapper(r113);     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
    L80:
        r108.b(r114.getName(), r114, null, new HashMap());     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
    L20:
        HashMap r115 = new HashMap();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        r115.put("filetype", "common_params");     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        r115.put("logtype", "env");     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        if (r110 == null) goto L25;
        r106 = r110.toString();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
    L25:
        if (TextUtils.isEmpty(r106) == false) goto L29;
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        r116.put("defaultData", "none commonParams");     // Catch: JSONException -> L68 Throwable -> L43 Exception -> L45 IOException -> L47
    L28:
        r106 = r116.toString();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
    L29:
        r108.c(r106, r115);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        String r117 = new String(r108.finish().f476669c);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        int r118 = -1;
        r118 = new JSONObject(r117).optInt(LKBaseResponseModel.ERROR_NO_KEY, -1);     // Catch: JSONException -> L33 Throwable -> L43 Exception -> L45 IOException -> L47
    L35:
        if (r112 != null) goto L37;
    L40:
        if (r114 == null) goto L82;
        r114.delete();     // Catch: Throwable -> L65
    L69:
        return;
    L82:
        return;
    L37:
        if (r118 != 200) goto L39;
        r112.onSuccess();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
        goto L40
    L39:
        r112.onFail(r117);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L47
    L47:
        e = e;
        r105 = r114;
    L52:
        if (r112 == null) goto L62;
        r112.onFail(e.getMessage());     // Catch: Throwable -> L13
    L62:
        if (r105 == null) goto L84;
    L63:
        r105.delete();     // Catch: Throwable -> L65
        goto L69
    L84:
        return;
    L45:
        e = e;
        r105 = r114;
    L49:
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r105 != null) goto L63;
        return;
    L43:
        th = th;
    L56:
        if (r114 != null) goto L72;
    L61:
        throw th;
    L72:
        r114.delete();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th.printStackTrace();
        goto L61
    L19:
        r114 = null;
    L65:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        e = e;
    L15:
        e = e;
    L13:
        th = th;
        r114 = null;
        goto L56
    }
}
