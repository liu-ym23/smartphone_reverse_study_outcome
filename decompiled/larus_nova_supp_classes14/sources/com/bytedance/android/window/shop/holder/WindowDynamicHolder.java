package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.dynamicview.common.j;
import com.bytedance.android.ec.window.base.dynamicview.renderer.impl.DynamicViewCache;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBasePresenter;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.h;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowDynamicHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/h;", "DynamicPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowDynamicHolder extends ShopWindowGenericHolder<h> {

    public static final class DynamicPresenter extends ECWindowHolderBasePresenter {
        public View g;
        public h h;
        public final j i;
        public final Lazy j;
        public so.d k;

        public final void C() {
            mo.b r0 = (mo.b) this.j.getValue();
            so.d r1 = this.k;
            h r2 = this.h;
            to.d r3 = null;
            if (r2 == null) goto L5;
            to.b r4 = r2.l;
        L6:
            r0.getClass();
            mo.b.b(r1, r4);
            so.d r5 = this.k;
            h r6 = this.h;
            if (r6 == null) goto L9;
            r3 = r6.k;
        L9:
            if (r5 == null) goto L15;
            if (r3 == null) goto L16;
            this.i.c(r5, r3);
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public DynamicPresenter(Fragment r4) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            ArrayList r1 = new ArrayList();
            fo.a<WindowLayoutType> r2 = WindowConstDef.a;
            if (WindowConstDef.s == false) goto L5;
            DynamicViewCache r5 = DynamicViewCache.d.a(r4);
        L6:
            this.i = new j(r1, r5);
            this.j = LazyKt.lazy(new WindowDynamicHolder$DynamicPresenter$eventHandler$2(this));
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void A(QModel r5) {
            View r1 = null;
            if ((r5 instanceof h) == true) goto L5;
            r5 = null;
        L5:
            this.h = (h) r5;
            View r6 = y();
            if ((r6 instanceof ViewGroup) == false) goto L9;
            r1 = r6;
        L9:
            ViewGroup r2 = (ViewGroup) r1;
            if (r2 != null) goto L12;
            return;
        L12:
            h r7 = this.h;
            if (r7 != null) goto L16;
            return;
        L16:
            if (r2.getChildCount() != 0) goto L18;
            k<? extends View, ?> r0 = r7.j;
            Context r3 = y().getContext();
            int r4 = k.f;
            View r8 = r0.d(r3, false);
            r2.addView(r8);
            this.g = r8;
            this.k = new so.d(r8);
        L18:
            so.d r9 = this.k;
            to.d r10 = r7.k;
            if (r9 == null) goto L24;
            if (r10 == null) goto L24;
            this.i.b(r9, r10);
        L24:
            so.d r11 = this.k;
            to.b r12 = r7.l;
            if (r11 == null) goto L31;
            if (r12 == null) goto L32;
            ((mo.b) this.j.getValue()).a(r11, r12);
            return;
        L32:
            return;
        }
    }

    public WindowDynamicHolder(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3, new FrameLayout(r3.requireContext()));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new DynamicPresenter(r2);
    }
}
