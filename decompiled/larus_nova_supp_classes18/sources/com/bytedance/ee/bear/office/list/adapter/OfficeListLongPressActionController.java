package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.screenmenu.ScreenMenu$addOnBackPressed$1;
import com.bytedance.ee.bear.office.common.screenmenu.ScreenMenuLayout;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeListLongPressActionController {
    public static final /* synthetic */ int i = 0;
    public final Context a;
    public final Function0<Fragment> b;
    public final com.bytedance.ee.bear.office.list.adapter.f c;
    public com.bytedance.ee.bear.office.common.screenmenu.j d;
    public v e;
    public f f;
    public boolean g;
    public a h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.adapter.OfficeListLongPressActionController$a$a, reason: collision with other inner class name */
        public static final class C0133a extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0133a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0133a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Configured(parentId=" + this.a + ')';
            }

            public C0133a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "parentId");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c {
        public final CommonMenu a;
        public final List<com.bytedance.ee.bear.office.list.menuconfig.a> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CurrentParentMenuBuild(parentMenu=" + this.a + ", configuredItems=" + this.b + ')';
        }

        public c(CommonMenu r2, List<com.bytedance.ee.bear.office.list.menuconfig.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "parentMenu");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends ScrollView {
        public final int a;

        public d(Context r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = r3;
        }

        @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE));
        }
    }

    public static final class e {
        public final Function0<View> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "RestoreSubMenu(viewHolder=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function0<? extends View> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewHolder");
            this.a = r2;
        }
    }

    public static final class f {
        public final View a;
        public final a0 b;
        public final c0 c;
        public final OfficeListSortFilterScene d;
        public final o e;
        public final boolean f;
        public final Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> g;
        public final Function0<Unit> h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            OfficeListSortFilterScene r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            o r5 = this.e;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (r4 + r2) * 31;
            if (this.f == false) goto L13;
            int r7 = 1231;
        L15:
            return ((((r6 + r7) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        L13:
            r7 = 1237;
            goto L15
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ShowState(anchor=" + this.a + ", menuContext=" + this.b + ", menuRules=" + this.c + ", scene=" + this.d + ", sortFilterAction=" + this.e + ", useConfiguredMenu=" + this.f + ", onMenuActionClick=" + this.g + ", onMultiSelect=" + this.h + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(View r2, a0 r3, c0 r4, OfficeListSortFilterScene r5, o r6, boolean r7, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r8, Function0<Unit> r9) {
            Intrinsics.checkNotNullParameter(r2, "anchor");
            Intrinsics.checkNotNullParameter(r3, "menuContext");
            Intrinsics.checkNotNullParameter(r4, "menuRules");
            Intrinsics.checkNotNullParameter(r8, "onMenuActionClick");
            Intrinsics.checkNotNullParameter(r9, "onMultiSelect");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.SORT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L65:
            r0[OfficeLongPressMenuAction.FILTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L77:
            r0[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[OfficeLongPressMenuAction.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L49:
            r0[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[OfficeLongPressMenuAction.STAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L71:
            r0[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L67:
            r0[OfficeLongPressMenuAction.MORE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L69:
            r0[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            r0[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L75:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L43:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L51:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L73:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L20:
            a = r0;
            int[] r1 = new int[OfficeLongPressMenuItemState.values().length];
            r1[OfficeLongPressMenuItemState.LOADING_BLOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L63:
            r1[OfficeLongPressMenuItemState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L23:
            b = r1;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ OfficeListLongPressActionController b;
        public final /* synthetic */ View c;
        public final /* synthetic */ List<com.bytedance.ee.bear.office.list.menuconfig.a> d;
        public final /* synthetic */ a0 e;
        public final /* synthetic */ c0 f;
        public final /* synthetic */ OfficeListSortFilterScene g;
        public final /* synthetic */ o h;
        public final /* synthetic */ Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> i;
        public final /* synthetic */ Function0<Unit> j;
        public final /* synthetic */ Function0<Unit> k;

        /* JADX WARN: Multi-variable type inference failed */
        public h(String r1, OfficeListLongPressActionController r2, View r3, List<com.bytedance.ee.bear.office.list.menuconfig.a> r4, a0 r5, c0 r6, OfficeListSortFilterScene r7, o r8, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r9, Function0<Unit> r10, Function0<Unit> r11) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
        }

        public final void a() {
            StringBuilder r1 = new StringBuilder("execute long press menu retry. reason=");
            r1.append(this.a);
            r1.append(", ");
            OfficeListLongPressActionController r2 = this.b;
            View r3 = this.c;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r4 = this.d;
            Integer r5 = null;
            if (r4 == null) goto L5;
            Integer r6 = Integer.valueOf(r4.size());
        L6:
            r1.append(OfficeListLongPressActionController.h(r2, r3, r6));
            tt5.a.h("OfficeLongPressMenu", r1.toString());
            if (this.c.isAttachedToWindow() == true) goto L13;
            OfficeListLongPressActionController r7 = this.b;
            View r8 = this.c;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r9 = this.d;
            if (r9 == null) goto L11;
            r5 = Integer.valueOf(r9.size());
        L11:
            OfficeListLongPressActionController.p(r7, "retry_anchor_detached", r8, r5, null, 24);
            return;
        L13:
            this.b.z(this.c, this.e, this.f, this.g, this.h, this.d, this.i, this.j, this.k, false);
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void t() {
        this.g = false;
        this.h = null;
        v r1 = this.e;
        if (r1 == null) goto L5;
        r1.c();
    L5:
        this.e = null;
        this.f = null;
    }

    public static boolean i(OfficeLongPressMenuAction r1) {
        if (r1 != OfficeLongPressMenuAction.DOWNLOAD) goto L5;
    L18:
        return true;
    L5:
        if (r1 == OfficeLongPressMenuAction.EXPORT_AS) goto L18;
        if (r1 == OfficeLongPressMenuAction.MAKE_COPY) goto L18;
        if (r1 == OfficeLongPressMenuAction.SECRET_SETTING) goto L18;
        if (r1 == OfficeLongPressMenuAction.MOVE_TO) goto L18;
        if (r1 == OfficeLongPressMenuAction.ADD_SHORTCUT) goto L18;
        if (r1 == OfficeLongPressMenuAction.RENAME) goto L18;
        return false;
    }

    public static boolean x(OfficeLongPressMenuAction r1) {
        int r2 = g.a[r1.ordinal()];
        if (r2 == 5) goto L6;
        switch(r2) {
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            default: goto L5;
        };
    L5:
        return false;
    L6:
        return true;
    }

    public final List<fk5.a> F(List<b0> r17) {
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r1 = r17.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        b0 r14 = (b0) r1.next();
        int r4 = r14.b;
        String r5 = r14.c;
        Integer r6 = Integer.valueOf(r14.d);
        Integer r7 = r14.g;
        Integer r8 = r14.h;
        if (r14.e != OfficeLongPressMenuItemState.DISABLED) goto L8;
        boolean r9 = true;
    L9:
        r0.add(r(this, r4, r5, r6, r7, r8, r9, true, false, null, false, r14, 896));
        goto L4
    L8:
        r9 = false;
        goto L9
    L10:
        return r0;
    }

    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        StringBuilder r0 = new StringBuilder("close and clear long press menu. reason=");
        r0.append(r4);
        r0.append(", hasSession=");
        if (this.e == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", screenVisible=");
        com.bytedance.ee.bear.office.common.screenmenu.j r2 = this.d;
        if (r2 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r2.m());
    L10:
        r0.append(r3);
        tt5.a.h("OfficeLongPressMenu", r0.toString());
        this.h = null;
        t();
        com.bytedance.ee.bear.office.common.screenmenu.j r5 = this.d;
        if (r5 == null) goto L14;
        r5.f(r4);
        return;
    L14:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final boolean k(b0 r10) {
        int r0 = g.b[r10.e.ordinal()];
        String r1 = "";
        if (r0 != 1) goto L5;
        tt5.a.h("OfficeLongPressMenu", "block long press menu item click. blockType=loading, " + G(r10, null));
        UDToast.a r2 = UDToast.build(this.a);
        String r11 = r10.f;
        if (r11 == null) goto L25;
        r1 = r11;
    L25:
        r2.g(r1);
        r2.b.d = -1;
        r2.h();
        return true;
    L5:
        if (r0 == 2) goto L8;
    L15:
        return false;
    L8:
        if (i(r10.a) == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L16;
        tt5.a.h("OfficeLongPressMenu", "allow disabled long press menu item dispatch. " + G(r10, null));
        goto L15
    L16:
        tt5.a.h("OfficeLongPressMenu", "block long press menu item click. blockType=disabled, " + G(r10, null));
        UDToast.a r4 = UDToast.build(this.a);
        String r12 = r10.f;
        if (r12 == null) goto L20;
        r1 = r12;
    L20:
        r4.g(r1);
        r4.b.d = -1;
        r4.h();
        return true;
    L10:
        if (r10.i == false) goto L12;
        r3 = true;
        goto L13
    }

    public final boolean l(int r3) {
        if (r3 != 0) goto L8;
        return false;
    L8:
        return Intrinsics.areEqual(this.a.getResources().getResourceTypeName(r3), "drawable");
    L10:
        return false;
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c q(int r8) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, com.bytedance.ee.bear.office.common.screenmenu.k.a(this.a, 8), com.bytedance.ee.bear.office.common.screenmenu.k.a(this.a, r8), 74);
    }

    public final CommonMenu s(int r3) {
        CommonMenu r0 = new CommonMenu(this.a);
        com.bytedance.ee.bear.office.common.screenmenu.b.a(r0);
        r0.d(com.bytedance.ee.bear.office.common.screenmenu.k.a(this.a, r3));
        return r0;
    }

    public static String C(com.bytedance.ee.bear.office.list.menuconfig.a r2, Integer r3) {
        return "id=" + r2.a + ",menuId=" + r3 + ",action=" + r2.b + ",state=" + r2.e + ",dispatchWhenDisabled=" + r2.i + ",disabledReason=" + r2.j + ",children=" + r2.l.size();
    }

    public static /* synthetic */ String D(OfficeListLongPressActionController r0, com.bytedance.ee.bear.office.list.menuconfig.a r1) {
        r0.getClass();
        return C(r1, null);
    }

    public static String G(b0 r2, Integer r3) {
        StringBuilder r0 = new StringBuilder("action=");
        r0.append(r2.a);
        r0.append(",menuId=");
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        r0.append(r4);
        r0.append(",state=");
        r0.append(r2.e);
        r0.append(",dispatchWhenDisabled=");
        r0.append(r2.i);
        r0.append(",disabledReason=");
        r0.append(r2.j);
        return r0.toString();
    L5:
        r4 = r2.b;
        goto L6
    }

    public static final d b(OfficeListLongPressActionController r2, View r3) {
        Resources r0 = r2.a.getResources();
        d r1 = new d(r2.a, (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).heightPixels * 0.72f));
        r1.setFillViewport(false);
        r1.setOverScrollMode(1);
        r1.addView(r3, new ViewGroup.LayoutParams(-2, -2));
        return r1;
    }

    public static void m(String r4, List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (((b0) r1).e != OfficeLongPressMenuItemState.HIDDEN) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        Iterator r7 = r0.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        tt5.a.h("OfficeLongPressMenu", "drop default menu item. stage=" + r4 + ", " + G((b0) r7.next(), null) + ", reason=hidden_state");
        goto L13
    }

    public static List v(List r18, boolean r19) {
        LinkedHashSet r0 = new LinkedHashSet();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r18.iterator();
    L4:
        if (r2.hasNext() == false) goto L30;
        com.bytedance.ee.bear.office.list.menuconfig.a r3 = (com.bytedance.ee.bear.office.list.menuconfig.a) r2.next();
        if (r3.e == OfficeLongPressMenuItemState.HIDDEN) goto L7;
        if (StringsKt.isBlank(r3.a) == true) goto L10;
        if (StringsKt.isBlank(r3.c) == true) goto L13;
        if (r0.add(r3.a) == false) goto L16;
        if (r1.size() >= 12) goto L19;
        if (r19 == false) goto L26;
        if (r3.l.size() <= 12) goto L24;
        tt5.a.h("OfficeLongPressMenu", "trim configured menu children. reason=exceed_max_count, " + C(r3, null));
    L24:
        List r4 = CollectionsKt.take(r3.l, 12);
    L29:
        String r6 = r3.a;
        OfficeLongPressMenuAction r7 = r3.b;
        String r8 = r3.c;
        int r9 = r3.d;
        OfficeLongPressMenuItemState r10 = r3.e;
        String r11 = r3.f;
        Integer r12 = r3.g;
        Integer r13 = r3.h;
        boolean r14 = r3.i;
        OfficeLongPressDisabledDispatchReason r15 = r3.j;
        Map<String, String> r5 = r3.k;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r5, "payload");
        Intrinsics.checkNotNullParameter(r4, "children");
        r1.add(new com.bytedance.ee.bear.office.list.menuconfig.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r5, r4));
        goto L4
    L26:
        if ((!r3.l.isEmpty()) == false) goto L28;
        tt5.a.h("OfficeLongPressMenu", "trim configured menu children. reason=nested_children_not_allowed, " + C(r3, null));
    L28:
        r4 = CollectionsKt.emptyList();
        goto L29
    L19:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=exceed_max_count, " + C(r3, null));
        goto L4
    L16:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=duplicate_id, " + C(r3, null));
        goto L4
    L13:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=blank_title, " + C(r3, null));
        goto L4
    L10:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=blank_id, " + C(r3, null));
        goto L4
    L7:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=hidden_state, " + C(r3, null));
        goto L4
    L30:
        return r1;
    }

    public final void u(boolean r3, Function0<Unit> r4) {
        this.g = r3;
        com.bytedance.ee.bear.office.common.screenmenu.j r5 = this.d;
        if (r5 == null) goto L13;
        com.bytedance.ee.bear.office.common.screenmenu.j.e(r5, "terminal_action", 2);
    L13:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(r4.invoke());     // Catch: Throwable -> L7
    L9:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        tt5.a.e("OfficeLongPressMenu", "run long press menu action failed", r8, false);
        t();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public OfficeListLongPressActionController(Context r2, Function0<? extends Fragment> r3, com.bytedance.ee.bear.office.list.adapter.f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ownerFragmentProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static /* synthetic */ String h(OfficeListLongPressActionController r1, View r2, Integer r3) {
        Fragment r0 = (Fragment) r1.b.invoke();
        r1.getClass();
        return g(r2, r3, -1, r0);
    }

    public static void n(String r2, boolean r3, String r4) {
        tt5.a.h("OfficeLongPressMenu", "long press menu snapshot. stage=" + r2 + ", useConfiguredMenu=" + r3 + ", items=" + r4);
    }

    public final void B(CommonMenu r23, final OfficeListSortFilterScene r24, final o r25) {
        FolderSortStrategy r0 = r25.c(r24);
        Iterator<T> r1 = r24.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        OfficeListSortFilterScene.c r4 = (OfficeListSortFilterScene.c) r2;
        if (r0.e == r4.b) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
    L14:
        OfficeListSortFilterScene.c r3 = (OfficeListSortFilterScene.c) r2;
        if (r3 != null) goto L29;
        Iterator<T> r6 = r24.c.iterator();
    L18:
        if (r6.hasNext() == false) goto L25;
        Object r7 = r6.next();
        if (r0.e != ((OfficeListSortFilterScene.c) r7).b) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L18;
    L26:
        r3 = (OfficeListSortFilterScene.c) r7;
        if (r3 != null) goto L29;
        r3 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r24.c);
        goto L29
    L22:
        r8 = false;
        goto L23
    L25:
        r7 = null;
    L29:
        OfficeListSortFilterScene.c r12 = r3;
        if (r12 == null) goto L34;
        int r9 = OfficeListSortFilterScene.e;
        String r10 = OfficeListSortFilterScene.a.f(this.a, r12);
        if (r10 == null) goto L34;
    L38:
        List r11 = CollectionsKt.createListBuilder();
        OfficeListSortFilterScene.c r15 = r12;
        List r13 = r11;
        r13.add(r(this, 201, this.a.getString(2131889454), 2131244683, 2131244679, null, false, false, false, r10, false, null, 1776));
        r13.add(q(220));
        Iterator<T> r18 = r24.c.iterator();
        int r14 = 0;
    L40:
        if (r18.hasNext() == false) goto L49;
        Object r16 = r18.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        OfficeListSortFilterScene.c r19 = (OfficeListSortFilterScene.c) r16;
        int r20 = r14 + 2000;
        int r21 = OfficeListSortFilterScene.e;
        String r22 = OfficeListSortFilterScene.a.f(this.a, r19);
        if (Intrinsics.areEqual(r19, r15) == false) goto L47;
        Integer r26 = 2131233736;
    L48:
        boolean r27 = Intrinsics.areEqual(r19, r15);
        OfficeListSortFilterScene.c r110 = r15;
        List r111 = r13;
        r111.add(r(this, r20, r22, null, r26, null, false, false, r27, null, true, r19, 368));
        r13 = r111;
        r14 = r17;
        r15 = r110;
        goto L40
    L47:
        r26 = null;
        goto L48
    L49:
        List r28 = CollectionsKt.build(r13);
        CommonMenu r29 = s(220);
        r29.f(r28, new OfficeListLongPressActionController$showSortSubMenu$childMenu$1(this, r25, r24));
        this.h = a.d.a;
        com.bytedance.ee.bear.office.common.screenmenu.j r30 = this.d;
        if (r30 == null) goto L66;
        r30.t(r23, r29.j());
        return;
    L66:
        return;
    L34:
        OfficeListSortFilterScene.c r31 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r24.c);
        if (r31 == null) goto L37;
        int r32 = OfficeListSortFilterScene.e;
        r10 = OfficeListSortFilterScene.a.f(this.a, r31);
        goto L38
    L37:
        r10 = this.a.getString(2131889454);
        goto L38
    L8:
        if (r0.f != r4.c) goto L10;
        r5 = true;
        goto L11
    L13:
        r2 = null;
        goto L14
    }

    public final List<fk5.a> E(List<com.bytedance.ee.bear.office.list.menuconfig.a> r22, int r23, int r24) {
        List r14 = CollectionsKt.createListBuilder();
        Iterator<T> r15 = r22.iterator();
        String r1 = null;
        int r0 = 0;
    L4:
        if (r15.hasNext() == false) goto L33;
        Object r2 = r15.next();
        int r18 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.ee.bear.office.list.menuconfig.a r11 = (com.bytedance.ee.bear.office.list.menuconfig.a) r2;
        String r12 = r11.k.get("groupId");
        if (r0 <= 0) goto L14;
        if (Intrinsics.areEqual(r12, r1) == true) goto L14;
        r14.add(q(r24));
    L14:
        int r3 = r23 + r0;
        String r4 = r11.c;
        Integer r5 = Integer.valueOf(r11.d);
        if (Boolean.valueOf(l(r5.intValue())).booleanValue() == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L20;
        int r6 = r5.intValue();
    L21:
        Integer r7 = Integer.valueOf(r6);
        Integer r8 = r11.h;
        if (r8 != null) goto L24;
    L26:
        Integer r9 = null;
    L27:
        Integer r10 = r11.g;
        if (r11.e != OfficeLongPressMenuItemState.DISABLED) goto L30;
        boolean r13 = true;
    L31:
        r14.add(r(this, r3, r4, r7, r9, r10, r13, true, false, null, false, r11, 896));
        r0 = r18;
        r1 = r12;
        goto L4
    L30:
        r13 = false;
        goto L31
    L24:
        if (l(r8.intValue()) == false) goto L26;
        r9 = r8;
        goto L27
    L20:
        r6 = 2131244683;
        goto L21
    L33:
        return CollectionsKt.build(r14);
    }

    public final View f(final a0 r13, c0 r14, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r15) {
        List<b0> r16 = r14.d(r13);
        m("more_rules", r16);
        ArrayList r0 = new ArrayList();
        Iterator r17 = ((ArrayList) r16).iterator();
    L3:
        boolean r2 = true;
        if (r17.hasNext() == false) goto L11;
        Object r1 = r17.next();
        if (((b0) r1).e != OfficeLongPressMenuItemState.HIDDEN) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L3;
        r0.add(r1);
        goto L3
    L11:
        List r18 = CollectionsKt.toMutableList(F(r0));
        tt5.a.h("OfficeLongPressMenu", "default more menu specs built. items=" + CollectionsKt.joinToString$default(r18, ";", "[", "]", 0, null, new OfficeListLongPressActionController$childrenForLog$1(this), 24, null));
        if (r18.size() > 1) goto L15;
        tt5.a.h("OfficeLongPressMenu", "skip show more sub menu because no available child. itemCount=" + r18.size());
        return null;
    L15:
        ListProtector.add(r18, 1, q(220));
        CommonMenu r3 = s(220);
        r3.f(r18, new OfficeListLongPressActionController$buildMoreSubMenuView$childMenu$1(this, r15, r13));
        return r3.j();
    }

    public final void y(CommonMenu r23, final OfficeListSortFilterScene r24, final o r25) {
        FolderSortStrategy r0 = r25.c(r24);
        FilterType.a r1 = FilterType.Companion;
        int r2 = r0.getType();
        String r3 = r0.c;
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        String r5 = r0.d;
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r1.getClass();
        FilterType r6 = FilterType.a.b(r2, r3, r4);
        Iterator<T> r7 = r24.d.iterator();
    L11:
        if (r7.hasNext() == false) goto L22;
        Object r8 = r7.next();
        OfficeListSortFilterScene.b r9 = (OfficeListSortFilterScene.b) r8;
        if (r6.getType() == r9.getType()) goto L15;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L11;
    L23:
        OfficeListSortFilterScene.b r15 = (OfficeListSortFilterScene.b) r8;
        List r12 = CollectionsKt.createListBuilder();
        r12.add(r(this, 301, this.a.getString(2131889408), 2131244682, 2131244679, null, false, false, false, null, false, null, 2032));
        r12.add(q(220));
        Iterator<T> r18 = r24.d.iterator();
        int r11 = 0;
    L25:
        if (r18.hasNext() == false) goto L34;
        Object r13 = r18.next();
        int r16 = r11 + 1;
        if (r11 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        OfficeListSortFilterScene.b r14 = (OfficeListSortFilterScene.b) r13;
        int r17 = r11 + 3000;
        int r19 = OfficeListSortFilterScene.e;
        String r20 = OfficeListSortFilterScene.a.e(this.a, r14);
        if (Intrinsics.areEqual(r14, r15) == false) goto L32;
        Integer r21 = 2131233736;
    L33:
        boolean r22 = Intrinsics.areEqual(r14, r15);
        OfficeListSortFilterScene.b r110 = r15;
        List r111 = r12;
        r111.add(r(this, r17, r20, null, r21, null, false, false, r22, null, true, r14, 368));
        r12 = r111;
        r11 = r16;
        r15 = r110;
        goto L25
    L32:
        r21 = null;
        goto L33
    L34:
        List r26 = CollectionsKt.build(r12);
        CommonMenu r27 = s(220);
        r27.f(r26, new OfficeListLongPressActionController$showFilterSubMenu$childMenu$1(this, r25, r24));
        this.h = a.b.a;
        com.bytedance.ee.bear.office.common.screenmenu.j r28 = this.d;
        if (r28 == null) goto L46;
        r28.t(r23, r27.j());
        return;
    L46:
        return;
    L15:
        if (Intrinsics.areEqual(r6.getFileType(), r9.c) == false) goto L19;
        if (Intrinsics.areEqual(r6.getForbiddenFileType(), r9.d) == false) goto L19;
        r10 = true;
        goto L20
    L22:
        r8 = null;
        goto L23
    }

    public static String g(View r3, Integer r4, int r5, Fragment r6) {
        StringBuilder r0 = new StringBuilder("fragmentAdded=");
        Lifecycle.State r1 = null;
        if (r6 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r6.isAdded());
    L6:
        r0.append(r2);
        r0.append(", fragmentState=");
        if (r6 == null) goto L11;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L11;
        r1 = r7.getCurrentState();
    L11:
        r0.append(r1);
        r0.append(", anchorAttached=");
        r0.append(r3.isAttachedToWindow());
        r0.append(", anchorWidth=");
        r0.append(r3.getWidth());
        r0.append(", anchorHeight=");
        r0.append(r3.getHeight());
        r0.append(", parentMenuChildCount=");
        r0.append(r5);
        r0.append(", configuredItemsSize=");
        r0.append(r4);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final void A(CommonMenu r4, a0 r5, c0 r6, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r7) {
        com.bytedance.ee.bear.office.common.screenmenu.j r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L15;
        ScreenMenuLayout r2 = r0.a;
        if (r2 != null) goto L7;
    L12:
        boolean r3 = false;
    L13:
        if (r3 != true) goto L15;
        r1 = true;
        goto L15
    L7:
        if (r2.g == null) goto L9;
        boolean r8 = true;
    L10:
        if (r8 != true) goto L12;
        r3 = true;
        goto L13
    L9:
        r8 = false;
    L15:
        if (r1 == true) goto L17;
    L25:
        View r9 = f(r5, r6, r7);
        if (r9 != null) goto L28;
        return;
    L28:
        this.h = a.c.a;
        tt5.a.h("OfficeLongPressMenu", "show more sub menu. activeSubMenuState=" + this.h);
        com.bytedance.ee.bear.office.common.screenmenu.j r10 = this.d;
        if (r10 == null) goto L33;
        r10.t(r4, r9);
        return;
    L33:
        return;
    L17:
        if (Intrinsics.areEqual(this.h, a.c.a) == false) goto L22;
        this.h = null;
        com.bytedance.ee.bear.office.common.screenmenu.j r11 = this.d;
        if (r11 == null) goto L32;
        r11.q();
        return;
    L32:
        return;
    L22:
        com.bytedance.ee.bear.office.common.screenmenu.j r12 = this.d;
        if (r12 == null) goto L25;
        r12.q();
        goto L25
    }

    public final View d(com.bytedance.ee.bear.office.list.menuconfig.a r24, List<com.bytedance.ee.bear.office.list.menuconfig.a> r25, final a0 r26, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r27) {
        Integer r2 = null;
        if (r25.isEmpty() == false) goto L6;
        tt5.a.h("OfficeLongPressMenu", "skip configured sub menu because children empty. parent=" + C(r24, null));
        return null;
    L6:
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r12 = v(r25, false);
        if (((ArrayList) r12).isEmpty() == false) goto L10;
        tt5.a.h("OfficeLongPressMenu", "skip configured sub menu because sanitized children empty. parent=" + C(r24, null));
        return null;
    L10:
        tt5.a.h("OfficeLongPressMenu", "configured sub menu built. parent=" + C(r24, null) + ", children=" + CollectionsKt.joinToString$default(r12, ";", "[", "]", 0, null, new OfficeListLongPressActionController$toConfiguredLogString$1(this), 24, null));
        List r14 = CollectionsKt.createListBuilder();
        String r3 = r24.c;
        Integer r0 = Integer.valueOf(r24.d);
        if (l(r0.intValue()) == false) goto L13;
        r2 = r0;
    L13:
        if (r2 == null) goto L15;
        int r1 = r2.intValue();
    L16:
        r14.add(r(this, 30000, r3, Integer.valueOf(r1), 2131233731, r24.g, false, false, false, null, false, r24, 992));
        r14.add(q(220));
        r14.addAll(E(r12, 40000, 220));
        List r4 = CollectionsKt.build(r14);
        CommonMenu r5 = s(220);
        r5.f(r4, new OfficeListLongPressActionController$buildConfiguredSubMenuView$1(this, r27, r26));
        return r5.j();
    L15:
        r1 = 2131244683;
        goto L16
    }

    public static void o(String r2, View r3, Integer r4, int r5, Fragment r6) {
        tt5.a.h("OfficeLongPressMenu", "skip long press menu show. reason=" + r2 + ", " + g(r3, r4, r5, r6));
    }

    public final CommonMenu e(a0 r17, c0 r18, OfficeListSortFilterScene r19, o r20, Function1<? super fk5.a, Unit> r21) {
        CommonMenu r2 = s(200);
        List<b0> r3 = r18.c(r17);
        m("main_rules", r3);
        ArrayList r4 = new ArrayList();
        Iterator r5 = ((ArrayList) r3).iterator();
    L3:
        boolean r6 = false;
        if (r5.hasNext() == false) goto L10;
        Object r7 = r5.next();
        if (((b0) r7).e == OfficeLongPressMenuItemState.HIDDEN) goto L8;
        r6 = true;
    L8:
        if (r6 == false) goto L3;
        r4.add(r7);
        goto L3
    L10:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r4.iterator();
    L12:
        if (r9.hasNext() == false) goto L58;
        Object r10 = r9.next();
        b0 r11 = (b0) r10;
        OfficeLongPressMenuAction r12 = r11.a;
        int[] r13 = g.a;
        int r14 = r13[r12.ordinal()];
        if (r14 == 1) goto L25;
        if (r14 != 2) goto L32;
        if (r19 != null) goto L19;
    L21:
        boolean r15 = false;
    L22:
        if (r15 == false) goto L33;
        if (r20 != null) goto L32;
    L33:
        boolean r16 = false;
    L34:
        if (r16 == true) goto L56;
        StringBuilder r110 = new StringBuilder("drop default main menu item. stage=capability_filter, ");
        Boolean r111 = null;
        r110.append(G(r11, null));
        r110.append(", reason=");
        int r22 = r13[r11.a.ordinal()];
        if (r22 == 1) goto L47;
        if (r22 == 2) goto L39;
        String r23 = "capability_missing";
    L55:
        r110.append(r23);
        tt5.a.h("OfficeLongPressMenu", r110.toString());
        goto L56
    L39:
        StringBuilder r24 = new StringBuilder("filter_capability_missing(sceneCanFilter=");
        if (r19 == null) goto L42;
        r111 = Boolean.valueOf(!r19.d.isEmpty());
    L42:
        r24.append(r111);
        r24.append(",hasAction=");
        if (r20 == null) goto L45;
        boolean r112 = true;
    L46:
        r24.append(r112);
        r24.append(')');
        r23 = r24.toString();
        goto L55
    L45:
        r112 = false;
        goto L46
    L47:
        StringBuilder r25 = new StringBuilder("sort_capability_missing(sceneCanSort=");
        if (r19 == null) goto L50;
        r111 = Boolean.valueOf(r19.a());
    L50:
        r25.append(r111);
        r25.append(",hasAction=");
        if (r20 == null) goto L53;
        boolean r113 = true;
    L54:
        r25.append(r113);
        r25.append(')');
        r23 = r25.toString();
        goto L55
    L53:
        r113 = false;
    L56:
        if (r16 == false) goto L12;
        r8.add(r10);
        goto L12
    L19:
        if ((!r19.d.isEmpty()) != true) goto L21;
        r15 = true;
    L32:
        r16 = true;
        goto L34
    L25:
        if (r19 != null) goto L27;
    L29:
        boolean r26 = false;
    L30:
        if (r26 == false) goto L33;
        if (r20 == null) goto L33;
    L27:
        if (r19.a() != true) goto L29;
        r26 = true;
        goto L30
    L58:
        tt5.a.h("OfficeLongPressMenu", "default main menu specs built. specs=" + CollectionsKt.joinToString$default(r8, ";", "[", "]", 0, null, new OfficeListLongPressActionController$toSpecLogString$1(this), 24, null));
        r2.f(F(r8), r21);
        return r2;
    }

    public static /* synthetic */ void p(OfficeListLongPressActionController r1, String r2, View r3, Integer r4, Fragment r5, int r6) {
        if ((r6 & 8) == 0) goto L5;
        int r0 = -1;
    L7:
        if ((r6 & 16) == 0) goto L9;
        r5 = (Fragment) r1.b.invoke();
    L9:
        r1.getClass();
        o(r2, r3, r4, r0, r5);
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public final CommonMenu c(List<com.bytedance.ee.bear.office.list.menuconfig.a> r20, final a0 r21, final c0 r22, final OfficeListSortFilterScene r23, final o r24, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r25, final Function0<Unit> r26) {
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r0 = v(r20, true);
        tt5.a.h("OfficeLongPressMenu", "configured long press menu sanitized. originalSize=" + r20.size() + ", sanitizedSize=" + ((ArrayList) r0).size() + ", items=" + CollectionsKt.joinToString$default(r0, ";", "[", "]", 0, null, new OfficeListLongPressActionController$toConfiguredLogString$1(this), 24, null));
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        CommonMenu r11 = s(200);
        r11.f(E(r0, 20000, 200), new OfficeListLongPressActionController$buildConfiguredMainMenu$1(this, r10, r21, r25, r22, r23, r24, r26));
        r10.element = r11;
        return r11;
    }

    public static final void a(final OfficeListLongPressActionController r3, fk5.a r4, CommonMenu r5, final a0 r6, c0 r7, OfficeListSortFilterScene r8, o r9, final Function2 r10, Function0 r11) {
        r3.getClass();
        if ((r4 instanceof com.bytedance.ee.bear.office.common.screenmenu.e) == false) goto L5;
        com.bytedance.ee.bear.office.common.screenmenu.e r12 = (com.bytedance.ee.bear.office.common.screenmenu.e) r4;
    L6:
        if (r12 == null) goto L8;
        Object r13 = r12.k;
    L10:
        if ((r13 instanceof b0) == false) goto L12;
        final b0 r14 = (b0) r13;
    L13:
        if (r14 == null) goto L51;
        tt5.a.h("OfficeLongPressMenu", "main menu item clicked. " + G(r14, null));
        if (r3.k(r14) == false) goto L19;
        return;
    L19:
        switch(g.a[r14.a.ordinal()]) {
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L30;
            case 5: goto L30;
            case 6: goto L30;
            case 7: goto L30;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L22;
            default: goto L37;
        };
    L25:
        r3.A(r5, r6, r7, r10);
        return;
    L30:
        r3.u(x(r14.a), new OfficeListLongPressActionController$handleMainMenuClick$1(r10, r14, r6));
        return;
    L31:
        if (r8 == null) goto L45;
        if (r9 == null) goto L46;
        r3.y(r5, r8, r9);
        return;
    L46:
        return;
    L45:
        return;
    L34:
        if (r8 == null) goto L48;
        if (r9 == null) goto L49;
        r3.B(r5, r8, r9);
        return;
    L49:
        return;
    L48:
        return;
    L37:
        r3.u(x(r14.a), new OfficeListLongPressActionController$handleMainMenuClick$5(r10, r14, r6));
        return;
    L22:
        if (r3.c == null) goto L24;
        r3.u(false, new OfficeListLongPressActionController$handleMainMenuClick$3(r3));
        return;
    L24:
        r3.u(false, new OfficeListLongPressActionController$handleMainMenuClick$4(r10, r14, r6));
        return;
    L27:
        if (r6.i == false) goto L29;
        r3.u(false, r11);
        return;
    L29:
        r3.u(false, new OfficeListLongPressActionController$handleMainMenuClick$2(r10, r14, r6));
        return;
    L51:
        return;
    L12:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public final void w(String r16, View r17, a0 r18, c0 r19, OfficeListSortFilterScene r20, o r21, List<com.bytedance.ee.bear.office.list.menuconfig.a> r22, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r23, Function0<Unit> r24, Function0<Unit> r25) {
        StringBuilder r0 = new StringBuilder("schedule long press menu retry. reason=");
        r0.append(r16);
        r0.append(", ");
        if (r22 == null) goto L5;
        Integer r2 = Integer.valueOf(r22.size());
    L6:
        r0.append(h(this, r17, r2));
        tt5.a.h("OfficeLongPressMenu", r0.toString());
        r17.postDelayed(new h(r16, this, r17, r22, r18, r19, r20, r21, r23, r24, r25), 80);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void z(final View r19, final a0 r20, final c0 r21, final OfficeListSortFilterScene r22, final o r23, final List<com.bytedance.ee.bear.office.list.menuconfig.a> r24, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r25, final Function0<Unit> r26, final Function0<Unit> r27, boolean r28) {
        StringBuilder r0 = new StringBuilder("enter long press menu show. allowRetry=");
        r0.append(r28);
        r0.append(", useConfiguredMenu=");
        if (r24 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", ");
        if (r24 == null) goto L9;
        Integer r2 = Integer.valueOf(r24.size());
    L10:
        r0.append(h(this, r19, r2));
        tt5.a.h("OfficeLongPressMenu", r0.toString());
        if (r19.isAttachedToWindow() == false) goto L164;
        if (r19.getWidth() <= 0) goto L164;
        if (r19.getHeight() <= 0) goto L164;
        Fragment r4 = (Fragment) this.b.invoke();
        if (r4 != null) goto L20;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == true) goto L27;
        if (r24 == null) goto L36;
        Integer r5 = Integer.valueOf(r24.size());
    L37:
        com.bytedance.ee.bear.office.common.screenmenu.j r6 = this.d;
        if (r6 != null) goto L40;
        r6 = new com.bytedance.ee.bear.office.common.screenmenu.j();
        this.d = r6;
    L40:
        if (r4 != null) goto L42;
        Fragment r29 = r4;
        String r15 = "OfficeLongPressMenu";
        Context r7 = r19.getContext();
    L50:
        if ((r7 instanceof ContextWrapper) == false) goto L55;
        if ((r7 instanceof FragmentActivity) == true) goto L53;
        r7 = ((ContextWrapper) r7).getBaseContext();
        goto L50
    L53:
        FragmentActivity r8 = (FragmentActivity) r7;
    L56:
        if (r8 != null) goto L65;
        Context r9 = this.a;
    L59:
        if ((r9 instanceof ContextWrapper) == false) goto L64;
        if ((r9 instanceof FragmentActivity) == true) goto L62;
        r9 = ((ContextWrapper) r9).getBaseContext();
        goto L59
    L62:
        r8 = (FragmentActivity) r9;
        goto L65
    L64:
        r8 = null;
    L65:
        if (r8 != null) goto L68;
        p(this, "ensure_activity_missing", r19, r5, null, 24);
    L75:
        com.bytedance.ee.bear.office.common.screenmenu.j r10 = null;
    L76:
        if (r10 != null) goto L79;
        return;
    L79:
        if (this.e == r20.n) goto L81;
        t();
    L81:
        this.h = null;
        this.e = r20.n;
        if (r24 == null) goto L84;
        boolean r16 = true;
    L85:
        com.bytedance.ee.bear.office.common.screenmenu.j r11 = r10;
        boolean r12 = r16;
        String r17 = r15;
        this.f = new f(r19, r20, r21, r22, r23, r12, r25, r26);
        Function0<Unit> r13 = new OfficeListLongPressActionController$showInternal$1(this, r19, r24, r27);
        r11.g = r13;
        ScreenMenuLayout r14 = r11.a;
        if (r14 == null) goto L88;
        r14.setOnDismissListener(r13);
    L88:
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        if (r24 != null) goto L91;
        CommonMenu r30 = e(r20, r21, r22, r23, new OfficeListLongPressActionController$showInternal$2(this, r18, r20, r21, r22, r23, r25, r26));
    L92:
        r18.element = r30;
        if (r24 == null) goto L95;
        boolean r31 = true;
    L96:
        StringBuilder r32 = new StringBuilder("parentMenuChildCount=");
        Object r33 = r18.element;
        if (r33 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r34 = null;
    L100:
        r32.append(r34.getChildCount());
        n("parent_built", r31, r32.toString());
        StringBuilder r35 = new StringBuilder("built long press parent menu. childCount=");
        Object r36 = r18.element;
        if (r36 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r37 = null;
    L104:
        r35.append(r37.getChildCount());
        r35.append(", useConfiguredMenu=");
        if (r24 == null) goto L107;
        boolean r38 = true;
    L108:
        r35.append(r38);
        r35.append(", ");
        if (r24 == null) goto L111;
        Integer r39 = Integer.valueOf(r24.size());
    L112:
        Object r40 = r18.element;
        if (r40 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r41 = null;
    L116:
        Fragment r42 = r29;
        r35.append(g(r19, r39, r41.getChildCount(), r42));
        tt5.a.h(r17, r35.toString());
        Object r43 = r18.element;
        if (r43 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r44 = null;
    L121:
        if (r44.getChildCount() != 0) goto L131;
        if (r24 == null) goto L124;
        Integer r45 = Integer.valueOf(r24.size());
    L125:
        Object r46 = r18.element;
        if (r46 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r47 = null;
    L129:
        o("empty_parent_menu", r19, r45, r47.getChildCount(), r42);
        t();
        return;
    L128:
        r47 = (CommonMenu) r46;
        goto L129
    L124:
        r45 = null;
        goto L125
    L131:
        StringBuilder r48 = new StringBuilder("call screen menu show. ");
        if (r24 == null) goto L134;
        Integer r49 = Integer.valueOf(r24.size());
    L135:
        Object r50 = r18.element;
        if (r50 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        LinearLayoutCompat r51 = null;
    L139:
        r48.append(g(r19, r49, r51.getChildCount(), r42));
        tt5.a.h(r17, r48.toString());
        com.bytedance.ee.bear.office.common.screenmenu.u r52 = com.bytedance.ee.bear.office.common.screenmenu.u.e;
        Function0<View> r53 = new OfficeListLongPressActionController$showInternal$3(this, r18);
        Intrinsics.checkNotNullParameter(r19, "anchor");
        Intrinsics.checkNotNullParameter(r52, "presentation");
        Intrinsics.checkNotNullParameter(r53, "menuViewHolder");
        ScreenMenu$addOnBackPressed$1 r54 = r11.f;
        if (r54 == null) goto L142;
        r54.setEnabled(true);
    L142:
        r11.i();
        StringBuilder r55 = new StringBuilder("show screen menu with holder. presentation=");
        r55.append(r52);
        r55.append(", layoutReady=");
        if (r11.a == null) goto L145;
        boolean r110 = true;
    L146:
        r55.append(r110);
        r55.append(", ");
        r55.append(r11.b(r19));
        tt5.a.h("ScreenMenu", r55.toString());
        ScreenMenuLayout r56 = r11.a;
        if (r56 == null) goto L152;
        Intrinsics.checkNotNullParameter(r19, "anchor");
        Intrinsics.checkNotNullParameter(r52, "presentation");
        Intrinsics.checkNotNullParameter(r53, "menuViewHolder");
        StringBuilder r57 = new StringBuilder("layout show with holder start. presentation=");
        r57.append(r52);
        r57.append(", ");
        LinearLayoutCompat r58 = null;
        r57.append(r56.g(r19, null));
        tt5.a.h("ScreenMenuLayout", r57.toString());
        r56.l = false;
        r56.m = false;
        r56.n = SystemClock.uptimeMillis();
        r56.bringToFront();
        r56.removeAllViews();
        r56.f(r52);
        if (r52.b == false) goto L151;
        r56.d(r19);
    L151:
        View r59 = (View) r53.invoke();
        r56.b = r19;
        r56.c = r59;
        r56.d = r19;
        r56.e = r59;
        r56.m(r19, r59);
        r56.setVisibility(0);
        tt5.a.h("ScreenMenuLayout", "layout show with holder visible. menuChildCount=" + r56.getChildCount() + ", " + r56.g(r19, r59));
        OneShotPreDrawListener.add(r56, new com.bytedance.ee.bear.office.common.screenmenu.q(r56, r56));
    L153:
        StringBuilder r60 = new StringBuilder("screen menu show returned. isVisible=");
        r60.append(r11.m());
        r60.append(", ");
        if (r24 == null) goto L156;
        LinearLayoutCompat r61 = Integer.valueOf(r24.size());
    L157:
        Object r62 = r18.element;
        if (r62 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
    L161:
        r60.append(g(r19, r61, r58.getChildCount(), r42));
        tt5.a.h(r17, r60.toString());
        return;
    L160:
        r58 = (CommonMenu) r62;
        goto L161
    L156:
        r61 = r58;
        goto L157
    L152:
        r58 = null;
        goto L153
    L145:
        r110 = false;
        goto L146
    L138:
        r51 = (CommonMenu) r50;
        goto L139
    L134:
        r49 = null;
        goto L135
    L119:
        r44 = (CommonMenu) r43;
        goto L121
    L115:
        r41 = (CommonMenu) r40;
        goto L116
    L111:
        r39 = null;
        goto L112
    L107:
        r38 = false;
        goto L108
    L103:
        r37 = (CommonMenu) r36;
        goto L104
    L99:
        r34 = (CommonMenu) r33;
        goto L100
    L95:
        r31 = false;
        goto L96
    L91:
        r30 = c(r24, r20, r21, r22, r23, r25, r26);
        goto L92
    L84:
        r16 = false;
        goto L85
    L68:
        if (r8.isFinishing() == false) goto L70;
    L74:
        p(this, "ensure_activity_invalid", r19, r5, null, 24);
        goto L75
    L70:
        if (r8.isDestroyed() == true) goto L74;
        r6.h(r8);
    L73:
        r10 = r6;
        goto L76
    L55:
        r8 = null;
        goto L56
    L42:
        if (r4.isAdded() == true) goto L44;
    L47:
        r29 = r4;
        r15 = "OfficeLongPressMenu";
        p(this, "ensure_fragment_not_resumed", r19, r5, r4, 8);
        goto L75
    L44:
        if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L47;
        r6.g(r4);
        r29 = r4;
        r15 = "OfficeLongPressMenu";
        goto L73
    L36:
        r5 = null;
        goto L37
    L27:
        if (r24 == null) goto L29;
        Integer r63 = Integer.valueOf(r24.size());
    L30:
        p(this, "fragment_not_resumed", r19, r63, r4, 8);
        if (r28 == false) goto L175;
        w("fragment_not_resumed", r19, r20, r21, r22, r23, r24, r25, r26, r27);
        return;
    L175:
        return;
    L29:
        r63 = null;
        goto L30
    L20:
        if (r4.isAdded() == true) goto L22;
    L23:
        r3 = true;
        goto L25
    L22:
        if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L24;
    L164:
        if (r24 == null) goto L166;
        Integer r64 = Integer.valueOf(r24.size());
    L167:
        p(this, "anchor_not_ready", r19, r64, null, 24);
        if (r28 == false) goto L176;
        w("anchor_not_ready", r19, r20, r21, r22, r23, r24, r25, r26, r27);
        return;
    L176:
        return;
    L166:
        r64 = null;
        goto L167
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static com.bytedance.ee.bear.office.common.screenmenu.e r(OfficeListLongPressActionController r19, int r20, String r21, Integer r22, Integer r23, Integer r24, boolean r25, boolean r26, boolean r27, String r28, boolean r29, Object r30, int r31) {
        if ((r31 & 8) == 0) goto L5;
        Integer r11 = null;
    L7:
        if ((r31 & 16) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r31 & 32) == 0) goto L13;
        boolean r15 = false;
    L15:
        if ((r31 & 64) == 0) goto L17;
        boolean r14 = true;
    L19:
        if ((r31 & 128) == 0) goto L21;
        boolean r12 = false;
    L23:
        if ((r31 & 256) == 0) goto L25;
        String r6 = null;
    L27:
        if ((r31 & 512) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r31 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L33;
        Object r13 = null;
    L34:
        r19.getClass();
        return new com.bytedance.ee.bear.office.common.screenmenu.e(r20, r21, r6, r7, r22, false, r10, r11, r12, r13, r14, r15, null, null, 51744);
    L33:
        r13 = r30;
        goto L34
    L29:
        r10 = r29;
        goto L31
    L25:
        r6 = r28;
        goto L27
    L21:
        r12 = r27;
        goto L23
    L17:
        r14 = r26;
        goto L19
    L13:
        r15 = r25;
        goto L15
    L9:
        r7 = r24;
        goto L11
    L5:
        r11 = r23;
        goto L7
    }
}
