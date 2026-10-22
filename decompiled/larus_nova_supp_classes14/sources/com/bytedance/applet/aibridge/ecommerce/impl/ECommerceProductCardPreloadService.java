package com.bytedance.applet.aibridge.ecommerce.impl;

import com.larus.im.d;
import com.larus.im.internal.stream.StreamDispatcher;
import com.larus.im.internal.stream.b;
import com.larus.platform.api.IECommerceProductCardPreloadService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/ECommerceProductCardPreloadService;", "Lcom/larus/platform/api/IECommerceProductCardPreloadService;", "<init>", "()V", "startObservingMessages", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECommerceProductCardPreloadService implements IECommerceProductCardPreloadService {
    public ECommerceProductCardPreloadService() {
    }

    public final void a() {
        a r0 = a.a;
        if (a.g().a != ECommerceProductCardPreloadGroup.DISABLED) goto L5;
        FLogger.a.i("ECommerceProductCardPreload", "[product_card_preload] stage=message_observer result=skip reason=experiment_disabled");
        return;
    L5:
        Object r1 = a.b;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (a.c == false) goto L10;
        boolean r2 = false;
    L11:
        monitor-exit(r1);
        if (r2 == false) goto L22;
        d.e().registerOnGlobalMessageObserver(r0);
        b r3 = b.a;
        Intrinsics.checkNotNullParameter(r0, "observer");
        StreamDispatcher r4 = StreamDispatcher.a;
        Intrinsics.checkNotNullParameter(r0, "observer");
        StreamDispatcher.d.add(r0);
        FLogger.a.i("ECommerceProductCardPreload", "[product_card_preload] stage=message_observer result=started");
        return;
    L22:
        return;
    L10:
        r2 = true;
        a.c = true;     // Catch: Throwable -> L16
        goto L11
    }
}
