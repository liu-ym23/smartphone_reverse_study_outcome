package com.bytedance.ee.bear.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020 H\u0003J\b\u0010$\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/profile/HalfProfileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "profilePageController", "Lcom/ss/android/lark/profile_api/IProfilePageController;", "invite", "Landroid/widget/TextView;", "content", "profileContainer", "Lcom/bytedance/ee/bear/profile/VerticalScrollInterceptLayout;", "inviteBanner", "Landroid/widget/LinearLayout;", "topDivider", "Landroid/view/View;", "shadow", "callback", "Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;", "getCallback", "()Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;", "setCallback", "(Lcom/bytedance/ee/bear/lark/dependency/IProfileDependency$HalfProfileResultCallBack;)V", "hasCalledCallback", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "init", "initDragView", "close", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HalfProfileFragment extends Fragment {
    public static final /* synthetic */ int m = 0;
    public r1c.a d;
    public TextView e;
    public TextView f;
    public VerticalScrollInterceptLayout g;
    public LinearLayout h;
    public View i;
    public View j;
    public c0.a k;
    public boolean l;

    public static final class a {
    }

    static {
    }

    public HalfProfileFragment() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.e = (TextView) r6.findViewById(2131375587);
        this.f = (TextView) r6.findViewById(2131367794);
        this.g = (VerticalScrollInterceptLayout) r6.findViewById(2131383203);
        this.h = (LinearLayout) r6.findViewById(2131375595);
        this.i = r6.findViewById(2131389146);
        this.j = r6.findViewById(2131386031);
        TextView r8 = this.e;
        if (r8 == null) goto L5;
        r8.setOnClickListener(new k(this));
    L5:
        View r9 = this.i;
        if (r9 == null) goto L8;
        r9.setVisibility(8);
    L8:
        LinearLayout r10 = this.h;
        if (r10 == null) goto L11;
        r10.setVisibility(0);
    L11:
        View r11 = this.j;
        if (r11 == null) goto L14;
        r11.setVisibility(0);
    L14:
        TextView r12 = this.f;
        String r1 = "";
        if (r12 == null) goto L23;
        Bundle r3 = getArguments();
        if (r3 == null) goto L19;
        String r4 = r3.getString("content");
    L20:
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        r12.setText(r4);
        goto L23
    L19:
        r4 = null;
    L23:
        TextView r13 = this.e;
        if (r13 == null) goto L32;
        Bundle r5 = getArguments();
        if (r5 == null) goto L28;
        String r14 = r5.getString("confirmText");
    L29:
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r13.setText(r14);
        goto L32
    L28:
        r14 = null;
    L32:
        Bundle r15 = getArguments();
        if (r15 == null) goto L35;
        String r16 = r15.getString("userId");
    L36:
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        Bundle r17 = getArguments();
        if (r17 == null) goto L41;
        String r18 = r17.getString("title");
    L42:
        if (r18 == null) goto L62;
        r1 = r18;
    L62:
        Pair r19 = ((c0) org.koin.android.ext.android.a.a(this).a.d().c(Reflection.getOrCreateKotlinClass(c0.class), null, null)).j4(PassportcConvention.b(this), r16, r1);     // Catch: Exception -> L55
        final Fragment r2 = (Fragment) r19.getFirst();
        getChildFragmentManager().registerFragmentLifecycleCallbacks(new HalfProfileFragment$initDragView$1(r2, this), false);
        r1c.a r20 = (r1c.a) r19.getSecond();
        this.d = r20;
        if (r20 == null) goto L49;
        r20.b(new m(this));
    L49:
        if (r2 == null) goto L57;
        FragmentTransaction r21 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r21, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "UserProfileFragmentV3", 2131383214) == true) goto L54;
        r21.add(2131383214, r2, "UserProfileFragmentV3");
    L54:
        r21.commitAllowingStateLoss();
    L57:
        tua.b r22 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r22 == null) goto L60;
        r22.u(this, new l(this, r22));
    L60:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r6);
        return;
    L55:
        e = move-exception;
        tt5.a.f("HalfProfileFragment", e, false);
        goto L57
    L41:
        r18 = null;
        goto L42
    L35:
        r16 = null;
        goto L36
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131558486, r3, false);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r5;
    }
}
