package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetFragment;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListDialogFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetFragment;", "Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListDialogViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListDialogFragment extends AosBottomSheetFragment<MixAwemeListDialogViewModel> {
    public static final /* synthetic */ int y = 0;
    public final b34.a i;
    public String j;
    public boolean k;
    public final Handler l;
    public final MixAwemeListAdapter m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Map<Integer, View> x;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.domain.mix.b {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ MixAwemeListDialogFragment b;

        public final void b() {
        }

        public final void a() {
            if (this.b.getContext() != null) goto L5;
            return;
        L5:
            zx3.a.b(this.b.getContext(), 2131894241).d();
        }

        public final void onSuccess() {
            String r1 = "";
            if (this.a == false) goto L24;
            r14.c r0 = this.b.m.y2();
            d14.a r3 = b14.a.a;
            t24.a r4 = b14.a.a(t24.a.class);
            if (r0 == null) goto L9;
            User r5 = r0.f();
            if (r5 == null) goto L9;
            String r6 = r5.u();
        L10:
            if (r6 != null) goto L12;
            r6 = "";
        L12:
            if (r0 == null) goto L14;
            String r7 = r0.c();
        L15:
            if (r7 != null) goto L17;
            r7 = "";
        L17:
            if (r0 == null) goto L19;
            String r2 = r0.r().c;
        L20:
            if (r2 == null) goto L23;
            r1 = r2;
        L23:
            r4.P(r6, r7, r1, this.b.j);
            this.b.l.removeCallbacksAndMessages(null);
            x54.b.d((View) this.b.v.getValue());
            final MixAwemeListDialogFragment r8 = this.b;
            r8.l.postDelayed(new w(r8), 3000);
        L44:
            MixAwemeListDialogFragment r9 = this.b;
            int r10 = MixAwemeListDialogFragment.y;
            r9.ha0();
            return;
        L19:
            r2 = null;
            goto L20
        L14:
            r7 = null;
        L9:
            r6 = null;
            goto L10
        L24:
            r14.c r11 = this.b.m.y2();
            d14.a r12 = b14.a.a;
            t24.a r13 = b14.a.a(t24.a.class);
            if (r11 == null) goto L29;
            User r14 = r11.f();
            if (r14 == null) goto L29;
            String r15 = r14.u();
        L30:
            if (r15 != null) goto L32;
            r15 = "";
        L32:
            if (r11 == null) goto L34;
            String r16 = r11.c();
        L35:
            if (r16 != null) goto L37;
            r16 = "";
        L37:
            if (r11 == null) goto L39;
            String r17 = r11.r().c;
        L40:
            if (r17 == null) goto L43;
            r1 = r17;
        L43:
            r13.O1(r15, r16, r1, this.b.j);
            x54.b.a((View) this.b.v.getValue());
            this.b.l.removeCallbacksAndMessages(null);
            zx3.a.b(this.b.getContext(), 2131894150).d();
            goto L44
        L39:
            r17 = null;
            goto L40
        L34:
            r16 = null;
        L29:
            r15 = null;
            goto L30
        }

        public final void onFail(Exception r2) {
            if (this.b.getContext() != null) goto L6;
            return;
        L6:
            if (this.a == false) goto L8;
            zx3.a.b(this.b.getContext(), 2131894151).d();
            return;
        L8:
            zx3.a.b(this.b.getContext(), 2131894147).d();
        }

        public b(boolean r1, MixAwemeListDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.x).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558676;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<MixAwemeListDialogViewModel> da0() {
        return MixAwemeListDialogViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public MixAwemeListDialogFragment() {
        this.x = new LinkedHashMap();
        d14.a r0 = b14.a.a;
        this.i = b14.a.a(b34.a.class);
        this.j = "";
        this.l = new Handler(Looper.getMainLooper());
        this.m = new MixAwemeListAdapter();
        this.n = LazyKt.lazy(new MixAwemeListDialogFragment$recyclerView$2(this));
        this.o = LazyKt.lazy(new MixAwemeListDialogFragment$collectBar$2(this));
        this.p = LazyKt.lazy(new MixAwemeListDialogFragment$mixName$2(this));
        this.q = LazyKt.lazy(new MixAwemeListDialogFragment$mixNameCenterPoint$2(this));
        this.r = LazyKt.lazy(new MixAwemeListDialogFragment$mixUpdatedEpisode$2(this));
        this.s = LazyKt.lazy(new MixAwemeListDialogFragment$loadingView$2(this));
        this.t = LazyKt.lazy(new MixAwemeListDialogFragment$mixListCollectIcon$2(this));
        this.u = LazyKt.lazy(new MixAwemeListDialogFragment$mixListCollectText$2(this));
        this.v = LazyKt.lazy(new MixAwemeListDialogFragment$collectRemind$2(this));
        this.w = LazyKt.lazy(new MixAwemeListDialogFragment$closeBtn$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final AosViewModel T90() {
        FragmentActivity r1 = requireActivity();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModelProviderFactory r2 = ViewModelProviderFactory.a;
        r2.getClass();
        return (MixAwemeListDialogViewModel) new ViewModelProvider(r1, r2).get(MixAwemeListDialogViewModel.class);
    }

    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.n.getValue();
    }

    public final void ha0() {
        if (this.i.v2(this.j, this.k) == false) goto L5;
        ((ImageView) this.t.getValue()).setImageResource(2131231489);
        ((TextView) this.u.getValue()).setText(2131894229);
        ((TextView) this.u.getValue()).setTextColor(getResources().getColor(2131100292));
    L6:
        x54.b.d((ImageView) this.t.getValue());
        x54.b.d((TextView) this.u.getValue());
        return;
    L5:
        ((ImageView) this.t.getValue()).setImageResource(2131231491);
        ((TextView) this.u.getValue()).setText(2131894230);
        ((TextView) this.u.getValue()).setTextColor(getResources().getColor(2131100294));
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        final LinearLayoutManager r0 = new LinearLayoutManager(getContext());
        getRecyclerView().setLayoutManager(r0);
        getRecyclerView().setAdapter(this.m);
        getRecyclerView().addOnScrollListener(new AnonymousClass1(this, r0));
        ((View) this.o.getValue()).setOnClickListener(new n(this));
        ((View) this.v.getValue()).setOnClickListener(new o(this));
        ((View) this.w.getValue()).setOnClickListener(new p(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetFragment
    public final void onShow() {
        Iterator<T> r0 = this.m.c.iterator();
        int r1 = 0;
    L3:
        LinearLayoutManager r3 = null;
        if (r0.hasNext() == false) goto L12;
        Object r2 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((MixAwemeListAdapter.c) r2).b == true) goto L10;
        r1 = r4;
        goto L3
    L10:
        Integer r5 = Integer.valueOf(r1);
    L13:
        if (r5 == null) goto L22;
        int r6 = r5.intValue();
        getRecyclerView().stopScroll();
        RecyclerView.LayoutManager r7 = getRecyclerView().getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L17;
        r3 = (LinearLayoutManager) r7;
    L17:
        if (r3 == null) goto L23;
        r3.scrollToPosition(r6);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r5 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        ((MixAwemeListDialogViewModel) W90()).getMixInfoLiveData().observe(this, new q(this));
        ((MixAwemeListDialogViewModel) W90()).getDataList().observe(this, new r(this));
        ((MixAwemeListDialogViewModel) W90()).getSelectedIndex().observe(this, new s(this));
        ((MixAwemeListDialogViewModel) W90()).getLoading().observe(this, new t(this));
        MixAwemeListAdapter r0 = this.m;
        r0.d = new MixAwemeListDialogFragment$onBind$5(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<MixAwemeListAdapter.c> ga0() {
        ListState r0 = (ListState) ((MixAwemeListDialogViewModel) W90()).getDataList().getValue();
        if (r0 == null) goto L20;
        List r1 = (List) r0.a;
        if (r1 == null) goto L20;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L8:
        if (r4.hasNext() == false) goto L25;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r14.c r8 = ((jz3.a) r6).a;
        Integer r9 = (Integer) ((MixAwemeListDialogViewModel) W90()).getSelectedIndex().getValue();
        if (r9 != null) goto L16;
    L18:
        boolean r10 = false;
    L19:
        r3.add(new MixAwemeListAdapter.c(r8, r10, false, false));
        r5 = r7;
        goto L8
    L16:
        if (r5 != r9.intValue()) goto L18;
        r10 = true;
        goto L19
    L25:
        return r3;
    L20:
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetFragment, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.z
    public final int getBottomSheetHeight() {
        return (int) (((d0.c(getContext()) * 1.0f) / 4) * 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MixAwemeListDialogViewModel fa0(MixAwemeListDialogFragment r0) {
        return (MixAwemeListDialogViewModel) r0.W90();
    }
}
