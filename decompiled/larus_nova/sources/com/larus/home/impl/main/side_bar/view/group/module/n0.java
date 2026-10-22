package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.SidebarHasAvatar;
import com.larus.home.impl.main.side_bar.view.SidebarTitleIsBoldDisplay;
import com.larus.home.impl.main.side_bar.view.SidebarTitleLeftMargin;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.ImConversationSource;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.SideBarQuickAccessPinnedDataSource;
import com.larus.home.impl.main.side_bar.view.group.datasource.lark.HumanFeedScope;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.render.GroupHeaderAdapter;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationProjectStatus;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes29.dex */
public final class n0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345513a = null;

        static {
            int[] r100 = new int[ConversationArchiveFilter.values().length];
            r100[ConversationArchiveFilter.Active.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ConversationArchiveFilter.Archived.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f345513a = r100;
        }
    }

    public n0() {
    }

    public static void b(c0 r100) {
        Job r101 = (Job) r100.f345466c.get(Job.Key);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isCancelled() != true) goto L7;
    L8:
        if (r102 == true) goto L12;
        JobKt.ensureActive(r100.f345465b.getCoroutineContext());
        return;
    L12:
        throw new CancellationException("group build cancelled");
    L7:
        r102 = false;
        goto L8
    }

    public static com.larus.home.impl.main.side_bar.view.group.datasource.lark.v e(c0 r100, String r110, HumanFeedScope r111, com.larus.home.impl.main.side_bar.view.group.render.z r112) {
        Intrinsics.checkNotNullParameter(r100, "deps");
        Intrinsics.checkNotNullParameter(r110, "sectionId");
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r112, "paging");
        b(r100);
        if (r100.f345472i == true) goto L5;
        return null;
    L5:
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.u r101 = r100.f345464a.a();
        if (com.larus.home.impl.main.side_bar.p.c() != 3) goto L8;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        SidebarHasAvatar r103 = SidebarHasAvatar.V3;
    L13:
        boolean r104 = r103.getValue();
        if (r102 == false) goto L16;
        SidebarTitleIsBoldDisplay r105 = SidebarTitleIsBoldDisplay.V3;
    L17:
        boolean r106 = r105.getValue();
        if (r102 == false) goto L20;
        SidebarTitleLeftMargin r107 = SidebarTitleLeftMargin.V3;
    L21:
        eb9.l r108 = new eb9.l(r104, r106, r107.getValue(), 504);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r108, "config");
        Object r109 = r101.f345447b.invoke();
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.g r113 = r101.f345448c;
        if (r113 != null) goto L24;
    L27:
        r113 = r101.f345446a.invoke(r108);
        if (r113 != null) goto L30;
        r113 = null;
    L31:
        if (r113 != null) goto L33;
        return null;
    L33:
        int r114 = com.larus.home.impl.main.side_bar.view.group.datasource.lark.i.f345419l;
        CoroutineScope r115 = r100.f345465b;
        int r116 = RangesKt.coerceAtLeast(r112.f345736a, 1);
        Intrinsics.checkNotNullParameter(r113, "controller");
        Intrinsics.checkNotNullParameter(r115, "coroutineScope");
        Intrinsics.checkNotNullParameter(r111, "scope");
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.i r117 = new com.larus.home.impl.main.side_bar.view.group.datasource.lark.i(r113, r115, r111, r116);
        int r118 = com.larus.home.impl.main.side_bar.view.group.datasource.lark.r.f345442a;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.o r119 = com.larus.home.impl.main.side_bar.view.group.datasource.lark.o.f345433a;
        return new com.larus.home.impl.main.side_bar.view.group.datasource.lark.v(r110, r117, r113, r111);
    L30:
        r101.f345448c = r113;
        r101.f345449d = r109;
        r101.f345450e++;
        int r120 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_port_create", com.larus.home.impl.main.side_bar.view.group.datasource.lark.u.b(r113) + " user=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r109));
        goto L31
    L24:
        if (Intrinsics.areEqual(r101.f345449d, r109) == false) goto L26;
        int r121 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_port_reuse", com.larus.home.impl.main.side_bar.view.group.datasource.lark.u.b(r113) + " user=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r109));
        goto L31
    L26:
        r101.a("user_changed");
        goto L27
    L20:
        r107 = SidebarTitleLeftMargin.V2;
        goto L21
    L16:
        r105 = SidebarTitleIsBoldDisplay.V2;
        goto L17
    L12:
        r103 = SidebarHasAvatar.V2;
        goto L13
    L8:
        r102 = false;
        goto L10
    }

    public static ImConversationSource c(c0 r100, com.larus.home.impl.main.side_bar.view.group.render.z r110, OmniPinStatus r111, OmniConversationProjectStatus r112, com.larus.home.impl.main.side_bar.view.group.datasource.im.k0 r113) {
        Intrinsics.checkNotNullParameter(r100, "deps");
        Intrinsics.checkNotNullParameter(r110, "paging");
        Intrinsics.checkNotNullParameter(r111, "pinStatus");
        Intrinsics.checkNotNullParameter(r112, "projectStatus");
        Intrinsics.checkNotNullParameter(r113, "deviceScope");
        b(r100);
        int r101 = ImConversationSource.f345239v;
        ConversationArchiveFilter r102 = r100.f345470g;
        int r103 = a.f345513a[r102.ordinal()];
        if (r103 != 1) goto L5;
        OmniArchiveStatus r104 = OmniArchiveStatus.ArchiveStatus_NO_BELONG_ARCHIVE;
    L10:
        CoroutineScope r105 = r100.f345465b;
        int r106 = RangesKt.coerceAtLeast(r110.f345736a, 1);
        return ImConversationSource.b.a(r111, r112, r105, r106, r113, r104, r100.f345476m);
    L5:
        if (r103 != 2) goto L8;
        r104 = OmniArchiveStatus.ArchiveStatus_BELONG_ARCHIVE;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ ImConversationSource d(n0 r100, c0 r101, com.larus.home.impl.main.side_bar.view.group.render.z r102, OmniPinStatus r103, com.larus.home.impl.main.side_bar.view.group.datasource.im.k0.b r104, int r105) {
        if ((r105 & 8) == 0) goto L5;
        OmniConversationProjectStatus r106 = OmniConversationProjectStatus.ConversationProjectStatus_ALL;
    L6:
        com.larus.home.impl.main.side_bar.view.group.datasource.im.k0 r107 = r104;
        if ((r105 & 16) == 0) goto L9;
        r107 = com.larus.home.impl.main.side_bar.view.group.datasource.im.k0.a.f345356a;
    L9:
        r100.getClass();
        return c(r101, r102, r103, r106, r107);
    L5:
        r106 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.home.impl.main.side_bar.view.group.module.e0] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.larus.home.impl.main.side_bar.view.group.module.f0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.home.impl.main.side_bar.view.group.module.d0] */
    public static y f(n0 r110, final c0 r111, final String r112, eb9.e r113, com.larus.home.impl.main.side_bar.view.group.render.o r210, com.larus.home.impl.main.side_bar.view.group.module.a r211, int r212) {
        if ((r212 & 16) == 0) goto L5;
        final List r100 = CollectionsKt.emptyList();
    L7:
        if ((r212 & 32) == 0) goto L9;
        com.larus.home.impl.main.side_bar.view.group.module.a r114 = null;
    L10:
        boolean r101 = true;
        if ((r212 & 64) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r212 & 128) != 0) goto L18;
        r101 = false;
    L18:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "deps");
        Intrinsics.checkNotNullParameter(r112, "id");
        Intrinsics.checkNotNullParameter(r113, "title");
        Intrinsics.checkNotNullParameter(r210, "content");
        Intrinsics.checkNotNullParameter(r100, "customActionItems");
        final ac9.n r103 = r111.f345481r;
        return new y(r112, new GroupHeaderAdapter(new com.larus.home.impl.main.side_bar.view.group.render.y(r112 + "/header", r113, new d0(r111, r100), r114, r103.f2790k, new e0(r103, r112)), new rb9.b(r111.f345464a.d())), r210, r102, r101, new f0(r103, r112));
    L13:
        r102 = false;
        goto L15
    L9:
        r114 = r211;
        goto L10
    L5:
        r100 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [com.larus.home.impl.main.side_bar.view.group.module.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.home.impl.main.side_bar.view.group.module.l0, java.lang.Object] */
    public static com.larus.home.impl.main.side_bar.view.group.render.g a(n0 r110, final c0 r111, String r210, com.larus.home.impl.main.side_bar.view.group.render.z r211, boolean r212, ImConversationSource r213, com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r214, com.larus.home.impl.main.side_bar.view.group.render.h r215, SideBarQuickAccessPinnedDataSource r216, com.larus.home.impl.main.side_bar.view.group.datasource.im.s0 r217, q0 r218, boolean r219, String r310, int r311) {
        if ((r311 & 16) == 0) goto L5;
        ImConversationSource r100 = null;
    L7:
        if ((r311 & 32) == 0) goto L9;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.v r101 = null;
    L11:
        if ((r311 & 64) == 0) goto L13;
        com.larus.home.impl.main.side_bar.view.group.render.h r112 = null;
    L15:
        if ((r311 & 128) == 0) goto L17;
        SideBarQuickAccessPinnedDataSource r102 = null;
    L19:
        if ((r311 & 256) == 0) goto L21;
        com.larus.home.impl.main.side_bar.view.group.datasource.im.s0 r103 = null;
    L23:
        if ((r311 & 512) == 0) goto L25;
        Function1 r104 = new g0();
    L27:
        if ((r311 & 1024) == 0) goto L29;
        boolean r113 = false;
    L31:
        if ((r311 & 2048) == 0) goto L33;
        String r105 = null;
    L34:
        Intrinsics.checkNotNullParameter(r111, "deps");
        Intrinsics.checkNotNullParameter(r210, "sectionId");
        Intrinsics.checkNotNullParameter(r211, "paging");
        Intrinsics.checkNotNullParameter(r104, "sortPolicyTransformer");
        if (r112 == null) goto L39;
        if (r103 == null) goto L39;
        boolean r114 = false;
    L41:
        if (r114 == false) goto L76;
        int r115 = com.larus.home.impl.main.side_bar.view.group.render.g.A;
        Intrinsics.checkNotNullParameter(r210, "sectionId");
        Intrinsics.checkNotNullParameter(r104, "sortPolicyTransformer");
        zb9.d[] r116 = new zb9.d[4];
        if (r103 == null) goto L45;
        zb9.c r117 = new zb9.c(r210 + "/main_conversation", r103);
    L46:
        r116[0] = r117;
        if (r100 == null) goto L49;
        zb9.c r106 = new zb9.c(r210 + "/query", r100);
        char r107 = 1;
    L50:
        r116[r107] = r106;
        if (r101 == null) goto L53;
        zb9.c r108 = r101.f345455e;
    L54:
        r116[2] = r108;
        if (r102 == null) goto L57;
        zb9.c r109 = new zb9.c(r210 + "/quick_access", r102);
    L58:
        r116[3] = r109;
        List r118 = CollectionsKt.listOfNotNull(r116);
        boolean r119 = true;
        if ((!r118.isEmpty()) == false) goto L74;
        zb9.a r120 = new zb9.a(r118, new zb9.h(new zb9.v(), null, 6), r104);
        if (r102 != null) goto L64;
        r119 = false;
    L64:
        SideBarContentFragment r121 = r111.f345464a.f();
        SideBarContentFragment r122 = r111.f345464a.g();
        d1 r123 = r111.f345469f;
        int r124 = r111.f345468e.getType();
        String r125 = r111.f345468e.h();
        if (r105 == null) goto L70;
        com.larus.home.impl.main.side_bar.view.group.render.o0 r126 = r111.f345464a.i();
        r126.getClass();
        Intrinsics.checkNotNullParameter(r105, "listKey");
        r126.a();
        LinkedHashMap r127 = (LinkedHashMap) r126.f345699d;
        Object r128 = r127.get(r105);
        if (r128 != null) goto L69;
        r128 = new com.larus.home.impl.main.side_bar.view.group.render.m();
        r127.put(r105, r128);
    L69:
        com.larus.home.impl.main.side_bar.view.group.render.n r129 = (com.larus.home.impl.main.side_bar.view.group.render.n) r128;
    L71:
        ?? r130 = new l0(r111);
        ?? r131 = new m0(r111);
        Intrinsics.checkNotNullParameter(r210, "sectionId");
        Intrinsics.checkNotNullParameter(r120, "compoundDataSource");
        Intrinsics.checkNotNullParameter(r121, "conversationBridge");
        Intrinsics.checkNotNullParameter(r122, "contentBridge");
        Intrinsics.checkNotNullParameter(r123, "sideBarTabInfo");
        Intrinsics.checkNotNullParameter(r130, "groupByProvider");
        Intrinsics.checkNotNullParameter(r131, "sortTypeProvider");
        Intrinsics.checkNotNullParameter(r211, "pagingConfig");
        Intrinsics.checkNotNullParameter(r129, "displayPolicy");
        return new com.larus.home.impl.main.side_bar.view.group.render.g(r210, r120, r101, r119, r121, r122, r123, r124, r125, r130, r131, r211, r212, r129, r112, r113);
    L70:
        r129 = new com.larus.home.impl.main.side_bar.view.group.render.m();
        goto L71
    L74:
        throw new IllegalArgumentException(("section " + r210 + " has no source").toString());
    L57:
        r109 = null;
        goto L58
    L53:
        r108 = null;
        goto L54
    L49:
        r107 = 1;
        r106 = null;
        goto L50
    L45:
        r117 = null;
        goto L46
    L76:
        throw new IllegalArgumentException(("section " + r210 + " cannot mix date headers with a fixed-first source").toString());
    L39:
        r114 = true;
        goto L41
    L33:
        r105 = r310;
        goto L34
    L29:
        r113 = r219;
        goto L31
    L25:
        r104 = r218;
        goto L27
    L21:
        r103 = r217;
        goto L23
    L17:
        r102 = r216;
        goto L19
    L13:
        r112 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
