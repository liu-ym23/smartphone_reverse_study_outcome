package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements j73.l {
    public final x a;

    public final void Q() {
        x r0 = this.a;
        if (r0 == null) goto L6;
        r0.Q();
        return;
    }

    public final CommonMeta a() {
        x r0 = this.a;
        if (r0 == null) goto L11;
        PdpDataStore r1 = r0.getData();
        if (r1 == null) goto L11;
        ObservableData r2 = r1.b;
        if (r2 == null) goto L11;
        PageMeta r3 = (PageMeta) r2.a();
        if (r3 == null) goto L11;
        return r3.getCommonMeta();
    L11:
        return null;
    }

    public final LinkedTreeMap<String, Object> b() {
        x r0 = this.a;
        if (r0 == null) goto L11;
        PdpDataStore r1 = r0.getData();
        if (r1 == null) goto L11;
        ObservableData r2 = r1.b;
        if (r2 == null) goto L11;
        PageMeta r3 = (PageMeta) r2.a();
        if (r3 == null) goto L11;
        return r3.getTrackMeta();
    L11:
        return null;
    }

    public final String f() {
        x r0 = this.a;
        if (r0 == null) goto L7;
        PdpDataStore r1 = r0.getData();
        if (r1 == null) goto L7;
        return r1.d();
    L7:
        return null;
    }

    public g(x r1) {
        this.a = r1;
    }

    public final void U(boolean r2) {
        x r3 = this.a;
        if (r3 == null) goto L6;
        r3.c0(false);
        return;
    }

    public final void T(Map<String, ? extends Object> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        x r0 = this.a;
        if (r0 == null) goto L6;
        r0.T(r2, r3);
        return;
    }

    public final void V(Map r3, Map r4, boolean r5, Function1 r6) {
        Intrinsics.checkNotNullParameter("custom_action_refresh", "refreshType");
        x r0 = this.a;
        if (r0 == null) goto L5;
        r0.c1(r3);
    L5:
        x r7 = this.a;
        if (r7 == null) goto L9;
        r7.w0("custom_action_refresh", r4, r5, r6);
        return;
    }
}
