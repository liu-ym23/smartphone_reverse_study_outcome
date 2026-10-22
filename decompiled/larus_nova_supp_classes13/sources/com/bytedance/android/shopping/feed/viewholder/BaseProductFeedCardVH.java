package com.bytedance.android.shopping.feed.viewholder;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.InflowCardBuyButton;
import com.bytedance.android.shopping.feed.widget.ProductFeedAbilityBarView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/BaseProductFeedCardVH;", "T", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseProductFeedCardVH<T> extends JediSimpleViewHolder<T> {
    public static final /* synthetic */ int s = 0;
    public final Lazy l;
    public rd3.a m;
    public final ProductFeedAbilityBarView.a n;
    public final Function3<View, String, String, Unit> o;
    public final Fragment p;
    public final ProductFeedAdapter q;
    public final BaseCardDetailView r;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseProductFeedCardVH a;

        public b(BaseProductFeedCardVH r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = ((RecyclerView.ViewHolder) this.a).itemView;     // Catch: Throwable -> L9
            if ((r0 instanceof BaseCardDetailView) == true) goto L5;
            r0 = null;
        L5:
            BaseCardDetailView r1 = (BaseCardDetailView) r0;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            r1.g();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public final ProductFeedViewModel c4() {
        return (ProductFeedViewModel) this.l.getValue();
    }

    public void d4(View r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onResume() {
        this.r.postDelayed(new b(this), 100);
    }

    public void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        rd3.a r0 = this.m;
        if (r0 == null) goto L6;
        this.n.a(r0);
        return;
    }

    public BaseProductFeedCardVH(JediBaseFragment r3, ProductFeedAdapter r4, BaseCardDetailView r5) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        super(r5);
        this.p = r3;
        this.q = r4;
        this.r = r5;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        final KClass r6 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        this.l = LazyKt.lazy(new BaseProductFeedCardVH$$special$$inlined$hostViewModel$1(this, r6, r6));
        this.n = new ProductFeedAbilityBarView.a(r4, r5.getBottomBarView().getAbilityViewView());
        this.o = new BaseProductFeedCardVH$productDetailOnClickListener$1(this);
    }

    public void b4(T r4, int r5, List<Object> r6) {
        if (r6 != null) goto L4;
    L31:
        a4(r4);
        return;
    L4:
        if ((!r6.isEmpty()) != true) goto L31;
        Object r1 = null;
        if ((ListProtector.get(r6, 0) instanceof Pair) == false) goto L16;
        Object r0 = ListProtector.get(r6, 0);
        if ((r0 instanceof Pair) == true) goto L10;
        r0 = null;
    L10:
        Pair r2 = (Pair) r0;
        if (r2 == null) goto L13;
        Object r3 = r2.getFirst();
    L14:
        if (r3 != null) goto L16;
        a4(r4);
        return;
    L13:
        r3 = null;
    L16:
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof BaseCardDetailView) == true) goto L19;
        r7 = null;
    L19:
        BaseCardDetailView r8 = (BaseCardDetailView) r7;
        if (r8 == null) goto L34;
        Object r9 = CollectionsKt.firstOrNull(r6);
        if ((r9 instanceof ActivityVO) == true) goto L24;
        r9 = null;
    L24:
        ActivityVO r10 = (ActivityVO) r9;
        View r11 = r8.k.g.getChildAt(0);
        if ((r11 instanceof InflowCardBuyButton) == false) goto L28;
        r1 = r11;
    L28:
        InflowCardBuyButton r12 = (InflowCardBuyButton) r1;
        if (r12 == null) goto L35;
        r12.setDepositPresaleAppointmentButtonText(r10);
        return;
    L35:
        return;
    }
}
