package com.bytedance.ee.bear.middleground.record.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.n;
import com.jaeger.library.StatusBarUtil;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import yi5.a;
import yi5.d;
import yi5.e;
import yi5.j;
import yi5.k;

/* JADX INFO: loaded from: classes18.dex */
public class PrivacyFragment extends a implements c {
    public static final /* synthetic */ int B = 0;

    @Inject
    public h A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f234310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f234311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f234312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDSwitch f234313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f234314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q f234315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SpaceEmptyState f234316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PrivacyViewModel f234317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f234318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f234319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public BearLottieView f234320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f234321r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f234322s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f234323t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f234324u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public UDSwitch f234325v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BaseTitleBar f234326w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set<String> f234327x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f234328y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Inject
    public NetService f234329z;

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
    public final /* synthetic */ m getPassport() {
        return b.a(this);
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
    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final void X90() {
        this.f234316m.setVisibility(0);
        this.f234316m.setImageRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_access));
        if (this.f234328y == false) goto L6;
        this.f234316m.setTitle(n.x(getContext(), R.string.LarkCCM_Docs_DocDetail_PrivacyNoAvailable_Descrip));
        return;
    L6:
        this.f234316m.setTitle(n.x(getContext(), R.string.CreationMobile_Stats_Visits_NoPermissionToUse_title));
        this.f234316m.setDesc(n.x(getContext(), R.string.CreationMobile_Stats_Visits_NoPermissionToUse_desc));
        this.f234316m.setPrimaryText("");
    }

    public PrivacyFragment() {
        this.f234327x = new HashSet();
        this.f234328y = ((ai5.a) org.koin.java.a.a(ai5.a.class)).b();
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return ((c) getActivity()).e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return PassportcConvention.a(eu5.b.f474075a);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f234317n.destroy();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    static {
    }

    public static void V90(PrivacyFragment r100) {
        BearLottieView r101 = r100.f234320q;
        if (r101 == null) goto L6;
        r101.cancelAnimation();
        r100.f234320q.setVisibility(8);
        return;
    }

    public final void W90(boolean r100) {
        ViewGroup r101 = this.f234319p;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L8;
        this.f234324u.setVisibility(0);
        this.f234319p.setVisibility(0);
        return;
    L8:
        r101.setVisibility(8);
    }

    public final void Y90(boolean r100) {
        ViewGroup r101 = this.f234318o;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L8;
        this.f234324u.setVisibility(0);
        this.f234318o.setVisibility(0);
        return;
    L8:
        r101.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        this.f234310g = r101.getInt("TYPE", 0);
        this.f234311h = r101.getString(faceverify.q.KEY_TOKEN, "");
        ((HashSet) this.f234327x).add("privacyKey");
        ((HashSet) this.f234327x).add("avatarKey");
        if (f.b(this) != null) goto L12;
        FragmentActivity r102 = getActivity();
        Context r103 = getContext();
        if (r103 == null) goto L7;
        Resources r104 = r103.getResources();
    L8:
        if (r102 == null) goto L13;
        if (r104 == null) goto L14;
        StatusBarUtil.setColorNoTranslucent(r102, r104.getColor(R.color.bg_float_base));
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f234314k = (TextView) this.f234312i.findViewById(R.id.lean_more);
        this.f234313j = (UDSwitch) this.f234312i.findViewById(R.id.ud_switch);
        this.f234325v = (UDSwitch) this.f234312i.findViewById(R.id.avatar_ud_switch);
        this.f234316m = (SpaceEmptyState) this.f234312i.findViewById(R.id.found_empty_state);
        this.f234318o = (ViewGroup) this.f234312i.findViewById(R.id.open_root);
        this.f234319p = (ViewGroup) this.f234312i.findViewById(R.id.avatar_root);
        this.f234316m.setVisibility(8);
        this.f234315l = new q(getContext());
        this.f234324u = (TextView) this.f234312i.findViewById(R.id.title1);
        this.f234320q = (BearLottieView) this.f234312i.findViewById(R.id.loading_view);
        this.f234322s = (TextView) this.f234312i.findViewById(R.id.explain);
        this.f234323t = (TextView) this.f234312i.findViewById(R.id.oepn_text);
        this.f234326w = (BaseTitleBar) this.f234312i.findViewById(R.id.titleBar);
        if (this.f234328y == false) goto L6;
        this.f234322s.setText(R.string.LarkCCM_Docs_DocDetail_ViewHistory_Descrip);
        this.f234323t.setText(R.string.LarkCCM_Docs_DocDetail_ViewHistory_Title);
    L6:
        if (this.f234328y == true) goto L8;
        this.f234320q.setVisibility(8);
        this.f234318o.setVisibility(0);
        this.f234324u.setVisibility(0);
    L8:
        this.f234321r = (TextView) this.f234312i.findViewById(R.id.avatar_learn_more);
        this.f234314k.setOnClickListener(new j(this));
        this.f234321r.setOnClickListener(new e(this));
        this.f234313j.setOnCheckedChangeListener(new yi5.f(this));
        final g r102 = f.b(this);
        if (r102 == null) goto L12;
        this.f234326w.setLeftClickListener(new yi5.g(r102));
        this.f234312i.setOnClickListener(null);
        this.f234312i.setFitsSystemWindows(true);
    L12:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L14;
        this.f234314k.setVisibility(8);
        this.f234321r.setVisibility(8);
    L14:
        PrivacyViewModel r103 = (PrivacyViewModel) ViewModelProviders.of(this).get(PrivacyViewModel.class);
        this.f234317n = r103;
        String r104 = this.f234311h;
        int r105 = this.f234310g;
        NetService r106 = this.f234329z;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r103.attach(r104, r105, r106, new vo5.b(this));
        this.f234317n.getData();
        this.f234317n.getIsCheckMutableLiveData().observe(getViewLifecycleOwner(), new k(this));
        this.f234317n.getStateMutableLiveData().observe(getViewLifecycleOwner(), new yi5.l(this));
        this.f234317n.getShowAvatarLiveData().observe(getViewLifecycleOwner(), new yi5.c(this));
        this.f234317n.getUserSettingLiveData().observe(getViewLifecycleOwner(), new d(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.privacy_layout_fragment, r101, false);
        this.f234312i = r103;
        return r103;
    }
}
