package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.config.jg0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/e;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroid/content/Context;", "j", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseFirstLevelTabManager implements e, LifecycleOwnerCompat {
    public static final /* synthetic */ int o = 0;
    public final Lazy a;
    public final Lazy b;
    public final Map<FirstLevelTab, Integer> c;
    public final Lazy d;
    public TabLayout e;
    public final LifecycleRegistry f;
    public final Lazy g;
    public Integer h;
    public String i;
    public final Context j;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b k;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a l;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d m;
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseFirstLevelTabManager a;

        public b(BaseFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (ChorusContext.Companion.c() == true) goto L13;
            BaseFirstLevelTabManager r5 = this.a;
            FirstLevelTab r0 = FirstLevelTab.OrderedSongTab;
            OrderedSongDataContext r1 = r5.m.getOrderedSongDataContext();
            if (r1 == null) goto L10;
            List<SongUniqueInfo> r2 = r1.getKtvPublicSongUniqueInfoList();
            if (r2 == null) goto L10;
            int r6 = r2.size();
        L11:
            r5.u(r0, r6);
            return;
        L10:
            r6 = 0;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseFirstLevelTabManager a;

        public c(BaseFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            if (ChorusContext.Companion.c() == false) goto L11;
            List r5 = (List) sh6.c.b(r4);
            if (r5 == null) goto L8;
            int r6 = r5.size();
        L9:
            this.a.u(FirstLevelTab.OrderedSongTab, r6);
            return;
        L8:
            r6 = 0;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BaseFirstLevelTabManager a;

        public d(BaseFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            BaseFirstLevelTabManager r6 = this.a;
            FirstLevelTab r0 = FirstLevelTab.MySongTab;
            int r1 = BaseFirstLevelTabManager.o;
            if (r6.p() == false) goto L5;
            long r2 = 1L;
        L6:
            r6.v(r0, r2);
            return;
        L5:
            r2 = 0L;
            goto L6
        }
    }

    static {
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final List<String> l() {
        return (List) this.a.getValue();
    }

    public abstract LiveKtvFirstLevelTabConfigData m();

    public final List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> o() {
        return (List) this.b.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void clearData() {
        this.f.setCurrentState(Lifecycle.State.DESTROYED);
        ((CompositeDisposable) this.d.getValue()).clear();
        this.e = null;
        o().clear();
    }

    public void e() {
        this.f.setCurrentState(Lifecycle.State.STARTED);
        FirstLevelTab r0 = FirstLevelTab.MySongTab;
        if (p() == false) goto L5;
        long r1 = 1L;
    L6:
        v(r0, r1);
        FirstLevelTab r2 = FirstLevelTab.OrderedSongTab;
        Integer r3 = KSongOrderSongUtilKt.e(this.m);
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        u(r2, r4);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0L;
        goto L6
    }

    public final Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f() {
        return new BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1(this);
    }

    public final Function3<String, TabLayout, Context, Unit> h() {
        return new BaseFirstLevelTabManager$fillCustomTabAction$1(this);
    }

    public final Function0<Unit> i() {
        return new BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1(this);
    }

    public final Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> j() {
        return new BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1(this);
    }

    public final boolean p() {
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasNewKtvDress() != true) goto L7;
        return true;
    }

    public final Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r() {
        return new BaseFirstLevelTabManager$initBusinessEntryAction$1(this);
    }

    public void s() {
        this.f.setCurrentState(Lifecycle.State.CREATED);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.m;
        if (r0 == null) goto L9;
        OrderedSongDataContext r1 = r0.getOrderedSongDataContext();
        if (r1 == null) goto L9;
        Disposable r2 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r1, null, new b(this), 3);
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, (CompositeDisposable) this.d.getValue());
    L9:
        ChorusContext r3 = ChorusContext.Companion.getContext();
        if (r3 == null) goto L18;
        n<List<MusicPanel>> r4 = r3.getChorusSelectedSongList();
        if (r4 == null) goto L18;
        Observable r5 = r4.a();
        if (r5 == null) goto L18;
        Disposable r6 = r5.subscribe(new c(this));
        if (r6 == null) goto L18;
        RxUtilKt.c(r6, (CompositeDisposable) this.d.getValue());
    L18:
        KtvContext.Companion.getClass();
        Disposable r7 = KtvContext.a.g().getKtvAddDressVersion().a().subscribe(new d(this));
        if (r7 == null) goto L22;
        RxUtilKt.c(r7, (CompositeDisposable) this.d.getValue());
        return;
    }

    public final Function0<Unit> t() {
        return new BaseFirstLevelTabManager$postFillCustomTabAction$1(this);
    }

    public final Function0<Unit> w() {
        return new BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1(this);
    }

    public final Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> x() {
        return new BaseFirstLevelTabManager$setCartAnimAction$1(this);
    }

    public final Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> y() {
        return new BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1(this);
    }

    public final Function0<Unit> z() {
        return new BaseFirstLevelTabManager$syncOrderedSongListAction$1(this);
    }

    public final Context getContext() {
        return this.j;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r25) {
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(new OrderSongRequiredConfig(this.k, new BaseFirstLevelTabManager$fillCustomTabAction$1(this), new BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1(this), new BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1(this)), new u(new BaseFirstLevelTabManager$postFillCustomTabAction$1(this), new BaseFirstLevelTabManager$setCartAnimAction$1(this), new BaseFirstLevelTabManager$selectDefaultFirstLevelTabAction$1(this), new BaseFirstLevelTabManager$syncOrderedSongListAction$1(this), new BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1(this), new BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1(this), new BaseFirstLevelTabManager$initBusinessEntryAction$1(this), null, false, null, null, null, null, null, null, 65408));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void a(int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "secondLevelTabName");
        Iterator<T> r0 = o().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r0.next()).O0();
        goto L4
    L6:
        Pair<Integer, String> r13 = k(r11, r12);
        int r14 = ((Number) r13.component1()).intValue();
        String r15 = (String) r13.component2();
        FirstLevelTab[] r1 = FirstLevelTab.values();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L16;
        FirstLevelTab r4 = r1[r3];
        if (r14 != r4.getValue()) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L17;
        r3 = r3 + 1;
    L17:
        if (r4 != null) goto L19;
        r4 = FirstLevelTab.OrderSongTab;
    L19:
        FirstLevelTab r16 = r4;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.m;
        if (r6 == null) goto L22;
        ModeType r7 = r6.getModeType();
    L23:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r8 = this.k;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = this.m;
        if (r9 == null) goto L26;
        String r10 = r9.getRequiredSongInfo();
    L27:
        KSongOrderSongUtilKt.o(r7, r8, r16, r10, false, r15, 16);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r17 = this.k;
        if (r17 == null) goto L30;
        r17.updateSelectFirstLevelTabValue(r16.getValue(), UpdateTabType.DEFAULT);
    L30:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r18 = this.k;
        if (r18 == null) goto L34;
        y r19 = r18.getSecondLevelTabDataByParams(r16.getValue(), r15);
        if (r19 == null) goto L34;
    L38:
        Iterator<T> r20 = o().iterator();
    L40:
        if (r20.hasNext() == false) goto L47;
        Object r21 = r20.next();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r21).VL().getValue() != r16.getValue()) goto L44;
        boolean r22 = true;
    L45:
        if (r22 == false) goto L40;
    L48:
        com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a r23 = (com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r21;
        if (r23 == null) goto L52;
        r23.Tq(r19, SecondLevelTabViewSelectedType.Default);
    L52:
        if (this.h == null) goto L55;
        this.h = null;
    L55:
        if (this.i == null) goto L66;
        this.i = null;
        return;
    L66:
        return;
    L44:
        r22 = false;
        goto L45
    L47:
        r21 = null;
    L34:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r110 = this.k;
        if (r110 == null) goto L37;
        r19 = r110.getSelectedSecondLevelTabData(r16.getValue());
        goto L38
    L37:
        r19 = null;
        goto L38
    L26:
        r10 = null;
        goto L27
    L22:
        r7 = null;
        goto L23
    L12:
        r5 = false;
        goto L13
    L16:
        r4 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void c(Integer r1, String r2) {
        this.h = r1;
        this.i = r2;
    }

    public final boolean g(int r6, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r7) {
        int r0 = ((Number) h.F0.getValue(null, h.a[82])).intValue();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r7, r6)).VL().getValue() != FirstLevelTab.OrderedSongTab.getValue()) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (bb0.b.a() == KtvMode.LIVE_KTV) goto L12;
    L32:
        return false;
    L12:
        if (j.i() == true) goto L32;
        DataCenter r9 = (DataCenter) this.g.getValue();
        if (r9 == null) goto L21;
        Integer r10 = (Integer) r9.get("data_link_state", 0);
        if (r10 == null) goto L21;
        int r11 = r10.intValue();
        boolean r1 = v.a(r11, 4);
        boolean r12 = v.a(r11, 64);
        if (r1 == true) goto L20;
        if (r12 == false) goto L21;
    L20:
        boolean r13 = true;
    L22:
        if (r13 == true) goto L32;
        if (r0 <= 0) goto L32;
        if (r8 == false) goto L32;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L32;
        if (((Number) jg0.a.getValue()).intValue() <= 0) goto L32;
        if (jc0.a.c() == true) goto L32;
        return true;
    L21:
        r13 = false;
        goto L22
    L5:
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r7, r6)).VL().getValue() == FirstLevelTab.OrderSongTab.getValue()) goto L8;
        r8 = false;
        goto L10
    }

    public Pair<Integer, String> k(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabName");
        Integer r0 = this.h;
        if (r0 == null) goto L5;
        r2 = r0.intValue();
    L5:
        String r1 = this.i;
        if (r1 == null) goto L10;
        r3 = r1;
    L10:
        return new Pair(Integer.valueOf(r2), r3);
    }

    public final void u(FirstLevelTab r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "firstLevelTab");
        Iterator<T> r0 = o().iterator();
    L3:
        View r2 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r1).VL().getValue() != r6.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L3;
    L12:
        com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a r4 = (com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r1;
        if (r4 == null) goto L16;
        String r5 = r4.aK();
        if (r5 == null) goto L16;
    L17:
        if (r7 == 0) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L22;
        r5 = r5 + ' ' + r7;
    L22:
        TabLayout r8 = this.e;
        if (r8 == null) goto L31;
        Integer r9 = (Integer) ((LinkedHashMap) this.c).get(r6);
        if (r9 == null) goto L27;
        int r10 = r9.intValue();
    L28:
        TabLayout.Tab r11 = r8.getTabAt(r10);
        if (r11 == null) goto L31;
        View r12 = r11.getCustomView();
    L33:
        if ((r12 instanceof kb0.a) == false) goto L36;
        r2 = r12;
    L36:
        kb0.a r13 = (kb0.a) r2;
        if (r13 == null) goto L45;
        r13.setTabName(r5);
        return;
    L45:
        return;
    L27:
        r10 = -1;
    L31:
        r12 = null;
    L16:
        r5 = "";
        goto L17
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final void v(FirstLevelTab r7, Long r8) {
        Intrinsics.checkNotNullParameter(r7, "firstLevelTab");
        if (r8 == null) goto L5;
        long r2 = r8.longValue();
    L6:
        int r9 = -1;
        View r4 = null;
        if (r2 <= 0) goto L24;
        TabLayout r0 = this.e;
        if (r0 == null) goto L16;
        Integer r10 = (Integer) ((LinkedHashMap) this.c).get(r7);
        if (r10 == null) goto L13;
        r9 = r10.intValue();
    L13:
        TabLayout.Tab r11 = r0.getTabAt(r9);
        if (r11 == null) goto L16;
        View r12 = r11.getCustomView();
    L18:
        if ((r12 instanceof kb0.a) == false) goto L21;
        r4 = r12;
    L21:
        kb0.a r5 = (kb0.a) r4;
        if (r5 == null) goto L41;
        r5.G5(0);
        return;
    L41:
        return;
    L16:
        r12 = null;
        goto L18
    L24:
        TabLayout r1 = this.e;
        if (r1 == null) goto L32;
        Integer r13 = (Integer) ((LinkedHashMap) this.c).get(r7);
        if (r13 == null) goto L29;
        r9 = r13.intValue();
    L29:
        TabLayout.Tab r14 = r1.getTabAt(r9);
        if (r14 == null) goto L32;
        View r15 = r14.getCustomView();
    L34:
        if ((r15 instanceof kb0.a) == false) goto L37;
        r4 = r15;
    L37:
        kb0.a r6 = (kb0.a) r4;
        if (r6 == null) goto L43;
        r6.G5(8);
        return;
    L43:
        return;
    L32:
        r15 = null;
        goto L34
    L5:
        r2 = 0;
        goto L6
    }

    public BaseFirstLevelTabManager(Integer r1, String r2, Context r3, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4, com.bytedance.android.live.ktv.common.search.viewmodel.a r5, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.a = LazyKt.lazy(BaseFirstLevelTabManager$firstLevelTabArrayList$2.INSTANCE);
        this.b = LazyKt.lazy(BaseFirstLevelTabManager$firstLevelTabFragmentList$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = LazyKt.lazy(BaseFirstLevelTabManager$compositeDisposable$2.INSTANCE);
        this.f = new LifecycleRegistry(this);
        this.g = LazyKt.lazy(BaseFirstLevelTabManager$dataCenter$2.INSTANCE);
    }
}
