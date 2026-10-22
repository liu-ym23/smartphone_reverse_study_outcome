package com.bytedance.ee.bear.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020 H\u0003J\b\u0010$\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/profile/HalfProfileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "profilePageController", "Lcom/ss/android/lark/profile_api/IProfilePageController;", "invite", "Landroid/widget/TextView;", "content", "profileContainer", "Lcom/bytedance/ee/bear/profile/VerticalScrollInterceptLayout;", "inviteBanner", "Landroid/widget/LinearLayout;", "topDivider", "Landroid/view/View;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "callback", "Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;", "getCallback", "()Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;", "setCallback", "(Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;)V", "hasCalledCallback", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "init", "initDragView", "close", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HalfProfileFragment extends Fragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f236262m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r1c.a f236263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f236264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f236265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VerticalScrollInterceptLayout f236266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f236267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f236268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f236269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c0.a f236270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f236271l;

    public static final class a {
    }

    static {
    }

    public HalfProfileFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f236264e = (TextView) r100.findViewById(R.id.invite);
        this.f236265f = (TextView) r100.findViewById(R.id.content);
        this.f236266g = (VerticalScrollInterceptLayout) r100.findViewById(R.id.profile_container);
        this.f236267h = (LinearLayout) r100.findViewById(R.id.invite_banner);
        this.f236268i = r100.findViewById(R.id.top_divider);
        this.f236269j = r100.findViewById(R.id.shadow);
        TextView r102 = this.f236264e;
        if (r102 == null) goto L5;
        r102.setOnClickListener(new k(this));
    L5:
        View r103 = this.f236268i;
        if (r103 == null) goto L8;
        r103.setVisibility(8);
    L8:
        LinearLayout r104 = this.f236267h;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        View r105 = this.f236269j;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        TextView r106 = this.f236265f;
        String r107 = "";
        if (r106 == null) goto L23;
        Bundle r108 = getArguments();
        if (r108 == null) goto L19;
        String r109 = r108.getString("content");
    L20:
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r106.setText(r109);
        goto L23
    L19:
        r109 = null;
    L23:
        TextView r110 = this.f236264e;
        if (r110 == null) goto L32;
        Bundle r111 = getArguments();
        if (r111 == null) goto L28;
        String r112 = r111.getString("confirmText");
    L29:
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        r110.setText(r112);
        goto L32
    L28:
        r112 = null;
    L32:
        Bundle r113 = getArguments();
        if (r113 == null) goto L35;
        String r114 = r113.getString("userId");
    L36:
        if (r114 != null) goto L38;
        r114 = "";
    L38:
        Bundle r115 = getArguments();
        if (r115 == null) goto L41;
        String r116 = r115.getString("title");
    L42:
        if (r116 == null) goto L62;
        r107 = r116;
    L62:
        Pair<Fragment, r1c.a> r117 = ((c0) org.koin.android.ext.android.a.a(this).f526122a.d().c(Reflection.getOrCreateKotlinClass(c0.class), null, null)).j4(PassportcConvention.b(this), r114, r107);     // Catch: Exception -> L55
        final Fragment r118 = r117.getFirst();
        getChildFragmentManager().registerFragmentLifecycleCallbacks(new HalfProfileFragment$initDragView$1(r118, this), false);
        r1c.a r119 = r117.getSecond();
        this.f236263d = r119;
        if (r119 == null) goto L49;
        r119.b(new m(this));
    L49:
        if (r118 == null) goto L57;
        FragmentTransaction r120 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r120, r118, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "UserProfileFragmentV3", R.id.profile_fragment) == true) goto L54;
        r120.add(R.id.profile_fragment, r118, "UserProfileFragmentV3");
    L54:
        r120.commitAllowingStateLoss();
    L57:
        tua.b r121 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r121 == null) goto L60;
        r121.u(this, new l(this, r121));
    L60:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r100);
        return;
    L55:
        e = move-exception;
        tt5.a.f("HalfProfileFragment", e, false);
        goto L57
    L41:
        r116 = null;
        goto L42
    L35:
        r114 = null;
        goto L36
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.activity_half_profile, r101, false);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r103;
    }
}
