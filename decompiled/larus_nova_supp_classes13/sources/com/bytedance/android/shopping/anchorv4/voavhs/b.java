package com.bytedance.android.shopping.anchorv4.voavhs;

import android.net.Uri;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.imagex.m;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public final /* synthetic */ AnchorV4Adapter a;

    public final ImageRequest b(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    public b(AnchorV4Adapter r1) {
        this.a = r1;
    }

    public final void c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        if (PdpMessageOpt.b() == false) goto L6;
        PdpMessageOpt.a(this.a.Y.getSessionId(), r2);
        return;
    }

    public final boolean a(Uri r8, SlcImageFetchManager r9, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r10, Object r11, SlcImageFetchManager.a r12) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        Intrinsics.checkNotNullParameter(r9, "imageManager");
        Intrinsics.checkNotNullParameter(r10, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r12, "callback");
        return m.a.a(r8, r9, r10, r11, r12);
    }
}
