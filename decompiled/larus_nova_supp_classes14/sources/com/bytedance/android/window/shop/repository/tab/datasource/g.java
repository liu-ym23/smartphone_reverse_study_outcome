package com.bytedance.android.window.shop.repository.tab.datasource;

import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends ShopWindowDataSourceConfig<WindowProductTabRequestParam> {
    public boolean d;

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig
    public final mq3.e a() {
        return new WindowProductTabRequestParam();
    }

    public g() {
        this.d = true;
    }
}
