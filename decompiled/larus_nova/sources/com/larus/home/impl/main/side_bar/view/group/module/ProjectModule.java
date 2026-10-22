package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.data.w0;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource;
import com.larus.home.impl.main.side_bar.view.group.datasource.im.ImSdkSideBarProjectImService;
import com.larus.home.impl.main.side_bar.view.project.SideBarProjectActionHandler;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class ProjectModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f345457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f345458b;

    public ProjectModule(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "deps");
        this.f345457a = r100;
        this.f345458b = false;
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [com.larus.home.impl.main.side_bar.view.group.module.j0, java.lang.Object] */
    public final Object a(Continuation<? super y> r610) {
        if ((r610 instanceof ProjectModule$build$1) == false) goto L7;
        ProjectModule$build$1 r100 = (ProjectModule$build$1) r610;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        eb9.e r105 = (eb9.e) r100.L$3;
        String r106 = (String) r100.L$2;
        c0 r107 = (c0) r100.L$1;
        n0 r108 = (n0) r100.L$0;
        ResultKt.throwOnFailure(r102);
        eb9.e r109 = r105;
        c0 r110 = r107;
    L19:
        return n0.f(r108, r110, r106, r109, (com.larus.home.impl.main.side_bar.view.group.render.o) r102, null, 176);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        c0 r111 = this.f345457a;
        n0 r112 = r111.f345483t;
        eb9.e.b r113 = new eb9.e.b(R.string.larus_groupChats_navBar_entry_group_byProject);
        final c0 r114 = this.f345457a;
        boolean r115 = this.f345458b;
        r100.L$0 = r112;
        r100.L$1 = r111;
        r100.L$2 = SlashMentionConfig.SLASH_CONTENT_PROJECT;
        r100.L$3 = r113;
        r100.label = 1;
        r112.getClass();
        n0.b(r114);
        final com.larus.home.impl.main.side_bar.view.group.assembly.n r116 = r114.f345464a;
        final SideBarProjectActionHandler r117 = r116.c();
        final com.larus.home.impl.main.side_bar.data.p r118 = r114.f345468e;
        int r119 = com.larus.home.impl.main.side_bar.view.group.render.i0.A;
        CoroutineScope r120 = r114.f345465b;
        o0 r121 = r114.f345479p;
        com.larus.home.impl.main.side_bar.view.group.render.z r122 = r121.f345518c;
        com.larus.home.impl.main.side_bar.view.group.render.z r123 = r121.f345519d;
        SideBarContentFragment r124 = r116.f();
        SideBarContentFragment r125 = r116.g();
        ac9.c0 r126 = r116.d();
        d1 r127 = r114.f345469f;
        int r128 = r118.getType();
        String r129 = r118.h();
        Function0 r130 = new h0(r114);
        Function0 r131 = new i0(r114);
        ?? r132 = new j0(r117);
        Function2 r133 = new k0(r116, r118);
        boolean r134 = r114.f345471h;
        GroupModuleSupport$projectContent$6 r135 = new GroupModuleSupport$projectContent$6(r117);
        GroupModuleSupport$projectContent$7 r136 = new GroupModuleSupport$projectContent$7(r117);
        GroupModuleSupport$projectContent$8 r137 = new GroupModuleSupport$projectContent$8(r117);
        GroupModuleSupport$projectContent$9 r138 = new GroupModuleSupport$projectContent$9(r117);
        com.larus.home.impl.main.side_bar.view.group.render.m r139 = new com.larus.home.impl.main.side_bar.view.group.render.m();
        Intrinsics.checkNotNullParameter(r120, "coroutineScope");
        Intrinsics.checkNotNullParameter(r122, "pagingConfig");
        Intrinsics.checkNotNullParameter(r123, "projectConversationPagingConfig");
        Intrinsics.checkNotNullParameter(r139, "displayPolicy");
        Intrinsics.checkNotNullParameter(r124, "conversationBridge");
        Intrinsics.checkNotNullParameter(r125, "contentBridge");
        Intrinsics.checkNotNullParameter(r126, "actionMenuPresenter");
        Intrinsics.checkNotNullParameter(r127, "sideBarTabInfo");
        Intrinsics.checkNotNullParameter(r130, "groupByProvider");
        Intrinsics.checkNotNullParameter(r131, "sortTypeProvider");
        Intrinsics.checkNotNullParameter(r132, "onCreateBlankProject");
        Intrinsics.checkNotNullParameter(r133, "onProjectCollapse");
        Intrinsics.checkNotNullParameter(r135, "onCreateConversationInProject");
        Intrinsics.checkNotNullParameter(r136, "onRenameProject");
        Intrinsics.checkNotNullParameter(r137, "onHideProjectConversations");
        Intrinsics.checkNotNullParameter(r138, "onRemoveProject");
        IProjectListDataSource r140 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        ImSdkSideBarProjectImService r141 = ImSdkSideBarProjectImService.f345306a;
        Intrinsics.checkNotNullParameter(r120, "coroutineScope");
        Intrinsics.checkNotNullParameter(r122, "pagingConfig");
        Intrinsics.checkNotNullParameter(r123, "projectConversationPagingConfig");
        Intrinsics.checkNotNullParameter(r139, "displayPolicy");
        Intrinsics.checkNotNullParameter(r141, "imService");
        Intrinsics.checkNotNullParameter(r124, "conversationBridge");
        Intrinsics.checkNotNullParameter(r125, "contentBridge");
        Intrinsics.checkNotNullParameter(r126, "actionMenuPresenter");
        Intrinsics.checkNotNullParameter(r127, "sideBarTabInfo");
        Intrinsics.checkNotNullParameter(r130, "groupByProvider");
        Intrinsics.checkNotNullParameter(r131, "sortTypeProvider");
        Intrinsics.checkNotNullParameter(r132, "onCreateBlankProject");
        Intrinsics.checkNotNullParameter(r133, "onProjectCollapse");
        Intrinsics.checkNotNullParameter(r135, "onCreateConversationInProject");
        Intrinsics.checkNotNullParameter(r136, "onRenameProject");
        Intrinsics.checkNotNullParameter(r137, "onHideProjectConversations");
        Intrinsics.checkNotNullParameter(r138, "onRemoveProject");
        int r142 = ImProjectSource.f345271w;
        w0 r143 = w0.f344543a;
        Intrinsics.checkNotNullParameter(r141, "imService");
        Intrinsics.checkNotNullParameter(r123, "conversationPagingConfig");
        Intrinsics.checkNotNullParameter(r120, "coroutineScope");
        Intrinsics.checkNotNullParameter(r143, "expandStore");
        r102 = new com.larus.home.impl.main.side_bar.view.group.render.i0(new ImProjectSource(r140, r123, r120, r143), r122, r115, r139, r120, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138);
        if (r102 != r103) goto L17;
        return r103;
    L17:
        r110 = r111;
        r106 = SlashMentionConfig.SLASH_CONTENT_PROJECT;
        r108 = r112;
        r109 = r113;
    L7:
        r100 = new ProjectModule$build$1(this, r610);
        goto L8
    }
}
