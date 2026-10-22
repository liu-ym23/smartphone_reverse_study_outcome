package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonOrderFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher;
import com.bytedance.android.live.ktv.common.search.view.CommonSearchContainer;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search.SearchOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/firstleveltab/OrderFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonOrderFirstLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderFirstLevelTabFragment extends CommonOrderFirstLevelTabFragment {
    public static final /* synthetic */ int E = 0;
    public CommonSearchContainer A;
    public final Lazy B;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d C;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a D;
    public long y;
    public DialogLoadingView z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public b(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            td2.a r3 = (td2.a) r2;
            OrderFirstLevelTabFragment r4 = this.a;
            int r0 = OrderFirstLevelTabFragment.E;
            FrameLayout r5 = ((CommonOrderFirstLevelTabFragment) r4).x;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.getVisibility() != 0) goto L9;
            ((SearchOuterCallback) this.a.B.getValue()).onSearchExit();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public c(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            if (r3 == null) goto L13;
            int r4 = ((Number) r3.component1()).intValue();
            this.a.getClass();
            if (r4 != FirstLevelTab.OrderSongTab.getValue()) goto L11;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.a.C;
            if (r5 == null) goto L12;
            r5.updateCurrentTabData();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public d(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            OrderFirstLevelTabFragment r4 = this.a;
            int r0 = OrderFirstLevelTabFragment.E;
            r4.ha0();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public e(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            OrderFirstLevelTabFragment r4 = this.a;
            int r0 = OrderFirstLevelTabFragment.E;
            r4.ha0();
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public f(OrderFirstLevelTabFragment r1) {
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
            OrderFirstLevelTabFragment r7 = this.a;
            int r1 = OrderFirstLevelTabFragment.E;
            KtvTextSwitcher r8 = ((CommonOrderFirstLevelTabFragment) r7).u;
            if (r8 == null) goto L14;
            r8.setItems(r0);
            return;
        L14:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public g(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            OrderFirstLevelTabFragment r0 = this.a;
            int r1 = OrderFirstLevelTabFragment.E;
            if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.OrderSongTab) == false) goto L8;
            DialogLoadingView r2 = this.a.z;
            if (r2 == null) goto L9;
            r2.a(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public h(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            OrderFirstLevelTabFragment r0 = this.a;
            int r1 = OrderFirstLevelTabFragment.E;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseFirstLevelTabFragment) r0).q;
            KSongOrderSongUtilKt.h(r2, (Long) r4, "recommend", FirstLevelTab.OrderSongTab);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public i(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Map r9 = (Map) r8;
            if (r9 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == true) goto L43;
            OrderFirstLevelTabFragment r1 = this.a;
            int r2 = OrderFirstLevelTabFragment.E;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = ((BaseFirstLevelTabFragment) r1).q;
            if (r3 == null) goto L31;
            List r4 = r3.getSecondLevelTabDataList(FirstLevelTab.OrderSongTab.getValue());
            if (r4 == null) goto L42;
            Iterator<T> r5 = r4.iterator();
        L17:
            if (r5.hasNext() == false) goto L44;
            y r6 = (y) r5.next();
            Map r7 = r6.e;
            if (r7 == null) goto L17;
            int r10 = o0.a;
            String r11 = (String) r7.get("activity_id");
            if (r11 == null) goto L17;
            Iterator<T> r12 = this.a.Y90().iterator();
        L24:
            if (r12.hasNext() == false) goto L17;
            com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r13 = (com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r12.next();
            if (Intrinsics.areEqual(r6.c, r13.Ms()) == false) goto L24;
            ArrayList r14 = new ArrayList();
            LabelBannerUrl r15 = (LabelBannerUrl) r9.get(r11);
            if (r15 == null) goto L30;
            r14.add(r15);
        L30:
            Unit r16 = Unit.INSTANCE;
            r13.ok(r6, r13.ms(r14));
            goto L17
        L44:
            return;
        L42:
            return;
        L31:
            return;
        L43:
            return;
        L5:
            if (r9.isEmpty() == true) goto L8;
            r0 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderFirstLevelTabFragment$initData$6, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass6 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(vb0.a.class, "isRequestRecommendApi", "isRequestRecommendApi()Ljava/lang/Boolean;", 0);
        }

        public Object get(Object r1) {
            return ((vb0.a) r1).i;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderFirstLevelTabFragment$initData$8, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass8 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(vb0.a.class, "applyListenUnreadNum", "getApplyListenUnreadNum()Ljava/lang/Long;", 0);
        }

        public Object get(Object r1) {
            return ((vb0.a) r1).b;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ OrderFirstLevelTabFragment a;

        public j(OrderFirstLevelTabFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            OrderFirstLevelTabFragment r12 = this.a;
            if (r12.y > 0) goto L5;
        L7:
            r12.y = System.currentTimeMillis();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) r12).q;
            if (r0 == null) goto L10;
            y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
        L11:
            if (r1 == null) goto L14;
            List r2 = r1.h;
            if (r2 == null) goto L14;
        L16:
            if (r2.isEmpty() == false) goto L18;
            f2.b(2131918492, 0);
            return;
        L18:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = r12.C;
            if (r3 != null) goto L21;
        L48:
            f2.b(2131918497, 0);
            return;
        L21:
            if (r3.canSelectMore() != true) goto L48;
            ArrayList r4 = new ArrayList();
            Iterator r5 = r2.iterator();
        L25:
            if (r5.hasNext() == false) goto L30;
            MusicPanel r6 = (MusicPanel) r5.next();
            if (r6.b != 1) goto L25;
            r4.add(r6);
            goto L25
        L30:
            if (r4.isEmpty() == false) goto L32;
            f2.b(2131918492, 0);
            return;
        L32:
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.l;
            if (((Boolean) r7.getValue()).booleanValue() == false) goto L45;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = r12.C;
            if (r8 == null) goto L45;
            if (r8.isAudienceEnableSing() != true) goto L45;
            Context r9 = r12.getContext();
            x0.d r10 = new x0.d();
            r10.b = r9;
            r10.a = 0;
            r10.a = 7;
            r10.c = s1.B(2131918496);
            r10.d = s1.B(2131918495);
            r10.m = Float.valueOf(2.0f);
            String r13 = s1.B(2131918493);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.g r14 = com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.g.a;
            x0.c[] r15 = r10.g;
            x0.c r16 = r15[1];
            if (r16 != null) goto L41;
            r16 = new x0.c();
            r15[1] = r16;
        L41:
            r16.a = r13;
            r16.b = r14;
            String r17 = s1.B(2131918494);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.h r18 = new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.h(r12, r4, r1);
            x0.c[] r19 = r10.g;
            x0.c r20 = r19[0];
            if (r20 != null) goto L44;
            r20 = new x0.c();
            r19[0] = r20;
        L44:
            r20.a = r17;
            r20.b = r18;
            r10.k = true;
            x0.b.g(new x0(r10.b, r10));
            com.bytedance.android.livesdk.sharedpref.f.d(r7, Boolean.FALSE);
            return;
        L45:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r110 = r12.C;
            if (r110 == null) goto L59;
            r110.orderPlayAllSong(r4, r1);
            return;
        L59:
            return;
        L14:
            r2 = new ArrayList();
            goto L16
        L10:
            r1 = null;
            goto L11
        L5:
            if ((System.currentTimeMillis() - r12.y) >= 3000) goto L7;
            f2.b(2131918498, 0);
        }
    }

    static {
    }

    public OrderFirstLevelTabFragment() {
        this(null, null, null, null);
    }

    public final String aK() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.C;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 == ModeType.MUSIC_EFFECT) goto L9;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == true) goto L19;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L19;
        if (jc0.a.c() == true) goto L19;
        return s1.B(2131918627);
    L19:
        return s1.B(2131918625);
    L9:
        return s1.B(2131916420);
    L5:
        r1 = null;
        goto L7
    }

    public final void ha0() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.C;
        if (r0 == null) goto L6;
        r0.observeSecondLevelTabBanner(this, new i(this));
        return;
    }

    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    public final void initData() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment*/.initData();
        Disposable r0 = xs2.b.a().b(td2.a.class).subscribe(new b(this));
        if (r0 == null) goto L5;
        S90(r0);
    L5:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1 = ((BaseFirstLevelTabFragment) this).q;
        if (r1 == null) goto L9;
        r1.observeSelectedFirstLevelTabValueChange(this, new c(this));
    L9:
        if (((BaseFirstLevelTabFragment) this).f == false) goto L11;
        S90(Observable.timer(((BaseFirstLevelTabFragment) this).e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this)));
    L12:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r2 = this.D;
        if (r2 == null) goto L15;
        r2.observeHotWordListChange(this, new f(this));
    L15:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r3 = this.D;
        if (r3 == null) goto L18;
        r3.syncHotWords();
    L18:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.C;
        if (r4 == null) goto L24;
        MutableLiveData<vb0.a> r5 = r4.getOrderSongUiState();
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r5, this, AnonymousClass6.INSTANCE, new g(this));
    L24:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L32;
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L32;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.C;
        if (r6 == null) goto L32;
        MutableLiveData<vb0.a> r7 = r6.getOrderSongUiState();
        if (r7 == null) goto L32;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r7, this, AnonymousClass8.INSTANCE, new h(this));
    L32:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = this.C;
        if (r8 == null) goto L35;
        r8.observeCurOrderedMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.e(this));
    L35:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = this.C;
        if (r9 == null) goto L38;
        r9.observeCurFavoriteMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.f(this));
    L38:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r10 = ((BaseFirstLevelTabFragment) this).q;
        ModeType r11 = null;
        if (r10 == null) goto L41;
        y r12 = r10.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
    L42:
        ConstraintLayout r13 = ((CommonOrderFirstLevelTabFragment) this).v;
        TextView r14 = ((CommonOrderFirstLevelTabFragment) this).w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r15 = this.C;
        if (r15 == null) goto L45;
        r11 = r15.getModeType();
    L45:
        KSongOrderSongUtilKt.g(r12, r13, r14, r11);
        return;
    L41:
        r12 = null;
        goto L42
    L11:
        ha0();
        goto L12
    }

    public static final void ga0(OrderFirstLevelTabFragment r4) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) r4).q;
        if (r0 == null) goto L8;
        y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
        if (r1 == null) goto L8;
        String r2 = r1.c;
        if (r2 == null) goto L8;
    L9:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r3 = r4.D;
        if (r3 == null) goto L12;
        r3.updateExtraRequestData(new xb0.a(r2, 3));
    L12:
        CommonSearchContainer r5 = r4.A;
        if (r5 == null) goto L15;
        r5.f();
    L15:
        ConstraintLayout r6 = ((CommonOrderFirstLevelTabFragment) r4).s;
        if (r6 == null) goto L18;
        r6.setVisibility(8);
    L18:
        FrameLayout r7 = ((CommonOrderFirstLevelTabFragment) r4).x;
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
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.C;
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r4, r2, r3);
    }

    public final void U50(boolean r9) {
        if (r9 == false) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r10 = this.C;
        String r0 = null;
        if (r10 == null) goto L6;
        ModeType r1 = r10.getModeType();
    L7:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseFirstLevelTabFragment) this).q;
        FirstLevelTab r11 = FirstLevelTab.OrderSongTab;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.C;
        if (r3 == null) goto L10;
        r0 = r3.getRequiredSongInfo();
    L10:
        KSongOrderSongUtilKt.o(r1, r2, r11, r0, false, null, 48);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = ((BaseFirstLevelTabFragment) this).q;
        if (r4 == null) goto L17;
        y r12 = r4.getSelectedSecondLevelTabData(r11.getValue());
        if (r12 == null) goto L18;
        ka0(r12);
        return;
    L18:
        return;
    L17:
        return;
    L6:
        r1 = null;
        goto L7
    L15:
        xs2.b.a().post(new td2.a("leave_order_song_tab"));
    }

    public final void ca0(y r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (ea0(r4) == true) goto L16;
        ConstraintLayout r0 = ((CommonOrderFirstLevelTabFragment) this).v;
        TextView r1 = ((CommonOrderFirstLevelTabFragment) this).w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.C;
        if (r2 == null) goto L9;
        ModeType r3 = r2.getModeType();
    L10:
        KSongOrderSongUtilKt.g(r4, r0, r1, r3);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.C;
        if (r5 == null) goto L13;
        r5.updateCurrentTabData();
    L13:
        ka0(r4);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void da0(y r5) {
        Intrinsics.checkNotNullParameter(r5, "secondLevelTabData");
        if (r5.k == FirstLevelTab.OrderSongTab.getValue()) goto L5;
        return;
    L5:
        y r0 = KSongOrderSongUtilKt.c(((BaseFirstLevelTabFragment) this).q);
        ModeType r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.c;
    L10:
        if (Intrinsics.areEqual(r2, r5.c) == false) goto L16;
        ConstraintLayout r3 = ((CommonOrderFirstLevelTabFragment) this).v;
        TextView r4 = ((CommonOrderFirstLevelTabFragment) this).w;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.C;
        if (r6 == null) goto L14;
        r1 = r6.getModeType();
    L14:
        KSongOrderSongUtilKt.g(r5, r3, r4, r1);
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void ia0(View r5) {
        if (r5 == null) goto L6;
        final Context r6 = r5.getContext();
        if (r6 == null) goto L6;
        CommonSearchContainer r0 = new CommonSearchContainer((SearchOuterCallback) this.B.getValue(), r6, false, 28);
        r0.setGoFeedbackAction(new OrderFirstLevelTabFragment$initSearchContainer$$inlined$let$lambda$1(r6, this));
        UtilityKotlinExtentionsKt.t(r0);
    L7:
        this.A = r0;
        FrameLayout r7 = ((CommonOrderFirstLevelTabFragment) this).x;
        if (r7 == null) goto L10;
        r7.removeAllViews();
    L10:
        View r8 = this.A;
        if (r8 == null) goto L15;
        FrameLayout r1 = ((CommonOrderFirstLevelTabFragment) this).x;
        if (r1 == null) goto L15;
        r1.addView(r8);
    L15:
        FrameLayout r9 = ((CommonOrderFirstLevelTabFragment) this).x;
        if (r9 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r9);
        return;
    L19:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public final void initView(View r7) {
        super.initView(r7);
        ConstraintLayout r0 = ((CommonOrderFirstLevelTabFragment) this).v;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new j(this));
    L5:
        Boolean r3 = null;
        DialogLoadingView r1 = new DialogLoadingView(requireContext(), null, 6, 0);
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(s1.f(100.0f), s1.f(90.0f));
        r2.leftToLeft = 0;
        r2.rightToRight = 0;
        r2.topToBottom = 2131382415;
        r2.bottomToBottom = 0;
        r1.setLayoutParams(r2);
        if ((r7 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r7).addView(r1);
    L9:
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) this).q, FirstLevelTab.OrderSongTab) == false) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.C;
        if (r4 == null) goto L17;
        MutableLiveData<vb0.a> r5 = r4.getOrderSongUiState();
        if (r5 == null) goto L17;
        vb0.a r6 = (vb0.a) r5.getValue();
        if (r6 == null) goto L17;
        r3 = r6.i;
    L17:
        r1.a(Intrinsics.areEqual(r3, Boolean.TRUE));
    L18:
        Unit r8 = Unit.INSTANCE;
        this.z = r1;
        View r9 = ((CommonOrderFirstLevelTabFragment) this).t;
        if (r9 == null) goto L21;
        KtvOrderSongThemeManager.c(r9, KtvOrderSongThemeManager.i);
    L21:
        KtvTextSwitcher r10 = ((CommonOrderFirstLevelTabFragment) this).u;
        if (r10 == null) goto L24;
        r10.setItems(new ArrayList());
    L24:
        KtvTextSwitcher r11 = ((CommonOrderFirstLevelTabFragment) this).u;
        if (r11 == null) goto L27;
        r11.a(KtvOrderSongThemeManager.a(8));
    L27:
        KtvTextSwitcher r12 = ((CommonOrderFirstLevelTabFragment) this).u;
        if (r12 == null) goto L30;
        r12.setTextSwitchClickListener(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.i(this));
    L30:
        ConstraintLayout r13 = ((CommonOrderFirstLevelTabFragment) this).s;
        if (r13 == null) goto L33;
        KtvOrderSongThemeManager.c(r13, KtvOrderSongThemeManager.h);
    L33:
        ia0(r7);
    }

    public final void ja0(y r18) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.C;
        if (r1 == null) goto L7;
        MutableLiveData<vb0.a> r2 = r1.getOrderSongUiState();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r2, OrderFirstLevelTabFragment$reLoadSongList$1.INSTANCE);
    L7:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = ((BaseFirstLevelTabFragment) this).q;
        if (r3 == null) goto L19;
        long r4 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.C;
        if (r5 == null) goto L12;
        ModeType r6 = r5.getModeType();
    L13:
        int r8 = KSongOrderSongUtilKt.f(r6);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r7 = this.C;
        if (r7 == null) goto L16;
        String r14 = r7.getRequiredSongInfo();
    L17:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(r3, r4, true, 0, r8, r18, 0, 0, r14, new OrderFirstLevelTabFragment$reLoadSongList$2(this), 100);
        return;
    L16:
        r14 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    }

    public final void ka0(y r4) {
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == true) goto L5;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.C;
        if (r0 == null) goto L13;
        ModeType r1 = r0.getModeType();
    L15:
        if (r1 != ModeType.MUSIC_EFFECT) goto L18;
        ja0(r4);
    L18:
        if (KtvContext.a.k() == true) goto L20;
        return;
    L20:
        if (jc0.a.a() == true) goto L24;
        ja0(r4);
        return;
    L24:
        return;
    L13:
        r1 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r4.c, "recommend") == false) goto L10;
        KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
        if (r2 == null) goto L9;
        r2.updateListenApplyUnreadCount(0);
    L9:
        ja0(r4);
        goto L10
    }

    public OrderFirstLevelTabFragment(String r1, final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4) {
        super(r1, r2);
        this.C = r3;
        this.D = r4;
        this.B = LazyKt.lazy(new OrderFirstLevelTabFragment$commonSearchOuterCallback$2(this, r2));
    }
}
