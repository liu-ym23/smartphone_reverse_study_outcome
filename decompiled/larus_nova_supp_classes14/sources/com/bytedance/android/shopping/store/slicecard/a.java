package com.bytedance.android.shopping.store.slicecard;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.slicecard.a$a, reason: collision with other inner class name */
    public static final class C0017a {
        public static void a(SliceActionType r1, StoreV2ProductItemVO r2, View r3) {
            Intrinsics.checkNotNullParameter(r1, "actionType");
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "target");
        }

        public static void b(SliceActionType r1, ShopSlcProductItemV2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r1, "actionType");
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "target");
        }

        public static void c(StoreV2ProductItemVO r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r2, "target");
        }
    }

    void a(ShopSlcProductItemV2 r1, View r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4);

    void b(StoreV2ProductItemVO r1, View r2, Map<String, ? extends Object> r3);

    void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4);

    void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4);
}
