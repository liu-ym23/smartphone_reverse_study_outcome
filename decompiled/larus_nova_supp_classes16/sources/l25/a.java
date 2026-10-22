package l25;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.fastjson.JSONReader;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.offline.remoteres.RemoteResourceConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSFile;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import n25.i;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final NetService a;
    public final d b;
    public final RemoteResourceConfig c;
    public final i d;
    public String e;

    public final WebResourceResponse a(String r13) {
        Request r1 = new Request.Builder().url(r13).build();
        long r2 = SystemClock.currentThreadTimeMillis();
        Response r3 = this.a.g6(r1);
        long r4 = SystemClock.currentThreadTimeMillis();
        if (r3 == null) goto L29;
        Uri r7 = UriProtector.parse(r13);
        String r8 = b.a(r7.getPath());
        if (TextUtils.isEmpty(r8) == false) goto L7;
        tt5.a.h("RemoteResourceLoader", "path is empty");
        r8 = r7.getPath();
    L7:
        boolean r9 = r3.isSuccessful();
        tt5.a.h("RemoteResourceLoader", "loadRemoterResource, isSuccess: " + r9 + " url=" + r13);
        long r5 = r4 - r2;
        String r6 = this.d.b;
        JSONObject r10 = new JSONObject();
        r10.put("path", r8);     // Catch: JSONException -> L14
        if (r9 == false) goto L11;
        String r11 = DiagramData$RESULT.SUCCESS;
    L12:
        r10.put("isSuccess", r11);     // Catch: JSONException -> L14
        r10.put("cost_time", r5);     // Catch: JSONException -> L14
        r10.put("pkg_version", r6);     // Catch: JSONException -> L14
    L16:
        tt5.a.b("RemoteResourceLoader", "report, params = " + r10);
        this.b.a("load_fe_remote_resource", r10);
        if (r9 == false) goto L29;
        if (r3.body() == null) goto L29;
        InputStream r12 = r3.body().byteStream();     // Catch: Exception -> L24
        VFSFile r14 = ay4.d.a().v(this.d.a.getParent(), r8);     // Catch: Exception -> L24
        tt5.a.b("RemoteResourceLoader", "loadRemoteResource, cache file: " + r14);     // Catch: Exception -> L24
        Map<String, Set<String>> r0 = d25.d.a;     // Catch: Exception -> L24
        byte[] r16 = new byte[1024];     // Catch: Exception -> L24
        OutputStream r17 = r14.newOutputStream();     // Catch: Exception -> L24
    L21:
        int r18 = r12.read(r16);     // Catch: Exception -> L24
        if (r18 == (-1)) goto L26;
        r17.write(r16, 0, r18);     // Catch: Exception -> L24
        r17.flush();     // Catch: Exception -> L24
        goto L21
    L26:
        r17.close();     // Catch: Exception -> L24
        r12.close();     // Catch: Exception -> L24
        return new WebResourceResponse(d25.d.c(r13), n25.b.a, r14.newInputStream());
    L24:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "loadRemoteResource error", e, false);
        goto L29
    L11:
        r11 = DiagramData$RESULT.FAIL;
    L14:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "reportLoadRemoteResource fail", e, false);
    L29:
        tt5.a.h("RemoteResourceLoader", "failed to load remote resource. url= " + r13);
        return null;
    }

    public final boolean b(String r4) {
        Uri r5 = UriProtector.parse(r4);
        String r0 = r5.getPath();
        String r1 = r5.getHost();
        if (r1 == null) goto L12;
        if (r0 == null) goto L12;
        String r2 = b.a(r0);
        RemoteResourceConfig r3 = this.c;
        if (r3 == null) goto L12;
        if (r3.getFileNameSet().contains(r2) == false) goto L12;
        if (TextUtils.equals(r1, this.e) == false) goto L12;
        tt5.a.h("RemoteResourceLoader", "shouldInterceptRequest, load remote resource: " + r5);
        return true;
    L12:
        return false;
    }

    public a(NetService r3, d r4, i r5) {
        this.a = r3;
        this.b = r4;
        VFSFile r6 = ay4.d.a().D(r5.a, "remote_resources.json");
        if (r6.exists() == true) goto L5;
    L10:
        tt5.a.d("RemoteResourceLoader", "getRemoteResConfig, remote config file not exist");
    L11:
        RemoteResourceConfig r7 = RemoteResourceConfig.defaultResConfig();
    L12:
        this.c = r7;
        this.d = r5;
        r7.generateFileNameSet();
        return;
    L5:
        if (r6.isFile() == false) goto L10;
        r7 = (RemoteResourceConfig) new JSONReader(new InputStreamReader(r6.newInputStream())).readObject(RemoteResourceConfig.class);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "getRemoteResConfig fail", e, false);
        goto L11
    }
}
