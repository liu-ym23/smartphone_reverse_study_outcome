package com.bytedance.android.shopping.buynow.opt;

import android.content.Context;
import android.content.res.Configuration;
import androidx.appcompat.view.ContextThemeWrapper;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger(1);
    }

    @JvmStatic
    public static final ContextThemeWrapper a(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        EventActionImpl r4 = new EventActionImpl();
        e r9 = new e(Configuration.class);     // Catch: Exception -> L24
        f r10 = new f(android.view.ContextThemeWrapper.class, new Class[0]);     // Catch: Exception -> L24
        Configuration r11 = new Configuration(r15.getResources().getConfiguration());     // Catch: Exception -> L24
        Field r12 = (Field) r9.a.getValue();     // Catch: Exception -> L24
        if (r12 == null) goto L7;
        Object r13 = r12.get(r11);     // Catch: Exception -> L24
    L9:
        if (r13 == null) goto L23;
        Integer r14 = Integer.valueOf(((Integer) r13).intValue() + a.incrementAndGet());     // Catch: Exception -> L24
        Field r16 = (Field) r9.a.getValue();     // Catch: Exception -> L24
        if (r16 == null) goto L13;
        r16.set(r11, r14);     // Catch: Exception -> L24
    L13:
        Context r17 = r15.createConfigurationContext(r11);     // Catch: Exception -> L24
        NewMiraResourcesManager.getInstance().install(r17);     // Catch: Exception -> L24
        Object[] r18 = new Object[0];     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r18, "params");     // Catch: Exception -> L24
        Method r19 = (Method) r10.a.getValue();     // Catch: Exception -> L24
        if (r19 == null) goto L16;
        Object r110 = r19.invoke(r15, Arrays.copyOf(r18, 0));     // Catch: Exception -> L24
    L17:
        if (r110 == null) goto L21;
        int r111 = ((Integer) r110).intValue();     // Catch: Exception -> L24
        r4.doEventAction("ies_ecommerce_fe_custom_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "SHADOW_CONTEXT_COMPAT"), TuplesKt.to("desc", String.valueOf(1))}), new Pair[0]);     // Catch: Exception -> L24
        return new ContextThemeWrapper(r17, r111);
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L24
    L16:
        r110 = null;
        goto L17
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L24
    L7:
        r13 = null;
    L24:
        e = move-exception;
        r4.doEventAction("ies_ecommerce_fe_custom_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "SHADOW_CONTEXT_COMPAT"), TuplesKt.to("desc", String.valueOf(0)), TuplesKt.to("detail", String.valueOf(e.getMessage()))}), new Pair[0]);
        return null;
    }
}
