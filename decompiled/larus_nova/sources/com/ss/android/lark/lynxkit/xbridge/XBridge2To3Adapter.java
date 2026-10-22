package com.ss.android.lark.lynxkit.xbridge;

import com.alipay.sdk.m.p.e;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeContextAwareMethod;
import f66.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020\u000b0\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridge2To3Adapter;", "", e.f25671s, "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "<init>", "(Lcom/bytedance/ies/xbridge/XBridgeMethod;)V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "callContext", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "params", "", "callback", "Lkotlin/Function1;", "shouldRunOnCallingThread", "", "isMainThread", "release", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridge2To3Adapter {
    private final XBridgeMethod method;

    public final String getName() {
        return this.method.getName();
    }

    public final void release() {
        this.method.release();
    }

    public XBridge2To3Adapter(XBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        this.method = r100;
    }

    public final boolean shouldRunOnCallingThread(boolean r100) {
        return XBridgeThreadPolicy.INSTANCE.shouldRunOnCallingThread(this.method, r100);
    }

    public final void handle(LarkLynxBridgeCallContext r100, Map<String, ? extends Object> r101, final Function1<? super Map<String, ? extends Object>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        XBridgeMethod.Callback r103 = new XBridge2To3Adapter$handle$originCallback$1(r102);
        d r104 = new d(new JSONObject(r101));
        XBridgeMethod r105 = this.method;
        if ((r105 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L5;
        LarkLynxBridgeContextAwareMethod r106 = (LarkLynxBridgeContextAwareMethod) r105;
    L6:
        if (r106 == null) goto L24;
        r106.setBridgeContext(r100);
    L24:
        this.method.handle(r104, r103, XBridgePlatformType.LYNX);     // Catch: Throwable -> L16
        XBridgeMethod r107 = this.method;
        if ((r107 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L12;
        LarkLynxBridgeContextAwareMethod r108 = (LarkLynxBridgeContextAwareMethod) r107;
    L13:
        if (r108 == null) goto L26;
        r108.setBridgeContext(null);
        return;
    L26:
        return;
    L12:
        r108 = null;
    L16:
        th = move-exception;
        XBridgeMethod r109 = this.method;
        if ((r109 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L20;
        LarkLynxBridgeContextAwareMethod r110 = (LarkLynxBridgeContextAwareMethod) r109;
    L21:
        if (r110 == null) goto L23;
        r110.setBridgeContext(null);
    L23:
        throw th;
    L20:
        r110 = null;
        goto L21
    L5:
        r106 = null;
        goto L6
    }
}
