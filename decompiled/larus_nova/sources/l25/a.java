package l25;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.fastjson.JSONReader;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.offline.remoteres.RemoteResourceConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f507114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f507115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteResourceConfig f507116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f507117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f507118e;

    public final WebResourceResponse a(String r110) {
        Request r100 = new Request.Builder().url(r110).build();
        long r101 = SystemClock.currentThreadTimeMillis();
        Response r102 = this.f507114a.g6(r100);
        long r103 = SystemClock.currentThreadTimeMillis();
        if (r102 == null) goto L29;
        Uri r104 = UriProtector.parse(r110);
        String r105 = b.a(r104.getPath());
        if (TextUtils.isEmpty(r105) == false) goto L7;
        tt5.a.h("RemoteResourceLoader", "path is empty");
        r105 = r104.getPath();
    L7:
        boolean r106 = r102.isSuccessful();
        tt5.a.h("RemoteResourceLoader", "loadRemoterResource, isSuccess: " + r106 + " url=" + r110);
        long r107 = r103 - r101;
        String r108 = this.f507117d.f516740b;
        JSONObject r109 = new JSONObject();
        r109.put("path", r105);     // Catch: JSONException -> L14
        if (r106 == false) goto L11;
        String r111 = "1";
    L12:
        r109.put("isSuccess", r111);     // Catch: JSONException -> L14
        r109.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r107);     // Catch: JSONException -> L14
        r109.put("pkg_version", r108);     // Catch: JSONException -> L14
    L16:
        tt5.a.b("RemoteResourceLoader", "report, params = " + r109);
        this.f507115b.a("load_fe_remote_resource", r109);
        if (r106 == false) goto L29;
        if (r102.body() == null) goto L29;
        InputStream r112 = r102.body().byteStream();     // Catch: Exception -> L24
        VFSFile r113 = ay4.d.a().v(this.f507117d.f516739a.getParent(), r105);     // Catch: Exception -> L24
        tt5.a.b("RemoteResourceLoader", "loadRemoteResource, cache file: " + r113);     // Catch: Exception -> L24
        Map<String, Set<String>> r114 = d25.d.f466514a;     // Catch: Exception -> L24
        byte[] r115 = new byte[1024];     // Catch: Exception -> L24
        OutputStream r116 = r113.newOutputStream();     // Catch: Exception -> L24
    L21:
        int r117 = r112.read(r115);     // Catch: Exception -> L24
        if (r117 == (-1)) goto L26;
        r116.write(r115, 0, r117);     // Catch: Exception -> L24
        r116.flush();     // Catch: Exception -> L24
        goto L21
    L26:
        r116.close();     // Catch: Exception -> L24
        r112.close();     // Catch: Exception -> L24
        return new WebResourceResponse(d25.d.c(r110), n25.b.f516700a, r113.newInputStream());
    L24:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "loadRemoteResource error", e, false);
        goto L29
    L11:
        r111 = "0";
    L14:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "reportLoadRemoteResource fail", e, false);
    L29:
        tt5.a.h("RemoteResourceLoader", "failed to load remote resource. url= " + r110);
        return null;
    }

    public final boolean b(String r100) {
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getPath();
        String r103 = r101.getHost();
        if (r103 == null) goto L12;
        if (r102 == null) goto L12;
        String r104 = b.a(r102);
        RemoteResourceConfig r105 = this.f507116c;
        if (r105 == null) goto L12;
        if (r105.getFileNameSet().contains(r104) == false) goto L12;
        if (TextUtils.equals(r103, this.f507118e) == false) goto L12;
        tt5.a.h("RemoteResourceLoader", "shouldInterceptRequest, load remote resource: " + r101);
        return true;
    L12:
        return false;
    }

    public a(NetService r100, d r101, i r102) {
        this.f507114a = r100;
        this.f507115b = r101;
        VFSFile r103 = ay4.d.a().D(r102.f516739a, "remote_resources.json");
        if (r103.exists() == true) goto L5;
    L10:
        tt5.a.d("RemoteResourceLoader", "getRemoteResConfig, remote config file not exist");
    L11:
        RemoteResourceConfig r104 = RemoteResourceConfig.defaultResConfig();
    L12:
        this.f507116c = r104;
        this.f507117d = r102;
        r104.generateFileNameSet();
        return;
    L5:
        if (r103.isFile() == false) goto L10;
        r104 = (RemoteResourceConfig) new JSONReader(new InputStreamReader(r103.newInputStream())).readObject(RemoteResourceConfig.class);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        tt5.a.e("RemoteResourceLoader", "getRemoteResConfig fail", e, false);
        goto L11
    }
}
