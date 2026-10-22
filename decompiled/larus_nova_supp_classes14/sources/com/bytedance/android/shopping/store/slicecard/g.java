package com.bytedance.android.shopping.store.slicecard;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.m;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public g() {
    }

    public final void c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
    }

    public final ImageRequest b(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r2, "uri");
        ConcurrentHashMap<String, ImageRequest[]> r0 = c.a;
        String r3 = r2.toString();
        Intrinsics.checkNotNullParameter(r3, "key");
        ImageRequest[] r4 = c.a.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (ImageRequest) ArraysKt.firstOrNull(r4);
    }

    public final boolean a(Uri r9, SlcImageFetchManager r10, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r11, Object r12, SlcImageFetchManager.a r13) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        Intrinsics.checkNotNullParameter(r10, "imageManager");
        Intrinsics.checkNotNullParameter(r11, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r13, "callback");
        return m.a.d(r9, r10, r11, r12, r13, new ShopSlcImageLoaderHook$fetchImage$1(this));
    }
}
