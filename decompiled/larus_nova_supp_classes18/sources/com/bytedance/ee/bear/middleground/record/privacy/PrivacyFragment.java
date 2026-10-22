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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PrivacyFragment extends a implements c {
    public static final /* synthetic */ int B = 0;

    @Inject
    public h A;
    public int g;
    public String h;
    public View i;
    public UDSwitch j;
    public TextView k;
    public q l;
    public SpaceEmptyState m;
    public PrivacyViewModel n;
    public ViewGroup o;
    public ViewGroup p;
    public BearLottieView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public UDSwitch v;
    public BaseTitleBar w;
    public final Set<String> x;
    public final boolean y;

    @Inject
    public NetService z;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final void X90() {
        this.m.setVisibility(0);
        this.m.setImageRes(2131232545);
        if (this.y == false) goto L6;
        this.m.setTitle(n.x(getContext(), 2131889030));
        return;
    L6:
        this.m.setTitle(n.x(getContext(), 2131887412));
        this.m.setDesc(n.x(getContext(), 2131887411));
        this.m.setPrimaryText("");
    }

    public PrivacyFragment() {
        this.x = new HashSet();
        this.y = ((ai5.a) org.koin.java.a.a(ai5.a.class)).b();
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return getActivity().e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return PassportcConvention.a(eu5.b.a);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.n.destroy();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m298provideComponent() {
        return provideComponent();
    }

    static {
    }

    public static void V90(PrivacyFragment r1) {
        BearLottieView r0 = r1.q;
        if (r0 == null) goto L6;
        r0.cancelAnimation();
        r1.q.setVisibility(8);
        return;
    }

    public final void W90(boolean r2) {
        ViewGroup r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L8;
        this.u.setVisibility(0);
        this.p.setVisibility(0);
        return;
    L8:
        r0.setVisibility(8);
    }

    public final void Y90(boolean r2) {
        ViewGroup r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L8;
        this.u.setVisibility(0);
        this.o.setVisibility(0);
        return;
    L8:
        r0.setVisibility(8);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        this.g = r4.getInt("TYPE", 0);
        this.h = r4.getString("TOKEN", "");
        ((HashSet) this.x).add("privacyKey");
        ((HashSet) this.x).add("avatarKey");
        if (f.b(this) != null) goto L12;
        FragmentActivity r5 = getActivity();
        Context r0 = getContext();
        if (r0 == null) goto L7;
        Resources r1 = r0.getResources();
    L8:
        if (r5 == null) goto L13;
        if (r1 == null) goto L14;
        StatusBarUtil.setColorNoTranslucent(r5, r1.getColor(2131100558));
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.k = (TextView) this.i.findViewById(2131377680);
        this.j = this.i.findViewById(2131391818);
        this.v = this.i.findViewById(2131363750);
        this.m = (SpaceEmptyState) this.i.findViewById(2131373261);
        this.o = (ViewGroup) this.i.findViewById(2131381531);
        this.p = (ViewGroup) this.i.findViewById(2131363728);
        this.m.setVisibility(8);
        this.l = new q(getContext());
        this.u = (TextView) this.i.findViewById(2131388773);
        this.q = this.i.findViewById(2131379091);
        this.s = (TextView) this.i.findViewById(2131371934);
        this.t = (TextView) this.i.findViewById(2131381314);
        this.w = (BaseTitleBar) this.i.findViewById(2131388775);
        if (this.y == false) goto L6;
        this.s.setText(2131889033);
        this.t.setText(2131889034);
    L6:
        if (this.y == true) goto L8;
        this.q.setVisibility(8);
        this.o.setVisibility(0);
        this.u.setVisibility(0);
    L8:
        this.r = (TextView) this.i.findViewById(2131363705);
        this.k.setOnClickListener(new j(this));
        this.r.setOnClickListener(new e(this));
        this.j.setOnCheckedChangeListener(new yi5.f(this));
        final g r6 = f.b(this);
        if (r6 == null) goto L12;
        this.w.setLeftClickListener(new yi5.g(r6));
        this.i.setOnClickListener(null);
        this.i.setFitsSystemWindows(true);
    L12:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L14;
        this.k.setVisibility(8);
        this.r.setVisibility(8);
    L14:
        PrivacyViewModel r7 = (PrivacyViewModel) ViewModelProviders.of(this).get(PrivacyViewModel.class);
        this.n = r7;
        String r8 = this.h;
        int r0 = this.g;
        NetService r1 = this.z;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r7.attach(r8, r0, r1, new vo5.b(this));
        this.n.getData();
        this.n.getIsCheckMutableLiveData().observe(getViewLifecycleOwner(), new k(this));
        this.n.getStateMutableLiveData().observe(getViewLifecycleOwner(), new yi5.l(this));
        this.n.getShowAvatarLiveData().observe(getViewLifecycleOwner(), new yi5.c(this));
        this.n.getUserSettingLiveData().observe(getViewLifecycleOwner(), new d(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131564254, r3, false);
        this.i = r5;
        return r5;
    }
}
