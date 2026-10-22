package com.bytedance.ee.bear.onboarding.synchronization;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OnBoardingSynchronizer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f236173i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f236174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f236175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f236176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lazy<? extends com.bytedance.ee.bear.onboarding.synchronization.a> f236177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f236178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f236179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f236180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f236181h;

    public static final class a {
    }

    static {
        f236173i = OnBoardingSynchronizer.class.getSimpleName();
    }

    public static boolean b() {
        boolean r100 = !TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e());
        ml5.b r101 = new ml5.b("debug_config");
        if (r100 == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r101.a("global_onboarding_native_only_enable", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    public final void a() {
        if (this.f236181h == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.onboarding.synchronization.a r100 = c();
        if (r100 == null) goto L9;
        r100.a(new OnBoardingSynchronizer$fetchFromRemote$1(this), new OnBoardingSynchronizer$fetchFromRemote$2(this));
        return;
    }

    public final com.bytedance.ee.bear.onboarding.synchronization.a c() {
        Lazy<? extends com.bytedance.ee.bear.onboarding.synchronization.a> r100 = this.f236177d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public final void d() {
        this.f236177d = LazyKt.lazy(OnBoardingSynchronizer$init$1.INSTANCE);
        b r100 = new b();
        this.f236178e = r100;
        Map<String, Boolean> r101 = this.f236174a;
        Map<String, OnBoardingPrefData.OnBoardingItem> r102 = r100.a().getOnBoardingItemMap();
        HashMap r103 = new HashMap();
        Iterator<Map.Entry<String, OnBoardingPrefData.OnBoardingItem>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, OnBoardingPrefData.OnBoardingItem> r105 = r104.next();
        r103.put(r105.getKey(), Boolean.valueOf(r105.getValue().isDone()));
        goto L4
    L6:
        tt5.a.b("OnBoardingPrefDataManager", "Load OnBoardings from preference: " + r102);
        ((HashMap) r101).putAll(r103);
        tt5.a.b("OnBoardingManager", " onBoardingIdsCacheMap : " + this.f236174a);
        this.f236179f = b();
        tt5.a.b(f236173i, "In native only mode? " + this.f236179f);
        if (this.f236179f == false) goto L13;
        this.f236181h = true;
        Function0<Unit> r106 = this.f236180g;
        if (r106 == null) goto L14;
        r106.invoke();
        return;
    L14:
        return;
    }

    public final void i() {
        if ((!this.f236175b.isEmpty()) == false) goto L11;
        final String r100 = (String) ListProtector.get(this.f236175b, 0);
        if (this.f236179f == false) goto L7;
        tt5.a.b(f236173i, "In native mode，don't sync to remote.");
        return;
    L7:
        com.bytedance.ee.bear.onboarding.synchronization.a r101 = c();
        if (r101 == null) goto L13;
        r101.c(r100, new OnBoardingSynchronizer$syncDoneToRemote$1(r100, this), OnBoardingSynchronizer$syncDoneToRemote$2.INSTANCE);
        return;
    L13:
        return;
    }

    public final void j() {
        if ((!this.f236175b.isEmpty()) == false) goto L6;
        i();
        return;
    L6:
        if ((!this.f236176c.isEmpty()) == true) goto L8;
        return;
    L8:
        if ((!((ArrayList) this.f236176c).isEmpty()) == false) goto L18;
        final String r100 = (String) ListProtector.get(this.f236176c, 0);
        if (this.f236179f == false) goto L12;
        tt5.a.b(f236173i, "In native mode，don't sync to remote.");
        return;
    L12:
        com.bytedance.ee.bear.onboarding.synchronization.a r101 = c();
        if (r101 == null) goto L20;
        r101.b(r100, new OnBoardingSynchronizer$syncUpdateToRemote$1(this, r100), OnBoardingSynchronizer$syncUpdateToRemote$2.INSTANCE);
        return;
    L20:
        return;
    }

    public OnBoardingSynchronizer() {
        this.f236174a = new HashMap();
        this.f236175b = new ArrayList();
        this.f236176c = new ArrayList();
    }

    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        boolean r101 = !this.f236179f;
        if (this.f236181h == false) goto L8;
        Boolean r102 = (Boolean) ((HashMap) this.f236174a).get(r100);
        if (r102 != null) goto L7;
        return r101;
    L7:
        return r102.booleanValue();
    L8:
        tt5.a.d(f236173i, "OnBoardingSynchronizer hasn't initialized.");
        return true;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (e(r100) == true) goto L6;
        Map<String, Boolean> r101 = this.f236174a;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, Boolean.TRUE);
        ((ArrayList) this.f236175b).add(r100);
        h(r100, true);
        i();
        return;
    }

    public final void g(HashMap<String, Boolean> r100) {
        tt5.a.b("OnBoardingManager", "setPatchStatusToPreference: " + r100);
        b r101 = this.f236178e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L10;
        tt5.a.h("OnBoardingPrefDataManager", "setPatchStatus to preference: " + r100);
        OnBoardingPrefData r102 = r101.a();
        r102.putAll(r100);
        r101.b(r102);
        return;
    }

    public final void update(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "idList");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        String r102 = (String) r101.next();
        if (e(r102) == true) goto L4;
        b r103 = this.f236178e;
        if (r103 == null) goto L10;
        boolean r104 = r103.c(r102);
    L11:
        Boolean r105 = Boolean.valueOf(r104);
        ((HashMap) this.f236174a).put(r102, r105);
        if (r104 == true) goto L13;
        ((ArrayList) this.f236176c).add(r102);
        goto L4
    L13:
        ((ArrayList) this.f236175b).add(r102);
        goto L4
    L10:
        r104 = false;
        goto L11
    L15:
        j();
    }

    public final void update(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (e(r100) == false) goto L5;
        return;
    L5:
        b r101 = this.f236178e;
        if (r101 == null) goto L8;
        boolean r102 = r101.c(r100);
    L9:
        Boolean r103 = Boolean.valueOf(r102);
        ((HashMap) this.f236174a).put(r100, r103);
        if (r102 == false) goto L12;
        ((ArrayList) this.f236175b).add(r100);
    L13:
        j();
        return;
    L12:
        ((ArrayList) this.f236176c).add(r100);
        goto L13
    L8:
        r102 = false;
        goto L9
    }

    public final void h(String r100, boolean r101) {
        tt5.a.b("OnBoardingManager", "setStatusToPreference[" + r100 + "]: " + r101);
        b r102 = this.f236178e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        tt5.a.h("OnBoardingPrefDataManager", "setStatus to preference: " + r100 + ": " + r101);
        OnBoardingPrefData r103 = r102.a();
        r103.update(r100, r101);
        r102.b(r103);
        return;
    }
}
