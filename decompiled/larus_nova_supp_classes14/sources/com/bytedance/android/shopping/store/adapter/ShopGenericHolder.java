package com.bytedance.android.shopping.store.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.ShopItemViewHolder;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pn.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/adapter/ShopGenericHolder;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "T", "Lcom/bytedance/android/ec/store/product/holder/ShopItemViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopGenericHolder<T extends QModel> extends ShopItemViewHolder<T> {
    public final QUIManager a;
    public final Lazy b;
    public final Function1<T, QModel> c;

    public ShopGenericHolder() {
        throw null;
    }

    public abstract QIPresenter V3(Fragment r1);

    public final void T3(T r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        Unit r0 = (Unit) this.b.getValue();
        QUIManager r1 = this.a;
        QModel r4 = (QModel) this.c.invoke(r3);
        Intrinsics.checkNotNullParameter(r1, "$this$bindGeneric");
        r1.c(a.class, r4);
    }

    public ShopGenericHolder(final Fragment r3, final View r4) {
        Function1<T, QModel> r0 = (Function1<T, QModel>) ShopGenericHolderKt.a;
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r0, "modelTransformer");
        super(r4);
        this.c = r0;
        this.a = new QUIManager();
        this.b = LazyKt.lazy(new ShopGenericHolder$initMgrOnceHelper$2(this, r4, r3));
    }
}
