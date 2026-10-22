package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRuleList;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mhc.b f454635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f454636b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f454637c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<c> f454638d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<r> f454639e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f454640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f454641g = null;

    public static abstract class a {
        public a() {
        }

        public abstract void b(s r100);

        public abstract void c(ControlRule r100);

        public abstract void d(ControlRule r100);

        public void a(boolean r100, ControlRule r101) {
            Logger r102 = Logger.f454747c;
            Objects.toString(r101);
            r102.b();
        }
    }

    public j() {
    }

    static {
        f454641g = new j();
        f454635a = new mhc.b();
        f454636b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("RouteOutControlManager"));
        f454637c = new e(0);
        f454638d = new ArrayList();
        f454639e = new ArrayList();
        f454640f = true;
    }

    public static boolean a() {
        if (f454640f == false) goto L7;
        f454635a.getClass();
        if (Intrinsics.areEqual("off", "on") == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static Map d(String r100) {
        e r101 = f454637c;
        monitor-enter(r101);
        ListIterator<c> r102 = r101.listIterator(r101.size());     // Catch: Throwable -> L26
    L5:
        Map r103 = null;
        if (r102.hasPrevious() == false) goto L10;
        c r104 = r102.previous();     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r104.f454615c, r100) == false) goto L5;
    L11:
        c r105 = r104;     // Catch: Throwable -> L26
        if (r105 == null) goto L14;
        r105.getClass();     // Catch: Throwable -> L26
    L14:
        ArrayList r106 = (ArrayList) f454638d;     // Catch: Throwable -> L26
        ListIterator r107 = r106.listIterator(r106.size());     // Catch: Throwable -> L26
    L16:
        if (r107.hasPrevious() == false) goto L20;
        Object r108 = r107.previous();     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(((c) r108).f454615c, r100) == false) goto L16;
    L21:
        c r109 = (c) r108;     // Catch: Throwable -> L26
        if (r109 == null) goto L24;
        r103 = null;
        r109.getClass();     // Catch: Throwable -> L26
    L24:
        monitor-exit(r101);
        return r103;
    L20:
        r108 = null;
        goto L21
    L10:
        r104 = null;
    L26:
        th = move-exception;
        throw th;
    }

    public static d b(Intent r100, String r110) {
        d r111 = c(r100, r110);
        String r101 = r111.f454619b;
        String r112 = r111.f454618a;
        ArrayList r102 = new ArrayList();
        if (r101.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        r102.add(r101);
    L9:
        if (r112.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r102.add(r112);
    L14:
        e r105 = f454637c;
        monitor-enter(r105);
        Iterator r106 = CollectionsKt.asReversedMutable(r105).iterator();     // Catch: Throwable -> L91
        int r107 = 0;
    L18:
        if (r106.hasNext() == false) goto L26;
        c r108 = (c) r106.next();     // Catch: Throwable -> L91
        if (r107 > 1) goto L25;
        if ((!Intrinsics.areEqual(r108.f454615c, r101)) == false) goto L18;
        if ((!Intrinsics.areEqual(r108.f454615c, r112)) == false) goto L18;
    L25:
        r107 = r107 + 1;     // Catch: Throwable -> L91
        r102.add(r108.f454615c);     // Catch: Throwable -> L91
        goto L18
    L26:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L91
        monitor-exit(r105);
        if (r101.length() <= 0) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L41;
        if (r112.length() <= 0) goto L36;
        boolean r114 = true;
    L37:
        if (r114 == false) goto L41;
        return new d(r112, r101, r102);
    L36:
        r114 = false;
    L41:
        if (r101.length() != 0) goto L43;
        boolean r115 = true;
    L44:
        if (r115 == false) goto L57;
        e r116 = f454637c;
        monitor-enter(r116);
        int r117 = r116.size();     // Catch: Throwable -> L53
        if (r117 <= 0) goto L50;
        String r118 = r116.a(r117 - 1).f454615c;     // Catch: Throwable -> L53
    L51:
        monitor-exit(r116);
        r101 = r118;
        goto L57
    L50:
        r118 = "";
    L53:
        th = move-exception;
        throw th;
    L57:
        if (r101.length() != 0) goto L59;
        boolean r119 = true;
    L60:
        if (r119 == false) goto L64;
        return new d(r112, "", r102);
    L64:
        if (r112.length() != 0) goto L66;
        boolean r120 = true;
    L67:
        if (r120 == false) goto L89;
        e r121 = f454637c;
        monitor-enter(r121);
        int r122 = r121.size() - 1;     // Catch: Throwable -> L86
    L71:
        if (r122 < 0) goto L81;
        if (r112.length() != 0) goto L75;
        boolean r123 = true;
    L76:
        if (r123 == true) goto L79;
        if (Intrinsics.areEqual(r112, r101) == false) goto L81;
    L79:
        r112 = f454637c.a(r122).f454615c;     // Catch: Throwable -> L86
        r122 = r122 - 1;     // Catch: Throwable -> L86
        goto L71
    L75:
        r123 = false;
    L81:
        if (Intrinsics.areEqual(r112, r101) == false) goto L83;
        r112 = "";
    L83:
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L86
        monitor-exit(r121);
    L86:
        th = move-exception;
        throw th;
    L89:
        r100.putExtra("ug_open_third_app_last_cert_id", r112);
        r100.putExtra("ug_open_third_app_cert_id", r101);
        return new d(r112, r101, r102);
    L66:
        r120 = false;
        goto L67
    L59:
        r119 = false;
        goto L60
    L43:
        r115 = false;
        goto L44
    L31:
        r113 = false;
    L91:
        th = move-exception;
        throw th;
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    public static d c(Intent r100, String r101) {
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        String r103 = "";
        if (r102 == false) goto L12;
        r101 = g("ug_open_third_app_cert_id", r100);
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        String r104 = g("ug_open_third_app_last_cert_id", r100);
        if (r104 == null) goto L16;
        r103 = r104;
    L16:
        return new d(r103, r101, new ArrayList());
    L5:
        r102 = false;
        goto L6
    }

    public static r f(String r100, String r101) {
        List<r> r102 = f454639e;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L23
    L6:
        if (r103.hasNext() == false) goto L19;
        r r104 = (r) r103.next();     // Catch: Throwable -> L23
        s r105 = r104.f454669a;     // Catch: Throwable -> L23
        String r106 = r105.f454671a.f454659c.f454619b;     // Catch: Throwable -> L23
        ControlRule r107 = r105.f454674d;     // Catch: Throwable -> L23
        if (r107 == null) goto L12;
        String r108 = r107.getRuleId();     // Catch: Throwable -> L23
        if (r108 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r106, r100) == false) goto L6;
        if (Intrinsics.areEqual(r108, r101) == false) goto L6;
        monitor-exit(r102);
        return r104;
    L12:
        r108 = "";
        goto L14
    L19:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r102);
        return null;
    L23:
        th = move-exception;
        throw th;
    }

    public static String g(String r100, Intent r101) {
        Uri r102 = r101.getData();
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        String r104 = null;
    L8:
        if (r104 != null) goto L10;
    L13:
        if (r103 == false) goto L16;
        return r101.getStringExtra(r100);
    L16:
        return Uri.decode(r104);
    L10:
        if (r104.length() == 0) goto L13;
        r103 = false;
        goto L13
    L5:
        if (r102.isHierarchical() != true) goto L7;
        r104 = UriProtector.getQueryParameter(r102, r100);
        goto L8
    }

    public static s h(o r110, Intent r111) {
        com.ss.android.ugc.route_monitor.impl.route_out.o r100 = com.ss.android.ugc.route_monitor.impl.route_out.o.f454736h;
        String r101 = r110.f454661e;
        r100.getClass();
        boolean r102 = true;
        if ((!Intrinsics.areEqual(com.ss.android.ugc.route_monitor.impl.route_out.o.c(r101), "third_app")) == false) goto L6;
        ControlRule.Companion.getClass();
        ControlRule r103 = new ControlRule();
        ControlRule.access$setCertId$p(r103, "");
        ControlRule.access$setRuleId$p(r103, "");
        ControlRule.access$setPriority$p(r103, 0);
        ControlRule.access$setAction$p(r103, 100);
        ControlRule.access$setStrategyType$p(r103, 0);
        ControlRule.access$setValidCondition$p(r103, null);
        ControlRule.access$setExtraData$p(r103, null);
        s r104 = new s(r110, MatchResult.SUCCEED, "not_third_app_route_out", r103, false);
    L26:
        if (r104.f454672b == MatchResult.SUCCEED) goto L28;
    L30:
        boolean r105 = false;
    L31:
        if (r105 == true) goto L45;
        Logger r106 = Logger.f454747c;
        r104.toString();
        r106.b();
        Iterator<ControlRule> r107 = f454635a.f514029c.iterator();
    L34:
        if (r107.hasNext() == false) goto L45;
        ControlRule r108 = r107.next();
        mhc.c r109 = r108.match(r110);
        if (r109.f514033d == true) goto L37;
        r104.f454676f.add(r109);
        goto L34
    L37:
        List<String> r112 = r110.f454659c.f454620c;
        r110.f454659c = b(r111, r108.getCertId());
        RouteMonitorManager.f454384g.b().getClass();
        List<String> r113 = r110.f454659c.f454620c;
        r113.clear();
        if (r108.getCertId().length() > 0) goto L41;
        r102 = false;
    L41:
        if (r102 == false) goto L43;
        r113.add(r108.getCertId());
    L43:
        r113.addAll(r112);
        MatchResult r114 = MatchResult.SUCCEED;
        r104 = new s(r110, r114, r114.toString(), r108, true);
        Logger r115 = Logger.f454747c;
        r104.toString();
        r115.b();
    L45:
        RouteMonitorManager.f454384g.b().getClass();
        List<r> r116 = f454639e;
        monitor-enter(r116);
    L64:
        th = move-exception;
        throw th;
    L48:
        if (((ArrayList) r116).size() <= 5) goto L50;
        r r117 = (r) ((ArrayList) r116).remove(((ArrayList) r116).size() - 1);     // Catch: Throwable -> L64
        Logger r118 = Logger.f454747c;     // Catch: Throwable -> L64
        ((ArrayList) r116).size();     // Catch: Throwable -> L64
        Objects.toString(r117);     // Catch: Throwable -> L64
        r118.b();     // Catch: Throwable -> L64
    L50:
        String r119 = r104.f454671a.f454659c.f454619b;     // Catch: Throwable -> L64
        ControlRule r120 = r104.f454674d;     // Catch: Throwable -> L64
        if (r120 == null) goto L55;
        String r121 = r120.getRuleId();     // Catch: Throwable -> L64
        if (r121 == null) goto L55;
    L56:
        r r122 = f(r119, r121);     // Catch: Throwable -> L64
        if (r122 == null) goto L59;
        r122.f454669a = r104;     // Catch: Throwable -> L64
    L60:
        Logger r123 = Logger.f454747c;     // Catch: Throwable -> L64
        ((ArrayList) r116).size();     // Catch: Throwable -> L64
        r104.toString();     // Catch: Throwable -> L64
        r123.b();     // Catch: Throwable -> L64
        monitor-exit(r116);
        Logger r124 = Logger.f454747c;
        r104.toString();
        r124.b();
        return r104;
    L59:
        ((ArrayList) r116).add(0, new r(r104));     // Catch: Throwable -> L64
    L55:
        r121 = "";
        goto L56
    L28:
        if (r104.f454674d == null) goto L30;
        r105 = true;
        goto L31
    L6:
        if (r110.f454659c.f454619b.length() <= 0) goto L8;
        boolean r125 = true;
    L9:
        if (r125 == true) goto L11;
        MatchResult r126 = MatchResult.CERT_ID_INVALID;
        r104 = new s(r110, r126, r126.toString(), null, false);
        goto L26
    L11:
        String r127 = r110.f454659c.f454619b;
        mhc.a r128 = (mhc.a) f454635a.f514028b.get(r127);
        if (r128 == null) goto L14;
        ControlRuleList r129 = r128.f514026b;
    L15:
        if (r129 != null) goto L17;
        RouteMonitorManager.f454384g.b().getClass();
        ControlRule.Companion.getClass();
        ControlRule r130 = new ControlRule();
        ControlRule.access$setCertId$p(r130, r127);
        ControlRule.access$setRuleId$p(r130, "");
        ControlRule.access$setPriority$p(r130, 0);
        ControlRule.access$setAction$p(r130, 100);
        ControlRule.access$setStrategyType$p(r130, 0);
        ControlRule.access$setValidCondition$p(r130, null);
        ControlRule.access$setExtraData$p(r130, null);
        r104 = new s(r110, MatchResult.SUCCEED, "miss_match_rule", r130, false);
        goto L26
    L17:
        ArrayList r131 = new ArrayList();
        Iterator<ControlRule> r132 = r129.iterator();
    L19:
        if (r132.hasNext() == false) goto L24;
        ControlRule r133 = r132.next();
        mhc.c r134 = r133.match(r110);
        if (r134.f514033d == true) goto L22;
        r131.add(r134);
        goto L19
    L22:
        MatchResult r135 = MatchResult.SUCCEED;
        r104 = new s(r110, r135, r135.toString(), r133, true);
        goto L26
    L24:
        MatchResult r136 = MatchResult.CONDITION_MISS_MATCH;
        r104 = new s(r110, r136, r136.toString(), null, true, r131);
        goto L26
    L14:
        r129 = null;
        goto L15
    L8:
        r125 = false;
        goto L9
    }

    public final o e(Intent r110, ComponentInfo r111) {
        d r100 = b(r110, "");
        String r101 = r100.f454619b;
        String r102 = g("ug_open_third_app_biz_data", r110);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L65;
        e r104 = f454637c;
        monitor-enter(r104);
        ListIterator<c> r105 = r104.listIterator(r104.size());     // Catch: Throwable -> L33
    L13:
        Object r106 = null;
        if (r105.hasPrevious() == false) goto L18;
        c r107 = r105.previous();     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(r107.f454615c, r101) == false) goto L13;
    L19:
        c r108 = r107;     // Catch: Throwable -> L33
        if (r108 == null) goto L22;
        r108.getClass();     // Catch: Throwable -> L33
    L22:
        ArrayList r109 = (ArrayList) f454638d;     // Catch: Throwable -> L33
        ListIterator r112 = r109.listIterator(r109.size());     // Catch: Throwable -> L33
    L24:
        if (r112.hasPrevious() == false) goto L28;
        Object r113 = r112.previous();     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(((c) r113).f454615c, r101) == false) goto L24;
        r106 = r113;
    L28:
        c r114 = (c) r106;     // Catch: Throwable -> L33
        if (r114 == null) goto L31;
        r114.getClass();     // Catch: Throwable -> L33
    L31:
        monitor-exit(r104);
        Map r115 = MapsKt.emptyMap();
    L43:
        Map r116 = r115;
        com.ss.android.ugc.route_monitor.c.a().e().getClass();
        int r117 = lhc.c.f509309a;
        if (r111 == null) goto L50;
        ApplicationInfo r118 = r111.applicationInfo;
        if (r118 == null) goto L50;
        String r119 = r118.packageName;
        if (r119 == null) goto L50;
    L51:
        String r120 = r119;
        Uri r121 = r110.getData();
        com.ss.android.ugc.route_monitor.c.a().f();
        m.a().getClass();
        boolean r122 = CollectionsKt.emptyList().contains(r120);
        RouteMonitorManager.f454384g.b().a();
        String r123 = String.valueOf(-1);
        String r124 = r110.getAction();
        if (r124 != null) goto L55;
        r124 = "";
    L55:
        String r125 = r124;
        if (r121 == null) goto L60;
        String r126 = r121.getScheme();
        if (r126 == null) goto L60;
    L62:
        return new o(r125, r126, r100, "", r120, r121, -1, r123, r122, r116);
    L60:
        r126 = "";
    L50:
        r119 = "";
        goto L51
    L18:
        r107 = null;
    L33:
        th = move-exception;
        throw th;
    L65:
        r115 = new LinkedHashMap();     // Catch: Throwable -> L41
        JSONObject r127 = new JSONObject(r102);     // Catch: Throwable -> L41
        Iterator<String> r128 = r127.keys();     // Catch: Throwable -> L41
    L38:
        if (r128.hasNext() == false) goto L43;
        String r129 = r128.next();     // Catch: Throwable -> L41
        r115.put(r129, r127.get(r129));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Logger.f454747c.d(th);
        r115 = MapsKt.emptyMap();
        goto L43
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final ControlRule i(Intent r100, ResolveInfo r101) {
        if (r101 == null) goto L5;
        ActivityInfo r102 = r101.activityInfo;
    L7:
        if (a() == false) goto L31;
        Logger r103 = Logger.f454747c;
        Objects.toString(r100);
        Objects.toString(r102);
        r103.b();
        String r104 = r100.getStringExtra("ug_open_third_app_cert_id");
        if (r104 == null) goto L24;
        String r105 = r100.getStringExtra("ug_open_third_app_rule_id");
        if (r105 == null) goto L24;
        mhc.a r106 = (mhc.a) f454635a.f514028b.get(r104);
        if (r106 == null) goto L24;
        ControlRuleList r107 = r106.f514026b;
        if (r107 == null) goto L24;
        Iterator<ControlRule> r108 = r107.iterator();
    L18:
        if (r108.hasNext() == false) goto L22;
        ControlRule r109 = r108.next();
        if (Intrinsics.areEqual(r109.getRuleId(), r105) == false) goto L18;
    L23:
        ControlRule r110 = r109;
    L25:
        if (r110 != null) goto L35;
        if (r102 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("app");
        throw null;
    L36:
        return h(e(r100, r102), r100).f454674d;
    L35:
        return r110;
    L22:
        r109 = null;
    L24:
        r110 = null;
        goto L25
    L31:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    public final void j(Intent r100, ComponentInfo r110, a r111) {
        Logger r101 = Logger.f454747c;
        Objects.toString(r100);
        Objects.toString(r110);
        r111.toString();
        r101.b();
        o r102 = e(r100, r110);
        if (a() == true) goto L6;
        MatchResult r103 = MatchResult.SWITCH_OFF;
        r111.b(new s(r102, r103, r103.toString(), null, false));
        return;
    L6:
        s r104 = h(r102, r100);
        if (r104.f454672b == MatchResult.SUCCEED) goto L9;
    L11:
        boolean r112 = false;
    L12:
        if (r112 == false) goto L21;
        ControlRule r105 = r104.f454674d;
        if (r105 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        r111.c(r105);
        WeakReference<Activity> r113 = com.ss.android.ugc.route_monitor.utils.c.f454753e;
        if (r113 == null) goto L19;
        Activity r114 = r113.get();
    L20:
        r105.execRule(r114, r111);
        return;
    L19:
        r114 = null;
        goto L20
    L21:
        r111.b(r104);
        return;
    L9:
        if (r104.f454674d == null) goto L11;
        r112 = true;
        goto L12
    }
}
