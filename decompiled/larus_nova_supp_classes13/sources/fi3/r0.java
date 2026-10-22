package fi3;

import android.net.Uri;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r0 {
    public final Map<String, Object> a;
    public final ArrayList<Map<String, Object>> b;
    public final String c;
    public final Uri d;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0001¨\u0006\u0006"}, d2 = {"fi3/r0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Map<String, Object>>> {
        public a() {
        }
    }

    public final Uri a() {
        int r0 = com.bytedance.android.ec.core.utils.t0.a;
        String r1 = GsonProtectorUtils.toJson(com.bytedance.android.ec.core.utils.t0.a.a, this.b);
        if (r1 == null) goto L5;
        this.a.put(this.c, r1);
    L5:
        int r2 = com.bytedance.android.ec.core.utils.p0.a;
        Uri r3 = this.d;
        Map<String, Object> r4 = this.a;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r6 = r4.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<String, Object> r7 = r6.next();
        if ((r7.getValue() instanceof Map) == true) goto L10;
        r5.put(r7.getKey(), r7.getValue().toString());
        goto L7
    L10:
        int r8 = com.bytedance.android.ec.core.utils.t0.a;
        String r9 = GsonProtectorUtils.toJson(com.bytedance.android.ec.core.utils.t0.a.a, r7.getValue());
        String r10 = r7.getKey();
        String r11 = a2.d(r9);
        if (r11 != null) goto L13;
        r11 = r7.getValue().toString();
    L13:
        r5.put(r10, r11);
        goto L7
    L16:
        return com.bytedance.android.ec.core.utils.p0.f(r3, r5);
    }

    public final String b() {
        Object r0 = this.a.get("biz_context");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 == null) goto L8;
        Object r3 = r1.get("scene_type");
    L10:
        if ((r3 instanceof String) == false) goto L13;
        r2 = r3;
    L13:
        String r4 = (String) r2;
        if (r4 != null) goto L17;
        return "";
    L17:
        return r4;
    L8:
        r3 = null;
        goto L10
    }

    public r0(Uri r9) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        this.d = r9;
        this.c = "pass_through";
        String r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        HashMap r3 = new HashMap();     // Catch: Throwable -> L27
        Iterator r4 = UriProtector.getQueryParameterNames(r9).iterator();     // Catch: Throwable -> L27
    L5:
        if (r4.hasNext() == false) goto L25;
        String r5 = (String) r4.next();     // Catch: Throwable -> L27
        boolean r6 = false;
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L5;
        String r8 = UriProtector.getQueryParameter(r9, r5);     // Catch: Throwable -> L27
        if (r8 != null) goto L17;
    L18:
        r6 = true;
    L20:
        if ((!r6) == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L5;
        r3.put(r5, r8);     // Catch: Throwable -> L27
        goto L5
    L17:
        if (StringsKt.isBlank(r8) == false) goto L20;
    L9:
        if (StringsKt.isBlank(r5) == true) goto L12;
        r7 = false;
        goto L13
    L25:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r10) == false) goto L32;
        r10 = null;
    L32:
        HashMap r11 = (HashMap) r10;
        if (r11 != null) goto L36;
        r11 = new HashMap();
    L36:
        this.a = r11;
        Object r12 = r11.get(this.c);
        if (r12 == null) goto L39;
        String r13 = r12.toString();
    L40:
        if (r13 == null) goto L51;
        Object r14 = r11.get(this.c);
        if (r14 == null) goto L45;
        r0 = r14.toString();
    L45:
        if ((!Intrinsics.areEqual(r0, "null")) == false) goto L51;
        int r1 = com.bytedance.android.ec.core.utils.t0.a;     // Catch: Exception -> L48
        List r15 = (List) com.bytedance.android.ec.core.utils.t0.a.a.fromJson(String.valueOf(r11.get(this.c)), new a().getType());     // Catch: Exception -> L48
    L50:
        ArrayList<Map<String, Object>> r16 = new ArrayList(r15);
    L52:
        this.b = r16;
        return;
    L48:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r15 = CollectionsKt.emptyList();
    L51:
        r16 = new ArrayList();
        goto L52
    L39:
        r13 = null;
    L27:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static Map c(Object r1) {
        if (TypeIntrinsics.isMutableMap(r1) == false) goto L11;
        if (TypeIntrinsics.isMutableMap(r1) == true) goto L7;
        r1 = null;
    L7:
        Map r2 = (Map) r1;
        if (r2 == null) goto L20;
        return r2;
    L20:
        return new LinkedHashMap();
    L11:
        if ((r1 instanceof String) == false) goto L18;
        JSONObject r3 = z1.g((String) r1);
        if (r3 == null) goto L22;
        Map r4 = MapsKt.toMutableMap(z1.k(r3));
        if (r4 == null) goto L22;
        return r4;
    L22:
        return new LinkedHashMap();
    L18:
        return new LinkedHashMap();
    }

    public final void d(j73.d r10) {
        Intrinsics.checkNotNullParameter(r10, "anchorV4VM");
        Map r0 = c(this.a.get("client_params"));
        if (com.bytedance.android.shopping.anchorv4.helper.e.c(r10) == false) goto L6;
        r0.put("height_percent", Integer.valueOf(r10.r()));
    L6:
        if (r10.isExpanded() == true) goto L15;
        AnchorV4Param r2 = r10.c();
        if (r2 == null) goto L14;
        V4NativeParams r3 = r2.getNativeParams();
        if (r3 == null) goto L14;
        if (r3.getFullMode() == true) goto L15;
    L14:
        float r4 = 0.0f;
    L16:
        r0.put("mask_alpha", Float.valueOf(r4));
        boolean r5 = false;
        if (r10.P() == null) goto L19;
        boolean r6 = true;
    L20:
        r0.put("disable_server_specs_default_select", Boolean.valueOf(r6));
        if (Intrinsics.areEqual(b(), "105") == false) goto L26;
        SkuRestoreState r7 = r10.P();
        if (r7 != null) goto L25;
    L48:
        int r8 = com.bytedance.android.ec.core.utils.t0.a;
        Gson r9 = com.bytedance.android.ec.core.utils.t0.a.a;
        String r1 = GsonProtectorUtils.toJson(r9, r0);
        if (r1 == null) goto L51;
        this.a.put("client_params", r1);
    L51:
        Map r11 = c(this.a.get("biz_context"));
        if (Intrinsics.areEqual(b(), "105") == false) goto L57;
        SkuRestoreState r12 = r10.P();
        if (r12 != null) goto L56;
    L71:
        String r13 = GsonProtectorUtils.toJson(r9, r11);
        if (r13 == null) goto L74;
        this.a.put("biz_context", r13);
    L74:
        Iterator<Map<String, Object>> r14 = this.b.iterator();
    L76:
        if (r14.hasNext() == false) goto L99;
        Map<String, Object> r15 = r14.next();
        Object r16 = r15.get("to");
        if ((r16 instanceof ArrayList) == true) goto L80;
        r16 = null;
    L80:
        ArrayList r17 = (ArrayList) r16;
        if (r17 == null) goto L76;
        if (CollectionsKt.contains(r17, "track.client") != true) goto L76;
        JSONObject r18 = z1.f(mq.b.d(r15, "data", null));
        if (r10.isExpanded() == false) goto L87;
        String r19 = "full_screen";
    L88:
        KtSafeMethodExtensionKt.safePut(r18, "page_type", r19);
        String r110 = GsonProtectorUtils.toJson(com.bytedance.android.ec.core.utils.t0.a.a, r18);
        if (r110 == null) goto L98;
        r15.put("data", r110);
        return;
    L98:
        return;
    L87:
        r19 = "half_screen";
        goto L88
    L99:
        return;
    L56:
        if (r12.allSelected() != true) goto L71;
    L57:
        SkuRestoreState r20 = r10.P();
        if (r20 == null) goto L60;
        String r21 = r20.getSelectedSkuId();
    L61:
        if (r21 != null) goto L63;
    L64:
        r5 = true;
    L66:
        if ((!r5) == true) goto L69;
        r21 = null;
    L69:
        if (r21 == null) goto L71;
        r11.put("sku_id", r21);
        goto L71
    L63:
        if (r21.length() != 0) goto L66;
    L60:
        r21 = null;
        goto L61
    L25:
        if (r7.allSelected() != true) goto L48;
    L26:
        SkuRestoreState r22 = r10.P();
        if (r22 == null) goto L29;
        String[] r23 = r22.getSelectSkuKeys();
    L30:
        if (r23 != null) goto L32;
    L38:
        boolean r24 = true;
    L40:
        if ((!r24) == true) goto L43;
        r23 = null;
    L43:
        if (r23 == null) goto L45;
        r0.put("default_spec_id", r23);
    L45:
        SkuRestoreState r25 = r10.P();
        if (r25 == null) goto L48;
        r0.put("default_count", Long.valueOf(r25.getProductCount()));
        goto L48
    L32:
        if (r23.length != 0) goto L34;
        boolean r26 = true;
    L35:
        if (r26 == true) goto L38;
        r24 = false;
        goto L40
    L34:
        r26 = false;
        goto L35
    L29:
        r23 = null;
        goto L30
    L19:
        r6 = false;
    L15:
        r4 = 0.5f;
        goto L16
    }

    public final void e(List<? extends Map<String, Object>> r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<? extends Map<String, Object>> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L32;
        Map<String, Object> r1 = r14.next();
        Iterator<Map<String, Object>> r3 = this.b.iterator();
        boolean r4 = false;
    L9:
        if (r3.hasNext() == false) goto L29;
        Map<String, Object> r5 = r3.next();
        Object r7 = r1.get("to");
        if ((r7 instanceof List) == true) goto L13;
        r7 = null;
    L13:
        List r8 = (List) r7;
        if (r8 == null) goto L9;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L9;
        Object r10 = r9.next();
        Object r11 = r5.get("to");
        if ((r11 instanceof ArrayList) == true) goto L21;
        r11 = null;
    L21:
        ArrayList r12 = (ArrayList) r11;
        if (r12 == null) goto L17;
        if (CollectionsKt.contains(r12, r10) != true) goto L17;
        JSONObject r15 = z1.f(mq.b.d(r5, "data", null));
        ul.e.a(r15, z1.f(mq.b.d(r1, "data", null)));
        int r16 = com.bytedance.android.ec.core.utils.t0.a;
        String r17 = GsonProtectorUtils.toJson(com.bytedance.android.ec.core.utils.t0.a.a, r15);
        if (r17 == null) goto L28;
        r5.put("data", r17);
    L28:
        r4 = true;
        goto L17
    L29:
        if (r4 == true) goto L6;
        r0.add(r1);
        goto L6
    L32:
        if ((!r0.isEmpty()) == false) goto L51;
        this.b.addAll(r0);
        return;
    }

    public final void f(Map<String, ? extends Object> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L32;
        Map.Entry<String, ? extends Object> r0 = r11.next();
        String r2 = r0.getKey();
        Object r1 = r0.getValue();
        Map<String, Object> r3 = this.a;
        List r4 = StringsKt.split$default(r2, new String[]{"."}, false, 0, 6, null);
        String r5 = (String) CollectionsKt.last(r4);
        Iterator r6 = CollectionsKt.dropLast(r4, 1).iterator();
    L9:
        if (r6.hasNext() == false) goto L27;
        String r7 = (String) r6.next();
        Object r8 = r3.get(r7);
        if (TypeIntrinsics.isMutableMap(r8) == true) goto L12;
        if ((r8 instanceof String) == false) goto L24;
        JSONObject r9 = z1.g((String) r8);
        if (r9 == null) goto L22;
        Map<String, Object> r12 = MapsKt.toMutableMap(z1.k(r9));
        if (r12 == null) goto L22;
    L23:
        r3.put(r7, r12);
    L25:
        r3 = r12;
    L22:
        r12 = new LinkedHashMap();
        goto L23
    L24:
        r12 = new LinkedHashMap();
        r3.put(r7, r12);
        goto L25
    L12:
        if (r8 == null) goto L15;
        r3 = TypeIntrinsics.asMutableMap(r8);
        goto L9
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
    L27:
        if ((r1 instanceof Number) == false) goto L31;
        Number r13 = (Number) r1;
        if (r13.intValue() != r13.doubleValue()) goto L31;
        r3.put(r5, Integer.valueOf(r13.intValue()));
    L31:
        r3.put(r5, r1);
        goto L6
    }
}
