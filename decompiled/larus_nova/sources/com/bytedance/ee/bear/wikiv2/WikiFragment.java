package com.bytedance.ee.bear.wikiv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiEmptyView;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import yq5.a0;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\"\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010 2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020 H\u0002J,\u00106\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001a08H\u0002J \u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020/2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u001a\u0010;\u001a\u0002042\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(H\u0002J\b\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020\u001a2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u0014\u0010C\u001a\u00020\u001a2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010AH\u0002J\b\u0010E\u001a\u00020\u001aH\u0002J\u0018\u0010F\u001a\u00020\u001a2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u00020\u001a2\b\u0010J\u001a\u0004\u0018\u00010KJ\b\u0010L\u001a\u000204H\u0002J*\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(2\u0006\u00101\u001a\u000202H\u0002J\u0012\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002J\"\u0010Q\u001a\u00020R2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010S\u001a\u00020/2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 H\u0002J\b\u0010T\u001a\u00020/H\u0002J\b\u0010U\u001a\u00020\u001aH\u0016J\"\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/WikiFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "Lcom/bytedance/ee/bear/facade/common/extension/ActivityResultDeduplication;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "baseTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getBaseTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setBaseTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "wikiFragmentFromXml", "Landroid/widget/FrameLayout;", "getWikiFragmentFromXml", "()Landroid/widget/FrameLayout;", "setWikiFragmentFromXml", "(Landroid/widget/FrameLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadedWikiInfo", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiInfo;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onViewCreated", "view", "load", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "params", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "isLoad", "", "wikiInfo", "resolveLoadUrl", "onResolved", "Lkotlin/Function1;", "handleWikiInfoLoaded", "loadUrl", "checkMovToSpace", "args", "onPause", "dispatchLoadStart", "dispatchLoadFail", LynxError.LYNX_THROWABLE, "", "dispatchLoadSuccess", "hideLoading", "e", DyPayConstant.KEY_SHOW_LOADING, "browseReport", "findTopDocumentFragment", "Lcom/bytedance/ee/bear/document/DocumentFragment;", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "hasContentFragment", "openContentFragment", "ensureBitableAppUrl", "", "url", "requireContentFragment", "Landroidx/fragment/app/Fragment;", "genObjUrl", "requireBearUrl", LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiFragment extends Hilt_WikiFragment implements sa5.a, ta5.e, d0c.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f240459l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseTitleBar f240460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WikiEmptyView f240461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f240462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f240463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicReference<WikiInfo> f240464k;

    public static final class a {
        @JvmStatic
        public static WikiFragment a(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            if (r101 != null) goto L5;
            r101 = new Bundle();
        L5:
            r101.putString("url", r100);
            WikiFragment r102 = new WikiFragment();
            r102.setArguments(r101);
            return r102;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiFragment f240465a;

        public b(WikiFragment r100) {
            this.f240465a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (ForsetiHelper.c(this.f240465a) == false) goto L6;
            this.f240465a.Y90().setNeedReturnBack(true);
            return;
        L6:
            this.f240465a.Y90().setNeedReturnBack(false);
            tt5.a.h("WikiFragment", "onViewCreated: baseTitleBar LeftClickListener");
            FragmentActivity r101 = this.f240465a.getActivity();
            if (r101 == null) goto L10;
            r101.onBackPressed();
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

    public final BaseTitleBar Y90() {
        View r100 = this.f240460g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.baseTitleBar);
    L8:
        this.f240460g = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    public final WikiEmptyView Z90() {
        View r100 = this.f240461h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.wikiEmptyView);
    L8:
        this.f240461h = (WikiEmptyView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiEmptyView) r100;
    }

    public WikiFragment() {
        this.f240463j = new CompositeDisposable();
        this.f240464k = new AtomicReference();
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L5;
        KeyEventDispatcher.Component r100 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        UserSession r101 = ((d0c.c) r100).e9();     // Catch: Exception -> L7
    L9:
        return r101;
    L5:
        r101 = PassportcConvention.b(this);     // Catch: Exception -> L7
    L12:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f240463j.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f240460g = null;
        this.f240461h = null;
        this.f240462i = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        d25.d.j(null, null);
        d25.d.l(null);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public static BearUrl X90(BearUrl r100, WikiInfo r101) {
        String r102 = p.a().Fd(r100.f222564e, r101.getObjTypeString(), r101.getObjToken(), r100.f222563d);
        return p.a().Z(r102);
    }

    public final void W90(WikiInfo r100, ce5.a r101) {
        Z90().c(2);
        if (r100.getObjType() != sbb.e.f541301l.f541317b) goto L5;
    L6:
        p0.b(r100.getWikiToken(), r101);
        return;
    L5:
        if (r100.getObjType() == 111) goto L6;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (getChildFragmentManager().findFragmentById(R.id.wikiFragment) == null) goto L6;
        tt5.a.h("WikiFragment", "Find childFragment, return.");
        return;
    L6:
        boolean r102 = s1.f221470n;
        s1.f221482z = System.currentTimeMillis();
        ce5.a r103 = new ce5.a(this);
        Y90().setLeftClickListener(new b(this));
        WikiEmptyView r104 = Z90();
        View r105 = this.f240462i;
        if (r105 != null) goto L13;
        View r106 = getView();
        if (r106 == null) goto L11;
        r105 = r106.findViewById(R.id.wikiFragment);
    L12:
        this.f240462i = (FrameLayout) r105;
        goto L13
    L11:
        r105 = null;
    L13:
        WikiEmptyView.b r107 = new WikiEmptyView.b();
        r104.f242279g = (FrameLayout) r105;
        r104.f242280h = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L17;
        String r109 = r108.getString("url");
        if (r109 == null) goto L17;
    L18:
        BearUrl r110 = p.a().Z(p.a().v8(r109));
        Bundle r111 = getArguments();
        if (r111 == null) goto L21;
        Serializable r112 = r111.getSerializable("wiki_info");
    L22:
        WikiInfo r113 = (WikiInfo) r112;
        if (r110.f222564e != null) goto L25;
    L46:
        tt5.a.d("WikiFragment", "Invalid URL. ");
        return;
    L25:
        if (r110.f222561b == null) goto L46;
        if (r113 == null) goto L29;
        String r114 = r113.getObjToken();
    L30:
        d25.d.j(r110, r114);
        d25.d.l(r110);
        StringBuilder r115 = new StringBuilder("Wiki start. docFrom: ");
        r115.append(r110.f222567h);
        r115.append(" wikiInfo is null:");
        boolean r116 = true;
        if (r113 != null) goto L33;
        boolean r117 = true;
    L34:
        r115.append(r117);
        tt5.a.h("WikiFragment", r115.toString());
        this.f240464k.set(null);
        tt5.a.h("WikiFragment", "Wait wikiInfo.");
        if (r103.f23449d.isCurrentEnable("ccm.mobile.doc_upgrade_to_docx_v2") == false) goto L43;
        String r118 = r110.f222561b;
        if (fx4.a.f(r110.f222564e) == true) goto L39;
    L41:
        r116 = false;
    L42:
        Flowable<up5.b<WikiInfo>> r119 = p0.d(r118, r113, r103, r116);
    L44:
        up5.g.a(r119.subscribe(new com.bytedance.ee.bear.wikiv2.b(this, r110, r103), new c(this), d.f240689a, new e(this)), this.f240463j);
        return;
    L39:
        if (Intrinsics.areEqual(r110.f222563d.get("is_docx_wiki"), "1") == true) goto L41;
    L43:
        r119 = p0.d(r110.f222561b, r113, r103, false);
        goto L44
    L33:
        r117 = false;
        goto L34
    L29:
        r114 = null;
        goto L30
    L21:
        r112 = null;
    L17:
        r109 = "";
        goto L18
    }

    public final Fragment aa0(BearUrl r100, WikiInfo r101, Bundle r102) {
        if (r101.getObjType() != 12) goto L31;
        BearUrl r103 = p.a().Z(p.a().Le(r101.getObjTypeString(), r101.getObjToken(), r100.f222563d));
        SpaceFileOpenEntity r104 = new SpaceFileOpenEntity(r103.f222561b, "");
        r104.setUrl(r103.f222564e);
        if (r102 == null) goto L7;
        String r105 = r102.getString("url");
    L8:
        r104.setOriginUrl(r105);
        r104.setAppId(BDLocationException.ERROR_SHAKE_UPLOAD);
        r104.setPreviewFrom("wiki");
        r104.setMountPoint("wiki");
        Map<String, String> r106 = r100.f222563d;
        if (r106 == null) goto L11;
        String r107 = r106.get("docId");
    L12:
        r104.setFeedId(r107);
        if (r102 == null) goto L15;
        Bundle r108 = r102.getBundle("remind_binder");
    L16:
        r104.setReminderBinder(r108);
        r104.setWikiUrl(p.a().Le(sbb.e.f541303n.getType(), r101.getWikiToken(), r100.f222563d));
        if (r102 == null) goto L19;
        Serializable r109 = r102.getSerializable("extra_data_map");
    L20:
        if (r109 == null) goto L27;
        if ((r109 instanceof Map) == false) goto L24;
        Map<String, String> r110 = (Map) r109;
    L25:
        r104.setExtra(r110);
        goto L27
    L24:
        r110 = null;
    L27:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L29;
        r104.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r104.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L29:
        UserContainerDriveMainFragment r111 = ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).d(r104, r102);
        Intrinsics.checkNotNull(r111);
        return r111;
    L19:
        r109 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L7:
        r105 = null;
        goto L8
    L31:
        return DocumentFragment.la0(r101.getObjTypeString(), r100.f222564e, r102, e9());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        tt5.a.h("WikiFragment", "onActivityResult()...requestCode = " + r100 + ", resultCode = " + r101);
        Iterator<Fragment> r103 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onActivityResult(r100, r101, r102);
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Lazy r103 = FGDowngradeHelper.f216485a;
        boolean r104 = false;
        if (FGDowngradeHelper.b() == false) goto L17;
        Context r105 = requireContext();
        Map<Integer, Queue<View>> r106 = qq5.d.f534485a;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        Queue r108 = (Queue) r107.get(Integer.valueOf(R.layout.wiki_fragment));
        if (r108 == null) goto L7;
        View r109 = (View) r108.poll();
    L8:
        StringBuilder r110 = new StringBuilder("ViewFactory.create, layoutRes: 2131568236, hasCache: ");
        if (r109 == null) goto L11;
        r104 = true;
    L11:
        r110.append(r104);
        tt5.a.h("ViewFactory", r110.toString());
        if (r109 != null) goto L14;
        r109 = qq5.d.a(r105, r101, R.layout.wiki_fragment);
    L14:
        qq5.d.b(eu5.b.a(), r101);
        return r109;
    L7:
        r109 = null;
        goto L8
    L17:
        return r100.inflate(R.layout.wiki_fragment, r101, false);
    }

    public static final void V90(WikiFragment r110, BearUrl r111, WikiInfo r112, ce5.a r113) {
        r110.getClass();
        tt5.a.h("WikiFragment", "handleWikiInfoLoaded: inSpace=" + r112.getInSpace() + ", type=" + r112.getObjType());
        Bundle r100 = r110.getArguments();
        if (r100 != null) goto L5;
    L9:
        if (r100 == null) goto L11;
        r100.putString(DocViewModel.EXTRA_SPACE_ID, r112.getSpaceId());
    L11:
        WikiInfo r101 = r110.f240464k.get();
        boolean r102 = true;
        if (r101 == null) goto L16;
        if (r101.getInSpace() == false) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == false) goto L27;
        tt5.a.h("WikiFragment", "This wiki has been moved to space. objToken: " + du5.b.i(r112.getObjToken()));
        Context r104 = r110.getContext();
        if (r104 == null) goto L23;
        UDToast.a r105 = UDToast.build(r104);
        r105.f285429b.e(R.string.CreationMobile_Wiki_GoingToDocs);
        r105.h();
    L23:
        if (r100 == null) goto L25;
        String r106 = r100.getString("redirect");
    L26:
        boolean r107 = !TextUtils.isEmpty(r106);
        WikiRouteTable.c(a0.a(r112), r107);
    L28:
        tt5.a.h("WikiFragment", "checkMovToSpace: isMovToSpace:" + r103 + " redirected:" + r107);
        if (r103 == true) goto L31;
    L39:
        boolean r108 = s1.f221470n;
        s1.A = System.currentTimeMillis();
        int r109 = r112.getObjType();
        Map<String, Set<String>> r114 = d25.d.f466514a;
        d25.d.f466521h = sbb.e.f(r109);
        if (r112.getObjType() == 8) goto L62;
    L56:
        FragmentTransaction r115 = r110.getChildFragmentManager().beginTransaction();
        Fragment r116 = r110.aa0(r111, r112, r100);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r116, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.wikiFragment) == true) goto L60;
        r115 = r115.replace(R.id.wikiFragment, r116);
    L60:
        r115.commitAllowingStateLoss();
        tt5.a.h("WikiFragment", "Load onSuccess. Type: " + r111.f222560a);
        r110.W90(r112, r113);
        r110.f240464k.set(r112);
        return;
    L62:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L43
        Object r118 = Result.m9449constructorimpl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L43
    L46:
        if (Result.m9455isFailureimpl(r118) == false) goto L48;
        r118 = null;
    L48:
        bn4.a r119 = (bn4.a) r118;
        if (r119 != null) goto L51;
    L53:
        r102 = false;
    L54:
        if (r102 == false) goto L56;
        r110.f240464k.set(r112);
        r119.o(r112.getObjToken(), new f(r110, r111, r112, r100, r113));
        return;
    L51:
        if (r119.m() != true) goto L53;
    L43:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L31:
        if (ForsetiHelper.p() == false) goto L39;
        if (r100 == null) goto L34;
        r100.putParcelable("bear_url", r111);
    L34:
        com.bytedance.ee.bear.route.h r121 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r122 = r112.getWikiToken();
        if (r121.Xb(r122) == false) goto L39;
        String r123 = r111.f222561b;
        if (r123 == null) goto L39;
        int r124 = com.bytedance.ee.bear.route.c.f236659a;
        r121.Pb(r122, com.bytedance.ee.bear.route.c.c(r123, r111.f222564e, com.bytedance.ee.bear.route.c.b(r122), com.bytedance.ee.bear.route.c.a(r123)), false);
        goto L39
    L25:
        r106 = null;
        goto L26
    L27:
        r107 = false;
    L16:
        if (r112.getInSpace() == false) goto L18;
        r103 = true;
        goto L19
    L5:
        if (r112.getInSpace() == false) goto L7;
        WikiInfo r125 = null;
    L8:
        r100.putSerializable("wiki_info", r125);
        goto L9
    L7:
        r125 = r112;
        goto L8
    }
}
