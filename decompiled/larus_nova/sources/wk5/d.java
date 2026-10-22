package wk5;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.onboarding.e;
import com.bytedance.ee.bear.onboarding.synchronization.OnBoardingSynchronizer;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
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

/* JADX INFO: loaded from: classes18.dex */
@Singleton
public final class d implements sk5.b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8127a f560115a = null;

        /* JADX INFO: renamed from: wk5.d$a$a, reason: collision with other inner class name */
        public class C8127a implements sk5.c {
            public C8127a() {
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
                if (e.f236143j.f236149c.f236178e == null) goto L9;
                LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "on_boarding", true).clear();
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
                return e.f236138e;
            }

            @Override // sk5.a
            public final void c(String r100) {
                if (e.d() == true) goto L5;
                e r101 = e.f236143j;
                r101.getClass();
                if (TextUtils.isEmpty(r100) == true) goto L15;
                r101.f236149c.f(r100);
                return;
            L15:
                return;
            L5:
                if (e.f236138e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void d(com.bytedance.ee.bear.document.onboarding.b r100) {
                e.a(r100);
            }

            @Override // sk5.a
            public final boolean f(String r100) {
                if (e.d() == true) goto L5;
                e r101 = e.f236143j;
                r101.getClass();
                if (e.c(r100) == false) goto L13;
            L11:
                return false;
            L13:
                if (TextUtils.isEmpty(r100) == true) goto L11;
                return r101.f236149c.e(r100);
            L5:
                if (e.f236138e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return true;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void i(List<String> r100) {
                if (e.d() == true) goto L5;
                e r101 = e.f236143j;
                r101.getClass();
                if (((ArrayList) r100).isEmpty() == true) goto L26;
                OnBoardingSynchronizer r102 = r101.f236149c;
                r102.getClass();
                Intrinsics.checkNotNullParameter(r100, "idList");
                HashMap<String, Boolean> r103 = new HashMap();
                Iterator<T> r104 = r100.iterator();
            L14:
                if (r104.hasNext() == false) goto L18;
                String r105 = (String) r104.next();
                if (r102.e(r105) == true) goto L14;
                Map<String, Boolean> r106 = r102.f236174a;
                Boolean r107 = Boolean.TRUE;
                ((HashMap) r106).put(r105, r107);
                ((ArrayList) r102.f236175b).add(r105);
                r103.put(r105, r107);
                goto L14
            L18:
                r102.g(r103);
                r102.i();
                return;
            L26:
                return;
            L5:
                if (e.f236138e == true) goto L8;
                tt5.a.d("OnBoardingManager", "OnBoarding INSTANCE hasn't init...");
                return;
            L8:
                throw new RuntimeException("OnBoardingManager: OnBoarding INSTANCE hasn't init...");
            }

            @Override // sk5.a
            public final void a(tk5.d r100, com.bytedance.ee.bear.document.onboarding.c r101) {
                e.e(r100, r101);
            }

            @Override // sk5.a
            public final void g(tk5.d<vk5.a> r100, FragmentActivity r101) {
                if (e.d() == true) goto L7;
                e.e(r100, new vk5.a(r101, null));
                return;
            }
        }

        static {
            f560115a = new C8127a();
        }
    }

    @Override // sk5.b
    public final void a() {
        e.f236144k = true;
        if (e.d() == true) goto L8;
        e r100 = e.f236143j;
        if (e.f236144k == false) goto L7;
        r100.f236149c.a();
        goto L8
    L7:
        r100.getClass();
    L8:
        ((h0) org.koin.java.a.a(h0.class)).Pe(e.f236146m);
    }

    @Inject
    public d() {
    }

    @Override // sk5.b
    public final sk5.c b() {
        return a.f560115a;
    }

    @Override // sk5.b
    public final void init(Map r100) {
        boolean r101 = e.f236138e;
        tt5.a.b("OnBoardingManager", "Initialize OnBoardingManager");
        ((HashMap) e.f236141h).putAll(r100);
    }

    @Override // sk5.b
    public final void c(String r100, String r101) {
        boolean r102 = e.f236138e;
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (e.d() == false) goto L8;
    L9:
        tt5.a.h("OnBoardingManager", "Login status changed");
        if (g.j() == true) goto L13;
        tt5.a.b("OnBoardingManager", "reset UserSP instance if not in main process.");
        UserSP.resetInstance();
    L13:
        if (e.d() == true) goto L20;
        e r103 = e.f236143j;
        com.bytedance.ee.bear.onboarding.synchronization.a r104 = r103.f236149c.c();
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        com.bytedance.ee.bear.onboarding.g r105 = r103.f236148b.f236158c;
        if (r105 == null) goto L20;
        j.e(r105);
    L20:
        e.f236143j = new e(r100);
        return;
    L8:
        if (TextUtils.equals(e.f236143j.f236147a, r100) == false) goto L9;
        return;
    L22:
        if (e.d() == true) goto L30;
        e r106 = e.f236143j;
        com.bytedance.ee.bear.onboarding.synchronization.a r107 = r106.f236149c.c();
        if (r107 == null) goto L26;
        r107.dispose();
    L26:
        com.bytedance.ee.bear.onboarding.g r108 = r106.f236148b.f236158c;
        if (r108 == null) goto L29;
        j.e(r108);
    L29:
        e.f236143j = null;
    L30:
        tt5.a.d("OnBoardingManager", "Fail to change user account.");
    }
}
