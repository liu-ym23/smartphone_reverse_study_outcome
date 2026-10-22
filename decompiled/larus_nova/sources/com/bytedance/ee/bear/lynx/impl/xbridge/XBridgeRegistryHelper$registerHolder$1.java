package com.bytedance.ee.bear.lynx.impl.xbridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class XBridgeRegistryHelper$registerHolder$1 extends Lambda implements Function1<XBridgeLynxKitRuntime, Unit> {
    final /* synthetic */ Class<Object> $clazz;
    final /* synthetic */ Object $item;

    public XBridgeRegistryHelper$registerHolder$1(Class<Object> r100, Object r101) {
        this.$clazz = r100;
        this.$item = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(XBridgeLynxKitRuntime r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.registerService(this.$clazz, this.$item);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(XBridgeLynxKitRuntime r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
