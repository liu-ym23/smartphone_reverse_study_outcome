package com.bytedance.android.shopping.searchsimilar.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.y;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements y.b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Context b;

    public final void onFailure() {
        boolean r0 = f.a;
        f.a(this.b, this.a);
    }

    public final void onSuccess(DataSource<CloseableReference<CloseableImage>> r2) {
        boolean r3 = f.a;
        f.a(this.b, this.a);
    }

    public e(boolean r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
