package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupActionId;
import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupMenuSection;
import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupSelectionId;
import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupToggleId;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.home.impl.main.side_bar.view.p1;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConversationGroupPolicy f345531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<GroupSortPolicy> f345532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConversationArchiveFilter f345533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f345534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f345535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f345536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ac9.n f345537g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345538a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f345539b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f345540c = null;

        static {
            int[] r100 = new int[ConversationGroupPolicy.values().length];
            r100[ConversationGroupPolicy.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L33:
            r100[ConversationGroupPolicy.Project.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r100[ConversationGroupPolicy.Device.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[ConversationGroupPolicy.Time.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            f345538a = r100;
            int[] r101 = new int[GroupSortPolicy.values().length];
            r101[GroupSortPolicy.UpdateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L37:
            r101[GroupSortPolicy.CreateTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L27:
            r101[GroupSortPolicy.PinTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            f345539b = r101;
            int[] r102 = new int[ConversationArchiveFilter.values().length];
            r102[ConversationArchiveFilter.Active.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L39:
            r102[ConversationArchiveFilter.Archived.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L16:
            f345540c = r102;
        }
    }

    public static eb9.e.b a(ConversationArchiveFilter r100) {
        int r101 = a.f345540c[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = R.string.larus_infra_archiveChat_navBar_filterOption_active;
    L11:
        return new eb9.e.b(r102);
    L5:
        if (r101 != 2) goto L8;
        r102 = R.string.larus_infra_archiveChat_navBar_filterOption_hidden;
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static eb9.e.b c(ConversationGroupPolicy r100) {
        int r101 = a.f345538a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = R.string.larus_groupChats_navBar_entry_group_noGroup;
    L17:
        return new eb9.e.b(r102);
    L5:
        if (r101 != 2) goto L7;
        r102 = R.string.larus_groupChats_navBar_entry_group_byProject;
        goto L17
    L7:
        if (r101 != 3) goto L9;
        r102 = R.string.larus_groupChats_navBar_entry_group_byDevice;
        goto L17
    L9:
        if (r101 != 4) goto L12;
        r102 = R.string.larus_groupChats_navBar_entry_group_byDate;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static eb9.e.b d(GroupSortPolicy r100) {
        int r101 = a.f345539b[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = R.string.larus_groupChats_navBar_entry_sortBy_dateUpdated;
    L14:
        return new eb9.e.b(r102);
    L5:
        if (r101 != 2) goto L7;
        r102 = R.string.larus_groupChats_navBar_entry_sortBy_dateCreated;
        goto L14
    L7:
        if (r101 != 3) goto L10;
        r102 = R.string.larus_infra_navBar_option_datePinned;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [com.larus.home.impl.main.side_bar.view.group.module.j] */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.larus.home.impl.main.side_bar.view.group.module.i] */
    public final List<eb9.d> b(eb9.q r210) {
        List r100 = CollectionsKt.createListBuilder();
        SideBarGroupSelectionId r101 = SideBarGroupSelectionId.GROUP_POLICY;
        SideBarGroupMenuSection r110 = SideBarGroupMenuSection.GROUP_SORT_POLICY;
        String r102 = r110.getId();
        eb9.e.b r111 = new eb9.e.b(R.string.larus_groupChats_navBar_entry_group);
        ConversationArchiveFilter r103 = this.f345533c;
        ConversationArchiveFilter r104 = ConversationArchiveFilter.Archived;
        if (r103 == r104) goto L5;
        boolean r112 = true;
    L6:
        eb9.k r105 = new eb9.k(r111, null, null, r112, 14);
        eb9.q r113 = new e(this);
        r100.add(new eb9.d.b(r101, r105, new n(this), new o(this), r113, r102));
        SideBarGroupSelectionId r211 = SideBarGroupSelectionId.SORT_POLICY;
        String r212 = r110.getId();
        eb9.k r213 = new eb9.k(new eb9.e.b(R.string.larus_groupChats_navBar_entry_sortBy), null, null, false, 30);
        eb9.q r106 = new p(this);
        r100.add(new eb9.d.b(r211, r213, new q(this), new r(this), r106, r212));
        if (this.f345534d == false) goto L9;
        SideBarGroupSelectionId r107 = SideBarGroupSelectionId.ARCHIVE_FILTER;
        String r114 = SideBarGroupMenuSection.CONVERSATION_OPTIONS.getId();
        eb9.k r108 = new eb9.k(new eb9.e.b(R.string.larus_infra_archiveChat_navBar_filterHeader_filters), null, null, false, 30);
        eb9.q r109 = new f(this);
        r100.add(new eb9.d.b(r107, r108, new g(this), new h(this), r109, r114));
    L9:
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == false) goto L17;
        SideBarGroupToggleId r115 = SideBarGroupToggleId.SOCIAL_INDEPENDENT;
        String r116 = SideBarGroupMenuSection.CONVERSATION_OPTIONS.getId();
        eb9.e.b r117 = new eb9.e.b(R.string.larus_groupChats_navBar_project_menuOption_chatSeparate_cn);
        if (this.f345533c == r104) goto L14;
        boolean r214 = true;
    L15:
        eb9.k r118 = new eb9.k(r117, null, null, r214, 14);
        ?? r119 = new i(this);
        r100.add(new eb9.d.C5763d(r115, r118, new j(this), r119, r116));
        goto L17
    L14:
        r214 = false;
    L17:
        if (this.f345531a == ConversationGroupPolicy.Time) goto L19;
    L24:
        ConversationGroupPolicy r120 = this.f345531a;
        ConversationGroupPolicy r121 = ConversationGroupPolicy.Project;
        if (r120 != r121) goto L40;
        final boolean r122 = this.f345537g.f2785f.invoke().booleanValue();
        if (r122 == false) goto L29;
        SideBarGroupActionId r123 = SideBarGroupActionId.COLLAPSE_ALL_PROJECTS;
    L30:
        String r124 = SideBarGroupMenuSection.PROJECT_ACTIONS.getId();
        if (r122 == false) goto L33;
        int r125 = R.string.larus_groupChats_navBar_menuButton_collapse;
    L34:
        eb9.e.b r126 = new eb9.e.b(r125);
        if (r122 == false) goto L37;
        int r127 = R.drawable.larus_ic_side_bar_project_collapse_all;
    L38:
        r100.add(new eb9.d.a(r123, new eb9.k(r126, Integer.valueOf(r127), null, false, 28), new k(this, r122), r124));
        goto L40
    L37:
        r127 = R.drawable.larus_ic_side_bar_project_expand_all;
        goto L38
    L33:
        r125 = R.string.larus_groupChats_navBar_menuButton_expand;
        goto L34
    L29:
        r123 = SideBarGroupActionId.EXPAND_ALL_PROJECTS;
    L40:
        if (this.f345531a != r121) goto L42;
        String r128 = SideBarGroupMenuSection.PROJECT_ACTIONS.getId();
    L43:
        r100.add(new eb9.d.a(SideBarGroupActionId.CREATE_BLANK_PROJECT, new eb9.k(new eb9.e.b(R.string.larus_groupChats_navBar_project_more_menuOption_newProject), Integer.valueOf(R.drawable.larus_ic_create_blank_project), null, false, 28), new l(this), r128));
        if (this.f345536f == false) goto L47;
        r100.add(new eb9.d.a(SideBarGroupActionId.CREATE_GROUP_CHAT, new eb9.k(new eb9.e.b(R.string.larus_create_group_chat), Integer.valueOf(R.drawable.larus_ic_lark_group_chat), null, false, 28), new m(this), r128));
    L47:
        return CollectionsKt.build(r100);
    L42:
        r128 = SideBarGroupMenuSection.CREATE_ACTIONS.getId();
        goto L43
    L19:
        if (this.f345534d == false) goto L24;
        if (this.f345533c != ConversationArchiveFilter.Active) goto L24;
        if (r210 == null) goto L24;
        SideBarGroupActionId r129 = SideBarGroupActionId.ARCHIVE_TIME_GROUP;
        String r130 = SideBarGroupMenuSection.ARCHIVE_ACTIONS.getId();
        r100.add(new eb9.d.a(r129, new eb9.k(new eb9.e.b(R.string.larus_infra_archiveChat_menuOption_archiveGroupChats), Integer.valueOf(R.drawable.larus_ic_conversation_archive), null, false, 28), r210, r130));
        goto L24
    L5:
        r112 = false;
        goto L6
    }

    public s(ConversationGroupPolicy r100, p1 r101, ConversationArchiveFilter r102, boolean r103, boolean r104, boolean r105, ac9.n r106) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        Intrinsics.checkNotNullParameter(r101, "sortPolicyProvider");
        Intrinsics.checkNotNullParameter(r102, "archiveFilter");
        Intrinsics.checkNotNullParameter(r106, "callbacks");
        this.f345531a = r100;
        this.f345532b = r101;
        this.f345533c = r102;
        this.f345534d = r103;
        this.f345535e = r104;
        this.f345536f = r105;
        this.f345537g = r106;
    }
}
