package com.ss.android.ugc.aweme.search.filter.dynamic;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.commodity.select.BaseSelectItemView;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterContainerView;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/dynamic/ECSearchFilterAnimManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterAnimManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchFilterAnimManager f452905a = null;

    private ECSearchFilterAnimManager() {
    }

    static {
        f452905a = new ECSearchFilterAnimManager();
    }

    public static void a(RenderItem r110, final ECSearchFilterContainerView r111, int r112, int r113) {
        if (r110 != null) goto L4;
        return;
    L4:
        View r100 = r111.findViewById(R.id.search_filter_scroll_view);
        if ((r100 instanceof ViewGroup) == true) goto L8;
        r100 = null;
    L8:
        if (((ViewGroup) r100) != null) goto L10;
        return;
    L10:
        RenderLine r101 = r110.getRenderLine();
        if (r101 == null) goto L17;
        String r102 = r101.getWidthStrategy();
        if (r102 == null) goto L17;
        if (r102.equals(RenderLine.STRATEGY_TAB_QUICK_FILTER_COMBINED) != true) goto L17;
        boolean r103 = true;
    L18:
        int r114 = r112 - r113;
        if (r103 == false) goto L21;
        int r115 = DimenExtensionsKt.c(8);
    L22:
        int r116 = r114 - r115;
        Logger.d("FilterAnim", "use dynamic anim, isLeftFix = " + r103 + " offset = " + r116);
        RenderLine r117 = r110.getRenderLine();
        int r104 = -1;
        if (r117 == null) goto L36;
        List<RenderItem> r118 = r117.getRenderItemList();
        if (r118 == null) goto L36;
        Iterator<T> r119 = r118.iterator();
        int r105 = -1;
        int r106 = 0;
    L28:
        if (r119.hasNext() == false) goto L37;
        Object r107 = r119.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        if (Intrinsics.areEqual(((RenderItem) r107).getDataId(), r110.getDataId()) == false) goto L35;
        r105 = r106;
    L35:
        r106 = r108;
    L37:
        if (r105 >= 0) goto L39;
        return;
    L39:
        RenderLine r120 = r110.getRenderLine();
        if (r120 == null) goto L44;
        List<RenderItem> r121 = r120.getRenderItemList();
        if (r121 == null) goto L44;
        r104 = r121.size();
    L44:
        if (r104 >= 0) goto L47;
        return;
    L47:
        if (((r104 - r105) - 1) > 0) goto L49;
        return;
    L49:
        RenderLine r122 = r110.getRenderLine();
        if (r122 == null) goto L54;
        List<RenderItem> r123 = r122.getRenderItemList();
        if (r123 == null) goto L54;
        List<RenderItem> r124 = r123.subList(r105 + 1, r104);
    L55:
        final ArrayList r125 = new ArrayList();
        final ArrayList r109 = new ArrayList();
        if (r124 == null) goto L70;
        Iterator<T> r126 = r124.iterator();
    L59:
        if (r126.hasNext() == false) goto L70;
        RenderItem r127 = (RenderItem) r126.next();
        BaseSelectItemView r128 = r127.getRenderView();
        if ((r128 instanceof ECSearchBaseFilterViewHolder) == true) goto L63;
        r128 = null;
    L63:
        ECSearchBaseFilterViewHolder r129 = (ECSearchBaseFilterViewHolder) r128;
        if (r129 == null) goto L69;
        final View r130 = r129.f452782j;
        if (r130 == null) goto L78;
        Logger.d("FilterAnim", "doFilterAnim remove all views, dataId = " + r127.getDataId());
        ValueAnimator r131 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r131.setDuration(100);
        r131.setInterpolator(new LinearInterpolator());
        r131.addUpdateListener(new ECSearchFilterAnimManager$$special$$inlined$apply$lambda$1(r130));
        r125.add(r131);
        r109.add(r130);
        goto L59
    L78:
        return;
    L69:
        return;
    L70:
        Intrinsics.checkNotNullParameter(r111, "scrollView");
        r111.clearAnimation();
        final int r132 = r111.getScrollX();
        ValueAnimator r133 = ValueAnimator.ofInt(new int[]{0, r116});
        r133.setDuration(200);
        r133.setInterpolator(new LinearInterpolator());
        r133.addUpdateListener(new ECSearchFilterAnimManager$scrollAnimatorWithCustomDuration$$inlined$apply$lambda$1(r111, r132));
        r125.add(r133);
        AnimatorSet r134 = new AnimatorSet();
        r134.playTogether(r125);
        r134.addListener(new ECSearchFilterAnimManager$doFilterScrollAnim$$inlined$apply$lambda$1(r125, r109));
        r134.start();
        return;
    L54:
        r124 = null;
    L36:
        r105 = -1;
        goto L37
    L21:
        r115 = 0;
    L17:
        r103 = false;
        goto L18
    }
}
