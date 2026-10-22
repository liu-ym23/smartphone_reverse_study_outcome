package com.bytedance.sysoptimizer.javahook;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyFrameData {
    private static final String TAG = "ProxyFrameData";

    public ProxyFrameData() {
    }

    public Object update(long r100, Object r101) throws Throwable {
        String r102 = "update() called with: frameTimeNanos = [" + r100 + "], vsyncEventData = [" + r101 + "]";
        Object r103 = AHook.callOrigin(OriginMethodKey.KEY_FRAMEDATA_UPDATE, this, new Object[]{Long.valueOf(r100), r101});
        AHook.getCallback().e(TAG, r102 + ", o = [" + r103 + "]", new Throwable());
        return r103;
    }
}
