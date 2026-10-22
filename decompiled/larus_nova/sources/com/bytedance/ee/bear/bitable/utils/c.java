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

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f216264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f216265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<Activity> f216266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<WeakReference<Fragment>> f216267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<Fragment, C3086a> f216268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f216269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f216270g;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.utils.c$a$a, reason: collision with other inner class name */
        public static final class C3086a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Boolean f216271a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f216272b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Boolean f216273c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3086a) == true) goto L8;
                return false;
            L8:
                C3086a r101 = (C3086a) r100;
                if (Intrinsics.areEqual(this.f216271a, r101.f216271a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f216272b, r101.f216272b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f216273c, r101.f216273c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                Boolean r100 = this.f216271a;
                int r101 = 0;
                if (r100 != null) goto L5;
                int r102 = 0;
            L6:
                int r103 = r102 * 31;
                Integer r104 = this.f216272b;
                if (r104 != null) goto L9;
                int r105 = 0;
            L10:
                int r106 = (r103 + r105) * 31;
                Boolean r107 = this.f216273c;
                if (r107 == null) goto L15;
                r101 = r107.hashCode();
            L15:
                return r106 + r101;
            L9:
                r105 = r104.hashCode();
                goto L10
            L5:
                r102 = r100.hashCode();
                goto L6
            }

            public final String toString() {
                return "FragmentStatusBarState(consumeStatusBar=" + this.f216271a + ", statusBarColor=" + this.f216272b + ", statusBarFillerVisible=" + this.f216273c + ')';
            }

            public C3086a(Boolean r100, Integer r101, Boolean r102) {
                this.f216271a = r100;
                this.f216272b = r101;
                this.f216273c = r102;
            }
        }

        public final Activity d() {
            return this.f216266c.get();
        }

        public final List<Fragment> e() {
            List<WeakReference<Fragment>> r100 = this.f216267d;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Fragment r103 = (Fragment) ((WeakReference) r102.next()).get();
            if (r103 == null) goto L4;
            r101.add(r103);
            goto L4
        L8:
            return r101;
        }

        public final void f() {
            if (this.f216264a == false) goto L23;
            Activity r100 = d();
            if (r100 == null) goto L9;
            View r101 = r100.findViewById(R.id.content);
            if (r101 == null) goto L9;
            r101.requestApplyInsets();
        L9:
            Activity r102 = d();
            if (r102 == null) goto L16;
            Window r103 = r102.getWindow();
            if (r103 == null) goto L16;
            View r104 = a(r103);
            if (r104 == null) goto L16;
            r104.requestApplyInsets();
        L16:
            Iterator<T> r105 = e().iterator();
        L18:
            if (r105.hasNext() == false) goto L22;
            View r106 = ((Fragment) r105.next()).getView();
            if (r106 == null) goto L18;
            r106.requestApplyInsets();
            goto L18
        L22:
            return;
        L23:
            Fragment r107 = (Fragment) CollectionsKt.firstOrNull(e());
            if (r107 == null) goto L26;
            View r108 = r107.getView();
        L27:
            if (r108 == null) goto L29;
            r108.requestApplyInsets();
            return;
        L29:
            Activity r109 = d();
            if (r109 == null) goto L43;
            Window r110 = r109.getWindow();
            if (r110 == null) goto L44;
            View r111 = a(r110);
            if (r111 == null) goto L45;
            r111.requestApplyInsets();
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L26:
            r108 = null;
            goto L27
        }

        public final void g() {
            if (this.f216264a == false) goto L6;
            h();
            i();
            return;
        L6:
            int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
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
            Activity r100 = d();
            if (r100 == null) goto L20;
            Integer r101 = this.f216270g;
            if (r101 == null) goto L7;
            WindowInsetsUtils.c(r100).b(r101.intValue());
        L7:
            Boolean r102 = this.f216269f;
            if (r102 == null) goto L11;
            WindowInsetsUtils.c(r100).c(r102.booleanValue());
        L11:
            if (r100.isFinishing() == false) goto L13;
        L18:
            this.f216265b = true;
            tt5.a.h("BitableStatusBarManager", "resetState oldActivityStatusBarColor: " + this.f216270g + ", oldActivityConsumeStatusBar: " + this.f216269f);
            return;
        L13:
            if (r100.isDestroyed() == true) goto L18;
            View r103 = r100.findViewById(R.id.content);
            if (r103 == null) goto L17;
            r103.requestApplyInsets();
        L17:
            a(r100.getWindow()).requestApplyInsets();
            goto L18
        }

        public final void i() {
            Iterator<T> r100 = e().iterator();
        L4:
            if (r100.hasNext() == false) goto L25;
            Fragment r101 = (Fragment) r100.next();
            C3086a r102 = (C3086a) ((LinkedHashMap) this.f216268e).get(r101);
            if (r102 == null) goto L4;
            Integer r103 = r102.f216272b;
            if (r103 == null) goto L11;
            WindowInsetsUtils.b(r101).b(r103.intValue());
        L11:
            Boolean r104 = r102.f216271a;
            if (r104 == null) goto L15;
            WindowInsetsUtils.b(r101).c(r104.booleanValue());
        L15:
            if (Intrinsics.areEqual(r102.f216273c, Boolean.TRUE) == false) goto L21;
            View r105 = r101.getView();
            if (r105 == null) goto L21;
            View r106 = r105.findViewById(com.larus.nova.R.id.statusBarFiller);
            if (r106 == null) goto L21;
            r106.setVisibility(0);
        L21:
            View r107 = r101.getView();
            if (r107 == null) goto L24;
            r107.requestApplyInsets();
        L24:
            this.f216265b = true;
            tt5.a.h("BitableStatusBarManager", "resetState fragment:" + r101.getClass().getSimpleName() + ", oldState:" + r102);
            goto L4
        }

        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public final void b(int r100, boolean r101) {
            Activity r102 = d();
            if (r102 == null) goto L6;
            com.ss.android.lark.insets.h r103 = WindowInsetsUtils.c(r102);
            r103.b(r100);
            r103.c(r101);
            return;
        }

        public final void c(int r100, boolean r101) {
            Iterator<T> r102 = e().iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Fragment r103 = (Fragment) r102.next();
            com.ss.android.lark.insets.f r104 = WindowInsetsUtils.b(r103);
            r104.b(r100);
            r104.c(r101);
            View r105 = r103.getView();
            if (r105 == null) goto L4;
            View r106 = r105.findViewById(com.larus.nova.R.id.statusBarFiller);
            if (r106 == null) goto L4;
            r106.setVisibility(8);
            goto L4
        }

        public a(FragmentActivity r100, List r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "fragments");
            this.f216264a = r102;
            this.f216266c = new WeakReference(r100);
            List r103 = r101;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator r105 = r103.iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            r104.add(new WeakReference((Fragment) r105.next()));
            goto L4
        L6:
            this.f216267d = r104;
            this.f216268e = new LinkedHashMap();
        }

        public final void j(int r100, boolean r101, boolean r110) {
            if (r110 == false) goto L22;
            Activity r111 = d();
            if (r111 == null) goto L7;
            this.f216270g = Integer.valueOf(WindowInsetsUtils.c(r111).f427737e);
            this.f216269f = Boolean.valueOf(WindowInsetsUtils.c(r111).f427741i);
        L7:
            ((LinkedHashMap) this.f216268e).clear();
            Iterator r112 = ((ArrayList) e()).iterator();
        L9:
            if (r112.hasNext() == false) goto L22;
            Fragment r102 = (Fragment) r112.next();
            com.ss.android.lark.insets.f r103 = WindowInsetsUtils.b(r102);
            View r104 = r102.getView();
            if (r104 == null) goto L19;
            View r105 = r104.findViewById(com.larus.nova.R.id.statusBarFiller);
            if (r105 == null) goto L19;
            if (r105.getVisibility() != 0) goto L17;
            boolean r106 = true;
        L18:
            Boolean r107 = Boolean.valueOf(r106);
        L20:
            this.f216268e.put(r102, new C3086a(Boolean.valueOf(r103.e()), Integer.valueOf(r103.a()), r107));
            goto L9
        L17:
            r106 = false;
        L19:
            r107 = null;
        L22:
            if (this.f216264a == false) goto L25;
            b(r100, r101);
            c(r100, r101);
            return;
        L25:
            int r113 = com.bytedance.ee.bear.bitable.c.f207079a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.forseti_status_bar_color_fix_enable") == true) goto L28;
            b(r100, r101);
            c(r100, r101);
            return;
        L28:
            if ((!((ArrayList) e()).isEmpty()) == false) goto L30;
            c(r100, r101);
            return;
        L30:
            b(r100, r101);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f216274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f216275b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f216274a, r101.f216274a) == true) goto L12;
            return false;
        L12:
            if (this.f216275b == r101.f216275b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Fragment r100 = this.f216274a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f216275b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StatusBarTarget(fragment=" + this.f216274a + ", applyToActivity=" + this.f216275b + ')';
        }

        public b(Fragment r100, boolean r101) {
            this.f216274a = r100;
            this.f216275b = r101;
        }
    }

    static {
    }

    @JvmStatic
    public static final a a(FragmentActivity r110, Fragment r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "originFragment");
        List r112 = SequencesKt.toList(SequencesKt.generateSequence(r111, BitableStatusBarManager$newChameleonInstance$fragmentChain$1.INSTANCE));
        tt5.a.h("BitableStatusBarManager", "newChameleonInstance fragments:" + CollectionsKt.joinToString$default(r112, null, null, null, 0, null, BitableStatusBarManager$newChameleonInstance$1.INSTANCE, 31, null));
        return new a(r110, r112, true);
    }

    @JvmStatic
    public static final a b(FragmentActivity r100, Fragment r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "originFragment");
        Intrinsics.checkNotNullParameter(r101, "originFragment");
        List r103 = SequencesKt.toList(SequencesKt.generateSequence(r101, BitableStatusBarManager$findStatusBarTarget$fragmentChain$1.INSTANCE));
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if ((r106 instanceof BaseCCMForsetiFragment) == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        BaseCCMForsetiFragment r107 = (BaseCCMForsetiFragment) CollectionsKt.firstOrNull(r104);
        boolean r108 = false;
        if (r107 == null) goto L11;
        b r109 = new b(r107, false);
    L19:
        Fragment r110 = r109.f216274a;
        boolean r111 = r109.f216275b;
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new a(r100, CollectionsKt.listOfNotNull(r110), r111);
    L11:
        Object r112 = CollectionsKt.lastOrNull(r103);
        Fragment r113 = (Fragment) r112;
        if (r102 == true) goto L15;
        r112 = null;
    L15:
        Fragment r114 = (Fragment) r112;
        if (r114 == null) goto L18;
        r108 = true;
    L18:
        r109 = new b(r114, r108);
        goto L19
    }
}
