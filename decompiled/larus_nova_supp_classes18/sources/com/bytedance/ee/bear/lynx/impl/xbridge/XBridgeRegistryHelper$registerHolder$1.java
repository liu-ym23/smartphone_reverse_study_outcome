package com.bytedance.ee.bear.lynx.impl.xbridge;

import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class XBridgeRegistryHelper$registerHolder$1 extends Lambda implements Function1<XBridgeLynxKitRuntime, Unit> {
    final /* synthetic */ Class<Object> $clazz;
    final /* synthetic */ Object $item;

    public XBridgeRegistryHelper$registerHolder$1(Class<Object> r1, Object r2) {
        this.$clazz = r1;
        this.$item = r2;
        super(1);
    }

    public final void invoke(XBridgeLynxKitRuntime r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.registerService(this.$clazz, this.$item);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((XBridgeLynxKitRuntime) r1);
        return Unit.INSTANCE;
    }
}
