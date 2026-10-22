package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCartCustomWidget {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a(int r4, int r5, int r6) {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        CardListCartCustomWidget$injectCustomWidget$1 r3 = CardListCartCustomWidget$injectCustomWidget$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECCartSlideContainer", r3);
        ElementTypes.b("ECCartCounter", CardListCartCustomWidget$injectCustomWidget$2.INSTANCE);
        ElementTypes.b("ECCartCountDown", CardListCartCustomWidget$injectCustomWidget$3.INSTANCE);
        ElementTypes.b("ECCartTabContainer", CardListCartCustomWidget$injectCustomWidget$4.INSTANCE);
        ElementTypes.b("ECCartLoadingCircle", CardListCartCustomWidget$injectCustomWidget$5.INSTANCE);
        ElementTypes.b("ECCartLynxPendant", CardListCartCustomWidget$injectCustomWidget$6.INSTANCE);
        ElementTypes.b("ECCartProgressView", CardListCartCustomWidget$injectCustomWidget$7.INSTANCE);
        ElementTypes.b("ECCartScrollNumber", CardListCartCustomWidget$injectCustomWidget$8.INSTANCE);
        ElementTypes.b("ECCartBottomButtonContainer", CardListCartCustomWidget$injectCustomWidget$9.INSTANCE);
        ElementTypes.c("yata_cart", CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new fb3.d(), new fb3.e(), new fb3.a(r6), new fb3.c(r4), new fb3.b(r5)}));
    }
}
