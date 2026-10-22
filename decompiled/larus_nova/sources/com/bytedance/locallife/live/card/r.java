package com.bytedance.locallife.live.card;

import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLocalLifeGsonUtil;
import com.bytedance.locallife.live.util.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Object> f259280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<Object> f259281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet<String> f259282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f259283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Object> f259284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Object> f259285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<String> f259286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.locallife.live.msgcenter.b f259287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.locallife.live.msgcenter.b f259288i;

    public static final class a {
    }

    public static final class b implements pv6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f259289a;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/locallife/live/card/r$b$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
        public static final class a extends TypeToken<List<? extends Object>> {
            public a() {
            }
        }

        public b(r r100) {
            this.f259289a = r100;
        }

        @Override // pv6.c
        public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            ArrayList r103 = null;
            String r104 = null;
            if (r101 == null) goto L5;
            String r105 = w.f(r101, "from");
        L7:
            if (Intrinsics.areEqual(r105, "lynx") == false) goto L18;
            Type r106 = new a().getType();
            Gson r107 = LiveLocalLifeGsonUtil.f260680a;
            Gson r108 = LiveLocalLifeGsonUtil.a.a();
            if (r108 == null) goto L13;
            if (r101 != null) goto L16;
        L12:
            r103 = (ArrayList) GsonProtectorUtils.fromJson(r108, r104, r106);     // Catch: JsonSyntaxException -> L15
            goto L13
        L16:
            r104 = w.f(r101, "coupon_collected_list");     // Catch: JsonSyntaxException -> L15
        L19:
            return;
        L13:
            r.b(this.f259289a, r103);     // Catch: JsonSyntaxException -> L15
            return;
        L18:
            return;
        L5:
            r105 = null;
            goto L7
        }
    }

    public static final class c implements pv6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f259290a;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/locallife/live/card/r$c$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
        public static final class a extends TypeToken<List<? extends Object>> {
            public a() {
            }
        }

        public c(r r100) {
            this.f259290a = r100;
        }

        @Override // pv6.c
        public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            ArrayList r103 = null;
            String r104 = null;
            if (r101 == null) goto L5;
            Object r105 = r101.get("data");
        L7:
            if ((r105 instanceof Map) == false) goto L9;
            Map r106 = (Map) r105;
        L10:
            Type r107 = new a().getType();
            Gson r108 = LiveLocalLifeGsonUtil.f260680a;
            Gson r109 = LiveLocalLifeGsonUtil.a.a();
            r r110 = this.f259290a;     // Catch: JsonSyntaxException -> L25
            if (r109 == null) goto L17;
            if (r106 == null) goto L15;
            String r111 = w.f(r106, "coupon_list");     // Catch: JsonSyntaxException -> L25
        L16:
            ArrayList r112 = (ArrayList) GsonProtectorUtils.fromJson(r109, r111, r107);     // Catch: JsonSyntaxException -> L25
        L18:
            r110.f259284e = r112;     // Catch: JsonSyntaxException -> L25
            if (r109 == null) goto L23;
            if (r106 == null) goto L22;
            r104 = w.f(r106, "invalid_coupon_list");     // Catch: JsonSyntaxException -> L25
        L22:
            r103 = (ArrayList) GsonProtectorUtils.fromJson(r109, r104, r107);     // Catch: JsonSyntaxException -> L25
        L23:
            r.b(this.f259290a, r103);     // Catch: JsonSyntaxException -> L25
            return;
        L15:
            r111 = null;
            goto L16
        L17:
            r112 = null;
        L28:
            return;
        L9:
            r106 = null;
            goto L10
        L5:
            r105 = null;
            goto L7
        }
    }

    static {
    }

    public final void c() {
        ArrayList<Object> r100 = this.f259280a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        ArrayList<Object> r101 = this.f259281b;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        HashSet<String> r102 = this.f259282c;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        Lazy r103 = MsgCenter.f260620a;
        MsgCenter.h(this.f259287h);
        MsgCenter.h(this.f259288i);
        List<Object> r104 = this.f259284e;
        if (r104 == null) goto L14;
        r104.clear();
    L14:
        List<Object> r105 = this.f259285f;
        if (r105 == null) goto L17;
        ((ArrayList) r105).clear();
    L17:
        Set<String> r106 = this.f259286g;
        if (r106 == null) goto L21;
        ((HashSet) r106).clear();
        return;
    }

    public r() {
        this.f259280a = new ArrayList();
        this.f259281b = new ArrayList();
        this.f259282c = new HashSet();
        this.f259283d = "LiveLocalLifeDataInteractionCenter";
        this.f259284e = new ArrayList();
        this.f259285f = new ArrayList();
        this.f259286g = new HashSet();
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("data_name", "short_touch_coupon_center_list");
        Unit r101 = Unit.INSTANCE;
        this.f259287h = new com.bytedance.locallife.live.msgcenter.b("live_life_listen_data", r100, new c(this));
        this.f259288i = new com.bytedance.locallife.live.msgcenter.b("short_touch_coupon_center_invalid_list", null, new b(this));
    }

    public static final void a(r r100, List r101) {
        r100.getClass();
        if (r101 == null) goto L50;
        List r102 = r101;
        if ((!r102.isEmpty()) == false) goto L67;
        ArrayList<Object> r103 = r100.f259281b;
        if (r103 != null) goto L9;
    L35:
        ArrayList<Object> r104 = new ArrayList();
        r104.addAll(r102);
        r100.f259281b = r104;
        r100.f259282c = new HashSet();
        Iterator r105 = r101.iterator();
    L37:
        if (r105.hasNext() == false) goto L69;
        Object r106 = r105.next();
        if ((r106 instanceof HashMap) == false) goto L41;
        HashMap r107 = (HashMap) r106;
    L42:
        if (r107 == null) goto L44;
        Object r108 = r107.get("coupon_id");
    L45:
        String r109 = (String) r108;
        if (r109 == null) goto L37;
        HashSet<String> r110 = r100.f259282c;
        if (r110 == null) goto L37;
        r110.add(r109);
        goto L37
    L44:
        r108 = null;
        goto L45
    L41:
        r107 = null;
        goto L42
    L69:
        return;
    L9:
        if ((!r103.isEmpty()) != true) goto L11;
        boolean r111 = true;
    L12:
        if (r111 == false) goto L35;
        Iterator r112 = r101.iterator();
    L15:
        if (r112.hasNext() == false) goto L68;
        Object r113 = r112.next();
        if ((r113 instanceof HashMap) == false) goto L19;
        HashMap r114 = (HashMap) r113;
    L20:
        if (r114 == null) goto L22;
        Object r115 = r114.get("coupon_id");
    L23:
        String r116 = (String) r115;
        if (r116 == null) goto L15;
        HashSet<String> r117 = r100.f259282c;
        if (r117 != null) goto L28;
    L30:
        boolean r118 = false;
    L31:
        if (r118 == false) goto L15;
        ArrayList<Object> r119 = r100.f259281b;
        if (r119 == null) goto L15;
        r119.add(r113);
        goto L15
    L28:
        if (r117.add(r116) != true) goto L30;
        r118 = true;
        goto L31
    L22:
        r115 = null;
        goto L23
    L19:
        r114 = null;
        goto L20
    L68:
        return;
    L11:
        r111 = false;
        goto L12
    L67:
        return;
    }

    public static final void b(r r100, List r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L74;
        List<Object> r103 = r100.f259285f;
        if (r103 != null) goto L13;
    L49:
        ArrayList r104 = new ArrayList();
        r104.addAll(r101);
        r100.f259285f = r104;
        r100.f259286g = new HashSet();
        Iterator r105 = r101.iterator();
    L51:
        if (r105.hasNext() == false) goto L92;
        Object r106 = r105.next();
        if ((r106 instanceof HashMap) == false) goto L55;
        HashMap r107 = (HashMap) r106;
    L56:
        if (r107 == null) goto L58;
        Object r108 = r107.get("collect_base_info");
    L60:
        if ((r108 instanceof Map) == false) goto L62;
        Map r109 = (Map) r108;
    L63:
        if (r109 == null) goto L65;
        Object r110 = r109.get("coupon_id");
    L67:
        if ((r110 instanceof String) == false) goto L69;
        String r111 = (String) r110;
    L70:
        if (r111 == null) goto L51;
        Set<String> r112 = r100.f259286g;
        if (r112 == null) goto L51;
        ((HashSet) r112).add(r111);
        goto L51
    L69:
        r111 = null;
        goto L70
    L65:
        r110 = null;
        goto L67
    L62:
        r109 = null;
        goto L63
    L58:
        r108 = null;
        goto L60
    L55:
        r107 = null;
        goto L56
    L92:
        return;
    L13:
        if ((!r103.isEmpty()) != true) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == false) goto L49;
        Iterator r114 = r101.iterator();
    L19:
        if (r114.hasNext() == false) goto L91;
        Object r115 = r114.next();
        if ((r115 instanceof HashMap) == false) goto L23;
        HashMap r116 = (HashMap) r115;
    L24:
        if (r116 == null) goto L26;
        Object r117 = r116.get("collect_base_info");
    L28:
        if ((r117 instanceof Map) == false) goto L30;
        Map r118 = (Map) r117;
    L31:
        if (r118 == null) goto L33;
        Object r119 = r118.get("coupon_id");
    L35:
        if ((r119 instanceof String) == false) goto L37;
        String r120 = (String) r119;
    L38:
        if (r120 == null) goto L19;
        Set<String> r121 = r100.f259286g;
        if (r121 != null) goto L42;
    L44:
        boolean r122 = false;
    L45:
        if (r122 == false) goto L19;
        List<Object> r123 = r100.f259285f;
        if (r123 == null) goto L19;
        ((ArrayList) r123).add(r115);
        goto L19
    L42:
        if (((HashSet) r121).add(r120) != true) goto L44;
        r122 = true;
        goto L45
    L37:
        r120 = null;
        goto L38
    L33:
        r119 = null;
        goto L35
    L30:
        r118 = null;
        goto L31
    L26:
        r117 = null;
        goto L28
    L23:
        r116 = null;
        goto L24
    L91:
        return;
    L15:
        r113 = false;
        goto L16
    L74:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
