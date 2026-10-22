package com.bytedance.ee.bear.wikiv2.mylib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002J\u0010\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020$H\u0016J\b\u0010L\u001a\u00020MH\u0016J\"\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020$H\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006X"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTitleBarFromXml", "Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "getWikiTitleBarFromXml", "()Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", "setWikiTitleBarFromXml", "(Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;)V", "wikiCreateBtnFromXml", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "getWikiCreateBtnFromXml", "()Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "setWikiCreateBtnFromXml", "(Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;)V", "wikiEmptyContentViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "getWikiEmptyContentViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;", "setWikiEmptyContentViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/mylib/HomeLibraryEmptyContentView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "clearFromXmlViewCache", "", "onDestroyView", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "launch", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "libraryId", "", "bindView", "bindListener", "navigation", "param", "Lcom/bytedance/ee/bear/wikiv2/mylib/NavigationParam;", "onStart", "onBackPressed", "", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "onDestroy", "getContext", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeLibraryFragment extends Hilt_HomeLibraryFragment implements d0c.c {
    public static final /* synthetic */ int p = 0;
    public HomeMainTitleBar g;
    public CommonCreateButton h;
    public HomeLibraryEmptyContentView i;
    public WikiSearchPickerView j;
    public WikiTreeCtrlView k;
    public final CompositeDisposable l;
    public WikiSearchPickerView m;

    @Inject
    public NetService n;
    public ce5.a o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ HomeLibraryFragment a;

        public b(HomeLibraryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wwc.c r3 = (wwc.c) r2;
            this.a.W90().setVisibility(8);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HomeLibraryFragment a;

        public c(HomeLibraryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            String r2 = (String) r10;
            gq5.d.p(r2, null, null, true, 6);
            Fragment r11 = this.a;
            Intrinsics.checkNotNull(r2);
            View r3 = r11.j;
            if (r3 != null) goto L9;
            View r4 = r11.getView();
            if (r4 == null) goto L7;
            r3 = r4.findViewById(2131393253);
        L8:
            r11.j = (WikiSearchPickerView) r3;
            goto L9
        L7:
            r3 = null;
        L9:
            WikiSearchPickerView r5 = (WikiSearchPickerView) r3;
            r11.m = r5;
            if (r5 == null) goto L12;
            r5.c(r11, r2, true);
        L12:
            WikiTreeCtrlView.c r6 = new WikiTreeCtrlView.c();
            r6.c = true;
            r6.d = true;
            r6.e = true;
            r6.f = true;
            r6.h = true;
            WeakReference r7 = new WeakReference(r11.Y90());
            ce5.a r8 = r11.o;
            if (r8 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
            r8 = null;
        L16:
            r6.k = CollectionsKt.listOf(new n(r11, r7, r8));
            r6.l = CollectionsKt.listOf(new p(r11, new WeakReference(r11.Y90())));
            r6.o = CollectionsKt.listOf(new WikiBottomDecoration(2131168357));
            Intrinsics.checkNotNullParameter("HomeLibraryFragment", "<set-?>");
            r6.p = "HomeLibraryFragment";
            r6.q = "fullscreen";
            WikiTreeCtrlView r9 = r11.Y90();
            String r12 = "";
            ce5.a r1 = r11.o;
            if (r1 == null) goto L19;
            ce5.a r13 = r1;
        L20:
            r9.i(new f1(r11, r2, r12, r6, r13));
            HomeLibraryFragment r14 = this.a;
            r14.getClass();
            j.a.a.a().observe(r14.getViewLifecycleOwner(), new g(r14));
            HomeLibraryFragment r15 = this.a;
            r15.X90().setOnSearchBtnClickListener(new dq5.a(r15));
            r15.V90().setOnClickListener(new dq5.b(r15));
            r15.W90().setOnEmptyCreateListener(new dq5.c(r15));
            r15.Y90().setViewDelegate(new dq5.d(r15));
            r15.Y90().setTreeUpdateListener(new dq5.e(r15));
            WikiSearchPickerView r0 = r15.m;
            if (r0 == null) goto L24;
            r0.setSearchViewDelegate(new f(r15));
            return;
        L24:
            return;
        L19:
            Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
            r13 = null;
            goto L20
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ HomeLibraryFragment a;

        public d(HomeLibraryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            tt5.a.e("HomeLibraryFragment", "getLibraryId err. ", (Throwable) r5, false);
            HomeLibraryEmptyContentView r6 = this.a.W90();
            UDEmptyState r0 = r6.a;
            r0.setImageRes(2131232579);
            r0.setTitle(null);
            r0.setDesc(r0.getContext().getString(2131888788));
            r0.setPrimaryText(r0.getContext().getString(2131888789));
            r0.setPrimaryClickListener(r6.b);
            r6.setVisibility(0);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ HomeLibraryFragment a;

        public e(HomeLibraryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.k("HomeLibraryFragment", "onReload. ");
            HomeLibraryFragment r3 = this.a;
            int r0 = HomeLibraryFragment.p;
            r3.Z90();
        }
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final CommonCreateButton V90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393207);
    L8:
        this.h = (CommonCreateButton) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CommonCreateButton) r0;
    }

    public final HomeLibraryEmptyContentView W90() {
        View r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393208);
    L8:
        this.i = (HomeLibraryEmptyContentView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (HomeLibraryEmptyContentView) r0;
    }

    public final HomeMainTitleBar X90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393213);
    L8:
        this.g = (HomeMainTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (HomeMainTitleBar) r0;
    }

    public final WikiTreeCtrlView Y90() {
        View r0 = this.k;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393214);
    L8:
        this.k = (WikiTreeCtrlView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiTreeCtrlView) r0;
    }

    public final void Z90() {
        tt5.a.h("HomeLibraryFragment", "launch. ");
        int r0 = dq5.j.a;
        ce5.a r1 = this.o;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r1 = null;
    L6:
        up5.g.a(dq5.j.b(r1).doOnSubscribe(new b(this)).subscribe(new c(this), new d(this)), this.l);
    }

    public final boolean onBackPressed() {
        WikiSearchPickerView r0 = this.m;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        return super.onBackPressed();
    }

    public HomeLibraryFragment() {
        this.l = new CompositeDisposable();
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        d0c.c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.mylib.Hilt_HomeLibraryFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.l.clear();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        if (ForsetiHelper.x(this) == true) goto L10;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        r1.setSoftInputMode(32);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m679provideComponent() {
        return provideComponent();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ce5.a r4 = new ce5.a(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.o = r4;
        X90().g();
        X90().setTitle(getString(2131888790));
        X90().setSearchEnable(false);
        V90().setVisibility(8);
        W90().setOnReloadListener(new e(this));
        Z90();
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        Y90().o(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563494, r3, false);
    }
}
