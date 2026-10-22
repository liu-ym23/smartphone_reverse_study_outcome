package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonOrderedFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CustomSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.BusinessListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/firstleveltab/OrderedFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonOrderedFirstLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderedFirstLevelTabFragment extends CommonOrderedFirstLevelTabFragment {
    public static final /* synthetic */ int u = 0;
    public com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d s;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d t;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OrderedFirstLevelTabFragment a;

        public b(OrderedFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 == null) goto L6;
            r4.intValue();
            OrderedFirstLevelTabFragment r0 = this.a;
            int r5 = r4.intValue();
            int r1 = OrderedFirstLevelTabFragment.u;
            r0.ia0(r5);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ OrderedFirstLevelTabFragment a;

        public c(OrderedFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Long r3 = (Long) r2;
            OrderedFirstLevelTabFragment r4 = this.a;
            int r0 = OrderedFirstLevelTabFragment.u;
            r4.ga0();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ OrderedFirstLevelTabFragment a;

        public d(OrderedFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            if (ChorusContext.Companion.c() == true) goto L13;
            OrderedFirstLevelTabFragment r4 = this.a;
            OrderedSongDataContext r0 = r4.t.getOrderedSongDataContext();
            if (r0 == null) goto L10;
            List<SongUniqueInfo> r1 = r0.getKtvPublicSongUniqueInfoList();
            if (r1 == null) goto L10;
            int r5 = r1.size();
        L11:
            r4.ha0(r5);
            return;
        L10:
            r5 = 0;
            goto L11
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ OrderedFirstLevelTabFragment a;

        public e(OrderedFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            if (ChorusContext.Companion.c() == false) goto L11;
            List r5 = (List) sh6.c.b(r4);
            if (r5 == null) goto L8;
            int r6 = r5.size();
        L9:
            OrderedFirstLevelTabFragment r0 = this.a;
            int r1 = OrderedFirstLevelTabFragment.u;
            r0.ha0(r6);
            return;
        L8:
            r6 = 0;
            goto L9
        }
    }

    static {
    }

    public OrderedFirstLevelTabFragment() {
        this(null, null, null);
    }

    public final void V90() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        if (r0 == null) goto L5;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r1 = r0.getFirstLevelTabDataByTopValue(FirstLevelTab.OrderedSongTab.getValue());
    L6:
        if (r1 != null) goto L23;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r2 = new com.bytedance.android.live.ktv.common.karaokestation.model.d(0, 15);
        FirstLevelTab r3 = FirstLevelTab.OrderedSongTab;
        r2.d = r3.getValue();
        Map r4 = r2.a;
        y r5 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("play_list", "<set-?>");
        r5.c = "play_list";
        r5.k = r3.getValue();
        Intrinsics.checkNotNullParameter("播放列表", "<set-?>");
        r5.d = "播放列表";
        r5.n = 0;
        r5.j = true;
        Unit r9 = Unit.INSTANCE;
        r4.put("play_list", r5);
        if (KtvUtilsKt.v() == true) goto L11;
        y r6 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("sung", "<set-?>");
        r6.c = "sung";
        r6.k = r3.getValue();
        Intrinsics.checkNotNullParameter("已唱", "<set-?>");
        r6.d = "已唱";
        r6.n = 1;
        r4.put("sung", r6);
    L11:
        if (KtvUtilsKt.v() == true) goto L19;
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L19;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L19;
        if (jc0.a.c() == true) goto L19;
        y r7 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("mine_want_sing", "<set-?>");
        r7.c = "mine_want_sing";
        r7.k = r3.getValue();
        Intrinsics.checkNotNullParameter("我的想唱", "<set-?>");
        r7.d = "我的想唱";
        r7.n = 2;
        r4.put("mine_want_sing", r7);
    L19:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r8 = ((BaseFirstLevelTabFragment) this).q;
        if (r8 == null) goto L24;
        r8.updateTabListData(r2);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ga0() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L12;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L12;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L12;
        MutableLiveData<Long> r3 = r2.getMyWantSingSongTotalNum();
        if (r3 == null) goto L12;
        Long r4 = (Long) r3.getValue();
        if (r4 == null) goto L12;
    L13:
        long r5 = r4.longValue();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r6 = ((BaseFirstLevelTabFragment) this).q;
        y r7 = null;
        boolean r8 = false;
        if (r6 == null) goto L37;
        List r9 = r6.getSecondLevelTabDataList(FirstLevelTab.OrderedSongTab.getValue());
        if (r9 == null) goto L37;
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((y) r11).c, "mine_want_sing") == false) goto L19;
    L24:
        y r12 = (y) r11;
        if (r12 == null) goto L37;
        if (r5 <= 0) goto L32;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L32;
        String r13 = "我的想唱 " + r5;
    L34:
        if ((!Intrinsics.areEqual(r12.d, r13)) == false) goto L36;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.d = r13;
        r8 = true;
    L36:
        r7 = r12;
    L32:
        r13 = "我的想唱";
        goto L34
    L23:
        r11 = null;
    L37:
        if (r8 == false) goto L45;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r14 = ((BaseFirstLevelTabFragment) this).q;
        if (r14 == null) goto L46;
        r14.updateSecondLevelTabListState(r7);
        return;
    L46:
        return;
    L45:
        return;
    L12:
        r4 = 0L;
        goto L13
    }

    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    public final void initData() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment*/.initData();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.t;
        int r2 = 0;
        if (r0 == null) goto L5;
        r0.syncSungSongList(false, null);
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.t;
        if (r1 == null) goto L8;
        r1.syncMineWantSingSongList(false, null);
    L8:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.t;
        if (r3 == null) goto L13;
        Integer r4 = r3.getSungOrderCount();
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        ia0(r5);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.t;
        if (r6 == null) goto L17;
        r6.observeSungOrderCount(this, new b(this));
    L17:
        ga0();
        KtvComponentContext r7 = KtvComponentContext.Companion.getContext();
        if (r7 == null) goto L26;
        n<KtvComponentUIContext> r8 = r7.getKtvComponentUIContext();
        if (r8 == null) goto L26;
        KtvComponentUIContext r9 = (KtvComponentUIContext) r8.getValue();
        if (r9 == null) goto L26;
        MutableLiveData<Long> r10 = r9.getMyWantSingSongTotalNum();
        if (r10 == null) goto L26;
        r10.observe(this, new c(this));
    L26:
        Integer r11 = KSongOrderSongUtilKt.e(this.t);
        if (r11 == null) goto L29;
        r2 = r11.intValue();
    L29:
        ha0(r2);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = this.t;
        if (r12 == null) goto L36;
        OrderedSongDataContext r13 = r12.getOrderedSongDataContext();
        if (r13 == null) goto L36;
        Disposable r14 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r13, null, new d(this), 3);
        if (r14 == null) goto L36;
        S90(r14);
    L36:
        ChorusContext r15 = ChorusContext.Companion.getContext();
        if (r15 == null) goto L45;
        n<List<MusicPanel>> r16 = r15.getChorusSelectedSongList();
        if (r16 == null) goto L45;
        Observable r17 = r16.a();
        if (r17 == null) goto L45;
        Disposable r18 = r17.subscribe(new e(this));
        if (r18 == null) goto L45;
        S90(r18);
    L45:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r19 = this.t;
        if (r19 == null) goto L48;
        r19.observeCurOrderedMusic(this, new j(this));
    L48:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r20 = this.t;
        if (r20 == null) goto L52;
        r20.observeCurFavoriteMusic(this, new k(this));
        return;
    L52:
        return;
    L13:
        r5 = 0;
        goto L14
    }

    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r9) {
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        if (Intrinsics.areEqual(r9.c, "play_list") == false) goto L6;
        int r1 = CustomSecondLevelTabFragment.k;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = ((BaseFirstLevelTabFragment) this).q;
        Function0<Unit> r6 = new OrderedFirstLevelTabFragment$createSecondLevelTabFragment$1(this);
        Function3<Fragment, FrameLayout, View, Unit> r5 = new OrderedFirstLevelTabFragment$createSecondLevelTabFragment$2(this);
        Function2<Integer, String, Unit> r7 = new OrderedFirstLevelTabFragment$createSecondLevelTabFragment$3(this);
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        return new CustomSecondLevelTabFragment(r3, r9, r5, r6, r7);
    L6:
        if (Intrinsics.areEqual(r9.c, "mine_want_sing") == false) goto L8;
        int r2 = BusinessListSecondLevelTabFragment.s;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = ((BaseFirstLevelTabFragment) this).q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = this.t;
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        return new BusinessListSecondLevelTabFragment(r9, r4, r8);
    L8:
        int r10 = MusicListSecondLevelTabFragment.x;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r11 = ((BaseFirstLevelTabFragment) this).q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = this.t;
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r9, r11, r12);
    }

    public final void U50(boolean r6) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        if (r0 == null) goto L7;
        y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.OrderedSongTab.getValue());
        if (r1 == null) goto L7;
        String r2 = r1.c;
    L9:
        if (r6 == true) goto L11;
    L25:
        if (r6 == true) goto L27;
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d r7 = this.s;
        if (r7 == null) goto L37;
        r7.a();
        return;
    L37:
        return;
    L27:
        if (Intrinsics.areEqual(r2, "play_list") == false) goto L31;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d r8 = this.s;
        if (r8 == null) goto L35;
        r8.f();
        return;
    L35:
        return;
    L11:
        if (Intrinsics.areEqual(r2, "mine_want_sing") == false) goto L16;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.t;
        if (r3 == null) goto L25;
        r3.syncMineWantSingSongList(false, null);
        goto L25
    L16:
        if (Intrinsics.areEqual(r2, "sung") == false) goto L21;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.t;
        if (r4 == null) goto L25;
        r4.syncSungSongList(false, null);
        goto L25
    L21:
        if (Intrinsics.areEqual(r2, "play_list") == false) goto L25;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.t;
        if (r5 == null) goto L25;
        r5.getOrderedSongList(false);
    L7:
        r2 = null;
        goto L9
    }

    public final void ca0(y r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (ea0(r5) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5.c, "sung") == false) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.t;
        if (r0 == null) goto L13;
        MutableLiveData<vb0.a> r1 = r0.getOrderSongUiState();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r1, OrderedFirstLevelTabFragment$onSecondLevelTabSelected$1.INSTANCE);
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.t;
        if (r2 == null) goto L17;
        r2.syncSungSongList(false, new OrderedFirstLevelTabFragment$onSecondLevelTabSelected$2(this));
    L17:
        if (Intrinsics.areEqual(r5.c, "mine_want_sing") == false) goto L30;
        KtvComponentContext r3 = KtvComponentContext.Companion.getContext();
        if (r3 == null) goto L21;
        r3.updateSingApplyUnreadCount(0);
    L21:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.t;
        if (r4 == null) goto L26;
        MutableLiveData<vb0.a> r6 = r4.getOrderSongUiState();
        if (r6 == null) goto L26;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r6, OrderedFirstLevelTabFragment$onSecondLevelTabSelected$3.INSTANCE);
    L26:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r7 = this.t;
        if (r7 == null) goto L30;
        r7.syncMineWantSingSongList(false, new OrderedFirstLevelTabFragment$onSecondLevelTabSelected$4(this));
    L30:
        if (Intrinsics.areEqual(r5.c, "play_list") == false) goto L37;
        ke2.a.a(true);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = this.t;
        if (r8 == null) goto L34;
        r8.getOrderedSongList(false);
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d r9 = this.s;
        if (r9 == null) goto L42;
        r9.f();
        return;
    L42:
        return;
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d r10 = this.s;
        if (r10 == null) goto L44;
        r10.a();
        return;
    }

    public final void ha0(int r7) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        y r1 = null;
        boolean r2 = false;
        if (r0 == null) goto L25;
        List r3 = r0.getSecondLevelTabDataList(FirstLevelTab.OrderedSongTab.getValue());
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((y) r5).c, "play_list") == false) goto L8;
    L13:
        y r6 = (y) r5;
        if (r6 == null) goto L25;
        if (r7 <= 0) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L20;
        String r8 = "播放列表 " + r7;
    L22:
        if ((!Intrinsics.areEqual(r6.d, r8)) == false) goto L24;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r6.d = r8;
        r2 = true;
    L24:
        r1 = r6;
    L20:
        r8 = "播放列表";
        goto L22
    L12:
        r5 = null;
    L25:
        if (r2 == false) goto L33;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r9 = ((BaseFirstLevelTabFragment) this).q;
        if (r9 == null) goto L34;
        r9.updateSecondLevelTabListState(r1);
        return;
    L34:
        return;
    }

    public final void ia0(int r7) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        y r1 = null;
        boolean r2 = false;
        if (r0 == null) goto L25;
        List r3 = r0.getSecondLevelTabDataList(FirstLevelTab.OrderedSongTab.getValue());
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((y) r5).c, "sung") == false) goto L8;
    L13:
        y r6 = (y) r5;
        if (r6 == null) goto L25;
        if (r7 <= 0) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L20;
        String r8 = "已唱 " + r7;
    L22:
        if ((!Intrinsics.areEqual(r6.d, r8)) == false) goto L24;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r6.d = r8;
        r2 = true;
    L24:
        r1 = r6;
    L20:
        r8 = "已唱";
        goto L22
    L12:
        r5 = null;
    L25:
        if (r2 == false) goto L33;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r9 = ((BaseFirstLevelTabFragment) this).q;
        if (r9 == null) goto L34;
        r9.updateSecondLevelTabListState(r1);
        return;
    L34:
        return;
    }

    public OrderedFirstLevelTabFragment(String r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3) {
        super(r1, r2);
        this.t = r3;
    }
}
