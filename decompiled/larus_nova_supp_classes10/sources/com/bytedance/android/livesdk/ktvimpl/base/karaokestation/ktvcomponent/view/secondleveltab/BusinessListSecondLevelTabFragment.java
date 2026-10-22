package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.ItemExposureCheckHelper;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonDefaultSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/BusinessListSecondLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonDefaultSecondLevelTabFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BusinessListSecondLevelTabFragment extends CommonDefaultSecondLevelTabFragment {
    public static final /* synthetic */ int s = 0;
    public final Map<String, Boolean> o;
    public final Lazy p;
    public final Lazy q;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BusinessListSecondLevelTabFragment a;

        public b(BusinessListSecondLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L5;
            boolean r5 = r4.booleanValue();
        L6:
            BusinessListSecondLevelTabFragment r0 = this.a;
            int r1 = BusinessListSecondLevelTabFragment.s;
            r0.Y90(r5);
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    static {
    }

    public BusinessListSecondLevelTabFragment() {
        this(new y(0, 0, 65535), null, null);
    }

    public final void O0() {
        ((LinkedHashMap) this.o).clear();
    }

    public final Function1<MultiTypeAdapter, Unit> U90() {
        return new BusinessListSecondLevelTabFragment$getCustomItemViewBinderAction$1(this);
    }

    public final Function1<t, Unit> V90() {
        return new BusinessListSecondLevelTabFragment$getHandleLoadMoreAction$1(this);
    }

    public final void initData() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment*/.initData();
        ((ItemExposureCheckHelper) this.p.getValue()).b(((BaseSecondLevelTabFragment) this).g, (c) this.q.getValue());
    }

    public final void Y90(boolean r6) {
        if (Intrinsics.areEqual(((BaseSecondLevelTabFragment) this).k.c, "multi_chorus") == true) goto L7;
        if (Intrinsics.areEqual(((BaseSecondLevelTabFragment) this).k.c, "single_sing") == true) goto L7;
        return;
    L7:
        if (r6 == false) goto L12;
        KtvCommonEmptyView r7 = ((BaseSecondLevelTabFragment) this).h;
        if (r7 == null) goto L11;
        r7.a(s1.B(2131918291), s1.B(2131918292));
    L11:
        r3.a(((BaseSecondLevelTabFragment) this).h, s1.B(2131918291) + ' ' + s1.B(2131918292));
        return;
    L12:
        KtvCommonEmptyView r8 = ((BaseSecondLevelTabFragment) this).h;
        if (r8 == null) goto L15;
        r8.a(s1.B(2131918289), s1.B(2131918290));
    L15:
        r3.a(((BaseSecondLevelTabFragment) this).h, s1.B(2131918289) + ' ' + s1.B(2131918290));
    }

    public final void initView(View r2) {
        super.initView(r2);
        KtvComponentContext.a r3 = KtvComponentContext.Companion;
        KtvComponentContext r0 = r3.getContext();
        if (r0 == null) goto L9;
        n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L9;
        Boolean r4 = (Boolean) r1.getValue();
        if (r4 == null) goto L9;
        boolean r5 = r4.booleanValue();
    L10:
        Y90(r5);
        KtvComponentContext r6 = r3.getContext();
        if (r6 == null) goto L20;
        n<Boolean> r7 = r6.isAudienceEnableSing();
        if (r7 == null) goto L21;
        Observable r8 = r7.a();
        if (r8 == null) goto L22;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(AutoDispose.bind(this));
        if (r9 == null) goto L23;
        r9.subscribe(new b(this));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r5 = false;
        goto L10
    }

    public final Function3<List<MusicPanel>, List<Object>, y, Unit> ms(List<? extends Object> r1) {
        return BusinessListSecondLevelTabFragment$getFillAdapterDataAction$1.INSTANCE;
    }

    public static final void X90(BusinessListSecondLevelTabFragment r1, t r2) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = r1.r;
        if (r3 == null) goto L7;
        MutableLiveData<vb0.a> r4 = r3.getOrderSongUiState();
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r4, BusinessListSecondLevelTabFragment$resetLoadState$1.INSTANCE);
    L7:
        r2.a = false;
    }

    public final void rs(SecondLevelTabViewSelectedType r8, y r9) {
        Intrinsics.checkNotNullParameter(r8, "secondLevelTabViewSelectedType");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r10 = ((BaseSecondLevelTabFragment) this).l;
        ModeType r0 = null;
        if (r10 == null) goto L7;
        Pair r11 = r10.getSelectedFirstLevelTabValue();
        if (r11 == null) goto L7;
        Integer r12 = (Integer) r11.getFirst();
    L8:
        if (r9 == null) goto L10;
        Integer r1 = Integer.valueOf(r9.k);
    L11:
        boolean r13 = Intrinsics.areEqual(r12, r1);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseSecondLevelTabFragment) this).l;
        if (r2 == null) goto L19;
        if (r9 == null) goto L15;
        int r3 = r9.k;
    L16:
        y r4 = r2.getSelectedSecondLevelTabData(r3);
        if (r4 == null) goto L19;
        String r5 = r4.c;
    L20:
        if (r9 == null) goto L22;
        String r6 = r9.c;
    L23:
        boolean r7 = Intrinsics.areEqual(r5, r6);
        if (r13 == false) goto L43;
        if (r7 == false) goto L43;
        if (r9 == null) goto L43;
        ALogger.i("BusinessListSecondLevelTabFragment", "onSecondLevelTabSelectStateChange ;; " + r9.d);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = this.r;
        if (r14 == null) goto L31;
        String r15 = r14.getCurSortType();
        if (r15 == null) goto L31;
    L32:
        int r16 = r9.k;
        String r17 = r9.d;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r18 = this.r;
        if (r18 == null) goto L38;
        td2.b r19 = r18.getOrderSongExtraInfo();
        if (r19 == null) goto L38;
        String r20 = r19.a;
        if (r20 == null) goto L38;
    L39:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r21 = this.r;
        if (r21 == null) goto L42;
        r0 = r21.getModeType();
    L42:
        KSongOrderSongUtilKt.m(r15, r16, r17, r20, r0);
    L38:
        r20 = "";
    L31:
        r15 = " ";
    L43:
        if (r13 == false) goto L47;
        if (r7 == false) goto L48;
        ((ItemExposureCheckHelper) this.p.getValue()).a(false);
        return;
    L48:
        return;
    L47:
        return;
    L22:
        r6 = null;
        goto L23
    L15:
        r3 = 0;
    L19:
        r5 = null;
        goto L20
    L10:
        r1 = null;
    L7:
        r12 = null;
        goto L8
    }

    public BusinessListSecondLevelTabFragment(final y r2, final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        super(r2, r3);
        this.r = r4;
        this.o = new LinkedHashMap();
        this.p = LazyKt.lazy(BusinessListSecondLevelTabFragment$itemExposureCheckHelper$2.INSTANCE);
        this.q = LazyKt.lazy(new BusinessListSecondLevelTabFragment$itemExposureListener$2(this, r2, r3));
    }
}
