package com.ss.android.lark.lynxkit.xbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012 \u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R(\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxJsEventDelegate;", "Lcom/bytedance/ies/xbridge/XBridgeMethod$JsEventDelegate;", "sendGlobalEvent", "Lkotlin/Function2;", "", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "sendJsEvent", "eventName", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridgeLynxJsEventDelegate implements XBridgeMethod.b {
    private final Function2<String, List<? extends Object>, Unit> sendGlobalEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public XBridgeLynxJsEventDelegate(Function2<? super String, ? super List<? extends Object>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "sendGlobalEvent");
        this.sendGlobalEvent = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
    public void sendJsEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JavaOnlyMapConverter r102 = JavaOnlyMapConverter.INSTANCE;
        if (r101 == null) goto L6;
        Map<String, Object> r103 = r101.toMap();
        if (r103 == null) goto L6;
    L7:
        JavaOnlyMap r104 = r102.toLynxMap(MapsKt.mapOf(TuplesKt.to("data", r103)));
        this.sendGlobalEvent.invoke(r100, CollectionsKt.listOf(r104));
        return;
    L6:
        r103 = MapsKt.emptyMap();
        goto L7
    }
}
