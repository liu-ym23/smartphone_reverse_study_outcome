package com.bytedance.ee.bear.drive.view.preview.excel;

import android.content.Context;
import com.bytedance.ee.bear.drive.cache.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final t a;
    public final q75.a b;
    public final ExcelCacheHelper c;
    public final a95.a d;

    public b(t r1, Context r2, a95.a r3) {
        this.a = r1;
        this.d = r3;
        this.b = o75.b.a().getDriveConfig();
        this.c = new ExcelCacheHelper();
    }
}
