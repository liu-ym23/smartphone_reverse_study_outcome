package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import dj3.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEmptyHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopEmptyHolder extends ECShopBaseHolder {
    public static final a q = null;

    public static final class a {
        public a() {
        }
    }

    static {
        q = new a();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        ej3.e.a r5 = ej3.e.b;
        if ((r3 instanceof ej3.e) == false) goto L6;
    L12:
        ej3.e r6 = (ej3.e) r3;
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.a != null) goto L18;
        return;
    L18:
        TextView r7 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387433);
        if (r7 == null) goto L22;
        r7.setText(r6.a);
        return;
    L22:
        return;
    L6:
        if ((r3 instanceof f) == true) goto L8;
        r3 = null;
    L8:
        f r8 = (f) r3;
        if (r8 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r8, "dto");
        ej3.e r9 = new ej3.e();
        r9.a = r8.a();
        r3 = r9;
        goto L12
    }

    public ECShopEmptyHolder(QUIManager r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3, r4);
    }
}
