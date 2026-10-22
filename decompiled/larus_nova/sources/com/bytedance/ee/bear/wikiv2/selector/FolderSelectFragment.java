package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\u001aH\u0016J\u001a\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\tH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/list/selector/FolderSelectDependence;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "rootView", "Landroid/view/View;", "folderType", "", "objToken", "", "title", "ownerType", "isShareFolder", "", "external", "folderSource", "presenter", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectPresenter;", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "fetchOwnerType", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onDestroyView", "initMVP", "parseBundle", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "back", "openSearch", VideoEventOneOutSync.END_TYPE_FINISH, "finishWithIntent", "intent", "Landroid/content/Intent;", "resultCode", "getContext", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderSelectFragment extends Hilt_FolderSelectFragment implements td5.b, d0c.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f241083s = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f241084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f241085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f241086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f241087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f241088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f241089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f241090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f241091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f241092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.searchv2.a f241093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SelectorConfig f241094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f241095r;

    public static final class a {
        public static Fragment a(FragmentManager r100, Context r101, int r102, String r103, String r104, int r105, boolean r106, boolean r107, int r110, boolean r111, Bundle r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "objToken");
            Intrinsics.checkNotNullParameter(r104, "title");
            if (r112 != null) goto L5;
            Bundle r108 = new Bundle();
        L6:
            r108.putInt("extra_folder_type", r102);
            r108.putString("extra_obj_token", r103);
            r108.putString("extra_title", r104);
            r108.putInt("extra_owner_type", r105);
            r108.putBoolean("extra_is_share_folder", r106);
            r108.putBoolean("extra_external", r107);
            r108.putInt("extra_folder_source", r110);
            r108.putBoolean("extra_is_at_vc", r111);
            r108.putBoolean("extra_fetch_owner_type", r113);
            Fragment r109 = r100.getFragmentFactory().instantiate(r101.getClassLoader(), FolderSelectFragment.class.getName());
            r109.setArguments(r112);
            return r109;
        L5:
            r108 = r112;
            goto L6
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

    @Override // td5.b
    public final void Ra() {
        tt5.a.h("FolderSelectFragment", "openSearch()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241093p;
        if (r100 == null) goto L6;
        r100.vZ();
        return;
    }

    @Override // td5.b
    public final void back() {
        tt5.a.h("FolderSelectFragment", "back()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241093p;
        if (r100 == null) goto L11;
        r100.back();
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.onBackPressed();
        return;
    }

    @Override // td5.b
    public final void finish() {
        tt5.a.h("FolderSelectFragment", "finish()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L11;
        r100.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.finish();
        return;
    }

    public FolderSelectFragment() {
        this.f241085h = sbb.e.f541295f.f541317b;
        FolderVersion.Companion.getClass();
        this.f241088k = 5;
        this.f241091n = FolderSource.MY_SPACE.getSource();
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

    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_FolderSelectFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("FolderSelectFragment", "onDestroyView()...");
        d r100 = this.f241092o;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // td5.b
    public final void j7(td5.e r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        tt5.a.h("FolderSelectFragment", "openFolder()...folderType = " + this.f241085h + ", isShareFolder = " + this.f241089l + ", ownerType = " + this.f241088k);
        r100.f545512e = this.f241091n;
        com.bytedance.ee.bear.wikiv2.searchv2.a r101 = this.f241093p;
        if (r101 == null) goto L6;
        r101.j7(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_FolderSelectFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        tt5.a.h("FolderSelectFragment", "onAttach()...");
        if ((r100 instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L6;
        this.f241093p = (com.bytedance.ee.bear.wikiv2.searchv2.a) r100;
    L6:
        if (ForsetiHelper.p() == true) goto L8;
        return;
    L8:
        if (this.f241093p == null) goto L10;
        return;
    L10:
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L15;
        ActivityResultCaller r101 = getParentFragment();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");
        this.f241093p = (com.bytedance.ee.bear.wikiv2.searchv2.a) r101;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("FolderSelectFragment", "onCreate()...");
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        int r102 = r101.getInt("extra_folder_type");
    L6:
        this.f241085h = r102;
        Bundle r103 = getArguments();
        String r104 = "";
        if (r103 == null) goto L10;
        String r105 = r103.getString("extra_obj_token");
        if (r105 == null) goto L10;
    L11:
        this.f241086i = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L17;
        String r107 = r106.getString("extra_title");
        if (r107 == null) goto L17;
        r104 = r107;
    L17:
        this.f241087j = r104;
        Bundle r108 = getArguments();
        if (r108 == null) goto L20;
        int r109 = r108.getInt("extra_owner_type");
    L21:
        this.f241088k = r109;
        Bundle r110 = getArguments();
        boolean r111 = false;
        if (r110 == null) goto L24;
        boolean r112 = r110.getBoolean("extra_is_share_folder");
    L25:
        this.f241089l = r112;
        Bundle r113 = getArguments();
        if (r113 == null) goto L28;
        boolean r114 = r113.getBoolean("extra_external");
    L29:
        this.f241090m = r114;
        Bundle r115 = getArguments();
        if (r115 == null) goto L32;
        int r116 = r115.getInt("extra_folder_source");
    L33:
        this.f241091n = r116;
        Bundle r117 = getArguments();
        if (r117 == null) goto L37;
        SelectorConfig r118 = (SelectorConfig) r117.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
        if (r118 == null) goto L37;
    L38:
        this.f241094q = r118;
        Bundle r119 = getArguments();
        if (r119 == null) goto L41;
        r111 = r119.getBoolean("extra_fetch_owner_type");
    L41:
        this.f241095r = r111;
        return;
    L37:
        r118 = new SelectorConfig();
        goto L38
    L32:
        r116 = FolderSource.MY_SPACE.getSource();
        goto L33
    L28:
        r114 = false;
        goto L29
    L24:
        r112 = false;
        goto L25
    L20:
        FolderVersion.Companion.getClass();
        r109 = 5;
    L10:
        r105 = "";
        goto L11
    L5:
        r102 = sbb.e.f541295f.f541317b;
        goto L6
    }

    @Override // td5.b
    public final void bv(Intent r100, int r101) {
        tt5.a.h("FolderSelectFragment", "finishWithIntent()...resultCode = " + r101);
        if (ForsetiHelper.s(this) == false) goto L10;
        com.suite.lark.component.navroute.forseti.g r102 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r102 == null) goto L17;
        Bundle r103 = r100.getExtras();
        if (r103 != null) goto L9;
        r103 = new Bundle();
    L9:
        r102.c(r101, r103);
        return;
    L17:
        return;
    L10:
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L13;
        r104.setResult(r101, r100);
    L13:
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L19;
        r105.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        tt5.a.h("FolderSelectFragment", "initMVP()...");
        int r100 = this.f241085h;
        String r101 = this.f241087j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        String r102 = null;
    L6:
        View r103 = this.f241084g;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r104 = null;
    L10:
        SelectorConfig r105 = this.f241094q;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        SelectorConfig r106 = null;
    L14:
        e r107 = new e(r100, r102, r104, this, r106);
        Context r110 = getContext();
        int r108 = this.f241085h;
        String r109 = this.f241086i;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("objToken");
        String r111 = null;
    L18:
        iq5.d r112 = new iq5.d(r110, r108, r111, this.f241088k, this.f241089l);
        com.bytedance.ee.bear.more.b r113 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Context r114 = getContext();
        String r115 = this.f241086i;
        if (r115 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("objToken");
        String r116 = null;
    L22:
        int r117 = this.f241085h;
        String r118 = this.f241087j;
        if (r118 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        String r119 = null;
    L26:
        int r120 = this.f241088k;
        boolean r121 = this.f241089l;
        boolean r122 = this.f241090m;
        int r123 = this.f241091n;
        SelectorConfig r124 = this.f241094q;
        if (r124 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        SelectorConfig r125 = null;
    L30:
        d r126 = new d(r113, r112, r107, r114, this, this, r116, r117, r119, r120, r121, r122, r123, r125, getArguments(), this.f241095r, (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6), new ce5.a(this));
        this.f241092o = r126;
        r126.create();
        if (ForsetiHelper.s(this) == false) goto L34;
        FragmentBackPressedHelperKt.a(this, new iq5.b(this));
        return;
    L34:
        return;
    L29:
        r125 = r124;
        goto L30
    L25:
        r119 = r118;
        goto L26
    L21:
        r116 = r115;
        goto L22
    L17:
        r111 = r109;
        goto L18
    L13:
        r106 = r105;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.list_fragment_sub_folder_select, r101, false);
        this.f241084g = r103;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r103;
    }
}
