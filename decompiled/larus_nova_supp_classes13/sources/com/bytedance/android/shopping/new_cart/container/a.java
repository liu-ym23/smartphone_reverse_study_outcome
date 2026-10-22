package com.bytedance.android.shopping.new_cart.container;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public final /* synthetic */ CardListCartSliceRenderInfoManager a;

    public final ImageRequest b(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    public a(CardListCartSliceRenderInfoManager r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) == false) goto L7;
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r4 = (com.bytedance.android.ecom.arch.slice.render.widget.fresco.h) r3;
        HandlerExecutorServiceImpl r0 = this.a.a;
        if (r0 == null) goto L11;
        r4.b = r0;
        return;
    L11:
        return;
    L7:
        Field r1 = (Field) this.a.b.getValue();
        if (r1 == null) goto L13;
        r1.set(r3, this.a.a);
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
