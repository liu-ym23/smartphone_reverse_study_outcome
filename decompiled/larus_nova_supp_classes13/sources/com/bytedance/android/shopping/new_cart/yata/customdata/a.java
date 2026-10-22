package com.bytedance.android.shopping.new_cart.yata.customdata;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int e = 0;
    public final Integer a;
    public final Map<String, Map<String, Object>> b;
    public final Context c;
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.yata.customdata.a$a, reason: collision with other inner class name */
    public static final class C0136a {
    }

    static {
    }

    public final int a() {
        Activity r0 = l0.b(this.c);
        Insets r1 = null;
        if (r0 == null) goto L11;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L11;
        View r3 = r2.getDecorView();
        if (c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L12;
        c.a(r4, "getDecorView");
    L12:
        if (r3 == null) goto L14;
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r3);
    L15:
        if (r5 == null) goto L17;
        r1 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
    L17:
        if (r1 == null) goto L23;
        Object r6 = b.f(Integer.valueOf(r1.bottom));
        if (r6 == null) goto L23;
        Integer r7 = ECHybridExtensionsKt.i(r6);
        if (r7 == null) goto L23;
        return r7.intValue();
    L23:
        return 0;
    L14:
        r5 = null;
    L11:
        r3 = null;
        goto L12
    }

    public final int b() {
        Lazy r0 = CartCommonLog.a;
        CartCommonLog.a("CustomDataCenter", new CustomDataCenter$foldPaddingBottomDiff$1$1(this));
        int r1 = a();
        if (r1 != 0) goto L12;
        String r2 = this.d;
        if (Intrinsics.areEqual(r2, ECFoldScene.MALL.name()) == false) goto L8;
    L18:
        return 5;
    L8:
        if (Intrinsics.areEqual(r2, ECFoldScene.LIVE.name()) == true) goto L21;
        return 12;
    L21:
        return 13;
    L12:
        if (1 <= r1) goto L15;
    L23:
        return 0;
    L15:
        if (34 < r1) goto L23;
        String r3 = this.d;
        if (Intrinsics.areEqual(r3, ECFoldScene.MALL.name()) == true) goto L18;
        if (Intrinsics.areEqual(r3, ECFoldScene.LIVE.name()) == true) goto L21;
        return 34 - r1;
    }

    public final Context getContext() {
        return this.c;
    }

    public final void c(Object r5) {
        Intrinsics.checkNotNullParameter("counter_active", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((Map) r2.getValue()).containsKey("counter_active") == false) goto L4;
        ((Map) r2.getValue()).put("counter_active", r5);
        goto L4
    }

    public a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = r3;
        this.a = ECHybridExtensionsKt.i(b.f(Integer.valueOf(eh.b.b(r2))));
        this.b = new LinkedHashMap();
    }
}
