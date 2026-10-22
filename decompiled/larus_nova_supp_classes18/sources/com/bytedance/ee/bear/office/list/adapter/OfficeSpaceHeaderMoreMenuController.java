package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadActionType;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.widgets.menuconfig.OfficeSpaceMenuConfigSorter;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSpaceHeaderMoreMenuController {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public final Function0<Fragment> b;
    public com.bytedance.ee.bear.office.common.screenmenu.j c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[OfficeSpaceHeaderAction.SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    static {
    }

    public final boolean h() {
        Fragment r0 = (Fragment) this.b.invoke();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isAdded() == true) goto L8;
        return false;
    L8:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final void k() {
        com.bytedance.ee.bear.office.common.screenmenu.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.n(OfficeSpaceHeaderMoreMenuController$resetMenuLocate$1.INSTANCE);
        return;
    }

    public static String e(View r2) {
        return "attached=" + r2.isAttachedToWindow() + ",size=" + r2.getWidth() + 'x' + r2.getHeight() + ",shown=" + r2.isShown() + ",windowFocus=" + r2.hasWindowFocus();
    }

    public static String g(Fragment r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getClass().getSimpleName());
        r0.append(",added=");
        r0.append(r2.isAdded());
        r0.append(",hasView=");
        if (r2.getView() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(",state=");
        r0.append(r2.getLifecycle().getCurrentState());
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public static boolean q(OfficeListSortFilterScene r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L15;
        OfficeListSortFilterScene.Kind r4 = r3.a;
        if (r4 != OfficeListSortFilterScene.Kind.RECENT) goto L12;
    L13:
        return true;
    L12:
        if (r4 == OfficeListSortFilterScene.Kind.FAVORITE) goto L13;
        return false;
    L15:
        return false;
    L5:
        if ((!r3.d.isEmpty()) != true) goto L7;
        r2 = true;
        goto L8
    }

    public static String r(String r1) {
        if (r1 != null) goto L4;
    L10:
        return "default";
    L4:
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L10;
        String r2 = Integer.valueOf(r1.hashCode()).toString();
        if (r2 == null) goto L10;
        return r2;
    }

    public final Pair<String, String> a(OfficeListSortFilterScene.c r2) {
        if (OfficeSortDirectionSupport.f(r2) == false) goto L6;
        return TuplesKt.to(c(2131889411), c(2131889423));
    L6:
        return TuplesKt.to(c(2131889442), c(2131889444));
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c b(int r8) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, d(8), d(r8), 74);
    }

    public final String c(int r2) {
        return this.a.getString(r2);
    }

    public final int d(int r3) {
        Resources r0 = this.a.getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final CommonMenu j(int r3) {
        CommonMenu r0 = new CommonMenu(this.a);
        com.bytedance.ee.bear.office.common.screenmenu.b.a(r0);
        r0.d(d(r3));
        return r0;
    }

    public final void m(Function0<Unit> r3) {
        k();
        com.bytedance.ee.bear.office.common.screenmenu.j r0 = this.c;
        if (r0 == null) goto L5;
        int r1 = com.bytedance.ee.bear.office.common.screenmenu.j.h;
        r0.f("unknown");
    L5:
        r3.invoke();
    }

    public final String p(OfficeListSortFilterScene.c r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = OfficeListSortFilterScene.e;
        r0.append(OfficeListSortFilterScene.a.f(this.a, r3));
        r0.append(" · ");
        r0.append(OfficeSortDirectionSupport.d(r3));
        return r0.toString();
    }

    public OfficeSpaceHeaderMoreMenuController(Context r2, Function0<? extends Fragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ownerFragmentProvider");
        this.a = r2;
        this.b = r3;
    }

    public static String f(boolean r0, boolean r1, boolean r2, List r3) {
        if (r0 == true) goto L4;
        return "default_no_snapshot";
    L4:
        if (r1 == true) goto L6;
        return "default_no_home_more";
    L6:
        if (r2 == false) goto L8;
        return "home_more_disabled";
    L8:
        if (r3 != null) goto L11;
        return "default_compose_null";
    L11:
        if (r3.isEmpty() == false) goto L14;
        return "home_more_empty";
    L14:
        return "home_more_configured:" + r3.size();
    }

    public final void l(final com.bytedance.ee.bear.office.export.space.i r16, final OfficeSpaceHeaderAction r17, final com.bytedance.ee.bear.office.list.i r18, final OfficeSpaceTab r19) {
        boolean r1 = true;
        boolean r2 = false;
        switch(b.a[r17.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        boolean r0 = false;
    L8:
        Boolean r10 = null;
        if (r0 == false) goto L11;
        i0.a.f(r19, r17, null, false);
    L11:
        final long r5 = System.currentTimeMillis();
        if (r17 == OfficeSpaceHeaderAction.CREATE_DOC) goto L24;
        if (r17 == OfficeSpaceHeaderAction.CREATE_PPT) goto L24;
        if (r17 == OfficeSpaceHeaderAction.CREATE_BITABLE) goto L24;
        if (r17 == OfficeSpaceHeaderAction.CREATE_SHEET) goto L24;
        if (r17 == OfficeSpaceHeaderAction.CREATE_FOLDER) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L27;
        tt5.a.h("OfficeHeaderMoreMenu", "[OfficeCreatePerf] stage=menu_dispatch_start action=" + r17 + " tab=" + r19 + " ts=" + r5);
    L27:
        if (r17 != OfficeSpaceHeaderAction.CREATE_FOLDER) goto L39;
        final Function0<Unit> r13 = new OfficeSpaceHeaderMoreMenuController$runHeaderAction$1(this, r16, r18, r19, r5);
        k();
        StringBuilder r3 = new StringBuilder("[OfficeCreatePerf] stage=menu_close_start action=");
        r3.append(r17);
        r3.append(" tab=");
        r3.append(r19);
        r3.append(" visible=");
        com.bytedance.ee.bear.office.common.screenmenu.j r4 = this.c;
        if (r4 == null) goto L31;
        r10 = Boolean.valueOf(r4.m());
    L31:
        r3.append(r10);
        tt5.a.h("OfficeHeaderMoreMenu", r3.toString());
        com.bytedance.ee.bear.office.common.screenmenu.j r6 = this.c;
        if (r6 != null) goto L37;
        tt5.a.h("OfficeHeaderMoreMenu", "[OfficeCreatePerf] stage=menu_close_complete action=" + r17 + " tab=" + r19 + " reason=menu_missing");
        if (h() == true) goto L36;
        tt5.a.k("OfficeHeaderMoreMenu", "[OfficeCreatePerf] stage=create_folder_skip_after_menu_closed action=" + r17 + " tab=" + r19 + " reason=owner_inactive");
        return;
    L36:
        r13.invoke();
        return;
    L37:
        r6.d("header_more_" + r17, new OfficeSpaceHeaderMoreMenuController$closeMenuAfterDismiss$1(r17, r19, this, r13));
        return;
    L39:
        k();
        com.bytedance.ee.bear.office.common.screenmenu.j r7 = this.c;
        if (r7 == null) goto L42;
        com.bytedance.ee.bear.office.common.screenmenu.j.e(r7, null, 3);
    L42:
        OfficeUploadHeaderAction r8 = OfficeUploadHeaderAction.a;
        if (OfficeUploadHeaderAction.b(r17) == false) goto L58;
        com.bytedance.ee.bear.office.export.space.h r9 = r16.a();
        Intrinsics.checkNotNullParameter(r17, "action");
        Intrinsics.checkNotNullParameter(r18, "capability");
        Intrinsics.checkNotNullParameter(r19, "tab");
        Fragment r11 = r18.a();
        if (r11 == null) goto L51;
        OfficeUploadActionType r12 = OfficeUploadHeaderAction.f(r17);
        if (r12 == null) goto L51;
        com.bytedance.ee.bear.office.common.upload.g0.b r14 = com.bytedance.ee.bear.office.common.upload.g0.b.a;
        r2 = OfficeUploadHeaderAction.e(r11, r17, r14, r9, OfficeUploadHeaderAction.a(r12, r14, r18, r19, false, null));
    L51:
        if (r2 == false) goto L54;
        return;
    L54:
        if (Intrinsics.areEqual(r16.b(r17), OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L56;
        return;
    L56:
        UDToast.a r15 = UDToast.build(this.a);
        r15.g(com.bytedance.ee.bear.more.office.f.c());
        r15.b.d = -1;
        r15.h();
        return;
    L58:
        OfficeSpaceActionResult r20 = r16.b(r17);
        if (r1 == false) goto L62;
        tt5.a.h("OfficeHeaderMoreMenu", "[OfficeCreatePerf] stage=menu_dispatch_result action=" + r17 + " tab=" + r19 + " result=" + r20 + " elapsed=" + (System.currentTimeMillis() - r5));
    L62:
        if (Intrinsics.areEqual(r20, OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L64;
        return;
    L64:
        UDToast.a r21 = UDToast.build(this.a);
        r21.g(com.bytedance.ee.bear.more.office.f.c());
        r21.b.d = -1;
        r21.h();
        return;
    L7:
        r0 = true;
        goto L8
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean n(final View r85, final OfficeSpaceTab r86, final com.bytedance.ee.bear.office.list.i r87, final com.bytedance.ee.bear.office.export.space.i r88, String r89) {
        Intrinsics.checkNotNullParameter(r85, "anchor");
        Intrinsics.checkNotNullParameter(r86, "tab");
        Intrinsics.checkNotNullParameter(r87, "capability");
        Intrinsics.checkNotNullParameter(r88, "dispatcher");
        if (r85.isAttachedToWindow() == true) goto L5;
    L470:
        tt5.a.h("OfficeHeaderMoreMenu", "skip header more menu, anchor invalid, runtime=" + r(r89) + ", tab=" + r86 + ", attached=" + r85.isAttachedToWindow() + ", size=" + r85.getWidth() + 'x' + r85.getHeight());
        return false;
    L5:
        if (r85.getWidth() <= 0) goto L470;
        if (r85.getHeight() <= 0) goto L470;
        Fragment r0 = (Fragment) this.b.invoke();
        if (r0 != null) goto L14;
        tt5.a.h("OfficeHeaderMoreMenu", "skip header more menu, owner missing, runtime=" + r(r89) + ", tab=" + r86);
        return false;
    L14:
        if (r0.isAdded() == true) goto L16;
    L468:
        tt5.a.h("OfficeHeaderMoreMenu", "skip header more menu, owner not resumed, runtime=" + r(r89) + ", tab=" + r86 + ", added=" + r0.isAdded() + ", state=" + r0.getLifecycle().getCurrentState());
        return false;
    L16:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L468;
        final Fragment r7 = r87.a();
        String r6 = ", anchor=";
        if (r7 != null) goto L22;
        tt5.a.h("OfficeHeaderMoreMenu", "skip header more menu, list owner missing, runtime=" + r(r89) + ", tab=" + r86 + ", module=" + r87.a + ", anchor=" + e(r85));
        return false;
    L22:
        int r1 = OfficeListSortFilterScene.e;
        OfficeListSortFilterScene r4 = OfficeListSortFilterScene.a.c(r86, r87.a, r7);
        if (r4 == null) goto L25;
        o r3 = new o(new OfficeSpaceHeaderMoreMenuController$show$sortFilterAction$1$1(r7), r87.c);
    L26:
        f r2 = new f(new OfficeSpaceHeaderMoreMenuController$show$displayModeAction$1(r87));
        com.bytedance.ee.bear.widgets.menuconfig.c r5 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        com.bytedance.ee.bear.widgets.menuconfig.d r8 = com.bytedance.ee.bear.widgets.menuconfig.c.b;
        if (r8 == null) goto L29;
        com.bytedance.ee.bear.widgets.menuconfig.e r19 = r8.a("home_more");
    L30:
        String r20 = ", tab=";
        if (q(r4) == false) goto L34;
        if (r3 == null) goto L34;
        boolean r9 = true;
    L35:
        com.bytedance.ee.bear.widgets.menuconfig.g r21 = com.bytedance.ee.bear.office.list.menuconfig.c.a;
        Context r10 = this.a;
        boolean r22 = t3.a;
        if (r4 == null) goto L40;
        f r23 = r2;
        String r24 = ", module=";
        if (r4.a() != true) goto L41;
        boolean r11 = true;
    L42:
        if (r11 == false) goto L45;
        if (r3 == null) goto L45;
        boolean r12 = true;
    L46:
        Intrinsics.checkNotNullParameter(r10, "context");
        String r26 = "OfficeHeaderMoreMenu";
        Fragment r27 = r7;
        if (r8 == null) goto L51;
        com.bytedance.ee.bear.widgets.menuconfig.e r13 = r8.a("home_more");
        if (r13 == null) goto L51;
        if ((!r13.b) == false) goto L55;
        List r14 = CollectionsKt.emptyList();
        boolean r51 = r9;
    L79:
        if (r4 == null) goto L202;
        com.bytedance.ee.bear.widgets.menuconfig.g r15 = com.bytedance.ee.bear.office.list.menuconfig.c.a;
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r8 == null) goto L85;
        com.bytedance.ee.bear.widgets.menuconfig.e r16 = r8.a("home_sort");
        if (r16 == null) goto L85;
        if ((!r16.b) == false) goto L89;
        List r17 = CollectionsKt.emptyList();
    L201:
        List r18 = r17;
    L203:
        com.bytedance.ee.bear.office.common.screenmenu.j r25 = this.c;
        if (r25 != null) goto L206;
        r25 = new com.bytedance.ee.bear.office.common.screenmenu.j();
        this.c = r25;
    L206:
        com.bytedance.ee.bear.office.common.screenmenu.j r110 = r25;
        r110.g(r0);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        if (r4 == null) goto L256;
        if (r3 == null) goto L256;
        if (r18 != null) goto L212;
        List r28 = OfficeSortDirectionSupport.e(r4);
    L214:
        if (r28.isEmpty() == true) goto L256;
        FolderSortStrategy r29 = r3.c(r4);
        List r30 = r28;
        Iterator r31 = r30.iterator();
    L218:
        if (r31.hasNext() == false) goto L228;
        Object r32 = r31.next();
        OfficeListSortFilterScene.c r33 = (OfficeListSortFilterScene.c) r32;
        if (r29.e == r33.b) goto L222;
    L224:
        boolean r34 = false;
    L225:
        if (r34 == false) goto L218;
    L229:
        OfficeListSortFilterScene.c r35 = (OfficeListSortFilterScene.c) r32;
        if (r35 != null) goto L247;
        Iterator r36 = r30.iterator();
    L233:
        if (r36.hasNext() == false) goto L240;
        Object r37 = r36.next();
        if (r29.e != ((OfficeListSortFilterScene.c) r37).b) goto L237;
        boolean r38 = true;
    L238:
        if (r38 == false) goto L233;
    L241:
        OfficeListSortFilterScene.c r39 = (OfficeListSortFilterScene.c) r37;
        if (r39 == null) goto L244;
        r35 = OfficeListSortFilterScene.c.a(r39, r29.f);
    L245:
        if (r35 != null) goto L247;
        r35 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r28);
        goto L247
    L244:
        r35 = null;
        goto L245
    L237:
        r38 = false;
        goto L238
    L240:
        r37 = null;
    L247:
        if (r35 != null) goto L249;
        r35 = null;
    L252:
        if (r35 == null) goto L254;
        String r40 = p(r35);
    L255:
        if (r40 == null) goto L256;
    L257:
        String r112 = r40;
        if (r14 != null) goto L260;
        o r210 = r3;
        CommonMenu r113 = null;
        OfficeUploadHeaderAction r41 = OfficeUploadHeaderAction.a;
        p0 r42 = OfficeUploadHeaderAction.d(OfficeSpaceHeaderAction.UPLOAD_IMAGE, r86, r87);
        p0 r43 = OfficeUploadHeaderAction.d(OfficeSpaceHeaderAction.UPLOAD_FILE, r86, r87);
        List r44 = CollectionsKt.createListBuilder();
        OfficeSpaceTab r114 = r86;
        r44.add(i(this, 1, c(2131889438), 2131233748, null, null, false, null, false, false, 504));
        r44.add(i(this, 2, c(2131889441), 2131233747, null, null, false, null, false, false, 504));
        r44.add(i(this, 12, c(2131887432), 2131254406, null, null, false, null, false, false, 504));
        r44.add(i(this, 11, c(2131889440), 2131233749, null, null, false, null, false, false, 504));
        e.a.getClass();
        if (e.a(r114, r87, false) == false) goto L330;
        r44.add(i(this, 3, c(2131889439), 2131233751, null, null, false, null, false, false, 504));
    L330:
        if (r42.a == false) goto L332;
    L335:
        r44.add(b(240));
        if (r42.a == false) goto L340;
        String r45 = c(2131889457);
        boolean r46 = r42.b;
        r44.add(i(this, 4, r45, 2131233754, null, null, false, null, r46, !r46, 120));
    L340:
        if (r10.a == false) goto L342;
        String r47 = c(2131889456);
        boolean r48 = r43.b;
        r44.add(i(this, 5, r47, 2131233745, null, null, false, null, r48, !r48, 120));
    L342:
        int r115 = 240;
        r44.add(b(240));
        r44.add(b(240));
        String r49 = c(2131889429);
        if (t3.a == true) goto L345;
        Integer r50 = 2131233736;
    L346:
        r44.add(i(this, 7, r49, 2131233740, r50, null, false, null, false, false, 496));
        String r52 = c(2131889428);
        if (t3.a == false) goto L349;
        Integer r53 = 2131233736;
    L350:
        r44.add(i(this, 8, r52, 2131233753, r53, null, false, null, false, false, 496));
        OfficeListSortFilterScene r116 = r4;
        if (r116 != null) goto L353;
    L355:
        boolean r54 = false;
    L356:
        if (r54 == false) goto L358;
    L359:
        if (r210 == null) goto L361;
        r44.add(b(240));
    L361:
        if (r116 != null) goto L363;
    L365:
        boolean r55 = false;
    L366:
        if (r55 == false) goto L371;
        if (r210 == null) goto L371;
        r44.add(i(this, 9, c(2131889454), 2131233735, 2131244677, r112, false, null, false, false, 480));
    L371:
        if (q(r116) == false) goto L374;
        if (r210 == null) goto L374;
        r44.add(i(this, 10, c(2131889427), 2131233750, 2131244677, null, false, null, false, false, 496));
    L374:
        List r56 = CollectionsKt.build(r44);
    L262:
        List r117 = r56;
    L376:
        if (r117.isEmpty() == false) goto L440;
        StringBuilder r57 = new StringBuilder("skip header more menu, main items empty, runtime=");
        r57.append(r(r89));
        r57.append(r20);
        r57.append(r114);
        r57.append(", configState=");
        com.bytedance.ee.bear.widgets.menuconfig.e r58 = r19;
        if (r8 == null) goto L380;
        boolean r59 = true;
    L381:
        if (r58 == null) goto L383;
        boolean r60 = true;
    L384:
        if (r58 != null) goto L386;
    L388:
        boolean r61 = false;
    L389:
        r57.append(f(r59, r60, r61, r14));
        r57.append(", availability=");
        if (r14 != 0) goto L393;
        String r62 = "default_menu";
    L395:
        boolean r63 = false;
    L428:
        r57.append(r62);
        r57.append(", scene=");
        if (r116 == null) goto L431;
        Object r64 = r116.a;
    L432:
        r57.append(r64);
        r57.append(r24);
        r57.append(r87.a);
        r57.append(", canSort=");
        if (r116 != null) goto L435;
    L437:
        boolean r65 = false;
    L438:
        r57.append(r65);
        r57.append(", canFilter=");
        r57.append(r51);
        r57.append(", listOwner=");
        r57.append(g(r27));
        r57.append(r6);
        r57.append(e(r85));
        tt5.a.h(r26, r57.toString());
        return r63;
    L435:
        if (r116.a() != true) goto L437;
        r65 = true;
        goto L438
    L431:
        r64 = r113;
        goto L432
    L393:
        if (r14.isEmpty() == false) goto L396;
        r62 = "configured_empty";
        goto L395
    L396:
        ArrayList r66 = new ArrayList();
        Iterator r67 = r14.iterator();
    L398:
        if (r67.hasNext() == false) goto L421;
        com.bytedance.ee.bear.office.list.menuconfig.b r68 = (com.bytedance.ee.bear.office.list.menuconfig.b) r67.next();
        if (r68.e != OfficeSpaceHeaderAction.CREATE_FOLDER) goto L404;
        e.a.getClass();
        com.bytedance.ee.bear.office.list.i r69 = r87;
        if (e.a(r114, r69, false) == true) goto L405;
        Object r70 = r68.a.a + ":create_folder_unavailable";
    L419:
        if (r70 == null) goto L398;
        r66.add(r70);
    L405:
        OfficeSpaceHeaderAction r71 = r68.e;
        if (r71 == null) goto L410;
        OfficeUploadHeaderAction r72 = OfficeUploadHeaderAction.a;
        if (OfficeUploadHeaderAction.b(r71) != true) goto L410;
        boolean r73 = true;
    L411:
        if (r73 == false) goto L418;
        OfficeSpaceHeaderAction r74 = r68.e;
        if (r74 == null) goto L418;
        if (OfficeUploadHeaderAction.d(r74, r114, r69).a == true) goto L418;
        r70 = r68.a.a + ":upload_unavailable";
    L418:
        r70 = r113;
    L410:
        r73 = false;
        goto L411
    L404:
        r69 = r87;
        goto L405
    L421:
        r63 = false;
        StringBuilder r75 = new StringBuilder("configured=");
        r75.append(r14.size());
        r75.append(", filtered=");
        r75.append(r14.size() - r66.size());
        r75.append(", unavailable=");
        String r76 = CollectionsKt.joinToString$default(r66, "|", null, null, 0, null, null, 62, null);
        if (r76.length() != 0) goto L424;
        boolean r77 = true;
    L425:
        if (r77 == false) goto L427;
        r76 = "none";
    L427:
        r75.append(r76);
        r62 = r75.toString();
        goto L428
    L424:
        r77 = false;
        goto L425
    L386:
        if ((!r58.b) != true) goto L388;
        r61 = true;
        goto L389
    L383:
        r60 = false;
        goto L384
    L380:
        r59 = false;
        goto L381
    L440:
        List r78 = r14;
        com.bytedance.ee.bear.widgets.menuconfig.e r79 = r19;
        String r80 = r24;
        boolean r81 = r51;
        String r82 = r6;
        String r83 = r26;
        String r84 = r20;
        CommonMenu r118 = j(r115);
        final Ref.ObjectRef r90 = r111;
        final OfficeListSortFilterScene r91 = r116;
        final o r92 = r210;
        OfficeListSortFilterScene r610 = r116;
        final f r93 = r23;
        final List r94 = r18;
        r118.f(r117, new OfficeSpaceHeaderMoreMenuController$show$1(this, r90, r91, r92, r93, r88, r87, r86, r94));
        Ref.ObjectRef r95 = r111;
        r95.element = r118;
        com.bytedance.ee.bear.office.common.screenmenu.j r96 = r110;
        r96.n(new OfficeSpaceHeaderMoreMenuController$show$2(this, r85));
        Object r97 = r95.element;
        if (r97 != null) goto L443;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
        CommonMenu r98 = r113;
    L444:
        r96.s(r85, r98.j(), com.bytedance.ee.bear.office.common.screenmenu.u.f);
        StringBuilder r99 = new StringBuilder("show header more menu success, runtime=");
        r99.append(r(r89));
        r99.append(r84);
        r99.append(r114);
        r99.append(", itemCount=");
        r99.append(r117.size());
        r99.append(", configState=");
        if (r8 == null) goto L447;
        boolean r100 = true;
    L448:
        if (r79 == null) goto L450;
        boolean r101 = true;
    L451:
        if (r79 != null) goto L453;
    L455:
        boolean r102 = false;
    L456:
        r99.append(f(r100, r101, r102, r78));
        r99.append(", scene=");
        if (r610 == null) goto L459;
        OfficeListSortFilterScene r103 = r610;
        Object r104 = r103.a;
    L460:
        r99.append(r104);
        r99.append(r80);
        r99.append(r87.a);
        r99.append(", canSort=");
        if (r103 != null) goto L463;
    L465:
        boolean r105 = false;
    L466:
        r99.append(r105);
        r99.append(", canFilter=");
        r99.append(r81);
        r99.append(", listOwner=");
        r99.append(g(r27));
        r99.append(r82);
        r99.append(e(r85));
        tt5.a.h(r83, r99.toString());
        return true;
    L463:
        if (r103.a() != true) goto L465;
        r105 = true;
        goto L466
    L459:
        r103 = r610;
        r104 = r113;
        goto L460
    L453:
        if ((!r79.b) != true) goto L455;
        r102 = true;
        goto L456
    L450:
        r101 = false;
        goto L451
    L447:
        r100 = false;
        goto L448
    L443:
        r98 = (CommonMenu) r97;
        goto L444
    L363:
        if (r116.a() != true) goto L365;
        r55 = true;
        goto L366
    L358:
        if (q(r116) == false) goto L361;
    L353:
        if (r116.a() != true) goto L355;
        r54 = true;
        goto L356
    L349:
        r53 = null;
        goto L350
    L345:
        r50 = null;
        goto L346
    L332:
        if (r43.a == true) goto L335;
        r14 = r14;
        goto L342
    L260:
        if (r14.isEmpty() == false) goto L263;
        r56 = CollectionsKt.emptyList();
        r210 = r3;
        r116 = r4;
        r14 = r14;
        r115 = 240;
        r113 = null;
        r114 = r86;
        goto L262
    L263:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r14.iterator();
    L265:
        if (r107.hasNext() == false) goto L275;
        Object r108 = r107.next();
        if (((com.bytedance.ee.bear.office.list.menuconfig.b) r108).e != OfficeSpaceHeaderAction.CREATE_FOLDER) goto L272;
        e.a.getClass();
        if (e.a(r86, r87, false) == true) goto L272;
        boolean r119 = true;
    L273:
        if (r119 == true) goto L265;
        r106.add(r108);
    L272:
        r119 = false;
        goto L273
    L275:
        OfficeSpaceTab r109 = r86;
        com.bytedance.ee.bear.office.list.i r120 = r87;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r106.iterator();
    L277:
        if (r122.hasNext() == false) goto L293;
        Object r123 = r122.next();
        OfficeSpaceHeaderAction r124 = ((com.bytedance.ee.bear.office.list.menuconfig.b) r123).e;
        if (r124 == null) goto L283;
        OfficeUploadHeaderAction r211 = OfficeUploadHeaderAction.a;
        com.bytedance.ee.bear.widgets.menuconfig.d r212 = r8;
        if (OfficeUploadHeaderAction.b(r124) != true) goto L284;
        boolean r125 = true;
    L285:
        if (r125 == true) goto L287;
    L289:
        boolean r126 = false;
    L290:
        if (r126 == true) goto L292;
        r121.add(r123);
    L292:
        r8 = r212;
        goto L277
    L287:
        if (OfficeUploadHeaderAction.d(r124, r109, r120).a == true) goto L289;
        r126 = true;
    L284:
        r125 = false;
        goto L285
    L283:
        r212 = r8;
        goto L284
    L293:
        r8 = r8;
        List r127 = CollectionsKt.createListBuilder();
        Iterator r213 = r121.iterator();
        int r128 = 0;
        String r129 = null;
    L295:
        if (r213.hasNext() == false) goto L325;
        Object r130 = r213.next();
        int r214 = r128 + 1;
        if (r128 >= 0) goto L299;
        CollectionsKt.throwIndexOverflow();
    L299:
        com.bytedance.ee.bear.office.list.menuconfig.b r131 = (com.bytedance.ee.bear.office.list.menuconfig.b) r130;
        String r132 = r131.a.c;
        OfficeSpaceHeaderAction r133 = r131.e;
        if (r133 == null) goto L307;
        OfficeUploadHeaderAction r310 = OfficeUploadHeaderAction.a;
        if (OfficeUploadHeaderAction.b(r133) == true) goto L305;
        r133 = null;
    L305:
        if (r133 == null) goto L307;
        p0 r134 = OfficeUploadHeaderAction.d(r133, r109, r120);
    L308:
        if (r128 <= 0) goto L313;
        if (Intrinsics.areEqual(r132, r129) == true) goto L313;
        r127.add(b(240));
    L313:
        int r135 = r131.b;
        o r215 = r3;
        String r136 = r131.c;
        Integer r311 = Integer.valueOf(r131.d);
        Integer r137 = r131.f;
        if (r131.b != 9) goto L316;
        String r312 = r112;
    L317:
        com.bytedance.ee.bear.widgets.menuconfig.g r138 = r131.a;
        if (r134 == null) goto L320;
        boolean r313 = r134.b;
    L321:
        if (r134 == null) goto L323;
        boolean r314 = !r134.b;
    L324:
        List r710 = r127;
        r710.add(i(this, r135, r136, r311, r137, r312, false, r138, r313, r314, 32));
        r109 = r86;
        r120 = r87;
        r127 = r710;
        r129 = r132;
        r110 = r110;
        r3 = r215;
        r111 = r111;
        r128 = r214;
        r4 = r4;
        r24 = r24;
        r6 = r6;
        r26 = r26;
        r20 = r20;
        goto L295
    L323:
        r314 = false;
        goto L324
    L320:
        r313 = true;
        goto L321
    L316:
        r312 = null;
    L307:
        r134 = null;
        goto L308
    L325:
        r210 = r3;
        r6 = r6;
        r20 = r20;
        r24 = r24;
        r26 = r26;
        r27 = r27;
        r51 = r51;
        r113 = null;
        r111 = r111;
        r110 = r110;
        r117 = CollectionsKt.build(r127);
        r14 = r14;
        r18 = r18;
        r116 = r4;
        r115 = 240;
        r114 = r86;
        goto L376
    L254:
        r40 = null;
        goto L255
    L249:
        if (r4.a != OfficeListSortFilterScene.Kind.RECENT) goto L252;
        int r139 = OfficeSortDirectionSupport.a;
        r35 = OfficeSortDirectionSupport.g(r35, OfficeSortDirectionSupport.DirectionSlot.FIRST);
        goto L252
    L222:
        if (r29.f != r33.c) goto L224;
        r34 = true;
        goto L225
    L228:
        r32 = null;
        goto L229
    L212:
        r28 = r18;
    L256:
        r40 = "";
        goto L257
    L89:
        List r140 = OfficeSpaceMenuConfigSorter.a(r16);
        ArrayList r141 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r142 = r140.iterator();
    L91:
        if (r142.hasNext() == false) goto L94;
        r141.add(((com.bytedance.ee.bear.widgets.menuconfig.g) r142.next()).a);
        goto L91
    L94:
        if (r141.isEmpty() == false) goto L97;
        r17 = CollectionsKt.emptyList();
        goto L201
    L97:
        List r143 = CollectionsKt.toMutableList(OfficeSortDirectionSupport.e(r4));
        ArrayList r144 = new ArrayList();
        Iterator r145 = r141.iterator();
    L99:
        if (r145.hasNext() == false) goto L182;
        String r146 = (String) r145.next();
        com.bytedance.ee.bear.widgets.menuconfig.g r147 = com.bytedance.ee.bear.office.list.menuconfig.c.a;
        if (r143.isEmpty() == false) goto L104;
        OfficeListSortFilterScene.c r148 = null;
    L165:
        OfficeListSortFilterScene.c r149 = r148;
        int r150 = 2;
    L171:
        if (r149 != null) goto L173;
        r149 = null;
    L179:
        if (r149 == null) goto L99;
        r144.add(r149);
        goto L99
    L173:
        r143.remove(r149);
        if (StringsKt.endsWith$default(r146, "_asc", false, r150, null) == false) goto L177;
        r149 = OfficeListSortFilterScene.c.a(r149, true);
        goto L179
    L177:
        if (StringsKt.endsWith$default(r146, "_desc", false, r150, null) == false) goto L179;
        r149 = OfficeListSortFilterScene.c.a(r149, false);
        goto L179
    L104:
        switch(r146.hashCode()) {
            case -1781973675: goto L167;
            case -1672977454: goto L162;
            case -1672820408: goto L159;
            case -1672775551: goto L158;
            case -1222978428: goto L156;
            case -1041975739: goto L152;
            case -812649188: goto L149;
            case -632122412: goto L146;
            case -180113220: goto L140;
            case -93018731: goto L137;
            case 113306952: goto L134;
            case 155914505: goto L131;
            case 172648244: goto L127;
            case 504485672: goto L124;
            case 592278736: goto L122;
            case 616358919: goto L120;
            case 662458379: goto L117;
            case 742450910: goto L114;
            case 1055395515: goto L111;
            case 1180848146: goto L109;
            case 1938005755: goto L107;
            default: goto L105;
        };
    L105:
        r150 = 2;
        r149 = null;
        goto L171
    L109:
        String r151 = "sort_direction_desc";
    L160:
        r146.equals(r151);
        goto L105
    L122:
        r151 = "sort_direction_asc";
        goto L160
    L140:
        char r152 = 0;
        if (r146.equals("sort_by_share_time_desc") == false) goto L105;
        int r153 = 2;
    L144:
        int[] r154 = new int[r153];
        r154[r152] = ShareFileSort.SHARE_TIME.getRank();
        r154[1] = FolderSort.SHARED_TIME.convertSortType().b;
        r148 = com.bytedance.ee.bear.office.list.menuconfig.c.a(r143, r154);
        goto L165
    L158:
        r151 = "sort_by_type";
        goto L160
    L159:
        r151 = "sort_by_size";
        goto L160
    L107:
        if (r146.equals("sort_by_edit_time") == false) goto L105;
    L169:
        r150 = 2;
        r149 = com.bytedance.ee.bear.office.list.menuconfig.c.a(r143, new int[]{RecentSort.MODIFIED.getRank(), ShareFileSort.MODIFIED_TIME.getRank(), FolderSort.MODIFIED_TIME.convertSortType().b});
        goto L171
    L111:
        if (r146.equals("sort_by_open_time") == false) goto L105;
    L139:
        r148 = com.bytedance.ee.bear.office.list.menuconfig.c.a(r143, new int[]{RecentSort.OPENED.getRank()});
        goto L165
    L114:
        if (r146.equals("sort_by_name_desc") == false) goto L105;
    L164:
        r148 = com.bytedance.ee.bear.office.list.menuconfig.c.a(r143, new int[]{FolderSort.NAME.convertSortType().b});
        goto L165
    L117:
        if (r146.equals("sort_by_created_time") == false) goto L105;
    L154:
        r148 = com.bytedance.ee.bear.office.list.menuconfig.c.a(r143, new int[]{RecentSort.CREATED.getRank(), ShareFileSort.CREATE_TIME.getRank(), FolderSort.CREATED_TIME.convertSortType().b});
        goto L165
    L120:
        if (r146.equals("sort_by_create_time_desc") == true) goto L154;
    L124:
        if (r146.equals("sort_by_visit_time_desc") == true) goto L139;
    L127:
        if (r146.equals("sort_by_share_time") == false) goto L105;
        r153 = 2;
        r152 = 0;
        goto L144
    L131:
        if (r146.equals("sort_by_create_time") == true) goto L154;
    L134:
        if (r146.equals("sort_by_visit_time") == true) goto L139;
    L137:
        if (r146.equals("sort_by_open_time_desc") == true) goto L139;
    L146:
        if (r146.equals("sort_by_modified_time_desc") == true) goto L169;
    L149:
        if (r146.equals("sort_by_modified_time") == true) goto L169;
    L152:
        if (r146.equals("sort_by_created_time_desc") == true) goto L154;
    L156:
        if (r146.equals("sort_by_name_asc") == true) goto L164;
    L162:
        if (r146.equals("sort_by_name") == true) goto L164;
    L167:
        if (r146.equals("sort_by_edit_time_desc") == true) goto L169;
    L182:
        if (r4.a == OfficeListSortFilterScene.Kind.RECENT) goto L184;
        r17 = r144;
        goto L201
    L184:
        List<OfficeListSortFilterScene.c> r155 = r4.c;
        ArrayList r156 = new ArrayList();
        Iterator<T> r157 = r155.iterator();
    L186:
        if (r157.hasNext() == false) goto L200;
        OfficeListSortFilterScene.c r158 = (OfficeListSortFilterScene.c) r157.next();
        Iterator r159 = r144.iterator();
    L189:
        if (r159.hasNext() == false) goto L196;
        Object r160 = r159.next();
        if (((OfficeListSortFilterScene.c) r160).b != r158.b) goto L193;
        boolean r161 = true;
    L194:
        if (r161 == false) goto L189;
    L197:
        OfficeListSortFilterScene.c r162 = (OfficeListSortFilterScene.c) r160;
        if (r162 == null) goto L186;
        r156.add(r162);
        goto L186
    L193:
        r161 = false;
        goto L194
    L196:
        r160 = null;
        goto L197
    L200:
        r17 = r156;
    L85:
        r17 = null;
        goto L201
    L202:
        r18 = null;
        goto L203
    L55:
        String r410 = r10.getString(2131889454);
        String r411 = r10.getString(2131889427);
        Map r163 = MapsKt.createMapBuilder();
        Pair[] r164 = new Pair[9];
        com.bytedance.ee.bear.widgets.menuconfig.g r412 = com.bytedance.ee.bear.office.list.menuconfig.c.a;
        r164[0] = TuplesKt.to("create_doc", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 1, r10.getString(2131889438), 2131233748, OfficeSpaceHeaderAction.CREATE_DOC, null, false, false, null, 480));
        r164[1] = TuplesKt.to("create_ppt", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 2, r10.getString(2131889441), 2131233747, OfficeSpaceHeaderAction.CREATE_PPT, null, false, false, null, 480));
        r164[2] = TuplesKt.to("create_bitable", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 12, r10.getString(2131887432), 2131254406, OfficeSpaceHeaderAction.CREATE_BITABLE, null, false, false, null, 480));
        r164[3] = TuplesKt.to("create_sheet", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 11, r10.getString(2131889440), 2131233749, OfficeSpaceHeaderAction.CREATE_SHEET, null, false, false, null, 480));
        r164[4] = TuplesKt.to("create_folder", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 3, r10.getString(2131889439), 2131233751, OfficeSpaceHeaderAction.CREATE_FOLDER, null, false, false, null, 480));
        r164[5] = TuplesKt.to("upload_image", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 4, r10.getString(2131889457), 2131233754, OfficeSpaceHeaderAction.UPLOAD_IMAGE, null, false, false, null, 480));
        r164[6] = TuplesKt.to("upload_file", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 5, r10.getString(2131889456), 2131233745, OfficeSpaceHeaderAction.UPLOAD_FILE, null, false, false, null, 480));
        String r510 = r10.getString(2131889429);
        if (r22 == true) goto L58;
        Integer r611 = 2131233736;
    L59:
        r164[7] = TuplesKt.to("list_view", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 7, r510, 2131233740, null, r611, true, false, null, SegmentStyle.FONT_WEIGHT_NORMAL));
        String r511 = r10.getString(2131889428);
        if (r22 == false) goto L62;
        Integer r612 = 2131233736;
    L63:
        r164[8] = TuplesKt.to("grid_view", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 8, r511, 2131233753, null, r612, false, true, null, 336));
        r163.putAll(MapsKt.mapOf(r164));
        if (r9 == false) goto L66;
        r163.put("filter", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 10, r411, 2131233750, null, 2131244677, false, false, null, 464));
    L66:
        if (r12 == false) goto L68;
        r163.put("sort", new com.bytedance.ee.bear.office.list.menuconfig.b(r412, 9, r410, 2131233735, null, 2131244677, false, false, "home_sort", 208));
    L68:
        Map r165 = MapsKt.build(r163);
        List r166 = OfficeSpaceMenuConfigSorter.a(r13);
        ArrayList r167 = new ArrayList();
        Iterator r168 = r166.iterator();
    L70:
        if (r168.hasNext() == false) goto L78;
        com.bytedance.ee.bear.widgets.menuconfig.g r169 = (com.bytedance.ee.bear.widgets.menuconfig.g) r168.next();
        com.bytedance.ee.bear.office.list.menuconfig.b r170 = (com.bytedance.ee.bear.office.list.menuconfig.b) r165.get(r169.a);
        if (r170 == null) goto L74;
        String r171 = r169.e;
        int r172 = r170.b;
        String r173 = r170.c;
        int r174 = r170.d;
        OfficeSpaceHeaderAction r175 = r170.e;
        Integer r176 = r170.f;
        boolean r177 = r170.g;
        boolean r178 = r170.h;
        Intrinsics.checkNotNullParameter(r169, "configItem");
        Intrinsics.checkNotNullParameter(r173, "text");
        com.bytedance.ee.bear.office.list.menuconfig.b r179 = new com.bytedance.ee.bear.office.list.menuconfig.b(r169, r172, r173, r174, r175, r176, r177, r178, r171);
    L75:
        if (r179 == null) goto L77;
        r167.add(r179);
    L77:
        r165 = r165;
        r168 = r168;
        r9 = r9;
        goto L70
    L74:
        r179 = null;
        goto L75
    L78:
        r51 = r9;
        r14 = r167;
        goto L79
    L62:
        r612 = null;
        goto L63
    L58:
        r611 = null;
    L51:
        r51 = r9;
        r14 = null;
    L45:
        r12 = false;
    L41:
        r11 = false;
        goto L42
    L40:
        r23 = r2;
        r24 = ", module=";
    L34:
        r9 = false;
        goto L35
    L29:
        r19 = null;
        goto L30
    L25:
        r3 = null;
        goto L26
    }

    public static final void o(final OfficeSpaceHeaderMoreMenuController r21, final Ref.ObjectRef<CommonMenu> r22, final List<OfficeListSortFilterScene.c> r23, final boolean r24, final FolderSortStrategy r25, final OfficeListSortFilterScene.c r26, final o r27, final OfficeListSortFilterScene r28, OfficeListSortFilterScene.c r29, OfficeListSortFilterScene.c r30) {
        if (r30 != null) goto L5;
        OfficeListSortFilterScene.c r13 = r29;
    L6:
        if (r30 == null) goto L8;
        int r1 = r30.b;
    L10:
        Integer r15 = Integer.valueOf(r1);
    L12:
        if (r29 == null) goto L14;
        String r0 = r21.p(r29);
    L15:
        if (r0 != null) goto L17;
        r0 = "";
    L17:
        List r10 = CollectionsKt.createListBuilder();
        r10.add(i(r21, 201, r21.c(2131889454), 2131233735, 2131244678, r0, false, null, false, false, 480));
        r10.add(r21.b(260));
        Iterator<T> r16 = r23.iterator();
        int r2 = 0;
    L19:
        if (r16.hasNext() == false) goto L32;
        Object r3 = r16.next();
        int r19 = r2 + 1;
        if (r2 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        OfficeListSortFilterScene.c r7 = (OfficeListSortFilterScene.c) r3;
        int r4 = r2 + 2000;
        int r5 = OfficeListSortFilterScene.e;
        String r6 = OfficeListSortFilterScene.a.f(r21.a, r7);
        int r8 = r7.b;
        if (r15 != null) goto L27;
    L29:
        Integer r9 = null;
    L30:
        r10.add(i(r21, r4, r6, null, r9, null, true, r7, false, false, SegmentStyle.FONT_WEIGHT_NORMAL));
        r2 = r19;
        r15 = r15;
        goto L19
    L27:
        if (r8 != r15.intValue()) goto L29;
        r9 = 2131233736;
        goto L30
    L32:
        if (r24 == true) goto L47;
        if (r13 == null) goto L47;
        r10.add(r21.b(260));
        Pair<String, String> r11 = r21.a(r13);
        int r12 = OfficeSortDirectionSupport.a;
        Iterator r17 = OfficeSortDirectionSupport.b(r13, (String) r11.getFirst(), (String) r11.getSecond()).iterator();
        int r14 = 0;
    L36:
        if (r17.hasNext() == false) goto L47;
        Object r18 = r17.next();
        int r110 = r14 + 1;
        if (r14 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        OfficeSortDirectionSupport.a r20 = (OfficeSortDirectionSupport.a) r18;
        int r31 = r14 + 4000;
        String r32 = r20.a;
        if (r30 != null) goto L45;
        int r33 = OfficeSortDirectionSupport.a;
        if (OfficeSortDirectionSupport.c(r13, r13.c) != r20.b) goto L45;
        Integer r34 = 2131233736;
    L46:
        r10.add(i(r21, r31, r32, null, r34, null, true, r20.c, false, false, SegmentStyle.FONT_WEIGHT_NORMAL));
        r14 = r110;
    L45:
        r34 = null;
    L47:
        List r35 = CollectionsKt.build(r10);
        Object r36 = r22.element;
        if (r36 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("childMenu");
        CommonMenu r111 = null;
    L51:
        r111.f(r35, new OfficeSpaceHeaderMoreMenuController$showSortSubMenu$renderSortSubMenu$1(r21, r24, r25, r26, r27, r28, r22, r23));
        return;
    L50:
        r111 = (CommonMenu) r36;
        goto L51
    L14:
        r0 = null;
        goto L15
    L8:
        if (r29 == null) goto L11;
        r1 = r29.b;
        goto L10
    L11:
        r15 = null;
        goto L12
    L5:
        r13 = r30;
        goto L6
    }

    public static com.bytedance.ee.bear.office.common.screenmenu.e i(OfficeSpaceHeaderMoreMenuController r21, int r22, String r23, Integer r24, Integer r25, String r26, boolean r27, Object r28, boolean r29, boolean r30, int r31) {
        if ((r31 & 8) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r31 & 16) == 0) goto L9;
        String r8 = null;
    L10:
        boolean r5 = false;
        if ((r31 & 32) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r31 & 64) == 0) goto L17;
        Object r15 = null;
    L19:
        if ((r31 & 128) == 0) goto L21;
        boolean r16 = true;
    L23:
        if ((r31 & 256) == 0) goto L25;
        boolean r17 = false;
    L26:
        r21.getClass();
        if (r24 == null) goto L36;
        int r1 = r24.intValue();
        if (r1 != 0) goto L52;
    L33:
        boolean r3 = false;
    L34:
        if (r3 == false) goto L36;
        Integer r10 = r24;
    L37:
        if (r2 == null) goto L45;
        int r4 = r2.intValue();
        if (r4 != 0) goto L50;
    L43:
        if (r5 == false) goto L45;
        Integer r13 = r2;
    L47:
        return new com.bytedance.ee.bear.office.common.screenmenu.e(r22, r23, r8, null, r10, false, r12, r13, false, r15, r16, r17, null, null, 52008);
    L50:
        r21.a.getResources().getResourceTypeName(r4);     // Catch: Resources.NotFoundException -> L48
        r5 = true;
    L45:
        r13 = null;
        goto L47
    L52:
        r21.a.getResources().getResourceTypeName(r1);     // Catch: Resources.NotFoundException -> L49
        r3 = true;
    L36:
        r10 = null;
        goto L37
    L25:
        r17 = r30;
        goto L26
    L21:
        r16 = r29;
        goto L23
    L17:
        r15 = r28;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r8 = r26;
        goto L10
    L5:
        r2 = r25;
        goto L7
    }
}
