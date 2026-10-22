package com.bytedance.android.shopping.ligo.context;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.shopping.ligo.monitor.LigoMonitor;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;
import w83.e;
import w83.f;
import w83.h;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;", "Lw83/i;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LigoViewManager implements i, LifecycleEventObserver {
    public static final /* synthetic */ int l = 0;
    public final HashMap<ViewGroup, HashMap<String, ll.c>> a;
    public final LigoComponentRegistry b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final LifecycleOwner f;
    public final Map<String, Object> g;
    public final w83.d<?> h;
    public final Function0<Map<String, Object>> i;
    public final Function0<x83.a> j;
    public final com.bytedance.android.shopping.ligo.monitor.a k;

    public static final class a {
        public static void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
            Object r0 = r4.getTag(2131370717);
            if ((r0 instanceof l) == true) goto L5;
            r0 = null;
        L5:
            l r1 = (l) r0;
            if (r1 == null) goto L9;
            dm.a.a("LigoViewManager").i("id: " + r4.getId() + " release component success");
            r1.release();
            return;
        }
    }

    public static final class b implements LifecycleEventObserver {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r6, Lifecycle.Event r7) {
            Intrinsics.checkNotNullParameter(r6, "source");
            Intrinsics.checkNotNullParameter(r7, "event");
            int r8 = com.bytedance.android.shopping.ligo.context.d.a[r7.ordinal()];
            if (r8 != 1) goto L5;
            l r9 = this.a;
            JSONObject r4 = new JSONObject();
            r4.put("visible", true);
            r4.put("source", "page");
            Unit r10 = Unit.INSTANCE;
            r9.sendJsEvent("pageVisibilityChange", r4);
            return;
        L5:
            if (r8 != 2) goto L11;
            l r11 = this.a;
            JSONObject r3 = new JSONObject();
            r3.put("visible", false);
            r3.put("source", "page");
            Unit r12 = Unit.INSTANCE;
            r11.sendJsEvent("pageVisibilityChange", r3);
            return;
        }
    }

    public static final class c implements k {
        public final /* synthetic */ LigoViewManager a;
        public final /* synthetic */ ll.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f d;

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            dm.a.a("LigoViewManager").w("load lynx failed by inner fallback!schema=" + this.c, null);
            f r0 = this.d;
            if (r0 == null) goto L5;
            r0.onFallback();
        L5:
            LigoViewManager r1 = this.a;
            int r2 = LigoViewManager.l;
            r1.h().d(this.b, String.valueOf(-1), "");
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            LigoViewManager r4 = this.a;
            int r0 = LigoViewManager.l;
            r4.h().a().b(this.b);
            dm.a.a("LigoViewManager").i("load lynx success, schema=" + this.c);
            f r5 = this.d;
            if (r5 == null) goto L6;
            r5.onLoadSuccess();
            return;
        }

        public final void onRuntimeReady(View r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            LigoViewManager r4 = this.a;
            int r0 = LigoViewManager.l;
            com.bytedance.android.shopping.ligo.monitor.c r5 = r4.h().a();
            ll.a r1 = this.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r1, "dynamicRegion");
            r5.c(r1.e(), "on_runtime_ready");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        }

        public final void onLoadFailed(View r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            dm.a.a("LigoViewManager").w("load lynx failed! schema=" + this.c, null);
            f r5 = this.d;
            if (r5 == null) goto L5;
            r5.a(r4);
        L5:
            LigoViewManager r6 = this.a;
            int r0 = LigoViewManager.l;
            r6.h().d(this.b, "", r4);
        }

        public final void onPageStart(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            LigoViewManager r4 = this.a;
            int r5 = LigoViewManager.l;
            com.bytedance.android.shopping.ligo.monitor.c r6 = r4.h().a();
            ll.a r7 = this.b;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "dynamicRegion");
            r6.c(r7.e(), "on_page_start");
        }

        public final void s(View r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
            LigoViewManager r9 = this.a;
            int r10 = LigoViewManager.l;
            LigoMonitor r11 = r9.h();
            ll.a r12 = this.b;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "dynamicRegion");
            Intrinsics.checkNotNullParameter("", "errorCode");
            com.bytedance.android.shopping.ligo.monitor.d r13 = r11.b;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r12, "dynamicRegion");
            Intrinsics.checkNotNullParameter("", "errorCode");
            String r14 = r13.a;
            String r0 = "lynx_runtime_error_" + r12.b();
            Map r15 = com.bytedance.android.shopping.ligo.monitor.d.a(r12, new Pair[]{new Pair("error_code", ""), new Pair("error_msg", r8)});
            xh.b r16 = new xh.b();
            r16.c(r14);
            r16.b(r0);
            r16.a(r15);
            xh.c.a("Ligo").f(5, r16);
        }

        public c(LigoViewManager r1, ll.a r2, String r3, f r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((x83.b) r1).b), Integer.valueOf(((x83.b) r2).b));
        }
    }

    static {
    }

    public final LigoMonitor h() {
        return (LigoMonitor) this.c.getValue();
    }

    public static boolean f(ViewGroup r5) {
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        int r0 = r6.width;
        if (r0 == (-1)) goto L5;
        if (r0 == (-2)) goto L5;
    L9:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L14;
        r6 = null;
    L14:
        if (r6 != null) goto L18;
        return false;
    L18:
        return true;
    L5:
        int r2 = r6.height;
        if (r2 == (-1)) goto L10;
        if (r2 != (-2)) goto L9;
    L10:
        r1 = true;
        goto L11
    }

    @Override // w83.i
    public final void b(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        HashMap<String, ll.c> r0 = this.a.get(r3);
        if (r0 == null) goto L11;
        Iterator<Map.Entry<String, ll.c>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        View r2 = g(r3, r1.next().getValue());
        if (r2 == null) goto L6;
        r3.removeViewAt(r3.indexOfChild(r2));
    L11:
        this.a.remove(r3);
    }

    @Override // w83.i
    public final void d(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        dm.a.a("LigoViewManager").a("unload: parent: " + r4.hashCode());
        l(r4);
        this.a.remove(r4);
    }

    public final void l(ViewGroup r8) {
        HashMap<String, ll.c> r0 = this.a.get(r8);
        if (r0 == null) goto L40;
        Collection<ll.c> r1 = r0.values();
        if (r1 == null) goto L46;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L47;
        ll.c r3 = (ll.c) r2.next();
        dm.a.a("LigoViewManager").a("[unload] cache: {" + r3.getIdentifier() + " data: {name=" + r3.b.b() + " type=" + r3.b.a() + ", url=" + r3.b.e() + ", params" + r3.b.c() + "}}");
        LifecycleOwner r4 = this.f;
        if ((r4 instanceof Fragment) == true) goto L12;
        r4 = null;
    L12:
        Fragment r5 = (Fragment) r4;
        if (r5 == null) goto L15;
        FragmentManager r6 = r5.getChildFragmentManager();
    L16:
        Integer r7 = r3.getIdentifier().a;
        if (r7 == null) goto L27;
        int r9 = r7.intValue();
        View r10 = r8.findViewById(r9);
        if (r10 == null) goto L21;
        m(r8, r10, r3);
        Unit r11 = Unit.INSTANCE;
    L26:
        if (r11 == null) goto L27;
    L38:
        if (r11 != null) goto L8;
        dm.a.a("LigoViewManager").w("[unload] no view find to remove", null);
        goto L8
    L21:
        if (r6 == null) goto L25;
        Fragment r12 = r6.findFragmentById(r9);
        if (r12 == null) goto L25;
        k(r12, r6);
        r11 = Unit.INSTANCE;
    L25:
        r11 = null;
    L27:
        String r13 = r3.getIdentifier().b;
        if (r13 == null) goto L37;
        View r14 = r8.findViewWithTag(r13);
        if (r14 == null) goto L33;
        m(r8, r14, r3);
        Unit r15 = Unit.INSTANCE;
    L32:
        r11 = r15;
        goto L38
    L33:
        if (r6 == null) goto L37;
        Fragment r16 = r6.findFragmentByTag(r13);
        if (r16 == null) goto L37;
        k(r16, r6);
        r15 = Unit.INSTANCE;
    L37:
        r11 = null;
        goto L38
    L15:
        r6 = null;
        goto L16
    L47:
        return;
    L46:
        return;
    }

    public static View g(ViewGroup r2, ll.c r3) {
        Integer r0 = r3.getIdentifier().a;
        if (r0 == null) goto L6;
        View r1 = r2.findViewById(r0.intValue());
        if (r1 == null) goto L6;
    L10:
        if (r1 != null) goto L13;
        return null;
    L13:
        return r1;
    L6:
        String r4 = r3.getIdentifier().b;
        if (r4 == null) goto L9;
        r1 = r2.findViewWithTag(r4);
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public static void k(Fragment r2, FragmentManager r3) {
        dm.a.a("LigoViewManager").a("[unload] parent has fragment");
        r3.beginTransaction().setTransition(0).setTransitionStyle(0).setCustomAnimations(0, 0, 0, 0).remove(r2).commitNowAllowingStateLoss();
    }

    public final void j(ViewGroup r7, String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        HashMap<String, ll.c> r1 = this.a.get(r7);
        if (r1 == null) goto L16;
        Iterator<Map.Entry<String, ll.c>> r2 = r1.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<String, ll.c> r3 = r2.next();
        View r4 = g(r7, r3.getValue());
        if (r4 == null) goto L8;
        int r5 = r7.indexOfChild(r4);
        if (r5 == (-1)) goto L8;
        r0.add(new x83.b(r4, r5, r3));
    L16:
        Function0<x83.a> r9 = this.j;
        if (r9 == null) goto L29;
        x83.a r10 = (x83.a) r9.invoke();
        if (r10 == null) goto L30;
        r10.c(r8, r0);
        return;
    L30:
        return;
    }

    public final boolean n(View r11, ll.a r12) {
        h().a().a(r12);
        int r0 = r12.a();
        Object r7 = null;
        if (r0 != DynamicType.LYNX.getValue()) goto L49;
        String r1 = r12.e();
        if (r1 != null) goto L7;
    L46:
        h().b(r12, "10001", "template_url is null");
        return false;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L46;
        LinkedHashMap r3 = new LinkedHashMap();
        Map<String, Object> r4 = this.g;
        if (r4 == null) goto L18;
        r3.putAll(r4);
    L18:
        Function0<Map<String, Object>> r5 = this.i;
        if (r5 == null) goto L23;
        Map r6 = (Map) r5.invoke();
        if (r6 == null) goto L23;
        r3.putAll(r6);
    L23:
        String r8 = r12.c();
        if (r8 == null) goto L26;
        r3.put("dynamic_region_params", r8);
    L26:
        String r9 = r12.e();
        if (r9 != null) goto L29;
    L37:
        Unit r10 = Unit.INSTANCE;
        Map r13 = MapsKt.mapOf(TuplesKt.to("ecom_dynamic_params", r3));
        UrlBuilderV2 r14 = new UrlBuilderV2(r12.e());
        String r15 = UUID.randomUUID().toString();
        HashMap r16 = j.a;
        j.h(r15, new JSONObject(r13));
        r14.addOrReplaceParam("mega_object_id", r15);
        String r17 = r14.build();
        Object r18 = r11.getTag(2131370717);
        if ((r18 instanceof l) == false) goto L41;
        r7 = r18;
    L41:
        l r19 = (l) r7;
        if (r19 == null) goto L45;
        dm.a.a("LigoViewManager").i("id: " + r11.getId() + " renderTemplate");
        r19.updateBusinessGlobalProps(r13);
        r19.renderTemplate(r17, r13);
        h().c(r12);
        return true;
    L45:
        h().b(r12, "10005", "cannot get annie card.");
    L71:
        h().b(r12, "10004", "unknown dynamic_type " + r12.a());
        return false;
    L29:
        if (r9.length() <= 0) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == true) goto L35;
        r9 = null;
    L35:
        if (r9 == null) goto L37;
        com.bytedance.android.shopping.ligo.monitor.c r21 = h().a();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r12, "dynamicRegion");
        r3.put("dynamic_region_perf_params", (Map) ((LinkedHashMap) r21.a).get(r12.e()));
        goto L37
    L31:
        r20 = false;
        goto L32
    L9:
        r2 = false;
        goto L10
    L49:
        if (r0 != DynamicType.NATIVE.getValue()) goto L71;
        String r22 = r12.e();
        if (r22 != null) goto L53;
    L69:
        h().b(r12, "10001", "template_url is null");
        return false;
    L53:
        if (r22.length() <= 0) goto L55;
        boolean r23 = true;
    L56:
        if (r23 == false) goto L58;
        r7 = r22;
    L58:
        if (r7 == null) goto L69;
        w83.a r24 = this.b.a(UriProtector.parse(r12.e()));
        if (r24 != null) goto L65;
        h().b(r12, "10005", "cannot get NA component.");
        return false;
    L65:
        if ((r24 instanceof h) == false) goto L67;
        ((h) r24).d(r11, r12);
        dm.a.a("LigoViewManager").i("id: " + r11.getId() + " update compose success");
    L67:
        h().c(r12);
        return true;
    L55:
        r23 = false;
        goto L56
    }

    public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = com.bytedance.android.shopping.ligo.context.d.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        dm.a.a("LigoViewManager").a("onCreate clear cache");
        this.a.clear();
        ((LinkedHashMap) h().a().a).clear();
        return;
    L5:
        if (r5 != 2) goto L22;
        dm.a.a("LigoViewManager").a("onDestroy clear cache");
        Iterator<T> r6 = this.a.keySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        l((ViewGroup) r6.next());     // Catch: Exception -> L14
        goto L10
    L12:
        this.a.clear();     // Catch: Exception -> L14
        ((LinkedHashMap) h().a().a).clear();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        dm.a.a("LigoViewManager").b("dynamicCache clear failed, e = " + e, null);
        return;
    }

    public final void m(ViewGroup r7, View r8, ll.c r9) {
        dm.a.a("LigoViewManager").a("[unload] parent has view");
        int r1 = r7.indexOfChild(r8);
        if (r1 != (-1)) goto L5;
        return;
    L5:
        w83.a r2 = this.b.a(UriProtector.parse(r9.b.e()));
        if (r2 != null) goto L8;
    L10:
        dm.a.b r4 = dm.a.a("LigoViewManager");
        StringBuilder r5 = new StringBuilder("id: ");
        r5.append(r8.getId());
        r5.append(" unload compose error compose: ");
        if (r2 == null) goto L13;
        boolean r3 = true;
    L14:
        r5.append(r3);
        r5.append(" isCompose: ");
        r5.append(r2 instanceof h);
        r4.b(r5.toString(), null);
    L15:
        a.a(r8);
        LifecycleEventObserver r10 = r9.c;
        if (r10 == null) goto L18;
        this.f.getLifecycle().removeObserver(r10);
    L18:
        dm.a.a("LigoViewManager").i("[unload] parent find index: " + r1);
        if (((Boolean) this.e.getValue()).booleanValue() == true) goto L26;
        r7.removeViewAt(r1);
        return;
    L26:
        r7.removeView(r8);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L13:
        r3 = false;
        goto L14
    L8:
        if ((r2 instanceof h) == false) goto L10;
        ((h) r2).c(r8);
        dm.a.a("LigoViewManager").i("id: " + r8.getId() + " unload compose success");
        goto L15
    }

    public final void o(ViewGroup r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        HashMap<String, ll.c> r0 = this.a.get(r5);
        if (r0 == null) goto L24;
        Map r1 = MapsKt.toMap(r0);
        if (r1 == null) goto L34;
        Iterator r2 = r1.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L35;
        ll.c r3 = (ll.c) ((Map.Entry) r2.next()).getValue();
        if (r3.b.a() != DynamicType.LYNX.getValue()) goto L8;
        Integer r4 = r3.getIdentifier().a;
        if (r4 == null) goto L8;
        View r8 = r5.findViewById(r4.intValue());
        Object r9 = null;
        if (r8 == null) goto L16;
        Object r10 = r8.getTag(2131370717);
    L18:
        if ((r10 instanceof l) == false) goto L21;
        r9 = r10;
    L21:
        l r11 = (l) r9;
        if (r11 == null) goto L8;
        r11.updateScreenMetrics(r6, r7);
        goto L8
    L16:
        r10 = null;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    @Override // w83.i
    public final ll.b a(ViewGroup r16, ll.a r17, boolean r18, f r19) {
        Intrinsics.checkNotNullParameter(r16, "parent");
        Intrinsics.checkNotNullParameter(r17, "data");
        LigoMonitor r0 = h();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r17, "dynamicRegion");
        r0.a().a(r17);
        r0.c.b("livesdk_ligo_load_start", com.bytedance.android.shopping.ligo.monitor.b.a(r17));
        dm.a.a("LigoViewManager").a("load: parent: " + r16.hashCode() + " data: {name: " + r17.b() + " type=" + r17.a() + ", url=" + r17.e() + ", params=" + r17.c() + '}');
        HashMap<String, ll.c> r1 = this.a.get(r16);
        if (r1 == null) goto L41;
        String r2 = r17.b();
        String r12 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        ll.c r3 = r1.get(r2);
        if (r3 == null) goto L41;
        dm.a.a("LigoViewManager").a("cache: {" + r3.getIdentifier() + " data: {name: " + r3.b.b() + " type=" + r3.b.a() + ", url=" + r3.b.e() + ", params" + r3.b.c() + "}}");
        Integer r4 = r3.getIdentifier().a;
        if (r4 == null) goto L41;
        View r5 = r16.findViewById(r4.intValue());
        if (r5 == null) goto L41;
        dm.a.a("LigoViewManager").a("parent has view");
        if (Intrinsics.areEqual(r17, r3.b) == false) goto L18;
        h().c(r17);
        return r3.getIdentifier();
    L18:
        dm.a.a("LigoViewManager").a("data equal not model");
        if (r19 == null) goto L22;
        r19.b(r3.b.e(), r3.b.a());
    L22:
        if (r17.a() == r3.b.a()) goto L30;
        int r6 = r16.indexOfChild(r5);
        dm.a.a("LigoViewManager").i("parent find index: " + r6);
        r16.removeViewAt(r6);
        Pair<Object, ll.b> r7 = i(r16, r6, r17, r18, r19);
        if (r7 == null) goto L26;
        e(r16, r7.getFirst(), (ll.b) r7.getSecond(), r17);
        dm.a.a("LigoViewManager").i("create new view id: " + ((ll.b) r7.getSecond()));
        return (ll.b) r7.getSecond();
    L26:
        return new ll.b(-1, null);
    L30:
        if (n(r5, r17) == false) goto L40;
        HashMap<String, ll.c> r8 = this.a.get(r16);
        if (r8 != null) goto L34;
        r8 = new HashMap();
    L34:
        String r9 = r17.b();
        if (r9 == null) goto L38;
        r12 = r9;
    L38:
        r8.put(r12, ll.c.a(r3, r17));
        this.a.put(r16, r8);
        dm.a.a("LigoViewManager").a("update cache success");
    L40:
        return r3.getIdentifier();
    L41:
        dm.a.a("LigoViewManager").a("begin init view");
        Pair<Object, ll.b> r10 = i(r16, -1, r17, r18, r19);
        if (r10 == null) goto L44;
        e(r16, r10.getFirst(), (ll.b) r10.getSecond(), r17);
        dm.a.a("LigoViewManager").a("init view " + ((ll.b) r10.getSecond()));
        return (ll.b) r10.getSecond();
    L44:
        return new ll.b(-1, null);
    }

    public final void e(ViewGroup r6, Object r7, ll.b r8, ll.a r9) {
        b r1 = null;
        if ((r7 instanceof View) == false) goto L16;
        View r10 = (View) r7;
        if (r10.getId() != (-1)) goto L7;
        int r0 = ViewCompat.generateViewId();
        r10.setId(r0);
        r8.a = Integer.valueOf(r0);
        dm.a.a("LigoViewManager").a("generate view id: " + r10.getId());
    L7:
        Integer r11 = Integer.valueOf(r10.getId());
        Object r12 = r10.getTag(2131370717);
        if ((r12 instanceof l) == true) goto L10;
        r12 = null;
    L10:
        l r13 = (l) r12;
        if (r13 == null) goto L13;
        b r2 = new b(r13);
        this.f.getLifecycle().addObserver(r2);
        Unit r14 = Unit.INSTANCE;
    L14:
        String r15 = null;
        r1 = r2;
    L19:
        HashMap<String, ll.c> r3 = this.a.get(r6);
        if (r3 != null) goto L22;
        r3 = new HashMap();
    L22:
        String r4 = r9.b();
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        r3.put(r4, new ll.c(new ll.b(r11, r15), r9, r1));
        this.a.put(r6, r3);
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L31;
        cl.d r16 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r16 == null) goto L32;
        r16.e();
        return;
    L32:
        return;
    L31:
        return;
    L13:
        r2 = null;
        goto L14
    L16:
        if ((r7 instanceof Fragment) == false) goto L18;
        r15 = ((Fragment) r7).getTag();
        r11 = null;
        goto L19
    L18:
        r15 = null;
        r11 = null;
        goto L19
    }

    @Override // w83.i
    public final ll.b c(ViewGroup r17, ll.a r18, String r19, boolean r20, f r21) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        Intrinsics.checkNotNullParameter(r18, "data");
        LigoMonitor r0 = h();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r18, "dynamicRegion");
        r0.a().a(r18);
        r0.c.b("livesdk_ligo_load_start", com.bytedance.android.shopping.ligo.monitor.b.a(r18));
        HashMap<String, ll.c> r1 = this.a.get(r17);
        String r3 = "";
        if (r1 == null) goto L42;
        String r4 = r18.b();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        ll.c r2 = r1.get(r4);
        if (r2 == null) goto L42;
        View r5 = g(r17, r2);
        if (r5 != null) goto L13;
    L108:
        if (r2 != null) goto L116;
        Pair<Object, ll.b> r6 = i(r17, -1, r18, r20, r21);
        if (r6 == null) goto L112;
        e(r17, r6.getFirst(), (ll.b) r6.getSecond(), r18);
        dm.a.a("LigoViewManager").a("init view " + ((ll.b) r6.getSecond()));
        j(r17, r19);
        return (ll.b) r6.getSecond();
    L112:
        return new ll.b(-1, null);
    L116:
        return new ll.b(-1, null);
    L13:
        if (Intrinsics.areEqual(r18, r2.b) == false) goto L16;
        h().c(r18);
        return r2.getIdentifier();
    L16:
        if (r21 == null) goto L19;
        r21.b(r2.b.e(), r2.b.a());
    L19:
        if (r18.a() == r2.b.a()) goto L31;
        int r7 = r17.indexOfChild(r5);
        if (r7 == (-1)) goto L23;
        r17.removeViewAt(r7);
        Pair<Object, ll.b> r8 = i(r17, r7, r18, r20, r21);
        if (r8 == null) goto L27;
        e(r17, r8.getFirst(), (ll.b) r8.getSecond(), r18);
        j(r17, r19);
        return (ll.b) r8.getSecond();
    L27:
        return new ll.b(-1, null);
    L23:
        return new ll.b(-1, null);
    L31:
        if (n(r5, r18) == false) goto L41;
        HashMap<String, ll.c> r9 = this.a.get(r17);
        if (r9 != null) goto L35;
        r9 = new HashMap();
    L35:
        String r10 = r18.b();
        if (r10 == null) goto L39;
        r3 = r10;
    L39:
        r9.put(r3, ll.c.a(r2, r18));
        this.a.put(r17, r9);
        dm.a.a("LigoViewManager").a("update cache success");
    L41:
        return r2.getIdentifier();
    L42:
        Function0<x83.a> r11 = this.j;
        if (r11 == null) goto L107;
        x83.a r12 = (x83.a) r11.invoke();
        if (r12 == null) goto L107;
        List<x83.b> r13 = r12.b(r19);
        if (r13 == null) goto L107;
        List r14 = CollectionsKt.sortedWith(r13, new d());
        if (r14 == null) goto L107;
        h().a().a(r18);
        List r15 = r14;
        Iterator r16 = r15.iterator();
    L52:
        if (r16.hasNext() == false) goto L59;
        View r110 = ((x83.b) r16.next()).a;
        ViewParent r111 = r110.getParent();
        if ((r111 instanceof ViewGroup) == true) goto L56;
        r111 = null;
    L56:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L52;
        r112.removeView(r110);
        goto L52
    L59:
        HashMap r22 = new HashMap();
        Iterator r23 = r15.iterator();
    L61:
        if (r23.hasNext() == false) goto L63;
        x83.b r113 = (x83.b) r23.next();
        r17.addView(r113.a);
        r22.put(r113.c.getKey(), r113.c.getValue());
        goto L61
    L63:
        this.a.put(r17, (HashMap<String, ll.c>) r22);
        HashMap<String, ll.c> r24 = this.a.get(r17);
        if (r24 == null) goto L106;
        String r25 = r18.b();
        if (r25 != null) goto L68;
        r25 = "";
    L68:
        ll.c r26 = r24.get(r25);
        if (r26 == null) goto L106;
        View r27 = g(r17, r26);
        if (r27 != null) goto L76;
        return new ll.b(-1, null);
    L76:
        if (Intrinsics.areEqual(r18, r26.b) == false) goto L79;
        h().c(r18);
        return r26.getIdentifier();
    L79:
        if (r21 == null) goto L82;
        r21.b(r26.b.e(), r26.b.a());
    L82:
        if (r18.a() == r26.b.a()) goto L94;
        int r28 = r17.indexOfChild(r27);
        if (r28 == (-1)) goto L86;
        r17.removeViewAt(r28);
        Pair<Object, ll.b> r29 = i(r17, r28, r18, r20, r21);
        if (r29 == null) goto L90;
        e(r17, r29.getFirst(), (ll.b) r29.getSecond(), r18);
        j(r17, r19);
        return (ll.b) r29.getSecond();
    L90:
        return new ll.b(-1, null);
    L86:
        return new ll.b(-1, null);
    L94:
        if (n(r27, r18) == false) goto L104;
        HashMap<String, ll.c> r30 = this.a.get(r17);
        if (r30 != null) goto L98;
        r30 = new HashMap();
    L98:
        String r31 = r18.b();
        if (r31 == null) goto L102;
        r3 = r31;
    L102:
        r30.put(r3, ll.c.a(r26, r18));
        this.a.put(r17, r30);
        dm.a.a("LigoViewManager").a("update cache success");
    L104:
        return r26.getIdentifier();
    L106:
        return new ll.b(-1, null);
    L107:
        r2 = null;
        goto L108
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<Object, ll.b> i(ViewGroup r28, int r29, ll.a r30, boolean r31, f r32) {
        h().a().a(r30);
        int r5 = r30.a();
        boolean r12 = true;
        if (r5 != DynamicType.LYNX.getValue()) goto L66;
        String r6 = r30.e();
        if (r6 != null) goto L7;
    L63:
        h().b(r30, "10001", "template_url is null");
        return null;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L63;
        LinkedHashMap r8 = new LinkedHashMap();
        Map<String, Object> r9 = this.g;
        if (r9 == null) goto L18;
        r8.putAll(r9);
    L18:
        Function0<Map<String, Object>> r10 = this.i;
        if (r10 == null) goto L23;
        Map r11 = (Map) r10.invoke();
        if (r11 == null) goto L23;
        r8.putAll(r11);
    L23:
        String r13 = r30.c();
        if (r13 == null) goto L26;
        r8.put("dynamic_region_params", r13);
    L26:
        String r14 = r30.e();
        if (r14 != null) goto L29;
    L37:
        Unit r15 = Unit.INSTANCE;
        Map r16 = MapsKt.mapOf(TuplesKt.to("ecom_dynamic_params", r8));
        UrlBuilderV2 r17 = new UrlBuilderV2(r30.e());
        String r18 = UUID.randomUUID().toString();
        HashMap r19 = j.a;
        j.h(r18, new JSONObject(r16));
        r17.addOrReplaceParam("mega_object_id", r18);
        String r20 = r17.build();
        l r4 = ECLiveHybridUtil.b(r28.getContext(), r20, r16, null, new c(this, r30, r20, r32), null, null, false, null, null, false, 4072);
        if (r4 == null) goto L58;
        r4.updateBusinessGlobalProps(r16);
        dm.a.a("LigoViewManager").i("create annie component success");
        View r21 = r4.getHybridView();
        if (r21 == null) goto L57;
        if (r31 == true) goto L43;
    L45:
        r12 = false;
    L46:
        if (r12 == false) goto L48;
        LigoViewManager r22 = this;
    L49:
        if (r22 == null) goto L52;
        ViewGroup.LayoutParams r23 = r28.getLayoutParams();
        if (r23 == null) goto L52;
    L53:
        r28.addView(r21, r29, r23);
        if (r21.getId() != (-1)) goto L56;
        r21.setId(ViewCompat.generateViewId());
    L56:
        r21.setTag(2131370717, r4);
        dm.a.a("LigoViewManager").i("create annie card success");
    L52:
        r23 = new ViewGroup.LayoutParams(-2, -2);
        goto L53
    L48:
        r22 = null;
        goto L49
    L43:
        if (f(r28) == false) goto L45;
    L57:
        View r1 = r4.getHybridView();
    L59:
        if (r1 != null) goto L61;
        h().b(r30, "10003", "lynx component create failed.");
    L61:
        if (r1 == null) goto L152;
        h().c(r30);
        return new Pair(r1, new ll.b(Integer.valueOf(r1.getId()), null));
    L152:
        return null;
    L58:
        r1 = null;
        goto L59
    L29:
        if (r14.length() <= 0) goto L31;
        boolean r24 = true;
    L32:
        if (r24 == true) goto L35;
        r14 = null;
    L35:
        if (r14 == null) goto L37;
        com.bytedance.android.shopping.ligo.monitor.c r25 = h().a();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r30, "dynamicRegion");
        r8.put("dynamic_region_perf_params", (Map) ((LinkedHashMap) r25.a).get(r30.e()));
        goto L37
    L31:
        r24 = false;
        goto L32
    L9:
        r7 = false;
        goto L10
    L66:
        if (r5 != DynamicType.NATIVE.getValue()) goto L148;
        String r26 = r30.e();
        if (r26 != null) goto L70;
    L144:
        if (r32 == null) goto L146;
        r32.a("template_url is null");
    L146:
        h().b(r30, "10001", "template_url is null");
        return null;
    L70:
        if (r26.length() <= 0) goto L72;
        boolean r27 = true;
    L73:
        if (r27 == true) goto L76;
        r26 = null;
    L76:
        if (r26 == null) goto L144;
        w83.a r33 = this.b.a(UriProtector.parse(r30.e()));
        if (r33 != null) goto L84;
        if (r32 == null) goto L82;
        r32.a("component factory is null");
    L82:
        h().b(r30, "10002", "unregistered component.");
        return null;
    L84:
        dm.a.a("LigoViewManager").i("create native component success");
        if ((r33 instanceof h) == false) goto L112;
        w83.d<?> r34 = this.h;
        if (r34 == null) goto L89;
        w83.b r35 = r34.a();
    L90:
        View r36 = ((h) r33).b(r28, r30, r35);
        if (r36 != null) goto L94;
        h().b(r30, "10003", "native component create failed.");
        return null;
    L94:
        if (r31 == true) goto L96;
    L98:
        r12 = false;
    L99:
        if (r12 == false) goto L101;
        LigoViewManager r37 = this;
    L102:
        if (r37 == null) goto L105;
        ViewGroup.LayoutParams r38 = r28.getLayoutParams();
        if (r38 == null) goto L105;
    L106:
        r28.addView(r36, r29, r38);
        dm.a.a("LigoViewManager").i("create native view success");
        h().a().b(r30);
        if (r32 == null) goto L109;
        r32.onLoadSuccess();
    L109:
        h().c(r30);
        return new Pair(r36, new ll.b(Integer.valueOf(r36.getId()), null));
    L105:
        r38 = new ViewGroup.LayoutParams(-2, -2);
        goto L106
    L101:
        r37 = null;
        goto L102
    L96:
        if (f(r28) == false) goto L98;
    L89:
        r35 = null;
        goto L90
    L112:
        if ((r33 instanceof e) == false) goto L141;
        w83.d<?> r2 = this.h;
        if (r2 == null) goto L116;
        r2.a();
    L116:
        Fragment r3 = ((e) r33).a();
        LifecycleOwner r39 = this.f;
        if ((r39 instanceof Fragment) == true) goto L119;
        r39 = null;
    L119:
        Fragment r40 = (Fragment) r39;
        if (r40 == null) goto L122;
        FragmentManager r41 = r40.getChildFragmentManager();
    L123:
        if (r3 == null) goto L130;
        if (r41 == null) goto L130;
        String r42 = "ligo_fragment_" + r3.hashCode();
        FragmentTransaction r43 = r41.beginTransaction().setTransition(0).setTransitionStyle(0).setCustomAnimations(0, 0, 0, 0);
        int r44 = r28.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r43, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r42, r44) == true) goto L129;
        r43 = r43.add(r44, r3, r42);
    L129:
        r43.commitNowAllowingStateLoss();
    L130:
        dm.a.a("LigoViewManager").i("create fragment success");
        if (r3 == null) goto L137;
        h().a().b(r30);
        if (r32 == null) goto L135;
        r32.onLoadSuccess();
    L135:
        h().c(r30);
        return new Pair(r3, new ll.b(null, r3.getTag()));
    L137:
        if (r32 == null) goto L139;
        r32.a("fragment create failed.");
    L139:
        h().b(r30, "10003", "fragment create failed.");
        return null;
    L122:
        r41 = null;
        goto L123
    L141:
        if (r32 == null) goto L143;
        r32.a("unknown native component factory");
    L143:
        h().b(r30, "10006", "unknown native component factory");
        return null;
    L72:
        r27 = false;
        goto L73
    L148:
        if (r32 == null) goto L150;
        r32.a("unknown dynamicType");
    L150:
        h().b(r30, "10004", "unknown dynamic_type " + r30.a());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LigoViewManager(LifecycleOwner r2, Map<String, ? extends Object> r3, w83.d<?> r4, Function0<? extends Map<String, ? extends Object>> r5, Function0<? extends x83.a> r6, com.bytedance.android.shopping.ligo.monitor.a r7) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "eventTracker");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.a = new HashMap();
        this.b = (LigoComponentRegistry) LigoComponentRegistry.b.getValue();
        this.c = LazyKt.lazy(new LigoViewManager$monitor$2(this));
        this.d = LazyKt.lazy(LigoViewManager$isLocalTestChannel$2.INSTANCE);
        this.e = LazyKt.lazy(LigoViewManager$fixLigoCrash$2.INSTANCE);
        r2.getLifecycle().addObserver(this);
    }
}
