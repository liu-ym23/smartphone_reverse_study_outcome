package uj7;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f550418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f550419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550420c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r111 = this.f550418a.getText().toString();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "parseProxySchema is called, fakeSchema is " + r111);
        ti7.d r100 = null;
        if (com.bytedance.ug.sdk.luckycat.impl.utils.r.b(r111) == true) goto L5;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "isProxySchema = false");
    L39:
        ProjectActivity r112 = this.f550420c;
        int r101 = ProjectActivity.f271429b;
        r112.getClass();
        StringBuilder r113 = new StringBuilder();
        if (r100 != null) goto L42;
        r113.append("proxy schema 解析失败，具体错误查看ALOG【ProxySchemaUtil】");
    L43:
        this.f550419b.setText(r113.toString());
        return;
    L42:
        r113.append("settingsKey: ");
        r113.append(r100.f546228a);
        r113.append("\n\nurlParams: ");
        r113.append(r100.f546229b);
        r113.append("\n\nschemaParams: ");
        r113.append(r100.f546230c);
        r113.append("\n\nproxySchema: ");
        r113.append(r100.f546231d);
        r113.append("\n\nrealSchema: ");
        r113.append(r100.f546232e);
        r113.append("\n\nhost: ");
        r113.append(r100.f546233f);
        r113.append("\n\n");
        goto L43
    L5:
        Uri r102 = UriProtector.parse(r111);
        String r103 = r102.getHost();
        String r104 = UriProtector.getQueryParameter(r102, "settings_key");
        if (bd7.a.a(r103) == true) goto L11;
        Object r105 = LuckyCatSettingsManger.b.f271283a.c(new String[]{"proxy_schema_config", "entrances", r103});
        if ((r105 instanceof JSONObject) == false) goto L11;
        JSONObject r106 = (JSONObject) r105;
    L12:
        if (r106 != null) goto L14;
        String r107 = null;
    L16:
        if (TextUtils.isEmpty(r107) == false) goto L18;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "settingsSchema is empty, return");
        goto L39
    L18:
        String r108 = UriProtector.getQueryParameter(r102, "url_params");
        String r109 = UriProtector.getQueryParameter(r102, "schema_params");
        ti7.d r114 = new ti7.d();
        r114.f546228a = r104;
        r114.f546229b = r108;
        r114.f546230c = r109;
        r114.f546231d = r111;
        r114.f546233f = r103;
        if (com.bytedance.ug.sdk.luckycat.utils.i.f(r107) == false) goto L22;
        String r115 = com.bytedance.ug.sdk.luckycat.impl.utils.r.a(r108);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "return mergeQueryParams, fakeUrl = " + r115);
        r114.f546232e = com.bytedance.ug.sdk.luckycat.impl.utils.r.c(r115, r107);
    L21:
        r100 = r114;
        goto L39
    L22:
        String r116 = com.bytedance.ug.sdk.luckycat.impl.utils.r.c(com.bytedance.ug.sdk.luckycat.impl.utils.r.a(r109), r107);
        Uri r117 = UriProtector.parse(r116);
        String r118 = UriProtector.getQueryParameter(r117, "url");
        if (TextUtils.isEmpty(r118) == false) goto L25;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "httpUrl is empty");
        r114.f546232e = r116;
        goto L21
    L25:
        String r119 = com.bytedance.ug.sdk.luckycat.impl.utils.r.c(com.bytedance.ug.sdk.luckycat.impl.utils.r.a(r108), Uri.decode(r118));
        Uri.Builder r120 = new Uri.Builder();
        r120.scheme(r117.getScheme());
        r120.authority(r117.getAuthority());
        r120.path(r117.getPath());
        r120.appendQueryParameter("url", r119);
        Set<String> r121 = UriProtector.getQueryParameterNames(r117);
        if (r121 != null) goto L28;
    L38:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "queryName is null or empty");
        r114.f546232e = r120.build().toString();
        goto L21
    L28:
        if (r121.size() <= 0) goto L38;
        Iterator<String> r122 = r121.iterator();
    L32:
        if (r122.hasNext() == false) goto L37;
        String r123 = r122.next();
        if ("url".equals(r123) == true) goto L32;
        String r124 = UriProtector.getQueryParameter(r117, r123);
        TextUtils.isEmpty(r124);
        r120.appendQueryParameter(r123, r124);
        goto L32
    L37:
        String r125 = r120.build().toString();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ProxySchemaUtil", "realSchema is " + r125);
        r114.f546232e = r125;
        goto L21
    L14:
        r107 = r106.optString(r104);
    L11:
        r106 = null;
        goto L12
    }

    public j(ProjectActivity r100, EditText r101, TextView r102) {
        this.f550420c = r100;
        this.f550418a = r101;
        this.f550419b = r102;
    }
}
