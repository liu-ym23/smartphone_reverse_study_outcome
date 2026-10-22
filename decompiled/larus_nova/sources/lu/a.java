package lu;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f510770c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f510771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f510772b;

    public a() {
        this.f510771a = null;
        ArrayList r100 = new ArrayList();
        this.f510772b = r100;
        r100.add("https://aweme.snssdk.com/luckycat/aweme/v1/");
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r110) throws Exception {
        Request r100 = r110.request();
        Iterator r101 = ((ArrayList) this.f510772b).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.getUrl().startsWith((String) r101.next()) == false) goto L4;
        return r110.proceed(r100);
    L9:
        String r102 = r100.getPath();
        if (r102 == null) goto L55;
        if (r102.isEmpty() == true) goto L55;
        TypedOutput r103 = r100.getBody();
        String r104 = r100.getUrl();
        if (r102.endsWith(HTTP.URL_DEFAULT) == false) goto L16;
        boolean r105 = false;
    L21:
        if (GameCpTargetUtils.h() == true) goto L23;
    L51:
        TypedOutput r106 = r103;
        String r107 = r104;
        if (r105 == false) goto L55;
        r100 = new Request(r100.getMethod(), r107, r100.getHeaders(), r106, r100.getPriorityLevel(), r100.isResponseStreaming(), r100.getMaxLength(), r100.isAddCommonParam(), r100.getExtraInfo());
        goto L55
    L23:
        if (r104.contains("/openapi/") == false) goto L25;
    L27:
        Map<String, String> r108 = this.f510771a;
        if (r108 != null) goto L30;
    L31:
        HashMap r109 = new HashMap();
        this.f510771a = r109;
        r109.put("anchor_id", "anchor_open_id");
        ((HashMap) this.f510771a).put("user_id", "user_open_id");
        ((HashMap) this.f510771a).put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, "promoter_saas_open_id");
        ((HashMap) this.f510771a).put("author_id", "author_open_id");
    L32:
        Iterator r111 = ((HashMap) this.f510771a).entrySet().iterator();
    L34:
        if (r111.hasNext() == false) goto L39;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (r104.contains((CharSequence) r112.getKey()) == false) goto L34;
        r104 = r104.replace((CharSequence) r112.getKey(), (CharSequence) r112.getValue());
        r105 = true;
        goto L34
    L39:
        if (TextUtils.equals(r100.getMethod(), "POST") == false) goto L51;
        ByteArrayOutputStream r113 = new ByteArrayOutputStream();     // Catch: IOException -> L56
        if (r103 == null) goto L44;
        r103.writeTo(r113);     // Catch: IOException -> L56
        String r114 = new String(r113.toByteArray(), StandardCharsets.UTF_8);     // Catch: IOException -> L56
    L45:
        Iterator r115 = ((HashMap) this.f510771a).entrySet().iterator();
    L47:
        if (r115.hasNext() == false) goto L51;
        Map.Entry r116 = (Map.Entry) r115.next();
        if (r114.contains((CharSequence) r116.getKey()) == false) goto L47;
        r114 = r114.replace((CharSequence) r116.getKey(), (CharSequence) r116.getValue());
        r103 = new TypedByteArray(r103.mimeType(), r114.getBytes(StandardCharsets.UTF_8), new String[]{r103.fileName()});
        r105 = true;
    L44:
        r114 = "";
        goto L45
    L30:
        if (((HashMap) r108).entrySet().size() != 0) goto L32;
    L25:
        if (r104.contains("/webcast/") == false) goto L27;
        r104 = r104.replace("/webcast/", "/webcast/openapi/");
        r105 = true;
        goto L27
    L16:
        if (cs.a.a() == false) goto L18;
        jv.a r117 = jv.a.a();
        r102.concat(HTTP.URL_DEFAULT);
        r117.b(new nu.a());
    L18:
        int r118 = r100.getUrl().indexOf(r102) + r102.length();
        r104 = r100.getUrl().substring(0, r118) + HTTP.URL_DEFAULT + r100.getUrl().substring(r118);
        r105 = true;
    L55:
        return r110.proceed(r100);
    }
}
