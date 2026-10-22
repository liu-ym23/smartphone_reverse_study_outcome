package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowStoreListBgPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public ViewGroup f;
    public ViewGroup g;
    public ECHybridListContainer h;
    public float i;
    public final Lazy j;
    public final Class<T> k;

    public static final class a {
    }

    static {
    }

    public final T h0() {
        return (T) this.j.getValue();
    }

    public final Map<String, Object> e0() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("skin", h0().getPageParams().get(BaseFollowStoreViewModel.KEY_SKIN_INFO));
        r0.put("theme", h0().getPageParams().get(BaseFollowStoreViewModel.KEY_APP_THEME));
        return r0;
    }

    public final void b0(QModel r14) {
        this.f = (ViewGroup) Z().b(2131374302).f();
        this.g = (ViewGroup) Z().b(2131372582).f();
        this.h = Z().b(2131370738).f();
        if (h0().isDoubleRaw() == true) goto L11;
        ViewGroup r15 = this.f;
        if (r15 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L7:
        r15.setVisibility(8);
        ViewGroup r16 = this.g;
        if (r16 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L10:
        r16.setVisibility(8);
        return;
    L11:
        hj3.g r17 = h0().getMomentConfig();
        String r3 = null;
        if (r17 == null) goto L14;
        String r18 = r17.b();
    L15:
        boolean r4 = true;
        if (r18 != null) goto L18;
    L21:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L28;
        ViewGroup r7 = this.f;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L27:
        ECLynxCard r0 = new ECLynxCard();
        ECLynxLoadParam.a r11 = new ECLynxLoadParam.a(a0().getContext(), r18, r7);
        r11.j(2000);
        d r19 = new d(r0, r7);
        Intrinsics.checkNotNullParameter(r19, "lifecycle");
        r11.o = r19;
        r11.h(h0().getSceneId());
        Map<String, Object> r110 = e0();
        Intrinsics.checkNotNullParameter(r110, "ecGlobalProps");
        r11.p = r110;
        r0.j(new ECLynxLoadParam(r11));
    L32:
        hj3.g r111 = h0().getMomentConfig();
        if (r111 == null) goto L35;
        r3 = r111.d();
    L35:
        if (r3 != null) goto L37;
    L40:
        if (r4 == true) goto L48;
        ViewGroup r112 = this.g;
        if (r112 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L44:
        r112.setVisibility(0);
        ViewGroup r113 = this.g;
        if (r113 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L47:
        ECLynxCard r1 = new ECLynxCard();
        ECLynxLoadParam.a r2 = new ECLynxLoadParam.a(a0().getContext(), r3, r113);
        r2.j(2000);
        e r5 = new e(r1, r113);
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        r2.o = r5;
        r2.h(h0().getSceneId());
        Map<String, Object> r114 = e0();
        Intrinsics.checkNotNullParameter(r114, "ecGlobalProps");
        r2.p = r114;
        r1.j(new ECLynxLoadParam(r2));
    L52:
        final ECHybridListContainer r115 = this.h;
        if (r115 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L55:
        r115.getRecyclerView().addOnScrollListener(new BaseFollowStoreListBgPresenter$initBgView$$inlined$let$lambda$1(r115, this));
        h0().getResponse().b(ECQuickUtilKt.a(Y()), new c(this));
        return;
    L48:
        ViewGroup r116 = this.g;
        if (r116 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L51:
        r116.setVisibility(8);
        goto L52
    L37:
        if (StringsKt.isBlank(r3) == true) goto L40;
        r4 = false;
        goto L40
    L28:
        ViewGroup r117 = this.f;
        if (r117 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L31:
        r117.setVisibility(8);
        goto L32
    L18:
        if (StringsKt.isBlank(r18) == true) goto L21;
        r6 = false;
        goto L23
    L14:
        r18 = null;
        goto L15
    }

    public BaseFollowStoreListBgPresenter(Fragment r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.k = r3;
        this.j = LazyKt.lazy(new BaseFollowStoreListBgPresenter$viewModel$2(this));
    }

    public static final void d0(BaseFollowStoreListBgPresenter r10, ECHybridListEngine r11) {
        r10.getClass();
        ExposeLinearLayoutManagerEx r0 = r11.b.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(r0.findFirstVisibleItemPosition());
    L8:
        int r2 = com.bytedance.android.shopping.extensions.k.f(r1);
        if (r0 == null) goto L11;
        Integer r3 = Integer.valueOf(r0.findLastVisibleItemPosition());
    L12:
        int r4 = com.bytedance.android.shopping.extensions.k.f(r3);
        ECHybridListItemVO r5 = r11.h(r2 - 1);
        ECHybridListItemVO r6 = r11.h(r2);
        ECHybridListItemVO r7 = r11.h(RangesKt.coerceAtMost(r2 + 1, r4));
        if (r6 == null) goto L35;
        Integer r8 = r6.c;
        if (r8 != null) goto L19;
    L31:
        ViewGroup r9 = r10.f;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L34:
        r9.setVisibility(8);
        goto L35
    L19:
        if (r8.intValue() != 50103) goto L31;
        String r12 = r6.d;
        if (r12 == null) goto L35;
        BaseViewHolder r13 = r11.e(null, r12);
        if (r13 == null) goto L35;
        ViewGroup r14 = r10.f;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L27:
        r14.setVisibility(0);
        ViewGroup r15 = r10.f;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L30:
        r15.setY(((RecyclerView.ViewHolder) r13).itemView.getY());
    L35:
        if (r6 == null) goto L37;
        Integer r16 = r6.c;
    L38:
        if (r16 != null) goto L41;
    L43:
        ViewGroup r17 = r10.g;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L46:
        r17.setY(r11.b.getY());
        if (r5 == null) goto L55;
        Integer r18 = r5.c;
        if (r18 != null) goto L52;
    L54:
        boolean r19 = false;
    L56:
        if (r19 == false) goto L73;
        if (r6 == null) goto L74;
        String r20 = r6.d;
        if (r20 == null) goto L75;
        BaseViewHolder r21 = r11.e(null, r20);
        if (r21 == null) goto L76;
        ViewGroup r22 = r10.g;
        if (r22 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L65:
        r22.setVisibility(0);
        ViewGroup r23 = r10.g;
        if (r23 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("firstContentCardBg");
    L68:
        float r24 = ((RecyclerView.ViewHolder) r21).itemView.getY();
        ViewGroup r25 = r10.f;
        if (r25 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L71:
        Context r26 = r25.getContext();
        float r110 = r10.i;
        Lazy r27 = CommonUtilKt.a;
        Intrinsics.checkNotNullParameter(r26, "context");
        Resources r28 = r26.getResources();
        r23.setY(RangesKt.coerceAtLeast(r24 - ((int) TypedValue.applyDimension(1, r110, WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics()))), r11.b.getY()));
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L52:
        if (r18.intValue() != 50103) goto L54;
    L55:
        r19 = true;
        goto L56
    L41:
        if (r16.intValue() != 50103) goto L43;
        r6 = r7;
        goto L43
    L37:
        r16 = null;
        goto L38
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = null;
        goto L8
    }
}
