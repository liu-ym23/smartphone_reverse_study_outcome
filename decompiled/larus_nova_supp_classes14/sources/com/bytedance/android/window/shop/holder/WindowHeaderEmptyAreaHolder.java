package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHeaderEmptyAreaHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Loq3/f;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderEmptyAreaHolder extends ShopWindowItemHolder<f> {

    public static final class a extends View {
        @Override // android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r1) {
            return false;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    public WindowHeaderEmptyAreaHolder(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(new a(r2.requireContext()));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(com.bytedance.android.window.shop.repository.tab.entity.f r5) {
        f r6 = (f) r5;
        Intrinsics.checkNotNullParameter(r6, "vo");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r1.height = com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(r6.j));
        Unit r7 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
    }
}
