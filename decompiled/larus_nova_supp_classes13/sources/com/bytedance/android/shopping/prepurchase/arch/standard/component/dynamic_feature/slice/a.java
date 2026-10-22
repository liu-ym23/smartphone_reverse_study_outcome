package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.net.Uri;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public final /* synthetic */ b a;

    public final ImageRequest b(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    public a(b r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k r1 = (com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k) this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "controller");
        if (PdpMessageOpt.b() == false) goto L8;
        y r0 = (y) r1.c.getService(y.class);
        if (r0 == null) goto L9;
        r0.z1(r3);
        return;
    L9:
        return;
    }

    public final boolean a(Uri r8, SlcImageFetchManager r9, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r10, Object r11, SlcImageFetchManager.a r12) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        Intrinsics.checkNotNullParameter(r9, "imageManager");
        Intrinsics.checkNotNullParameter(r10, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r12, "callback");
        return com.bytedance.android.ec.core.imagex.m.a.a(r8, r9, r10, r11, r12);
    }
}
