package com.bytedance.ee.bear.contract.route.parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i extends com.bytedance.ee.bear.browser.plugin.i {

    public interface a {
        void onLoadFail();

        void onLoadStart();

        void onLoadSuccess();
    }

    void addLoadingCallback(a r1);
}
