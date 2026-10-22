package com.bytedance.android.shopping.mall.feed.help;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.ui.ECMediaWrapperForLynx;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallShelterHelp implements q, ik.c {
    public static final int l = 0;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public final Set<Integer> e;
    public final CopyOnWriteArraySet<k> f;
    public final CopyOnWriteArraySet<l> g;
    public final Lazy h;
    public final Lazy i;
    public final MallShelterHelp$fragmentLifeCycleCallbacks$1 j;
    public final a.C0084a k;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.MallShelterHelp$a$a, reason: collision with other inner class name */
        public static final class C0084a {
            public final FragmentActivity a;
            public final com.bytedance.android.shopping.api.mall.d b;
            public final String c;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0084a) == false) goto L12;
                C0084a r4 = (C0084a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public final int hashCode() {
                FragmentActivity r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                com.bytedance.android.shopping.api.mall.d r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.c;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "ShelterContext(activity=" + this.a + ", popupHelp=" + this.b + ", sceneId=" + this.c + ")";
            }

            public final FragmentActivity getActivity() {
                return this.a;
            }

            public C0084a(FragmentActivity r2, ECMallFragment r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, "activity");
                Intrinsics.checkNotNullParameter(r3, "popupHelp");
                Intrinsics.checkNotNullParameter(r4, "sceneId");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }
    }

    public final void C() {
    }

    static {
        int r0 = com.bytedance.android.ec.hybrid.tools.f.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L81
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("mall_delay_on_pause_method");     // Catch: Throwable -> L54
        if (r5 != null) goto L9;
    L51:
        Object r6 = null;
    L52:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L54
    L56:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L81
        if (r8 == null) goto L60;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L81
    L60:
        if (Result.isFailure-impl(r7) == false) goto L63;
        r7 = null;
    L63:
        if ((r7 instanceof Integer) == true) goto L65;
        r7 = null;
    L65:
        Integer r9 = (Integer) r7;     // Catch: Throwable -> L81
        if (r9 == null) goto L68;
        r1 = r9;
    L89:
        l = ((Number) r1).intValue();
        return;
    L68:
        IHybridHostService r10 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L81
        if (r10 == null) goto L71;
        Object r11 = r10.getHostABValue("mall_delay_on_pause_method", r1);     // Catch: Throwable -> L81
    L72:
        if (r11 == null) goto L89;
        if ((r11 instanceof Integer) == false) goto L77;
        r4 = r11;
    L77:
        Integer r12 = (Integer) r4;     // Catch: Throwable -> L81
        if (r12 == null) goto L89;
        r1 = r12;
        goto L89
    L71:
        r11 = null;
        goto L72
    L9:
        if ((r5 instanceof Integer) == true) goto L11;
        Object r13 = null;
    L12:
        r6 = (Integer) r13;     // Catch: Throwable -> L54
        if (r6 != null) goto L52;
        if ((r5 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r14 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L54
        if ((r14 instanceof Integer) == true) goto L22;
        r14 = null;
    L22:
        r6 = (Integer) r14;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r15 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L54
        if ((r15 instanceof Integer) == true) goto L28;
        r15 = null;
    L28:
        r6 = (Integer) r15;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r6 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r16 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L54
        if ((r16 instanceof Integer) == true) goto L37;
        r16 = null;
    L37:
        r6 = (Integer) r16;     // Catch: Throwable -> L54
    L39:
        if ((r5 instanceof JSONObject) == false) goto L41;
    L91:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r17 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r17 instanceof Integer) == true) goto L45;
        r17 = null;
    L45:
        Object r18 = Result.constructor-impl((Integer) r17);     // Catch: Throwable -> L47
    L49:
        r6 = r18;
        if (Result.isFailure-impl(r6) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L54
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r5 instanceof JSONArray) == false) goto L51;
    L11:
        r13 = r5;
    L54:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L81
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L86;
        EnsureManager.ensureNotReachHere(r23);
    L86:
        if (Result.isFailure-impl(r22) == true) goto L89;
        r1 = r22;
        goto L89
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final int b() {
        if (this.c == true) goto L7;
        return 0;
    L7:
        return this.b;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final int i() {
        if (this.e.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.a;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ability.f
    public final boolean f() {
        return this.d;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.android.shopping.mall.feed.help.MallShelterHelp$fragmentLifeCycleCallbacks$1] */
    public MallShelterHelp(a.C0084a r5) {
        Intrinsics.checkNotNullParameter(r5, "shelterContext");
        this.k = r5;
        this.e = new LinkedHashSet();
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
        Lazy r0 = LazyKt.lazy(new MallShelterHelp$popupShowSubscriber$2(this));
        this.h = r0;
        Lazy r1 = LazyKt.lazy(new MallShelterHelp$popupDismissSubscriber$2(this));
        this.i = r1;
        ECEventCenter.e("ec.on_popup_show", (com.bytedance.android.ec.hybrid.card.event.e) r0.getValue(), r5.c);
        ECEventCenter.e("ec.on_popup_dismiss", (com.bytedance.android.ec.hybrid.card.event.e) r1.getValue(), r5.c);
        if (l != 1) goto L5;
        Map r2 = ECMediaWrapperForLynx.f;
        String r6 = r5.c;
        Intrinsics.checkNotNullParameter(r6, "containerId");
        Intrinsics.checkNotNullParameter(this, "listener");
        ECMediaWrapperForLynx.f.put(r6, this);
    L5:
        this.j = new MallShelterHelp$fragmentLifeCycleCallbacks$1(this);
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final void a(ShelterEventHelp$halfPageListener$2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.remove(r2);
    }

    @Override // com.bytedance.android.shopping.mall.feed.ability.f
    public final void c(com.bytedance.android.shopping.mall.feed.ability.e r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.d = r3.c;
        if (r3.b == true) goto L5;
        return;
    L5:
        this.a++;
        this.k.getActivity().getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.j, false);
        Iterator<k> r4 = this.f.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().c();
        goto L7
    }

    public final void d(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.containsKey("delayOnPause") == false) goto L11;
        Object r4 = r3.get("delayOnPause");
        if ((r4 instanceof Boolean) == true) goto L8;
        r4 = null;
    L8:
        if (Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) == false) goto L12;
        this.d = true;
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final void e(l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.g.contains(r2) == false) goto L5;
        return;
    L5:
        this.g.add(r2);
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final void g(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.f.contains(r2) == false) goto L5;
        return;
    L5:
        this.f.add(r2);
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.q
    public final void h(ShelterEventHelp$popupListener$2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }
}
