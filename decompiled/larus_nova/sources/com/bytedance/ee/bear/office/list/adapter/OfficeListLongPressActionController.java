package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.screenmenu.ScreenMenu$addOnBackPressed$1;
import com.bytedance.ee.bear.office.common.screenmenu.ScreenMenuLayout;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeListLongPressActionController {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f235620i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f235621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Fragment> f235622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.office.list.adapter.f f235623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.office.common.screenmenu.j f235624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f235625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f235626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f235627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f235628h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.adapter.OfficeListLongPressActionController$a$a, reason: collision with other inner class name */
        public static final class C3380a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f235629a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3380a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f235629a, ((C3380a) r100).f235629a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f235629a.hashCode();
            }

            public final String toString() {
                return "Configured(parentId=" + this.f235629a + ')';
            }

            public C3380a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "parentId");
                this.f235629a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f235630a = null;

            static {
                f235630a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f235631a = null;

            static {
                f235631a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f235632a = null;

            static {
                f235632a = new d();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CommonMenu f235633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bytedance.ee.bear.office.list.menuconfig.a> f235634b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f235633a, r101.f235633a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f235634b, r101.f235634b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f235633a.hashCode() * 31;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r101 = this.f235634b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CurrentParentMenuBuild(parentMenu=" + this.f235633a + ", configuredItems=" + this.f235634b + ')';
        }

        public c(CommonMenu r100, List<com.bytedance.ee.bear.office.list.menuconfig.a> r101) {
            Intrinsics.checkNotNullParameter(r100, "parentMenu");
            this.f235633a = r100;
            this.f235634b = r101;
        }
    }

    public static final class d extends ScrollView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f235635a;

        public d(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f235635a = r101;
        }

        @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f235635a, Integer.MIN_VALUE));
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<View> f235636a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235636a, ((e) r100).f235636a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235636a.hashCode();
        }

        public final String toString() {
            return "RestoreSubMenu(viewHolder=" + this.f235636a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function0<? extends View> r100) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
            this.f235636a = r100;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f235637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0 f235638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f235639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final OfficeListSortFilterScene f235640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final o f235641e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f235642f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> f235643g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function0<Unit> f235644h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f235637a, r101.f235637a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f235638b, r101.f235638b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f235639c, r101.f235639c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f235640d, r101.f235640d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f235641e, r101.f235641e) == true) goto L24;
            return false;
        L24:
            if (this.f235642f == r101.f235642f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f235643g, r101.f235643g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f235644h, r101.f235644h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f235637a.hashCode() * 31) + this.f235638b.hashCode()) * 31) + this.f235639c.hashCode()) * 31;
            OfficeListSortFilterScene r101 = this.f235640d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            o r105 = this.f235641e;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (r104 + r102) * 31;
            if (this.f235642f == false) goto L13;
            int r107 = 1231;
        L15:
            return ((((r106 + r107) * 31) + this.f235643g.hashCode()) * 31) + this.f235644h.hashCode();
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ShowState(anchor=" + this.f235637a + ", menuContext=" + this.f235638b + ", menuRules=" + this.f235639c + ", scene=" + this.f235640d + ", sortFilterAction=" + this.f235641e + ", useConfiguredMenu=" + this.f235642f + ", onMenuActionClick=" + this.f235643g + ", onMultiSelect=" + this.f235644h + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(View r100, a0 r101, c0 r102, OfficeListSortFilterScene r103, o r104, boolean r105, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r106, Function0<Unit> r107) {
            Intrinsics.checkNotNullParameter(r100, "anchor");
            Intrinsics.checkNotNullParameter(r101, "menuContext");
            Intrinsics.checkNotNullParameter(r102, "menuRules");
            Intrinsics.checkNotNullParameter(r106, "onMenuActionClick");
            Intrinsics.checkNotNullParameter(r107, "onMultiSelect");
            this.f235637a = r100;
            this.f235638b = r101;
            this.f235639c = r102;
            this.f235640d = r103;
            this.f235641e = r104;
            this.f235642f = r105;
            this.f235643g = r106;
            this.f235644h = r107;
        }
    }

    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235645a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f235646b = null;

        static {
            int[] r100 = new int[OfficeLongPressMenuAction.values().length];
            r100[OfficeLongPressMenuAction.SORT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L65:
            r100[OfficeLongPressMenuAction.FILTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L77:
            r100[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[OfficeLongPressMenuAction.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L49:
            r100[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[OfficeLongPressMenuAction.STAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L71:
            r100[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L67:
            r100[OfficeLongPressMenuAction.MORE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L69:
            r100[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            r100[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L75:
            r100[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L43:
            r100[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L51:
            r100[OfficeLongPressMenuAction.RENAME.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L73:
            r100[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L20:
            f235645a = r100;
            int[] r101 = new int[OfficeLongPressMenuItemState.values().length];
            r101[OfficeLongPressMenuItemState.LOADING_BLOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L63:
            r101[OfficeLongPressMenuItemState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L23:
            f235646b = r101;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f235647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeListLongPressActionController f235648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f235649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<com.bytedance.ee.bear.office.list.menuconfig.a> f235650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a0 f235651e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c0 f235652f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ OfficeListSortFilterScene f235653g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o f235654h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> f235655i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f235656j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f235657k;

        /* JADX WARN: Multi-variable type inference failed */
        public h(String r100, OfficeListLongPressActionController r101, View r102, List<com.bytedance.ee.bear.office.list.menuconfig.a> r103, a0 r104, c0 r105, OfficeListSortFilterScene r106, o r107, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r108, Function0<Unit> r110, Function0<Unit> r111) {
            this.f235647a = r100;
            this.f235648b = r101;
            this.f235649c = r102;
            this.f235650d = r103;
            this.f235651e = r104;
            this.f235652f = r105;
            this.f235653g = r106;
            this.f235654h = r107;
            this.f235655i = r108;
            this.f235656j = r110;
            this.f235657k = r111;
        }

        public final void a() {
            StringBuilder r100 = new StringBuilder("execute long press menu retry. reason=");
            r100.append(this.f235647a);
            r100.append(", ");
            OfficeListLongPressActionController r101 = this.f235648b;
            View r102 = this.f235649c;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r103 = this.f235650d;
            Integer r104 = null;
            if (r103 == null) goto L5;
            Integer r105 = Integer.valueOf(r103.size());
        L6:
            r100.append(OfficeListLongPressActionController.h(r101, r102, r105));
            tt5.a.h("OfficeLongPressMenu", r100.toString());
            if (this.f235649c.isAttachedToWindow() == true) goto L13;
            OfficeListLongPressActionController r106 = this.f235648b;
            View r107 = this.f235649c;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r108 = this.f235650d;
            if (r108 == null) goto L11;
            r104 = Integer.valueOf(r108.size());
        L11:
            OfficeListLongPressActionController.p(r106, "retry_anchor_detached", r107, r104, null, 24);
            return;
        L13:
            this.f235648b.z(this.f235649c, this.f235651e, this.f235652f, this.f235653g, this.f235654h, this.f235650d, this.f235655i, this.f235656j, this.f235657k, false);
            return;
        L5:
            r105 = null;
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
        this.f235627g = false;
        this.f235628h = null;
        v r100 = this.f235625e;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f235625e = null;
        this.f235626f = null;
    }

    public static boolean i(OfficeLongPressMenuAction r100) {
        if (r100 != OfficeLongPressMenuAction.DOWNLOAD) goto L5;
    L18:
        return true;
    L5:
        if (r100 == OfficeLongPressMenuAction.EXPORT_AS) goto L18;
        if (r100 == OfficeLongPressMenuAction.MAKE_COPY) goto L18;
        if (r100 == OfficeLongPressMenuAction.SECRET_SETTING) goto L18;
        if (r100 == OfficeLongPressMenuAction.MOVE_TO) goto L18;
        if (r100 == OfficeLongPressMenuAction.ADD_SHORTCUT) goto L18;
        if (r100 == OfficeLongPressMenuAction.RENAME) goto L18;
        return false;
    }

    public static boolean x(OfficeLongPressMenuAction r100) {
        int r101 = g.f235645a[r100.ordinal()];
        if (r101 == 5) goto L6;
        switch(r101) {
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

    public final List<fk5.a> F(List<b0> r110) {
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        b0 r111 = (b0) r101.next();
        int r102 = r111.f235724b;
        String r103 = r111.f235725c;
        Integer r104 = Integer.valueOf(r111.f235726d);
        Integer r105 = r111.f235729g;
        Integer r106 = r111.f235730h;
        if (r111.f235727e != OfficeLongPressMenuItemState.DISABLED) goto L8;
        boolean r107 = true;
    L9:
        r100.add(r(this, r102, r103, r104, r105, r106, r107, true, false, null, false, r111, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT));
        goto L4
    L8:
        r107 = false;
        goto L9
    L10:
        return r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        StringBuilder r101 = new StringBuilder("close and clear long press menu. reason=");
        r101.append(r100);
        r101.append(", hasSession=");
        if (this.f235625e == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(", screenVisible=");
        com.bytedance.ee.bear.office.common.screenmenu.j r103 = this.f235624d;
        if (r103 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r103.m());
    L10:
        r101.append(r104);
        tt5.a.h("OfficeLongPressMenu", r101.toString());
        this.f235628h = null;
        t();
        com.bytedance.ee.bear.office.common.screenmenu.j r105 = this.f235624d;
        if (r105 == null) goto L14;
        r105.f(r100);
        return;
    L14:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final boolean k(b0 r110) {
        int r100 = g.f235646b[r110.f235727e.ordinal()];
        String r101 = "";
        if (r100 != 1) goto L5;
        tt5.a.h("OfficeLongPressMenu", "block long press menu item click. blockType=loading, " + G(r110, null));
        UDToast.a r102 = UDToast.build(this.f235621a);
        String r111 = r110.f235728f;
        if (r111 == null) goto L25;
        r101 = r111;
    L25:
        r102.g(r101);
        r102.f285429b.f417630d = -1;
        r102.h();
        return true;
    L5:
        if (r100 == 2) goto L8;
    L15:
        return false;
    L8:
        if (i(r110.f235723a) == true) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L16;
        tt5.a.h("OfficeLongPressMenu", "allow disabled long press menu item dispatch. " + G(r110, null));
        goto L15
    L16:
        tt5.a.h("OfficeLongPressMenu", "block long press menu item click. blockType=disabled, " + G(r110, null));
        UDToast.a r104 = UDToast.build(this.f235621a);
        String r112 = r110.f235728f;
        if (r112 == null) goto L20;
        r101 = r112;
    L20:
        r104.g(r101);
        r104.f285429b.f417630d = -1;
        r104.h();
        return true;
    L10:
        if (r110.f235731i == false) goto L12;
        r103 = true;
        goto L13
    }

    public final boolean l(int r100) {
        if (r100 != 0) goto L8;
        return false;
    L8:
        return Intrinsics.areEqual(this.f235621a.getResources().getResourceTypeName(r100), "drawable");
    L10:
        return false;
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c q(int r100) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), R.drawable.office_common_menu_divider, com.bytedance.ee.bear.office.common.screenmenu.k.a(this.f235621a, 8), com.bytedance.ee.bear.office.common.screenmenu.k.a(this.f235621a, r100), 74);
    }

    public final CommonMenu s(int r100) {
        CommonMenu r101 = new CommonMenu(this.f235621a);
        com.bytedance.ee.bear.office.common.screenmenu.b.a(r101);
        r101.d(com.bytedance.ee.bear.office.common.screenmenu.k.a(this.f235621a, r100));
        return r101;
    }

    public static String C(com.bytedance.ee.bear.office.list.menuconfig.a r100, Integer r101) {
        return "id=" + r100.f235928a + ",menuId=" + r101 + ",action=" + r100.f235929b + ",state=" + r100.f235932e + ",dispatchWhenDisabled=" + r100.f235936i + ",disabledReason=" + r100.f235937j + ",children=" + r100.f235939l.size();
    }

    public static /* synthetic */ String D(OfficeListLongPressActionController r100, com.bytedance.ee.bear.office.list.menuconfig.a r101) {
        r100.getClass();
        return C(r101, null);
    }

    public static String G(b0 r100, Integer r101) {
        StringBuilder r102 = new StringBuilder("action=");
        r102.append(r100.f235723a);
        r102.append(",menuId=");
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        r102.append(r103);
        r102.append(",state=");
        r102.append(r100.f235727e);
        r102.append(",dispatchWhenDisabled=");
        r102.append(r100.f235731i);
        r102.append(",disabledReason=");
        r102.append(r100.f235732j);
        return r102.toString();
    L5:
        r103 = r100.f235724b;
        goto L6
    }

    public static final d b(OfficeListLongPressActionController r100, View r101) {
        Resources r102 = r100.f235621a.getResources();
        d r103 = new d(r100.f235621a, (int) (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).heightPixels * 0.72f));
        r103.setFillViewport(false);
        r103.setOverScrollMode(1);
        r103.addView(r101, new ViewGroup.LayoutParams(-2, -2));
        return r103;
    }

    public static void m(String r100, List r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((b0) r104).f235727e != OfficeLongPressMenuItemState.HIDDEN) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        Iterator r106 = r102.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        tt5.a.h("OfficeLongPressMenu", "drop default menu item. stage=" + r100 + ", " + G((b0) r106.next(), null) + ", reason=hidden_state");
        goto L13
    }

    public static List v(List r110, boolean r111) {
        LinkedHashSet r100 = new LinkedHashSet();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L30;
        com.bytedance.ee.bear.office.list.menuconfig.a r103 = (com.bytedance.ee.bear.office.list.menuconfig.a) r102.next();
        if (r103.f235932e == OfficeLongPressMenuItemState.HIDDEN) goto L7;
        if (StringsKt.isBlank(r103.f235928a) == true) goto L10;
        if (StringsKt.isBlank(r103.f235930c) == true) goto L13;
        if (r100.add(r103.f235928a) == false) goto L16;
        if (r101.size() >= 12) goto L19;
        if (r111 == false) goto L26;
        if (r103.f235939l.size() <= 12) goto L24;
        tt5.a.h("OfficeLongPressMenu", "trim configured menu children. reason=exceed_max_count, " + C(r103, null));
    L24:
        List r104 = CollectionsKt.take(r103.f235939l, 12);
    L29:
        String r105 = r103.f235928a;
        OfficeLongPressMenuAction r106 = r103.f235929b;
        String r107 = r103.f235930c;
        int r108 = r103.f235931d;
        OfficeLongPressMenuItemState r112 = r103.f235932e;
        String r113 = r103.f235933f;
        Integer r114 = r103.f235934g;
        Integer r115 = r103.f235935h;
        boolean r116 = r103.f235936i;
        OfficeLongPressDisabledDispatchReason r117 = r103.f235937j;
        Map<String, String> r109 = r103.f235938k;
        Intrinsics.checkNotNullParameter(r105, "id");
        Intrinsics.checkNotNullParameter(r107, "title");
        Intrinsics.checkNotNullParameter(r112, "state");
        Intrinsics.checkNotNullParameter(r109, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r104, "children");
        r101.add(new com.bytedance.ee.bear.office.list.menuconfig.a(r105, r106, r107, r108, r112, r113, r114, r115, r116, r117, r109, r104));
        goto L4
    L26:
        if ((!r103.f235939l.isEmpty()) == false) goto L28;
        tt5.a.h("OfficeLongPressMenu", "trim configured menu children. reason=nested_children_not_allowed, " + C(r103, null));
    L28:
        r104 = CollectionsKt.emptyList();
        goto L29
    L19:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=exceed_max_count, " + C(r103, null));
        goto L4
    L16:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=duplicate_id, " + C(r103, null));
        goto L4
    L13:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=blank_title, " + C(r103, null));
        goto L4
    L10:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=blank_id, " + C(r103, null));
        goto L4
    L7:
        tt5.a.h("OfficeLongPressMenu", "drop configured menu item. reason=hidden_state, " + C(r103, null));
        goto L4
    L30:
        return r101;
    }

    public final void u(boolean r100, Function0<Unit> r101) {
        this.f235627g = r100;
        com.bytedance.ee.bear.office.common.screenmenu.j r102 = this.f235624d;
        if (r102 == null) goto L13;
        com.bytedance.ee.bear.office.common.screenmenu.j.e(r102, "terminal_action", 2);
    L13:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(r101.invoke());     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        tt5.a.e("OfficeLongPressMenu", "run long press menu action failed", r105, false);
        t();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeListLongPressActionController(Context r100, Function0<? extends Fragment> r101, com.bytedance.ee.bear.office.list.adapter.f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "ownerFragmentProvider");
        this.f235621a = r100;
        this.f235622b = r101;
        this.f235623c = r102;
    }

    public static /* synthetic */ String h(OfficeListLongPressActionController r100, View r101, Integer r102) {
        Fragment r103 = r100.f235622b.invoke();
        r100.getClass();
        return g(r101, r102, -1, r103);
    }

    public static void n(String r100, boolean r101, String r102) {
        tt5.a.h("OfficeLongPressMenu", "long press menu snapshot. stage=" + r100 + ", useConfiguredMenu=" + r101 + ", items=" + r102);
    }

    public final void B(CommonMenu r210, final OfficeListSortFilterScene r211, final o r212) {
        FolderSortStrategy r100 = r212.c(r211);
        Iterator<T> r101 = r211.f235661c.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        OfficeListSortFilterScene.c r103 = (OfficeListSortFilterScene.c) r102;
        if (r100.f227684e == r103.f235673b) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        OfficeListSortFilterScene.c r105 = (OfficeListSortFilterScene.c) r102;
        if (r105 != null) goto L29;
        Iterator<T> r106 = r211.f235661c.iterator();
    L18:
        if (r106.hasNext() == false) goto L25;
        Object r107 = r106.next();
        if (r100.f227684e != ((OfficeListSortFilterScene.c) r107).f235673b) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L18;
    L26:
        r105 = (OfficeListSortFilterScene.c) r107;
        if (r105 != null) goto L29;
        r105 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r211.f235661c);
        goto L29
    L22:
        r108 = false;
        goto L23
    L25:
        r107 = null;
    L29:
        OfficeListSortFilterScene.c r110 = r105;
        if (r110 == null) goto L34;
        int r109 = OfficeListSortFilterScene.f235658e;
        String r111 = OfficeListSortFilterScene.a.f(this.f235621a, r110);
        if (r111 == null) goto L34;
    L38:
        List r112 = CollectionsKt.createListBuilder();
        OfficeListSortFilterScene.c r113 = r110;
        List r114 = r112;
        r114.add(r(this, 201, this.f235621a.getString(R.string.LarkCCM_Doubao_Drive_SortBy_Menu), Integer.valueOf(R.drawable.office_ic_screen_menu_more), Integer.valueOf(R.drawable.office_ic_screen_menu_arrow_up), null, false, false, false, r111, false, null, 1776));
        r114.add(q(220));
        Iterator<T> r115 = r211.f235661c.iterator();
        int r116 = 0;
    L40:
        if (r115.hasNext() == false) goto L49;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        OfficeListSortFilterScene.c r119 = (OfficeListSortFilterScene.c) r117;
        int r120 = r116 + 2000;
        int r121 = OfficeListSortFilterScene.f235658e;
        String r122 = OfficeListSortFilterScene.a.f(this.f235621a, r119);
        if (Intrinsics.areEqual(r119, r113) == false) goto L47;
        Integer r123 = Integer.valueOf(R.drawable.dbx_ic_check);
    L48:
        boolean r124 = Intrinsics.areEqual(r119, r113);
        OfficeListSortFilterScene.c r125 = r113;
        List r126 = r114;
        r126.add(r(this, r120, r122, null, r123, null, false, false, r124, null, true, r119, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION));
        r114 = r126;
        r116 = r118;
        r113 = r125;
        goto L40
    L47:
        r123 = null;
        goto L48
    L49:
        List r127 = CollectionsKt.build(r114);
        CommonMenu r128 = s(220);
        r128.f(r127, new OfficeListLongPressActionController$showSortSubMenu$childMenu$1(this, r212, r211));
        this.f235628h = a.d.f235632a;
        com.bytedance.ee.bear.office.common.screenmenu.j r129 = this.f235624d;
        if (r129 == null) goto L66;
        r129.t(r210, r128.j());
        return;
    L66:
        return;
    L34:
        OfficeListSortFilterScene.c r130 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r211.f235661c);
        if (r130 == null) goto L37;
        int r131 = OfficeListSortFilterScene.f235658e;
        r111 = OfficeListSortFilterScene.a.f(this.f235621a, r130);
        goto L38
    L37:
        r111 = this.f235621a.getString(R.string.LarkCCM_Doubao_Drive_SortBy_Menu);
        goto L38
    L8:
        if (r100.f227685f != r103.f235674c) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    public final List<fk5.a> E(List<com.bytedance.ee.bear.office.list.menuconfig.a> r210, int r211, int r212) {
        List r110 = CollectionsKt.createListBuilder();
        Iterator<T> r111 = r210.iterator();
        String r100 = null;
        int r101 = 0;
    L4:
        if (r111.hasNext() == false) goto L33;
        Object r102 = r111.next();
        int r112 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.ee.bear.office.list.menuconfig.a r113 = (com.bytedance.ee.bear.office.list.menuconfig.a) r102;
        String r114 = r113.f235938k.get("groupId");
        if (r101 <= 0) goto L14;
        if (Intrinsics.areEqual(r114, r100) == true) goto L14;
        r110.add(q(r212));
    L14:
        int r103 = r211 + r101;
        String r104 = r113.f235930c;
        Integer r105 = Integer.valueOf(r113.f235931d);
        if (Boolean.valueOf(l(r105.intValue())).booleanValue() == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L21:
        Integer r107 = Integer.valueOf(r106);
        Integer r108 = r113.f235935h;
        if (r108 != null) goto L24;
    L26:
        Integer r109 = null;
    L27:
        Integer r115 = r113.f235934g;
        if (r113.f235932e != OfficeLongPressMenuItemState.DISABLED) goto L30;
        boolean r116 = true;
    L31:
        r110.add(r(this, r103, r104, r107, r109, r115, r116, true, false, null, false, r113, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT));
        r101 = r112;
        r100 = r114;
        goto L4
    L30:
        r116 = false;
        goto L31
    L24:
        if (l(r108.intValue()) == false) goto L26;
        r109 = r108;
        goto L27
    L20:
        r106 = R.drawable.office_ic_screen_menu_more;
        goto L21
    L33:
        return CollectionsKt.build(r110);
    }

    public final View f(final a0 r110, c0 r111, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r112) {
        List<b0> r113 = r111.d(r110);
        m("more_rules", r113);
        ArrayList r100 = new ArrayList();
        Iterator r114 = ((ArrayList) r113).iterator();
    L3:
        boolean r101 = true;
        if (r114.hasNext() == false) goto L11;
        Object r102 = r114.next();
        if (((b0) r102).f235727e != OfficeLongPressMenuItemState.HIDDEN) goto L9;
        r101 = false;
    L9:
        if (r101 == false) goto L3;
        r100.add(r102);
        goto L3
    L11:
        List r115 = CollectionsKt.toMutableList(F(r100));
        tt5.a.h("OfficeLongPressMenu", "default more menu specs built. items=" + CollectionsKt.joinToString$default(r115, com.alipay.sdk.m.u.i.f25853b, "[", "]", 0, null, new OfficeListLongPressActionController$childrenForLog$1(this), 24, null));
        if (r115.size() > 1) goto L15;
        tt5.a.h("OfficeLongPressMenu", "skip show more sub menu because no available child. itemCount=" + r115.size());
        return null;
    L15:
        ListProtector.add(r115, 1, q(220));
        CommonMenu r103 = s(220);
        r103.f(r115, new OfficeListLongPressActionController$buildMoreSubMenuView$childMenu$1(this, r112, r110));
        return r103.j();
    }

    public final void y(CommonMenu r210, final OfficeListSortFilterScene r211, final o r212) {
        FolderSortStrategy r100 = r212.c(r211);
        FilterType.a r101 = FilterType.Companion;
        int r102 = r100.getType();
        String r103 = r100.f227682c;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r100.f227683d;
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r101.getClass();
        FilterType r106 = FilterType.a.b(r102, r103, r104);
        Iterator<T> r107 = r211.f235662d.iterator();
    L11:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        OfficeListSortFilterScene.b r109 = (OfficeListSortFilterScene.b) r108;
        if (r106.getType() == r109.getType()) goto L15;
    L19:
        boolean r110 = false;
    L20:
        if (r110 == false) goto L11;
    L23:
        OfficeListSortFilterScene.b r111 = (OfficeListSortFilterScene.b) r108;
        List r112 = CollectionsKt.createListBuilder();
        r112.add(r(this, 301, this.f235621a.getString(R.string.LarkCCM_Doubao_DriveFilter_TypeFilter_Menu), Integer.valueOf(R.drawable.office_ic_screen_menu_export_file), Integer.valueOf(R.drawable.office_ic_screen_menu_arrow_up), null, false, false, false, null, false, null, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT));
        r112.add(q(220));
        Iterator<T> r113 = r211.f235662d.iterator();
        int r114 = 0;
    L25:
        if (r113.hasNext() == false) goto L34;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        OfficeListSortFilterScene.b r117 = (OfficeListSortFilterScene.b) r115;
        int r118 = r114 + 3000;
        int r119 = OfficeListSortFilterScene.f235658e;
        String r120 = OfficeListSortFilterScene.a.e(this.f235621a, r117);
        if (Intrinsics.areEqual(r117, r111) == false) goto L32;
        Integer r121 = Integer.valueOf(R.drawable.dbx_ic_check);
    L33:
        boolean r122 = Intrinsics.areEqual(r117, r111);
        OfficeListSortFilterScene.b r123 = r111;
        List r124 = r112;
        r124.add(r(this, r118, r120, null, r121, null, false, false, r122, null, true, r117, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION));
        r112 = r124;
        r114 = r116;
        r111 = r123;
        goto L25
    L32:
        r121 = null;
        goto L33
    L34:
        List r125 = CollectionsKt.build(r112);
        CommonMenu r126 = s(220);
        r126.f(r125, new OfficeListLongPressActionController$showFilterSubMenu$childMenu$1(this, r212, r211));
        this.f235628h = a.b.f235630a;
        com.bytedance.ee.bear.office.common.screenmenu.j r127 = this.f235624d;
        if (r127 == null) goto L46;
        r127.t(r210, r126.j());
        return;
    L46:
        return;
    L15:
        if (Intrinsics.areEqual(r106.getFileType(), r109.f235668c) == false) goto L19;
        if (Intrinsics.areEqual(r106.getForbiddenFileType(), r109.f235669d) == false) goto L19;
        r110 = true;
        goto L20
    L22:
        r108 = null;
        goto L23
    }

    public static String g(View r100, Integer r101, int r102, Fragment r103) {
        StringBuilder r104 = new StringBuilder("fragmentAdded=");
        Lifecycle.State r105 = null;
        if (r103 == null) goto L5;
        Boolean r106 = Boolean.valueOf(r103.isAdded());
    L6:
        r104.append(r106);
        r104.append(", fragmentState=");
        if (r103 == null) goto L11;
        Lifecycle r107 = r103.getLifecycle();
        if (r107 == null) goto L11;
        r105 = r107.getCurrentState();
    L11:
        r104.append(r105);
        r104.append(", anchorAttached=");
        r104.append(r100.isAttachedToWindow());
        r104.append(", anchorWidth=");
        r104.append(r100.getWidth());
        r104.append(", anchorHeight=");
        r104.append(r100.getHeight());
        r104.append(", parentMenuChildCount=");
        r104.append(r102);
        r104.append(", configuredItemsSize=");
        r104.append(r101);
        return r104.toString();
    L5:
        r106 = null;
        goto L6
    }

    public final void A(CommonMenu r100, a0 r101, c0 r102, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r103) {
        com.bytedance.ee.bear.office.common.screenmenu.j r104 = this.f235624d;
        boolean r105 = false;
        if (r104 == null) goto L15;
        ScreenMenuLayout r106 = r104.f235228a;
        if (r106 != null) goto L7;
    L12:
        boolean r107 = false;
    L13:
        if (r107 != true) goto L15;
        r105 = true;
        goto L15
    L7:
        if (r106.f235180g == null) goto L9;
        boolean r108 = true;
    L10:
        if (r108 != true) goto L12;
        r107 = true;
        goto L13
    L9:
        r108 = false;
    L15:
        if (r105 == true) goto L17;
    L25:
        View r109 = f(r101, r102, r103);
        if (r109 != null) goto L28;
        return;
    L28:
        this.f235628h = a.c.f235631a;
        tt5.a.h("OfficeLongPressMenu", "show more sub menu. activeSubMenuState=" + this.f235628h);
        com.bytedance.ee.bear.office.common.screenmenu.j r110 = this.f235624d;
        if (r110 == null) goto L33;
        r110.t(r100, r109);
        return;
    L33:
        return;
    L17:
        if (Intrinsics.areEqual(this.f235628h, a.c.f235631a) == false) goto L22;
        this.f235628h = null;
        com.bytedance.ee.bear.office.common.screenmenu.j r111 = this.f235624d;
        if (r111 == null) goto L32;
        r111.q();
        return;
    L32:
        return;
    L22:
        com.bytedance.ee.bear.office.common.screenmenu.j r112 = this.f235624d;
        if (r112 == null) goto L25;
        r112.q();
        goto L25
    }

    public final View d(com.bytedance.ee.bear.office.list.menuconfig.a r210, List<com.bytedance.ee.bear.office.list.menuconfig.a> r211, final a0 r212, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r213) {
        Integer r100 = null;
        if (r211.isEmpty() == false) goto L6;
        tt5.a.h("OfficeLongPressMenu", "skip configured sub menu because children empty. parent=" + C(r210, null));
        return null;
    L6:
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r110 = v(r211, false);
        if (((ArrayList) r110).isEmpty() == false) goto L10;
        tt5.a.h("OfficeLongPressMenu", "skip configured sub menu because sanitized children empty. parent=" + C(r210, null));
        return null;
    L10:
        tt5.a.h("OfficeLongPressMenu", "configured sub menu built. parent=" + C(r210, null) + ", children=" + CollectionsKt.joinToString$default(r110, com.alipay.sdk.m.u.i.f25853b, "[", "]", 0, null, new OfficeListLongPressActionController$toConfiguredLogString$1(this), 24, null));
        List r111 = CollectionsKt.createListBuilder();
        String r101 = r210.f235930c;
        Integer r102 = Integer.valueOf(r210.f235931d);
        if (l(r102.intValue()) == false) goto L13;
        r100 = r102;
    L13:
        if (r100 == null) goto L15;
        int r103 = r100.intValue();
    L16:
        r111.add(r(this, 30000, r101, Integer.valueOf(r103), Integer.valueOf(R.drawable.dbx_ic_arrow_up), r210.f235934g, false, false, false, null, false, r210, 992));
        r111.add(q(220));
        r111.addAll(E(r110, 40000, 220));
        List r104 = CollectionsKt.build(r111);
        CommonMenu r105 = s(220);
        r105.f(r104, new OfficeListLongPressActionController$buildConfiguredSubMenuView$1(this, r213, r212));
        return r105.j();
    L15:
        r103 = R.drawable.office_ic_screen_menu_more;
        goto L16
    }

    public static void o(String r100, View r101, Integer r102, int r103, Fragment r104) {
        tt5.a.h("OfficeLongPressMenu", "skip long press menu show. reason=" + r100 + ", " + g(r101, r102, r103, r104));
    }

    public final CommonMenu e(a0 r110, c0 r111, OfficeListSortFilterScene r112, o r210, Function1<? super fk5.a, Unit> r211) {
        CommonMenu r100 = s(200);
        List<b0> r101 = r111.c(r110);
        m("main_rules", r101);
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L10;
        Object r105 = r103.next();
        if (((b0) r105).f235727e == OfficeLongPressMenuItemState.HIDDEN) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L3;
        r102.add(r105);
        goto L3
    L10:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L12:
        if (r107.hasNext() == false) goto L58;
        Object r108 = r107.next();
        b0 r109 = (b0) r108;
        OfficeLongPressMenuAction r113 = r109.f235723a;
        int[] r114 = g.f235645a;
        int r115 = r114[r113.ordinal()];
        if (r115 == 1) goto L25;
        if (r115 != 2) goto L32;
        if (r112 != null) goto L19;
    L21:
        boolean r116 = false;
    L22:
        if (r116 == false) goto L33;
        if (r210 != null) goto L32;
    L33:
        boolean r117 = false;
    L34:
        if (r117 == true) goto L56;
        StringBuilder r118 = new StringBuilder("drop default main menu item. stage=capability_filter, ");
        Boolean r119 = null;
        r118.append(G(r109, null));
        r118.append(", reason=");
        int r120 = r114[r109.f235723a.ordinal()];
        if (r120 == 1) goto L47;
        if (r120 == 2) goto L39;
        String r121 = "capability_missing";
    L55:
        r118.append(r121);
        tt5.a.h("OfficeLongPressMenu", r118.toString());
        goto L56
    L39:
        StringBuilder r122 = new StringBuilder("filter_capability_missing(sceneCanFilter=");
        if (r112 == null) goto L42;
        r119 = Boolean.valueOf(!r112.f235662d.isEmpty());
    L42:
        r122.append(r119);
        r122.append(",hasAction=");
        if (r210 == null) goto L45;
        boolean r123 = true;
    L46:
        r122.append(r123);
        r122.append(')');
        r121 = r122.toString();
        goto L55
    L45:
        r123 = false;
        goto L46
    L47:
        StringBuilder r124 = new StringBuilder("sort_capability_missing(sceneCanSort=");
        if (r112 == null) goto L50;
        r119 = Boolean.valueOf(r112.a());
    L50:
        r124.append(r119);
        r124.append(",hasAction=");
        if (r210 == null) goto L53;
        boolean r125 = true;
    L54:
        r124.append(r125);
        r124.append(')');
        r121 = r124.toString();
        goto L55
    L53:
        r125 = false;
    L56:
        if (r117 == false) goto L12;
        r106.add(r108);
        goto L12
    L19:
        if ((!r112.f235662d.isEmpty()) != true) goto L21;
        r116 = true;
    L32:
        r117 = true;
        goto L34
    L25:
        if (r112 != null) goto L27;
    L29:
        boolean r126 = false;
    L30:
        if (r126 == false) goto L33;
        if (r210 == null) goto L33;
    L27:
        if (r112.a() != true) goto L29;
        r126 = true;
        goto L30
    L58:
        tt5.a.h("OfficeLongPressMenu", "default main menu specs built. specs=" + CollectionsKt.joinToString$default(r106, com.alipay.sdk.m.u.i.f25853b, "[", "]", 0, null, new OfficeListLongPressActionController$toSpecLogString$1(this), 24, null));
        r100.f(F(r106), r211);
        return r100;
    }

    public static /* synthetic */ void p(OfficeListLongPressActionController r100, String r101, View r102, Integer r103, Fragment r104, int r105) {
        if ((r105 & 8) == 0) goto L5;
        int r106 = -1;
    L7:
        if ((r105 & 16) == 0) goto L9;
        r104 = r100.f235622b.invoke();
    L9:
        r100.getClass();
        o(r101, r102, r103, r106, r104);
        return;
    L5:
        r106 = 0;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.bytedance.ee.bear.office.common.screenmenu.CommonMenu] */
    public final CommonMenu c(List<com.bytedance.ee.bear.office.list.menuconfig.a> r210, final a0 r211, final c0 r212, final OfficeListSortFilterScene r213, final o r214, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r215, final Function0<Unit> r216) {
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r100 = v(r210, true);
        tt5.a.h("OfficeLongPressMenu", "configured long press menu sanitized. originalSize=" + r210.size() + ", sanitizedSize=" + ((ArrayList) r100).size() + ", items=" + CollectionsKt.joinToString$default(r100, com.alipay.sdk.m.u.i.f25853b, "[", "]", 0, null, new OfficeListLongPressActionController$toConfiguredLogString$1(this), 24, null));
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        ?? r111 = s(200);
        r111.f(E(r100, 20000, 200), new OfficeListLongPressActionController$buildConfiguredMainMenu$1(this, r110, r211, r215, r212, r213, r214, r216));
        r110.element = r111;
        return r111;
    }

    public static final void a(final OfficeListLongPressActionController r100, fk5.a r101, CommonMenu r102, final a0 r103, c0 r104, OfficeListSortFilterScene r105, o r106, final Function2 r110, Function0 r111) {
        r100.getClass();
        if ((r101 instanceof com.bytedance.ee.bear.office.common.screenmenu.e) == false) goto L5;
        com.bytedance.ee.bear.office.common.screenmenu.e r107 = (com.bytedance.ee.bear.office.common.screenmenu.e) r101;
    L6:
        if (r107 == null) goto L8;
        Object r108 = r107.f235214k;
    L10:
        if ((r108 instanceof b0) == false) goto L12;
        final b0 r109 = (b0) r108;
    L13:
        if (r109 == null) goto L51;
        tt5.a.h("OfficeLongPressMenu", "main menu item clicked. " + G(r109, null));
        if (r100.k(r109) == false) goto L19;
        return;
    L19:
        switch(g.f235645a[r109.f235723a.ordinal()]) {
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
        r100.A(r102, r103, r104, r110);
        return;
    L30:
        r100.u(x(r109.f235723a), new OfficeListLongPressActionController$handleMainMenuClick$1(r110, r109, r103));
        return;
    L31:
        if (r105 == null) goto L45;
        if (r106 == null) goto L46;
        r100.y(r102, r105, r106);
        return;
    L46:
        return;
    L45:
        return;
    L34:
        if (r105 == null) goto L48;
        if (r106 == null) goto L49;
        r100.B(r102, r105, r106);
        return;
    L49:
        return;
    L48:
        return;
    L37:
        r100.u(x(r109.f235723a), new OfficeListLongPressActionController$handleMainMenuClick$5(r110, r109, r103));
        return;
    L22:
        if (r100.f235623c == null) goto L24;
        r100.u(false, new OfficeListLongPressActionController$handleMainMenuClick$3(r100));
        return;
    L24:
        r100.u(false, new OfficeListLongPressActionController$handleMainMenuClick$4(r110, r109, r103));
        return;
    L27:
        if (r103.f235716i == false) goto L29;
        r100.u(false, r111);
        return;
    L29:
        r100.u(false, new OfficeListLongPressActionController$handleMainMenuClick$2(r110, r109, r103));
        return;
    L51:
        return;
    L12:
        r109 = null;
        goto L13
    L8:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    public final void w(String r110, View r111, a0 r112, c0 r113, OfficeListSortFilterScene r210, o r211, List<com.bytedance.ee.bear.office.list.menuconfig.a> r212, Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r213, Function0<Unit> r214, Function0<Unit> r215) {
        StringBuilder r100 = new StringBuilder("schedule long press menu retry. reason=");
        r100.append(r110);
        r100.append(", ");
        if (r212 == null) goto L5;
        Integer r101 = Integer.valueOf(r212.size());
    L6:
        r100.append(h(this, r111, r101));
        tt5.a.h("OfficeLongPressMenu", r100.toString());
        r111.postDelayed(new h(r110, this, r111, r212, r112, r113, r210, r211, r213, r214, r215), 80);
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(final View r110, final a0 r210, final c0 r211, final OfficeListSortFilterScene r212, final o r213, final List<com.bytedance.ee.bear.office.list.menuconfig.a> r214, final Function2<? super OfficeLongPressMenuAction, ? super a0, ? extends OfficeSpaceActionResult> r215, final Function0<Unit> r216, final Function0<Unit> r217, boolean r218) {
        StringBuilder r100 = new StringBuilder("enter long press menu show. allowRetry=");
        r100.append(r218);
        r100.append(", useConfiguredMenu=");
        if (r214 == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(", ");
        if (r214 == null) goto L9;
        Integer r102 = Integer.valueOf(r214.size());
    L10:
        r100.append(h(this, r110, r102));
        tt5.a.h("OfficeLongPressMenu", r100.toString());
        if (r110.isAttachedToWindow() == false) goto L164;
        if (r110.getWidth() <= 0) goto L164;
        if (r110.getHeight() <= 0) goto L164;
        Fragment r103 = this.f235622b.invoke();
        if (r103 != null) goto L20;
    L24:
        boolean r104 = false;
    L25:
        if (r104 == true) goto L27;
        if (r214 == null) goto L36;
        Integer r105 = Integer.valueOf(r214.size());
    L37:
        com.bytedance.ee.bear.office.common.screenmenu.j r106 = this.f235624d;
        if (r106 != null) goto L40;
        r106 = new com.bytedance.ee.bear.office.common.screenmenu.j();
        this.f235624d = r106;
    L40:
        if (r103 != null) goto L42;
        Fragment r219 = r103;
        String r111 = "OfficeLongPressMenu";
        Context r107 = r110.getContext();
    L50:
        if ((r107 instanceof ContextWrapper) == false) goto L55;
        if ((r107 instanceof FragmentActivity) == true) goto L53;
        r107 = ((ContextWrapper) r107).getBaseContext();
        goto L50
    L53:
        FragmentActivity r108 = (FragmentActivity) r107;
    L56:
        if (r108 != null) goto L65;
        Context r109 = this.f235621a;
    L59:
        if ((r109 instanceof ContextWrapper) == false) goto L64;
        if ((r109 instanceof FragmentActivity) == true) goto L62;
        r109 = ((ContextWrapper) r109).getBaseContext();
        goto L59
    L62:
        r108 = (FragmentActivity) r109;
        goto L65
    L64:
        r108 = null;
    L65:
        if (r108 != null) goto L68;
        p(this, "ensure_activity_missing", r110, r105, null, 24);
    L75:
        com.bytedance.ee.bear.office.common.screenmenu.j r112 = null;
    L76:
        if (r112 != null) goto L79;
        return;
    L79:
        if (this.f235625e == r210.f235721n) goto L81;
        t();
    L81:
        this.f235628h = null;
        this.f235625e = r210.f235721n;
        if (r214 == null) goto L84;
        boolean r113 = true;
    L85:
        com.bytedance.ee.bear.office.common.screenmenu.j r114 = r112;
        boolean r115 = r113;
        String r116 = r111;
        this.f235626f = new f(r110, r210, r211, r212, r213, r115, r215, r216);
        Function0<Unit> r117 = new OfficeListLongPressActionController$showInternal$1(this, r110, r214, r217);
        r114.f235234g = r117;
        ScreenMenuLayout r118 = r114.f235228a;
        if (r118 == null) goto L88;
        r118.setOnDismissListener(r117);
    L88:
        final Ref.ObjectRef r119 = new Ref.ObjectRef();
        if (r214 != null) goto L91;
        T r120 = e(r210, r211, r212, r213, new OfficeListLongPressActionController$showInternal$2(this, r119, r210, r211, r212, r213, r215, r216));
    L92:
        r119.element = r120;
        if (r214 == null) goto L95;
        boolean r121 = true;
    L96:
        StringBuilder r122 = new StringBuilder("parentMenuChildCount=");
        T r123 = r119.element;
        if (r123 != 0) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r124 = null;
    L100:
        r122.append(r124.getChildCount());
        n("parent_built", r121, r122.toString());
        StringBuilder r125 = new StringBuilder("built long press parent menu. childCount=");
        T r126 = r119.element;
        if (r126 != 0) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r127 = null;
    L104:
        r125.append(r127.getChildCount());
        r125.append(", useConfiguredMenu=");
        if (r214 == null) goto L107;
        boolean r128 = true;
    L108:
        r125.append(r128);
        r125.append(", ");
        if (r214 == null) goto L111;
        Integer r129 = Integer.valueOf(r214.size());
    L112:
        T r130 = r119.element;
        if (r130 != 0) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r131 = null;
    L116:
        Fragment r132 = r219;
        r125.append(g(r110, r129, r131.getChildCount(), r132));
        tt5.a.h(r116, r125.toString());
        T r133 = r119.element;
        if (r133 != 0) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r134 = null;
    L121:
        if (r134.getChildCount() != 0) goto L131;
        if (r214 == null) goto L124;
        Integer r135 = Integer.valueOf(r214.size());
    L125:
        T r136 = r119.element;
        if (r136 != 0) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r137 = null;
    L129:
        o("empty_parent_menu", r110, r135, r137.getChildCount(), r132);
        t();
        return;
    L128:
        r137 = (CommonMenu) r136;
        goto L129
    L124:
        r135 = null;
        goto L125
    L131:
        StringBuilder r138 = new StringBuilder("call screen menu show. ");
        if (r214 == null) goto L134;
        Integer r139 = Integer.valueOf(r214.size());
    L135:
        T r140 = r119.element;
        if (r140 != 0) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r141 = null;
    L139:
        r138.append(g(r110, r139, r141.getChildCount(), r132));
        tt5.a.h(r116, r138.toString());
        com.bytedance.ee.bear.office.common.screenmenu.u r142 = com.bytedance.ee.bear.office.common.screenmenu.u.f235255e;
        Function0<View> r143 = new OfficeListLongPressActionController$showInternal$3(this, r119);
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r142, "presentation");
        Intrinsics.checkNotNullParameter(r143, "menuViewHolder");
        ScreenMenu$addOnBackPressed$1 r144 = r114.f235233f;
        if (r144 == null) goto L142;
        r144.setEnabled(true);
    L142:
        r114.i();
        StringBuilder r145 = new StringBuilder("show screen menu with holder. presentation=");
        r145.append(r142);
        r145.append(", layoutReady=");
        if (r114.f235228a == null) goto L145;
        boolean r146 = true;
    L146:
        r145.append(r146);
        r145.append(", ");
        r145.append(r114.b(r110));
        tt5.a.h("ScreenMenu", r145.toString());
        ScreenMenuLayout r147 = r114.f235228a;
        if (r147 == null) goto L152;
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r142, "presentation");
        Intrinsics.checkNotNullParameter(r143, "menuViewHolder");
        StringBuilder r148 = new StringBuilder("layout show with holder start. presentation=");
        r148.append(r142);
        r148.append(", ");
        CommonMenu r149 = null;
        r148.append(r147.g(r110, null));
        tt5.a.h("ScreenMenuLayout", r148.toString());
        r147.f235185l = false;
        r147.f235186m = false;
        r147.f235187n = SystemClock.uptimeMillis();
        r147.bringToFront();
        r147.removeAllViews();
        r147.f(r142);
        if (r142.f235258b == false) goto L151;
        r147.d(r110);
    L151:
        View r150 = r143.invoke();
        r147.f235175b = r110;
        r147.f235176c = r150;
        r147.f235177d = r110;
        r147.f235178e = r150;
        r147.m(r110, r150);
        r147.setVisibility(0);
        tt5.a.h("ScreenMenuLayout", "layout show with holder visible. menuChildCount=" + r147.getChildCount() + ", " + r147.g(r110, r150));
        OneShotPreDrawListener.add(r147, new com.bytedance.ee.bear.office.common.screenmenu.q(r147, r147));
    L153:
        StringBuilder r151 = new StringBuilder("screen menu show returned. isVisible=");
        r151.append(r114.m());
        r151.append(", ");
        if (r214 == null) goto L156;
        Integer r152 = Integer.valueOf(r214.size());
    L157:
        T r153 = r119.element;
        if (r153 != 0) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
    L161:
        r151.append(g(r110, r152, r149.getChildCount(), r132));
        tt5.a.h(r116, r151.toString());
        return;
    L160:
        r149 = (CommonMenu) r153;
        goto L161
    L156:
        r152 = r149;
        goto L157
    L152:
        r149 = null;
        goto L153
    L145:
        r146 = false;
        goto L146
    L138:
        r141 = (CommonMenu) r140;
        goto L139
    L134:
        r139 = null;
        goto L135
    L119:
        r134 = (CommonMenu) r133;
        goto L121
    L115:
        r131 = (CommonMenu) r130;
        goto L116
    L111:
        r129 = null;
        goto L112
    L107:
        r128 = false;
        goto L108
    L103:
        r127 = (CommonMenu) r126;
        goto L104
    L99:
        r124 = (CommonMenu) r123;
        goto L100
    L95:
        r121 = false;
        goto L96
    L91:
        r120 = c(r214, r210, r211, r212, r213, r215, r216);
        goto L92
    L84:
        r113 = false;
        goto L85
    L68:
        if (r108.isFinishing() == false) goto L70;
    L74:
        p(this, "ensure_activity_invalid", r110, r105, null, 24);
        goto L75
    L70:
        if (r108.isDestroyed() == true) goto L74;
        r106.h(r108);
    L73:
        r112 = r106;
        goto L76
    L55:
        r108 = null;
        goto L56
    L42:
        if (r103.isAdded() == true) goto L44;
    L47:
        r219 = r103;
        r111 = "OfficeLongPressMenu";
        p(this, "ensure_fragment_not_resumed", r110, r105, r103, 8);
        goto L75
    L44:
        if (r103.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L47;
        r106.g(r103);
        r219 = r103;
        r111 = "OfficeLongPressMenu";
        goto L73
    L36:
        r105 = null;
        goto L37
    L27:
        if (r214 == null) goto L29;
        Integer r154 = Integer.valueOf(r214.size());
    L30:
        p(this, "fragment_not_resumed", r110, r154, r103, 8);
        if (r218 == false) goto L175;
        w("fragment_not_resumed", r110, r210, r211, r212, r213, r214, r215, r216, r217);
        return;
    L175:
        return;
    L29:
        r154 = null;
        goto L30
    L20:
        if (r103.isAdded() == true) goto L22;
    L23:
        r104 = true;
        goto L25
    L22:
        if (r103.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L24;
    L164:
        if (r214 == null) goto L166;
        Integer r155 = Integer.valueOf(r214.size());
    L167:
        p(this, "anchor_not_ready", r110, r155, null, 24);
        if (r218 == false) goto L176;
        w("anchor_not_ready", r110, r210, r211, r212, r213, r214, r215, r216, r217);
        return;
    L176:
        return;
    L166:
        r155 = null;
        goto L167
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public static com.bytedance.ee.bear.office.common.screenmenu.e r(OfficeListLongPressActionController r110, int r210, String r211, Integer r212, Integer r213, Integer r214, boolean r215, boolean r216, boolean r217, String r218, boolean r219, Object r310, int r311) {
        if ((r311 & 8) == 0) goto L5;
        Integer r111 = null;
    L7:
        if ((r311 & 16) == 0) goto L9;
        Integer r100 = null;
    L11:
        if ((r311 & 32) == 0) goto L13;
        boolean r112 = false;
    L15:
        if ((r311 & 64) == 0) goto L17;
        boolean r113 = true;
    L19:
        if ((r311 & 128) == 0) goto L21;
        boolean r114 = false;
    L23:
        if ((r311 & 256) == 0) goto L25;
        String r101 = null;
    L27:
        if ((r311 & 512) == 0) goto L29;
        boolean r115 = false;
    L31:
        if ((r311 & 1024) == 0) goto L33;
        Object r116 = null;
    L34:
        r110.getClass();
        return new com.bytedance.ee.bear.office.common.screenmenu.e(r210, r211, r101, r100, r212, false, r115, r111, r114, r116, r113, r112, null, null, 51744);
    L33:
        r116 = r310;
        goto L34
    L29:
        r115 = r219;
        goto L31
    L25:
        r101 = r218;
        goto L27
    L21:
        r114 = r217;
        goto L23
    L17:
        r113 = r216;
        goto L19
    L13:
        r112 = r215;
        goto L15
    L9:
        r100 = r214;
        goto L11
    L5:
        r111 = r213;
        goto L7
    }
}
