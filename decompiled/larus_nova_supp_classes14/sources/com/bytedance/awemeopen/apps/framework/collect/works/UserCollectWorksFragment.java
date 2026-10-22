package com.bytedance.awemeopen.apps.framework.collect.works;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.collect.AmeCollectDecoration;
import com.bytedance.awemeopen.apps.framework.collect.AosUserCollectFragment;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerItemViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/works/UserCollectWorksFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/collect/works/UserCollectWorksFragmentViewModel;", "Lxx3/b$a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserCollectWorksFragment extends AosRecyclerListFragment<jz3.a, UserCollectWorksFragmentViewModel> implements xx3.b.a {
    public static final /* synthetic */ int r = 0;
    public Function0<String> n;
    public final e o;
    public final b p;
    public final Map<Integer, View> q;

    public static final class a {
    }

    public static final class b implements o24.a {
        public final /* synthetic */ UserCollectWorksFragment a;

        public b(UserCollectWorksFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onChange(String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "aid");
            if (r4 == false) goto L5;
            UserCollectWorksFragment r0 = this.a;
            int r1 = UserCollectWorksFragment.r;
            Pair<Boolean, Boolean> r5 = ((UserCollectWorksFragmentViewModel) r0.W90()).collectItem(r3);
        L7:
            if (((Boolean) r5.getFirst()).booleanValue() == false) goto L14;
            this.a.ha0().notifyDataSetChanged();
            if (r4 == false) goto L14;
            DmtStatusView r6 = this.a.h;
            if (r6 == null) goto L14;
            r6.c();
        L14:
            if (((Boolean) r5.getSecond()).booleanValue() == false) goto L19;
            DmtStatusView r7 = this.a.h;
            if (r7 == null) goto L20;
            r7.setVisibility(0);
            r7.setStatus(1);
            return;
        L20:
            return;
        L19:
            return;
        L5:
            UserCollectWorksFragment r2 = this.a;
            int r8 = UserCollectWorksFragment.r;
            r5 = ((UserCollectWorksFragmentViewModel) r2.W90()).unCollectItem(r3);
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.q).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<UserCollectWorksFragmentViewModel> da0() {
        return UserCollectWorksFragmentViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ga0() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ka0() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void la0(List r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.awemeopen.apps.framework.collect.works.e] */
    public UserCollectWorksFragment() {
        this.q = new LinkedHashMap();
        this.o = new e(this);
        this.p = new b(this);
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
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new o04.a(UserCollectWorksFragment.class.getName(), 0));
        this.k = false;
        Fragment r1 = getParentFragment();
        if ((r1 instanceof AosUserCollectFragment) == false) goto L5;
        final AosUserCollectFragment r2 = (AosUserCollectFragment) r1;
    L6:
        if (r2 == null) goto L8;
        this.n = new UserCollectWorksFragment$onBind$1$1(r2);
        r2.W90().getServerUserInfo().observe(this, new c(this));
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        r2.W90().getSelectedIndex().observe(this, new d(r3));
    L8:
        DmtStatusView.a r4 = DmtStatusView.a.a(getContext());
        View r5 = LayoutInflater.from(getContext()).inflate(2131558691, this.h, false);
        LinearLayout r6 = (LinearLayout) r5.findViewById(2131378675);
        float r7 = 190;
        Resources r8 = Resources.getSystem();
        r6.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()))), 0, 0);
        ((ImageView) r5.findViewById(2131375008)).setImageResource(2131231596);
        ((TextView) r5.findViewById(2131388877)).setText(2131894158);
        ((TextView) r5.findViewById(2131367826)).setText(2131894159);
        r4.b(r5);
        if (this.h == null) goto L11;
        View r9 = LayoutInflater.from(getContext()).inflate(2131558692, this.h, false);
        LinearLayout r10 = (LinearLayout) r9.findViewById(2131378675);
        Resources r11 = Resources.getSystem();
        r10.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()))), 0, 0);
        ((ImageView) r9.findViewById(2131375008)).setImageResource(2131231596);
        ((TextView) r9.findViewById(2131388877)).setText(2131894156);
        ((TextView) r9.findViewById(2131367826)).setText(2131894157);
        r4.d(r9);
    L11:
        DmtStatusView r12 = this.h;
        if (r12 == null) goto L14;
        r12.setBuilder(r4);
    L14:
        DmtStatusView r13 = this.h;
        if (r13 == null) goto L19;
        View r14 = r13.b(0);
        if (r14 == null) goto L19;
        Resources r15 = Resources.getSystem();
        r14.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 65, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()))), 0, 0);
    L19:
        DmtStatusView r16 = this.h;
        if (r16 == null) goto L22;
        r16.c();
    L22:
        this.k = true;
        ((UserCollectWorksFragmentViewModel) W90()).startLoad();
        LiveDataBus.a.a(gz3.b.class).observeForever(this.o);
        d14.a r17 = b14.a.a;
        b14.a.a(o24.b.class).l2(this.p);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        super.Z90();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.b.class).removeObserver(this.o);
        d14.a r1 = b14.a.a;
        b14.a.a(o24.b.class).T(this.p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ia0() {
        ((UserCollectWorksFragmentViewModel) W90()).resetPageCount2Default();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        super.initView();
        RecyclerView r0 = this.i;
        if (r0 == null) goto L5;
        r0.removeItemDecorationAt(0);
    L5:
        RecyclerView r1 = this.i;
        if (r1 == null) goto L9;
        Resources r4 = Resources.getSystem();
        r1.addItemDecoration(new AmeCollectDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())))));
        return;
    }

    @Override // xx3.b.a
    public final RecyclerView tA() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r8) {
        Bundle r9 = getArguments();
        String r0 = null;
        String r1 = "";
        if (r9 == null) goto L5;
        String r10 = r9.getString("argument_enter_aid", "");
    L6:
        Bundle r2 = getArguments();
        boolean r3 = false;
        if (r2 == null) goto L9;
        boolean r4 = r2.getBoolean("argument_enter_is_live", false);
    L10:
        Bundle r5 = getArguments();
        if (r5 == null) goto L13;
        String r6 = r5.getString("userOpenId", "");
    L14:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        UserCollectWorksFragmentViewModel r7 = (UserCollectWorksFragmentViewModel) W90();
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        r3 = r11.getBoolean("argument_hide_long_press_tab");
    L19:
        r7.setHideLongPressTab(r3);
        UserCollectWorksFragmentViewModel r12 = (UserCollectWorksFragmentViewModel) W90();
        Bundle r13 = getArguments();
        if (r13 == null) goto L22;
        r0 = r13.getString("argument_host_enter_from");
    L22:
        if (r0 == null) goto L25;
        r1 = r0;
    L25:
        r12.setHostEnterFrom(r1);
        ma0(r10, r4, r6);
        return;
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final AosRecyclerItemViewHolder ea0(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        return new UserCollectWorkViewHolder(new com.bytedance.awemeopen.apps.framework.collect.works.a(LayoutInflater.from(getContext()).inflate(2131558689, r11, false), r11, this, (UserCollectWorksFragmentViewModel) W90(), getActivity(), this.n));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final int fa0(int r1, jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment
    public final void ja0(List r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        ((UserCollectWorksFragmentViewModel) W90()).resetPageCount2Default();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ma0(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "userOpenId");
        if (this.d == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        UserCollectWorksFragmentViewModel r1 = (UserCollectWorksFragmentViewModel) W90();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r1.setEnterAid(r2);
        ((UserCollectWorksFragmentViewModel) W90()).setEnterIsLive(r3);
        ((UserCollectWorksFragmentViewModel) W90()).setUserOpenId(r4);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
