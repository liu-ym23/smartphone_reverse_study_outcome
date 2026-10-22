package com.bytedance.ee.bear.drive.test.item;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements z85.a {
    public final Context a;

    @Override // z85.a
    public final String getButtonName() {
        return "第三方附件预览";
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        return new r(this);
    }

    public u(Context r1) {
        this.a = r1;
    }
}
