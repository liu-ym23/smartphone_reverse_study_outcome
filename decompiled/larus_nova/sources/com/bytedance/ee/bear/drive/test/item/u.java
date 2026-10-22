package com.bytedance.ee.bear.drive.test.item;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class u implements z85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f224696a;

    @Override // z85.a
    public final String getButtonName() {
        return "第三方附件预览";
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        return new r(this);
    }

    public u(Context r100) {
        this.f224696a = r100;
    }
}
