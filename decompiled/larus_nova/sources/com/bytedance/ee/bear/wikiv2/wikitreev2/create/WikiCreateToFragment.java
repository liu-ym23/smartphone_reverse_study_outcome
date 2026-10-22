package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
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
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J&\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020<H\u0002J\b\u0010I\u001a\u00020<H\u0016J\u001e\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020<0NH\u0002J0\u0010O\u001a\u00020<2\u0006\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020LH\u0003J\"\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u000e2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020<H\u0002J#\u0010[\u001a\u00020<2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010L¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020<H\u0002J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u000eH\u0002J\b\u0010c\u001a\u00020LH\u0014J\u0010\u0010d\u001a\u00020<2\u0006\u0010e\u001a\u00020LH\u0014J\b\u0010f\u001a\u00020<H\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020aH\u0002J\b\u0010i\u001a\u00020aH\u0016J\b\u0010j\u001a\u00020<H\u0016J\n\u0010k\u001a\u0004\u0018\u00010lH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "getContract", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "setContract", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;)V", "rootView", "Landroid/view/View;", "titleBarHeight", "", "confirmView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;", "getConfirmView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;", "setConfirmView", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/NetObserveView;)V", "wikiDialog", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "getWikiDialog", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposes", "()Lio/reactivex/disposables/CompositeDisposable;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "wikiTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "wikiTreeCtrlView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlView", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiTreeView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "wikiOperateButton", "Landroid/widget/Button;", "getWikiOperateButton", "()Landroid/widget/Button;", "setWikiOperateButton", "(Landroid/widget/Button;)V", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "stickyHead", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemRootView;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "appbarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initTitleBar", "initAction", "checkUploadPerm", "focusToken", "", "callback", "Lkotlin/Function0;", "createDocument", "parentToken", "documentType", "title", "templateToken", "extraInfo", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setResultOkAndFinish", "reportWikiFileLocationSelectClick", "childrenFileType", "childrenPageToken", "(Ljava/lang/Integer;Ljava/lang/String;)V", "initContent", "isPositionValid", "", "position", "getDisableToken", "doFocusChange", WikiFolderPushPlugin.WIKI_TOKEN, "initSearchView", "setTitleBarVisible", "visible", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiCreateToFragment extends Hilt_WikiCreateToFragment implements d0c.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f241381v = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WikiTreeActivityContract f241382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f241383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f241384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f241385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WikiDialogs f241386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f241387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Inject
    public NetService f241388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BaseTitleBar f241389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WikiTreeCtrlView f241390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WikiTreeView f241391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Button f241392q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f241393r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WikItemRootView f241394s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WikiSearchPickerView f241395t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AppBarLayout f241396u;

    public static final class a {
    }

    static {
    }

    public String Z90() {
        return "";
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final WikiTreeActivityContract Y90() {
        WikiTreeActivityContract r100 = this.f241382g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        return null;
    }

    public void initAction() {
        Button r100 = this.f241392q;
        if (r100 == null) goto L5;
        this.f241385j = new b(this, r100);
    L5:
        b r101 = this.f241385j;
        if (r101 == null) goto L8;
        r101.f241402c = false;
    L8:
        if (r101 == null) goto L11;
        r101.a(new AnonymousClass2(this), null);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        WikiSearchPickerView r100 = this.f241395t;
        if (r100 == null) goto L6;
        r100.a();
    L6:
        if (super.onBackPressed() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public WikiCreateToFragment() {
        this.f241386k = new WikiDialogs();
        this.f241387l = new CompositeDisposable();
    }

    public final void ba0() {
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L11;
        r100.c(-1, new Bundle());
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.setResult(-1, null);
        r101.finish();
        return;
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        KeyEventDispatcher.Component r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return ((d0c.c) r100).e9();
    L6:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.Hilt_WikiCreateToFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f241386k.c();
        this.f241387l.clear();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public void X90(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        b r101 = this.f241385j;
        if (r101 == null) goto L6;
        r101.f241402c = !TextUtils.isEmpty(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        WikiTreeActivityContract r102 = (WikiTreeActivityContract) r101.getParcelable(WikiTreeActivityContract.class.getName());
    L6:
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f241382g = r102;
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
        r102 = null;
        goto L6
    }

    public static final void W90(WikiCreateToFragment r100, boolean r101) {
        AppBarLayout r102 = r100.f241396u;
        if (r102 == null) goto L12;
        int r103 = 0;
        if (r101 == false) goto L7;
        int r104 = 0;
    L8:
        if (r101 == false) goto L10;
        r103 = r100.f241384i;
    L10:
        com.bytedance.ee.util.ui.g.b(r102, r104, r103).start();
        return;
    L7:
        r104 = r100.f241384i;
        goto L8
    }

    public static void aa0(WikiCreateToFragment r110, Integer r111) {
        WikiTreeCtrlView r100 = r110.f241390o;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Bundle r103 = r110.getArguments();
        if (r103 == null) goto L11;
        SpaceSelectorBean r104 = (SpaceSelectorBean) r103.getParcelable("extra_space_bean");
    L13:
        if (r104 == null) goto L15;
        String r112 = "space";
    L25:
        String r105 = gq5.d.j.b(r110.Y90().getPageMode(), r110.Y90().getCreateDocumentType());
        String r106 = r110.Y90().getSpaceId();
        String r107 = r110.Y90().getSrcSpaceId();
        String r108 = r110.Y90().getSrcToken();
        if (r111 == null) goto L28;
        String r113 = sbb.e.c(r111.intValue());
    L29:
        String r114 = r110.Y90().getTriggerLocation();
        if (r102 == false) goto L32;
        String r109 = "my_docs";
    L34:
        if (r102 == false) goto L36;
        String r115 = "my_docs";
    L37:
        gq5.d.i(new gq5.d.C6055d(r105, r106, r107, r108, r113, null, null, r114, r109, null, r112, r115));
        return;
    L36:
        r115 = "wiki";
        goto L37
    L32:
        r109 = "wiki";
        goto L34
    L28:
        r113 = null;
        goto L29
    L15:
        Bundle r116 = r110.getArguments();
        if (r116 == null) goto L22;
        WikiSelectorBean r117 = (WikiSelectorBean) r116.getParcelable("extra_wiki_bean");
        if (r117 == null) goto L22;
        if (r117.f241141n != true) goto L22;
        r101 = true;
    L22:
        if (r101 == false) goto L24;
        r112 = "my_docs";
        goto L25
    L24:
        r112 = "wiki";
        goto L25
    L11:
        r104 = null;
        goto L13
    L5:
        if (r100.n() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f241383h = r110;
        if (r110 == null) goto L5;
        BaseTitleBar r100 = (BaseTitleBar) r110.findViewById(R.id.wiki_title_bar);
    L6:
        this.f241389n = r100;
        this.f241390o = (WikiTreeCtrlView) r110.findViewById(R.id.wiki_tree_ctrl_view);
        this.f241391p = (WikiTreeView) r110.findViewById(R.id.wiki_tree_view);
        this.f241392q = (Button) r110.findViewById(R.id.wiki_operate_button);
        this.f241393r = (RecyclerView) r110.findViewById(R.id.recycler_view);
        this.f241394s = (WikItemRootView) r110.findViewById(R.id.sticky_head);
        this.f241395t = (WikiSearchPickerView) r110.findViewById(R.id.wiki_search_view);
        this.f241396u = (AppBarLayout) r110.findViewById(R.id.appbar_layout);
        BaseTitleBar r112 = this.f241389n;
        if (r112 == null) goto L10;
        r112.setTitle(Y90().getDocumentName());
    L10:
        if (ForsetiHelper.s(this) == false) goto L14;
        BaseTitleBar r113 = this.f241389n;
        if (r113 == null) goto L14;
        r113.setLeftClickListener(new q(this));
    L14:
        initAction();
        WikiSearchPickerView r114 = this.f241395t;
        if (r114 == null) goto L22;
        WikiTreeActivityContract r101 = Y90();
        if (r101 == null) goto L20;
        String r102 = r101.getSpaceId();
        if (r102 == null) goto L20;
    L21:
        r114.c(this, r102, false);
    L20:
        r102 = "";
    L22:
        WikiSearchPickerView r115 = this.f241395t;
        if (r115 == null) goto L25;
        r115.setSearchViewDelegate(new p(this));
    L25:
        WikiTreeCtrlView r116 = this.f241390o;
        if (r116 == null) goto L28;
        String r103 = Y90().getSpaceId();
        String r104 = Y90().getDocumentToken();
        WikiTreeCtrlView.c r105 = new WikiTreeCtrlView.c();
        String r106 = Z90();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f242318a = r106;
        List<? extends Function<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j, Boolean>> r107 = CollectionsKt.listOf(new k());
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f242330m = r107;
        r105.f242319b = false;
        r105.f242320c = false;
        r105.f242329l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(getViewLifecycleOwner(), new WeakReference(this.f241390o)));
        r105.f242321d = false;
        Intrinsics.checkNotNullParameter("Wiki_WikiCreateToFragment", "<set-?>");
        r105.f242333p = "Wiki_WikiCreateToFragment";
        r105.f242332o = CollectionsKt.listOf(new WikiItemNewDecoration(getContext(), null, l.f241418a));
        r105.f242325h = true;
        r105.f242326i = m.f241419a;
        Unit r117 = Unit.INSTANCE;
        r116.i(new f1(this, r103, r104, r105, new ce5.a(this)));
    L28:
        RecyclerView r118 = this.f241393r;
        if (r118 == null) goto L31;
        r118.addOnItemTouchListener(new WikiTreeItemTouchListener(WikiCreateToFragment$initContent$2.INSTANCE, new WikiCreateToFragment$initContent$3(this)));
    L31:
        WikItemRootView r119 = this.f241394s;
        if (r119 == null) goto L34;
        r119.setOnAddClickListener(new n(this));
    L34:
        WikiTreeView r120 = this.f241391p;
        if (r120 == null) goto L37;
        r120.setTitleRightMargin(com.bytedance.ee.util.ui.n.d(28));
    L37:
        WikiTreeView r121 = this.f241391p;
        if (r121 == null) goto L40;
        r121.setUserComponentAbility(new ce5.a(this));
    L40:
        WikiTreeCtrlView r122 = this.f241390o;
        if (r122 == null) goto L44;
        r122.setViewDelegate(new o(this));
        return;
    L44:
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static final void V90(WikiCreateToFragment r100, String r101, Function0 r102) {
        WikiTreeCtrlView r103 = r100.f241390o;
        if (r103 == null) goto L27;
        TreeNode r104 = r103.g(r101);
        if (r104 == null) goto L30;
        boolean r105 = true;
        if (r104.wiki_node_type != 2) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L21;
        WikiTreeCtrlView r107 = r100.f241390o;
        if (r107 != null) goto L15;
    L17:
        r105 = false;
    L18:
        if (r105 == false) goto L20;
        r102.invoke();
        return;
    L20:
        Toast.showFailureText(r100.getContext(), R.string.LarkCCM_Docs_ActionFailed_NoTargetPermission_Mob);
        return;
    L15:
        if (r107.getCanCreate() != true) goto L17;
    L21:
        CompositeDisposable r108 = r100.f241387l;
        NetService r109 = r100.f241388m;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        r109 = null;
    L25:
        r108.add(new GetNodePermPuller(r109).d(new GetNodePermPuller.Params(r100.Y90().getSpaceId(), r101)).doOnSubscribe(new c(r100)).doFinally(new d(r100)).subscribe(new e(r102, r100), new f(r100)));
        return;
    L10:
        r106 = false;
        goto L11
    L30:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        tt5.a.h("Wiki_WikiCreateToFragment", "onActivityResult()...requestCode = " + r100 + ", resultCode = " + r101);
        if (r101 != (-1)) goto L6;
        ba0();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_tree_create_fragment, r101, false);
    }
}
