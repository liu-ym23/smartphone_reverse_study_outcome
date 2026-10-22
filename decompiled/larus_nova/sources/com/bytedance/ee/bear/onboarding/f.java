package com.bytedance.ee.bear.onboarding;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.document.onboarding.OnBoardingPlugin;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f236155h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<k> f236156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f236157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f236158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f236159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super tk5.d<? extends vk5.c>, Boolean> f236160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Boolean> f236161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f236162g;

    public static final class a implements sk5.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f236163a;

        public a(f r100) {
            this.f236163a = r100;
        }

        @Override // sk5.d.a
        public final void a(tk5.d<? extends vk5.c> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "mission");
            String r102 = r100.getId();
            tt5.a.b("OnBoardingManager", f.f236155h + ", onFinishPlay [" + r102 + "] ... hasPerformAction: " + r101);
            j r103 = this.f236163a.f236157b;
            if (r103 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r103.f236168b, r100) == false) goto L13;
            if (r101 == false) goto L10;
            Function1<? super String, Unit> r104 = this.f236163a.f236159d;
            if (r104 == null) goto L10;
            Intrinsics.checkNotNull(r102);
            r104.invoke(r102);
        L10:
            this.f236163a.a(r103, true);
            return;
        }
    }

    public static final class b {
    }

    static {
        f236155h = f.class.getSimpleName();
    }

    public final void b() {
        if (this.f236157b == null) goto L5;
        return;
    L5:
        if (this.f236156a.isEmpty() == true) goto L77;
        k r100 = (k) ((LinkedList) this.f236156a).peekFirst();
        if ((r100 instanceof j) == false) goto L67;
        ((LinkedList) this.f236156a).removeFirst();
        j r101 = (j) r100;
        this.f236157b = r101;
        tk5.d<UI> r102 = r101.f236168b;
        vk5.c r103 = (vk5.c) r101.f236169c.get();
        if ((r103 instanceof vk5.a) == false) goto L76;
        Function1<? super String, Boolean> r104 = this.f236161f;
        if (r104 == null) goto L15;
        boolean r105 = r104.invoke(r102.getId()).booleanValue();
    L17:
        if (TextUtils.equals("mobile_space_newbie_navigation", r102.getId()) == false) goto L19;
    L22:
        r105 = false;
    L23:
        String r106 = f236155h;
        boolean r107 = true;
        if (r105 == false) goto L29;
        tt5.a.h(r106, "play()...finished = " + r105 + ", mission id = " + r102.getId());
        tk5.b r108 = ((vk5.a) r103).f555502a;
        if (r108 == null) goto L28;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r108).f220699a, r102.getId(), "success");
    L28:
        a(r101, true);
        return;
    L29:
        Function1<? super tk5.d<? extends vk5.c>, Boolean> r109 = this.f236160e;
        Lifecycle.State r110 = null;
        if (r109 == null) goto L32;
        Boolean r111 = r109.invoke(r102);
    L34:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == true) goto L39;
        tk5.b r112 = ((vk5.a) r103).f555502a;
        if (r112 == null) goto L38;
        r102.getId();
        r102.getDependency();
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r112).f220699a, r102.getId(), "fail");
    L38:
        tt5.a.b("OnBoardingManager", "OnBoardingMission[" + r102.getId() + "]'s dependency[" + r102.getDependency() + "] unfinished.");
        a(r101, false);
        return;
    L39:
        vk5.a r113 = (vk5.a) r103;
        FragmentActivity r114 = r113.getActivity();
        if (r114 == null) goto L45;
        Lifecycle r115 = r114.getLifecycle();
        if (r115 == null) goto L45;
        r110 = r115.getCurrentState();
    L45:
        if (r110 != Lifecycle.State.RESUMED) goto L47;
        boolean r116 = true;
    L48:
        if (r116 == true) goto L50;
    L52:
        r107 = false;
    L53:
        if (r107 == true) goto L58;
        tk5.b r117 = r113.f555502a;
        if (r117 == null) goto L57;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r117).f220699a, r102.getId(), "fail");
    L57:
        a(r101, false);
        return;
    L58:
        r113.f555506e = this.f236162g;
        if (r102.b(r103) == true) goto L64;
        tk5.b r118 = r113.f555502a;
        if (r118 == null) goto L63;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r118).f220699a, r102.getId(), "fail");
    L63:
        tt5.a.b("OnBoardingManager", "Play mission[" + r102.getId() + "] failed.");
        a(r101, false);
        return;
    L64:
        tt5.a.b("OnBoardingManager", r106 + ", playOnBoarding[" + r102.getId() + "]...");
        return;
    L50:
        if (r113.a() == false) goto L52;
    L47:
        r116 = false;
        goto L48
    L32:
        r111 = null;
        goto L34
    L19:
        if (TextUtils.equals("mobile_space_newbie_createDocument", r102.getId()) == true) goto L22;
        if (TextUtils.equals("mobile_space_newbie_createTemplate", r102.getId()) == false) goto L23;
    L15:
        r105 = false;
        goto L17
    L76:
        return;
    L67:
        if ((r100 instanceof i) == false) goto L70;
        return;
    L70:
        throw new NoWhenBranchMatchedException();
    }

    public f() {
        this.f236156a = new LinkedList();
        this.f236162g = new a(this);
    }

    public final void a(j r100, boolean r101) {
        String r102 = null;
        this.f236157b = null;
        if (r101 == true) goto L5;
    L11:
        tt5.a.b(f236155h, "Total time in queue: " + ((System.currentTimeMillis() - r100.f236170a) / 1000.0d) + 's');
        b();
        return;
    L5:
        if ((r100 instanceof j) == false) goto L11;
        Object r103 = r100.f236168b;
        if ((r103 instanceof tk5.a) == false) goto L9;
        r102 = ((tk5.a) r103).a();
    L9:
        if (r102 == null) goto L11;
        i r104 = new i(r102);
        ((LinkedList) this.f236156a).addFirst(r104);
        g r105 = new g(this, r104);
        this.f236158c = r105;
        com.bytedance.ee.util.ui.j.d(r105, 1000);
        goto L11
    }
}
