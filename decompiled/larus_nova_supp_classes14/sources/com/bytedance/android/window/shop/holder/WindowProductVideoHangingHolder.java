package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.title.ECWindowProductCardTitleElementDefaultPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.shopping.api.window.AwemeInfo;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHangingVideoElementPresenter;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.WindowEventContext;
import com.bytedance.android.window.shop.home.tab.event.WindowProductHangingVideoCardEvent;
import com.bytedance.android.window.shop.product.presenter.group.ECWindowNoEventProductGroupPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.o;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowProductVideoHangingHolder;", "Ltp/c;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/o;", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductVideoHangingHolder extends ShopWindowGenericHolder<o> implements tp.c {
    public static final /* synthetic */ int B = 0;
    public final vp.c A;
    public final ECWindowNoEventProductGroupPresenter v;
    public final com.bytedance.android.window.shop.holder.presenter.a w;
    public final a x;
    public final ECWindowHangingVideoElementPresenter y;
    public final WindowLayoutType z;

    public final class a extends ECWindowHolderBaseFragmentPresenter {
        public o i;
        public final /* synthetic */ WindowProductVideoHangingHolder j;

        public final void c0() {
            this.i = null;
        }

        public final void b0(final QModel r6) {
            final BaseWindowTabViewModel r0 = gr3.c.a(Y(), ((QFragmentPresenter) this).e);
            boolean r1 = r6 instanceof o;
            if (r1 == true) goto L5;
            QModel r3 = null;
        L6:
            this.i = (o) r3;
            if (r1 == true) goto L9;
            QModel r4 = null;
        L10:
            o r5 = (o) r4;
            if (r5 == null) goto L32;
            if (r5.n == false) goto L30;
            fo.a<Set<String>> r7 = wn.a.m;
            if (r1 == true) goto L18;
            QModel r2 = null;
        L19:
            o r8 = (o) r2;
            if (r8 == null) goto L24;
            AwemeInfo r9 = r8.e();
            if (r9 == null) goto L24;
            String r10 = r9.a();
        L25:
            if (r10 != null) goto L28;
            r10 = "";
        L28:
            if (r0.shouldReportEvent(r7, r10) == false) goto L32;
            r0.runLowPriorityTask(new WindowProductVideoHangingHolder$ActionPresenter$reportVideoShowEvent$1(this, r6));
        L24:
            r10 = null;
            goto L25
        L18:
            r2 = r6;
            goto L19
        L30:
            r0.runLowPriorityTask(new WindowProductVideoHangingHolder$ActionPresenter$reportVideoShowEvent$2(this, r0, r6));
        L32:
            if (a0().hasOnClickListeners() == true) goto L36;
            f.c(a0(), null, "bind_store_product_card", new WindowProductVideoHangingHolder$ActionPresenter$initClickOnce$1(this, r0), 1);
            f.c(a0().findViewById(2131371327), null, "bind_store_product_card", new WindowProductVideoHangingHolder$ActionPresenter$initClickOnce$2(this, r0), 1);
            return;
        L36:
            return;
        L9:
            r4 = r6;
            goto L10
        L5:
            r3 = r6;
            goto L6
        }

        public a(WindowProductVideoHangingHolder r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            this.j = r2;
            super(r3);
        }
    }

    public static final class b extends ECWindowProductCardTitleElementDefaultPresenter {
        public b(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
        }

        public final String h0(WindowV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            String r0 = r4.e;
            if (r0 != null) goto L5;
        L7:
            r0 = null;
        L8:
            if (r0 == null) goto L10;
            return r0;
        L10:
            return r4.d;
        L5:
            if ((!StringsKt.isBlank(r0)) == false) goto L7;
            goto L7
        }
    }

    public final void B() {
        this.A.B();
    }

    public final boolean D3() {
        return this.A.D3();
    }

    public final void R() {
        this.A.R();
    }

    public final boolean g0() {
        return this.A.g0();
    }

    public final boolean isPlaying() {
        return this.A.isPlaying();
    }

    public final tp.b m() {
        return this.A.m();
    }

    public final void o2(tp.b r2) {
        this.A.o2(r2);
    }

    public final Rect r() {
        this.A.getClass();
        return null;
    }

    public final void startPlay() {
        this.A.startPlay();
    }

    public final void stopPlay() {
        this.A.stopPlay();
    }

    public final void v() {
        this.A.v();
    }

    public final void M() {
        vp.c r0 = this.A;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.A.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.A;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.A;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.A;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        WindowLayoutType r0 = this.z;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSingleColumn() != true) goto L7;
        return true;
    }

    public final void x() {
        vp.c r0 = this.A;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.A;
        r0.getClass();
        tp.c.a.d(r0);
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.y.L(r2);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L10;
        if ((r8.getSpanIndex() % 2) != 1) goto L8;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L8:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        com.bytedance.android.ec.window.base.utils.quick.b r4 = new com.bytedance.android.ec.window.base.utils.quick.b();
        r4.b(this.v, WindowProductVideoHangingHolder$generatePresenter$1.INSTANCE);
        r4.b(this.y, WindowProductVideoHangingHolder$generatePresenter$2.INSTANCE);
        r4.b(this.w, WindowProductVideoHangingHolder$generatePresenter$3.INSTANCE);
        r4.a(this.x);
        return r4;
    }

    public WindowProductVideoHangingHolder(Fragment r7, WindowLayoutType r8) {
        vp.c r0 = new vp.c();
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r0, "playableProxy");
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = r7.requireContext();
        r1.getClass();
        ShoppingAsyncInflater r3 = ShoppingAsyncInflater.a.a(r2);
        boolean r4 = true;
        if (r8 != null) goto L5;
    L7:
        int r5 = 2131560901;
    L8:
        super(r7, com.bytedance.android.ec.opt.asyncInflate.c.a(r3, r5, null, 4));
        this.z = r8;
        this.A = r0;
        if (r8 != null) goto L11;
    L13:
        ECWindowNoEventProductGroupPresenter r6 = new ECWindowNoEventProductGroupPresenter(r7, WindowLayoutType.SINGLECOLUMN);
        r6.d0(new com.bytedance.android.ec.window.base.product.presenter.element.mainimage.a(r7));
        r6.d0(new b(r7));
        r6.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.b(r7));
        if (r8 != null) goto L16;
    L18:
        this.v = r6;
        this.w = new com.bytedance.android.window.shop.holder.presenter.a(r8);
        this.x = new a(this, r7);
        if (r8 != null) goto L21;
    L23:
        r4 = false;
    L24:
        this.y = new ECWindowHangingVideoElementPresenter(r0, r4);
        return;
    L21:
        if (r8.isSingleColumn() != true) goto L23;
    L16:
        if (r8.isSingleColumn() != true) goto L18;
        r6.d0(new ECWindowProductCardRecommendInfoElementPresenter(r7));
        goto L18
    L11:
        if (r8.isDoubleColumn() != true) goto L13;
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387407)).setTypeface(Typeface.DEFAULT_BOLD);
        goto L13
    L5:
        if (r8.isSingleColumn() != true) goto L7;
        r5 = 2131560902;
        goto L8
    }

    public static final void w4(WindowProductVideoHangingHolder r0, String r1, o r2, WindowEventContext r3) {
        r0.getClass();
        if (r2 == null) goto L7;
        new WindowProductHangingVideoCardEvent(r1).fillWith(r2).with(new BaseEventContext[]{r3}).post(null, null);
        return;
    }
}
