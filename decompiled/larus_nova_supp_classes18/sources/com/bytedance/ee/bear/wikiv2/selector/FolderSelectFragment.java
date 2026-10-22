package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\u001aH\u0016J\u001a\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\tH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/list/selector/FolderSelectDependence;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "rootView", "Landroid/view/View;", "folderType", "", "objToken", "", "title", "ownerType", "isShareFolder", "", "external", "folderSource", "presenter", "Lcom/bytedance/ee/bear/wikiv2/selector/FolderSelectPresenter;", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "fetchOwnerType", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onDestroyView", "initMVP", "parseBundle", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "back", "openSearch", "finish", "finishWithIntent", "intent", "Landroid/content/Intent;", "resultCode", "getContext", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderSelectFragment extends Hilt_FolderSelectFragment implements td5.b, d0c.c {
    public static final /* synthetic */ int s = 0;
    public View g;
    public int h;
    public String i;
    public String j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public d o;
    public com.bytedance.ee.bear.wikiv2.searchv2.a p;
    public SelectorConfig q;
    public boolean r;

    public static final class a {
        public static Fragment a(FragmentManager r2, Context r3, int r4, String r5, String r6, int r7, boolean r8, boolean r9, int r10, boolean r11, Bundle r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r5, "objToken");
            Intrinsics.checkNotNullParameter(r6, "title");
            if (r12 != null) goto L5;
            Bundle r0 = new Bundle();
        L6:
            r0.putInt("extra_folder_type", r4);
            r0.putString("extra_obj_token", r5);
            r0.putString("extra_title", r6);
            r0.putInt("extra_owner_type", r7);
            r0.putBoolean("extra_is_share_folder", r8);
            r0.putBoolean("extra_external", r9);
            r0.putInt("extra_folder_source", r10);
            r0.putBoolean("extra_is_at_vc", r11);
            r0.putBoolean("extra_fetch_owner_type", r13);
            Fragment r14 = r2.getFragmentFactory().instantiate(r3.getClassLoader(), FolderSelectFragment.class.getName());
            r14.setArguments(r12);
            return r14;
        L5:
            r0 = r12;
            goto L6
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

    @Override // td5.b
    public final void Ra() {
        tt5.a.h("FolderSelectFragment", "openSearch()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.vZ();
        return;
    }

    @Override // td5.b
    public final void back() {
        tt5.a.h("FolderSelectFragment", "back()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.p;
        if (r0 == null) goto L11;
        r0.back();
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.onBackPressed();
        return;
    }

    @Override // td5.b
    public final void finish() {
        tt5.a.h("FolderSelectFragment", "finish()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L11;
        r0.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.finish();
        return;
    }

    public FolderSelectFragment() {
        this.h = sbb.e.f.b;
        FolderVersion.Companion.getClass();
        this.k = 5;
        this.n = FolderSource.MY_SPACE.getSource();
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        d0c.c r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return r0.e9();
    L6:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_FolderSelectFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        tt5.a.h("FolderSelectFragment", "onDestroyView()...");
        d r0 = this.o;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m682provideComponent() {
        return provideComponent();
    }

    @Override // td5.b
    public final void j7(td5.e r3) {
        Intrinsics.checkNotNullParameter(r3, "bean");
        tt5.a.h("FolderSelectFragment", "openFolder()...folderType = " + this.h + ", isShareFolder = " + this.l + ", ownerType = " + this.k);
        r3.e = this.n;
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.j7(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_FolderSelectFragment
    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        tt5.a.h("FolderSelectFragment", "onAttach()...");
        if ((r3 instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L6;
        this.p = (com.bytedance.ee.bear.wikiv2.searchv2.a) r3;
    L6:
        if (ForsetiHelper.p() == true) goto L8;
        return;
    L8:
        if (this.p == null) goto L10;
        return;
    L10:
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L15;
        com.bytedance.ee.bear.wikiv2.searchv2.a r4 = getParentFragment();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");
        this.p = r4;
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        tt5.a.h("FolderSelectFragment", "onCreate()...");
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        int r5 = r4.getInt("extra_folder_type");
    L6:
        this.h = r5;
        Bundle r6 = getArguments();
        String r0 = "";
        if (r6 == null) goto L10;
        String r7 = r6.getString("extra_obj_token");
        if (r7 == null) goto L10;
    L11:
        this.i = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L17;
        String r9 = r8.getString("extra_title");
        if (r9 == null) goto L17;
        r0 = r9;
    L17:
        this.j = r0;
        Bundle r10 = getArguments();
        if (r10 == null) goto L20;
        int r11 = r10.getInt("extra_owner_type");
    L21:
        this.k = r11;
        Bundle r12 = getArguments();
        boolean r1 = false;
        if (r12 == null) goto L24;
        boolean r13 = r12.getBoolean("extra_is_share_folder");
    L25:
        this.l = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L28;
        boolean r15 = r14.getBoolean("extra_external");
    L29:
        this.m = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L32;
        int r17 = r16.getInt("extra_folder_source");
    L33:
        this.n = r17;
        Bundle r18 = getArguments();
        if (r18 == null) goto L37;
        SelectorConfig r19 = (SelectorConfig) r18.getParcelable("extra_config");
        if (r19 == null) goto L37;
    L38:
        this.q = r19;
        Bundle r20 = getArguments();
        if (r20 == null) goto L41;
        r1 = r20.getBoolean("extra_fetch_owner_type");
    L41:
        this.r = r1;
        return;
    L37:
        r19 = new SelectorConfig();
        goto L38
    L32:
        r17 = FolderSource.MY_SPACE.getSource();
        goto L33
    L28:
        r15 = false;
        goto L29
    L24:
        r13 = false;
        goto L25
    L20:
        FolderVersion.Companion.getClass();
        r11 = 5;
    L10:
        r7 = "";
        goto L11
    L5:
        r5 = sbb.e.f.b;
        goto L6
    }

    @Override // td5.b
    public final void bv(Intent r3, int r4) {
        tt5.a.h("FolderSelectFragment", "finishWithIntent()...resultCode = " + r4);
        if (ForsetiHelper.s(this) == false) goto L10;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L17;
        Bundle r5 = r3.getExtras();
        if (r5 != null) goto L9;
        r5 = new Bundle();
    L9:
        r0.c(r4, r5);
        return;
    L17:
        return;
    L10:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.setResult(r4, r3);
    L13:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L19;
        r6.finish();
        return;
    }

    public final void onViewCreated(View r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r26, "view");
        super.onViewCreated(r26, r27);
        tt5.a.h("FolderSelectFragment", "initMVP()...");
        int r1 = this.h;
        String r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        String r2 = null;
    L6:
        View r3 = this.g;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r4 = null;
    L10:
        SelectorConfig r5 = this.q;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        SelectorConfig r6 = null;
    L14:
        e r7 = new e(r1, r2, r4, this, r6);
        Context r16 = getContext();
        int r8 = this.h;
        String r9 = this.i;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("objToken");
        String r18 = null;
    L18:
        iq5.d r10 = new iq5.d(r16, r8, r18, this.k, this.l);
        com.bytedance.ee.bear.more.b r11 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Context r12 = getContext();
        String r13 = this.i;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("objToken");
        String r14 = null;
    L22:
        int r15 = this.h;
        String r17 = this.j;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        String r19 = null;
    L26:
        int r20 = this.k;
        boolean r21 = this.l;
        boolean r22 = this.m;
        int r110 = this.n;
        SelectorConfig r23 = this.q;
        if (r23 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        SelectorConfig r111 = null;
    L30:
        d r112 = new d(r11, r10, r7, r12, this, this, r14, r15, r19, r20, r21, r22, r110, r111, getArguments(), this.r, (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6), new ce5.a(this));
        this.o = r112;
        r112.create();
        if (ForsetiHelper.s(this) == false) goto L34;
        FragmentBackPressedHelperKt.a(this, new iq5.b(this));
        return;
    L34:
        return;
    L29:
        r111 = r23;
        goto L30
    L25:
        r19 = r17;
        goto L26
    L21:
        r14 = r13;
        goto L22
    L17:
        r18 = r9;
        goto L18
    L13:
        r6 = r5;
        goto L14
    L9:
        r4 = r3;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563487, r3, false);
        this.g = r5;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r5;
    }
}
