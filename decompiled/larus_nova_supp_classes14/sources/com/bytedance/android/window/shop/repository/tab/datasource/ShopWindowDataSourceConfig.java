package com.bytedance.android.window.shop.repository.tab.datasource;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import mq3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ShopWindowDataSourceConfig<T extends mq3.e> {
    public final Lazy a;
    public WindowTabDataListResponseDTODeprecated b;
    public WindowHybridTabDataListResponseDTO c;

    public abstract T a();

    public final T b() {
        return (T) this.a.getValue();
    }

    public ShopWindowDataSourceConfig() {
        this.a = LazyKt.lazy(new ShopWindowDataSourceConfig$reqParam$2(this));
    }
}
