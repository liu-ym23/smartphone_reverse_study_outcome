package com.bytedance.android.shopping.store.tabkit.bridge;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.model.i;
import com.bytedance.android.shopping.store.tabkit.model.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface b {
    void C(i r1);

    void G(JSONObject r1, ECBaseBridgeMethod.a r2);

    void I();

    void N(int r1, String r2, JSONObject r3);

    void W(long r1);

    Result f0(int r1);

    int getScreenState();

    void j(z r1);

    void k(int r1);

    void l(String r1);

    void n(String r1);

    Object p(String r1);

    void q(String r1, Object r2);

    void s(boolean r1, long r2, long r4, int r6);

    void u(int r1, boolean r2, boolean r3);

    void z5(int r1, boolean r2);
}
