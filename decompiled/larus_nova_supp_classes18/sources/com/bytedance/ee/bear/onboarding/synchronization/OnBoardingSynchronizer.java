package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OnBoardingSynchronizer {
    public static final String i = null;
    public final Map<String, Boolean> a;
    public final List<String> b;
    public final List<String> c;
    public Lazy<? extends com.bytedance.ee.bear.onboarding.synchronization.a> d;
    public b e;
    public boolean f;
    public Function0<Unit> g;
    public boolean h;

    public static final class a {
    }

    static {
        i = OnBoardingSynchronizer.class.getSimpleName();
    }

    public static boolean b() {
        boolean r0 = !TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e());
        ml5.b r2 = new ml5.b("debug_config");
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r2.a("global_onboarding_native_only_enable", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    public final void a() {
        if (this.h == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.onboarding.synchronization.a r0 = c();
        if (r0 == null) goto L9;
        r0.a(new OnBoardingSynchronizer$fetchFromRemote$1(this), new OnBoardingSynchronizer$fetchFromRemote$2(this));
        return;
    }

    public final com.bytedance.ee.bear.onboarding.synchronization.a c() {
        Lazy<? extends com.bytedance.ee.bear.onboarding.synchronization.a> r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.onboarding.synchronization.a) r0.getValue();
    }

    public final void d() {
        this.d = LazyKt.lazy(OnBoardingSynchronizer$init$1.INSTANCE);
        b r0 = new b();
        this.e = r0;
        Map<String, Boolean> r1 = this.a;
        Map<String, OnBoardingPrefData.OnBoardingItem> r2 = r0.a().getOnBoardingItemMap();
        HashMap r3 = new HashMap();
        Iterator<Map.Entry<String, OnBoardingPrefData.OnBoardingItem>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, OnBoardingPrefData.OnBoardingItem> r5 = r4.next();
        r3.put(r5.getKey(), Boolean.valueOf(r5.getValue().isDone()));
        goto L4
    L6:
        tt5.a.b("OnBoardingPrefDataManager", "Load OnBoardings from preference: " + r2);
        ((HashMap) r1).putAll(r3);
        tt5.a.b("OnBoardingManager", " onBoardingIdsCacheMap : " + this.a);
        this.f = b();
        tt5.a.b(i, "In native only mode? " + this.f);
        if (this.f == false) goto L13;
        this.h = true;
        Function0<Unit> r6 = this.g;
        if (r6 == null) goto L14;
        r6.invoke();
        return;
    L14:
        return;
    }

    public final void i() {
        if ((!this.b.isEmpty()) == false) goto L11;
        final String r0 = (String) ListProtector.get(this.b, 0);
        if (this.f == false) goto L7;
        tt5.a.b(i, "In native mode，don't sync to remote.");
        return;
    L7:
        com.bytedance.ee.bear.onboarding.synchronization.a r1 = c();
        if (r1 == null) goto L13;
        r1.c(r0, new OnBoardingSynchronizer$syncDoneToRemote$1(r0, this), OnBoardingSynchronizer$syncDoneToRemote$2.INSTANCE);
        return;
    L13:
        return;
    }

    public final void j() {
        if ((!this.b.isEmpty()) == false) goto L6;
        i();
        return;
    L6:
        if ((!this.c.isEmpty()) == true) goto L8;
        return;
    L8:
        if ((!((ArrayList) this.c).isEmpty()) == false) goto L18;
        final String r0 = (String) ListProtector.get(this.c, 0);
        if (this.f == false) goto L12;
        tt5.a.b(i, "In native mode，don't sync to remote.");
        return;
    L12:
        com.bytedance.ee.bear.onboarding.synchronization.a r1 = c();
        if (r1 == null) goto L20;
        r1.b(r0, new OnBoardingSynchronizer$syncUpdateToRemote$1(this, r0), OnBoardingSynchronizer$syncUpdateToRemote$2.INSTANCE);
        return;
    L20:
        return;
    }

    public OnBoardingSynchronizer() {
        this.a = new HashMap();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final boolean e(String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        boolean r0 = !this.f;
        if (this.h == false) goto L8;
        Boolean r5 = (Boolean) ((HashMap) this.a).get(r4);
        if (r5 != null) goto L7;
        return r0;
    L7:
        return r5.booleanValue();
    L8:
        tt5.a.d(i, "OnBoardingSynchronizer hasn't initialized.");
        return true;
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_ID);
        if (e(r3) == true) goto L6;
        Map<String, Boolean> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Boolean.TRUE);
        ((ArrayList) this.b).add(r3);
        h(r3, true);
        i();
        return;
    }

    public final void g(HashMap<String, Boolean> r4) {
        tt5.a.b("OnBoardingManager", "setPatchStatusToPreference: " + r4);
        b r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L10;
        tt5.a.h("OnBoardingPrefDataManager", "setPatchStatus to preference: " + r4);
        OnBoardingPrefData r1 = r0.a();
        r1.putAll(r4);
        r0.b(r1);
        return;
    }

    public final void update(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "idList");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r0 = (String) r6.next();
        if (e(r0) == true) goto L4;
        b r1 = this.e;
        if (r1 == null) goto L10;
        boolean r2 = r1.c(r0);
    L11:
        Boolean r3 = Boolean.valueOf(r2);
        ((HashMap) this.a).put(r0, r3);
        if (r2 == true) goto L13;
        ((ArrayList) this.c).add(r0);
        goto L4
    L13:
        ((ArrayList) this.b).add(r0);
        goto L4
    L10:
        r2 = false;
        goto L11
    L15:
        j();
    }

    public final void update(String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        if (e(r4) == false) goto L5;
        return;
    L5:
        b r0 = this.e;
        if (r0 == null) goto L8;
        boolean r1 = r0.c(r4);
    L9:
        Boolean r2 = Boolean.valueOf(r1);
        ((HashMap) this.a).put(r4, r2);
        if (r1 == false) goto L12;
        ((ArrayList) this.b).add(r4);
    L13:
        j();
        return;
    L12:
        ((ArrayList) this.c).add(r4);
        goto L13
    L8:
        r1 = false;
        goto L9
    }

    public final void h(String r4, boolean r5) {
        tt5.a.b("OnBoardingManager", "setStatusToPreference[" + r4 + "]: " + r5);
        b r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        tt5.a.h("OnBoardingPrefDataManager", "setStatus to preference: " + r4 + ": " + r5);
        OnBoardingPrefData r1 = r0.a();
        r1.update(r4, r5);
        r0.b(r1);
        return;
    }
}
