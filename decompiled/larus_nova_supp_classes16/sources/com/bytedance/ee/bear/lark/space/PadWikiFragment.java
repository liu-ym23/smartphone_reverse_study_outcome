package com.bytedance.ee.bear.lark.space;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/lark/space/PadWikiFragment;", "Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "bindWikiData", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "", "provideHasTemplate", "", "isWiki", "getLogTag", "getWikiList", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PadWikiFragment extends BasePadHomeFragment {

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.creationmenu.f {
        public final /* synthetic */ PadWikiFragment a;

        public b(PadWikiFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.creationmenu.f
        public final void a(com.bytedance.ee.bear.creationmenu.g r3) {
            Intrinsics.checkNotNullParameter(r3, "menuItem");
            tt5.a.h("PadWikiFragment", "onWikiItemClick: , itemId = " + r3.c.id());
            yp5.e.a(this.a.getContext(), r3.c.id());
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<DocPageEnum> fa0() {
        return null;
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String getLogTag() {
        return "PadWikiFragment";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<ad5.e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new ad5.e(HomeTabEnum.WIKI.id, 2131888328, WikiHomeFragment2.class.getName()));
        return r0;
    }

    public final void ga0() {
        com.bytedance.ee.bear.creationmenu.c r1 = this.n;
        if (r1 != null) goto L5;
    L39:
        com.bytedance.ee.bear.creationmenu.c r2 = this.n;
        if (r2 == null) goto L54;
        ArrayList r3 = new ArrayList();
        SelectCreationMenuConfig r4 = com.bytedance.ee.bear.wikiv2.create.g.a();
        PermissionRequest r5 = new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "UPLOAD");
        PermissionResponse r6 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r5, null);
        gj5.c r7 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, "");
        if (r6 == null) goto L44;
        boolean r8 = r6.getAllow();
    L46:
        if (r4.k == false) goto L52;
        boolean r9 = r8;
        r3.add(new com.bytedance.ee.bear.creationmenu.g(r4.f, r9, SelectIndex.MEDIA, kac.a.b(2131254464), 2131887224));
        boolean r10 = r4.g;
        SelectIndex r11 = SelectIndex.FILE;
        if (en4.a.l() == false) goto L50;
        int r12 = 2131254725;
    L51:
        boolean r13 = r8;
        r3.add(new com.bytedance.ee.bear.creationmenu.g(r10, r13, r11, kac.a.b(r12), 2131887223));
        goto L52
    L50:
        r12 = 2131256271;
    L52:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.y = r3;
        return;
    L44:
        r8 = r7.a;
        goto L46
    L54:
        return;
    L5:
        if (yp5.c.a() == false) goto L25;
        ArrayList r14 = new ArrayList();
        SelectCreationMenuConfig r16 = com.bytedance.ee.bear.wikiv2.create.g.a();
        if (r16.p == false) goto L10;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.i, true, SelectIndex.DOCX, kac.a.b(2131254436), 2131887745));
    L10:
        if (r16.c == false) goto L12;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.b, true, SelectIndex.SHEET, com.bytedance.ee.bear.wikiv2.create.a.c(), 2131887733));
    L12:
        com.bytedance.ee.bear.wikiv2.create.a.a(r14);
        if (r16.q == true) goto L18;
        if (r16.l == false) goto L18;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L18:
        if (r16.o == false) goto L21;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.h, true, SelectIndex.BITABLE, kac.a.b(2131254400), 2131887715));
    L21:
        if (r16.q == false) goto L38;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.j, true, SelectIndex.SURVEY, kac.a.b(2131254460), 2131886600));
        if (r16.l == false) goto L38;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r16.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L38:
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r1.x = r14;
        goto L39
    L25:
        r14 = new ArrayList();
        SelectCreationMenuConfig r17 = com.bytedance.ee.bear.wikiv2.create.g.a();
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.a, true, SelectIndex.DOC, kac.a.b(2131254431), 2131887745));
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.b, true, SelectIndex.SHEET, com.bytedance.ee.bear.wikiv2.create.a.c(), 2131887733));
        com.bytedance.ee.bear.wikiv2.create.a.a(r14);
        if (r17.q == true) goto L31;
        if (r17.l == false) goto L31;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L31:
        if (r17.o == false) goto L34;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.h, true, SelectIndex.BITABLE, kac.a.b(2131254400), 2131887715));
    L34:
        if (r17.q == false) goto L38;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.j, true, SelectIndex.SURVEY, kac.a.b(2131254460), 2131886600));
        if (r17.l == false) goto L38;
        r14.add(new com.bytedance.ee.bear.creationmenu.g(r17.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
        goto L38
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final String ca0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131887849);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("PadWikiFragment", "onDestroyView() called this:" + hashCode());
    }

    public PadWikiFragment() {
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final void Y90() {
        ga0();
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        WikiCreateSelectPanelDialog._ViewModel r1 = ViewModelProviders.of(r0).get(WikiCreateSelectPanelDialog._ViewModel.class);
    L5:
        this.o = new b(this);
        super.onViewCreated(r3, r4);
        ga0();
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        tt5.a.h("PadWikiFragment", "onCreateView() called with:  this:" + hashCode() + " inflater = " + r3 + ", container = " + r4 + ", savedInstanceState = " + r5);
        return r3.inflate(2131561231, r4, false);
    }
}
