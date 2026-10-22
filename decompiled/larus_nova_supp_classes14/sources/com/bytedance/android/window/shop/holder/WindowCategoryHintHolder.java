package com.bytedance.android.window.shop.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowCategoryHintHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Ltq3/b;", "HintPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowCategoryHintHolder extends ShopWindowGenericHolder<tq3.b> {

    public static final class HintPresenter extends QPresenter {
        public final Lazy e;

        public HintPresenter() {
            this.e = LazyKt.lazy(new WindowCategoryHintHolder$HintPresenter$textView$2(this));
        }

        public final void A(QModel r3) {
            TextView r0 = (TextView) this.e.getValue();
            if (r0 != null) goto L6;
            return;
        L6:
            if ((r3 instanceof tq3.b) == true) goto L8;
            r3 = null;
        L8:
            tq3.b r4 = (tq3.b) r3;
            if (r4 != null) goto L11;
            return;
        L11:
            r0.setText(r4.j);
        }
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowCategoryHintHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        FrameLayout r0 = new FrameLayout(r5.requireContext());
        r0.addView(new AppCompatTextView(r5.requireContext()), -1, -2);
        Unit r1 = Unit.INSTANCE;
        super(r5, r0);
        View r6 = ((RecyclerView.ViewHolder) this).itemView;
        View r2 = null;
        if ((r6 instanceof FrameLayout) == true) goto L5;
        r6 = null;
    L5:
        FrameLayout r7 = (FrameLayout) r6;
        if (r7 != null) goto L8;
        return;
    L8:
        if (r7.getChildCount() == 0) goto L20;
        r7.setPadding(0, vf4.a.b(10), 0, vf4.a.b(20));
        View r8 = r7.getChildAt(0);
        if ((r8 instanceof TextView) == false) goto L14;
        r2 = r8;
    L14:
        TextView r3 = (TextView) r2;
        if (r3 == null) goto L19;
        r3.setGravity(17);
        r3.setTextColor(1461065763);
        r3.setTextSize(1, 12.0f);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new HintPresenter();
    }
}
