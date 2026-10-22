package com.larus.home.impl.main.side_bar.data;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.SideBarPage;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.side_bar.data.api.SideBarApi;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SideBarRepo f344467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h0 f344468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f344469c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f344470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f344471e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile h f344472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f344473g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f344474h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f344475i = null;

    public SideBarRepo() {
    }

    static {
        f344467a = new SideBarRepo();
        f344469c = new Object();
        f344471e = new Object();
        f344473g = new Object();
        f344474h = LazyKt.lazy(new a1());
        f344475i = LazyKt.lazy(new b1());
    }

    public static e c() {
        String r100 = AccountService.f365697a.getUserId();
        d r101 = f344470d;
        d r102 = null;
        if (r101 != null) goto L5;
    L11:
        Object r103 = f344471e;
        monitor-enter(r103);
        d r104 = f344470d;     // Catch: Throwable -> L25
        if (r104 != null) goto L16;
    L22:
        f344467a.getClass();     // Catch: Throwable -> L25
        e r105 = i(r100);     // Catch: Throwable -> L25
        f344470d = new d(r100, r105);     // Catch: Throwable -> L25
    L23:
        monitor-exit(r103);
        return r105;
    L16:
        if (Intrinsics.areEqual(r104.f344487a, r100) == false) goto L18;
        r102 = r104;
    L18:
        if (r102 == null) goto L22;
        r105 = r102.f344488b;     // Catch: Throwable -> L25
        if (r105 == null) goto L22;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r101.f344487a, r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101.f344488b;
    }

    public static Gson d() {
        return (Gson) f344475i.getValue();
    }

    public static Keva f() {
        return (Keva) f344474h.getValue();
    }

    public static k0 g() {
        FLogger r100 = FLogger.f375446a;
        r100.i("SideBarRepo", "getSideBarListFromLocal start");
        AccountService r101 = AccountService.f365697a;
        String r102 = r101.getUserId();
        Object r103 = GsonProtectorUtils.fromJson(d(), f().getString("side_bar_info_".concat(r102), ""), k0.class);
        k0 r104 = (k0) r103;
        if (r104 == null) goto L5;
        List<p> r105 = r104.b();
    L6:
        List<p> r106 = r105;
        if (r106 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L18;
        r100.i("SideBarRepo", "getSideBarListFromLocal, use local template");
        int r108 = tr8.a.f547317a;
        ArrayList r109 = new ArrayList();
        int r110 = ComponentTypeEnum.TOP_SECTION.getType();
        int r310 = ComponentTypeEnum.SEARCH.getType();
        List r311 = CollectionsKt.mutableListOf(new a[]{new a(new n("//flow/combine_search"))});
        AppHost.Companion r111 = AppHost.f326268a;
        r109.add(new p("top_node_task", r110, null, null, null, null, null, null, CollectionsKt.mutableListOf(new p[]{new p("search_node_task", r310, r311, r111.getApplication().getString(R.string.larus_sidebar_search_placeholder), null, null, null, null, null, 65520)}), 32764));
        r109.add(new p("middle_node_task", ComponentTypeEnum.MID_SECTION.getType(), null, null, null, null, null, null, CollectionsKt.mutableListOf(new p[]{new p("conversation_list_node_task", ComponentTypeEnum.CONVERSATION_CONTAINER.getType(), null, null, null, null, new o(Integer.MAX_VALUE, r111.getApplication().getString(R.string.larus_sidebar_show_all)), null, null, 65276)}), 32764));
        int r112 = ComponentTypeEnum.BOTTOM_SECTION.getType();
        f r113 = new f(DividerPositionEnum.TOP.getPosition(), 6);
        p[] r114 = new p[2];
        r114[0] = new p("profile_node_task", ComponentTypeEnum.PROFILE.getType(), CollectionsKt.mutableListOf(new a[]{new a(new n("//flow/profile_mine?is_side_bar=1"))}), r101.getNickname(), CollectionsKt.mutableListOf(new i[]{new i(IconTypeEnum.AVATAR.getType(), r101.t(), r101.s(), r101.t(), r101.s(), 0, 32)}), null, null, null, null, 65456);
        int r510 = ComponentTypeEnum.CONTAINER.getType();
        ArrayList r115 = new ArrayList();
        ComponentTypeEnum r210 = ComponentTypeEnum.ACTION_ITEM;
        int r116 = r210.getType();
        j r117 = new j(true, true);
        List r118 = CollectionsKt.mutableListOf(new a[]{new a(new n("//flow/camera/scan"))});
        IconTypeEnum r211 = IconTypeEnum.ICON_IMAGE;
        r115.add(new p("scan_node_task", r116, r118, null, CollectionsKt.mutableListOf(new i[]{new i(r211.getType(), null, null, null, null, R.drawable.larus_ic_side_bar_scan, 30)}), null, null, r117, null, 64952));
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L17;
        r115.add(new p("notice_node_task", ComponentTypeEnum.NOTICE.getType(), CollectionsKt.mutableListOf(new a[]{new a(new n("//flow/notify_activity?is_side_bar=1"))}), null, CollectionsKt.mutableListOf(new i[]{new i(r211.getType(), null, null, null, null, R.drawable.larus_ic_side_bar_notify, 30)}), null, null, new j(true, true), null, 64952));
    L17:
        r115.add(new p("setting_node_task", r210.getType(), CollectionsKt.mutableListOf(new a[]{new a(new n("//flow/app_setting?is_side_bar=1"))}), null, CollectionsKt.mutableListOf(new i[]{new i(r211.getType(), null, null, null, null, R.drawable.larus_ic_side_bar_settings, 30)}), null, null, new j(true, true), null, 64952));
        Unit r119 = Unit.INSTANCE;
        r114[1] = new p("bottom_right_action_node_task", r510, null, null, null, null, null, null, r115, 32764);
        r109.add(new p("bottom_node_task", r112, null, null, null, r113, null, null, CollectionsKt.mutableListOf(r114), 32636));
        r109.add(new p("back_top_node_task", ComponentTypeEnum.BACK_DOUBAO.getType(), null, tr8.b.a(null), null, null, null, null, null, 65524));
        r103 = new k0(r109, 3);
    L18:
        k0 r120 = (k0) r103;
        if (r120 == null) goto L21;
        k0 r121 = n0.c(r120);
    L22:
        Object r122 = f344469c;
        monitor-enter(r122);
    L33:
        th = move-exception;
        throw th;
    L25:
        if (Intrinsics.areEqual(r101.getUserId(), r102) == true) goto L29;
        monitor-exit(r122);
        return null;
    L29:
        f344468b = new h0(r102, r121);     // Catch: Throwable -> L33
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r122);
        r100.i("SideBarRepo", "getSideBarListFromLocal end");
        return r121;
    L21:
        r121 = null;
        goto L22
    L9:
        if (r106.isEmpty() == true) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return true;
    L12:
        return f().getBoolean("side_bar_tag_new_" + r100, true);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean e(String r100) {
        h r101 = f344472f;
        h r102 = null;
        if (r101 != null) goto L5;
    L11:
        Object r103 = f344473g;
        monitor-enter(r103);
        h r104 = f344472f;     // Catch: Throwable -> L24
        if (r104 != null) goto L16;
    L20:
        f344467a.getClass();     // Catch: Throwable -> L24
        boolean r105 = f().getBoolean("has_project_".concat(r100), false);     // Catch: Throwable -> L24
        f344472f = new h(r100, r105);     // Catch: Throwable -> L24
        boolean r106 = r105;
    L22:
        monitor-exit(r103);
        return r106;
    L16:
        if (Intrinsics.areEqual(r104.f344499a, r100) == false) goto L18;
        r102 = r104;
    L18:
        if (r102 == null) goto L20;
        r106 = r102.f344500b;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r101.f344499a, r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101.f344500b;
    }

    public static boolean h(final int r100) {
        if (r100 == 0) goto L22;
        SideBarPage.a r101 = SideBarPage.Companion;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        if (SideBarPage.a.c(r102) == true) goto L22;
        String r103 = AccountService.f365697a.getUserId();
        h0 r104 = f344468b;
        p r105 = null;
        if (r104 != null) goto L9;
    L16:
        if (r105 == null) goto L22;
        j r106 = r105.i();
        if (r106 == null) goto L22;
        if (r106.a() != true) goto L22;
        return true;
    L9:
        if (Intrinsics.areEqual(r104.f344501a, r103) == true) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L16;
        k0 r107 = r104.f344502b;
        if (r107 == null) goto L16;
        r105 = q.b(r107, new c1(r100));
    L22:
        return false;
    }

    public static e i(String r110) {
        ConversationArchiveFilter r100 = null;
        c r101 = (c) d().fromJson(f().getString("conversation_group_config_".concat(r110), ""), c.class);     // Catch: Exception -> L5
    L7:
        int r102 = com.larus.home.impl.main.side_bar.p.b().d();
        if (r102 == ConversationGroupPolicy.Project.getValue()) goto L10;
    L12:
        ConversationGroupPolicy[] r111 = ConversationGroupPolicy.values();
        int r103 = r111.length;
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L27;
        ConversationGroupPolicy r105 = r111[r104];
        int r106 = r105.getValue();
        if (r101 == null) goto L19;
        Integer r112 = r101.f344481a;
        if (r112 == null) goto L19;
    L21:
        if (r106 != r112.intValue()) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L28;
        r104 = r104 + 1;
    L28:
        if (r105 != null) goto L30;
        r105 = ConversationGroupPolicy.None;
    L30:
        ConversationGroupPolicy r113 = r105;
        int r114 = com.larus.home.impl.main.side_bar.p.b().e();
        GroupSortPolicy[] r108 = GroupSortPolicy.values();
        int r109 = r108.length;
        int r115 = 0;
    L31:
        if (r115 >= r109) goto L44;
        GroupSortPolicy r116 = r108[r115];
        int r117 = r116.getValue();
        if (r101 == null) goto L36;
        Integer r118 = r101.f344482b;
        if (r118 == null) goto L36;
    L38:
        if (r117 != r118.intValue()) goto L40;
        boolean r119 = true;
    L41:
        if (r119 == true) goto L45;
        r115 = r115 + 1;
    L45:
        if (r116 != null) goto L47;
        GroupSortPolicy r120 = GroupSortPolicy.UpdateTime;
    L48:
        ConversationArchiveFilter[] r121 = ConversationArchiveFilter.values();
        int r122 = r121.length;
        int r123 = 0;
    L49:
        if (r123 >= r122) goto L62;
        ConversationArchiveFilter r124 = r121[r123];
        if (r101 == null) goto L58;
        int r125 = r124.getValue();
        Integer r126 = r101.f344483c;
        if (r126 == null) goto L58;
        if (r125 != r126.intValue()) goto L58;
        boolean r127 = true;
    L59:
        if (r127 == true) goto L60;
        r123 = r123 + 1;
        goto L49
    L60:
        r100 = r124;
    L58:
        r127 = false;
    L62:
        if (r100 != null) goto L64;
        ConversationArchiveFilter r128 = ConversationArchiveFilter.Active;
    L65:
        if (r101 == null) goto L69;
        Boolean r129 = r101.f344484d;
        if (r129 == null) goto L69;
        boolean r130 = r129.booleanValue();
    L70:
        boolean r131 = r130;
        if (r101 == null) goto L73;
        boolean r132 = r101.f344485e;
    L74:
        e r133 = new e(r113, r120, r128, r131, r132);
        FLogger.f375446a.i("SideBarRepo", "getConversationGroupConfig group=" + r133.f344493a + " sort=" + r133.f344494b + " archiveFilter=" + r133.f344495c + " socialIndependent=" + r133.f344496d + " hasManuallyChangedConversationGroupPolicy=" + r133.f344497e);
        return r133;
    L73:
        r132 = false;
    L69:
        r130 = com.larus.home.impl.main.side_bar.p.b().p();
        goto L70
    L64:
        r128 = r100;
        goto L65
    L47:
        r120 = r116;
        goto L48
    L40:
        r119 = false;
    L36:
        r118 = Integer.valueOf(r114);
        goto L38
    L44:
        r116 = null;
        goto L45
    L23:
        r107 = false;
    L19:
        r112 = Integer.valueOf(r102);
        goto L21
    L27:
        r105 = null;
        goto L28
    L10:
        if (e(r110) == true) goto L12;
        r102 = ConversationGroupPolicy.None.getValue();
    L5:
        e = move-exception;
        FLogger.f375446a.e("SideBarRepo", "getConversationGroupConfig failed", e);
        r101 = null;
        goto L7
    }

    public static k0 a(k0 r100, String r110) {
        k0 r101 = null;
        if (r100 == null) goto L5;
        k0 r102 = n0.c(r100);
    L6:
        Object r103 = f344469c;
        monitor-enter(r103);
    L84:
        th = move-exception;
        throw th;
    L9:
        if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r110) == false) goto L82;
        h0 r104 = f344468b;     // Catch: Throwable -> L84
        if (r104 != null) goto L14;
    L19:
        k0 r105 = null;
    L20:
        int r106 = n0.f344524a;     // Catch: Throwable -> L84
        if (r102 == null) goto L23;
        List<p> r107 = r102.b();     // Catch: Throwable -> L84
    L24:
        List<p> r108 = r107;     // Catch: Throwable -> L84
        boolean r109 = false;
        if (r108 != null) goto L27;
    L30:
        boolean r111 = true;
    L31:
        if (r111 == true) goto L48;
        if (r105 == null) goto L35;
        List<p> r112 = r105.b();     // Catch: Throwable -> L84
    L36:
        List<p> r113 = r112;     // Catch: Throwable -> L84
        if (r113 != null) goto L39;
    L42:
        boolean r114 = true;
    L43:
        if (r114 == false) goto L46;
    L47:
        boolean r115 = true;
    L49:
        if (r115 == false) goto L52;
        if (r102 == null) goto L52;
        f344467a.getClass();     // Catch: Throwable -> L84
        k(r110, r102);     // Catch: Throwable -> L84
    L52:
        h0 r116 = f344468b;     // Catch: Throwable -> L84
        if (r116 == null) goto L82;
        if (Intrinsics.areEqual(r116.f344501a, r110) == true) goto L58;
        r116 = null;
    L58:
        if (r116 == null) goto L82;
        k0 r117 = r116.f344502b;     // Catch: Throwable -> L84
        if (r117 == null) goto L82;
        if (r102 == null) goto L63;
        List<p> r118 = r102.b();     // Catch: Throwable -> L84
    L64:
        List<p> r119 = r118;     // Catch: Throwable -> L84
        if (r119 != null) goto L67;
    L70:
        boolean r120 = true;
    L71:
        if (r120 == true) goto L80;
        if (r102 == null) goto L77;
        if (r117.c() != r102.c()) goto L77;
        boolean r121 = true;
    L78:
        if (r121 == false) goto L80;
        r109 = true;
    L77:
        r121 = false;
    L80:
        if (r109 == false) goto L82;
        r101 = r117;
        goto L82
    L67:
        if (r119.isEmpty() == true) goto L70;
        r120 = false;
        goto L71
    L63:
        r118 = null;
        goto L64
    L46:
        if (r102.c() <= r105.c()) goto L48;
    L39:
        if (r113.isEmpty() == true) goto L42;
        r114 = false;
        goto L43
    L35:
        r112 = null;
    L48:
        r115 = false;
        goto L49
    L27:
        if (r108.isEmpty() == true) goto L30;
        r111 = false;
        goto L31
    L23:
        r107 = null;
        goto L24
    L14:
        if (Intrinsics.areEqual(r104.f344501a, r110) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        r105 = r104.f344502b;     // Catch: Throwable -> L84
    L82:
        monitor-exit(r103);
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public static void k(String r100, k0 r101) {
        f344468b = new h0(r100, r101);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SideBarRepo$saveSideBarLayoutLocked$1(r101, r100, null), 2, null);
    }

    public final Object m(o0 r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof SideBarRepo$updateSideBarOrder$1) == false) goto L7;
        SideBarRepo$updateSideBarOrder$1 r100 = (SideBarRepo$updateSideBarOrder$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L26:
        return Boxing.boxBoolean(((Boolean) r112).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r110.f344529e.length() != 0) goto L17;
        boolean r113 = true;
    L18:
        if (r113 == true) goto L28;
        if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r110.f344529e) == false) goto L28;
        SideBarApi r114 = SideBarApi.f344480a.getValue();
        f1 r104 = new f1(r110.f344526b, r110.f344527c, r110.f344528d, com.larus.home.impl.main.side_bar.p.c());
        r100.label = 1;
        r112 = r114.b(r104, r100);
        if (r112 != r102) goto L26;
        return r102;
    L28:
        return Boxing.boxBoolean(false);
    L17:
        r113 = false;
    L7:
        r100 = new SideBarRepo$updateSideBarOrder$1(this, r111);
        goto L8
    }

    public final Object j(long r100, Integer r101, Continuation<? super k0> r110) {
        if ((r110 instanceof SideBarRepo$requestSideBarList$1) == false) goto L7;
        SideBarRepo$requestSideBarList$1 r102 = (SideBarRepo$requestSideBarList$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        k0 r112 = (k0) r111;
        if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r106) == false) goto L21;
        k0 r107 = a(r112, r106);
    L22:
        FLogger.f375446a.i("SideBarRepo", "requestSideBarList end");
        return r107;
    L21:
        r107 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i("SideBarRepo", "requestSideBarList start");
        String r113 = AccountService.f365697a.getUserId();
        SideBarApi r108 = SideBarApi.f344480a.getValue();
        r102.L$0 = r113;
        r102.label = 1;
        Object r109 = r108.a(r100, r101, r102);
        if (r109 != r104) goto L17;
        return r104;
    L17:
        r111 = r109;
        r106 = r113;
    L7:
        r102 = new SideBarRepo$requestSideBarList$1(this, r110);
        goto L8
    }

    public static void l(ConversationGroupPolicy r110, GroupSortPolicy r111, ConversationArchiveFilter r112, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "groupPolicy");
        Intrinsics.checkNotNullParameter(r111, "sortPolicy");
        Intrinsics.checkNotNullParameter(r112, "archiveFilter");
        String r113 = AccountService.f365697a.getUserId();
        e r100 = c();
        if (r100.f344497e == true) goto L9;
        if (r211 == true) goto L6;
    L8:
        boolean r114 = false;
    L10:
        e r115 = new e(r110, r111, r112, r210, r114);
        c r101 = new c(Integer.valueOf(r110.getValue()), Integer.valueOf(r111.getValue()), Integer.valueOf(r112.getValue()), Boolean.valueOf(r210), r114);
        Object r102 = f344471e;
        monitor-enter(r102);
        f344470d = new d(r113, r115);     // Catch: Throwable -> L19
        if (r211 == false) goto L15;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SideBarRepo$updateConversationGroupConfig$1$1(r101, r113, null), 2, null);     // Catch: Throwable -> L19
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        FLogger.f375446a.i("SideBarRepo", "updateConversationGroupConfig group=" + r110 + " sort=" + r111 + " archiveFilter=" + r112 + " socialIndependent=" + r210 + " persistToKeva=" + r211);
        return;
    L19:
        th = move-exception;
        throw th;
    L6:
        if (r100.f344493a == r110) goto L8;
    L9:
        r114 = true;
        goto L10
    }
}
