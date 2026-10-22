package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.holder.presenter.WindowReplayStructElementPresenter;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;
import sq3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleSamePriceProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/j;", "PriceDiscountElementPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleSamePriceProductHolder extends ShopWindowGenericHolder<j> {

    public static final class PriceDiscountElementPresenter extends com.bytedance.android.ec.window.base.utils.quick.c<j> {
        public final Lazy e;
        public final Lazy f;

        public PriceDiscountElementPresenter() {
            this.e = LazyKt.lazy(new WindowHotsaleSamePriceProductHolder$PriceDiscountElementPresenter$originPriceTextView$2(this));
            this.f = LazyKt.lazy(new WindowHotsaleSamePriceProductHolder$PriceDiscountElementPresenter$discountTagElementTextView$2(this));
        }

        public final void D(QModel r13) {
            j r14 = (j) r13;
            if (r14 == null) goto L6;
            ViewGroup r0 = (ViewGroup) y().findViewById(2131393295);
            GradientDrawable r1 = new GradientDrawable();
            r1.setColor((int) 4294963696L);
            r1.setCornerRadius(q.a(14));
            com.bytedance.android.ec.window.base.utils.c.d(r0, r1);
        L6:
            String r2 = null;
            if (r14 == null) goto L11;
            h r3 = r14.j;
            if (r3 == null) goto L11;
            Long r4 = ((WindowV2ProductItemVO) r3).k;
        L12:
            if (r14 == null) goto L16;
            h r5 = r14.j;
            if (r5 == null) goto L16;
            Long r6 = Long.valueOf(((WindowV2ProductItemVO) r5).j);
        L17:
            boolean r7 = Intrinsics.areEqual(r4, r6);
            if (r4 == null) goto L31;
            if (r7 == true) goto L31;
            TextView r8 = (TextView) this.e.getValue();
            if (r8 == null) goto L24;
            r8.setVisibility(0);
        L24:
            TextView r9 = (TextView) this.e.getValue();
            if (r9 == null) goto L34;
            long r10 = r4.longValue();
            long r11 = 100;
            long r12 = r10 % r11;
            if (r12 != 0) goto L29;
            String r15 = "¥" + (r10 / r11);
        L30:
            r9.setText(r15);
            goto L34
        L29:
            r15 = "¥" + (r10 / r11) + '.' + r12;
        L34:
            if (r14 == null) goto L49;
            h r16 = r14.j;
            if (r16 == null) goto L49;
            List r17 = r16.g("hot_living_sellpoint");
            if (r17 == null) goto L49;
            ArrayList r18 = new ArrayList();
            Iterator r19 = r17.iterator();
        L41:
            if (r19.hasNext() == false) goto L48;
            List r20 = ((ECRitTag) r19.next()).getText();
            if (r20 == null) goto L45;
            String r21 = (String) CollectionsKt.firstOrNull(r20);
        L46:
            if (r21 == null) goto L41;
            r18.add(r21);
            goto L41
        L45:
            r21 = null;
            goto L46
        L48:
            r2 = CollectionsKt.joinToString$default(r18, "｜", null, null, 0, null, null, 62, null);
        L49:
            if (r2 != null) goto L51;
            r2 = "";
        L51:
            TextView r110 = (TextView) this.f.getValue();
            if (r110 == null) goto L60;
            r110.setText(r2);
            return;
        L60:
            return;
        L31:
            TextView r22 = (TextView) this.e.getValue();
            if (r22 == null) goto L34;
            r22.setVisibility(8);
        L16:
            r6 = null;
        L11:
            r4 = null;
            goto L12
        }
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleSamePriceProductHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131561023, null, 4), AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r5) {
        if (getLayoutPosition() != 0) goto L7;
        return new Rect(d.a(12), d.a(4), d.a(12), d.a(8));
    L7:
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        WindowReplayStructElementPresenter r0 = new WindowReplayStructElementPresenter(r5, 307);
        com.bytedance.android.window.shop.product.presenter.group.c r1 = new com.bytedance.android.window.shop.product.presenter.group.c(CollectionsKt.listOf(r0));
        com.bytedance.android.ec.window.base.utils.quick.b r2 = new com.bytedance.android.ec.window.base.utils.quick.b();
        com.bytedance.android.window.shop.product.presenter.group.a r3 = new com.bytedance.android.window.shop.product.presenter.group.a(r5, r1);
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r5));
        r3.d0(new ECWindowProductCardRecommendInfoElementPresenter(r5));
        r3.d0(new ECWindowProductCardTagInfoElementPresenter(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.mainimage.a(r5));
        r3.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r5));
        r2.b(r3, WindowHotsaleSamePriceProductHolder$generatePresenter$1.INSTANCE);
        r2.a(new PriceDiscountElementPresenter());
        WindowHotsaleSamePriceProductHolder$generatePresenter$2 r6 = WindowHotsaleSamePriceProductHolder$generatePresenter$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "presenter");
        Intrinsics.checkNotNullParameter(r6, "transformer");
        r2.c(r0, r6);
        return r2;
    }
}
