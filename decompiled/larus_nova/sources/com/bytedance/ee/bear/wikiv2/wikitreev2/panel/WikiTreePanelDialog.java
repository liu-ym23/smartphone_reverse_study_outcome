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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
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
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0002jkB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\u0010\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u001eH\u0002J\u0018\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020\u001eH\u0002J\b\u0010T\u001a\u00020\u001eH\u0002J\b\u0010U\u001a\u00020\u001eH\u0002J\u0010\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020XH\u0002J\"\u0010Y\u001a\u00020'2\u0006\u0010W\u001a\u00020X2\u0006\u0010Z\u001a\u0002082\b\b\u0002\u0010[\u001a\u00020'H\u0002J\b\u0010\\\u001a\u00020\u001eH\u0016J\b\u0010]\u001a\u00020\u001eH\u0016J\"\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0002J\n\u0010f\u001a\u0004\u0018\u00010gH\u0016J\n\u0010h\u001a\u0004\u0018\u00010EH\u0002J\b\u0010i\u001a\u00020PH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/FullBottomSheetFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "wikiSearchViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "getWikiSearchViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "setWikiSearchViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;)V", "closeIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCloseIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "wikiPanelTitleFromXml", "Landroid/widget/TextView;", "getWikiPanelTitleFromXml", "()Landroid/widget/TextView;", "setWikiPanelTitleFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog$_ViewModel;", "onBoardingTask", "Ljava/lang/Runnable;", "wikiSearchView", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "wikiSearchSpaceId", "", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "decor", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/CustomConstraintLayout;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initView", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "initTitle", "bindView", "bindListener", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adaptiveLandscape", "notifyDoFavorite", WikiFolderPushPlugin.WIKI_TOKEN, "switchOn", "", "switchWorkspace", "toSpaceId", "syncWikiSearchSpaceIdWithTree", "checkShowOnBoarding", "closeIfLoseFocus", NotificationCompat.CATEGORY_NAVIGATION, "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/NavigationParams;", "buildUrl", "extra", "visibleSpaceId", WidgetCostModule.TYPE_ON_START, LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCtx", "Landroidx/fragment/app/FragmentActivity;", "getContext", "Landroid/content/Context;", "getViewModelStoreOwner", "isSupportScreenLandscape", "Companion", "_ViewModel", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiTreePanelDialog extends Hilt_WikiTreePanelDialog implements c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f241630w = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WikiTreeCtrlView f241631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WikiSearchPickerView f241632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatImageView f241633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f241634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public _ViewModel f241635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public j f241636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WikiSearchPickerView f241637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f241638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Inject
    public NetService f241639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ce5.a f241640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CustomConstraintLayout f241641v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/panel/WikiTreePanelDialog$_ViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", WikiFolderPushPlugin.WIKI_TOKEN, "getWikiToken", "setWikiToken", "uniqueUiId", "getUniqueUiId", "setUniqueUiId", "needOnBoarding", "", "getNeedOnBoarding", "()Z", "setNeedOnBoarding", "(Z)V", "isNeedExpandWindow", "setNeedExpandWindow", "pathResolveContext", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "getPathResolveContext", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;", "setPathResolveContext", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/pathresolve/WikiPathResolveContext;)V", "reusePathResolveTree", "getReusePathResolveTree", "setReusePathResolveTree", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void setNeedExpandWindow(boolean r100) {
            this.isNeedExpandWindow = r100;
        }

        public final void setNeedOnBoarding(boolean r100) {
            this.needOnBoarding = r100;
        }

        public final void setPathResolveContext(ar5.a r100) {
            this.pathResolveContext = r100;
        }

        public final void setReusePathResolveTree(boolean r100) {
            this.reusePathResolveTree = r100;
        }

        public final void setSpaceId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.spaceId = r100;
        }

        public final void setTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.title = r100;
        }

        public final void setUniqueUiId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.uniqueUiId = r100;
        }

        public final void setWikiToken(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.wikiToken = r100;
        }
    }

    public static final class a {
        @JvmStatic
        public static e3 a(ViewModelStoreOwner r100, ce5.a r101) {
            Intrinsics.checkNotNullParameter(r100, "viewModelStoreOwner");
            Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
            int r102 = WikiTreeCtrlView.f242300q;
            Intrinsics.checkNotNullParameter(r100, "dataLifeOwner");
            Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
            return WikiTreeCtrlView.a.a(r100, r101).cloneWorkspace();
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
        return b.a(this);
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
        return b.b(this);
    }

    public final WikiTreeCtrlView ea0() {
        View r100 = this.f241631l;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wiki_tree_ctrl_view);
    L8:
        this.f241631l = (WikiTreeCtrlView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiTreeCtrlView) r100;
    }

    public WikiTreePanelDialog() {
        this.f241638s = "";
    }

    public final void ca0() {
        if (ForsetiHelper.s(this) == true) goto L5;
        return;
    L5:
        if (n.C(getContext()) == false) goto L15;
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        if (ku5.c.k(getContext()) == false) goto L9;
        int r101 = 0;
    L10:
        r100.topMargin = y9c.d.a(r101);
        r100.gravity = 1;
        CustomConstraintLayout r102 = this.f241641v;
        if (r102 == null) goto L16;
        r102.setLayoutParams(r100);
        return;
    L16:
        return;
    L9:
        r101 = 39;
        goto L10
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L6;
        KeyEventDispatcher.Component r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return ((c) r100).e9();
    L6:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.panel.Hilt_WikiTreePanelDialog, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("Wiki_WikiTreePanelDialog", "onDestroy. ");
        j r100 = this.f241636q;
        if (r100 == null) goto L6;
        com.bytedance.ee.util.ui.j.e(r100);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f241631l = null;
        this.f241632m = null;
        this.f241633n = null;
        this.f241634o = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        View r100 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.a(getDialog());
        BottomSheetBehavior<FrameLayout> r101 = null;
        if ((r100 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r100;
    L6:
        if (r102 == null) goto L13;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        CoordinatorLayout.LayoutParams r104 = (CoordinatorLayout.LayoutParams) r103;
    L11:
        if (r104 == null) goto L13;
        ((ViewGroup.MarginLayoutParams) r104).height = -1;
        r102.setLayoutParams(r104);
        goto L13
    L10:
        r104 = null;
    L13:
        this.f216397i = com.bytedance.ee.bear.bizwidget.dialogfragment.b.c(getDialog());
        Dialog r105 = getDialog();
        if (r105 == null) goto L23;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L23;
        zo5.b r107 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r108 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L22;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r109 = ThreadMethodProxy.currentThread();
        if (r109 == com.larus.home.impl.utils.c.f346341a) goto L22;
        com.larus.home.impl.utils.c.a(r109, "getDecorView");
    L22:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.FrameLayout");
        r107.p((FrameLayout) r108);
    L23:
        if (r102 == null) goto L31;
        BottomSheetBehavior<FrameLayout> r110 = this.f216397i;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        ViewGroup.LayoutParams r111 = r102.getLayoutParams();
        if ((r111 instanceof CoordinatorLayout.LayoutParams) == false) goto L27;
        CoordinatorLayout.LayoutParams r112 = (CoordinatorLayout.LayoutParams) r111;
    L28:
        if (r112 != null) goto L30;
        r101 = r110;
        goto L31
    L30:
        r112.setBehavior(null);
        r102.setLayoutParams(r112);
        goto L31
    L27:
        r112 = null;
    L31:
        this.f216397i = r101;
        if (r101 == null) goto L34;
        r101.setState(3);
    L34:
        Y90(R.color.bg_base);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public static final void ba0(WikiTreePanelDialog r100) {
        if (TextUtils.isEmpty(r100.ea0().getFocusToken()) == false) goto L13;
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void fa0(uq5.a r110) {
        if (r110.f551296e == true) goto L147;
    L10:
        Bundle r100 = new Bundle();
        if (r110.f551293b == false) goto L13;
        r100.putBoolean("popLastDocument", true);
    L13:
        String r101 = r110.f551297f;
        if (r101 == null) goto L16;
        r100.putString("title", r101);
    L16:
        WikiInfo r102 = r110.f551298g;
        if (r102 == null) goto L19;
        r100.putSerializable("wiki_info", r102);
    L19:
        String r103 = r110.f551300i;
        if (r103 == null) goto L22;
        r100.putString("unique_ui_id", r103);
    L22:
        String r104 = r110.f551301j;
        if (r104 == null) goto L25;
        r100.putString("extra_from", r104);
    L25:
        r100.putBoolean("force_load_same", r110.f551299h);
        _ViewModel r105 = null;
        PluginHost r106 = PluginHost.fromFragment(this);     // Catch: Throwable -> L28
    L29:
        String r107 = r110.f551302k;
        WikiTreeCtrlView r108 = ea0();
        if (r108 == null) goto L32;
        String r109 = r108.getSpaceId();
    L33:
        WikiInfo r111 = r110.f551298g;
        if (r111 == null) goto L36;
        String r112 = r111.getSpaceId();
    L37:
        Intrinsics.checkNotNullParameter(r107, "explicitVisibleSpaceId");
        if (r107.length() <= 0) goto L40;
        boolean r113 = true;
    L41:
        String r114 = "";
        if (r113 == false) goto L44;
        String r115 = r107;
    L63:
        if (r106 == null) goto L71;
        Fragment r116 = r106.getHostFragment();
        if (r116 == null) goto L71;
        Fragment r117 = r116.getParentFragment();
        if (r117 == null) goto L71;
        if (ForsetiHelper.s(r117) == false) goto L71;
        Fragment r118 = r117;
    L73:
        if (r118 == null) goto L95;
        WikiInfo r119 = r110.f551298g;
        if (r119 != null) goto L77;
    L79:
        boolean r120 = false;
    L80:
        if (r120 == false) goto L95;
        Lazy r121 = ForsetiHelper.f216439a;
        Fragment r122 = r118;
    L82:
        if (r122 == null) goto L87;
        if ((r122 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n) == true) goto L88;
        r122 = r122.getParentFragment();
    L88:
        if (r122 == null) goto L95;
        MutableLiveData<Bundle> r123 = ((ForsetiVM) new ViewModelProvider(r122).get(ForsetiVM.class)).getLiveArgs();
        Bundle r124 = new Bundle();
        String r125 = da0(r110, r100, r115);
        r124.putString("url", r125);
        r124.putParcelable("bear_url", p.a().Z(p.a().v8(r125)));
        r124.putString(DocViewModel.EXTRA_SPACE_ID, r110.f551298g.getSpaceId());
        r124.putString("space_name", r110.f551295d);
        r124.putInt("type", r110.f551298g.getObjType());
        r124.putString("obj_token", r110.f551298g.getObjToken());
        r124.putSerializable("wiki_info", r110.f551298g);
        _ViewModel r126 = this.f241635p;
        if (r126 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L93:
        r124.putString("last_token", r105.getWikiToken());
        r124.putBoolean("is_from_wiki_tree_open", true);
        r123.postValue(r124);
        return;
    L92:
        r105 = r126;
        goto L93
    L87:
        r122 = null;
        goto L88
    L77:
        if (r119.getObjType() != 22) goto L79;
        r120 = true;
    L95:
        WikiInfo r127 = r110.f551298g;
        if (r127 == null) goto L98;
        Integer r128 = Integer.valueOf(r127.getObjType());
    L100:
        if (AppInfoUtils.f().booleanValue() == false) goto L132;
        if (r128 == null) goto L132;
        if (fx4.a.c(r128.intValue()) == false) goto L132;
        if (fx4.a.e(r128.intValue()) == true) goto L132;
        String r129 = da0(r110, r100, r110.f551302k);
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L113
        Uri r131 = UriProtector.parse(r129);     // Catch: Throwable -> L113
        if (TextUtils.equals(UriProtector.getQueryParameter(r131, "ccm_skip_officesdk_route"), "1") == false) goto L110;
        String r132 = r129;
    L111:
        Object r133 = Result.m9449constructorimpl(r132);     // Catch: Throwable -> L113
    L115:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L118;
        tt5.a.e("Wiki_WikiTreePanelDialog", "buildUnsupportedTypeUrl failed", r134, false);
    L118:
        Object r135 = r129;
        if (Result.m9455isFailureimpl(r133) == true) goto L122;
        r135 = r133;
    L122:
        String r136 = (String) r135;
        t45.c r137 = (t45.c) LarkContext.spiByDwarf(t45.c.class);
        WikiInfo r138 = r110.f551298g;
        if (r138 == null) goto L125;
        Integer r139 = Integer.valueOf(r138.getObjType());
    L126:
        String r140 = r137.T6(r136, r139);
        if (r140 == null) goto L130;
        r114 = r140;
    L130:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r114);
        return;
    L125:
        r139 = null;
        goto L126
    L110:
        String r141 = r131.buildUpon().appendQueryParameter("ccm_skip_officesdk_route", "1").build().toString();     // Catch: Throwable -> L113
        Intrinsics.checkNotNull(r141);     // Catch: Throwable -> L113
        r132 = r141;
    L113:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L132:
        String r143 = r110.f551294c;
        if (r143 != null) goto L140;
        WikiTreeCtrlView r144 = ea0();
        if (r144 == null) goto L137;
        r143 = r144.getSpaceId();
    L138:
        if (r143 != null) goto L140;
        String r145 = "";
    L141:
        String r146 = r110.f551295d;
        String r147 = r110.f551292a;
        _ViewModel r148 = this.f241635p;
        if (r148 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L145:
        o.b(r145, r146, r147, r100, Boolean.valueOf(r105.isNeedExpandWindow()), r118, r115);
        return;
    L144:
        r105 = r148;
        goto L145
    L137:
        r143 = null;
    L140:
        r145 = r143;
        goto L141
    L98:
        r128 = null;
    L71:
        r118 = null;
        goto L73
    L44:
        if (r109 != null) goto L46;
    L49:
        boolean r149 = true;
    L50:
        if (r149 == true) goto L62;
        if (r112 != null) goto L53;
    L56:
        boolean r150 = true;
    L57:
        if (r150 == true) goto L62;
        if (Intrinsics.areEqual(r109, r112) == true) goto L62;
        r115 = r109;
        goto L63
    L53:
        if (r112.length() == 0) goto L56;
        r150 = false;
    L62:
        r115 = "";
        goto L63
    L46:
        if (r109.length() == 0) goto L49;
        r149 = false;
        goto L50
    L40:
        r113 = false;
        goto L41
    L36:
        r112 = null;
        goto L37
    L32:
        r109 = null;
    L28:
        r106 = null;
        goto L29
    L147:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r151 = DialogFragmentLancet.sLastShowStack;
        if (r151 == null) goto L10;
        com.bytedance.crash.d.d(r151, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ca0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ce5.a r101 = new ce5.a(this);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f241640u = r101;
        Long r102 = gq5.b.f482179a;
        gq5.b.f482179a = Long.valueOf(System.currentTimeMillis());
        tt5.a.h("Wiki_WikiTreePanelDialog", "onCreate. ");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f241641v = (CustomConstraintLayout) r110.findViewById(R.id.decor);
        View r112 = null;
        PluginHost r113 = PluginHost.fromFragment(this);     // Catch: Throwable -> L5
    L6:
        if (r113 == null) goto L14;
        boolean r100 = ForsetiHelper.s(r113.getHostFragment());
        ViewModelStoreOwner r114 = r113;
        if (r100 == true) goto L11;
        r114 = null;
    L11:
        if (r114 == null) goto L14;
    L20:
        ViewModelStoreOwner r101 = r114;
        if (r101 != null) goto L24;
        tt5.a.d("Wiki_WikiTreePanelDialog", "viewModelStoreOwner is null!");
        return;
    L24:
        _ViewModel r102 = (_ViewModel) new ViewModelProvider(r101).get(_ViewModel.class);
        this.f241635p = r102;
        if (r102 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L27:
        String r103 = r102.getSpaceId();
        _ViewModel r104 = this.f241635p;
        if (r104 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r104 = null;
    L30:
        gq5.d.p(r103, r104.getWikiToken(), null, false, 12);
        WikiTreeCtrlView.c r105 = new WikiTreeCtrlView.c();
        boolean r115 = true;
        r105.f242320c = true;
        r105.f242321d = true;
        r105.f242322e = true;
        r105.f242323f = true;
        r105.f242324g = yp5.c.i();
        r105.f242325h = true;
        WeakReference r106 = new WeakReference(ea0());
        ce5.a r107 = this.f241640u;
        if (r107 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r107 = null;
    L34:
        r105.f242328k = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.n(this, r106, r107));
        r105.f242329l = CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.p(this, new WeakReference(ea0())));
        r105.f242332o = CollectionsKt.listOf(new WikiBottomDecoration(R.dimen.space_kit_len_40));
        Intrinsics.checkNotNullParameter("Wiki_WikiTreePanelDialog", "<set-?>");
        r105.f242333p = "Wiki_WikiTreePanelDialog";
        r105.f242334q = "panel";
        _ViewModel r116 = this.f241635p;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r116 = null;
    L37:
        r105.f242337t = r116.getPathResolveContext();
        _ViewModel r117 = this.f241635p;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r117 = null;
    L40:
        r105.f242338u = r117.getReusePathResolveTree();
        _ViewModel r118 = this.f241635p;
        if (r118 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r118 = null;
    L44:
        if (r118.getReusePathResolveTree() == false) goto L46;
        e3 r108 = null;
    L47:
        if (r108 == null) goto L64;
        _ViewModel r119 = this.f241635p;
        if (r119 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r119 = null;
    L52:
        if (r108.x(r119.getWikiToken()) == false) goto L64;
        WikiTreeCtrlView r120 = ea0();
        _ViewModel r109 = this.f241635p;
        if (r109 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r109 = null;
    L56:
        String r121 = r109.getWikiToken();
        _ViewModel r122 = this.f241635p;
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r122 = null;
    L59:
        String r123 = r122.getUniqueUiId();
        ce5.a r124 = this.f241640u;
        if (r124 == null) goto L62;
        ce5.a r125 = r124;
    L63:
        r120.i(new f1(this, r108, r121, r105, r101, r123, r125));
    L78:
        View r126 = this.f241632m;
        if (r126 != null) goto L85;
        View r127 = getView();
        if (r127 == null) goto L83;
        r126 = r127.findViewById(R.id.wiki_search_view);
    L84:
        this.f241632m = (WikiSearchPickerView) r126;
        goto L85
    L83:
        r126 = null;
    L85:
        this.f241637r = (WikiSearchPickerView) r126;
        _ViewModel r128 = this.f241635p;
        if (r128 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r128 = null;
    L88:
        String r129 = r128.getSpaceId();
        WikiTreeCtrlView r130 = ea0();
        if (r130 == null) goto L91;
        String r131 = r130.getSpaceId();
    L92:
        _ViewModel r132 = this.f241635p;
        if (r132 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r132 = null;
    L95:
        boolean r133 = r132.getReusePathResolveTree();
        _ViewModel r134 = this.f241635p;
        if (r134 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r134 = null;
    L98:
        ar5.a r135 = r134.getPathResolveContext();
        if (r135 == null) goto L101;
        String r136 = r135.f16013a;
    L102:
        Intrinsics.checkNotNullParameter(r129, "documentSpaceId");
        if (r136 != null) goto L105;
    L108:
        boolean r137 = true;
    L109:
        if (r137 == true) goto L111;
        r129 = r136;
    L119:
        this.f241638s = r129;
        WikiSearchPickerView r138 = this.f241637r;
        if (r138 == null) goto L122;
        r138.c(this, r129, false);
    L122:
        ea0().setTreeUpdateListener(new uq5.d(this));
        View r139 = this.f241633n;
        if (r139 != null) goto L129;
        View r140 = getView();
        if (r140 == null) goto L127;
        r139 = r140.findViewById(R.id.close_icon);
    L128:
        this.f241633n = (AppCompatImageView) r139;
        goto L129
    L127:
        r139 = null;
    L129:
        ((AppCompatImageView) r139).setOnClickListener(new e(this));
        _ViewModel r141 = this.f241635p;
        if (r141 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r141 = null;
    L132:
        String r142 = r141.getTitle();
        SpaceInfo r143 = ea0().getSpaceInfo();
        if (r143 == null) goto L135;
        String r144 = r143.getSpaceName();
    L137:
        if (TextUtils.isEmpty(r142) == true) goto L148;
        _ViewModel r145 = this.f241635p;
        if (r145 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r145 = null;
    L142:
        if (r145.getPathResolveContext() != null) goto L148;
        _ViewModel r146 = this.f241635p;
        if (r146 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r146 = null;
    L147:
        if (r146.getReusePathResolveTree() == true) goto L148;
    L151:
        View r147 = this.f241634o;
        if (r147 != null) goto L157;
        View r148 = getView();
        if (r148 == null) goto L156;
        r112 = r148.findViewById(R.id.wiki_panel_title);
    L156:
        this.f241634o = (TextView) r112;
        r147 = r112;
    L157:
        ((TextView) r147).setText(r142);
        ca0();
        WikiSearchPickerView r149 = this.f241637r;
        if (r149 == null) goto L160;
        r149.setSearchViewDelegate(new uq5.b(this));
    L160:
        ea0().setViewDelegate(new uq5.c(this));
        return;
    L148:
        if (r144 == null) goto L151;
        r142 = r144;
        goto L151
    L135:
        r144 = null;
        goto L137
    L111:
        if (r133 == false) goto L119;
        if (r131 != null) goto L114;
    L117:
        if (r115 == true) goto L119;
        r129 = r131;
        goto L119
    L114:
        if (r131.length() == 0) goto L117;
        r115 = false;
        goto L117
    L105:
        if (r136.length() == 0) goto L108;
        r137 = false;
        goto L109
    L101:
        r136 = null;
        goto L102
    L91:
        r131 = null;
        goto L92
    L62:
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r125 = null;
    L64:
        WikiTreeCtrlView r150 = ea0();
        _ViewModel r151 = this.f241635p;
        if (r151 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r151 = null;
    L67:
        String r152 = r151.getSpaceId();
        _ViewModel r153 = this.f241635p;
        if (r153 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r153 = null;
    L70:
        String r154 = r153.getWikiToken();
        _ViewModel r155 = this.f241635p;
        if (r155 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r155 = null;
    L73:
        String r156 = r155.getUniqueUiId();
        ce5.a r157 = this.f241640u;
        if (r157 == null) goto L76;
        ce5.a r158 = r157;
    L77:
        r150.i(new f1(this, r152, r154, r105, r101, r156, r158));
        goto L78
    L76:
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r158 = null;
        goto L77
    L46:
        r108 = g3.a.f241900a.f241899a.getAndSet(null);
    L14:
        if (getParentFragment() == null) goto L19;
        Fragment r159 = getParentFragment();
        if (r159 == null) goto L18;
        r114 = r159.getActivity();
        goto L20
    L18:
        r114 = null;
        goto L20
    L19:
        r114 = getActivity();
    L5:
        r113 = null;
        goto L6
    }

    public static String da0(uq5.a r100, Bundle r101, String r102) {
        WikiInfo r103 = r100.f551298g;
        if (r103 == null) goto L6;
        String r104 = r103.getWikiToken();
        if (r104 == null) goto L6;
    L7:
        String r105 = r100.f551301j;
        String r106 = "";
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        boolean r107 = false;
        if (r105.length() != 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r105 = "pages";
    L16:
        String r109 = r101.getString("ccm_open_type");
        if (r109 == null) goto L20;
        r106 = r109;
    L20:
        String r110 = p.a().J8(sbb.e.f541303n.getType(), r104, r105, r106);
        if (yp5.c.h() == true) goto L23;
    L27:
        Intrinsics.checkNotNull(r110);
        return r110;
    L23:
        if (r102.length() <= 0) goto L25;
        r107 = true;
    L25:
        if (r107 == false) goto L27;
        r110 = UriProtector.parse(r110).buildUpon().appendQueryParameter("visible_space_id", r102).build().toString();
        goto L27
    L13:
        r108 = false;
    L6:
        r104 = r100.f551292a;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (isDetached() == true) goto L8;
        WikiTreeCtrlView r103 = ea0();
        if (r103 == null) goto L9;
        r103.o(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_tree_panel_dialog, r101, false);
    }
}
