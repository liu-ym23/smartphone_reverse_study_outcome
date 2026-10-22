package com.bytedance.ee.bear.wikiv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiEmptyView;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\"\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010 2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020 H\u0002J,\u00106\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001a08H\u0002J \u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020/2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u001a\u0010;\u001a\u0002042\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(H\u0002J\b\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020\u001a2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u0014\u0010C\u001a\u00020\u001a2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010AH\u0002J\b\u0010E\u001a\u00020\u001aH\u0002J\u0018\u0010F\u001a\u00020\u001a2\u0006\u00105\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u00020\u001a2\b\u0010J\u001a\u0004\u0018\u00010KJ\b\u0010L\u001a\u000204H\u0002J*\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(2\u0006\u00101\u001a\u000202H\u0002J\u0012\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002J\"\u0010Q\u001a\u00020R2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010S\u001a\u00020/2\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u00020 H\u0002J\b\u0010T\u001a\u00020/H\u0002J\b\u0010U\u001a\u00020\u001aH\u0016J\"\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/WikiFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "Lcom/bytedance/ee/bear/facade/common/extension/ActivityResultDeduplication;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "baseTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getBaseTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setBaseTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "wikiEmptyViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "getWikiEmptyViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "setWikiEmptyViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;)V", "wikiFragmentFromXml", "Landroid/widget/FrameLayout;", "getWikiFragmentFromXml", "()Landroid/widget/FrameLayout;", "setWikiFragmentFromXml", "(Landroid/widget/FrameLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadedWikiInfo", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiInfo;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onViewCreated", "view", "load", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "params", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "isLoad", "", "wikiInfo", "resolveLoadUrl", "onResolved", "Lkotlin/Function1;", "handleWikiInfoLoaded", "loadUrl", "checkMovToSpace", "args", "onPause", "dispatchLoadStart", "dispatchLoadFail", "throwable", "", "dispatchLoadSuccess", "hideLoading", "e", "showLoading", "browseReport", "findTopDocumentFragment", "Lcom/bytedance/ee/bear/document/DocumentFragment;", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "hasContentFragment", "openContentFragment", "ensureBitableAppUrl", "", ResourceData.KEY_URL, "requireContentFragment", "Landroidx/fragment/app/Fragment;", "genObjUrl", "requireBearUrl", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiFragment extends Hilt_WikiFragment implements sa5.a, ta5.e, d0c.c {
    public static final /* synthetic */ int l = 0;
    public BaseTitleBar g;
    public WikiEmptyView h;
    public FrameLayout i;
    public final CompositeDisposable j;
    public final AtomicReference<WikiInfo> k;

    public static final class a {
        @JvmStatic
        public static WikiFragment a(String r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_URL);
            if (r2 != null) goto L5;
            r2 = new Bundle();
        L5:
            r2.putString(ResourceData.KEY_URL, r1);
            WikiFragment r3 = new WikiFragment();
            r3.setArguments(r2);
            return r3;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WikiFragment a;

        public b(WikiFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (ForsetiHelper.c(this.a) == false) goto L6;
            this.a.Y90().setNeedReturnBack(true);
            return;
        L6:
            this.a.Y90().setNeedReturnBack(false);
            tt5.a.h("WikiFragment", "onViewCreated: baseTitleBar LeftClickListener");
            FragmentActivity r3 = this.a.getActivity();
            if (r3 == null) goto L10;
            r3.onBackPressed();
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

    public final BaseTitleBar Y90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131363979);
    L8:
        this.g = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public final WikiEmptyView Z90() {
        EmptyView r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131393209);
    L8:
        this.h = (WikiEmptyView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiEmptyView) r0;
    }

    public WikiFragment() {
        this.j = new CompositeDisposable();
        this.k = new AtomicReference();
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L5;
        d0c.c r0 = getActivity();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");     // Catch: Exception -> L7
        UserSession r1 = r0.e9();     // Catch: Exception -> L7
    L9:
        return r1;
    L5:
        r1 = PassportcConvention.b(this);     // Catch: Exception -> L7
    L12:
        return new ce5.a().b;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.clear();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        d25.d.j(null, null);
        d25.d.l(null);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m663provideComponent() {
        return provideComponent();
    }

    public static BearUrl X90(BearUrl r3, WikiInfo r4) {
        String r5 = p.a().Fd(r3.e, r4.getObjTypeString(), r4.getObjToken(), r3.d);
        return p.a().Z(r5);
    }

    public final void W90(WikiInfo r3, ce5.a r4) {
        Z90().c(2);
        if (r3.getObjType() != sbb.e.l.b) goto L5;
    L6:
        p0.b(r3.getWikiToken(), r4);
        return;
    L5:
        if (r3.getObjType() == 111) goto L6;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        if (getChildFragmentManager().findFragmentById(2131393212) == null) goto L6;
        tt5.a.h("WikiFragment", "Find childFragment, return.");
        return;
    L6:
        boolean r10 = s1.n;
        s1.z = System.currentTimeMillis();
        ce5.a r11 = new ce5.a(this);
        Y90().setLeftClickListener(new b(this));
        WikiEmptyView r1 = Z90();
        View r2 = this.i;
        if (r2 != null) goto L13;
        View r3 = getView();
        if (r3 == null) goto L11;
        r2 = r3.findViewById(2131393212);
    L12:
        this.i = (FrameLayout) r2;
        goto L13
    L11:
        r2 = null;
    L13:
        WikiEmptyView.b r12 = new WikiEmptyView.b();
        r1.g = (FrameLayout) r2;
        r1.h = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L17;
        String r14 = r13.getString(ResourceData.KEY_URL);
        if (r14 == null) goto L17;
    L18:
        BearUrl r15 = p.a().Z(p.a().v8(r14));
        Bundle r4 = getArguments();
        if (r4 == null) goto L21;
        Serializable r5 = r4.getSerializable("wiki_info");
    L22:
        WikiInfo r6 = (WikiInfo) r5;
        if (r15.e != null) goto L25;
    L46:
        tt5.a.d("WikiFragment", "Invalid URL. ");
        return;
    L25:
        if (r15.b == null) goto L46;
        if (r6 == null) goto L29;
        String r7 = r6.getObjToken();
    L30:
        d25.d.j(r15, r7);
        d25.d.l(r15);
        StringBuilder r16 = new StringBuilder("Wiki start. docFrom: ");
        r16.append(r15.h);
        r16.append(" wikiInfo is null:");
        boolean r17 = true;
        if (r6 != null) goto L33;
        boolean r18 = true;
    L34:
        r16.append(r18);
        tt5.a.h("WikiFragment", r16.toString());
        this.k.set(null);
        tt5.a.h("WikiFragment", "Wait wikiInfo.");
        if (r11.d.isCurrentEnable("ccm.mobile.doc_upgrade_to_docx_v2") == false) goto L43;
        String r0 = r15.b;
        if (fx4.a.f(r15.e) == true) goto L39;
    L41:
        r17 = false;
    L42:
        Flowable<up5.b<WikiInfo>> r19 = p0.d(r0, r6, r11, r17);
    L44:
        up5.g.a(r19.subscribe(new com.bytedance.ee.bear.wikiv2.b(this, r15, r11), new c(this), d.a, new e(this)), this.j);
        return;
    L39:
        if (Intrinsics.areEqual(r15.d.get("is_docx_wiki"), "1") == true) goto L41;
    L43:
        r19 = p0.d(r15.b, r6, r11, false);
        goto L44
    L33:
        r18 = false;
        goto L34
    L29:
        r7 = null;
        goto L30
    L21:
        r5 = null;
    L17:
        r14 = "";
        goto L18
    }

    public final Fragment aa0(BearUrl r5, WikiInfo r6, Bundle r7) {
        if (r6.getObjType() != 12) goto L31;
        BearUrl r0 = p.a().Z(p.a().Le(r6.getObjTypeString(), r6.getObjToken(), r5.d));
        SpaceFileOpenEntity r1 = new SpaceFileOpenEntity(r0.b, "");
        r1.setUrl(r0.e);
        if (r7 == null) goto L7;
        String r2 = r7.getString(ResourceData.KEY_URL);
    L8:
        r1.setOriginUrl(r2);
        r1.setAppId("56");
        r1.setPreviewFrom(DocumentType.WIKI_NAME);
        r1.setMountPoint(DocumentType.WIKI_NAME);
        Map r3 = r5.d;
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("docId");
    L12:
        r1.setFeedId(r4);
        if (r7 == null) goto L15;
        Bundle r8 = r7.getBundle("remind_binder");
    L16:
        r1.setReminderBinder(r8);
        r1.setWikiUrl(p.a().Le(sbb.e.n.getType(), r6.getWikiToken(), r5.d));
        if (r7 == null) goto L19;
        Serializable r9 = r7.getSerializable("extra_data_map");
    L20:
        if (r9 == null) goto L27;
        if ((r9 instanceof Map) == false) goto L24;
        Map r10 = (Map) r9;
    L25:
        r1.setExtra(r10);
        goto L27
    L24:
        r10 = null;
    L27:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L29;
        r1.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r1.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L29:
        UserContainerDriveMainFragment r11 = ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).d(r1, r7);
        Intrinsics.checkNotNull(r11);
        return r11;
    L19:
        r9 = null;
        goto L20
    L15:
        r8 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    L31:
        return DocumentFragment.la0(r6.getObjTypeString(), r5.e, r7, e9());
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        tt5.a.h("WikiFragment", "onActivityResult()...requestCode = " + r3 + ", resultCode = " + r4);
        Iterator r0 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Fragment) r0.next()).onActivityResult(r3, r4, r5);
        goto L4
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Lazy r8 = FGDowngradeHelper.a;
        boolean r0 = false;
        if (FGDowngradeHelper.b() == false) goto L17;
        Context r9 = requireContext();
        Queue r10 = (Queue) ((ConcurrentHashMap) qq5.d.a).get(2131568236);
        if (r10 == null) goto L7;
        View r11 = (View) r10.poll();
    L8:
        StringBuilder r2 = new StringBuilder("ViewFactory.create, layoutRes: 2131568236, hasCache: ");
        if (r11 == null) goto L11;
        r0 = true;
    L11:
        r2.append(r0);
        tt5.a.h("ViewFactory", r2.toString());
        if (r11 != null) goto L14;
        r11 = qq5.d.a(r9, r6, 2131568236);
    L14:
        qq5.d.b(eu5.b.a(), r6);
        return r11;
    L7:
        r11 = null;
        goto L8
    L17:
        return r5.inflate(2131568236, r6, false);
    }

    public static final void V90(WikiFragment r12, BearUrl r13, WikiInfo r14, ce5.a r15) {
        r12.getClass();
        tt5.a.h("WikiFragment", "handleWikiInfoLoaded: inSpace=" + r14.getInSpace() + ", type=" + r14.getObjType());
        Bundle r6 = r12.getArguments();
        if (r6 != null) goto L5;
    L9:
        if (r6 == null) goto L11;
        r6.putString("space_id", r14.getSpaceId());
    L11:
        WikiInfo r2 = r12.k.get();
        boolean r3 = true;
        if (r2 == null) goto L16;
        if (r2.getInSpace() == false) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L27;
        tt5.a.h("WikiFragment", "This wiki has been moved to space. objToken: " + du5.b.i(r14.getObjToken()));
        Context r5 = r12.getContext();
        if (r5 == null) goto L23;
        UDToast.a r7 = UDToast.build(r5);
        r7.b.e(2131887477);
        r7.h();
    L23:
        if (r6 == null) goto L25;
        String r8 = r6.getString("redirect");
    L26:
        boolean r9 = !TextUtils.isEmpty(r8);
        WikiRouteTable.c(a0.a(r14), r9);
    L28:
        tt5.a.h("WikiFragment", "checkMovToSpace: isMovToSpace:" + r4 + " redirected:" + r9);
        if (r4 == true) goto L31;
    L39:
        boolean r10 = s1.n;
        s1.A = System.currentTimeMillis();
        int r11 = r14.getObjType();
        Map r16 = d25.d.a;
        d25.d.h = sbb.e.f(r11);
        if (r14.getObjType() == 8) goto L62;
    L56:
        FragmentTransaction r17 = r12.getChildFragmentManager().beginTransaction();
        Fragment r18 = r12.aa0(r13, r14, r6);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393212) == true) goto L60;
        r17 = r17.replace(2131393212, r18);
    L60:
        r17.commitAllowingStateLoss();
        tt5.a.h("WikiFragment", "Load onSuccess. Type: " + r13.a);
        r12.W90(r14, r15);
        r12.k.set(r14);
        return;
    L62:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L43
        Object r20 = Result.constructor-impl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r20) == false) goto L48;
        r20 = null;
    L48:
        bn4.a r21 = (bn4.a) r20;
        if (r21 != null) goto L51;
    L53:
        r3 = false;
    L54:
        if (r3 == false) goto L56;
        r12.k.set(r14);
        r21.o(r14.getObjToken(), new f(r12, r13, r14, r6, r15));
        return;
    L51:
        if (r21.m() != true) goto L53;
    L43:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L31:
        if (ForsetiHelper.p() == false) goto L39;
        if (r6 == null) goto L34;
        r6.putParcelable("bear_url", r13);
    L34:
        com.bytedance.ee.bear.route.h r23 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r24 = r14.getWikiToken();
        if (r23.Xb(r24) == false) goto L39;
        String r25 = r13.b;
        if (r25 == null) goto L39;
        int r26 = com.bytedance.ee.bear.route.c.a;
        r23.Pb(r24, com.bytedance.ee.bear.route.c.c(r25, r13.e, com.bytedance.ee.bear.route.c.b(r24), com.bytedance.ee.bear.route.c.a(r25)), false);
        goto L39
    L25:
        r8 = null;
        goto L26
    L27:
        r9 = false;
    L16:
        if (r14.getInSpace() == false) goto L18;
        r4 = true;
        goto L19
    L5:
        if (r14.getInSpace() == false) goto L7;
        WikiInfo r27 = null;
    L8:
        r6.putSerializable("wiki_info", r27);
        goto L9
    L7:
        r27 = r14;
        goto L8
    }
}
