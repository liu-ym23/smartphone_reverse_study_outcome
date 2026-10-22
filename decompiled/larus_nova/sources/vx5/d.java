package vx5;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f557490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Pair<String, b>> f557491b = null;

    public d() {
    }

    static {
        f557490a = new AtomicBoolean(false);
        f557491b = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Request a(Request r110, BaseHttpRequestInfo r111) {
        Request r100 = r110;
        if (f557490a.get() == true) goto L141;
        List<Pair<String, b>> r101 = f557491b;
        if (((CopyOnWriteArrayList) r101).isEmpty() == true) goto L141;
        r111.metrics.requestAuditStart();
        LinkedHashMap r102 = new LinkedHashMap();
        HashSet r103 = new HashSet();
        HashSet r104 = new HashSet();
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator r106 = ((CopyOnWriteArrayList) r101).iterator();
        JSONObject r107 = null;
        Pair<String, String> r108 = null;
        c r109 = null;
    L8:
        boolean r112 = true;
        if (r106.hasNext() == false) goto L66;
        Pair r113 = (Pair) r106.next();
        if (r113 == null) goto L8;
        String r114 = (String) r113.first;
        b r115 = (b) r113.second;
        if (r115 == null) goto L8;
        if (TextUtils.isEmpty(r114) == true) goto L8;
        e r116 = r115.a(new a(r110.getUrl(), r110.getHeaders()));     // Catch: Throwable -> L64
        if (r116 == null) goto L8;
        c.a r117 = new c.a(r114);
        if (CollectionUtils.isEmpty(r110.getHeaders()) == true) goto L39;
        if (CollectionUtils.isEmpty(r116.f557492a) == true) goto L39;
        Iterator<String> r118 = r116.f557492a.iterator();
    L28:
        if (r118.hasNext() == false) goto L39;
        String r119 = r118.next();
        if (TextUtils.isEmpty(r119) == true) goto L28;
        List<Header> r120 = r100.headers(r119);
        if (CollectionUtils.isEmpty(r120) == true) goto L28;
        if (r117.f557489b != null) goto L37;
        r117.f557489b = new HashSet();
    L37:
        ((HashSet) r117.f557489b).add(r119);
        r103.addAll(r120);
    L39:
        if (CollectionUtils.isEmpty(null) == true) goto L53;
        if (r108 == null) goto L144;
    L45:
        if (r108 == null) goto L53;
        if (r102.isEmpty() == true) goto L53;
        if (CollectionUtils.isEmpty(null) == true) goto L53;
        throw null;
    L144:
        r108 = UrlUtils.parseUrlWithValueList(r110.getUrl(), r102);     // Catch: Throwable -> L44
    L53:
        if (CollectionUtils.isEmpty(r117.f557489b) == true) goto L55;
    L59:
        boolean r121 = false;
    L60:
        if (r121 == true) goto L8;
        if (r109 != null) goto L63;
        r109 = new c();
    L63:
        ((ArrayList) r109.f557487a).add(r117);
        goto L8
    L55:
        if (CollectionUtils.isEmpty(null) == false) goto L59;
        if (CollectionUtils.isEmpty(null) == false) goto L59;
        r121 = true;
        goto L60
    L66:
        if (r103.isEmpty() == false) goto L68;
        Request.Builder r122 = null;
    L73:
        if (r108 != null) goto L75;
    L106:
        if (r122 == null) goto L108;
        r100 = r122.build();
    L108:
        if (r109 == null) goto L140;
        RetrofitMetrics r123 = r111.metrics;
        if (CollectionUtils.isEmpty(r109.f557487a) == true) goto L139;
        JSONObject r124 = new JSONObject();
        Iterator r125 = ((ArrayList) r109.f557487a).iterator();     // Catch: Exception -> L142
    L115:
        if (r125.hasNext() == false) goto L138;
        c.a r126 = (c.a) r125.next();     // Catch: Exception -> L142
        if (r126 == null) goto L115;
        JSONObject r127 = new JSONObject();     // Catch: Exception -> L142
        if (CollectionUtils.isEmpty(r126.f557489b) == true) goto L126;
        JSONArray r128 = new JSONArray();     // Catch: Exception -> L142
        Iterator r129 = ((HashSet) r126.f557489b).iterator();     // Catch: Exception -> L142
    L122:
        if (r129.hasNext() == false) goto L124;
        r128.put((String) r129.next());     // Catch: Exception -> L142
        goto L122
    L124:
        r127.put("rm_header", r128);     // Catch: Exception -> L142
    L126:
        if (CollectionUtils.isEmpty(null) == false) goto L136;
        if (CollectionUtils.isEmpty(null) == false) goto L134;
        if (TextUtils.isEmpty(r126.f557488a) == false) goto L132;
        String r130 = "null";
    L133:
        r124.put(r130, r127);     // Catch: Exception -> L142
        goto L115
    L132:
        r130 = r126.f557488a;     // Catch: Exception -> L142
        goto L133
    L134:
        new JSONArray();     // Catch: Exception -> L142
        throw null;     // Catch: Exception -> L142
    L136:
        new JSONArray();     // Catch: Exception -> L142
        throw null;     // Catch: Exception -> L142
    L138:
        r107 = r124;
    L139:
        r123.setRequestAuditLog(r107);
    L140:
        r111.metrics.requestAuditEnd();
        goto L141
    L75:
        if (r104.isEmpty() == true) goto L84;
        Iterator r131 = r104.iterator();
    L78:
        if (r131.hasNext() == false) goto L83;
        String r132 = (String) r131.next();
        if (TextUtils.isEmpty(r132) == true) goto L78;
        r102.remove(r132);
        goto L78
    L83:
        boolean r133 = true;
    L86:
        if (r105.isEmpty() == true) goto L97;
        Iterator r134 = r105.entrySet().iterator();
    L89:
        if (r134.hasNext() == false) goto L98;
        Map.Entry r135 = (Map.Entry) r134.next();
        if (r135 == null) goto L89;
        List r136 = (List) r102.get(r135.getKey());
        if (r136 != null) goto L96;
        r136 = new ArrayList();
        r102.put((String) r135.getKey(), r136);
    L96:
        r136.addAll((Collection) r135.getValue());
    L98:
        if (r112 == false) goto L106;
        String r137 = b(r110.getUrl(), r108, r102);
        if (TextUtils.isEmpty(r137) == true) goto L106;
        if (r137.equals(r110.getUrl()) == true) goto L106;
        if (r122 != null) goto L105;
        r122 = r110.newBuilder();
    L105:
        r122.url(r137);
        goto L106
    L97:
        r112 = r133;
        goto L98
    L84:
        r133 = false;
        goto L86
    L68:
        if (r110.getHeaders() == null) goto L70;
        ArrayList r138 = new ArrayList(r110.getHeaders());
    L71:
        r138.removeAll(r103);
        r122 = r110.newBuilder();
        r122.headers(r138);
        goto L73
    L70:
        r138 = new ArrayList();
    L141:
        return r100;
    }

    public static String b(String r100, Pair<String, String> r101, Map<String, List<String>> r102) {
        if (r101 != null) goto L28;
        return r100;
    L28:
        UrlBuilder r103 = new UrlBuilder(((String) r101.first) + ((String) r101.second));     // Catch: Throwable -> L27
        if (r102.isEmpty() == true) goto L23;
        Iterator r104 = ((LinkedHashMap) r102).entrySet().iterator();     // Catch: Throwable -> L27
    L8:
        if (r104.hasNext() == false) goto L23;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L27
        if (r105 == null) goto L8;
        if (TextUtils.isEmpty((CharSequence) r105.getKey()) == true) goto L8;
        List r106 = (List) r105.getValue();     // Catch: Throwable -> L27
        if (r106 == null) goto L8;
        if (r106.isEmpty() == true) goto L8;
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L27
    L21:
        if (r107.hasNext() == false) goto L8;
        r103.addParam((String) r105.getKey(), (String) r107.next());     // Catch: Throwable -> L27
    L23:
        String r108 = r103.build();     // Catch: Throwable -> L27
        String r109 = UriProtector.parse(r100).getEncodedFragment();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r109) == true) goto L43;
        return r108 + "#" + r109;
    L43:
        return r108;
    L27:
        return r100;
    }
}
