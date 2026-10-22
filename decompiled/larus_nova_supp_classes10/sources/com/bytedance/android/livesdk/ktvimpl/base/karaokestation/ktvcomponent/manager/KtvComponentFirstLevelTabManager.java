package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/manager/KtvComponentFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentFirstLevelTabManager extends BaseFirstLevelTabManager {
    public static final /* synthetic */ int q = 0;
    public final LiveKtvFirstLevelTabConfigData p;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ KtvComponentFirstLevelTabManager a;

        public b(KtvComponentFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            long r6 = (Long) r5;
            KtvComponentFirstLevelTabManager r0 = this.a;
            int r1 = KtvComponentFirstLevelTabManager.q;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = r0.k;
            if (r2 == null) goto L9;
            Pair r3 = r2.getSelectedFirstLevelTabValue();
            if (r3 == null) goto L9;
            if (((Number) r3.getFirst()).intValue() != FirstLevelTab.OrderSongTab.getValue()) goto L9;
            boolean r4 = true;
        L10:
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = this.a.k;
            if (r7 == null) goto L15;
            y r8 = r7.getSelectedSecondLevelTabData(FirstLevelTab.OrderSongTab.getValue());
            if (r8 == null) goto L15;
            String r9 = r8.c;
        L16:
            boolean r10 = Intrinsics.areEqual(r9, "recommend");
            KtvComponentFirstLevelTabManager r11 = this.a;
            FirstLevelTab r12 = FirstLevelTab.OrderSongTab;
            if (r4 == false) goto L19;
            if (r10 == false) goto L19;
        L21:
            r6 = 0L;
        L22:
            r11.v(r12, r6);
            return;
        L19:
            j.l.getClass();
            if (j.i() == false) goto L22;
        L15:
            r9 = null;
        L9:
            r4 = false;
            goto L10
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvComponentFirstLevelTabManager a;

        public c(KtvComponentFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Long r6 = (Long) r5;
            KtvComponentFirstLevelTabManager r0 = this.a;
            FirstLevelTab r1 = FirstLevelTab.AudienceSingTab;
            if (r6 == null) goto L5;
            int r7 = (int) r6.longValue();
        L6:
            int r2 = KtvComponentFirstLevelTabManager.q;
            r0.u(r1, r7);
            return;
        L5:
            r7 = 0;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvComponentFirstLevelTabManager a;

        public d(KtvComponentFirstLevelTabManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            long r6 = (Long) r5;
            KtvComponentFirstLevelTabManager r0 = this.a;
            FirstLevelTab r1 = FirstLevelTab.OrderedSongTab;
            j.l.getClass();
            if (j.i() == false) goto L5;
            r6 = 0L;
        L5:
            int r2 = KtvComponentFirstLevelTabManager.q;
            r0.v(r1, r6);
        }
    }

    static {
    }

    public final void B() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.m;
        if (r0 == null) goto L8;
        MutableLiveData<vb0.a> r1 = r0.getOrderSongUiState();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r1, new KtvComponentFirstLevelTabManager$updateSingListenApplyUnReadNum$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void e() {
        super.e();
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L17;
        FirstLevelTab r0 = FirstLevelTab.OrderedSongTab;
        j.l.getClass();
        if (j.i() == false) goto L7;
        Long r1 = 0L;
    L15:
        v(r0, r1);
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.m;
        if (r2 == null) goto L14;
        MutableLiveData<vb0.a> r3 = r2.getOrderSongUiState();
        if (r3 == null) goto L14;
        vb0.a r4 = (vb0.a) r3.getValue();
        if (r4 == null) goto L14;
        r1 = r4.a;
    L14:
        r1 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void s() {
        super.s();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L41;
        B();
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        KtvComponentContext r1 = r0.getContext();
        if (r1 == null) goto L13;
        n<KtvComponentUIContext> r2 = r1.getKtvComponentUIContext();
        if (r2 == null) goto L13;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r2.getValue();
        if (r3 == null) goto L13;
        NextLiveData<Long> r4 = r3.getApplyListenUnreadNum();
        if (r4 == null) goto L13;
        r4.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.b(this));
    L13:
        KtvComponentContext r5 = r0.getContext();
        if (r5 == null) goto L22;
        n<KtvComponentUIContext> r6 = r5.getKtvComponentUIContext();
        if (r6 == null) goto L22;
        KtvComponentUIContext r7 = (KtvComponentUIContext) r6.getValue();
        if (r7 == null) goto L22;
        NextLiveData<Long> r8 = r7.getApplySingUnreadNum();
        if (r8 == null) goto L22;
        r8.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.c(this));
    L22:
        KtvComponentContext r9 = r0.getContext();
        if (r9 == null) goto L31;
        n<KtvComponentUIContext> r10 = r9.getKtvComponentUIContext();
        if (r10 == null) goto L31;
        KtvComponentUIContext r11 = (KtvComponentUIContext) r10.getValue();
        if (r11 == null) goto L31;
        MutableLiveData<Long> r12 = r11.getUnreadMultiChorusApplyNum();
        if (r12 == null) goto L31;
        r12.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.d(this));
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r13 = this.m;
        if (r13 == null) goto L36;
        MutableLiveData<vb0.a> r14 = r13.getOrderSongUiState();
        if (r14 == null) goto L36;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r14, this, KtvComponentFirstLevelTabManager$initData$1.INSTANCE, new b(this));
    L36:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r15 = this.m;
        if (r15 == null) goto L61;
        MutableLiveData<vb0.a> r16 = r15.getOrderSongUiState();
        if (r16 == null) goto L62;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r16, this, KtvComponentFirstLevelTabManager$initData$3.INSTANCE, new c(this));
        return;
    L62:
        return;
    L61:
        return;
    L41:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r17 = this.m;
        if (r17 == null) goto L46;
        MutableLiveData<vb0.a> r18 = r17.getOrderSongUiState();
        if (r18 == null) goto L46;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r18, KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1.INSTANCE);
    L46:
        KtvComponentContext r19 = KtvComponentContext.Companion.getContext();
        if (r19 == null) goto L55;
        n<KtvComponentUIContext> r20 = r19.getKtvComponentUIContext();
        if (r20 == null) goto L55;
        KtvComponentUIContext r21 = (KtvComponentUIContext) r20.getValue();
        if (r21 == null) goto L55;
        NextLiveData<Integer> r22 = r21.getOrderSongUnReadNum();
        if (r22 == null) goto L55;
        r22.observe(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.a(this));
    L55:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r23 = this.m;
        if (r23 == null) goto L64;
        MutableLiveData<vb0.a> r24 = r23.getOrderSongUiState();
        if (r24 == null) goto L65;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r24, this, KtvComponentFirstLevelTabManager$initData$5.INSTANCE, new d(this));
        return;
    L65:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.p;
    }

    public static final long A(KtvComponentFirstLevelTabManager r2) {
        r2.getClass();
        KtvComponentContext r3 = KtvComponentContext.Companion.getContext();
        if (r3 == null) goto L13;
        n<KtvComponentUIContext> r4 = r3.getKtvComponentUIContext();
        if (r4 == null) goto L13;
        KtvComponentUIContext r5 = (KtvComponentUIContext) r4.getValue();
        if (r5 == null) goto L13;
        MutableLiveData<Long> r6 = r5.getUnreadMultiChorusApplyNum();
        if (r6 == null) goto L13;
        Long r7 = (Long) r6.getValue();
        if (r7 == null) goto L13;
        return r7.longValue();
    L13:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r25) {
        OrderSongRequiredConfig r1 = new OrderSongRequiredConfig(this.k, h(), i(), f());
        Function0<Unit> r8 = t();
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r9 = x();
        Function0<Unit> r10 = w();
        Function0<Unit> r11 = z();
        Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r12 = j();
        Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r14 = r();
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(r1, new u(r8, r9, r10, r11, r12, y(), r14, Integer.valueOf(s1.f(541.0f)), true, KtvComponentFirstLevelTabManager$initTopControlBarAction$1.INSTANCE, KtvComponentFirstLevelTabManager$updateOrderSongDialogTopAreaAction$1.INSTANCE, null, null, null, null, 61568));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final Pair<Integer, String> k(int r19, String r20) {
        String r2 = r20;
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabName");
        String r1 = this.i;
        if (r1 != null) goto L6;
        r1 = r2;
    L6:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L85;
        KtvComponentContext.a r3 = KtvComponentContext.Companion;
        KtvComponentContext r5 = r3.getContext();
        if (r5 == null) goto L10;
        long r8 = r5.getSingApplyUnreadCount();
    L11:
        KtvComponentContext r6 = r3.getContext();
        if (r6 == null) goto L14;
        long r10 = r6.getListenApplyUnreadCount();
    L15:
        KtvComponentContext r7 = r3.getContext();
        if (r7 == null) goto L25;
        n<KtvComponentUIContext> r9 = r7.getKtvComponentUIContext();
        if (r9 == null) goto L25;
        KtvComponentUIContext r11 = (KtvComponentUIContext) r9.getValue();
        if (r11 == null) goto L25;
        MutableLiveData<Long> r12 = r11.getUnreadMultiChorusApplyNum();
        if (r12 == null) goto L25;
        Long r13 = (Long) r12.getValue();
        if (r13 == null) goto L25;
    L26:
        long r14 = r13.longValue();
        long r15 = r8 + r14;
        KtvComponentContext r4 = r3.getContext();
        if (r4 == null) goto L33;
        n<KtvComponentUIContext> r16 = r4.getKtvComponentUIContext();
        if (r16 == null) goto L33;
        KtvComponentUIContext r17 = (KtvComponentUIContext) r16.getValue();
        if (r17 == null) goto L33;
        Integer r18 = r17.getLastApplyMsgType();
    L35:
        if (r10 > 0) goto L37;
    L66:
        if (r10 <= 0) goto L70;
        if (r15 != 0) goto L70;
    L72:
        if (r10 <= 0) goto L75;
        int r21 = FirstLevelTab.OrderSongTab.getValue();
    L99:
        Integer r22 = this.h;
        if (r22 == null) goto L104;
        if (r22 == null) goto L103;
        r21 = r22.intValue();
        goto L104
    L103:
        r21 = r19;
    L104:
        String r23 = this.i;
        if (r23 == null) goto L110;
        if (r23 == null) goto L109;
        r2 = r23;
    L109:
        r1 = r2;
    L110:
        KtvComponentContext r24 = KtvComponentContext.Companion.getContext();
        if (r24 == null) goto L118;
        n<KtvComponentUIContext> r25 = r24.getKtvComponentUIContext();
        if (r25 == null) goto L118;
        KtvComponentUIContext r26 = (KtvComponentUIContext) r25.getValue();
        if (r26 == null) goto L118;
        r26.setLastApplyMsgType(null);
    L118:
        return new Pair(Integer.valueOf(r21), r1);
    L75:
        if (r15 <= 0) goto L82;
        r21 = FirstLevelTab.AudienceSingTab.getValue();
        if (r14 <= 0) goto L80;
        r1 = "multi_chorus";
        goto L99
    L80:
        if (r8 <= 0) goto L99;
        r1 = "single_sing";
        goto L99
    L82:
        r21 = FirstLevelTab.OrderSongTab.getValue();
    L70:
        if (r15 <= 0) goto L83;
        if (r10 == 0) goto L72;
    L83:
        r21 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L37:
        if (r15 <= 0) goto L66;
        if (r18 != null) goto L42;
    L43:
        if (r18 != null) goto L46;
    L48:
        if (r18 != null) goto L51;
    L53:
        r21 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L51:
        if (r18.intValue() != 10) goto L53;
        r21 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L46:
        if (r18.intValue() != 15) goto L48;
    L54:
        int r27 = FirstLevelTab.AudienceSingTab.getValue();
        if (r18 != null) goto L58;
    L61:
        if (r18 != null) goto L64;
    L60:
        r21 = r27;
        goto L99
    L64:
        if (r18.intValue() != 15) goto L60;
        r1 = "multi_chorus";
        goto L60
    L58:
        if (r18.intValue() != 9) goto L61;
        r1 = "single_sing";
        goto L60
    L42:
        if (r18.intValue() == 9) goto L54;
    L33:
        r18 = null;
    L25:
        r13 = 0L;
        goto L26
    L14:
        r10 = 0;
        goto L15
    L10:
        r8 = 0;
        goto L11
    L85:
        if (KtvUtilsKt.f() == false) goto L95;
        KtvComponentContext r28 = KtvComponentContext.Companion.getContext();
        if (r28 == null) goto L91;
        n<Boolean> r29 = r28.isAudienceEnableSing();
        if (r29 == null) goto L91;
        Boolean r30 = (Boolean) r29.getValue();
    L93:
        if (Intrinsics.areEqual(r30, Boolean.TRUE) == false) goto L95;
        boolean r31 = true;
    L96:
        if (r31 == false) goto L98;
        r21 = FirstLevelTab.OrderSongTab.getValue();
        goto L99
    L98:
        r21 = FirstLevelTab.WantListenTab.getValue();
    L91:
        r30 = null;
    L95:
        r31 = false;
        goto L96
    }

    public KtvComponentFirstLevelTabManager(Integer r1, String r2, Context r3, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4, com.bytedance.android.live.ktv.common.search.viewmodel.a r5, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        LiveKtvFirstLevelTabConfig r8 = h.n();
        LiveKtvFirstLevelTabConfigData r9 = null;
        Object r10 = null;
        r9 = null;
        if (r8 == null) goto L13;
        List r11 = r8.getLiveKtvFirstLevelTabConfig();
        if (r11 == null) goto L13;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r13).getModeType(), ModeType.KTV_COMPONENT.getValue()) == false) goto L8;
        r10 = r13;
    L12:
        r9 = (LiveKtvFirstLevelTabConfigData) r10;
    L13:
        this.p = r9;
    }
}
