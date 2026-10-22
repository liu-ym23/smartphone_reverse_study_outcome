package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001UB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0016J$\u00103\u001a\u00020\t2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020-H\u0016J\b\u0010@\u001a\u00020-H\u0016J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020-H\u0016J\b\u0010E\u001a\u00020-H\u0016J\b\u0010F\u001a\u00020-H\u0016J\u001a\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020-H\u0016J\b\u0010M\u001a\u00020-H\u0016J\b\u0010N\u001a\u00020-H\u0016J\u0010\u0010N\u001a\u00020-2\u0006\u0010B\u001a\u00020OH\u0016J\"\u0010A\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010\t2\u0006\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020CH\u0016J\b\u0010R\u001a\u00020-H\u0016J\u0012\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010S\u001a\u00020-H\u0016J\n\u0010T\u001a\u0004\u0018\u00010/H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter$IDependence;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/IWikiMakeCopyDependence;", "Lcom/bytedance/ee/bear/list/selector/FolderSelectDependence;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "getSelectorConfig", "()Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "setSelectorConfig", "(Lcom/bytedance/ee/bear/list/selector/SelectorConfig;)V", "presenter", "Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;", "getPresenter", "()Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;", "setPresenter", "(Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;)V", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "getTrigger", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "setTrigger", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;)V", "command", "Lcom/bytedance/ee/bear/list/selector/ICommand;", "getCommand", "()Lcom/bytedance/ee/bear/list/selector/ICommand;", "setCommand", "(Lcom/bytedance/ee/bear/list/selector/ICommand;)V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initMVP", "getUserComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "onDestroyView", "selectCurrent", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "back", "openSearch", "finish", "finishWithIntent", "intent", "Landroid/content/Intent;", "resultCode", "", "openMySpace", "openSharedSpace", "openWiki", "Lcom/bytedance/ee/bear/wikiv2/selector/IRootSelectContract$SelectorWikiClickBean;", "position", "openFolderBean", "openMyLibrary", "onCancelClick", "getContext", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RootSelectFragment extends Hilt_RootSelectFragment implements u.b, sq5.a, td5.b, d0c.c {
    public static final /* synthetic */ int m = 0;
    public View g;
    public SelectorConfig h;
    public u i;
    public com.bytedance.ee.bear.wikiv2.searchv2.a j;
    public td5.d k;

    @Inject
    public NetService l;

    public static final class a {
        public static Fragment a(FragmentManager r1, Context r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r1, "fragmentManager");
            Intrinsics.checkNotNullParameter(r2, "context");
            Fragment r4 = r1.getFragmentFactory().instantiate(r2.getClassLoader(), RootSelectFragment.class.getName());
            r4.setArguments(r3);
            return r4;
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void E5() {
        tt5.a.h("RootSelectFragment", "openMySpace()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.E5();
        return;
    }

    @Override // sq5.a
    public final ce5.a P50() {
        return new ce5.a(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b, td5.b
    public final void Ra() {
        tt5.a.h("RootSelectFragment", "openSearch()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.DR();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void U5() {
        tt5.a.h("RootSelectFragment", "openMyLibrary()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.U5();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void V6() {
        tt5.a.h("RootSelectFragment", "openWiki()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.V6();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void Z3() {
        tt5.a.h("RootSelectFragment", "openSharedSpace()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.Z3();
        return;
    }

    @Override // td5.b
    public final void back() {
        tt5.a.h("RootSelectFragment", "back()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L11;
        r0.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.onBackPressed();
        return;
    }

    @Override // td5.b
    public final void finish() {
        tt5.a.h("RootSelectFragment", "finish()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L11;
        r0.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void ke() {
        tt5.a.h("RootSelectFragment", "selectCurrent()...");
        Bundle r1 = getArguments();
        SpaceSelectorBean r2 = null;
        td5.d r3 = null;
        r3 = null;
        if (r1 == null) goto L5;
        SelectorConfig r13 = (SelectorConfig) r1.getParcelable("extra_config");
    L6:
        if (r13 == null) goto L8;
        SelectorType r4 = r13.a;
    L10:
        if (r4 != SelectorType.WIKI_MAKE_COPY_TO) goto L72;
        Bundle r14 = getArguments();
        Intrinsics.checkNotNullParameter(r13, "selectorConfig");
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(this, "dependence");
        boolean r0 = false;
        if (r14 == null) goto L14;
        boolean r5 = r14.getBoolean("src_origin_external");
    L15:
        if (r14 == null) goto L18;
        r0 = r14.getBoolean("src_is_shortcut");
    L18:
        if (r14 == null) goto L20;
        WikiSelectorBean r6 = (WikiSelectorBean) r14.getParcelable("extra_wiki_bean");
    L22:
        if (r6 != null) goto L25;
        tt5.a.d("MakeCopyToWikiWrapper", "selectorBean is null!");
    L56:
        RootSelectFragment r9 = this;
    L69:
        r9.k = r3;
        if (r3 == null) goto L88;
        r3.execute();
        return;
    L88:
        return;
    L25:
        if (r5 == false) goto L51;
        if (r0 == false) goto L51;
        if (r14 == null) goto L33;
        String r7 = r14.getString("src_space_id");
        if (r7 == null) goto L33;
        String r8 = r7;
    L34:
        if (r14 == null) goto L39;
        String r10 = r14.getString("src_parent_token");
        if (r10 == null) goto L39;
        String r11 = r10;
    L40:
        if (r14 == null) goto L42;
        r14.putParcelable("extra_space_bean", sq5.n.a(r14, r6.g));
    L42:
        sq5.b r12 = new sq5.b(this, r14, r8, r11, this);
        String r15 = r6.a;
        String r16 = r6.d;
        String r26 = sbb.e.c(r6.j);
        if (r13.g != 2026) goto L45;
        String r29 = "wiki_tree";
    L47:
        if (r6.n == false) goto L49;
        String r33 = "my_docs";
    L50:
        gq5.d.i(new gq5.d.C0238d("make_a_copy_to", r15, r15, r16, r26, null, null, r29, "default_location", null, "space", r33));
        r3 = r12;
        goto L56
    L49:
        r33 = DocumentType.WIKI_NAME;
        goto L50
    L45:
        r29 = "docs_topbar";
    L39:
        r11 = "";
    L33:
        r8 = "";
    L51:
        if (r14 == null) goto L53;
        WikiSelectorBean r17 = (WikiSelectorBean) r14.getParcelable("extra_wiki_bean");
    L54:
        if (r17 != null) goto L57;
        tt5.a.d("MakeCopyToWikiWrapper", "selectorBean is null!");
        goto L56
    L57:
        String r18 = r17.d;
        int r19 = r17.j;
        String r20 = r17.a;
        String r21 = r17.f;
        SelectorConfig r22 = r13;
        WikiSelectorBean r23 = r17;
        sq5.m r24 = new sq5.m(new sq5.e(this, r14, r18, r19, r20, r21, r17.g, r21, r20, r17.b, r17.e, r17.c, r17.k, r17.l, this));
        String r25 = r23.a;
        String r27 = r23.d;
        String r28 = sbb.e.c(r23.j);
        if (r22.g != 2026) goto L60;
        String r110 = "wiki_tree";
    L61:
        boolean r30 = r23.n;
        if (r30 == false) goto L64;
        String r111 = "my_docs";
    L65:
        if (r30 == false) goto L67;
        String r112 = "my_docs";
    L68:
        gq5.d.i(new gq5.d.C0238d("make_a_copy_to", r25, r25, r27, r28, null, null, r110, "default_location", null, r111, r112));
        r9 = this;
        r3 = r24;
        goto L69
    L67:
        r112 = DocumentType.WIKI_NAME;
        goto L68
    L64:
        r111 = DocumentType.WIKI_NAME;
        goto L65
    L60:
        r110 = "docs_topbar";
        goto L61
    L53:
        r17 = null;
        goto L54
    L20:
        r6 = null;
        goto L22
    L14:
        r5 = false;
        goto L15
    L72:
        SelectorConfig r113 = r13;
        if (r113 == null) goto L75;
        SelectorType r31 = r113.a;
    L77:
        if (r31 != SelectorType.SPACE_MAKE_COPY_TO) goto L90;
        Bundle r32 = getArguments();
        if (r32 == null) goto L81;
        r2 = (SpaceSelectorBean) r32.getParcelable("extra_space_bean");
    L81:
        if (r2 != null) goto L84;
        tt5.a.d("RootSelectFragment", "spaceSelectorBean is null");
        return;
    L84:
        String r34 = r2.c;
        if (r34 == null) goto L91;
        Context r35 = getContext();
        int r36 = sbb.e.f.b;
        FolderVersion.Companion.getClass();
        com.bytedance.ee.bear.list.folderselect.command.n r114 = new com.bytedance.ee.bear.list.folderselect.command.n(r35, r34, r36, 5, null, getArguments(), this, new ce5.a(this));
        this.k = r114;
        r114.execute();
        return;
    L91:
        return;
    L90:
        return;
    L75:
        r31 = null;
        goto L77
    L8:
        r4 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void onCancelClick() {
        tt5.a.h("RootSelectFragment", "onCancelClick()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L11;
        r0.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.finish();
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        d0c.c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_RootSelectFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        tt5.a.h("RootSelectFragment", "onDestroyView()...");
        u r0 = this.i;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        td5.d r1 = this.k;
        if (r1 == null) goto L9;
        r1.destroy();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m683provideComponent() {
        return provideComponent();
    }

    public RootSelectFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void RW(iq5.o r4) {
        Intrinsics.checkNotNullParameter(r4, "bean");
        tt5.a.h("RootSelectFragment", "openWiki()...position = " + r4.b);
        getContext();
        com.bytedance.ee.bear.wikiv2.searchv2.c r0 = new com.bytedance.ee.bear.wikiv2.searchv2.c(r4.e, r4.f, r4.c);
        Bundle r5 = getArguments();
        SelectorConfig r1 = this.h;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r1 = null;
    L6:
        com.bytedance.ee.bear.wikiv2.wikitreev2.j.b(r0, r5, r1.g, this);
    }

    @Override // td5.b
    public final void j7(td5.e r3) {
        Intrinsics.checkNotNullParameter(r3, "bean");
        tt5.a.h("RootSelectFragment", "openFolder()...folderType = " + r3.a);
        r3.e = FolderSource.SEARCH.getSource();
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.j7(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_RootSelectFragment
    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        tt5.a.h("RootSelectFragment", "onAttach()...");
        if ((r3 instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L6;
        this.j = (com.bytedance.ee.bear.wikiv2.searchv2.a) r3;
    L6:
        if (ForsetiHelper.p() == true) goto L8;
        return;
    L8:
        if (this.j == null) goto L10;
        return;
    L10:
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L15;
        com.bytedance.ee.bear.wikiv2.searchv2.a r4 = getParentFragment();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");
        this.j = r4;
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        tt5.a.h("RootSelectFragment", "onCreate()...");
    }

    @Override // sq5.a
    public final void ww(Intent r3) {
        tt5.a.h("RootSelectFragment", "finishWithIntent()...");
        bv(r3, -1);
    }

    @Override // td5.b
    public final void bv(Intent r3, int r4) {
        tt5.a.h("RootSelectFragment", "finishWithIntent()...resultCode = " + r4);
        if (ForsetiHelper.s(this) == false) goto L11;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L18;
        if (r3 == null) goto L9;
        Bundle r5 = r3.getExtras();
        if (r5 == null) goto L9;
    L10:
        r0.c(r4, r5);
        return;
    L9:
        r5 = new Bundle();
        goto L10
    L18:
        return;
    L11:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L14;
        r1.setResult(r4, r3);
    L14:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L20;
        r6.finish();
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        tt5.a.h("RootSelectFragment", "initMVP()...");
        Bundle r11 = getArguments();
        if (r11 == null) goto L6;
        SelectorConfig r12 = (SelectorConfig) r11.getParcelable("extra_config");
        if (r12 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.h = r12;
        ce5.a r6 = new ce5.a(this);
        View r13 = this.g;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r13 = null;
    L11:
        SelectorConfig r0 = this.h;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r0 = null;
    L15:
        getArguments();
        w r2 = new w(r13, r0, r6);
        SelectorConfig r1 = this.h;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r1 = null;
    L19:
        t r14 = new t(r1);
        SelectorConfig r3 = this.h;
        if (r3 == null) goto L22;
        SelectorConfig r4 = r3;
    L23:
        u r7 = new u(r14, r2, r4, getArguments(), this, r6);
        this.i = r7;
        r7.create();
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r4 = null;
    L6:
        r12 = new SelectorConfig();
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void tN(int r3, td5.e r4) {
        Intrinsics.checkNotNullParameter(r4, "openFolderBean");
        tt5.a.h("RootSelectFragment", "openFolder()...position = " + r3);
        com.bytedance.ee.bear.wikiv2.searchv2.a r5 = this.j;
        if (r5 == null) goto L6;
        r5.j7(r4);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131568237, r3, false);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g = r5;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L7:
        return r5;
    }
}
