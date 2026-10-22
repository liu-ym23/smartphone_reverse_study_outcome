package com.bytedance.ee.bear.wikiv2.mylib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import dq5.f;
import dq5.g;
import e0c.l;
import f0c.h;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002J\u0010\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020$H\u0016J\b\u0010L\u001a\u00020MH\u0016J\"\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020$H\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006X"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTitleBarFromXml", "Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "getWikiTitleBarFromXml", "()Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "setWikiTitleBarFromXml", "(Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;)V", "wikiCreateBtnFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getWikiCreateBtnFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setWikiCreateBtnFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "wikiEmptyContentViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "getWikiEmptyContentViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "setWikiEmptyContentViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "clearFromXmlViewCache", "", "onDestroyView", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", EventVerify.TYPE_LAUNCH, "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "libraryId", "", "bindView", "bindListener", NotificationCompat.CATEGORY_NAVIGATION, "param", "Lcom/bytedance/ee/bear/wikiv2/mylib/NavigationParam;", WidgetCostModule.TYPE_ON_START, "onBackPressed", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeLibraryFragment extends Hilt_HomeLibraryFragment implements d0c.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f241026p = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HomeMainTitleBar f241027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonCreateButton f241028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HomeLibraryEmptyContentView f241029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WikiSearchPickerView f241030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WikiTreeCtrlView f241031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f241032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WikiSearchPickerView f241033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Inject
    public NetService f241034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ce5.a f241035o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomeLibraryFragment f241036a;

        public b(HomeLibraryFragment r100) {
            this.f241036a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            wwc.c r101 = (wwc.c) r100;
            this.f241036a.W90().setVisibility(8);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomeLibraryFragment f241037a;

        public c(HomeLibraryFragment r100) {
            this.f241037a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            String r100 = (String) r110;
            gq5.d.p(r100, null, null, true, 6);
            HomeLibraryFragment r111 = this.f241037a;
            Intrinsics.checkNotNull(r100);
            View r101 = r111.f241030j;
            if (r101 != null) goto L9;
            View r102 = r111.getView();
            if (r102 == null) goto L7;
            r101 = r102.findViewById(R.id.wiki_search_view);
        L8:
            r111.f241030j = (WikiSearchPickerView) r101;
            goto L9
        L7:
            r101 = null;
        L9:
            WikiSearchPickerView r103 = (WikiSearchPickerView) r101;
            r111.f241033m = r103;
            if (r103 == null) goto L12;
            r103.c(r111, r100, true);
        L12:
            WikiTreeCtrlView.c r104 = new WikiTreeCtrlView.c();
            r104.f242320c = true;
            r104.f242321d = true;
            r104.f242322e = true;
            r104.f242323f = true;
            r104.f242325h = true;
            WeakReference r105 = new WeakReference(r111.Y90());
            ce5.a r106 = r111.f241035o;
            if (r106 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
            r106 = null;
        L16:
            r104.f242328k = CollectionsKt.listOf(new n(r111, r105, r106));
            r104.f242329l = CollectionsKt.listOf(new p(r111, new WeakReference(r111.Y90())));
            r104.f242332o = CollectionsKt.listOf(new WikiBottomDecoration(R.dimen.space_kit_len_60));
            Intrinsics.checkNotNullParameter("HomeLibraryFragment", "<set-?>");
            r104.f242333p = "HomeLibraryFragment";
            r104.f242334q = "fullscreen";
            WikiTreeCtrlView r107 = r111.Y90();
            String r108 = "";
            ce5.a r109 = r111.f241035o;
            if (r109 == null) goto L19;
            ce5.a r112 = r109;
        L20:
            r107.i(new f1(r111, r100, r108, r104, r112));
            HomeLibraryFragment r113 = this.f241037a;
            r113.getClass();
            j.a.f217090a.a().observe(r113.getViewLifecycleOwner(), new g(r113));
            HomeLibraryFragment r114 = this.f241037a;
            r114.X90().setOnSearchBtnClickListener(new dq5.a(r114));
            r114.V90().setOnClickListener(new dq5.b(r114));
            r114.W90().setOnEmptyCreateListener(new dq5.c(r114));
            r114.Y90().setViewDelegate(new dq5.d(r114));
            r114.Y90().setTreeUpdateListener(new dq5.e(r114));
            WikiSearchPickerView r115 = r114.f241033m;
            if (r115 == null) goto L24;
            r115.setSearchViewDelegate(new f(r114));
            return;
        L24:
            return;
        L19:
            Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
            r112 = null;
            goto L20
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomeLibraryFragment f241038a;

        public d(HomeLibraryFragment r100) {
            this.f241038a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("HomeLibraryFragment", "getLibraryId err. ", (Throwable) r100, false);
            HomeLibraryEmptyContentView r101 = this.f241038a.W90();
            SpaceEmptyState r102 = r101.f241023a;
            r102.setImageRes(Integer.valueOf(R.drawable.ccm_vc_empty_negative_the_shared_miss));
            r102.setTitle(null);
            r102.setDesc(r102.getContext().getString(R.string.LarkCCM_CM_MyLib_LoadFail_Empty));
            r102.setPrimaryText(r102.getContext().getString(R.string.LarkCCM_CM_MyLib_LoadFail_Retry_Button));
            r102.setPrimaryClickListener(r101.f241024b);
            r101.setVisibility(0);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomeLibraryFragment f241039a;

        public e(HomeLibraryFragment r100) {
            this.f241039a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            tt5.a.k("HomeLibraryFragment", "onReload. ");
            HomeLibraryFragment r101 = this.f241039a;
            int r102 = HomeLibraryFragment.f241026p;
            r101.Z90();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final CommonCreateButton V90() {
        View r100 = this.f241028h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiCreateBtn);
    L8:
        this.f241028h = (CommonCreateButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonCreateButton) r100;
    }

    public final HomeLibraryEmptyContentView W90() {
        View r100 = this.f241029i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiEmptyContentView);
    L8:
        this.f241029i = (HomeLibraryEmptyContentView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (HomeLibraryEmptyContentView) r100;
    }

    public final HomeMainTitleBar X90() {
        View r100 = this.f241027g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiTitleBar);
    L8:
        this.f241027g = (HomeMainTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (HomeMainTitleBar) r100;
    }

    public final WikiTreeCtrlView Y90() {
        View r100 = this.f241031k;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiTreeCtrlView);
    L8:
        this.f241031k = (WikiTreeCtrlView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiTreeCtrlView) r100;
    }

    public final void Z90() {
        tt5.a.h("HomeLibraryFragment", "launch. ");
        int r100 = dq5.j.f469673a;
        ce5.a r101 = this.f241035o;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r101 = null;
    L6:
        up5.g.a(dq5.j.b(r101).doOnSubscribe(new b(this)).subscribe(new c(this), new d(this)), this.f241032l);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        WikiSearchPickerView r100 = this.f241033m;
        if (r100 == null) goto L6;
        r100.a();
    L6:
        return super.onBackPressed();
    }

    public HomeLibraryFragment() {
        this.f241032l = new CompositeDisposable();
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

    @Override // com.bytedance.ee.bear.wikiv2.mylib.Hilt_HomeLibraryFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
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
        this.f241032l.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f241027g = null;
        this.f241028h = null;
        this.f241029i = null;
        this.f241030j = null;
        this.f241031k = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (ForsetiHelper.x(this) == true) goto L10;
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L12;
        r101.setSoftInputMode(32);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ce5.a r102 = new ce5.a(this);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f241035o = r102;
        X90().g();
        X90().setTitle(getString(R.string.LarkCCM_CM_MyLib_Menu));
        X90().setSearchEnable(false);
        V90().setVisibility(8);
        W90().setOnReloadListener(new e(this));
        Z90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Y90().o(r100, r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.list_home_library, r101, false);
    }
}
