package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.StoreSizeConfig;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f4 {
    public y3 a;
    public wi3.a b;
    public e4 c;
    public final HashMap<ShopContainerType, vi3.b<? extends View>> d;
    public ECStoreParam e;
    public final Map<ShopContainerType, List<vi3.a>> f;
    public com.bytedance.android.shopping.store.home.entity.n g;
    public StoreSizeConfig h;

    public f4() {
        this.d = new HashMap();
        this.f = new LinkedHashMap();
    }

    public final void a(com.bytedance.android.shopping.store.home.entity.n r8, StoreSizeConfig r9) {
        Iterator<Map.Entry<ShopContainerType, vi3.b<? extends View>>> r0 = this.d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L30;
        Map.Entry<ShopContainerType, vi3.b<? extends View>> r1 = r0.next();
        wi3.a r2 = this.b;
        if (r2 == null) goto L4;
        ECStoreParam r3 = this.e;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("storeParams");
    L10:
        ShopContainerType r4 = r1.getKey();
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Intrinsics.checkNotNullParameter(r8, "headerInfo");
        Intrinsics.checkNotNullParameter(r4, "containerType");
        Intrinsics.checkNotNullParameter(r9, "storeSizeConfig");
        if (r4 != ShopContainerType.SHOP_TOPBAR_CONTAINER) goto L14;
        vi3.c r5 = new vi3.c(-1, ((Number) r9.s.getValue()).intValue(), new Rect());
    L21:
        if (r5 == null) goto L4;
        if (r1.getValue().a(r5, false) == false) goto L4;
        Map<ShopContainerType, List<vi3.a>> r6 = this.f;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        List r10 = (List) r7.get(r1.getKey());
        if (r10 == null) goto L4;
        Iterator r11 = r10.iterator();
    L28:
        if (r11.hasNext() == false) goto L4;
        ((vi3.a) r11.next()).a(r1.getKey(), r5);
        goto L28
    L14:
        if (r4 == ShopContainerType.LIVE_PREVIEW_CONTAINER) goto L16;
        r5 = vi3.c.f;
        goto L21
    L16:
        if (r3.isRedMan() == false) goto L18;
        int r12 = wi3.c.a(2131166436, r2.a);
    L19:
        dm.a.a("shop_frame").w("transform update livePreview config", null);
        r5 = new vi3.c(-1, r12);
        goto L21
    L18:
        r12 = wi3.c.a(2131166435, r2.a);
        goto L19
    }

    public final void update(com.bytedance.android.shopping.store.home.entity.n r5, StoreSizeConfig r6, ECStoreParam r7) {
        Intrinsics.checkNotNullParameter(r5, "headerInfo");
        Intrinsics.checkNotNullParameter(r6, "storeSizeConfig");
        Intrinsics.checkNotNullParameter(r7, "storeParams");
        this.e = r7;
        y3 r0 = this.a;
        if (r0 == null) goto L5;
        e4 r8 = r0.a(r7, r5);
    L6:
        dm.a.b r1 = dm.a.a("shop_frame");
        StringBuilder r2 = new StringBuilder("update, frameTransformer=");
        r2.append(this.a);
        r2.append(", containerMapIsEmpty=");
        r2.append(this.d.isEmpty());
        r2.append(", newFrameConfig=");
        r2.append(r8);
        r2.append(", update:");
        r2.append(!Intrinsics.areEqual(r8, this.c));
        r1.w(r2.toString(), null);
        if ((!Intrinsics.areEqual(r8, this.c)) == false) goto L10;
        this.c = r8;
    L10:
        if (this.d.isEmpty() == false) goto L13;
        this.g = r5;
        this.h = r6;
        return;
    L13:
        a(r5, r6);
        this.g = null;
        this.h = null;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
