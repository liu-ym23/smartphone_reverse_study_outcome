package com.bytedance.android.shopping.store.hybridproduct;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopProductCardHolderNew;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/ShopItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopItemAnimator extends DefaultItemAnimator {
    public final List<String> a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ECShopProductCardHolderNew a;

        public a(ECShopProductCardHolderNew r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            ((RecyclerView.ViewHolder) this.a).itemView.getLayoutParams().height = ((Integer) r3).intValue();
            ((RecyclerView.ViewHolder) this.a).itemView.requestLayout();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public ShopItemAnimator() {
        this.a = new ArrayList();
    }

    public final boolean animateChange(RecyclerView.ViewHolder r4, RecyclerView.ViewHolder r5, RecyclerView.ItemAnimator.ItemHolderInfo r6, RecyclerView.ItemAnimator.ItemHolderInfo r7) {
        Intrinsics.checkNotNullParameter(r4, "oldHolder");
        Intrinsics.checkNotNullParameter(r5, "newHolder");
        Intrinsics.checkNotNullParameter(r6, "preInfo");
        Intrinsics.checkNotNullParameter(r7, "postInfo");
        if ((r5 instanceof ECShopProductCardHolderNew) == true) goto L5;
        r5 = null;
    L5:
        ECShopProductCardHolderNew r8 = (ECShopProductCardHolderNew) r5;
        if (r8 != null) goto L8;
    L15:
        return false;
    L8:
        if (CollectionsKt.contains(this.a, r8.r) == false) goto L15;
        List<String> r9 = this.a;
        String r10 = r8.r;
        if (r9 == null) goto L14;
        TypeIntrinsics.asMutableCollection(r9).remove(r10);
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{0, ((RecyclerView.ViewHolder) r8).itemView.getHeight()});
        r11.setDuration(175);
        r11.setInterpolator(new LinearInterpolator());
        r11.addUpdateListener(new a(r8));
        ObjectAnimator r12 = ObjectAnimator.ofFloat(((RecyclerView.ViewHolder) r8).itemView, "alpha", new float[]{0.0f, 1.0f});
        r12.setDuration(150);
        r11.start();
        r12.start();
        return true;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
}
