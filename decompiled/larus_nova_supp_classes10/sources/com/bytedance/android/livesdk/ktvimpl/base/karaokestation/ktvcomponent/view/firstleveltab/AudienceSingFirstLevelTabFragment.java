package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.SecondLevelTabView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.BusinessListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/firstleveltab/AudienceSingFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceSingFirstLevelTabFragment extends BaseFirstLevelTabFragment {
    public static final /* synthetic */ int w = 0;
    public DialogLoadingView s;
    public boolean t;
    public final List<String> u;
    public final d v;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AudienceSingFirstLevelTabFragment a;

        public b(AudienceSingFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            AudienceSingFirstLevelTabFragment r0 = this.a;
            int r1 = AudienceSingFirstLevelTabFragment.w;
            if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.AudienceSingTab) == false) goto L8;
            DialogLoadingView r2 = this.a.s;
            if (r2 == null) goto L9;
            r2.a(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudienceSingFirstLevelTabFragment a;

        public c(AudienceSingFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            AudienceSingFirstLevelTabFragment r0 = this.a;
            int r1 = AudienceSingFirstLevelTabFragment.w;
            r0.ga0((Boolean) r3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.AudienceSingFirstLevelTabFragment$initData$3, reason: invalid class name */
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

    public AudienceSingFirstLevelTabFragment() {
        this(null, null, null);
    }

    public final int getLayoutId() {
        return 2131566447;
    }

    public final void V90() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        if (r0 == null) goto L5;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r1 = r0.getFirstLevelTabDataByTopValue(FirstLevelTab.AudienceSingTab.getValue());
    L6:
        if (r1 != null) goto L11;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r2 = new com.bytedance.android.live.ktv.common.karaokestation.model.d(0, 15);
        FirstLevelTab r3 = FirstLevelTab.AudienceSingTab;
        r2.d = r3.getValue();
        Map r4 = r2.a;
        y r5 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("multi_chorus", "<set-?>");
        r5.c = "multi_chorus";
        r5.k = r3.getValue();
        Intrinsics.checkNotNullParameter("一起唱", "<set-?>");
        r5.d = "一起唱";
        r5.n = 0;
        r5.j = true;
        Unit r9 = Unit.INSTANCE;
        r4.put("multi_chorus", r5);
        y r6 = new y(0, 0, 65535);
        Intrinsics.checkNotNullParameter("single_sing", "<set-?>");
        r6.c = "single_sing";
        r6.k = r3.getValue();
        Intrinsics.checkNotNullParameter("单人唱", "<set-?>");
        r6.d = "单人唱";
        r6.n = 1;
        r4.put("single_sing", r6);
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

    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    public final String aK() {
        return s1.B(2131918621);
    }

    public final void initData() {
        super.initData();
        d r0 = this.v;
        if (r0 == null) goto L5;
        r0.syncMultiChorusWaitingList(false, new AnonymousClass1(this));
    L5:
        d r1 = this.v;
        if (r1 == null) goto L8;
        r1.syncSongWaitingList(false, new AnonymousClass2(this));
    L8:
        d r2 = this.v;
        if (r2 == null) goto L13;
        MutableLiveData<vb0.a> r3 = r2.getOrderSongUiState();
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r3, this, AnonymousClass3.INSTANCE, new b(this));
    L13:
        MultiChorusContext.a r4 = MultiChorusContext.Companion;
        ga0(Boolean.valueOf(r4.c()));
        Disposable r5 = r4.g(new c(this));
        if (r5 == null) goto L17;
        S90(r5);
    L17:
        if (j.i() == false) goto L31;
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L32;
        d r6 = this.v;
        if (r6 == null) goto L25;
        MutableLiveData<vb0.a> r7 = r6.getOrderSongUiState();
        if (r7 == null) goto L25;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r7, this, AudienceSingFirstLevelTabFragment$handleSingApplyUnreadCount$1.INSTANCE, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.a(this));
    L25:
        d r8 = this.v;
        if (r8 == null) goto L33;
        MutableLiveData<vb0.a> r9 = r8.getOrderSongUiState();
        if (r9 == null) goto L34;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r9, this, AudienceSingFirstLevelTabFragment$handleSingApplyUnreadCount$3.INSTANCE, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.b(this));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }

    public final FirstLevelTab VL() {
        return FirstLevelTab.AudienceSingTab;
    }

    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r4) {
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        int r1 = BusinessListSecondLevelTabFragment.s;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseFirstLevelTabFragment) this).q;
        d r3 = this.v;
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        return new BusinessListSecondLevelTabFragment(r4, r2, r3);
    }

    public final void U50(boolean r5) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        if (r0 == null) goto L7;
        y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.AudienceSingTab.getValue());
        if (r1 == null) goto L7;
        String r2 = r1.c;
    L8:
        if (r5 == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r2, "multi_chorus") == false) goto L24;
        KtvComponentContext r6 = KtvComponentContext.Companion.getContext();
        if (r6 == null) goto L20;
        n<KtvComponentUIContext> r7 = r6.getKtvComponentUIContext();
        if (r7 == null) goto L20;
        KtvComponentUIContext r8 = (KtvComponentUIContext) r7.getValue();
        if (r8 == null) goto L20;
        MutableLiveData<Long> r9 = r8.getUnreadMultiChorusApplyNum();
        if (r9 == null) goto L20;
        r9.setValue(0L);
    L20:
        d r10 = this.v;
        if (r10 == null) goto L33;
        r10.syncMultiChorusWaitingList(false, new AudienceSingFirstLevelTabFragment$onFirstLevelTabSelectStateChange$1(this));
        return;
    L33:
        return;
    L24:
        if (Intrinsics.areEqual(r2, "single_sing") == false) goto L35;
        KtvComponentContext r11 = KtvComponentContext.Companion.getContext();
        if (r11 == null) goto L28;
        r11.updateSingApplyUnreadCount(0);
    L28:
        d r12 = this.v;
        if (r12 == null) goto L36;
        r12.syncSongWaitingList(false, new AudienceSingFirstLevelTabFragment$onFirstLevelTabSelectStateChange$2(this));
        return;
    L36:
        return;
    L35:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void ca0(y r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (ea0(r6) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r6.c, "multi_chorus") == false) goto L26;
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L17;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L17;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L17;
        MutableLiveData<Long> r3 = r2.getUnreadMultiChorusApplyNum();
        if (r3 == null) goto L17;
        r3.setValue(0L);
    L17:
        d r4 = this.v;
        if (r4 == null) goto L22;
        MutableLiveData<vb0.a> r5 = r4.getOrderSongUiState();
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r5, AudienceSingFirstLevelTabFragment$onSecondLevelTabSelected$1.INSTANCE);
    L22:
        d r7 = this.v;
        if (r7 == null) goto L26;
        r7.syncMultiChorusWaitingList(false, new AudienceSingFirstLevelTabFragment$onSecondLevelTabSelected$2(this));
    L26:
        if (Intrinsics.areEqual(r6.c, "single_sing") == false) goto L40;
        KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
        if (r8 == null) goto L30;
        r8.updateSingApplyUnreadCount(0);
    L30:
        d r9 = this.v;
        if (r9 == null) goto L35;
        MutableLiveData<vb0.a> r10 = r9.getOrderSongUiState();
        if (r10 == null) goto L35;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r10, AudienceSingFirstLevelTabFragment$onSecondLevelTabSelected$3.INSTANCE);
    L35:
        d r11 = this.v;
        if (r11 == null) goto L41;
        r11.syncSongWaitingList(false, new AudienceSingFirstLevelTabFragment$onSecondLevelTabSelected$4(this));
        return;
    L41:
        return;
    }

    public final void ga0(Boolean r5) {
        y r0 = null;
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L18;
        String r2 = "multi_chorus";
        if (this.t == false) goto L12;
        this.t = false;
        if (CollectionsKt.contains(this.u, ((BaseFirstLevelTabFragment) this).p) == false) goto L12;
        String r6 = ((BaseFirstLevelTabFragment) this).p;
        if (r6 == null) goto L12;
        r2 = r6;
    L12:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = ((BaseFirstLevelTabFragment) this).q;
        if (r7 == null) goto L15;
        r0 = r7.getSecondLevelTabDataByParams(FirstLevelTab.AudienceSingTab.getValue(), r2);
    L15:
        Tq(r0, SecondLevelTabViewSelectedType.CLICK);
        SecondLevelTabView r8 = ((BaseFirstLevelTabFragment) this).i;
        if (r8 == null) goto L33;
        r8.setVisibility(0);
        return;
    L33:
        return;
    L18:
        String r3 = "single_sing";
        if (this.t == false) goto L26;
        this.t = false;
        if (CollectionsKt.contains(this.u, ((BaseFirstLevelTabFragment) this).p) == false) goto L26;
        String r9 = ((BaseFirstLevelTabFragment) this).p;
        if (r9 == null) goto L26;
        r3 = r9;
    L26:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r10 = ((BaseFirstLevelTabFragment) this).q;
        if (r10 == null) goto L29;
        r0 = r10.getSecondLevelTabDataByParams(FirstLevelTab.AudienceSingTab.getValue(), r3);
    L29:
        Tq(r0, SecondLevelTabViewSelectedType.CLICK);
        SecondLevelTabView r11 = ((BaseFirstLevelTabFragment) this).i;
        if (r11 == null) goto L35;
        r11.setVisibility(8);
        return;
    }

    public final void initView(View r7) {
        super.initView(r7);
        Boolean r2 = null;
        DialogLoadingView r0 = new DialogLoadingView(requireContext(), null, 6, 0);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(s1.f(100.0f), s1.f(90.0f));
        r1.leftToLeft = 0;
        r1.rightToRight = 0;
        r1.topToBottom = 2131385682;
        r1.bottomToBottom = 0;
        r0.setLayoutParams(r1);
        if ((r7 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r7).addView(r0);
    L6:
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) this).q, FirstLevelTab.AudienceSingTab) == false) goto L15;
        d r8 = this.v;
        if (r8 == null) goto L14;
        MutableLiveData<vb0.a> r9 = r8.getOrderSongUiState();
        if (r9 == null) goto L14;
        vb0.a r10 = (vb0.a) r9.getValue();
        if (r10 == null) goto L14;
        r2 = r10.i;
    L14:
        r0.a(Intrinsics.areEqual(r2, Boolean.TRUE));
    L15:
        Unit r11 = Unit.INSTANCE;
        this.s = r0;
    }

    public AudienceSingFirstLevelTabFragment(String r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, d r3) {
        super(r1, r2);
        this.v = r3;
        this.t = true;
        this.u = CollectionsKt.listOf(new String[]{"single_sing", "multi_chorus"});
    }
}
