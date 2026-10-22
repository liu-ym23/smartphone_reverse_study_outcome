package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LynxAbilityImpl implements com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    public final Map<ti.j, f> a;
    public final String b;
    public final DynamicFeatureComponent.b c;

    public static final class a implements ti.j {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.invoke(r2);
        }
    }

    public final l p(o r14) {
        Intrinsics.checkNotNullParameter(r14, "option");
        Context r1 = r14.getContext();
        String r2 = r14.b;
        Map<String, Object> r3 = r14.d;
        ViewGroup r4 = r14.c;
        boolean r11 = r14.e;
        l r0 = ECLiveHybridUtil.b(r1, r2, r3, r4, r14.f, null, null, false, null, null, r11, 2016);
        if (r0 == null) goto L5;
        w.a.e(w.b, r0, r14.getContext(), Boolean.valueOf(this.c.a()), 8);
        return r0;
    L5:
        return null;
    }

    public LynxAbilityImpl(String r2, DynamicFeatureComponent.b r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.b = r2;
        this.c = r3;
        this.a = new HashMap(30);
    }

    public final void B(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        ECLiveHybridUtil.f(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void F0(String r2, ti.j r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        f r0 = (f) ((HashMap) this.a).remove(r3);
        if (r0 == null) goto L8;
        ti.j r1 = r0.b;
        if (r1 == null) goto L8;
        r3 = r1;
    L8:
        ECLiveHybridUtil.p(r2, r3);
    }

    public final void h0(String r2, boolean r3, Function1<? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        l0(r2, r3, new a(r4));
    }

    public final void l0(final String r2, final boolean r3, final ti.j r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new LynxAbilityImpl$registerLynxHandler$1(this, r3, r4, r2));
    }
}
