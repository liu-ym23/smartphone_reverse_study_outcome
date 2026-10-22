package com.bytedance.awemeopen.apps.framework.profile.likes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.apps.framework.profile.AosUserProfileFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p04.c;
import p04.d;
import xx3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/likes/UserProfileLikesFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/profile/likes/UserProfileLikesFragmentViewModel;", "Lxx3/b$a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileLikesFragment extends AosRecyclerListFragment<jz3.a, UserProfileLikesFragmentViewModel> implements b.a {
    public static final /* synthetic */ int s = 0;
    public View n;
    public View o;
    public AosDefaultNetErrorView p;
    public final c q;
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
    public final Class<UserProfileLikesFragmentViewModel> da0() {
        return UserProfileLikesFragmentViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ga0() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [p04.c] */
    public UserProfileLikesFragment() {
        this.r = new LinkedHashMap();
        this.q = new c(this);
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

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new o04.a(UserProfileLikesFragment.class.getName(), 1));
        this.k = false;
        Fragment r1 = getParentFragment();
        if ((r1 instanceof AosUserProfileFragment) == false) goto L5;
        AosUserProfileFragment r2 = (AosUserProfileFragment) r1;
    L6:
        if (r2 == null) goto L8;
        r2.W90().getServerUserInfo().observe(this, new d(this));
    L8:
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
    public final void ba0(Bundle r3) {
        UserProfileLikesFragmentViewModel r4 = (UserProfileLikesFragmentViewModel) W90();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        boolean r1 = r0.getBoolean("hideLongPressTab");
    L6:
        r4.setHideLongPressTab(r1);
        UserProfileLikesFragmentViewModel r5 = (UserProfileLikesFragmentViewModel) W90();
        Bundle r2 = getArguments();
        if (r2 == null) goto L9;
        String r6 = r2.getString("argument_host_enter_from");
    L10:
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        r5.setHostEnterFrom(r6);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final AosRecyclerItemViewHolder ea0(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new UserProfileLikeVideoViewHolder(new p04.a(LayoutInflater.from(getContext()).inflate(2131558689, r10, false), r10, this, (UserProfileLikesFragmentViewModel) W90(), getActivity()));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final int fa0(int r1, jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 1;
    }

    public final View ma0(int r5, int r6, int r7) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131558691, this.h, false);
        ((ImageView) r0.findViewById(2131375008)).setImageResource(r5);
        ((TextView) r0.findViewById(2131388877)).setText(r6);
        ((TextView) r0.findViewById(2131367826)).setText(r7);
        return r0;
    }
}
