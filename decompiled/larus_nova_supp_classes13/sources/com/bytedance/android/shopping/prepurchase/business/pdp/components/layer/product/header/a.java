package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.action.j;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.PdpEventRegistry;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.m1;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import j73.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements j, v {
    public final d a;
    public final /* synthetic */ v b;

    public final void a(jq.a r2, Map<String, ? extends Object> r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "logData");
        this.b.a(r2, r3, r4);
    }

    public final void c(EventContext r2, Map<String, String> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "eventContext");
        this.b.c(r2, r3, r4);
    }

    public final void e(Context r2, iq.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "toastParam");
        this.b.e(r2, r3);
    }

    public final void f(Activity r2, hq.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.b.f(r2, r3);
    }

    public a(v r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "dependencies");
        this.b = r2;
        this.a = r3;
    }

    public final void b(EventChain r3, j r4, FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r3, "chain");
        Intrinsics.checkNotNullParameter(r4, "provider");
        Intrinsics.checkNotNullParameter(r5, "activity");
        int r0 = PdpEventRegistry.a;
        d r1 = this.a;
        Intrinsics.checkNotNullParameter(r4, "yataCommonEventService");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r1, "dependency");
        PdpEventRegistry.a(new m1(r3), r4, r5, r1);
    }
}
