package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.karaokestation.ItemExposureCheckHelper;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonDefaultSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.adapter.KtvLabelBannerViewBinder;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.q;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/MusicListSecondLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonDefaultSecondLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MusicListSecondLevelTabFragment extends CommonDefaultSecondLevelTabFragment {
    public static final /* synthetic */ int x = 0;
    public final List<String> o;
    public final Map<Long, Boolean> p;
    public boolean q;
    public KtvLabelBannerViewBinder r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d w;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MusicListSecondLevelTabFragment a;

        public b(MusicListSecondLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Pair r5 = (Pair) r4;
            if (r5 == null) goto L30;
            int r0 = ((Number) r5.component1()).intValue();
            UpdateTabType r6 = (UpdateTabType) r5.component2();
            if (r6 != UpdateTabType.INDIRECT_CLICK) goto L19;
            MusicListSecondLevelTabFragment r1 = this.a;
            int r2 = MusicListSecondLevelTabFragment.x;
            int r3 = ((BaseSecondLevelTabFragment) r1).k.k;
            if (r0 != r3) goto L19;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = ((BaseSecondLevelTabFragment) r1).l;
            if (r7 == null) goto L14;
            y r8 = r7.getSelectedSecondLevelTabData(r3);
            if (r8 == null) goto L14;
            String r9 = r8.c;
        L16:
            if (Intrinsics.areEqual(r9, ((BaseSecondLevelTabFragment) this.a).k.c) == false) goto L19;
            MusicListSecondLevelTabFragment r10 = this.a;
            r10.rs(SecondLevelTabViewSelectedType.CLICK, ((BaseSecondLevelTabFragment) r10).k);
            return;
        L14:
            r9 = null;
        L19:
            if (r6 != UpdateTabType.DIRECT_CLICK) goto L27;
            MusicListSecondLevelTabFragment r11 = this.a;
            int r12 = MusicListSecondLevelTabFragment.x;
            y r13 = ((BaseSecondLevelTabFragment) r11).k;
            if (r0 == r13.k) goto L23;
            return;
        L23:
            if (Intrinsics.areEqual(r13.c, "want_listen") == false) goto L29;
            MusicListSecondLevelTabFragment r14 = this.a;
            r14.rs(SecondLevelTabViewSelectedType.CLICK, ((BaseSecondLevelTabFragment) r14).k);
            return;
        L29:
            return;
        L27:
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ MusicListSecondLevelTabFragment a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            MusicListSecondLevelTabFragment r0 = this.a;
            int r1 = MusicListSecondLevelTabFragment.x;
            CommonSongListView r2 = ((BaseSecondLevelTabFragment) r0).g;
            if (r2 == null) goto L7;
            ViewTreeObserver r3 = r2.getViewTreeObserver();
            if (r3 == null) goto L7;
            r3.removeOnGlobalLayoutListener(this);
        L7:
            q.c();
        }

        public c(MusicListSecondLevelTabFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public MusicListSecondLevelTabFragment() {
        this(new y(0, 0, 65535), null, null);
    }

    public final void O0() {
        ((LinkedHashMap) this.p).clear();
    }

    public final me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> T90() {
        String r0 = ((BaseSecondLevelTabFragment) this).k.c;
        int r1 = r0.hashCode();
        if (r1 == (-313784618)) goto L11;
        if (r1 != 3541915) goto L14;
        if (r0.equals("sung") == false) goto L14;
        return new n(new j(((BaseSecondLevelTabFragment) this).l, this.w));
    L14:
        return new k(new j(((BaseSecondLevelTabFragment) this).l, this.w));
    L11:
        if (r0.equals("want_listen") == false) goto L14;
        return new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.f(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.j(((BaseSecondLevelTabFragment) this).l, this.w));
    }

    public final Function1<MultiTypeAdapter, Unit> U90() {
        return new MusicListSecondLevelTabFragment$getCustomItemViewBinderAction$1(this);
    }

    public final Function1<t, Unit> V90() {
        return new MusicListSecondLevelTabFragment$getHandleLoadMoreAction$1(this);
    }

    public final void W90() {
        if (Intrinsics.areEqual(((BaseSecondLevelTabFragment) this).k.c, "recommend") == true) goto L5;
        return;
    L5:
        if (q.a() == true) goto L25;
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r0 = q.b();
        if (r0 != null) goto L9;
    L11:
        CommonSongListView r1 = ((BaseSecondLevelTabFragment) this).g;
        if (r1 == null) goto L18;
        RecyclerView.Adapter r2 = r1.getAdapter();
        if (r2 == null) goto L18;
        if (r2.getItemCount() != 0) goto L18;
        q.c();
        return;
    L18:
        CommonSongListView r3 = ((BaseSecondLevelTabFragment) this).g;
        if (r3 == null) goto L27;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L28;
        r4.addOnGlobalLayoutListener(new c(this));
        return;
    L28:
        return;
    L27:
        return;
    L9:
        if (r0.b == true) goto L11;
        r0.d = System.currentTimeMillis();
        goto L11
    }

    public final void onDestroy() {
        KtvLabelBannerViewBinder r0 = this.r;
        if (r0 == null) goto L7;
        KtvLabelBannerViewBinder.VH r1 = r0.b;
        if (r1 == null) goto L7;
        r1.release();
    L7:
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment*/.onDestroy();
    }

    public final void initData() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment*/.initData();
        ((ItemExposureCheckHelper) this.t.getValue()).b(((BaseSecondLevelTabFragment) this).g, (g) this.v.getValue());
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseSecondLevelTabFragment) this).l;
        if (r0 == null) goto L6;
        r0.observeSelectedFirstLevelTabValueChange(this, new b(this));
        return;
    }

    public final Function3<List<MusicPanel>, List<Object>, y, Unit> ms(final List<? extends Object> r2) {
        return new MusicListSecondLevelTabFragment$getFillAdapterDataAction$1(this, r2);
    }

    public static final void X90(MusicListSecondLevelTabFragment r1, t r2) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = r1.w;
        if (r3 == null) goto L7;
        MutableLiveData<vb0.a> r4 = r3.getOrderSongUiState();
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r4, MusicListSecondLevelTabFragment$resetLoadState$1.INSTANCE);
    L7:
        r2.a = false;
    }

    public final void ok(y r7, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r8, "fillAdapterDataAction");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseSecondLevelTabFragment) this).l;
        if (r0 == null) goto L9;
        Pair r1 = r0.getSelectedFirstLevelTabValue();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getFirst();
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = ((BaseSecondLevelTabFragment) this).l;
        if (r4 == null) goto L16;
        y r5 = r4.getSelectedSecondLevelTabData(r3);
        if (r5 == null) goto L16;
        String r6 = r5.c;
        if (r6 == null) goto L16;
    L18:
        if (r3 != r7.k) goto L20;
        boolean r9 = true;
    L21:
        boolean r10 = Intrinsics.areEqual(r6, r7.c);
        if (this.q == true) goto L24;
    L40:
        if (r9 == false) goto L49;
        if (r10 == false) goto L49;
        if (this.q == false) goto L49;
        this.q = false;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = this.w;
        if (r11 == null) goto L49;
        MutableLiveData<vb0.a> r12 = r11.getOrderSongUiState();
        if (r12 == null) goto L49;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r12, MusicListSecondLevelTabFragment$setDataAndNotify$2.INSTANCE);
    L49:
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment*/.ok(r7, r8);
        return;
    L24:
        if (r7.h.isEmpty() == false) goto L40;
        if ((!Intrinsics.areEqual(r7.c, "sung")) == false) goto L40;
        if (r9 == false) goto L51;
        if (r10 == false) goto L52;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r13 = this.w;
        if (r13 == null) goto L34;
        MutableLiveData<vb0.a> r14 = r13.getOrderSongUiState();
        if (r14 == null) goto L34;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r14, MusicListSecondLevelTabFragment$setDataAndNotify$1.INSTANCE);
    L34:
        View r15 = getView();
        if (r15 == null) goto L53;
        final Function0 r16 = (Function0) this.u.getValue();
        if (r16 == null) goto L39;
        r16 = new d(r16);
    L39:
        r15.postDelayed((Runnable) r16, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L20:
        r9 = false;
    L16:
        r6 = "";
    L9:
        r3 = FirstLevelTab.Unknown.getValue();
        goto L10
    }

    public final void rs(SecondLevelTabViewSelectedType r21, y r22) {
        Intrinsics.checkNotNullParameter(r21, "secondLevelTabViewSelectedType");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1 = ((BaseSecondLevelTabFragment) this).l;
        ModeType r16 = null;
        if (r1 == null) goto L7;
        Pair r2 = r1.getSelectedFirstLevelTabValue();
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getFirst();
    L8:
        if (r22 == null) goto L10;
        Integer r4 = Integer.valueOf(r22.k);
    L11:
        boolean r17 = Intrinsics.areEqual(r3, r4);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = ((BaseSecondLevelTabFragment) this).l;
        if (r5 == null) goto L19;
        if (r22 == null) goto L15;
        int r6 = r22.k;
    L16:
        y r7 = r5.getSelectedSecondLevelTabData(r6);
        if (r7 == null) goto L19;
        String r8 = r7.c;
    L20:
        if (r22 == null) goto L22;
        String r9 = r22.c;
    L23:
        boolean r18 = Intrinsics.areEqual(r8, r9);
        if (r17 == false) goto L63;
        if (r18 == false) goto L63;
        if (r22 == null) goto L63;
        ALogger.i("MusicListSecondLevelTabFragment", "onSecondLevelTabSelectStateChange ;; " + r22.d);
        t61 r10 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r10 != null) goto L30;
    L47:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = this.w;
        if (r11 == null) goto L51;
        String r12 = r11.getCurSortType();
        if (r12 == null) goto L51;
    L52:
        int r13 = r22.k;
        String r14 = r22.d;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r15 = this.w;
        if (r15 == null) goto L58;
        td2.b r19 = r15.getOrderSongExtraInfo();
        if (r19 == null) goto L58;
        String r20 = r19.a;
        if (r20 == null) goto L58;
    L59:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r23 = this.w;
        if (r23 == null) goto L62;
        r16 = r23.getModeType();
    L62:
        KSongOrderSongUtilKt.m(r12, r13, r14, r20, r16);
    L58:
        r20 = "";
    L51:
        r12 = " ";
        goto L52
    L30:
        if (u61.b(r10) != true) goto L47;
        if (r22.h.isEmpty() == false) goto L47;
        if (this.o.contains(r22.c) == true) goto L47;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r24 = this.w;
        if (r24 == null) goto L40;
        MutableLiveData<vb0.a> r25 = r24.getOrderSongUiState();
        if (r25 == null) goto L40;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r25, MusicListSecondLevelTabFragment$onSecondLevelTabSelectStateChange$1.INSTANCE);
    L40:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r26 = ((BaseSecondLevelTabFragment) this).l;
        if (r26 == null) goto L47;
        long r27 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r28 = this.w;
        if (r28 == null) goto L45;
        ModeType r29 = r28.getModeType();
    L46:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(r26, r27, true, 0, KSongOrderSongUtilKt.f(r29), r22, 0, 0, null, new MusicListSecondLevelTabFragment$onSecondLevelTabSelectStateChange$2(this), 228);
        goto L47
    L45:
        r29 = null;
    L63:
        if (r17 == false) goto L67;
        if (r18 == false) goto L68;
        ((ItemExposureCheckHelper) this.t.getValue()).a(false);
        return;
    L68:
        return;
    L67:
        return;
    L22:
        r9 = null;
        goto L23
    L15:
        r6 = 0;
    L19:
        r8 = null;
        goto L20
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    public MusicListSecondLevelTabFragment(final y r2, final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        super(r2, r3);
        this.w = r4;
        this.o = CollectionsKt.listOf(new String[]{"sung", "want_listen"});
        this.p = new LinkedHashMap();
        this.q = true;
        this.s = LazyKt.lazy(MusicListSecondLevelTabFragment$room$2.INSTANCE);
        this.t = LazyKt.lazy(MusicListSecondLevelTabFragment$itemExposureCheckHelper$2.INSTANCE);
        this.u = LazyKt.lazy(new MusicListSecondLevelTabFragment$delayRunnable$2(this));
        this.v = LazyKt.lazy(new MusicListSecondLevelTabFragment$itemExposureListener$2(this, r2, r3));
    }
}
