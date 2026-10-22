package com.bytedance.android.window.shop.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "T", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopWindowGenericHolder<T extends f> extends ShopWindowItemHolder<T> {
    public final QUIManager q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Function1<T, QModel> u;

    public abstract QIPresenter u4(Fragment r1);

    public boolean v4() {
        return ((Boolean) this.s.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void t4() {
        com.bytedance.android.ec.window.base.utils.quick.f.b(this.q);
        if (v4() == false) goto L16;
        this.q.r(a.class);
        ViewGroup r0 = (ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371316);
        if (r0 == null) goto L12;
        List r1 = com.bytedance.commerce.base.view.b.a(r0);
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((View) r2.next()).setVisibility(8);
    L12:
        if (r0 == null) goto L17;
        r0.setPadding(0, 0, 0, 0);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public void q4(T r5) {
        Intrinsics.checkNotNullParameter(r5, "vo");
        Unit r0 = (Unit) this.r.getValue();
        if (v4() == false) goto L17;
        Unit r1 = (Unit) this.t.getValue();
        ViewGroup r2 = (ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371316);
        if (r2 == null) goto L7;
        r2.setVisibility(0);
    L7:
        v r3 = r5.a;
        if (r3 != null) goto L10;
    L14:
        if (r2 == null) goto L16;
        r2.setPadding(0, 0, 0, 0);
    L16:
        this.q.c(a.class, r5.a);
        goto L17
    L10:
        if (r3.e() == true) goto L14;
        if (r2 == null) goto L16;
        r2.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, 0);
    L17:
        com.bytedance.android.ec.window.base.utils.quick.f.a(this.q, (QModel) this.u.invoke(r5));
    }

    public /* synthetic */ ShopWindowGenericHolder(Fragment r2, View r3) {
        this(r2, r3, WindowGenericHolderKt.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopWindowGenericHolder(final Fragment r2, final View r3, Function1<? super T, ? extends QModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "modelTransformer");
        super(r3);
        this.u = r4;
        this.q = new QUIManager();
        this.r = LazyKt.lazy(new ShopWindowGenericHolder$initMgrOnceHelper$2(this, r3, r2));
        this.s = LazyKt.lazy(new ShopWindowGenericHolder$hasExtensionModule$2(this));
        this.t = LazyKt.lazy(new ShopWindowGenericHolder$initLynxExtensionMgrOnceHelper$2(this, r2));
    }
}
