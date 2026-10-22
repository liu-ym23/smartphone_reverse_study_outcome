package xs3;

import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IHttpService;
import com.larus.apm.impl.protector.RunnableProtector;
import ff7.e;
import ff7.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ String e;
    public final /* synthetic */ JSONObject f;
    public final /* synthetic */ e g;
    public final /* synthetic */ a h;

    public final void a() {
        a r0 = this.h;
        String r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        List r4 = this.d;
        String r5 = this.e;
        JSONObject r6 = this.f;
        e r7 = this.g;
        r0.getClass();
        IHttpService r8 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L34
        if (r8 != null) goto L6;
        r8 = d.j;     // Catch: Exception -> L34
    L6:
        g r9 = r8.buildMultipartUpload(a.a, "UTF-8", false);     // Catch: Exception -> L34
        r9.a("aid", r1);     // Catch: Exception -> L34
        r9.a("device_id", r2);     // Catch: Exception -> L34
        r9.a("os", "Android");     // Catch: Exception -> L34
        r9.a("process_name", "main");     // Catch: Exception -> L34
        Iterator r10 = r4.iterator();     // Catch: Exception -> L34
    L8:
        String r11 = null;
        if (r10.hasNext() == false) goto L13;
        PolarisFileWrapper r12 = new PolarisFileWrapper((String) r10.next());     // Catch: Exception -> L34
        if (r12.exists() == false) goto L8;
        HashMap r13 = new HashMap();     // Catch: Exception -> L34
        r13.put("logtype", r3);     // Catch: Exception -> L34
        r13.put("scene", r5);     // Catch: Exception -> L34
        r13.put("env", "params.txt");     // Catch: Exception -> L34
        r9.b(r12.getName(), r12, null, r13);     // Catch: Exception -> L34
        goto L8
    L13:
        HashMap r14 = new HashMap();     // Catch: Exception -> L34
        r14.put("filetype", "common_params");     // Catch: Exception -> L34
        r14.put("logtype", "env");     // Catch: Exception -> L34
        if (r6 == null) goto L18;
        r11 = r6.toString();     // Catch: Exception -> L34
    L18:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L34
        r15.put("defaultData", "none commonParams");     // Catch: JSONException -> L38 Exception -> L34
    L21:
        r11 = r15.toString();     // Catch: Exception -> L34
    L22:
        r9.c(r11, r14);     // Catch: Exception -> L34
        String r16 = new String(r9.finish().c);     // Catch: Exception -> L34
        int r17 = -1;
        r17 = new JSONObject(r16).optInt("errno", -1);     // Catch: JSONException -> L26 Exception -> L34
    L28:
        if (r7 != null) goto L30;
        return;
    L30:
        if (r17 != 200) goto L32;
        r7.onSuccess();     // Catch: Exception -> L34
        return;
    L32:
        r7.onFail(r16);     // Catch: Exception -> L34
        return;
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        if (r7 == null) goto L51;
        r7.onFail(e.getMessage());
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

    public a$a(a r1, String r2, String r3, String r4, List r5, String r6, JSONObject r7, e r8) {
        this.h = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
