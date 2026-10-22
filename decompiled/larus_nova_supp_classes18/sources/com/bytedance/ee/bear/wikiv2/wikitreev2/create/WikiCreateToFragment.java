package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiTreeItemTouchListener;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J&\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020<H\u0002J\b\u0010I\u001a\u00020<H\u0016J\u001e\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020<0NH\u0002J0\u0010O\u001a\u00020<2\u0006\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020LH\u0003J\"\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u000e2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020<H\u0002J#\u0010[\u001a\u00020<2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010L¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020<H\u0002J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u000eH\u0002J\b\u0010c\u001a\u00020LH\u0014J\u0010\u0010d\u001a\u00020<2\u0006\u0010e\u001a\u00020LH\u0014J\b\u0010f\u001a\u00020<H\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020aH\u0002J\b\u0010i\u001a\u00020aH\u0016J\b\u0010j\u001a\u00020<H\u0016J\n\u0010k\u001a\u0004\u0018\u00010lH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "getContract", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "setContract", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;)V", "rootView", "Landroid/view/View;", "titleBarHeight", "", "confirmView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;", "getConfirmView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;", "setConfirmView", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;)V", "wikiDialog", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "getWikiDialog", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposes", "()Lio/reactivex/disposables/CompositeDisposable;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "wikiTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "wikiTreeCtrlView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlView", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiTreeView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "wikiOperateButton", "Landroid/widget/Button;", "getWikiOperateButton", "()Landroid/widget/Button;", "setWikiOperateButton", "(Landroid/widget/Button;)V", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "stickyHead", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "appbarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initTitleBar", "initAction", "checkUploadPerm", "focusToken", "", "callback", "Lkotlin/Function0;", "createDocument", "parentToken", "documentType", "title", "templateToken", "extraInfo", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "setResultOkAndFinish", "reportWikiFileLocationSelectClick", "childrenFileType", "childrenPageToken", "(Ljava/lang/Integer;Ljava/lang/String;)V", "initContent", "isPositionValid", "", "position", "getDisableToken", "doFocusChange", WikiFolderPushPlugin.WIKI_TOKEN, "initSearchView", "setTitleBarVisible", "visible", "onBackPressed", "onDestroy", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiCreateToFragment extends Hilt_WikiCreateToFragment implements d0c.c {
    public static final /* synthetic */ int v = 0;
    public WikiTreeActivityContract g;
    public View h;
    public int i;
    public b j;
    public final WikiDialogs k;
    public final CompositeDisposable l;

    @Inject
    public NetService m;
    public BaseTitleBar n;
    public WikiTreeCtrlView o;
    public WikiTreeView p;
    public Button q;
    public RecyclerView r;
    public WikItemRootView s;
    public WikiSearchPickerView t;
    public AppBarLayout u;

    public static final class a {
    }

    static {
    }

    public String Z90() {
        return "";
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

    public final WikiTreeActivityContract Y90() {
        WikiTreeActivityContract r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        return null;
    }

    public void initAction() {
        Button r0 = this.q;
        if (r0 == null) goto L5;
        this.j = new b(this, r0);
    L5:
        b r1 = this.j;
        if (r1 == null) goto L8;
        r1.c = false;
    L8:
        if (r1 == null) goto L11;
        r1.a(new AnonymousClass2(this), null);
        return;
    }

    public final boolean onBackPressed() {
        WikiSearchPickerView r0 = this.t;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (super.onBackPressed() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public WikiCreateToFragment() {
        this.k = new WikiDialogs();
        this.l = new CompositeDisposable();
    }

    public final void ba0() {
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L11;
        r0.c(-1, new Bundle());
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.setResult(-1, null);
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

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.Hilt_WikiCreateToFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public void onDestroy() {
        super.onDestroy();
        this.k.c();
        this.l.clear();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m696provideComponent() {
        return provideComponent();
    }

    public void X90(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        b r0 = this.j;
        if (r0 == null) goto L6;
        r0.c = !TextUtils.isEmpty(r2);
        return;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        WikiTreeActivityContract r4 = (WikiTreeActivityContract) r3.getParcelable(WikiTreeActivityContract.class.getName());
    L6:
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.g = r4;
        if (Y90().getPageMode() != 2) goto L11;
        qc5.a.j();
        return;
    L11:
        if (Y90().getPageMode() != 4) goto L15;
        qc5.a.j();
        return;
    L15:
        if (Y90().getPageMode() != 3) goto L18;
        return;
    L18:
        if (Y90().getPageMode() != 1) goto L20;
        return;
    L20:
        gq5.d.j(gq5.d.j.b(Y90().getPageMode(), Y90().getCreateDocumentType()), Y90().getSpaceId());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final void W90(WikiCreateToFragment r3, boolean r4) {
        AppBarLayout r0 = r3.u;
        if (r0 == null) goto L12;
        int r1 = 0;
        if (r4 == false) goto L7;
        int r2 = 0;
    L8:
        if (r4 == false) goto L10;
        r1 = r3.i;
    L10:
        com.bytedance.ee.util.ui.g.b(r0, r2, r1).start();
        return;
    L7:
        r2 = r3.i;
        goto L8
    }

    public static void aa0(WikiCreateToFragment r14, Integer r15) {
        WikiTreeCtrlView r0 = r14.o;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Bundle r3 = r14.getArguments();
        if (r3 == null) goto L11;
        SpaceSelectorBean r4 = (SpaceSelectorBean) r3.getParcelable("extra_space_bean");
    L13:
        if (r4 == null) goto L15;
        String r11 = "space";
    L25:
        String r5 = gq5.d.j.b(r14.Y90().getPageMode(), r14.Y90().getCreateDocumentType());
        String r6 = r14.Y90().getSpaceId();
        String r7 = r14.Y90().getSrcSpaceId();
        String r8 = r14.Y90().getSrcToken();
        if (r15 == null) goto L28;
        String r16 = sbb.e.c(r15.intValue());
    L29:
        String r17 = r14.Y90().getTriggerLocation();
        if (r2 == false) goto L32;
        String r9 = "my_docs";
    L34:
        if (r2 == false) goto L36;
        String r12 = "my_docs";
    L37:
        gq5.d.i(new gq5.d.C0238d(r5, r6, r7, r8, r16, null, null, r17, r9, null, r11, r12));
        return;
    L36:
        r12 = DocumentType.WIKI_NAME;
        goto L37
    L32:
        r9 = DocumentType.WIKI_NAME;
        goto L34
    L28:
        r16 = null;
        goto L29
    L15:
        Bundle r10 = r14.getArguments();
        if (r10 == null) goto L22;
        WikiSelectorBean r13 = (WikiSelectorBean) r10.getParcelable("extra_wiki_bean");
        if (r13 == null) goto L22;
        if (r13.n != true) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        r11 = "my_docs";
        goto L25
    L24:
        r11 = DocumentType.WIKI_NAME;
        goto L25
    L11:
        r4 = null;
        goto L13
    L5:
        if (r0.n() != true) goto L7;
        r2 = true;
        goto L8
    }

    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        this.h = r10;
        if (r10 == null) goto L5;
        BaseTitleBar r0 = (BaseTitleBar) r10.findViewById(2131393265);
    L6:
        this.n = r0;
        this.o = (WikiTreeCtrlView) r10.findViewById(2131393267);
        this.p = (WikiTreeView) r10.findViewById(2131393270);
        this.q = (Button) r10.findViewById(2131393237);
        this.r = r10.findViewById(2131384076);
        this.s = (WikItemRootView) r10.findViewById(2131387355);
        this.t = (WikiSearchPickerView) r10.findViewById(2131393253);
        this.u = r10.findViewById(2131363115);
        BaseTitleBar r12 = this.n;
        if (r12 == null) goto L10;
        r12.setTitle(Y90().getDocumentName());
    L10:
        if (ForsetiHelper.s(this) == false) goto L14;
        BaseTitleBar r13 = this.n;
        if (r13 == null) goto L14;
        r13.setLeftClickListener(new q(this));
    L14:
        initAction();
        WikiSearchPickerView r14 = this.t;
        if (r14 == null) goto L22;
        WikiTreeActivityContract r1 = Y90();
        if (r1 == null) goto L20;
        String r2 = r1.getSpaceId();
        if (r2 == null) goto L20;
    L21:
        r14.c(this, r2, false);
    L20:
        r2 = "";
    L22:
        WikiSearchPickerView r15 = this.t;
        if (r15 == null) goto L25;
        r15.setSearchViewDelegate(new p(this));
    L25:
        WikiTreeCtrlView r16 = this.o;
        if (r16 == null) goto L28;
        String r4 = Y90().getSpaceId();
        String r5 = Y90().getDocumentToken();
        WikiTreeCtrlView.c r6 = new WikiTreeCtrlView.c();
        String r3 = Z90();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r6.a = r3;
        List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r7 = CollectionsKt.listOf(new k());
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.m = r7;
        r6.b = false;
        r6.c = false;
        r6.l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(getViewLifecycleOwner(), new WeakReference(this.o)));
        r6.d = false;
        Intrinsics.checkNotNullParameter("Wiki_WikiCreateToFragment", "<set-?>");
        r6.p = "Wiki_WikiCreateToFragment";
        r6.o = CollectionsKt.listOf(new WikiItemNewDecoration(getContext(), null, l.a));
        r6.h = true;
        r6.i = m.a;
        Unit r17 = Unit.INSTANCE;
        r16.i(new f1(this, r4, r5, r6, new ce5.a(this)));
    L28:
        RecyclerView r18 = this.r;
        if (r18 == null) goto L31;
        r18.addOnItemTouchListener(new WikiTreeItemTouchListener(WikiCreateToFragment$initContent$2.INSTANCE, new WikiCreateToFragment$initContent$3(this)));
    L31:
        WikItemRootView r19 = this.s;
        if (r19 == null) goto L34;
        r19.setOnAddClickListener(new n(this));
    L34:
        WikiTreeView r110 = this.p;
        if (r110 == null) goto L37;
        r110.setTitleRightMargin(com.bytedance.ee.util.ui.n.d(28));
    L37:
        WikiTreeView r111 = this.p;
        if (r111 == null) goto L40;
        r111.setUserComponentAbility(new ce5.a(this));
    L40:
        WikiTreeCtrlView r112 = this.o;
        if (r112 == null) goto L44;
        r112.setViewDelegate(new o(this));
        return;
    L44:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final void V90(WikiCreateToFragment r4, String r5, Function0 r6) {
        WikiTreeCtrlView r0 = r4.o;
        if (r0 == null) goto L27;
        TreeNode r1 = r0.g(r5);
        if (r1 == null) goto L30;
        boolean r2 = true;
        if (r1.wiki_node_type != 2) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L21;
        WikiTreeCtrlView r7 = r4.o;
        if (r7 != null) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L20;
        r6.invoke();
        return;
    L20:
        Toast.showFailureText(r4.getContext(), 2131888937);
        return;
    L15:
        if (r7.getCanCreate() != true) goto L17;
    L21:
        CompositeDisposable r8 = r4.l;
        NetService r9 = r4.m;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        r9 = null;
    L25:
        r8.add(new GetNodePermPuller(r9).d(new GetNodePermPuller.Params(r4.Y90().getSpaceId(), r5)).doOnSubscribe(new c(r4)).doFinally(new d(r4)).subscribe(new e(r6, r4), new f(r4)));
        return;
    L10:
        r3 = false;
        goto L11
    L30:
        return;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        tt5.a.h("Wiki_WikiCreateToFragment", "onActivityResult()...requestCode = " + r2 + ", resultCode = " + r3);
        if (r3 != (-1)) goto L6;
        ba0();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568267, r3, false);
    }
}
