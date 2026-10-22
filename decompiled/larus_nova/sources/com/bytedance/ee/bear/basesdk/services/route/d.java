package com.bytedance.ee.bear.basesdk.services.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.route.h;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f206683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<? extends Activity> f206684b;

    @Override // com.bytedance.ee.bear.route.h.b
    public final Intent a() {
        return new Intent(this.f206683a, this.f206684b);
    }

    public d(Context r100, Class<? extends Activity> r101) {
        this.f206683a = r100;
        this.f206684b = r101;
    }
}
