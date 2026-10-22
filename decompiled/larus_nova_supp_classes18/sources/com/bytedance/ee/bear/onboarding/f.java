package com.bytedance.ee.bear.onboarding;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.document.onboarding.OnBoardingPlugin;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final String h = null;
    public final Deque<k> a;
    public j b;
    public g c;
    public Function1<? super String, Unit> d;
    public Function1<? super tk5.d<? extends vk5.c>, Boolean> e;
    public Function1<? super String, Boolean> f;
    public final a g;

    public static final class a implements sk5.d.a {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // sk5.d.a
        public final void a(tk5.d<? extends vk5.c> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "mission");
            String r0 = r4.getId();
            tt5.a.b("OnBoardingManager", f.h + ", onFinishPlay [" + r0 + "] ... hasPerformAction: " + r5);
            j r1 = this.a.b;
            if (r1 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r1.b, r4) == false) goto L13;
            if (r5 == false) goto L10;
            Function1<? super String, Unit> r6 = this.a.d;
            if (r6 == null) goto L10;
            Intrinsics.checkNotNull(r0);
            r6.invoke(r0);
        L10:
            this.a.a(r1, true);
            return;
        }
    }

    public static final class b {
    }

    static {
        h = f.class.getSimpleName();
    }

    public final void b() {
        if (this.b == null) goto L5;
        return;
    L5:
        if (this.a.isEmpty() == true) goto L77;
        k r0 = (k) ((LinkedList) this.a).peekFirst();
        if ((r0 instanceof j) == false) goto L67;
        ((LinkedList) this.a).removeFirst();
        j r1 = (j) r0;
        this.b = r1;
        tk5.d<UI> r2 = r1.b;
        vk5.c r3 = (vk5.c) r1.c.get();
        if ((r3 instanceof vk5.a) == false) goto L76;
        Function1<? super String, Boolean> r4 = this.f;
        if (r4 == null) goto L15;
        boolean r5 = ((Boolean) r4.invoke(r2.getId())).booleanValue();
    L17:
        if (TextUtils.equals("mobile_space_newbie_navigation", r2.getId()) == false) goto L19;
    L22:
        r5 = false;
    L23:
        String r6 = h;
        boolean r7 = true;
        if (r5 == false) goto L29;
        tt5.a.h(r6, "play()...finished = " + r5 + ", mission id = " + r2.getId());
        OnBoardingPlugin.a r8 = ((vk5.a) r3).a;
        if (r8 == null) goto L28;
        OnBoardingPlugin.access$300(r8.a, r2.getId(), "success");
    L28:
        a(r1, true);
        return;
    L29:
        Function1<? super tk5.d<? extends vk5.c>, Boolean> r9 = this.e;
        Lifecycle.State r10 = null;
        if (r9 == null) goto L32;
        Boolean r11 = (Boolean) r9.invoke(r2);
    L34:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == true) goto L39;
        OnBoardingPlugin.a r12 = ((vk5.a) r3).a;
        if (r12 == null) goto L38;
        r2.getId();
        r2.getDependency();
        OnBoardingPlugin.access$300(r12.a, r2.getId(), DocFeed$Value$Result.FAIL);
    L38:
        tt5.a.b("OnBoardingManager", "OnBoardingMission[" + r2.getId() + "]'s dependency[" + r2.getDependency() + "] unfinished.");
        a(r1, false);
        return;
    L39:
        vk5.a r13 = (vk5.a) r3;
        FragmentActivity r14 = r13.getActivity();
        if (r14 == null) goto L45;
        Lifecycle r15 = r14.getLifecycle();
        if (r15 == null) goto L45;
        r10 = r15.getCurrentState();
    L45:
        if (r10 != Lifecycle.State.RESUMED) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == true) goto L50;
    L52:
        r7 = false;
    L53:
        if (r7 == true) goto L58;
        OnBoardingPlugin.a r17 = r13.a;
        if (r17 == null) goto L57;
        OnBoardingPlugin.access$300(r17.a, r2.getId(), DocFeed$Value$Result.FAIL);
    L57:
        a(r1, false);
        return;
    L58:
        r13.e = this.g;
        if (r2.b(r3) == true) goto L64;
        OnBoardingPlugin.a r18 = r13.a;
        if (r18 == null) goto L63;
        OnBoardingPlugin.access$300(r18.a, r2.getId(), DocFeed$Value$Result.FAIL);
    L63:
        tt5.a.b("OnBoardingManager", "Play mission[" + r2.getId() + "] failed.");
        a(r1, false);
        return;
    L64:
        tt5.a.b("OnBoardingManager", r6 + ", playOnBoarding[" + r2.getId() + "]...");
        return;
    L50:
        if (r13.a() == false) goto L52;
    L47:
        r16 = false;
        goto L48
    L32:
        r11 = null;
        goto L34
    L19:
        if (TextUtils.equals("mobile_space_newbie_createDocument", r2.getId()) == true) goto L22;
        if (TextUtils.equals("mobile_space_newbie_createTemplate", r2.getId()) == false) goto L23;
    L15:
        r5 = false;
        goto L17
    L76:
        return;
    L67:
        if ((r0 instanceof i) == false) goto L70;
        return;
    L70:
        throw new NoWhenBranchMatchedException();
    }

    public f() {
        this.a = new LinkedList();
        this.g = new a(this);
    }

    public final void a(j r6, boolean r7) {
        String r0 = null;
        this.b = null;
        if (r7 == true) goto L5;
    L11:
        tt5.a.b(h, "Total time in queue: " + ((System.currentTimeMillis() - r6.a) / 1000.0d) + 's');
        b();
        return;
    L5:
        if ((r6 instanceof j) == false) goto L11;
        Object r8 = r6.b;
        if ((r8 instanceof tk5.a) == false) goto L9;
        r0 = ((tk5.a) r8).a();
    L9:
        if (r0 == null) goto L11;
        i r9 = new i(r0);
        ((LinkedList) this.a).addFirst(r9);
        g r1 = new g(this, r9);
        this.c = r1;
        com.bytedance.ee.util.ui.j.d(r1, 1000);
        goto L11
    }
}
