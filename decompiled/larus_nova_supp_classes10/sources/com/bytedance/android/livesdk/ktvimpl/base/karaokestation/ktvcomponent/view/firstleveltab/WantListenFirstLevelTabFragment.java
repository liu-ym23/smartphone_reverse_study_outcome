package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher;
import com.bytedance.android.live.ktv.common.search.view.CommonSearchContainer;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.WantListenSearchOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/firstleveltab/WantListenFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WantListenFirstLevelTabFragment extends BaseFirstLevelTabFragment {
    public static final /* synthetic */ int C = 0;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d A;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a B;
    public ConstraintLayout s;
    public View t;
    public KtvTextSwitcher u;
    public FrameLayout v;
    public FrameLayout w;
    public DialogLoadingView x;
    public CommonSearchContainer y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WantListenFirstLevelTabFragment a;

        public b(WantListenFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            td2.a r2 = (td2.a) r1;
            FrameLayout r3 = this.a.w;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getVisibility() != 0) goto L9;
            ((WantListenSearchOuterCallback) this.a.z.getValue()).onSearchExit();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ WantListenFirstLevelTabFragment a;

        public c(WantListenFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            if (r4 == null) goto L13;
            List r5 = r4;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            r0.add(((u) r6.next()).a());
            goto L6
        L8:
            KtvTextSwitcher r7 = this.a.u;
            if (r7 == null) goto L14;
            r7.setItems(r0);
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ WantListenFirstLevelTabFragment a;

        public d(WantListenFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            WantListenFirstLevelTabFragment r0 = this.a;
            int r1 = WantListenFirstLevelTabFragment.C;
            if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.WantListenTab) == false) goto L8;
            DialogLoadingView r2 = this.a.x;
            if (r2 == null) goto L9;
            r2.a(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ WantListenFirstLevelTabFragment a;

        public e(WantListenFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            MusicPanel r6 = (MusicPanel) r5;
            WantListenFirstLevelTabFragment r0 = this.a;
            int r1 = WantListenFirstLevelTabFragment.C;
            if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.WantListenTab) == false) goto L6;
            WantListenFirstLevelTabFragment r2 = this.a;
            KSongOrderSongUtilKt.k(r6, ((BaseFirstLevelTabFragment) r2).o, ((BaseFirstLevelTabFragment) r2).m, r2.getView(), this.a.getContext());
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.WantListenFirstLevelTabFragment$initData$3, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass3 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(vb0.a.class, "isRequestRecommendApi", "isRequestRecommendApi()Ljava/lang/Boolean;", 0);
        }

        public Object get(Object r1) {
            return ((vb0.a) r1).i;
        }
    }

    static {
    }

    public WantListenFirstLevelTabFragment() {
        this(null, null, null, null);
    }

    public final int getLayoutId() {
        return 2131566548;
    }

    public final void V90() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        if (r0 == null) goto L5;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r1 = r0.getFirstLevelTabDataByTopValue(FirstLevelTab.WantListenTab.getValue());
    L6:
        if (r1 != null) goto L11;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r2 = new com.bytedance.android.live.ktv.common.karaokestation.model.d(0, 15);
        FirstLevelTab r3 = FirstLevelTab.WantListenTab;
        r2.d = r3.getValue();
        Map r4 = r2.a;
        y r5 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("want_listen", "<set-?>");
        r5.c = "want_listen";
        r5.k = r3.getValue();
        Intrinsics.checkNotNullParameter("听歌", "<set-?>");
        r5.d = "听歌";
        r5.n = 0;
        r5.j = true;
        Unit r6 = Unit.INSTANCE;
        r4.put("want_listen", r5);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = ((BaseFirstLevelTabFragment) this).q;
        if (r7 == null) goto L12;
        r7.updateTabListData(r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final String aK() {
        return s1.B(2131918628);
    }

    public final void initData() {
        super.initData();
        Disposable r0 = xs2.b.a().b(td2.a.class).subscribe(new b(this));
        if (r0 == null) goto L5;
        S90(r0);
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.A;
        if (r1 == null) goto L8;
        r1.syncWantListenSongList(false, null);
    L8:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r2 = this.B;
        if (r2 == null) goto L11;
        r2.observeHotWordListChange(this, new c(this));
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.A;
        if (r3 == null) goto L16;
        MutableLiveData<vb0.a> r4 = r3.getOrderSongUiState();
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r4, this, AnonymousClass3.INSTANCE, new d(this));
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.A;
        if (r5 == null) goto L20;
        r5.observeCurFavoriteMusic(this, new e(this));
    L20:
        if (isAdded() == false) goto L42;
        Iterator r6 = Y90().iterator();
    L23:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r7).Ms(), "want_listen") == false) goto L23;
    L28:
        com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r8 = (com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r7;
        if ((r8 instanceof Fragment) == true) goto L31;
        r8 = null;
    L31:
        Fragment r9 = (Fragment) r8;
        if (r9 == null) goto L43;
        FragmentTransaction r10 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131368414) == true) goto L37;
        r10 = r10.add(2131368414, r9);
    L37:
        r10.commitAllowingStateLoss();
        return;
    L43:
        return;
    L27:
        r7 = null;
        goto L28
    }

    public final FirstLevelTab VL() {
        return FirstLevelTab.WantListenTab;
    }

    public static final void ga0(WantListenFirstLevelTabFragment r4) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) r4).q;
        if (r0 == null) goto L8;
        y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.WantListenTab.getValue());
        if (r1 == null) goto L8;
        String r2 = r1.c;
        if (r2 == null) goto L8;
    L9:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r3 = r4.B;
        if (r3 == null) goto L12;
        r3.updateExtraRequestData(new xb0.a(r2, 3));
    L12:
        CommonSearchContainer r5 = r4.y;
        if (r5 == null) goto L15;
        r5.f();
    L15:
        ConstraintLayout r6 = r4.s;
        if (r6 == null) goto L18;
        r6.setVisibility(8);
    L18:
        FrameLayout r7 = r4.w;
        if (r7 == null) goto L22;
        r7.setVisibility(0);
        return;
    L22:
        return;
    L8:
        r2 = "";
        goto L9
    }

    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r4) {
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        int r1 = MusicListSecondLevelTabFragment.x;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseFirstLevelTabFragment) this).q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.A;
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r4, r2, r3);
    }

    public final void U50(boolean r3) {
        if (r3 == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.A;
        if (r4 == null) goto L8;
        r4.syncWantListenSongList(false, null);
        return;
    L8:
        return;
    L6:
        xs2.b.a().post(new td2.a("leave_listen_song_tab"));
    }

    public final void ca0(y r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (ea0(r3) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r3.c, "want_listen") == false) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.A;
        if (r4 == null) goto L13;
        MutableLiveData<vb0.a> r5 = r4.getOrderSongUiState();
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r5, WantListenFirstLevelTabFragment$fetchWantListenSongList$1.INSTANCE);
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.A;
        if (r6 == null) goto L19;
        r6.syncWantListenSongList(false, new WantListenFirstLevelTabFragment$fetchWantListenSongList$2(this));
        return;
    L19:
        return;
    }

    public final void ha0(View r5) {
        if (r5 == null) goto L6;
        final Context r6 = r5.getContext();
        if (r6 == null) goto L6;
        CommonSearchContainer r0 = new CommonSearchContainer((WantListenSearchOuterCallback) this.z.getValue(), r6, false, 28);
        r0.setGoFeedbackAction(new WantListenFirstLevelTabFragment$initSearchContainer$$inlined$let$lambda$1(r6, this));
        UtilityKotlinExtentionsKt.t(r0);
    L7:
        this.y = r0;
        FrameLayout r7 = this.w;
        if (r7 == null) goto L10;
        r7.removeAllViews();
    L10:
        View r8 = this.y;
        if (r8 == null) goto L15;
        FrameLayout r1 = this.w;
        if (r1 == null) goto L15;
        r1.addView(r8);
    L15:
        FrameLayout r9 = this.w;
        if (r9 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r9);
        return;
    L19:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public final void initView(View r8) {
        super.initView(r8);
        Boolean r1 = null;
        if (r8 == null) goto L5;
        ConstraintLayout r2 = (ConstraintLayout) r8.findViewById(2131377062);
    L6:
        this.s = r2;
        if (r8 == null) goto L9;
        View r3 = r8.findViewById(2131377063);
    L10:
        this.t = r3;
        if (r8 == null) goto L13;
        KtvTextSwitcher r4 = (KtvTextSwitcher) r8.findViewById(2131388509);
    L14:
        this.u = r4;
        if (r8 == null) goto L17;
        FrameLayout r5 = (FrameLayout) r8.findViewById(2131368414);
    L18:
        this.v = r5;
        if (r8 == null) goto L21;
        FrameLayout r6 = (FrameLayout) r8.findViewById(2131385643);
    L22:
        this.w = r6;
        DialogLoadingView r7 = new DialogLoadingView(requireContext(), null, 6, 0);
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(s1.f(100.0f), s1.f(90.0f));
        r9.leftToLeft = 0;
        r9.rightToRight = 0;
        r9.topToBottom = 2131377062;
        r9.bottomToBottom = 0;
        r7.setLayoutParams(r9);
        if ((r8 instanceof ViewGroup) == false) goto L26;
        ((ViewGroup) r8).addView(r7);
    L26:
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) this).q, FirstLevelTab.WantListenTab) == false) goto L35;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.A;
        if (r0 == null) goto L34;
        MutableLiveData<vb0.a> r10 = r0.getOrderSongUiState();
        if (r10 == null) goto L34;
        vb0.a r11 = (vb0.a) r10.getValue();
        if (r11 == null) goto L34;
        r1 = r11.i;
    L34:
        r7.a(Intrinsics.areEqual(r1, Boolean.TRUE));
    L35:
        Unit r12 = Unit.INSTANCE;
        this.x = r7;
        View r13 = this.t;
        if (r13 == null) goto L38;
        KtvOrderSongThemeManager.c(r13, KtvOrderSongThemeManager.i);
    L38:
        KtvTextSwitcher r14 = this.u;
        if (r14 == null) goto L41;
        r14.setItems(new ArrayList());
    L41:
        KtvTextSwitcher r15 = this.u;
        if (r15 == null) goto L44;
        r15.a(KtvOrderSongThemeManager.a(8));
    L44:
        KtvTextSwitcher r16 = this.u;
        if (r16 == null) goto L47;
        r16.setTextSwitchClickListener(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.c(this));
    L47:
        ConstraintLayout r17 = this.s;
        if (r17 == null) goto L50;
        KtvOrderSongThemeManager.c(r17, KtvOrderSongThemeManager.h);
    L50:
        ha0(r8);
        return;
    L21:
        r6 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public WantListenFirstLevelTabFragment(String r1, final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4) {
        super(r1, r2);
        this.A = r3;
        this.B = r4;
        this.z = LazyKt.lazy(new WantListenFirstLevelTabFragment$commonSearchOuterCallback$2(this, r2));
    }
}
