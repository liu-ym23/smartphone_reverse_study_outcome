package com.bytedance.android.window.shop.widget;

import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements com.bytedance.android.ec.window.base.common.bubble.g {
    public final /* synthetic */ SubCategoryView a;
    public final /* synthetic */ String b;

    public final void onDismiss() {
    }

    public final void onShow() {
        SharedPrefExtKt.putBoolean(SharedPrefExtKt.getSharePref(this.a.getContext(), "ec_window_live_point"), this.b, true);
    }

    public m(SubCategoryView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
