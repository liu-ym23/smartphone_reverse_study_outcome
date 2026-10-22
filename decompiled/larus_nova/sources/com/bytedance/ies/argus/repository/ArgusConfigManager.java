package com.bytedance.ies.argus.repository;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.q;
import com.monitor.cloudmessage.consts.CloudControlInf;
import defpackage.ExtraStrategyConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusConfigManager {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<ArgusConfigManager> f246083j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f246084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f246085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f246086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f246087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f246088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f246089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ies.argus.repository.c f246090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ies.argus.bean.c f246091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f246092i;

    public static final class a {
        public static ArgusConfigManager a() {
            return ArgusConfigManager.f246083j.getValue();
        }
    }

    public final class b extends BaseConfigProvider<i> {
        public b(ArgusConfigManager r100) {
            r100.getClass();
            super(ArgusConfigManager.e());
        }

        @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
        public final i a(JSONObject r100, com.bytedance.ies.argus.repository.c r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "info");
            int r102 = i.f246127b;
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "info");
            return new i(r100);
        }
    }

    public final class c extends BaseConfigProvider<m> {
        public c(ArgusConfigManager r100) {
            r100.getClass();
            super(ArgusConfigManager.e());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v12, types: [java.util.ArrayList] */
        @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
        public final m a(JSONObject r110, com.bytedance.ies.argus.repository.c r210) {
            Intrinsics.checkNotNullParameter(r110, "data");
            Intrinsics.checkNotNullParameter(r210, "info");
            int r100 = m.f246133g;
            Intrinsics.checkNotNullParameter(r110, "data");
            Intrinsics.checkNotNullParameter(r210, "info");
            int r101 = 0;
            boolean r102 = r110.optBoolean("force_close_all", false);
            JSONObject r103 = r110.optJSONObject("aspect");
            JSONObject r104 = r110.optJSONObject(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            JSONObject r105 = r110.optJSONObject(CloudControlInf.PLUGIN);
            int r106 = com.bytedance.ies.argus.bean.feStrategy.b.f246027b;
            JSONObject r107 = r110.optJSONObject("strategy_own_config");
            if (r107 == null) goto L17;
            JSONObject r108 = r107.optJSONObject("jsb_auth");
            if (r108 == null) goto L17;
            JSONArray r109 = r108.optJSONArray("close_auth_urls");
            if (r109 == null) goto L17;
            List r111 = new ArrayList(r109.length());
            int r112 = r109.length();
            int r113 = 0;
        L9:
            if (r113 >= r112) goto L18;
            String r114 = r109.optString(r113);
            if (r114.length() <= 0) goto L13;
            boolean r115 = true;
        L14:
            if (r115 == false) goto L16;
            r111.add(r114);
        L16:
            r113 = r113 + 1;
            goto L9
        L13:
            r115 = false;
        L18:
            if (r111 != 0) goto L21;
            r111 = CollectionsKt.emptyList();
        L21:
            if (r111.isEmpty() == false) goto L23;
            com.bytedance.ies.argus.bean.feStrategy.b r116 = null;
        L24:
            LinkedHashSet r117 = new LinkedHashSet();
            LinkedHashMap r118 = new LinkedHashMap();
            if (r103 == null) goto L81;
            Iterator<String> r119 = r103.keys();
            if (r119 == null) goto L81;
        L29:
            if (r119.hasNext() == false) goto L81;
            String r120 = r119.next();
            JSONObject r121 = r103.optJSONObject(r120);
            if (r121 == null) goto L80;
            Iterator<String> r122 = r121.keys();
        L34:
            if (r122.hasNext() == false) goto L80;
            String r123 = r122.next();
            if (r121.optInt(r123) == 0) goto L38;
        L78:
            JSONObject r124 = r103;
        L79:
            r103 = r124;
            r101 = 0;
            goto L34
        L38:
            if (Intrinsics.areEqual(r123, "all") == false) goto L40;
            r117.add(r120);
            goto L78
        L40:
            int r125 = q.f246041t1;
            q[] r126 = ArgusContainerAspect.values();
            int r127 = r126.length;
        L41:
            if (r101 >= r127) goto L46;
            q r128 = r126[r101];
            if (Intrinsics.areEqual(r128.getStringValue(), r123) == true) goto L47;
            r101 = r101 + 1;
        L47:
            if (r128 != null) goto L71;
            int r129 = q.f246041t1;
            ArgusWebViewAspect[] r130 = ArgusWebViewAspect.values();
            int r131 = r130.length;
            int r132 = 0;
        L49:
            if (r132 >= r131) goto L54;
            ArgusWebViewAspect r133 = r130[r132];
            r124 = r103;
            if (Intrinsics.areEqual(r133.getStringValue(), r123) == true) goto L52;
            r132 = r132 + 1;
            r103 = r124;
            goto L49
        L52:
            r128 = r133;
        L55:
            if (r128 != null) goto L72;
            int r134 = q.f246041t1;
            ArgusLynxViewAspect[] r135 = ArgusLynxViewAspect.values();
            int r136 = r135.length;
            int r137 = 0;
        L57:
            if (r137 >= r136) goto L62;
            ArgusLynxViewAspect r138 = r135[r137];
            if (Intrinsics.areEqual(r138.getStringValue(), r123) == true) goto L60;
            r137 = r137 + 1;
            goto L57
        L60:
            r128 = r138;
        L63:
            if (r128 != null) goto L72;
            int r139 = q.f246041t1;
            q[] r140 = ArgusGlobalAspect.values();
            int r141 = r140.length;
            int r142 = 0;
        L65:
            if (r142 >= r141) goto L70;
            r128 = r140[r142];
            if (Intrinsics.areEqual(r128.getStringValue(), r123) == true) goto L72;
            r142 = r142 + 1;
            goto L65
        L70:
            q r143 = null;
        L73:
            if (r143 == null) goto L79;
            Object r144 = r118.get(r120);
            if (r144 != null) goto L77;
            r144 = new LinkedHashSet();
            r118.put(r120, r144);
        L77:
            ((Set) r144).add(r143);
            goto L79
        L62:
            r128 = null;
        L72:
            r143 = r128;
            goto L73
        L54:
            r124 = r103;
            r128 = null;
            goto L55
        L71:
            r124 = r103;
            goto L72
        L46:
            r128 = null;
        L80:
            r103 = r103;
            r101 = 0;
        L81:
            Set r145 = CollectionsKt.toSet(r117);
            LinkedHashMap r146 = new LinkedHashMap(MapsKt.mapCapacity(r118.size()));
            Iterator r147 = r118.entrySet().iterator();
        L83:
            if (r147.hasNext() == false) goto L85;
            Map.Entry r148 = (Map.Entry) r147.next();
            r146.put(r148.getKey(), CollectionsKt.toSet((Iterable) r148.getValue()));
            goto L83
        L85:
            LinkedHashMap r149 = new LinkedHashMap();
            if (r104 == null) goto L102;
            Iterator<String> r150 = r104.keys();
            if (r150 == null) goto L102;
        L90:
            if (r150.hasNext() == false) goto L102;
            String r151 = r150.next();
            JSONObject r152 = r104.optJSONObject(r151);
            if (r152 == null) goto L90;
            Iterator<String> r153 = r152.keys();
        L95:
            if (r153.hasNext() == false) goto L90;
            String r154 = r153.next();
            if (r152.optInt(r154) != 0) goto L95;
            Object r155 = r149.get(r151);
            if (r155 != null) goto L101;
            r155 = new LinkedHashSet();
            r149.put(r151, r155);
        L101:
            ((Set) r155).add(r154);
        L102:
            LinkedHashMap r156 = new LinkedHashMap(MapsKt.mapCapacity(r149.size()));
            Iterator r157 = r149.entrySet().iterator();
        L104:
            if (r157.hasNext() == false) goto L107;
            Map.Entry r158 = (Map.Entry) r157.next();
            r156.put(r158.getKey(), CollectionsKt.toSet((Iterable) r158.getValue()));
            goto L104
        L107:
            return new m(r102, r145, r146, r156, r116, r105);
        L23:
            r116 = new com.bytedance.ies.argus.bean.feStrategy.b(r111);
        L17:
            r111 = 0;
            goto L18
        }
    }

    static {
        f246083j = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ArgusConfigManager$Companion$instance$2.INSTANCE);
    }

    public static CoroutineScope e() {
        Lazy<ArgusEnv> r100 = ArgusEnv.f245917d;
        return ArgusEnv.b.a().f245920c;
    }

    public final com.bytedance.ies.argus.bean.a b() {
        com.bytedance.ies.argus.bean.c r100 = this.f246091h;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final int d() {
        if (this.f246092i != (-1)) goto L12;
        com.bytedance.ies.argus.bean.a r100 = b();
        if (r100 == null) goto L9;
        com.bytedance.ies.argus.bean.b r101 = r100.d();
        if (r101 == null) goto L9;
        int r102 = r101.b();
    L10:
        this.f246092i = r102;
    L9:
        r102 = 0;
    L12:
        return this.f246092i;
    }

    public ArgusConfigManager() {
        this.f246085b = new g(e());
        this.f246086c = new b(this);
        this.f246087d = new c(this);
        this.f246092i = -1;
    }

    public static Map c(boolean r100) {
        if (r100 == false) goto L4;
        ArgusConfigType r101 = ArgusConfigType.FE_CONFIG_LYNX;
    L5:
        ExtraStrategyConfigManager r102 = ExtraStrategyConfigManager.f1183c.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "configType");
        com.bytedance.ies.argus.bean.config.a r103 = r102.f1184a.get(r101);
        if (r103 != null) goto L8;
        r103 = null;
    L8:
        com.bytedance.ies.argus.bean.config.b r104 = (com.bytedance.ies.argus.bean.config.b) r103;
        if (r104 == null) goto L14;
        com.bytedance.ies.argus.bean.config.g r105 = r104.b();
        if (r105 != null) goto L13;
        return null;
    L13:
        return r105.a();
    L14:
        return null;
    L4:
        r101 = ArgusConfigType.FE_CONFIG_WEB;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(com.bytedance.ies.argus.bean.n r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "aspect");
        Intrinsics.checkNotNullParameter(r101, "argusBizId");
        m r102 = (m) this.f246087d.f246100d;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.f246135b.contains("global") == false) goto L9;
        return true;
    L9:
        if (r102.f246135b.contains(r101) == false) goto L11;
        return true;
    L11:
        Set<com.bytedance.ies.argus.bean.n> r103 = r102.f246136c.get("global");
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        return true;
    L19:
        Set<com.bytedance.ies.argus.bean.n> r105 = r102.f246136c.get(r101);
        if (r105 != null) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == false) goto L27;
        return true;
    L27:
        return false;
    L22:
        if (r105.contains(r100) != true) goto L24;
        r106 = true;
        goto L25
    L14:
        if (r103.contains(r100) != true) goto L16;
        r104 = true;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "strategyName");
        Intrinsics.checkNotNullParameter(r101, "argusBizId");
        m r102 = (m) this.f246087d.f246100d;
        if (r102 != null) goto L5;
        return false;
    L5:
        Set<String> r103 = r102.f246137d.get("global");
        if (r103 != null) goto L8;
    L10:
        Set<String> r104 = r102.f246137d.get(r101);
        if (r104 != null) goto L13;
    L15:
        return false;
    L13:
        if (r104.contains(r100) == false) goto L15;
        return true;
    L8:
        if (r103.contains(r100) == false) goto L10;
        return true;
    }

    public final void g(String r100, String r101) {
        BuildersKt.launch$default(e(), null, null, new ArgusConfigManager$updateFromSettings$1(r101, this, r100, null), 3, null);
    }
}
