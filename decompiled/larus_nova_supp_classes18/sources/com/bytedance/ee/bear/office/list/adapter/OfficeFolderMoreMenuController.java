package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadActionType;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeFolderMoreMenuController {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public final String b;
    public final Function0<Fragment> c;
    public com.bytedance.ee.bear.office.common.screenmenu.j d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L81:
            r0[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L93:
            r0[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L59:
            r0[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L61:
            r0[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L79:
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L91:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L69:
            r0[OfficeSpaceHeaderAction.SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L83:
            r0[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L85:
            r0[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L44
        L22:
            a = r0;
            int[] r1 = new int[OfficeFolderMoreMenuRules.Action.values().length];
            r1[OfficeFolderMoreMenuRules.Action.CREATE_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L77:
            r1[OfficeFolderMoreMenuRules.Action.CREATE_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L89:
            r1[OfficeFolderMoreMenuRules.Action.CREATE_PPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L57:
            r1[OfficeFolderMoreMenuRules.Action.CREATE_BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L48
        L65:
            r1[OfficeFolderMoreMenuRules.Action.CREATE_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L49
        L75:
            r1[OfficeFolderMoreMenuRules.Action.UPLOAD_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L50
        L87:
            r1[OfficeFolderMoreMenuRules.Action.UPLOAD_FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L51
        L55:
            r1[OfficeFolderMoreMenuRules.Action.LIST_VIEW.ordinal()] = 8;     // Catch: NoSuchFieldError -> L52
        L63:
            r1[OfficeFolderMoreMenuRules.Action.GRID_VIEW.ordinal()] = 9;     // Catch: NoSuchFieldError -> L53
        L73:
            r1[OfficeFolderMoreMenuRules.Action.SORT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L54
        L33:
            b = r1;
        }
    }

    static {
    }

    public final boolean c() {
        Fragment r0 = (Fragment) this.c.invoke();
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

    public final void e() {
        com.bytedance.ee.bear.office.common.screenmenu.j r0 = this.d;
        if (r0 == null) goto L6;
        r0.n(OfficeFolderMoreMenuController$resetMenuLocate$1.INSTANCE);
        return;
    }

    public final com.bytedance.ee.bear.office.common.screenmenu.c a(int r8) {
        return new com.bytedance.ee.bear.office.common.screenmenu.c(View.generateViewId(), 2131244664, b(8), b(r8), 74);
    }

    public final int b(int r3) {
        Resources r0 = this.a.getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final String h(OfficeListSortFilterScene.c r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = OfficeListSortFilterScene.e;
        r0.append(OfficeListSortFilterScene.a.f(this.a, r3));
        r0.append(" · ");
        r0.append(OfficeSortDirectionSupport.d(r3));
        return r0.toString();
    }

    public OfficeFolderMoreMenuController(Context r2, String r3, Function0<? extends Fragment> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "folderToken");
        Intrinsics.checkNotNullParameter(r4, "ownerFragmentProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void f(final com.bytedance.ee.bear.office.export.space.i r17, final OfficeSpaceHeaderAction r18, final com.bytedance.ee.bear.office.list.i r19, final OfficeSpaceTab r20) {
        boolean r10 = false;
        switch(b.a[r18.ordinal()]) {
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
        if (r0 == false) goto L10;
        i0.a.f(r20, r18, this.b, true);
    L10:
        final long r11 = System.currentTimeMillis();
        Boolean r13 = null;
        if (r18 != OfficeSpaceHeaderAction.CREATE_FOLDER) goto L23;
        tt5.a.h("OfficeFolderMoreMenu", "[OfficeCreatePerf] stage=menu_dispatch_start action=" + r18 + " tab=" + r20 + " isFolderPage=true ts=" + r11);
        final Function0<Unit> r15 = new OfficeFolderMoreMenuController$runHeaderAction$1(this, r17, r19, r20, r11);
        e();
        StringBuilder r1 = new StringBuilder("[OfficeCreatePerf] stage=menu_close_start action=");
        r1.append(r18);
        r1.append(" tab=");
        r1.append(r20);
        r1.append(" isFolderPage=true visible=");
        com.bytedance.ee.bear.office.common.screenmenu.j r2 = this.d;
        if (r2 == null) goto L15;
        r13 = Boolean.valueOf(r2.m());
    L15:
        r1.append(r13);
        tt5.a.h("OfficeFolderMoreMenu", r1.toString());
        com.bytedance.ee.bear.office.common.screenmenu.j r3 = this.d;
        if (r3 != null) goto L21;
        tt5.a.h("OfficeFolderMoreMenu", "[OfficeCreatePerf] stage=menu_close_complete action=" + r18 + " tab=" + r20 + " isFolderPage=true reason=menu_missing");
        if (c() == true) goto L20;
        tt5.a.k("OfficeFolderMoreMenu", "[OfficeCreatePerf] stage=create_folder_skip_after_menu_closed action=" + r18 + " tab=" + r20 + " isFolderPage=true reason=owner_inactive");
        return;
    L20:
        r15.invoke();
        return;
    L21:
        r3.d("folder_header_more_" + r18, new OfficeFolderMoreMenuController$closeMenuAfterDismiss$1(r18, r20, this, r15));
        return;
    L23:
        e();
        com.bytedance.ee.bear.office.common.screenmenu.j r4 = this.d;
        if (r4 == null) goto L26;
        com.bytedance.ee.bear.office.common.screenmenu.j.e(r4, null, 3);
    L26:
        OfficeUploadHeaderAction r5 = OfficeUploadHeaderAction.a;
        if (OfficeUploadHeaderAction.b(r18) == false) goto L45;
        Fragment r14 = (Fragment) this.c.invoke();
        if (r14 != null) goto L31;
        return;
    L31:
        String r6 = this.b;
        Intrinsics.checkNotNullParameter(r20, "tab");
        Intrinsics.checkNotNullParameter(r19, "capability");
        if (r5.c(OfficeSpaceHeaderAction.UPLOAD_FILE, r20, r19, true, r6).a == false) goto L40;
        String r7 = this.b;
        com.bytedance.ee.bear.office.export.space.h r8 = r17.a();
        Intrinsics.checkNotNullParameter(r18, "action");
        Intrinsics.checkNotNullParameter(r19, "capability");
        Intrinsics.checkNotNullParameter(r20, "tab");
        Intrinsics.checkNotNullParameter(r14, "hostFragment");
        Intrinsics.checkNotNullParameter(r7, "folderToken");
        OfficeUploadActionType r9 = OfficeUploadHeaderAction.f(r18);
        if (r9 == null) goto L37;
        com.bytedance.ee.bear.office.common.upload.g0.a r12 = new com.bytedance.ee.bear.office.common.upload.g0.a(r7);
        r10 = OfficeUploadHeaderAction.e(r14, r18, r12, r8, OfficeUploadHeaderAction.a(r9, r12, r19, r20, true, r14));
    L37:
        if (r10 == false) goto L40;
        return;
    L40:
        if (Intrinsics.areEqual(r17.b(r18), OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L42;
        return;
    L42:
        UDToast.a r16 = UDToast.build(this.a);
        r16.g(com.bytedance.ee.bear.more.office.f.c());
        r16.b.d = -1;
        r16.h();
        return;
    L45:
        if (Intrinsics.areEqual(r17.b(r18), OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L47;
        return;
    L47:
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

    public final boolean g(final View r33, final OfficeSpaceTab r34, final com.bytedance.ee.bear.office.list.i r35, final com.bytedance.ee.bear.office.list.c r36) {
        Intrinsics.checkNotNullParameter(r33, "anchor");
        Intrinsics.checkNotNullParameter(r34, "tab");
        Intrinsics.checkNotNullParameter(r35, "capability");
        Intrinsics.checkNotNullParameter(r36, "dispatcher");
        if (r33.isAttachedToWindow() == true) goto L5;
        return false;
    L5:
        if (r33.getWidth() > 0) goto L7;
        return false;
    L7:
        if (r33.getHeight() <= 0) goto L159;
        Fragment r0 = (Fragment) this.c.invoke();
        if (r0 != null) goto L13;
        return false;
    L13:
        if (r0.isAdded() == true) goto L15;
        return false;
    L15:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L157;
        final Fragment r1 = r35.a();
        if (r1 != null) goto L20;
        return false;
    L20:
        int r2 = OfficeListSortFilterScene.e;
        OfficeListSortFilterScene r10 = OfficeListSortFilterScene.a.c(r34, r35.a, r1);
        CommonMenu r16 = null;
        if (r10 == null) goto L23;
        o r9 = new o(new OfficeFolderMoreMenuController$show$sortFilterAction$1$1(r1), r35.c);
    L24:
        f r8 = new f(new OfficeFolderMoreMenuController$show$displayModeAction$1(r35));
        com.bytedance.ee.bear.office.common.screenmenu.j r3 = this.d;
        if (r3 != null) goto L27;
        r3 = new com.bytedance.ee.bear.office.common.screenmenu.j();
        this.d = r3;
    L27:
        com.bytedance.ee.bear.office.common.screenmenu.j r7 = r3;
        r7.g(r0);
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        CommonMenu r4 = new CommonMenu(this.a);
        com.bytedance.ee.bear.office.common.screenmenu.b.a(r4);
        r4.d(b(240));
        if (r10 == null) goto L76;
        if (r9 == null) goto L76;
        List r6 = OfficeSortDirectionSupport.e(r10);
        if (r6.isEmpty() == true) goto L76;
        FolderSortStrategy r11 = r9.c(r10);
        List r17 = r6;
        Iterator r18 = r17.iterator();
    L36:
        if (r18.hasNext() == false) goto L46;
        Object r19 = r18.next();
        OfficeListSortFilterScene.c r12 = (OfficeListSortFilterScene.c) r19;
        if (r11.e == r12.b) goto L40;
    L42:
        boolean r13 = false;
    L43:
        if (r13 == false) goto L36;
    L47:
        OfficeListSortFilterScene.c r110 = (OfficeListSortFilterScene.c) r19;
        if (r110 != null) goto L66;
        Iterator r14 = r17.iterator();
    L51:
        if (r14.hasNext() == false) goto L59;
        Object r15 = r14.next();
        Iterator r111 = r14;
        if (r11.e != ((OfficeListSortFilterScene.c) r15).b) goto L55;
        boolean r20 = true;
    L56:
        if (r20 == true) goto L60;
        r14 = r111;
    L60:
        OfficeListSortFilterScene.c r21 = (OfficeListSortFilterScene.c) r15;
        if (r21 == null) goto L63;
        r110 = new OfficeListSortFilterScene.c(r21.a, r21.b, r11.f);
    L64:
        if (r110 != null) goto L66;
        r110 = (OfficeListSortFilterScene.c) CollectionsKt.firstOrNull(r6);
        goto L66
    L63:
        r110 = null;
        goto L64
    L55:
        r20 = false;
        goto L56
    L59:
        r15 = null;
    L66:
        OfficeListSortFilterScene.c r22 = r110;
        if (r22 != null) goto L69;
        r22 = null;
    L72:
        if (r22 == null) goto L74;
        String r23 = h(r22);
    L75:
        if (r23 == null) goto L76;
    L77:
        String r112 = r23;
        int r24 = OfficeFolderMoreMenuRules.a;
        Context r25 = this.a;
        e.a.getClass();
        boolean r113 = e.a(r34, r35, true);
        OfficeUploadHeaderAction r114 = OfficeUploadHeaderAction.a;
        f r26 = r8;
        com.bytedance.ee.bear.office.common.screenmenu.j r27 = r7;
        p0 r28 = r114.c(OfficeSpaceHeaderAction.UPLOAD_IMAGE, r34, r35, true, this.b);
        p0 r29 = r114.c(OfficeSpaceHeaderAction.UPLOAD_FILE, r34, r35, true, this.b);
        if (r10 != null) goto L80;
    L82:
        boolean r30 = false;
    L83:
        if (r30 == false) goto L86;
        if (r9 == null) goto L86;
        boolean r210 = true;
    L87:
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r28, "mediaUploadState");
        Intrinsics.checkNotNullParameter(r29, "fileUploadState");
        List r31 = CollectionsKt.createListBuilder();
        OfficeFolderMoreMenuRules.Action r32 = OfficeFolderMoreMenuRules.Action.CREATE_DOC;
        OfficeFolderMoreMenuRules.Group r37 = OfficeFolderMoreMenuRules.Group.CREATE;
        r31.add(new OfficeFolderMoreMenuRules.a(r32, r37, r25.getString(2131889438), true));
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.CREATE_PPT, r37, r25.getString(2131889441), true));
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.CREATE_BITABLE, r37, r25.getString(2131887432), true));
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.CREATE_SHEET, r37, r25.getString(2131889440), true));
        if (r113 == false) goto L91;
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.CREATE_FOLDER, r37, r25.getString(2131889439), true));
    L91:
        if (r28.a == false) goto L94;
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.UPLOAD_IMAGE, OfficeFolderMoreMenuRules.Group.UPLOAD, r25.getString(2131889457), r28.b));
    L94:
        if (r29.a == false) goto L96;
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.UPLOAD_FILE, OfficeFolderMoreMenuRules.Group.UPLOAD, r25.getString(2131889456), r29.b));
    L96:
        OfficeFolderMoreMenuRules.Action r38 = OfficeFolderMoreMenuRules.Action.LIST_VIEW;
        OfficeFolderMoreMenuRules.Group r39 = OfficeFolderMoreMenuRules.Group.DISPLAY;
        r31.add(new OfficeFolderMoreMenuRules.a(r38, r39, r25.getString(2131889429), true));
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.GRID_VIEW, r39, r25.getString(2131889428), true));
        if (r210 == false) goto L99;
        r31.add(new OfficeFolderMoreMenuRules.a(OfficeFolderMoreMenuRules.Action.SORT, OfficeFolderMoreMenuRules.Group.SORT, r25.getString(2131889454), true));
    L99:
        List r40 = CollectionsKt.build(r31);
        List r41 = CollectionsKt.createListBuilder();
        Iterator r115 = r40.iterator();
        OfficeFolderMoreMenuRules.Group r42 = null;
    L101:
        if (r115.hasNext() == false) goto L131;
        OfficeFolderMoreMenuRules.a r43 = (OfficeFolderMoreMenuRules.a) r115.next();
        if (r42 == null) goto L109;
        if (r42 == r43.b) goto L109;
        r41.add(a(240));
    L109:
        switch(b.b[r43.a.ordinal()]) {
            case 1: goto L129;
            case 2: goto L128;
            case 3: goto L127;
            case 4: goto L126;
            case 5: goto L125;
            case 6: goto L124;
            case 7: goto L123;
            case 8: goto L118;
            case 9: goto L113;
            case 10: goto L112;
            default: goto L111;
        };
    L112:
        com.bytedance.ee.bear.office.common.screenmenu.e r44 = d(this, 9, r43.c, 2131233735, 2131244677, r112, false, null, false, false, 480);
        OfficeFolderMoreMenuRules.a r116 = r43;
    L130:
        List r45 = r41;
        r45.add(r44);
        r42 = r116.b;
        r41 = r45;
        r26 = r26;
        r9 = r9;
        r10 = r10;
        r27 = r27;
        goto L101
    L113:
        String r46 = r43.c;
        if (t3.a == false) goto L116;
        Integer r47 = 2131233736;
    L117:
        r116 = r43;
        r44 = d(this, 8, r46, 2131233753, r47, null, false, null, false, false, 496);
        goto L130
    L116:
        r47 = null;
        goto L117
    L118:
        r116 = r43;
        String r48 = r116.c;
        if (t3.a == true) goto L121;
        Integer r49 = 2131233736;
    L122:
        r44 = d(this, 7, r48, 2131233740, r49, null, false, null, false, false, 496);
        goto L130
    L121:
        r49 = null;
        goto L122
    L123:
        r116 = r43;
        String r50 = r116.c;
        boolean r51 = r116.d;
        r44 = d(this, 5, r50, 2131233745, null, null, false, null, r51, !r51, 120);
        goto L130
    L124:
        r116 = r43;
        String r52 = r116.c;
        boolean r53 = r116.d;
        r44 = d(this, 4, r52, 2131233754, null, null, false, null, r53, !r53, 120);
        goto L130
    L125:
        r116 = r43;
        r44 = d(this, 3, r116.c, 2131233751, null, null, false, null, false, false, 504);
        goto L130
    L126:
        r116 = r43;
        r44 = d(this, 12, r116.c, 2131254406, null, null, false, null, false, false, 504);
        goto L130
    L127:
        r116 = r43;
        r44 = d(this, 2, r116.c, 2131233747, null, null, false, null, false, false, 504);
        goto L130
    L128:
        r116 = r43;
        r44 = d(this, 11, r116.c, 2131233749, null, null, false, null, false, false, 504);
        goto L130
    L129:
        r116 = r43;
        r44 = d(this, 1, r116.c, 2131233748, null, null, false, null, false, false, 504);
        goto L130
    L111:
        throw new NoWhenBranchMatchedException();
    L131:
        final o r211 = r9;
        final OfficeListSortFilterScene r212 = r10;
        final f r213 = r26;
        com.bytedance.ee.bear.office.common.screenmenu.j r310 = r27;
        r4.f(CollectionsKt.build(r41), new OfficeFolderMoreMenuController$show$1(this, r5, r212, r211, r213, r36, r35, r34));
        r5.element = r4;
        r310.n(new OfficeFolderMoreMenuController$show$2(this, r33));
        Object r54 = r5.element;
        if (r54 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("parentMenu");
    L135:
        r310.s(r33, r16.j(), com.bytedance.ee.bear.office.common.screenmenu.u.f);
        return true;
    L134:
        r16 = (CommonMenu) r54;
    L86:
        r210 = false;
        goto L87
    L80:
        if (r10.a() != true) goto L82;
        r30 = true;
        goto L83
    L74:
        r23 = null;
        goto L75
    L69:
        if (r10.a != OfficeListSortFilterScene.Kind.RECENT) goto L72;
        int r55 = OfficeSortDirectionSupport.a;
        r22 = OfficeSortDirectionSupport.g(r22, OfficeSortDirectionSupport.DirectionSlot.FIRST);
        goto L72
    L40:
        if (r11.f != r12.c) goto L42;
        r13 = true;
        goto L43
    L46:
        r19 = null;
    L76:
        r23 = "";
        goto L77
    L23:
        r9 = null;
        goto L24
    L157:
        return false;
    L159:
        return false;
    }

    public static com.bytedance.ee.bear.office.common.screenmenu.e d(OfficeFolderMoreMenuController r21, int r22, String r23, Integer r24, Integer r25, String r26, boolean r27, OfficeListSortFilterScene.c r28, boolean r29, boolean r30, int r31) {
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
        OfficeListSortFilterScene.c r15 = null;
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
