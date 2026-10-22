package com.bytedance.ee.bear.drive.test.item;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements z85.a {
    public final Context a;

    @Override // z85.a
    public final View.OnClickListener a() {
        return new o(this);
    }

    @Override // z85.a
    public final String getButtonName() {
        return (String) this.a.getText(2131886256);
    }

    public q(Context r1) {
        this.a = r1;
    }
}
