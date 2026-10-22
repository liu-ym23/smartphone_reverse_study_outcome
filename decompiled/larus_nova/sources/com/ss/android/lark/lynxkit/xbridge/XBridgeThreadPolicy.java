package com.ss.android.lark.lynxkit.xbridge;

import com.alipay.sdk.m.p.e;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeThreadPolicy;", "", "<init>", "()V", "legacyBackgroundApiAvailable", "", "Ljava/lang/Boolean;", "shouldRunOnCallingThread", e.f25671s, "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "isMainThread", "canRunInBackground", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridgeThreadPolicy {
    public static final XBridgeThreadPolicy INSTANCE = null;
    private static volatile Boolean legacyBackgroundApiAvailable;

    static {
        INSTANCE = new XBridgeThreadPolicy();
    }

    private XBridgeThreadPolicy() {
    }

    public final boolean canRunInBackground(XBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        if ((r100 instanceof XCoreBridgeMethod) == false) goto L5;
        XCoreBridgeMethod r101 = (XCoreBridgeMethod) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(legacyBackgroundApiAvailable, Boolean.FALSE) == false) goto L16;
        return false;
    L16:
        boolean r102 = r101.canRunInBackground();     // Catch: NoSuchMethodError -> L14
        legacyBackgroundApiAvailable = Boolean.TRUE;     // Catch: NoSuchMethodError -> L14
        return r102;
    L14:
        legacyBackgroundApiAvailable = Boolean.FALSE;
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean shouldRunOnCallingThread(XBridgeMethod r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        if (canRunInBackground(r100) == true) goto L7;
        if (r101 == true) goto L7;
        return false;
    L7:
        return true;
    }
}
