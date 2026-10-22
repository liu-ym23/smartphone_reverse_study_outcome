package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiEmptyView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0016J\b\u0010M\u001a\u00020AH\u0002J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020O2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J\b\u0010`\u001a\u000206H\u0016J%\u0010a\u001a\u0002062\n\b\u0002\u0010b\u001a\u0004\u0018\u00010c2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010eH\u0002¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u000206H\u0002J\b\u0010h\u001a\u000206H\u0002J\b\u0010i\u001a\u000206H\u0002J\b\u0010j\u001a\u000206H\u0016J\b\u0010k\u001a\u00020AH\u0016J\b\u0010l\u001a\u00020AH\u0002J\"\u0010m\u001a\u0002062\u0006\u0010n\u001a\u00020e2\u0006\u0010o\u001a\u00020e2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\n\u0010r\u001a\u0004\u0018\u00010sH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010*8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u0001008FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020E8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010J\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010?\u001a\u0004\bJ\u0010K¨\u0006u"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiTreeFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiFloatingTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getWikiFloatingTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setWikiFloatingTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "wikiCoverViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "getWikiCoverViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "setWikiCoverViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "commonCreateButtonFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getCommonCreateButtonFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setCommonCreateButtonFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "wikiEmptyViewStubFromXml", "Landroid/view/ViewStub;", "getWikiEmptyViewStubFromXml", "()Landroid/view/ViewStub;", "setWikiEmptyViewStubFromXml", "(Landroid/view/ViewStub;)V", "wikiCoordinatorLayoutFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;", "getWikiCoordinatorLayoutFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;", "setWikiCoordinatorLayoutFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceHomeViewModel;", "flexCollapseView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiFlexCollapseView;", "getFlexCollapseView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiFlexCollapseView;", "flexCollapseView$delegate", "Lkotlin/Lazy;", "eptInit", "", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "isFgOnBackPress", "()Z", "isFgOnBackPress$delegate", "enableWikiTreeConsumeStatusBar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "setCover", "bindView", "bindListener", LiveCommonConstants.REASON_ON_DEDTROY, "showEmptyView", LynxError.LYNX_THROWABLE, "", "code", "", "(Ljava/lang/Throwable;Ljava/lang/Integer;)V", "initEmptyView", "showSearching", "hideSearching", "onResume", "onBackPressed", "handleBackPress", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreeFragment extends Hilt_WikiTreeFragment implements d0c.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f241489u = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WikiTreeCtrlView f241490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseTitleBar f241491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SpaceCoverView f241492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WikiSearchPickerView f241493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommonCreateButton f241494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WikiEmptyView f241495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewStub f241496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WikiCoverCoordinatorLayout f241497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SpaceHomeViewModel f241498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f241499p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f241500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WikiSearchPickerView f241501r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Inject
    public NetService f241502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f241503t;

    public static final class a {
    }

    public static final class b implements sa5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiTreeFragment f241504a;

        public b(WikiTreeFragment r100) {
            this.f241504a = r100;
        }

        @Override // sa5.d
        public final boolean onBackPressed() {
            return this.f241504a.onBackPressed();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiTreeFragment f241505a;

        public c(WikiTreeFragment r100) {
            this.f241505a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ForsetiViewMode r101 = (ForsetiViewMode) r100;
            if (r101 != null) goto L5;
        L9:
            WikiTreeCtrlView r102 = this.f241505a.Y90();
            if (r102 == null) goto L15;
            r102.setUploadViewVisible(true);
            return;
        L15:
            return;
        L5:
            if (r101.isCompact() == true) goto L9;
            WikiTreeCtrlView r103 = this.f241505a.Y90();
            if (r103 == null) goto L13;
            r103.setUploadViewVisible(false);
            return;
        }
    }

    static {
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

    public final CommonCreateButton V90() {
        View r100 = this.f241494k;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.common_create_button);
    L8:
        this.f241494k = (CommonCreateButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonCreateButton) r100;
    }

    public final SpaceCoverView W90() {
        View r100 = this.f241492i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wiki_cover_view);
    L8:
        this.f241492i = (SpaceCoverView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceCoverView) r100;
    }

    public final WikiEmptyView X90() {
        View r100 = this.f241495l;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiEmptyView);
    L8:
        this.f241495l = (WikiEmptyView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiEmptyView) r100;
    }

    public final WikiTreeCtrlView Y90() {
        View r100 = this.f241490g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wiki_tree_ctrl_view);
    L8:
        this.f241490g = (WikiTreeCtrlView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiTreeCtrlView) r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        if (((Boolean) this.f241503t.getValue()).booleanValue() == false) goto L21;
        WikiSearchPickerView r100 = this.f241501r;
        if (r100 == null) goto L16;
        StringBuilder r101 = new StringBuilder("isShow: ");
        if (r100.getVisibility() != 0) goto L9;
        boolean r102 = true;
    L10:
        r101.append(r102);
        tt5.a.h("WikiSearchPickerView", r101.toString());
        if (r100.getVisibility() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 != true) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L21;
        WikiSearchPickerView r105 = this.f241501r;
        if (r105 == null) goto L34;
        r105.a();
    L34:
        return true;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = false;
    L16:
        r104 = false;
    L21:
        WikiSearchPickerView r106 = this.f241501r;
        if (r106 == null) goto L25;
        r106.a();
    L25:
        if (ForsetiHelper.i() == true) goto L28;
    L30:
        boolean r107 = false;
    L31:
        if (r107 == true) goto L34;
        if (super.onBackPressed() == true) goto L34;
        return false;
    L28:
        if (ForsetiHelper.c(this) == false) goto L30;
        tt5.a.h("Wiki_WikiTreeFragment", "is forseti and splitWindowState do goback");
        r107 = true;
        goto L31
    }

    public WikiTreeFragment() {
        this.f241499p = LazyKt.lazy(new WikiTreeFragment$flexCollapseView$2(this));
        this.f241503t = LazyKt.lazy(WikiTreeFragment$isFgOnBackPress$2.INSTANCE);
    }

    public final void Z90() {
        SpaceCoverView r100 = W90();
        SpaceHomeViewModel r101 = this.f241498o;
        SpaceHomeViewModel r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        SpaceInfo r103 = r101.getSpaceInfo();
        if (r103 == null) goto L8;
        String r104 = r103.getSpaceName();
    L9:
        r100.setTitle(r104);
        SpaceCoverView r105 = W90();
        SpaceHomeViewModel r106 = this.f241498o;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r106 = null;
    L12:
        SpaceInfo r107 = r106.getSpaceInfo();
        if (r107 == null) goto L15;
        SpaceInfo.SpaceCover r108 = r107.space_cover;
    L16:
        r105.setCover(r108);
        SpaceCoverView r109 = W90();
        SpaceHomeViewModel r110 = this.f241498o;
        if (r110 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r110 = null;
    L19:
        r109.setMoreVisible(r110.canViewCollaborator());
        SpaceCoverView r111 = W90();
        SpaceHomeViewModel r112 = this.f241498o;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r112 = null;
    L22:
        SpaceInfo r113 = r112.getSpaceInfo();
        if (r113 == null) goto L25;
        String r114 = r113.tenant_id;
    L26:
        boolean r115 = up5.i.a(r114);
        SpaceHomeViewModel r116 = this.f241498o;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r116 = null;
    L29:
        boolean r117 = r116.isOpenSharing();
        SpaceHomeViewModel r118 = this.f241498o;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r118 = null;
    L32:
        boolean r119 = r118.isPublicScope();
        SpaceHomeViewModel r120 = this.f241498o;
        if (r120 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r120 = null;
    L35:
        SpaceInfo r121 = r120.getSpaceInfo();
        if (r121 == null) goto L38;
        DisplayTag r122 = r121.display_tag;
    L39:
        r111.a(r115, r117, r119, r122);
        SpaceCoverView r123 = W90();
        SpaceHomeViewModel r124 = this.f241498o;
        if (r124 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r123.setFavorite(r102.isSpaceStar());
        return;
    L42:
        r102 = r124;
        goto L43
    L38:
        r122 = null;
        goto L39
    L25:
        r114 = null;
        goto L26
    L15:
        r108 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
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

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.main.Hilt_WikiTreeFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        SpaceCoverView r100 = W90();
        if (r100 == null) goto L6;
        r100.f241466m.f241362a.b();
        tt5.a.h("WikiAiController", "releaseChatMode, isAIEnable intercepted");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f241490g = null;
        this.f241491h = null;
        this.f241492i = null;
        this.f241493j = null;
        this.f241494k = null;
        this.f241495l = null;
        this.f241496m = null;
        this.f241497n = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ((l) this.f241499p.getValue()).a();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        SpaceHomeViewModel r113 = null;
        if (r112 == null) goto L5;
        WikiTreeActivityContract r114 = (WikiTreeActivityContract) r112.getParcelable(WikiTreeActivityContract.class.getName());
    L6:
        Intrinsics.checkNotNull(r114);
        gq5.d.p(r114.getSpaceId(), r114.getDocumentToken(), Integer.valueOf(r114.isFromShareLink()), false, 8);
        SpaceHomeViewModel.Companion.getClass();
        this.f241498o = SpaceHomeViewModel.c.a(this, r114);
        final l r100 = (l) this.f241499p.getValue();
        r100.f241568b.setOnScrollListener(new k(r100));
        r100.f241568b.setInterceptTouchEventListener(new h(r100));
        r100.f241569c.addOnOffsetChangedListener(new i(r100));
        com.bytedance.ee.util.ui.k.h(r100.f241567a.getWindow());
        r100.f241567a.getWindow().setStatusBarColor(0);
        int r101 = com.bytedance.ee.util.ui.k.e(r100.f241567a);
        CollapsingToolbarLayout.LayoutParams r102 = (CollapsingToolbarLayout.LayoutParams) r100.f241571e.getLayoutParams();
        ((FrameLayout.LayoutParams) r102).height = com.bytedance.ee.util.ui.n.d(210) + r101;
        r100.f241571e.setLayoutParams(r102);
        r100.f241576j = ((FrameLayout.LayoutParams) r102).height;
        CollapsingToolbarLayout.LayoutParams r103 = (CollapsingToolbarLayout.LayoutParams) r100.f241570d.getLayoutParams();
        ((FrameLayout.LayoutParams) r103).height = r100.f241567a.getResources().getDimensionPixelSize(R.dimen.doc_titlebar_height) + r101;
        r100.f241570d.setPadding(0, r101, 0, 0);
        r100.f241570d.setLayoutParams(r103);
        r100.f241570d.setTranslationY(-((FrameLayout.LayoutParams) r103).height);
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r100.f241572f.getLayoutParams();
        r104.topMargin = r101;
        r100.f241572f.setLayoutParams(r104);
        r100.f241573g.setPadding(0, r101, 0, 0);
        View r105 = this.f241491h;
        if (r105 != null) goto L13;
        View r106 = getView();
        if (r106 == null) goto L11;
        r105 = r106.findViewById(R.id.wiki_floating_title_bar);
    L12:
        this.f241491h = (BaseTitleBar) r105;
        goto L13
    L11:
        r105 = null;
    L13:
        ((BaseTitleBar) r105).setActionIconTint(R.color.icon_n1);
        SpaceCoverView r107 = W90();
        View r108 = this.f241491h;
        if (r108 != null) goto L20;
        View r109 = getView();
        if (r109 == null) goto L18;
        r108 = r109.findViewById(R.id.wiki_floating_title_bar);
    L19:
        this.f241491h = (BaseTitleBar) r108;
        goto L20
    L18:
        r108 = null;
    L20:
        r107.setFloatingTitleBar((BaseTitleBar) r108);
        Z90();
        View r115 = this.f241493j;
        if (r115 != null) goto L27;
        View r116 = getView();
        if (r116 == null) goto L25;
        r115 = r116.findViewById(R.id.wiki_search_view);
    L26:
        this.f241493j = (WikiSearchPickerView) r115;
        goto L27
    L25:
        r115 = null;
    L27:
        WikiSearchPickerView r117 = (WikiSearchPickerView) r115;
        this.f241501r = r117;
        if (r117 == null) goto L33;
        SpaceHomeViewModel r118 = this.f241498o;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r118 = null;
    L32:
        r117.c(this, r118.getSpaceId(), true);
    L33:
        WikiTreeCtrlView.c r119 = new WikiTreeCtrlView.c();
        r119.f242320c = true;
        r119.f242321d = true;
        r119.f242322e = true;
        r119.f242323f = true;
        r119.f242324g = yp5.c.i();
        r119.f242325h = true;
        r119.f242328k = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n(this, new WeakReference(Y90()), new ce5.a(this)));
        r119.f242329l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(this, new WeakReference(Y90())));
        r119.f242332o = CollectionsKt.listOf(new WikiBottomDecoration(R.dimen.space_kit_len_60));
        Intrinsics.checkNotNullParameter("Wiki_WikiTreeFragment", "<set-?>");
        r119.f242333p = "Wiki_WikiTreeFragment";
        r119.f242334q = "fullscreen";
        r119.f242335r = Integer.valueOf(r114.isFromShareLink());
        WikiTreeCtrlView r120 = Y90();
        SpaceHomeViewModel r121 = this.f241498o;
        if (r121 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r121 = null;
    L36:
        String r122 = r121.getSpaceId();
        SpaceHomeViewModel r123 = this.f241498o;
        if (r123 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r123 = null;
    L39:
        r120.i(new f1(this, r122, r123.getDocumentToken(), r119, new ce5.a(this)));
        V90().setVisibility(8);
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(getViewLifecycleOwner(), new t(this));
        SpaceHomeViewModel r124 = this.f241498o;
        if (r124 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r113.isSpaceStarLiveData().observe(getViewLifecycleOwner(), new u(this));
        W90().setViewDelegate(new p(this));
        Y90().setViewDelegate(new q(this));
        WikiSearchPickerView r125 = this.f241501r;
        if (r125 == null) goto L46;
        r125.setSearchViewDelegate(new r(this));
    L46:
        V90().setOnClickListener(new s(this));
        if (ForsetiHelper.s(this) == false) goto L63;
        FragmentBackPressedHelperKt.a(this, new b(this));
        ForsetiViewModel r126 = ForsetiHelper.j(this);
        if (r126 != null) goto L51;
        return;
    L51:
        r126.getViewMode().observe(this, new c(this));
    L63:
        dn4.a r127 = (dn4.a) new ce5.a(this).a(dn4.a.class);     // Catch: Throwable -> L57
        if (r127 != null) goto L55;
        tt5.a.k("Wiki_WikiTreeFragment", "enableWikiTreeConsumeStatusBar: userAppSetting or fgService is null");     // Catch: Throwable -> L57
    L59:
        boolean r128 = false;
    L60:
        if (r128 == false) goto L64;
        WindowInsetsUtils.c(requireActivity()).c(false);
        return;
    L64:
        return;
    L55:
        r128 = r127.a().isEnable("ccm.mobile.wiki_tree_fragment_consume_status_bar");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        tt5.a.e("Wiki_WikiTreeFragment", "enableWikiTreeConsumeStatusBar error", th, false);
        goto L59
    L42:
        r113 = r124;
        goto L43
    L5:
        r114 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Y90().o(r100, r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_tree_fragment, r101, false);
    }

    public static void aa0(WikiTreeFragment r100, Throwable r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if (r100.f241500q == true) goto L18;
        View r104 = r100.f241496m;
        if (r104 != null) goto L17;
        View r105 = r100.getView();
        if (r105 == null) goto L15;
        r104 = r105.findViewById(R.id.wikiEmptyViewStub);
    L16:
        r100.f241496m = (ViewStub) r104;
        goto L17
    L15:
        r104 = null;
    L17:
        ((ViewStub) r104).inflate().setPadding(0, com.bytedance.ee.util.ui.k.e(r100.getContext()), 0, 0);
        WikiEmptyView r106 = r100.X90();
        int r107 = WikiEmptyView.f242277j;
        r106.f242279g = null;
        r106.f242280h = null;
        r100.f241500q = true;
    L18:
        if (r102 == null) goto L20;
        r100.X90().d(r102.intValue());
        return;
    L20:
        r100.X90().e(r101);
    }
}
