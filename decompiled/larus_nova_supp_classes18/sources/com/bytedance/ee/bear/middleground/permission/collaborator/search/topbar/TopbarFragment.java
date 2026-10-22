package com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/TopbarFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/TopbarPresenter$IDependency;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/TopbarPresenter;", "title", "", "from", "", "inviteMemberParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "contentView", "Landroid/view/View;", "colorStateList", "Landroid/content/res/ColorStateList;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustContentBackground", "onBack", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopbarFragment extends BaseFragment implements b.a {
    public static final /* synthetic */ int k = 0;
    public b e;
    public String f;
    public int g;
    public InviteMemberParams h;
    public View i;
    public ColorStateList j;

    public static final class a {
        public static TopbarFragment a(String r2, int r3, InviteMemberParams r4) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r4, "inviteMemberParams");
            Bundle r0 = new Bundle();
            r0.putString("extra_title", r2);
            r0.putParcelable("extra_params", r4);
            r0.putInt("extra_from", r3);
            TopbarFragment r5 = new TopbarFragment();
            r5.setArguments(r0);
            return r5;
        }
    }

    static {
    }

    public TopbarFragment() {
        this.f = "";
        this.h = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.b.a
    public final void onBack() {
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if (requireParentFragment().getParentFragment() != null) goto L7;
        return;
    L7:
        if ((requireParentFragment().getParentFragment() instanceof dh5.a) == false) goto L12;
        dh5.a r0 = requireParentFragment().getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.back();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        b r0 = this.e;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void U90(Configuration r2) {
        int r3 = r2.orientation;
        if (2 != r3) goto L8;
        View r4 = this.i;
        if (r4 == null) goto L12;
        r4.setBackgroundResource(2131235325);
    L12:
        ColorStateList r5 = this.j;
        if (r5 == null) goto L18;
        View r0 = this.i;
        if (r0 == null) goto L19;
        r0.setBackgroundTintList(r5);
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (1 != r3) goto L12;
        View r6 = this.i;
        if (r6 == null) goto L12;
        r6.setBackgroundResource(2131235305);
        goto L12
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        U90(r2);
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("extra_title");
        if (r2 == null) goto L6;
    L7:
        this.f = r2;
        Bundle r3 = getArguments();
        int r4 = 0;
        if (r3 == null) goto L10;
        r4 = r3.getInt("extra_from", 0);
    L10:
        this.g = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L14;
        InviteMemberParams r6 = (InviteMemberParams) r5.getParcelable("extra_params");
        if (r6 == null) goto L14;
    L15:
        this.h = r6;
        return;
    L14:
        r6 = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    L6:
        r2 = getString(2131888220);
        goto L7
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        gh5.b r0 = getParentFragment();
        if (r0 != null) goto L5;
    L7:
        tt5.a.d("TopbarFragment", "keywordChangeListener is null");
        gh5.b r1 = null;
    L8:
        gh5.b r4 = r1;
        gh5.c r2 = new gh5.c(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class));
        if (this.h.getType() != 125) goto L11;
        boolean r16 = true;
    L12:
        FragmentActivity r9 = requireActivity();
        String r11 = this.f;
        InviteMemberParams r3 = this.h;
        boolean r12 = r3.f;
        boolean r13 = r3.g;
        boolean r14 = r3.h;
        int r15 = r3.getType();
        int r5 = this.g;
        if (r5 != 1) goto L15;
        boolean r17 = true;
    L16:
        if (r5 != 0) goto L18;
        boolean r18 = true;
    L19:
        b r8 = new b(r2, new c(r9, r20, r11, r12, r13, r14, r15, r16, r17, r18), this, r4, this.h, this.g);
        this.e = r8;
        r8.create();
        return;
    L18:
        r18 = false;
        goto L19
    L15:
        r17 = false;
        goto L16
    L11:
        r16 = false;
        goto L12
    L5:
        if ((r0 instanceof gh5.b) == false) goto L7;
        r1 = r0;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.i = r2.inflate(2131564189, r3, false);
        Context r5 = getContext();
        if (r5 == null) goto L5;
        ColorStateList r6 = ContextCompat.getColorStateList(r5, 2131100548);
    L6:
        this.j = r6;
        U90(getResources().getConfiguration());
        return this.i;
    L5:
        r6 = null;
        goto L6
    }
}
