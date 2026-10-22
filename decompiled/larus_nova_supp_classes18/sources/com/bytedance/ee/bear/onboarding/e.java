package com.bytedance.ee.bear.onboarding;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static boolean e = false;
    public static String f = "";
    public static boolean g;
    public static final Map<String, OnBoardingColorStyle> h = null;
    public static Set<String> i;
    public static e j;
    public static boolean k;
    public static final CopyOnWriteArrayList<b> l = null;
    public static final a m = null;
    public final String a;
    public final f b;
    public final OnBoardingSynchronizer c;
    public final h d;

    public class a extends com.bytedance.ee.bear.contract.c {
        public a() {
        }

        public final void b(AccountService.Account r3) {
            if (r3 == null) goto L5;
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).c(r3.token, r3.uid);
            return;
        }
    }

    public interface b {
        void onInit();
    }

    static {
        h = new HashMap();
        k = false;
        l = new CopyOnWriteArrayList();
        m = new a();
    }

    public static boolean d() {
        if (j != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        tt5.a.d("OnBoardingManager", "OnBoardingManager Instance hasn't been created.");
    L8:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public static Map<String, Boolean> b() {
        if (d() == true) goto L5;
        OnBoardingSynchronizer r0 = j.c;
        if (r0.h == false) goto L14;
        return r0.a;
    L14:
        return new HashMap();
    L5:
        if (e == true) goto L9;
        tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
        return new HashMap();
    L9:
        throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
    }

    public e(String r10) {
        this.a = r10;
        f r11 = new f();
        this.b = r11;
        OnBoardingSynchronizer r0 = new OnBoardingSynchronizer();
        this.c = r0;
        this.d = new h();
        boolean r1 = !TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e());
        ml5.b r6 = new ml5.b("debug_config");
        if (r1 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        e = r2;
        String r3 = "";
        if ((!TextUtils.equals("release", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e())) == false) goto L11;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r4 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r4, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("global_onboarding_key", "key");
        r3 = r4.getString("global_onboarding_key", "");
    L11:
        f = r3;
        g = OnBoardingSynchronizer.b();
        tt5.a.b("OnBoardingManager", "DebugMode: " + e + ", DebugKey: " + f);
        r11.d = new com.bytedance.ee.bear.onboarding.a(this);
        r11.f = new com.bytedance.ee.bear.onboarding.b(this);
        r11.e = new c(this);
        r0.g = new d();
        r0.d();
        if (i != null) goto L16;
        i = new HashSet(com.bytedance.ee.bear.appsetting.c.a.a.e("disabled_onboardings", String.class, new ArrayList()));
    L16:
        if (k == false) goto L19;
        r0.a();
        return;
    L19:
        return;
    L5:
        if (((Boolean) r6.a("global_onboarding_enable", Boolean.FALSE)).booleanValue() == false) goto L7;
        r2 = true;
        goto L8
    }

    public static void a(final com.bytedance.ee.bear.document.onboarding.b r3) {
        if (d() == false) goto L5;
        return;
    L5:
        e r0 = j;
        if (r3 == null) goto L13;
        f r1 = r0.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "mission");
        j r2 = r1.b;
        if ((r2 instanceof j) == true) goto L10;
    L12:
        CollectionsKt.removeAll(r1.a, new OnBoardingMissionTaskManager$dismiss$1(r3));
        return;
    L10:
        if (Intrinsics.areEqual(r2.b, r3) == false) goto L12;
        r1.a(r2, false);
        return;
    L13:
        r0.getClass();
        tt5.a.d("OnBoardingManager", "OnBoardingMission is null!");
    }

    public static boolean c(String r1) {
        if (e == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(f) == false) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.equals(f, r1) == false) goto L9;
        goto L8
    }

    private void update(List<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        this.c.update(r2);
        return;
    }

    private void update(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.c.update(r2);
    }

    public static void e(tk5.d r6, vk5.a r7) {
        if (d() == false) goto L5;
        return;
    L5:
        e r0 = j;
        r0.getClass();
        if (r6 == null) goto L67;
        String r1 = r6.getId();
        Map<String, Boolean> r2 = b();
        boolean r4 = false;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.onboarding_follow_server") == false) goto L31;
        if (c(r1) == false) goto L13;
    L42:
        r4 = true;
    L44:
        if (r4 == false) goto L65;
        String r3 = r6.getBiz();
        if (r3 == null) goto L51;
        HashMap r5 = (HashMap) h;
        if (r5.get(r3) == null) goto L51;
        OnBoardingColorStyle r8 = (OnBoardingColorStyle) r5.get(r3);
    L52:
        if (r8 != null) goto L54;
        r8 = OnBoardingColorStyle.Blue;
    L54:
        r7.d = r8;
        r7.c = r6;
        r7.f = r0.d;
        f r9 = r0.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "mission");
        Intrinsics.checkNotNullParameter(r7, "onBoardingUI");
        j r10 = new j(r6, new WeakReference(r7));
        k r11 = (k) ((LinkedList) r9.a).peekFirst();
        if ((r11 instanceof i) == false) goto L63;
        String r12 = ((i) r11).b;
        Object r13 = r10.b;
        if ((r13 instanceof tk5.a) == false) goto L59;
        String r14 = ((tk5.a) r13).a();
    L61:
        if (Intrinsics.areEqual(r12, r14) == false) goto L63;
        ((LinkedList) r9.a).removeFirst();
        ((LinkedList) r9.a).addFirst(r10);
    L64:
        tt5.a.b("OnBoardingManager", "New task added, queue size: " + ((LinkedList) r9.a).size());
        r9.b();
        return;
    L59:
        r14 = null;
    L63:
        ((LinkedList) r9.a).add(r10);
    L51:
        r8 = OnBoardingColorStyle.Blue;
        goto L52
    L65:
        tt5.a.b("OnBoardingManager", "mission[ " + r1 + "] is in blacklist.");
        return;
    L13:
        if (r2.containsKey(r1) == false) goto L24;
        if (e == true) goto L22;
        Set<String> r15 = i;
        if (r15 == null) goto L22;
        if (r1 == null) goto L22;
        if (((HashSet) r15).contains(r1) == false) goto L22;
        r4 = true;
    L22:
        r4 = !r4;
        goto L44
    L24:
        if (g == false) goto L44;
        if (TextUtils.isEmpty(f) == true) goto L42;
        if (TextUtils.equals(f, r1) == false) goto L44;
    L31:
        if (c(r1) == true) goto L42;
        if (e == true) goto L40;
        Set<String> r16 = i;
        if (r16 == null) goto L40;
        if (r1 == null) goto L40;
        if (((HashSet) r16).contains(r1) == false) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == true) goto L44;
    L40:
        r17 = false;
        goto L41
    }
}
