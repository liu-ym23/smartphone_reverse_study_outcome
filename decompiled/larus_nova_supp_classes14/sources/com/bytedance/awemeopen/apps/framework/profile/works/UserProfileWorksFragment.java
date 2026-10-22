package com.bytedance.awemeopen.apps.framework.profile.works;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.profile.AosUserProfileFragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/UserProfileWorksFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/profile/works/UserProfileWorksFragmentViewModel;", "Lxx3/b$a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileWorksFragment extends AosRecyclerListFragment<jz3.a, UserProfileWorksFragmentViewModel> implements xx3.b.a {
    public static final /* synthetic */ int s = 0;
    public RecentlySeeHelper n;
    public RecentlySeeHelper.a o;
    public Function0<String> p;
    public final l q;
    public final Map<Integer, View> r;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.r).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<UserProfileWorksFragmentViewModel> da0() {
        return UserProfileWorksFragmentViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ga0() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.awemeopen.apps.framework.profile.works.l] */
    public UserProfileWorksFragment() {
        this.r = new LinkedHashMap();
        this.q = new l(this);
    }

    @Override // xx3.b.a
    public final int XI() {
        DmtStatusView r0 = this.h;
        if (r0 == null) goto L7;
        View r1 = r0.getStatusView();
        if (r1 == null) goto L7;
        return r1.getHeight();
    L7:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ia0() {
        RecentlySeeHelper.a r0 = this.o;
        if (r0 == null) goto L5;
        r0.onFail();
    L5:
        this.o = null;
        ((UserProfileWorksFragmentViewModel) W90()).resetPageCount2Default();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ka0() {
        RecentlySeeHelper r0 = this.n;
        if (r0 == null) goto L6;
        r0.m = RecentlySeeHelper.RefreshStatus.FAILED;
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new o04.a(UserProfileWorksFragment.class.getName(), 0));
        this.k = false;
        Fragment r1 = getParentFragment();
        if ((r1 instanceof AosUserProfileFragment) == false) goto L5;
        final AosUserProfileFragment r2 = (AosUserProfileFragment) r1;
    L6:
        if (r2 == null) goto L15;
        this.p = new UserProfileWorksFragment$onBind$1$1(r2);
        RecentlySeeHelper r3 = r2.W90().getRecentlySeeHelper();
        this.n = r3;
        if (r3 == null) goto L11;
        Function2<Integer, RecentlySeeHelper.a, Unit> r4 = new UserProfileWorksFragment$onBind$1$2(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.w = r4;
    L11:
        RecentlySeeHelper r5 = this.n;
        if (r5 == null) goto L14;
        RecyclerView r6 = this.i;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        r5.f = r6;
        GridLayoutManager r7 = r6.getLayoutManager();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        r5.g = r7;
        r6.removeOnScrollListener(r5.z);
        r6.addOnScrollListener(r5.z);
    L14:
        r2.W90().getServerUserInfo().observe(this, new j(this, r2));
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r2.W90().getSelectedIndex().observe(this, new k(r8, this));
    L15:
        LiveDataBus.a.a(gz3.d.class).observeForever(this.q);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        super.Z90();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.d.class).removeObserver(this.q);
    }

    @Override // xx3.b.a
    public final RecyclerView tA() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r7) {
        Bundle r8 = getArguments();
        String r0 = "";
        String r1 = null;
        if (r8 == null) goto L5;
        String r9 = r8.getString("argument_enter_aid", "");
    L6:
        Bundle r2 = getArguments();
        boolean r3 = false;
        if (r2 == null) goto L9;
        boolean r4 = r2.getBoolean("argument_enter_is_live", false);
    L10:
        UserProfileWorksFragmentViewModel r5 = (UserProfileWorksFragmentViewModel) W90();
        Bundle r6 = getArguments();
        if (r6 == null) goto L13;
        r3 = r6.getBoolean("argument_hide_long_press_tab");
    L13:
        r5.setHideLongPressTab(r3);
        Bundle r10 = getArguments();
        if (r10 == null) goto L18;
        String r11 = r10.getString("argument_host_extra_params");
        if (r11 == null) goto L18;
        JSONObject r12 = new JSONObject(r11);
    L19:
        UserProfileWorksFragmentViewModel r13 = (UserProfileWorksFragmentViewModel) W90();
        Bundle r14 = getArguments();
        if (r14 == null) goto L22;
        r1 = r14.getString("argument_host_enter_from");
    L22:
        if (r1 == null) goto L25;
        r0 = r1;
    L25:
        r13.setHostEnterFrom(r0);
        ma0(r9, r4, r12);
        return;
    L18:
        r12 = null;
        goto L19
    L9:
        r4 = false;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final AosRecyclerItemViewHolder ea0(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        View r4 = LayoutInflater.from(getContext()).inflate(2131558689, r11, false);
        UserProfileWorksFragmentViewModel r7 = (UserProfileWorksFragmentViewModel) W90();
        FragmentActivity r8 = getActivity();
        Function0<String> r9 = this.p;
        ((UserProfileWorksFragmentViewModel) W90()).getHostExtraParams();
        return new UserProfileWorkViewHolder(new com.bytedance.awemeopen.apps.framework.profile.works.a(r4, r11, this, r7, r8, r9));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void la0(List r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        RecentlySeeHelper r1 = this.n;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "data");
        r1.m = RecentlySeeHelper.RefreshStatus.SUCCESS;
        r1.j = RecentlySeeHelper.b(r3, r1.i);
        if (r3.isEmpty() == false) goto L9;
        r1.k = false;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final int fa0(int r1, jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ja0(List r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        RecentlySeeHelper r1 = this.n;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "data");
        r1.j = RecentlySeeHelper.b(r3, r1.i);
    L5:
        RecentlySeeHelper.a r0 = this.o;
        if (r0 == null) goto L8;
        r0.onSuccess(r3, r4);
    L8:
        this.o = null;
        ((UserProfileWorksFragmentViewModel) W90()).resetPageCount2Default();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ma0(String r2, boolean r3, JSONObject r4) {
        if (this.d == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        UserProfileWorksFragmentViewModel r1 = (UserProfileWorksFragmentViewModel) W90();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r1.setEnterAid(r2);
        ((UserProfileWorksFragmentViewModel) W90()).setEnterIsLive(r3);
        if (r4 == null) goto L13;
        ((UserProfileWorksFragmentViewModel) W90()).setHostExtraParams(r4);
    L13:
        RecentlySeeHelper r5 = this.n;
        if (r5 == null) goto L18;
        r5.d();
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
