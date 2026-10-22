package com.bytedance.ee.bear.bitable.utils;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {

    public static final class a {
        public final boolean a;
        public boolean b;
        public final WeakReference<Activity> c;
        public final List<WeakReference<Fragment>> d;
        public final Map<Fragment, C0030a> e;
        public Boolean f;
        public Integer g;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.utils.c$a$a, reason: collision with other inner class name */
        public static final class C0030a {
            public final Boolean a;
            public final Integer b;
            public final Boolean c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0030a) == true) goto L8;
                return false;
            L8:
                C0030a r6 = (C0030a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                Boolean r0 = this.a;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.b;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                Boolean r7 = this.c;
                if (r7 == null) goto L15;
                r1 = r7.hashCode();
            L15:
                return r6 + r1;
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "FragmentStatusBarState(consumeStatusBar=" + this.a + ", statusBarColor=" + this.b + ", statusBarFillerVisible=" + this.c + ')';
            }

            public C0030a(Boolean r1, Integer r2, Boolean r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public final Activity d() {
            return this.c.get();
        }

        public final List<Fragment> e() {
            List<WeakReference<Fragment>> r0 = this.d;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Fragment r3 = (Fragment) ((WeakReference) r2.next()).get();
            if (r3 == null) goto L4;
            r1.add(r3);
            goto L4
        L8:
            return r1;
        }

        public final void f() {
            if (this.a == false) goto L23;
            Activity r0 = d();
            if (r0 == null) goto L9;
            View r1 = r0.findViewById(R.id.content);
            if (r1 == null) goto L9;
            r1.requestApplyInsets();
        L9:
            Activity r2 = d();
            if (r2 == null) goto L16;
            Window r3 = r2.getWindow();
            if (r3 == null) goto L16;
            View r4 = a(r3);
            if (r4 == null) goto L16;
            r4.requestApplyInsets();
        L16:
            Iterator<T> r5 = e().iterator();
        L18:
            if (r5.hasNext() == false) goto L22;
            View r6 = ((Fragment) r5.next()).getView();
            if (r6 == null) goto L18;
            r6.requestApplyInsets();
            goto L18
        L22:
            return;
        L23:
            Fragment r7 = (Fragment) CollectionsKt.firstOrNull(e());
            if (r7 == null) goto L26;
            View r8 = r7.getView();
        L27:
            if (r8 == null) goto L29;
            r8.requestApplyInsets();
            return;
        L29:
            Activity r9 = d();
            if (r9 == null) goto L43;
            Window r10 = r9.getWindow();
            if (r10 == null) goto L44;
            View r11 = a(r10);
            if (r11 == null) goto L45;
            r11.requestApplyInsets();
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L26:
            r8 = null;
            goto L27
        }

        public final void g() {
            if (this.a == false) goto L6;
            h();
            i();
            return;
        L6:
            int r0 = com.bytedance.ee.bear.bitable.c.a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.forseti_status_bar_color_fix_enable") == true) goto L9;
            h();
            i();
            return;
        L9:
            if ((!((ArrayList) e()).isEmpty()) == false) goto L11;
            i();
            return;
        L11:
            h();
        }

        public final void h() {
            Activity r0 = d();
            if (r0 == null) goto L20;
            Integer r1 = this.g;
            if (r1 == null) goto L7;
            WindowInsetsUtils.c(r0).b(r1.intValue());
        L7:
            Boolean r2 = this.f;
            if (r2 == null) goto L11;
            WindowInsetsUtils.c(r0).c(r2.booleanValue());
        L11:
            if (r0.isFinishing() == false) goto L13;
        L18:
            this.b = true;
            tt5.a.h("BitableStatusBarManager", "resetState oldActivityStatusBarColor: " + this.g + ", oldActivityConsumeStatusBar: " + this.f);
            return;
        L13:
            if (r0.isDestroyed() == true) goto L18;
            View r3 = r0.findViewById(R.id.content);
            if (r3 == null) goto L17;
            r3.requestApplyInsets();
        L17:
            a(r0.getWindow()).requestApplyInsets();
            goto L18
        }

        public final void i() {
            Iterator<T> r0 = e().iterator();
        L4:
            if (r0.hasNext() == false) goto L25;
            Fragment r1 = (Fragment) r0.next();
            C0030a r2 = (C0030a) ((LinkedHashMap) this.e).get(r1);
            if (r2 == null) goto L4;
            Integer r3 = r2.b;
            if (r3 == null) goto L11;
            WindowInsetsUtils.b(r1).b(r3.intValue());
        L11:
            Boolean r4 = r2.a;
            if (r4 == null) goto L15;
            WindowInsetsUtils.b(r1).c(r4.booleanValue());
        L15:
            if (Intrinsics.areEqual(r2.c, Boolean.TRUE) == false) goto L21;
            View r5 = r1.getView();
            if (r5 == null) goto L21;
            View r6 = r5.findViewById(2131387279);
            if (r6 == null) goto L21;
            r6.setVisibility(0);
        L21:
            View r7 = r1.getView();
            if (r7 == null) goto L24;
            r7.requestApplyInsets();
        L24:
            this.b = true;
            tt5.a.h("BitableStatusBarManager", "resetState fragment:" + r1.getClass().getSimpleName() + ", oldState:" + r2);
            goto L4
        }

        public static View a(Window r3) {
            View r4 = r3.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            return r4;
        }

        public final void b(int r2, boolean r3) {
            Activity r0 = d();
            if (r0 == null) goto L6;
            com.ss.android.lark.insets.h r1 = WindowInsetsUtils.c(r0);
            r1.b(r2);
            r1.c(r3);
            return;
        }

        public final void c(int r4, boolean r5) {
            Iterator<T> r0 = e().iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            Fragment r1 = (Fragment) r0.next();
            com.ss.android.lark.insets.f r2 = WindowInsetsUtils.b(r1);
            r2.b(r4);
            r2.c(r5);
            View r3 = r1.getView();
            if (r3 == null) goto L4;
            View r6 = r3.findViewById(2131387279);
            if (r6 == null) goto L4;
            r6.setVisibility(8);
            goto L4
        }

        public a(FragmentActivity r2, List r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "fragments");
            this.a = r4;
            this.c = new WeakReference(r2);
            List r5 = r3;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            r6.add(new WeakReference((Fragment) r7.next()));
            goto L4
        L6:
            this.d = r6;
            this.e = new LinkedHashMap();
        }

        public final void j(int r8, boolean r9, boolean r10) {
            if (r10 == false) goto L22;
            Activity r11 = d();
            if (r11 == null) goto L7;
            this.g = Integer.valueOf(((com.ss.android.lark.insets.c) WindowInsetsUtils.c(r11)).e);
            this.f = Boolean.valueOf(((com.ss.android.lark.insets.c) WindowInsetsUtils.c(r11)).i);
        L7:
            ((LinkedHashMap) this.e).clear();
            Iterator r12 = ((ArrayList) e()).iterator();
        L9:
            if (r12.hasNext() == false) goto L22;
            Fragment r1 = (Fragment) r12.next();
            com.ss.android.lark.insets.f r2 = WindowInsetsUtils.b(r1);
            View r3 = r1.getView();
            if (r3 == null) goto L19;
            View r4 = r3.findViewById(2131387279);
            if (r4 == null) goto L19;
            if (r4.getVisibility() != 0) goto L17;
            boolean r5 = true;
        L18:
            Boolean r6 = Boolean.valueOf(r5);
        L20:
            this.e.put(r1, new C0030a(Boolean.valueOf(r2.e()), Integer.valueOf(r2.a()), r6));
            goto L9
        L17:
            r5 = false;
        L19:
            r6 = null;
        L22:
            if (this.a == false) goto L25;
            b(r8, r9);
            c(r8, r9);
            return;
        L25:
            int r13 = com.bytedance.ee.bear.bitable.c.a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.forseti_status_bar_color_fix_enable") == true) goto L28;
            b(r8, r9);
            c(r8, r9);
            return;
        L28:
            if ((!((ArrayList) e()).isEmpty()) == false) goto L30;
            c(r8, r9);
            return;
        L30:
            b(r8, r9);
        }
    }

    public static final class b {
        public final Fragment a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Fragment r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return r2 + r3;
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StatusBarTarget(fragment=" + this.a + ", applyToActivity=" + this.b + ')';
        }

        public b(Fragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @JvmStatic
    public static final a a(FragmentActivity r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "originFragment");
        List r13 = SequencesKt.toList(SequencesKt.generateSequence(r12, BitableStatusBarManager$newChameleonInstance$fragmentChain$1.INSTANCE));
        tt5.a.h("BitableStatusBarManager", "newChameleonInstance fragments:" + CollectionsKt.joinToString$default(r13, null, null, null, 0, null, BitableStatusBarManager$newChameleonInstance$1.INSTANCE, 31, null));
        return new a(r11, r13, true);
    }

    @JvmStatic
    public static final a b(FragmentActivity r5, Fragment r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "originFragment");
        Intrinsics.checkNotNullParameter(r6, "originFragment");
        List r8 = SequencesKt.toList(SequencesKt.generateSequence(r6, BitableStatusBarManager$findStatusBarTarget$fragmentChain$1.INSTANCE));
        ArrayList r2 = new ArrayList();
        Iterator r1 = r8.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if ((r3 instanceof BaseCCMForsetiFragment) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        BaseCCMForsetiFragment r4 = (BaseCCMForsetiFragment) CollectionsKt.firstOrNull(r2);
        boolean r9 = false;
        if (r4 == null) goto L11;
        b r10 = new b(r4, false);
    L19:
        Fragment r11 = r10.a;
        boolean r12 = r10.b;
        Intrinsics.checkNotNullParameter(r5, "activity");
        return new a(r5, CollectionsKt.listOfNotNull(r11), r12);
    L11:
        Object r13 = CollectionsKt.lastOrNull(r8);
        Fragment r14 = (Fragment) r13;
        if (r7 == true) goto L15;
        r13 = null;
    L15:
        Fragment r16 = (Fragment) r13;
        if (r16 == null) goto L18;
        r9 = true;
    L18:
        r10 = new b(r16, r9);
        goto L19
    }
}
