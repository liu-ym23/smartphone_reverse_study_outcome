package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogBackToPage", owner = "pengweitao")
public final class a extends ok7.a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogBackToPage";
    }

    public a() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        pl7.b.a(new pl7.a(r100.getString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID), r100.getInt("enter_from_mode"), r100.getString("enter_from")));     // Catch: Throwable -> L5
        i.b(r101, 1, null, null, 6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        i.b(r101, 0, null, th.toString(), 2);
    }
}
