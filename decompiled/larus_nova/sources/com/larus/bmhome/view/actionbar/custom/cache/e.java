package com.larus.bmhome.view.actionbar.custom.cache;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemTag;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f315871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<ModelItemIdentity, b2> f315872b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, t0> f315873c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f315874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f315875e;

    public e() {
    }

    static {
        f315871a = new Object();
        f315872b = new LinkedHashMap();
        f315873c = new LinkedHashMap();
    }

    public static ReplyOption a(ReplyOption r110) {
        Intrinsics.checkNotNullParameter(r110, "option");
        Object r100 = f315871a;
        monitor-enter(r100);
        boolean r101 = false;
        Object r102 = null;
        Integer r103 = null;
        Integer r104 = null;
        Integer r105 = null;
        r105 = null;
        r105 = null;
        Integer r106 = null;
        r106 = null;
        Integer r107 = null;
        r107 = null;
        if (f315874d == false) goto L110;
        LinkedHashMap<ModelItemIdentity, b2> r108 = f315872b;     // Catch: Throwable -> L136
        if (r108.isEmpty() == true) goto L108;
        LinkedHashMap<String, t0> r109 = f315873c;     // Catch: Throwable -> L136
        if (r109.isEmpty() == true) goto L108;
        String r111 = r110.getModeId();     // Catch: Throwable -> L136
        if (r111 == null) goto L14;
        t0 r112 = r109.get(r111);     // Catch: Throwable -> L136
    L15:
        if (r112 != null) goto L17;
    L24:
        boolean r113 = false;
    L25:
        b2 r114 = r108.get(r110.getModel());     // Catch: Throwable -> L136
        if (r114 != null) goto L28;
    L30:
        if (r113 == false) goto L56;
        if (r101 == false) goto L56;
        List<o1> r115 = r112.f295463n;     // Catch: Throwable -> L136
        if (r115 == null) goto L39;
        List<o1> r116 = r115;     // Catch: Throwable -> L136
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));     // Catch: Throwable -> L136
        Iterator<T> r118 = r116.iterator();     // Catch: Throwable -> L136
    L36:
        if (r118.hasNext() == false) goto L38;
        r117.add(((o1) r118.next()).a());     // Catch: Throwable -> L136
        goto L36
    L38:
        Boolean r119 = Boolean.valueOf(CollectionsKt.contains(r117, r114.b()));     // Catch: Throwable -> L136
    L41:
        if (Intrinsics.areEqual(r119, Boolean.TRUE) == true) goto L49;
        String r120 = r114.f295012s;     // Catch: Throwable -> L136
        u1 r121 = r114.f295013t;     // Catch: Throwable -> L136
        if (r121 == null) goto L45;
        r103 = r121.f295491b;     // Catch: Throwable -> L136
    L45:
        ReplyOption r122 = ReplyOption.copy$default(r110, null, r120, r103, 1, null);     // Catch: Throwable -> L136
        monitor-exit(r100);
        return r122;
    L49:
        if (r110.getReasoningEffort() != null) goto L54;
        u1 r123 = r114.f295013t;     // Catch: Throwable -> L136
        if (r123 == null) goto L53;
        r104 = r123.f295491b;     // Catch: Throwable -> L136
    L53:
        r110 = ReplyOption.copy$default(r110, null, null, r104, 3, null);     // Catch: Throwable -> L136
    L54:
        monitor-exit(r100);
        return r110;
    L39:
        r119 = null;
    L56:
        if (r113 == true) goto L84;
        if (r101 == true) goto L84;
        Iterator<T> r124 = r108.entrySet().iterator();     // Catch: Throwable -> L136
    L60:
        if (r124.hasNext() == false) goto L64;
        Object r125 = r124.next();     // Catch: Throwable -> L136
        Map.Entry r126 = (Map.Entry) r125;     // Catch: Throwable -> L136
        Intrinsics.checkNotNull(r126);     // Catch: Throwable -> L136
        if ((!f.b((b2) r126.getValue())) == false) goto L60;
    L65:
        Map.Entry r127 = (Map.Entry) r125;     // Catch: Throwable -> L136
        if (r127 == null) goto L69;
        ModelItemIdentity r128 = (ModelItemIdentity) r127.getKey();     // Catch: Throwable -> L136
        if (r128 == null) goto L69;
    L70:
        if (r127 == null) goto L74;
        b2 r129 = (b2) r127.getValue();     // Catch: Throwable -> L136
        if (r129 == null) goto L74;
        String r130 = r129.f295012s;     // Catch: Throwable -> L136
    L75:
        if (r127 == null) goto L81;
        b2 r131 = (b2) r127.getValue();     // Catch: Throwable -> L136
        if (r131 == null) goto L81;
        u1 r132 = r131.f295013t;     // Catch: Throwable -> L136
        if (r132 == null) goto L81;
        r105 = r132.f295491b;     // Catch: Throwable -> L136
    L81:
        ReplyOption r133 = r110.copy(r128, r130, r105);     // Catch: Throwable -> L136
        monitor-exit(r100);
        return r133;
    L74:
        r130 = null;
    L69:
        r128 = r110.getModel();     // Catch: Throwable -> L136
        goto L70
    L64:
        r125 = null;
    L84:
        if (r113 == false) goto L86;
        o1 r134 = r112.f295462m;     // Catch: Throwable -> L136
        if (r134 == null) goto L99;
        ModelItemIdentity r135 = r134.a();     // Catch: Throwable -> L136
    L100:
        ModelItemIdentity r136 = r135;
        b2 r137 = r108.get(r136);     // Catch: Throwable -> L136
        if (r137 == null) goto L105;
        u1 r138 = r137.f295013t;     // Catch: Throwable -> L136
        if (r138 == null) goto L105;
        r107 = r138.f295491b;     // Catch: Throwable -> L136
    L105:
        ReplyOption r139 = ReplyOption.copy$default(r110, r136, null, r107, 2, null);     // Catch: Throwable -> L136
        monitor-exit(r100);
        return r139;
    L99:
        r135 = r110.getModel();     // Catch: Throwable -> L136
        goto L100
    L86:
        if (r114 == null) goto L88;
        String r140 = r114.f295012s;     // Catch: Throwable -> L136
    L89:
        if (r114 == null) goto L93;
        u1 r141 = r114.f295013t;     // Catch: Throwable -> L136
        if (r141 == null) goto L93;
        r106 = r141.f295491b;     // Catch: Throwable -> L136
    L93:
        ReplyOption r142 = ReplyOption.copy$default(r110, null, r140, r106, 1, null);     // Catch: Throwable -> L136
        monitor-exit(r100);
        return r142;
    L88:
        r140 = null;
        goto L89
    L28:
        if (f.b(r114) == true) goto L30;
        r101 = true;
        goto L30
    L17:
        if (f315875e == false) goto L23;
        Integer r143 = r112.f295459j;     // Catch: Throwable -> L136
        int r144 = AgentMode.MOA.getValue();     // Catch: Throwable -> L136
        if (r143 == null) goto L24;
        if (r143.intValue() != r144) goto L24;
    L23:
        r113 = true;
        goto L25
    L14:
        r112 = null;
    L108:
        monitor-exit(r100);
        return r110;
    L110:
        LinkedHashMap<ModelItemIdentity, b2> r145 = f315872b;     // Catch: Throwable -> L136
        b2 r146 = r145.get(r110.getModel());     // Catch: Throwable -> L136
        if (r146 != null) goto L113;
    L115:
        if (r101 == false) goto L117;
    L134:
        monitor-exit(r100);
        return r110;
    L117:
        if (r145.isEmpty() == true) goto L134;
        Iterator<T> r147 = r145.entrySet().iterator();     // Catch: Throwable -> L136
    L121:
        if (r147.hasNext() == false) goto L125;
        Object r148 = r147.next();     // Catch: Throwable -> L136
        if (h((b2) ((Map.Entry) r148).getValue()) == false) goto L121;
        r102 = r148;
    L125:
        Map.Entry r149 = (Map.Entry) r102;     // Catch: Throwable -> L136
        if (r149 == null) goto L130;
        ModelItemIdentity r150 = (ModelItemIdentity) r149.getKey();     // Catch: Throwable -> L136
        if (r150 == null) goto L130;
    L131:
        ReplyOption r151 = ReplyOption.copy$default(r110, r150, null, null, 6, null);     // Catch: Throwable -> L136
        monitor-exit(r100);
        return r151;
    L130:
        r150 = wa8.t0.f558885a;     // Catch: Throwable -> L136
        goto L131
    L113:
        if (h(r146) != true) goto L115;
        r101 = true;
    L136:
        th = move-exception;
        throw th;
    }

    public static int c(ReplyOption r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        Object r101 = f315871a;
        monitor-enter(r101);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f315874d == false) goto L11;
        String r102 = r100.getModeId();     // Catch: Throwable -> L21
        if (r102 == null) goto L15;
        t0 r103 = f315873c.get(r102);     // Catch: Throwable -> L21
        if (r103 == null) goto L15;
        Integer r104 = r103.f295459j;     // Catch: Throwable -> L21
    L16:
        monitor-exit(r101);
        if (r104 == null) goto L20;
        return r104.intValue();
    L20:
        return AgentMode.UNKNOWN.getValue();
    L15:
        r104 = null;
        goto L16
    L11:
        b2 r105 = f315872b.get(r100.getModel());     // Catch: Throwable -> L21
        if (r105 == null) goto L15;
        r104 = r105.f295005l;     // Catch: Throwable -> L21
        goto L16
    }

    public static Integer d(ModelItemIdentity r100) {
        Integer r101 = null;
        if (r100 == null) goto L17;
        Object r102 = f315871a;
        monitor-enter(r102);
        b2 r103 = f315872b.get(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        u1 r104 = r103.f295013t;     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        r101 = r104.f295491b;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);
    L14:
        th = move-exception;
        throw th;
    L17:
        return r101;
    }

    public static DefaultReplyMenuItemTag e(List r110) {
        Object r100 = null;
        if (r110 == null) goto L42;
        Iterator r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L34;
        Object r101 = r111.next();
        DefaultReplyMenuItemTag r102 = (DefaultReplyMenuItemTag) r101;
        if (r102 == null) goto L10;
        Integer r103 = r102.getType();
    L11:
        boolean r104 = false;
        if (r103 != null) goto L15;
    L26:
        if (r103 == null) goto L31;
        if (r103.intValue() != 5) goto L31;
        r104 = true;
    L31:
        if (r104 == false) goto L6;
        r100 = r101;
        goto L34
    L15:
        if (r103.intValue() != 6) goto L26;
        Long r105 = r102.getTagExpireTime();
        if (r105 == null) goto L19;
        long r106 = r105.longValue();
    L21:
        if (r106 > 0) goto L23;
    L24:
        r104 = true;
    L25:
        FLogger.f375446a.i("ActionBarMenuSwitchHelper", "getFirstValidTag, expireTime: " + r106 + ", result: " + r104);
        goto L31
    L23:
        if ((AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000)) >= r106) goto L25;
    L19:
        r106 = 0;
        goto L21
    L10:
        r103 = null;
    L34:
        return (DefaultReplyMenuItemTag) r100;
    L42:
        return null;
    }

    public static Map f(ModelItemIdentity r100) {
        if (r100 == null) goto L17;
        Object r101 = f315871a;
        monitor-enter(r101);
        b2 r102 = f315872b.get(r100);     // Catch: Throwable -> L13
        if (r102 == null) goto L9;
        Map<String, String> r103 = r102.f295009p;     // Catch: Throwable -> L13
    L10:
        monitor-exit(r101);
        if (r103 == null) goto L17;
        return r103;
    L9:
        r103 = null;
    L13:
        th = move-exception;
        throw th;
    L17:
        return MapsKt.emptyMap();
    }

    public static String g(ModelItemIdentity r100) {
        Map r101 = f(r100);
        if (r101 == null) goto L6;
        String r102 = (String) r101.get("provider_id");
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static boolean h(b2 r100) {
        if (f.b(r100) == false) goto L6;
        return false;
    L6:
        if (f315875e == false) goto L13;
        Integer r101 = r100.f295005l;
        int r102 = AgentMode.MOA.getValue();
        if (r101 != null) goto L11;
    L12:
        return false;
    L11:
        if (r101.intValue() != r102) goto L12;
        return true;
    L13:
        return true;
    }

    public static boolean i(ReplyOption r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        if (c(r100) != AgentMode.MOA.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void j(List r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Object r101 = f315871a;
        monitor-enter(r101);
        f315872b.clear();     // Catch: Throwable -> L76
        f315873c.clear();     // Catch: Throwable -> L76
        Iterator r102 = r100.iterator();     // Catch: Throwable -> L76
    L5:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L18;
        Object r104 = r102.next();     // Catch: Throwable -> L76
        p0 r105 = ((z0) r104).f295619o;     // Catch: Throwable -> L76
        if (r105 == null) goto L15;
        Integer r106 = r105.f295366a;     // Catch: Throwable -> L76
        int r107 = ActiveSwitchType.DEEPTHINK.getValue();     // Catch: Throwable -> L76
        if (r106 == null) goto L15;
        if (r106.intValue() != r107) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L5;
    L19:
        z0 r109 = (z0) r104;     // Catch: Throwable -> L76
        if (r109 == null) goto L22;
        p0 r110 = r109.f295619o;     // Catch: Throwable -> L76
    L23:
        if (r110 == null) goto L25;
        boolean r111 = Intrinsics.areEqual(r110.f295376k, Boolean.TRUE);     // Catch: Throwable -> L76
    L26:
        f315874d = r111;     // Catch: Throwable -> L76
        if (r110 == null) goto L31;
        a2 r112 = r110.d();     // Catch: Throwable -> L76
        if (r112 == null) goto L31;
        List r113 = r112.f294974a;     // Catch: Throwable -> L76
    L32:
        if (r113 != null) goto L34;
        r113 = CollectionsKt.emptyList();     // Catch: Throwable -> L76
    L34:
        Iterator r114 = r113.iterator();     // Catch: Throwable -> L76
    L36:
        if (r114.hasNext() == false) goto L42;
        b2 r115 = (b2) r114.next();     // Catch: Throwable -> L76
        ModelItemIdentity r116 = r115.b();     // Catch: Throwable -> L76
        if (r116 == null) goto L36;
        f315872b.put(r116, r115);     // Catch: Throwable -> L76
        goto L36
    L42:
        if (f315874d == false) goto L66;
        if (r110 == null) goto L49;
        s0 r117 = r110.f295375j;     // Catch: Throwable -> L76
        if (r117 == null) goto L49;
        u0 r118 = r117.f295431a;     // Catch: Throwable -> L76
        if (r118 == null) goto L49;
        List r119 = r118.f295485a;     // Catch: Throwable -> L76
    L50:
        if (r119 != null) goto L52;
        r119 = CollectionsKt.emptyList();     // Catch: Throwable -> L76
    L52:
        Iterator r120 = r119.iterator();     // Catch: Throwable -> L76
    L54:
        if (r120.hasNext() == false) goto L66;
        t0 r121 = (t0) r120.next();     // Catch: Throwable -> L76
        String r122 = r121.f295450a;     // Catch: Throwable -> L76
        if (r122 == null) goto L54;
        if (r122.length() <= 0) goto L60;
        boolean r123 = true;
    L61:
        if (r123 == true) goto L64;
        r122 = null;
    L64:
        if (r122 == null) goto L54;
        f315873c.put(r122, r121);     // Catch: Throwable -> L76
        goto L54
    L60:
        r123 = false;
    L49:
        r119 = null;
    L66:
        FLogger.f375446a.d("ActionBarMenuSwitchHelper", "store, isUsingMenuConfV2: " + f315874d + ", modelItemMap: " + f315872b.keySet() + ", modeItemMap: " + f315873c.keySet());     // Catch: Throwable -> L76
        ObricTaskSkillDelegate r124 = ObricTaskSkillDelegate.f392916b;     // Catch: Throwable -> L76
        boolean r125 = f315874d;     // Catch: Throwable -> L76
        if (r110 == null) goto L73;
        s0 r126 = r110.f295375j;     // Catch: Throwable -> L76
        if (r126 == null) goto L73;
        Boolean r127 = r126.f295434d;     // Catch: Throwable -> L76
        if (r127 == null) goto L73;
        r103 = r127.booleanValue();     // Catch: Throwable -> L76
    L73:
        r124.r(r125, r103);     // Catch: Throwable -> L76
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r101);
        return;
    L31:
        r113 = null;
        goto L32
    L25:
        r111 = false;
        goto L26
    L22:
        r110 = null;
    L15:
        r108 = false;
        goto L16
    L18:
        r104 = null;
    L76:
        th = move-exception;
        throw th;
    }

    public static ReplyOption b(ReplyOption.a r100, ModelItemIdentity r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "modelItemIdentity");
        if (r102 != null) goto L20;
        if (r101 == null) goto L19;
        Object r104 = f315871a;
        monitor-enter(r104);
        b2 r105 = f315872b.get(r101);     // Catch: Throwable -> L16
        if (r105 == null) goto L11;
        String r106 = r105.f295012s;     // Catch: Throwable -> L16
    L12:
        monitor-exit(r104);
        if (r106 == null) goto L19;
        r102 = r106;
        goto L20
    L11:
        r106 = null;
    L16:
        th = move-exception;
        throw th;
    L19:
        r102 = "";
    L20:
        if (r103 != null) goto L23;
        r103 = d(r101);
    L23:
        return new ReplyOption(r101, r102, r103);
    }
}
