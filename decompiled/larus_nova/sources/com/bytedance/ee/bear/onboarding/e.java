package com.bytedance.ee.bear.onboarding;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.onboarding.export.OnBoardingColorStyle;
import com.bytedance.ee.bear.onboarding.synchronization.OnBoardingSynchronizer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f236138e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f236139f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f236140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, OnBoardingColorStyle> f236141h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Set<String> f236142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static e f236143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f236144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f236145l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f236146m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f236148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnBoardingSynchronizer f236149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f236150d;

    public class a extends com.bytedance.ee.bear.contract.c {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.c
        public final void b(AccountService$Account r100) {
            if (r100 == null) goto L5;
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).c(r100.token, r100.uid);
            return;
        }
    }

    public interface b {
        void onInit();
    }

    static {
        f236141h = new HashMap();
        f236144k = false;
        f236145l = new CopyOnWriteArrayList();
        f236146m = new a();
    }

    public static boolean d() {
        if (f236143j != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        tt5.a.d("OnBoardingManager", "OnBoardingManager Instance hasn't been created.");
    L8:
        return r100;
    L5:
        r100 = false;
        goto L6
    }

    public static Map<String, Boolean> b() {
        if (d() == true) goto L5;
        OnBoardingSynchronizer r100 = f236143j.f236149c;
        if (r100.f236181h == false) goto L14;
        return r100.f236174a;
    L14:
        return new HashMap();
    L5:
        if (f236138e == true) goto L9;
        tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
        return new HashMap();
    L9:
        throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
    }

    public e(String r110) {
        this.f236147a = r110;
        f r111 = new f();
        this.f236148b = r111;
        OnBoardingSynchronizer r100 = new OnBoardingSynchronizer();
        this.f236149c = r100;
        this.f236150d = new h();
        boolean r101 = !TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e());
        ml5.b r102 = new ml5.b("debug_config");
        if (r101 == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        f236138e = r103;
        String r104 = "";
        if ((!TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e())) == false) goto L11;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r105 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r105, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("global_onboarding_key", "key");
        r104 = r105.getString("global_onboarding_key", "");
    L11:
        f236139f = r104;
        f236140g = OnBoardingSynchronizer.b();
        tt5.a.b("OnBoardingManager", "DebugMode: " + f236138e + ", DebugKey: " + f236139f);
        r111.f236159d = new com.bytedance.ee.bear.onboarding.a(this);
        r111.f236161f = new com.bytedance.ee.bear.onboarding.b(this);
        r111.f236160e = new c(this);
        r100.f236180g = new d();
        r100.d();
        if (f236142i != null) goto L16;
        f236142i = new HashSet(com.bytedance.ee.bear.appsetting.c.a.f206237a.e("disabled_onboardings", String.class, new ArrayList()));
    L16:
        if (f236144k == false) goto L19;
        r100.a();
        return;
    L19:
        return;
    L5:
        if (((Boolean) r102.a("global_onboarding_enable", Boolean.FALSE)).booleanValue() == false) goto L7;
        r103 = true;
        goto L8
    }

    public static void a(final com.bytedance.ee.bear.document.onboarding.b r100) {
        if (d() == false) goto L5;
        return;
    L5:
        e r101 = f236143j;
        if (r100 == null) goto L13;
        f r102 = r101.f236148b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "mission");
        j r103 = r102.f236157b;
        if ((r103 instanceof j) == true) goto L10;
    L12:
        CollectionsKt.removeAll(r102.f236156a, new OnBoardingMissionTaskManager$dismiss$1(r100));
        return;
    L10:
        if (Intrinsics.areEqual(r103.f236168b, r100) == false) goto L12;
        r102.a(r103, false);
        return;
    L13:
        r101.getClass();
        tt5.a.d("OnBoardingManager", "OnBoardingMission is null!");
    }

    public static boolean c(String r100) {
        if (f236138e == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(f236139f) == false) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.equals(f236139f, r100) == false) goto L9;
        goto L8
    }

    private void update(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        this.f236149c.update(r100);
        return;
    }

    private void update(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f236149c.update(r100);
    }

    public static void e(tk5.d r100, vk5.a r101) {
        if (d() == false) goto L5;
        return;
    L5:
        e r102 = f236143j;
        r102.getClass();
        if (r100 == null) goto L67;
        String r103 = r100.getId();
        Map<String, Boolean> r104 = b();
        boolean r105 = false;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.onboarding_follow_server") == false) goto L31;
        if (c(r103) == false) goto L13;
    L42:
        r105 = true;
    L44:
        if (r105 == false) goto L65;
        String r106 = r100.getBiz();
        if (r106 == null) goto L51;
        HashMap r107 = (HashMap) f236141h;
        if (r107.get(r106) == null) goto L51;
        OnBoardingColorStyle r108 = (OnBoardingColorStyle) r107.get(r106);
    L52:
        if (r108 != null) goto L54;
        r108 = OnBoardingColorStyle.Blue;
    L54:
        r101.f555505d = r108;
        r101.f555504c = r100;
        r101.f555507f = r102.f236150d;
        f r109 = r102.f236148b;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r100, "mission");
        Intrinsics.checkNotNullParameter(r101, "onBoardingUI");
        j r110 = new j(r100, new WeakReference(r101));
        k r111 = (k) ((LinkedList) r109.f236156a).peekFirst();
        if ((r111 instanceof i) == false) goto L63;
        String r112 = ((i) r111).f236166b;
        Object r113 = r110.f236168b;
        if ((r113 instanceof tk5.a) == false) goto L59;
        String r114 = ((tk5.a) r113).a();
    L61:
        if (Intrinsics.areEqual(r112, r114) == false) goto L63;
        ((LinkedList) r109.f236156a).removeFirst();
        ((LinkedList) r109.f236156a).addFirst(r110);
    L64:
        tt5.a.b("OnBoardingManager", "New task added, queue size: " + ((LinkedList) r109.f236156a).size());
        r109.b();
        return;
    L59:
        r114 = null;
    L63:
        ((LinkedList) r109.f236156a).add(r110);
    L51:
        r108 = OnBoardingColorStyle.Blue;
        goto L52
    L65:
        tt5.a.b("OnBoardingManager", "mission[ " + r103 + "] is in blacklist.");
        return;
    L13:
        if (r104.containsKey(r103) == false) goto L24;
        if (f236138e == true) goto L22;
        Set<String> r115 = f236142i;
        if (r115 == null) goto L22;
        if (r103 == null) goto L22;
        if (((HashSet) r115).contains(r103) == false) goto L22;
        r105 = true;
    L22:
        r105 = !r105;
        goto L44
    L24:
        if (f236140g == false) goto L44;
        if (TextUtils.isEmpty(f236139f) == true) goto L42;
        if (TextUtils.equals(f236139f, r103) == false) goto L44;
    L31:
        if (c(r103) == true) goto L42;
        if (f236138e == true) goto L40;
        Set<String> r116 = f236142i;
        if (r116 == null) goto L40;
        if (r103 == null) goto L40;
        if (((HashSet) r116).contains(r103) == false) goto L40;
        boolean r117 = true;
    L41:
        if (r117 == true) goto L44;
    L40:
        r117 = false;
        goto L41
    }
}
