package wk5;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.onboarding.e;
import com.bytedance.ee.bear.onboarding.synchronization.OnBoardingSynchronizer;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.util.share_preference.UserSP;
import eu5.g;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Singleton
public final class d implements sk5.b {

    public static final class a {
        public static final C0326a a = null;

        /* JADX INFO: renamed from: wk5.d$a$a, reason: collision with other inner class name */
        public class C0326a implements sk5.c {
            public C0326a() {
            }

            @Override // sk5.c
            public final Flowable<sk5.a> e() {
                return Flowable.create(new b(this), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.a()).observeOn(fo5.d.d());
            }

            @Override // sk5.a
            public final void b() {
                if (e.d() == false) goto L6;
                return;
            L6:
                if (e.j.c.e == null) goto L9;
                LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "on_boarding", true).clear();
                return;
            }

            @Override // sk5.a
            public final Map<String, Boolean> h() {
                return e.b();
            }

            @Override // sk5.a
            public final boolean isDebugMode() {
                if (e.d() == false) goto L6;
                return false;
            L6:
                return e.e;
            }

            @Override // sk5.a
            public final void c(String r3) {
                if (e.d() == true) goto L5;
                e r0 = e.j;
                r0.getClass();
                if (TextUtils.isEmpty(r3) == true) goto L15;
                r0.c.f(r3);
                return;
            L15:
                return;
            L5:
                if (e.e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void d(com.bytedance.ee.bear.document.onboarding.b r1) {
                e.a(r1);
            }

            @Override // sk5.a
            public final boolean f(String r4) {
                if (e.d() == true) goto L5;
                e r0 = e.j;
                r0.getClass();
                if (e.c(r4) == false) goto L13;
            L11:
                return false;
            L13:
                if (TextUtils.isEmpty(r4) == true) goto L11;
                return r0.c.e(r4);
            L5:
                if (e.e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return true;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void i(List<String> r6) {
                if (e.d() == true) goto L5;
                e r0 = e.j;
                r0.getClass();
                if (((ArrayList) r6).isEmpty() == true) goto L26;
                OnBoardingSynchronizer r1 = r0.c;
                r1.getClass();
                Intrinsics.checkNotNullParameter(r6, "idList");
                HashMap<String, Boolean> r2 = new HashMap();
                Iterator<T> r7 = r6.iterator();
            L14:
                if (r7.hasNext() == false) goto L18;
                String r3 = (String) r7.next();
                if (r1.e(r3) == true) goto L14;
                Map<String, Boolean> r4 = r1.a;
                Boolean r5 = Boolean.TRUE;
                ((HashMap) r4).put(r3, r5);
                ((ArrayList) r1.b).add(r3);
                r2.put(r3, r5);
                goto L14
            L18:
                r1.g(r2);
                r1.i();
                return;
            L26:
                return;
            L5:
                if (e.e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void a(tk5.d r1, com.bytedance.ee.bear.document.onboarding.c r2) {
                e.e(r1, r2);
            }

            @Override // sk5.a
            public final void g(tk5.d<vk5.a> r3, FragmentActivity r4) {
                if (e.d() == true) goto L7;
                e.e(r3, new vk5.a(r4, null));
                return;
            }
        }

        static {
            a = new C0326a();
        }
    }

    @Override // sk5.b
    public final void a() {
        e.k = true;
        if (e.d() == true) goto L8;
        e r0 = e.j;
        if (e.k == false) goto L7;
        r0.c.a();
        goto L8
    L7:
        r0.getClass();
    L8:
        ((h0) org.koin.java.a.a(h0.class)).Pe(e.m);
    }

    @Inject
    public d() {
    }

    @Override // sk5.b
    public final sk5.c b() {
        return a.a;
    }

    @Override // sk5.b
    public final void init(Map r3) {
        boolean r0 = e.e;
        tt5.a.b("OnBoardingManager", "Initialize OnBoardingManager");
        ((HashMap) e.h).putAll(r3);
    }

    @Override // sk5.b
    public final void c(String r2, String r3) {
        boolean r0 = e.e;
        if (r2 == null) goto L22;
        if (r3 == null) goto L22;
        if (e.d() == false) goto L8;
    L9:
        tt5.a.h("OnBoardingManager", "Login status changed");
        if (g.j() == true) goto L13;
        tt5.a.b("OnBoardingManager", "reset UserSP instance if not in main process.");
        UserSP.resetInstance();
    L13:
        if (e.d() == true) goto L20;
        e r4 = e.j;
        com.bytedance.ee.bear.onboarding.synchronization.a r1 = r4.c.c();
        if (r1 == null) goto L17;
        r1.dispose();
    L17:
        com.bytedance.ee.bear.onboarding.g r5 = r4.b.c;
        if (r5 == null) goto L20;
        j.e(r5);
    L20:
        e.j = new e(r2);
        return;
    L8:
        if (TextUtils.equals(e.j.a, r2) == false) goto L9;
        return;
    L22:
        if (e.d() == true) goto L30;
        e r6 = e.j;
        com.bytedance.ee.bear.onboarding.synchronization.a r7 = r6.c.c();
        if (r7 == null) goto L26;
        r7.dispose();
    L26:
        com.bytedance.ee.bear.onboarding.g r8 = r6.b.c;
        if (r8 == null) goto L29;
        j.e(r8);
    L29:
        e.j = null;
    L30:
        tt5.a.d("OnBoardingManager", "Fail to change user account.");
    }
}
