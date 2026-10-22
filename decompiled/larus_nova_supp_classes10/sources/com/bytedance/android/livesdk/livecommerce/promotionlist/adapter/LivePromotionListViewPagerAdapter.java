package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.ToggleElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/LivePromotionListViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListViewPagerAdapter extends PagerAdapter {
    public final Toggle a;
    public final Function1<Integer, View> b;

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "object");
    }

    public final float getPageWidth(int r1) {
        return 0.9706f;
    }

    public final int getCount() {
        List<ToggleElement> r0 = this.a.getElements();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.size();
    }

    public final CharSequence getPageTitle(int r2) {
        List<ToggleElement> r0 = this.a.getElements();
        if (r0 == null) goto L7;
        ToggleElement r3 = (ToggleElement) ListProtector.get(r0, r2);
        if (r3 == null) goto L7;
        return r3.getText();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePromotionListViewPagerAdapter(Toggle r2, Function1<? super Integer, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r2, "toggle");
        Intrinsics.checkNotNullParameter(r3, "getPageView");
        this.a = r2;
        this.b = r3;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        View r4 = (View) this.b.invoke(Integer.valueOf(r3));
        r2.addView(r4);
        return r4;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "o");
        return Intrinsics.areEqual(r2, r3);
    }
}
