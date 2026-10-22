package qq3;

import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.home.tab.common.WindowTabRequestParamKey;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.i;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends b<CategoryRequestParamKey> {
    public c() {
    }

    @Override // qq3.b
    public final com.bytedance.android.window.shop.repository.tab.datasource.impl.a d(WindowTabRequestParamKey r3) {
        CategoryRequestParamKey r4 = (CategoryRequestParamKey) r3;
        Intrinsics.checkNotNullParameter(r4, "key");
        Integer r0 = r4.getTabType();
        if (r0 == null) goto L9;
        if (r0.intValue() != 500) goto L9;
        return new i(r4.getCategoryId(), com.bytedance.android.window.shop.c.g);
    L9:
        return new i(r4.getCategoryId(), com.bytedance.android.window.shop.c.c);
    }

    @Override // qq3.b
    public final void j(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r4, WindowTabDataListResponseDTODeprecated r5, WindowLayoutType r6) {
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        Object r1 = null;
        if ((r4 instanceof i) == true) goto L5;
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r0 = null;
    L6:
        i r2 = (i) r0;
        if (r2 == null) goto L9;
        String r3 = r2.h;
    L10:
        if (r5 == null) goto L12;
        String r7 = r5.getSelectCategoryId();
    L14:
        if (Intrinsics.areEqual(r3, r7) == false) goto L16;
        r4.e.b = r5;
    L16:
        Object r8 = r4.e;
        if ((r8 instanceof com.bytedance.android.window.shop.repository.tab.datasource.d) == false) goto L20;
        r1 = r8;
    L20:
        com.bytedance.android.window.shop.repository.tab.datasource.d r9 = (com.bytedance.android.window.shop.repository.tab.datasource.d) r1;
        if (r9 == null) goto L24;
        r9.d = r6;
        return;
    L24:
        return;
    L12:
        r7 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = r4;
        goto L6
    }
}
