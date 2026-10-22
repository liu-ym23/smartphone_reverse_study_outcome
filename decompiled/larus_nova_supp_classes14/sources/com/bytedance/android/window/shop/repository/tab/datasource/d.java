package com.bytedance.android.window.shop.repository.tab.datasource;

import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParamDeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends ShopWindowDataSourceConfig<WindowProductTabRequestParamDeprecated> {
    public WindowLayoutType d;
    public boolean e;

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig
    public final mq3.e a() {
        return new WindowProductTabRequestParamDeprecated();
    }

    public d() {
        this.e = true;
    }
}
