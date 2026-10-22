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
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiEmptyView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.google.android.material.appbar.CollapsingToolbarLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0016J\b\u0010M\u001a\u00020AH\u0002J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020O2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J\b\u0010`\u001a\u000206H\u0016J%\u0010a\u001a\u0002062\n\b\u0002\u0010b\u001a\u0004\u0018\u00010c2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010eH\u0002¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u000206H\u0002J\b\u0010h\u001a\u000206H\u0002J\b\u0010i\u001a\u000206H\u0002J\b\u0010j\u001a\u000206H\u0016J\b\u0010k\u001a\u00020AH\u0016J\b\u0010l\u001a\u00020AH\u0002J\"\u0010m\u001a\u0002062\u0006\u0010n\u001a\u00020e2\u0006\u0010o\u001a\u00020e2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\n\u0010r\u001a\u0004\u0018\u00010sH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010*8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u0001008FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020E8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010J\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010?\u001a\u0004\bJ\u0010K¨\u0006u"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiTreeFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiFloatingTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getWikiFloatingTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setWikiFloatingTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "wikiCoverViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "getWikiCoverViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "setWikiCoverViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "commonCreateButtonFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getCommonCreateButtonFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setCommonCreateButtonFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "wikiEmptyViewStubFromXml", "Landroid/view/ViewStub;", "getWikiEmptyViewStubFromXml", "()Landroid/view/ViewStub;", "setWikiEmptyViewStubFromXml", "(Landroid/view/ViewStub;)V", "wikiCoordinatorLayoutFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;", "getWikiCoordinatorLayoutFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;", "setWikiCoordinatorLayoutFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiCoverCoordinatorLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceHomeViewModel;", "flexCollapseView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiFlexCollapseView;", "getFlexCollapseView", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/WikiFlexCollapseView;", "flexCollapseView$delegate", "Lkotlin/Lazy;", "eptInit", "", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "isFgOnBackPress", "()Z", "isFgOnBackPress$delegate", "enableWikiTreeConsumeStatusBar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "setCover", "bindView", "bindListener", "onDestroy", "showEmptyView", "throwable", "", "code", "", "(Ljava/lang/Throwable;Ljava/lang/Integer;)V", "initEmptyView", "showSearching", "hideSearching", "onResume", "onBackPressed", "handleBackPress", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreeFragment extends Hilt_WikiTreeFragment implements d0c.c {
    public static final /* synthetic */ int u = 0;
    public WikiTreeCtrlView g;
    public BaseTitleBar h;
    public SpaceCoverView i;
    public WikiSearchPickerView j;
    public CommonCreateButton k;
    public WikiEmptyView l;
    public ViewStub m;
    public WikiCoverCoordinatorLayout n;
    public SpaceHomeViewModel o;
    public final Lazy p;
    public boolean q;
    public WikiSearchPickerView r;

    @Inject
    public NetService s;
    public final Lazy t;

    public static final class a {
    }

    public static final class b implements sa5.d {
        public final /* synthetic */ WikiTreeFragment a;

        public b(WikiTreeFragment r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            return this.a.onBackPressed();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ WikiTreeFragment a;

        public c(WikiTreeFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ForsetiViewMode r3 = (ForsetiViewMode) r2;
            if (r3 != null) goto L5;
        L9:
            WikiTreeCtrlView r4 = this.a.Y90();
            if (r4 == null) goto L15;
            r4.setUploadViewVisible(true);
            return;
        L15:
            return;
        L5:
            if (r3.isCompact() == true) goto L9;
            WikiTreeCtrlView r5 = this.a.Y90();
            if (r5 == null) goto L13;
            r5.setUploadViewVisible(false);
            return;
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

    public final CommonCreateButton V90() {
        View r0 = this.k;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131367552);
    L8:
        this.k = (CommonCreateButton) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CommonCreateButton) r0;
    }

    public final SpaceCoverView W90() {
        View r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393225);
    L8:
        this.i = (SpaceCoverView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceCoverView) r0;
    }

    public final WikiEmptyView X90() {
        EmptyView r0 = this.l;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393209);
    L8:
        this.l = (WikiEmptyView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiEmptyView) r0;
    }

    public final WikiTreeCtrlView Y90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393267);
    L8:
        this.g = (WikiTreeCtrlView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiTreeCtrlView) r0;
    }

    public final boolean onBackPressed() {
        if (((Boolean) this.t.getValue()).booleanValue() == false) goto L21;
        WikiSearchPickerView r0 = this.r;
        if (r0 == null) goto L16;
        StringBuilder r3 = new StringBuilder("isShow: ");
        if (r0.getVisibility() != 0) goto L9;
        boolean r4 = true;
    L10:
        r3.append(r4);
        tt5.a.h("WikiSearchPickerView", r3.toString());
        if (r0.getVisibility() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 != true) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L21;
        WikiSearchPickerView r5 = this.r;
        if (r5 == null) goto L34;
        r5.a();
    L34:
        return true;
    L13:
        r1 = false;
        goto L14
    L9:
        r4 = false;
    L16:
        r2 = false;
    L21:
        WikiSearchPickerView r6 = this.r;
        if (r6 == null) goto L25;
        r6.a();
    L25:
        if (ForsetiHelper.i() == true) goto L28;
    L30:
        boolean r7 = false;
    L31:
        if (r7 == true) goto L34;
        if (super.onBackPressed() == true) goto L34;
        return false;
    L28:
        if (ForsetiHelper.c(this) == false) goto L30;
        tt5.a.h("Wiki_WikiTreeFragment", "is forseti and splitWindowState do goback");
        r7 = true;
        goto L31
    }

    public WikiTreeFragment() {
        this.p = LazyKt.lazy(new WikiTreeFragment$flexCollapseView$2(this));
        this.t = LazyKt.lazy(WikiTreeFragment$isFgOnBackPress$2.INSTANCE);
    }

    public final void Z90() {
        SpaceCoverView r0 = W90();
        SpaceHomeViewModel r1 = this.o;
        SpaceHomeViewModel r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        SpaceInfo r2 = r1.getSpaceInfo();
        if (r2 == null) goto L8;
        String r4 = r2.getSpaceName();
    L9:
        r0.setTitle(r4);
        SpaceCoverView r5 = W90();
        SpaceHomeViewModel r6 = this.o;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L12:
        SpaceInfo r7 = r6.getSpaceInfo();
        if (r7 == null) goto L15;
        SpaceInfo.SpaceCover r8 = r7.space_cover;
    L16:
        r5.setCover(r8);
        SpaceCoverView r9 = W90();
        SpaceHomeViewModel r10 = this.o;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L19:
        r9.setMoreVisible(r10.canViewCollaborator());
        SpaceCoverView r11 = W90();
        SpaceHomeViewModel r12 = this.o;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L22:
        SpaceInfo r13 = r12.getSpaceInfo();
        if (r13 == null) goto L25;
        String r14 = r13.tenant_id;
    L26:
        boolean r15 = up5.i.a(r14);
        SpaceHomeViewModel r16 = this.o;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r16 = null;
    L29:
        boolean r17 = r16.isOpenSharing();
        SpaceHomeViewModel r18 = this.o;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L32:
        boolean r19 = r18.isPublicScope();
        SpaceHomeViewModel r20 = this.o;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r20 = null;
    L35:
        SpaceInfo r21 = r20.getSpaceInfo();
        if (r21 == null) goto L38;
        DisplayTag r22 = r21.display_tag;
    L39:
        r11.a(r15, r17, r19, r22);
        SpaceCoverView r23 = W90();
        SpaceHomeViewModel r24 = this.o;
        if (r24 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r23.setFavorite(r3.isSpaceStar());
        return;
    L42:
        r3 = r24;
        goto L43
    L38:
        r22 = null;
        goto L39
    L25:
        r14 = null;
        goto L26
    L15:
        r8 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        d0c.c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.main.Hilt_WikiTreeFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        SpaceCoverView r0 = W90();
        if (r0 == null) goto L6;
        r0.m.a.b();
        tt5.a.h("WikiAiController", "releaseChatMode, isAIEnable intercepted");
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ((l) this.p.getValue()).a();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m699provideComponent() {
        return provideComponent();
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        Bundle r15 = getArguments();
        SpaceHomeViewModel r16 = null;
        if (r15 == null) goto L5;
        WikiTreeActivityContract r17 = (WikiTreeActivityContract) r15.getParcelable(WikiTreeActivityContract.class.getName());
    L6:
        Intrinsics.checkNotNull(r17);
        gq5.d.p(r17.getSpaceId(), r17.getDocumentToken(), Integer.valueOf(r17.isFromShareLink()), false, 8);
        SpaceHomeViewModel.Companion.getClass();
        this.o = SpaceHomeViewModel.c.a(this, r17);
        final l r0 = (l) this.p.getValue();
        r0.b.setOnScrollListener(new k(r0));
        r0.b.setInterceptTouchEventListener(new h(r0));
        r0.c.addOnOffsetChangedListener(new i(r0));
        com.bytedance.ee.util.ui.k.h(r0.a.getWindow());
        r0.a.getWindow().setStatusBarColor(0);
        int r1 = com.bytedance.ee.util.ui.k.e(r0.a);
        CollapsingToolbarLayout.LayoutParams r2 = r0.e.getLayoutParams();
        ((FrameLayout.LayoutParams) r2).height = com.bytedance.ee.util.ui.n.d(210) + r1;
        r0.e.setLayoutParams(r2);
        r0.j = ((FrameLayout.LayoutParams) r2).height;
        CollapsingToolbarLayout.LayoutParams r3 = r0.d.getLayoutParams();
        ((FrameLayout.LayoutParams) r3).height = r0.a.getResources().getDimensionPixelSize(2131165837) + r1;
        r0.d.setPadding(0, r1, 0, 0);
        r0.d.setLayoutParams(r3);
        r0.d.setTranslationY(-((FrameLayout.LayoutParams) r3).height);
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r0.f.getLayoutParams();
        r4.topMargin = r1;
        r0.f.setLayoutParams(r4);
        r0.g.setPadding(0, r1, 0, 0);
        View r5 = this.h;
        if (r5 != null) goto L13;
        View r6 = getView();
        if (r6 == null) goto L11;
        r5 = r6.findViewById(2131393229);
    L12:
        this.h = (BaseTitleBar) r5;
        goto L13
    L11:
        r5 = null;
    L13:
        ((BaseTitleBar) r5).setActionIconTint(2131102418);
        SpaceCoverView r7 = W90();
        View r8 = this.h;
        if (r8 != null) goto L20;
        View r9 = getView();
        if (r9 == null) goto L18;
        r8 = r9.findViewById(2131393229);
    L19:
        this.h = (BaseTitleBar) r8;
        goto L20
    L18:
        r8 = null;
    L20:
        r7.setFloatingTitleBar((BaseTitleBar) r8);
        Z90();
        View r10 = this.j;
        if (r10 != null) goto L27;
        View r11 = getView();
        if (r11 == null) goto L25;
        r10 = r11.findViewById(2131393253);
    L26:
        this.j = (WikiSearchPickerView) r10;
        goto L27
    L25:
        r10 = null;
    L27:
        WikiSearchPickerView r12 = (WikiSearchPickerView) r10;
        this.r = r12;
        if (r12 == null) goto L33;
        SpaceHomeViewModel r18 = this.o;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L32:
        r12.c(this, r18.getSpaceId(), true);
    L33:
        WikiTreeCtrlView.c r19 = new WikiTreeCtrlView.c();
        r19.c = true;
        r19.d = true;
        r19.e = true;
        r19.f = true;
        r19.g = yp5.c.i();
        r19.h = true;
        r19.k = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n(this, new WeakReference(Y90()), new ce5.a(this)));
        r19.l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(this, new WeakReference(Y90())));
        r19.o = CollectionsKt.listOf(new WikiBottomDecoration(2131168357));
        Intrinsics.checkNotNullParameter("Wiki_WikiTreeFragment", "<set-?>");
        r19.p = "Wiki_WikiTreeFragment";
        r19.q = "fullscreen";
        r19.r = Integer.valueOf(r17.isFromShareLink());
        WikiTreeCtrlView r110 = Y90();
        SpaceHomeViewModel r20 = this.o;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r20 = null;
    L36:
        String r21 = r20.getSpaceId();
        SpaceHomeViewModel r22 = this.o;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r22 = null;
    L39:
        r110.i(new f1(this, r21, r22.getDocumentToken(), r19, new ce5.a(this)));
        V90().setVisibility(8);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(getViewLifecycleOwner(), new t(this));
        SpaceHomeViewModel r111 = this.o;
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r16.isSpaceStarLiveData().observe(getViewLifecycleOwner(), new u(this));
        W90().setViewDelegate(new p(this));
        Y90().setViewDelegate(new q(this));
        WikiSearchPickerView r112 = this.r;
        if (r112 == null) goto L46;
        r112.setSearchViewDelegate(new r(this));
    L46:
        V90().setOnClickListener(new s(this));
        if (ForsetiHelper.s(this) == false) goto L63;
        FragmentBackPressedHelperKt.a(this, new b(this));
        ForsetiViewModel r113 = ForsetiHelper.j(this);
        if (r113 != null) goto L51;
        return;
    L51:
        r113.getViewMode().observe(this, new c(this));
    L63:
        dn4.a r114 = (dn4.a) new ce5.a(this).a(dn4.a.class);     // Catch: Throwable -> L57
        if (r114 != null) goto L55;
        tt5.a.k("Wiki_WikiTreeFragment", "enableWikiTreeConsumeStatusBar: userAppSetting or fgService is null");     // Catch: Throwable -> L57
    L59:
        boolean r115 = false;
    L60:
        if (r115 == false) goto L64;
        WindowInsetsUtils.c(requireActivity()).c(false);
        return;
    L64:
        return;
    L55:
        r115 = r114.a().isEnable("ccm.mobile.wiki_tree_fragment_consume_status_bar");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        tt5.a.e("Wiki_WikiTreeFragment", "enableWikiTreeConsumeStatusBar error", th, false);
        goto L59
    L42:
        r16 = r111;
        goto L43
    L5:
        r17 = null;
        goto L6
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        Y90().o(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568271, r3, false);
    }

    public static void aa0(WikiTreeFragment r3, Throwable r4, Integer r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if (r3.q == true) goto L18;
        View r7 = r3.m;
        if (r7 != null) goto L17;
        View r8 = r3.getView();
        if (r8 == null) goto L15;
        r7 = r8.findViewById(2131393211);
    L16:
        r3.m = (ViewStub) r7;
        goto L17
    L15:
        r7 = null;
    L17:
        ((ViewStub) r7).inflate().setPadding(0, com.bytedance.ee.util.ui.k.e(r3.getContext()), 0, 0);
        WikiEmptyView r9 = r3.X90();
        int r0 = WikiEmptyView.j;
        r9.g = null;
        r9.h = null;
        r3.q = true;
    L18:
        if (r5 == null) goto L20;
        r3.X90().d(r5.intValue());
        return;
    L20:
        r3.X90().e(r4);
    }
}
