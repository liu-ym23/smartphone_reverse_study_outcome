package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements WikiSpaceListView.b {
    public final /* synthetic */ WikiSpaceListFragment a;

    public b(WikiSpaceListFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceListView.b
    public final void a(SpaceBean r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "space");
        Fragment r0 = this.a;
        String r1 = r8.space_id;
        String r2 = r8.space_name;
        WikiDocument r10 = zp5.a.c(r8);
        int r3 = WikiSpaceListFragment.m;
        r0.getClass();
        WikiTreeActivityContract r4 = new WikiTreeActivityContract();
        r4.setSpaceId(r1);
        r4.setDocumentToken("");
        r4.setDocumentName(r2);
        r4.setWikiDocument(r10);
        String r11 = r0.getTAG();
        StringBuilder r5 = new StringBuilder("args?=");
        boolean r6 = true;
        if (((WikiSpaceTabViewModel) r0.j.getValue()).getArgs() != null) goto L5;
        boolean r7 = true;
    L6:
        r5.append(r7);
        tt5.a.h(r11, r5.toString());
        WikiSpaceListArgs r12 = ((WikiSpaceTabViewModel) r0.j.getValue()).getArgs();
        if (r12 == null) goto L9;
        r4.setPageMode(r12.getPageMode());
        r4.setCreateDocumentType(r12.getCreateDocumentType());
        r4.setSrcToken(r12.getSrcToken());
        r4.setSrcObjType(r12.getSrcObjType());
        r4.setSrcParentToken(r12.getSrcParentToken());
        r4.setSrcIsLock(r12.getSrcIsLock());
        r4.setSrcSpaceId(r12.getSrcSpaceId());
        r4.setSrcTitle(r12.getTitle());
        r4.setTriggerLocation(r12.getTriggerLocation());
        r4.setSrcIsShortcut(r12.getSrcIsShortcut());
        r4.setSrcOriginWikiToken(r12.getSrcOriginWikiToken());
        r4.setSrcOriginSpaceId(r12.getSrcOriginSpaceId());
        r4.setSrcFileSize(r12.getSrcFileSize());
    L9:
        RouteBean r13 = new RouteBean();
        r13.a(r0);
        r13.q = RouteBean.DestStyle.FLOAT;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/wikiv2/treehome/activity", r13).o(WikiTreeActivityContract.class.getName(), r4).h(r0.getArguments()).k(0).e();
        WikiSpaceListViewModel r14 = this.a.W90().f;
        if (r14 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r14 = null;
    L12:
        gq5.c.b("select_space", "all_workspaces", -1, hu5.a.c((Collection) r14.getSpaceList().getValue()), r9);
        WikiSpaceListArgs r15 = ((WikiSpaceTabViewModel) this.a.j.getValue()).getArgs();
        if (r15 != null) goto L15;
    L17:
        r6 = false;
    L18:
        if (r6 == false) goto L21;
        gq5.d.f("workspace", "ccm_wiki_tree_view", null, 12);
        return;
    L21:
        return;
    L15:
        if (r15.getPageMode() != 0) goto L17;
    L5:
        r7 = false;
        goto L6
    }
}
