package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public View a;
    public RecyclerView b;
    public View c;
    public int d;
    public float e;
    public final int f;
    public final int g;
    public final int h;
    public final Context i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(ECGalleryActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.i = r2;
        int r0 = com.bytedance.android.shopping.extensions.b.b(32);
        this.g = r0;
        int r3 = k1.n(r2);
        this.h = r3;
        this.f = (r3 - (r0 * 2)) / 2;
    }
}
