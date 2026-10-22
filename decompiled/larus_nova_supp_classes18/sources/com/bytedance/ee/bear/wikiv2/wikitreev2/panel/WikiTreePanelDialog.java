package com.bytedance.ee.bear.wikiv2.wikitreev2.panel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.forseti.ForsetiVM;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import fq5.j;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import uq5.e;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0002jkB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\u0010\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u001eH\u0002J\u0018\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020\u001eH\u0002J\b\u0010T\u001a\u00020\u001eH\u0002J\b\u0010U\u001a\u00020\u001eH\u0002J\u0010\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020XH\u0002J\"\u0010Y\u001a\u00020'2\u0006\u0010W\u001a\u00020X2\u0006\u0010Z\u001a\u0002082\b\b\u0002\u0010[\u001a\u00020'H\u0002J\b\u0010\\\u001a\u00020\u001eH\u0016J\b\u0010]\u001a\u00020\u001eH\u0016J\"\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0002J\n\u0010f\u001a\u0004\u0018\u00010gH\u0016J\n\u0010h\u001a\u0004\u0018\u00010EH\u0002J\b\u0010i\u001a\u00020PH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/FullBottomSheetFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "closeIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCloseIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "wikiPanelTitleFromXml", "Landroid/widget/TextView;", "getWikiPanelTitleFromXml", "()Landroid/widget/TextView;", "setWikiPanelTitleFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog$_ViewModel;", "onBoardingTask", "Ljava/lang/Runnable;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "wikiSearchSpaceId", "", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "decor", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/CustomConstraintLayout;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "initTitle", "bindView", "bindListener", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adaptiveLandscape", "notifyDoFavorite", WikiFolderPushPlugin.WIKI_TOKEN, "switchOn", "", "switchWorkspace", "toSpaceId", "syncWikiSearchSpaceIdWithTree", "checkShowOnBoarding", "closeIfLoseFocus", "navigation", "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/NavigationParams;", "buildUrl", "extra", "visibleSpaceId", "onStart", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "getCtx", "Landroidx/fragment/app/FragmentActivity;", "getContext", "Landroid/content/Context;", "getViewModelStoreOwner", "isSupportScreenLandscape", "Companion", "_ViewModel", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreePanelDialog extends Hilt_WikiTreePanelDialog implements c {
    public static final /* synthetic */ int w = 0;
    public WikiTreeCtrlView l;
    public WikiSearchPickerView m;
    public AppCompatImageView n;
    public TextView o;
    public _ViewModel p;
    public j q;
    public WikiSearchPickerView r;
    public String s;

    @Inject
    public NetService t;
    public ce5.a u;
    public CustomConstraintLayout v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog$_ViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", WikiFolderPushPlugin.WIKI_TOKEN, "getWikiToken", "setWikiToken", "uniqueUiId", "getUniqueUiId", "setUniqueUiId", "needOnBoarding", "", "getNeedOnBoarding", "()Z", "setNeedOnBoarding", "(Z)V", "isNeedExpandWindow", "setNeedExpandWindow", "pathResolveContext", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "getPathResolveContext", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "setPathResolveContext", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;)V", "reusePathResolveTree", "getReusePathResolveTree", "setReusePathResolveTree", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class _ViewModel extends ViewModel {
        private boolean isNeedExpandWindow;
        private boolean needOnBoarding;
        private ar5.a pathResolveContext;
        private boolean reusePathResolveTree;
        private String spaceId;
        private String title;
        private String uniqueUiId;
        private String wikiToken;

        public _ViewModel() {
            this.title = "";
            this.spaceId = "";
            this.wikiToken = "";
            this.uniqueUiId = "";
        }

        public final boolean getNeedOnBoarding() {
            return this.needOnBoarding;
        }

        public final ar5.a getPathResolveContext() {
            return this.pathResolveContext;
        }

        public final boolean getReusePathResolveTree() {
            return this.reusePathResolveTree;
        }

        public final String getSpaceId() {
            return this.spaceId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUniqueUiId() {
            return this.uniqueUiId;
        }

        public final String getWikiToken() {
            return this.wikiToken;
        }

        public final boolean isNeedExpandWindow() {
            return this.isNeedExpandWindow;
        }

        public final void setNeedExpandWindow(boolean r1) {
            this.isNeedExpandWindow = r1;
        }

        public final void setNeedOnBoarding(boolean r1) {
            this.needOnBoarding = r1;
        }

        public final void setPathResolveContext(ar5.a r1) {
            this.pathResolveContext = r1;
        }

        public final void setReusePathResolveTree(boolean r1) {
            this.reusePathResolveTree = r1;
        }

        public final void setSpaceId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.spaceId = r2;
        }

        public final void setTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.title = r2;
        }

        public final void setUniqueUiId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.uniqueUiId = r2;
        }

        public final void setWikiToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.wikiToken = r2;
        }
    }

    public static final class a {
        @JvmStatic
        public static e3 a(ViewModelStoreOwner r2, ce5.a r3) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            int r1 = WikiTreeCtrlView.q;
            Intrinsics.checkNotNullParameter(r2, "dataLifeOwner");
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            return WikiTreeCtrlView.a.a(r2, r3).cloneWorkspace();
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
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final WikiTreeCtrlView ea0() {
        View r0 = this.l;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393267);
    L8:
        this.l = (WikiTreeCtrlView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiTreeCtrlView) r0;
    }

    public WikiTreePanelDialog() {
        this.s = "";
    }

    public final void ca0() {
        if (ForsetiHelper.s(this) == true) goto L5;
        return;
    L5:
        if (n.C(getContext()) == false) goto L15;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        if (ku5.c.k(getContext()) == false) goto L9;
        int r1 = 0;
    L10:
        r0.topMargin = d.a(r1);
        r0.gravity = 1;
        ConstraintLayout r2 = this.v;
        if (r2 == null) goto L16;
        r2.setLayoutParams(r0);
        return;
    L16:
        return;
    L9:
        r1 = 39;
        goto L10
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L6;
        c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.panel.Hilt_WikiTreePanelDialog
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.onDestroy();
        tt5.a.h("Wiki_WikiTreePanelDialog", "onDestroy. ");
        j r0 = this.q;
        if (r0 == null) goto L6;
        com.bytedance.ee.util.ui.j.e(r0);
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        View r0 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.a(getDialog());
        BottomSheetBehavior r2 = null;
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L13;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        CoordinatorLayout.LayoutParams r4 = (CoordinatorLayout.LayoutParams) r3;
    L11:
        if (r4 == null) goto L13;
        ((ViewGroup.MarginLayoutParams) r4).height = -1;
        r1.setLayoutParams(r4);
        goto L13
    L10:
        r4 = null;
    L13:
        ((FullBottomSheetFragment) this).i = com.bytedance.ee.bear.bizwidget.dialogfragment.b.c(getDialog());
        Dialog r5 = getDialog();
        if (r5 == null) goto L23;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L23;
        zo5.b r7 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r8 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L22;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r9 = ThreadMethodProxy.currentThread();
        if (r9 == com.larus.home.impl.utils.c.a) goto L22;
        com.larus.home.impl.utils.c.a(r9, "getDecorView");
    L22:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout");
        r7.p((FrameLayout) r8);
    L23:
        if (r1 == null) goto L31;
        BottomSheetBehavior r10 = ((FullBottomSheetFragment) this).i;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r11 = r1.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L27;
        ViewGroup.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11;
    L28:
        if (r12 != null) goto L30;
        r2 = r10;
        goto L31
    L30:
        r12.setBehavior(null);
        r1.setLayoutParams(r12);
        goto L31
    L27:
        r12 = null;
    L31:
        ((FullBottomSheetFragment) this).i = r2;
        if (r2 == null) goto L34;
        r2.setState(3);
    L34:
        Y90(2131100545);
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m703provideComponent() {
        return provideComponent();
    }

    public static final void ba0(WikiTreePanelDialog r1) {
        if (TextUtils.isEmpty(r1.ea0().getFocusToken()) == false) goto L13;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void fa0(uq5.a r14) {
        if (r14.e == true) goto L147;
    L10:
        Bundle r7 = new Bundle();
        if (r14.b == false) goto L13;
        r7.putBoolean("popLastDocument", true);
    L13:
        String r2 = r14.f;
        if (r2 == null) goto L16;
        r7.putString("title", r2);
    L16:
        WikiInfo r3 = r14.g;
        if (r3 == null) goto L19;
        r7.putSerializable("wiki_info", r3);
    L19:
        String r4 = r14.i;
        if (r4 == null) goto L22;
        r7.putString("unique_ui_id", r4);
    L22:
        String r5 = r14.j;
        if (r5 == null) goto L25;
        r7.putString("extra_from", r5);
    L25:
        r7.putBoolean("force_load_same", r14.h);
        _ViewModel r6 = null;
        PluginHost r8 = PluginHost.fromFragment(this);     // Catch: Throwable -> L28
    L29:
        String r9 = r14.k;
        WikiTreeCtrlView r10 = ea0();
        if (r10 == null) goto L32;
        String r11 = r10.getSpaceId();
    L33:
        WikiInfo r12 = r14.g;
        if (r12 == null) goto L36;
        String r13 = r12.getSpaceId();
    L37:
        Intrinsics.checkNotNullParameter(r9, "explicitVisibleSpaceId");
        if (r9.length() <= 0) goto L40;
        boolean r15 = true;
    L41:
        String r16 = "";
        if (r15 == false) goto L44;
        String r17 = r9;
    L63:
        if (r8 == null) goto L71;
        Fragment r18 = r8.getHostFragment();
        if (r18 == null) goto L71;
        Fragment r19 = r18.getParentFragment();
        if (r19 == null) goto L71;
        if (ForsetiHelper.s(r19) == false) goto L71;
        Fragment r20 = r19;
    L73:
        if (r20 == null) goto L95;
        WikiInfo r21 = r14.g;
        if (r21 != null) goto L77;
    L79:
        boolean r22 = false;
    L80:
        if (r22 == false) goto L95;
        Lazy r23 = ForsetiHelper.a;
        Fragment r24 = r20;
    L82:
        if (r24 == null) goto L87;
        if ((r24 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n) == true) goto L88;
        r24 = r24.getParentFragment();
    L88:
        if (r24 == null) goto L95;
        MutableLiveData r0 = new ViewModelProvider(r24).get(ForsetiVM.class).getLiveArgs();
        Bundle r1 = new Bundle();
        String r25 = da0(r14, r7, r17);
        r1.putString(ResourceData.KEY_URL, r25);
        r1.putParcelable("bear_url", p.a().Z(p.a().v8(r25)));
        r1.putString("space_id", r14.g.getSpaceId());
        r1.putString("space_name", r14.d);
        r1.putInt(ResourceData.KEY_TYPE, r14.g.getObjType());
        r1.putString(ResourceData.KEY_OBJ_TOKEN, r14.g.getObjToken());
        r1.putSerializable("wiki_info", r14.g);
        _ViewModel r110 = this.p;
        if (r110 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L93:
        r1.putString("last_token", r6.getWikiToken());
        r1.putBoolean("is_from_wiki_tree_open", true);
        r0.postValue(r1);
        return;
    L92:
        r6 = r110;
        goto L93
    L87:
        r24 = null;
        goto L88
    L77:
        if (r21.getObjType() != 22) goto L79;
        r22 = true;
    L95:
        WikiInfo r26 = r14.g;
        if (r26 == null) goto L98;
        Integer r27 = Integer.valueOf(r26.getObjType());
    L100:
        if (AppInfoUtils.f().booleanValue() == false) goto L132;
        if (r27 == null) goto L132;
        if (fx4.a.c(r27.intValue()) == false) goto L132;
        if (fx4.a.e(r27.intValue()) == true) goto L132;
        String r28 = da0(r14, r7, r14.k);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L113
        Uri r30 = UriProtector.parse(r28);     // Catch: Throwable -> L113
        if (TextUtils.equals(UriProtector.getQueryParameter(r30, "ccm_skip_officesdk_route"), "1") == false) goto L110;
        String r31 = r28;
    L111:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L113
    L115:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L118;
        tt5.a.e("Wiki_WikiTreePanelDialog", "buildUnsupportedTypeUrl failed", r33, false);
    L118:
        Object r34 = r28;
        if (Result.isFailure-impl(r32) == true) goto L122;
        r34 = r32;
    L122:
        String r35 = (String) r34;
        t45.c r36 = (t45.c) LarkContext.spiByDwarf(t45.c.class);
        WikiInfo r111 = r14.g;
        if (r111 == null) goto L125;
        Integer r112 = Integer.valueOf(r111.getObjType());
    L126:
        String r113 = r36.T6(r35, r112);
        if (r113 == null) goto L130;
        r16 = r113;
    L130:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r16);
        return;
    L125:
        r112 = null;
        goto L126
    L110:
        String r37 = r30.buildUpon().appendQueryParameter("ccm_skip_officesdk_route", "1").build().toString();     // Catch: Throwable -> L113
        Intrinsics.checkNotNull(r37);     // Catch: Throwable -> L113
        r31 = r37;
    L113:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
    L132:
        String r39 = r14.c;
        if (r39 != null) goto L140;
        WikiTreeCtrlView r40 = ea0();
        if (r40 == null) goto L137;
        r39 = r40.getSpaceId();
    L138:
        if (r39 != null) goto L140;
        String r41 = "";
    L141:
        String r42 = r14.d;
        String r43 = r14.a;
        _ViewModel r114 = this.p;
        if (r114 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L145:
        o.b(r41, r42, r43, r7, Boolean.valueOf(r6.isNeedExpandWindow()), r20, r17);
        return;
    L144:
        r6 = r114;
        goto L145
    L137:
        r39 = null;
    L140:
        r41 = r39;
        goto L141
    L98:
        r27 = null;
    L71:
        r20 = null;
        goto L73
    L44:
        if (r11 != null) goto L46;
    L49:
        boolean r44 = true;
    L50:
        if (r44 == true) goto L62;
        if (r13 != null) goto L53;
    L56:
        boolean r45 = true;
    L57:
        if (r45 == true) goto L62;
        if (Intrinsics.areEqual(r11, r13) == true) goto L62;
        r17 = r11;
        goto L63
    L53:
        if (r13.length() == 0) goto L56;
        r45 = false;
    L62:
        r17 = "";
        goto L63
    L46:
        if (r11.length() == 0) goto L49;
        r44 = false;
        goto L50
    L40:
        r15 = false;
        goto L41
    L36:
        r13 = null;
        goto L37
    L32:
        r11 = null;
    L28:
        r8 = null;
        goto L29
    L147:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r46 = DialogFragmentLancet.sLastShowStack;
        if (r46 == null) goto L10;
        com.bytedance.crash.d.d(r46, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        ca0();
    }

    public final void onCreate(Bundle r3) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.onCreate(r3);
        ce5.a r4 = new ce5.a(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.u = r4;
        Long r5 = gq5.b.a;
        gq5.b.a = Long.valueOf(System.currentTimeMillis());
        tt5.a.h("Wiki_WikiTreePanelDialog", "onCreate. ");
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r14, r15);
        this.v = (CustomConstraintLayout) r14.findViewById(2131368630);
        View r16 = null;
        PluginHost r17 = PluginHost.fromFragment(this);     // Catch: Throwable -> L5
    L6:
        if (r17 == null) goto L14;
        if (ForsetiHelper.s(r17.getHostFragment()) == true) goto L11;
        r17 = null;
    L11:
        if (r17 == null) goto L14;
    L20:
        PluginHost r5 = r17;
        if (r5 != null) goto L24;
        tt5.a.d("Wiki_WikiTreePanelDialog", "viewModelStoreOwner is null!");
        return;
    L24:
        _ViewModel r0 = (_ViewModel) new ViewModelProvider(r5).get(_ViewModel.class);
        this.p = r0;
        if (r0 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L27:
        String r1 = r0.getSpaceId();
        _ViewModel r2 = this.p;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L30:
        gq5.d.p(r1, r2.getWikiToken(), null, false, 12);
        WikiTreeCtrlView.c r4 = new WikiTreeCtrlView.c();
        boolean r10 = true;
        r4.c = true;
        r4.d = true;
        r4.e = true;
        r4.f = true;
        r4.g = yp5.c.i();
        r4.h = true;
        WeakReference r3 = new WeakReference(ea0());
        ce5.a r6 = this.u;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r6 = null;
    L34:
        r4.k = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n(this, r3, r6));
        r4.l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(this, new WeakReference(ea0())));
        r4.o = CollectionsKt.listOf(new WikiBottomDecoration(2131168341));
        Intrinsics.checkNotNullParameter("Wiki_WikiTreePanelDialog", "<set-?>");
        r4.p = "Wiki_WikiTreePanelDialog";
        r4.q = "panel";
        _ViewModel r18 = this.p;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L37:
        r4.t = r18.getPathResolveContext();
        _ViewModel r19 = this.p;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r19 = null;
    L40:
        r4.u = r19.getReusePathResolveTree();
        _ViewModel r110 = this.p;
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r110 = null;
    L44:
        if (r110.getReusePathResolveTree() == false) goto L46;
        e3 r7 = null;
    L47:
        if (r7 == null) goto L64;
        _ViewModel r111 = this.p;
        if (r111 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r111 = null;
    L52:
        if (r7.x(r111.getWikiToken()) == false) goto L64;
        WikiTreeCtrlView r112 = ea0();
        _ViewModel r8 = this.p;
        if (r8 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L56:
        String r9 = r8.getWikiToken();
        _ViewModel r11 = this.p;
        if (r11 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L59:
        String r12 = r11.getUniqueUiId();
        ce5.a r13 = this.u;
        if (r13 == null) goto L62;
        ce5.a r113 = r13;
    L63:
        r112.i(new f1(this, r7, r9, r4, r5, r12, r113));
    L78:
        View r114 = this.m;
        if (r114 != null) goto L85;
        View r115 = getView();
        if (r115 == null) goto L83;
        r114 = r115.findViewById(2131393253);
    L84:
        this.m = (WikiSearchPickerView) r114;
        goto L85
    L83:
        r114 = null;
    L85:
        this.r = (WikiSearchPickerView) r114;
        _ViewModel r116 = this.p;
        if (r116 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r116 = null;
    L88:
        String r117 = r116.getSpaceId();
        WikiTreeCtrlView r20 = ea0();
        if (r20 == null) goto L91;
        String r21 = r20.getSpaceId();
    L92:
        _ViewModel r22 = this.p;
        if (r22 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r22 = null;
    L95:
        boolean r23 = r22.getReusePathResolveTree();
        _ViewModel r24 = this.p;
        if (r24 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r24 = null;
    L98:
        ar5.a r25 = r24.getPathResolveContext();
        if (r25 == null) goto L101;
        String r26 = r25.a;
    L102:
        Intrinsics.checkNotNullParameter(r117, "documentSpaceId");
        if (r26 != null) goto L105;
    L108:
        boolean r27 = true;
    L109:
        if (r27 == true) goto L111;
        r117 = r26;
    L119:
        this.s = r117;
        WikiSearchPickerView r28 = this.r;
        if (r28 == null) goto L122;
        r28.c(this, r117, false);
    L122:
        ea0().setTreeUpdateListener(new uq5.d(this));
        View r118 = this.n;
        if (r118 != null) goto L129;
        View r119 = getView();
        if (r119 == null) goto L127;
        r118 = r119.findViewById(2131366997);
    L128:
        this.n = (AppCompatImageView) r118;
        goto L129
    L127:
        r118 = null;
    L129:
        ((AppCompatImageView) r118).setOnClickListener(new e(this));
        _ViewModel r120 = this.p;
        if (r120 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r120 = null;
    L132:
        String r121 = r120.getTitle();
        SpaceInfo r29 = ea0().getSpaceInfo();
        if (r29 == null) goto L135;
        String r30 = r29.getSpaceName();
    L137:
        if (TextUtils.isEmpty(r121) == true) goto L148;
        _ViewModel r31 = this.p;
        if (r31 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r31 = null;
    L142:
        if (r31.getPathResolveContext() != null) goto L148;
        _ViewModel r32 = this.p;
        if (r32 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r32 = null;
    L147:
        if (r32.getReusePathResolveTree() == true) goto L148;
    L151:
        View r33 = this.o;
        if (r33 != null) goto L157;
        View r34 = getView();
        if (r34 == null) goto L156;
        r16 = r34.findViewById(2131393240);
    L156:
        this.o = (TextView) r16;
        r33 = r16;
    L157:
        ((TextView) r33).setText(r121);
        ca0();
        WikiSearchPickerView r122 = this.r;
        if (r122 == null) goto L160;
        r122.setSearchViewDelegate(new uq5.b(this));
    L160:
        ea0().setViewDelegate(new uq5.c(this));
        return;
    L148:
        if (r30 == null) goto L151;
        r121 = r30;
        goto L151
    L135:
        r30 = null;
        goto L137
    L111:
        if (r23 == false) goto L119;
        if (r21 != null) goto L114;
    L117:
        if (r10 == true) goto L119;
        r117 = r21;
        goto L119
    L114:
        if (r21.length() == 0) goto L117;
        r10 = false;
        goto L117
    L105:
        if (r26.length() == 0) goto L108;
        r27 = false;
        goto L109
    L101:
        r26 = null;
        goto L102
    L91:
        r21 = null;
        goto L92
    L62:
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r113 = null;
    L64:
        WikiTreeCtrlView r123 = ea0();
        _ViewModel r35 = this.p;
        if (r35 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r35 = null;
    L67:
        String r36 = r35.getSpaceId();
        _ViewModel r37 = this.p;
        if (r37 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r37 = null;
    L70:
        String r38 = r37.getWikiToken();
        _ViewModel r39 = this.p;
        if (r39 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r39 = null;
    L73:
        String r40 = r39.getUniqueUiId();
        ce5.a r41 = this.u;
        if (r41 == null) goto L76;
        ce5.a r124 = r41;
    L77:
        r123.i(new f1(this, r36, r38, r4, r5, r40, r124));
        goto L78
    L76:
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r124 = null;
        goto L77
    L46:
        r7 = g3.a.a.a.getAndSet(null);
    L14:
        if (getParentFragment() == null) goto L19;
        Fragment r125 = getParentFragment();
        if (r125 == null) goto L18;
        r17 = r125.getActivity();
        goto L20
    L18:
        r17 = null;
        goto L20
    L19:
        r17 = getActivity();
    L5:
        r17 = null;
        goto L6
    }

    public static String da0(uq5.a r5, Bundle r6, String r7) {
        WikiInfo r0 = r5.g;
        if (r0 == null) goto L6;
        String r1 = r0.getWikiToken();
        if (r1 == null) goto L6;
    L7:
        String r8 = r5.j;
        String r2 = "";
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        boolean r3 = false;
        if (r8.length() != 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        r8 = "pages";
    L16:
        String r9 = r6.getString("ccm_open_type");
        if (r9 == null) goto L20;
        r2 = r9;
    L20:
        String r10 = p.a().J8(sbb.e.n.getType(), r1, r8, r2);
        if (yp5.c.h() == true) goto L23;
    L27:
        Intrinsics.checkNotNull(r10);
        return r10;
    L23:
        if (r7.length() <= 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        r10 = UriProtector.parse(r10).buildUpon().appendQueryParameter("visible_space_id", r7).build().toString();
        goto L27
    L13:
        r4 = false;
    L6:
        r1 = r5.a;
        goto L7
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        if (isDetached() == true) goto L8;
        WikiTreeCtrlView r0 = ea0();
        if (r0 == null) goto L9;
        r0.o(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568275, r3, false);
    }
}
