package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static n a(String r2) {
        d43.a<String, BuyNowStarterOpt> r0 = j.a;
        if (r2 != null) goto L5;
        String r1 = "";
    L6:
        BuyNowStarterOpt r3 = (BuyNowStarterOpt) r0.b(r1);
        if (r3 == null) goto L10;
        return r3;
    L10:
        if (((Boolean) ECSettingKeys.f.getValue()).booleanValue() == false) goto L16;
        WeakReference<n> r4 = BuyNowStarterWeakReferenceHolder.INSTANCE.get(r2);
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.get();
    L16:
        return BuyNowStarterHolder.INSTANCE.get(r2);
    L5:
        r1 = r2;
        goto L6
    }

    public static n c(String r2) {
        d43.a<String, BuyNowStarterOpt> r0 = j.a;
        if (r2 != null) goto L5;
        String r1 = "";
    L6:
        r0.i(r1);
        if (((Boolean) ECSettingKeys.f.getValue()).booleanValue() == false) goto L16;
        BuyNowStarterWeakReferenceHolder r3 = BuyNowStarterWeakReferenceHolder.INSTANCE;
        if (r3 == null) goto L15;
        WeakReference r4 = (WeakReference) TypeIntrinsics.asMutableMap(r3).remove(r2);
        if (r4 != null) goto L22;
        return null;
    L22:
        return (n) r4.get();
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L16:
        BuyNowStarterHolder r5 = BuyNowStarterHolder.INSTANCE;
        if (r5 == null) goto L21;
        return (n) TypeIntrinsics.asMutableMap(r5).remove(r2);
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        r1 = r2;
        goto L6
    }

    public static void b(String r1, n r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r2, "starter");
        if (r3 == false) goto L10;
        d43.a<String, BuyNowStarterOpt> r4 = j.a;
        if ((r2 instanceof BuyNowStarterOpt) == true) goto L7;
        r2 = null;
    L7:
        r4.g(r1, (BuyNowStarterOpt) r2);
        return;
    L10:
        if (((Boolean) ECSettingKeys.f.getValue()).booleanValue() == false) goto L12;
        BuyNowStarterWeakReferenceHolder.INSTANCE.put(r1, new WeakReference(r2));
        return;
    L12:
        BuyNowStarterHolder.INSTANCE.put(r1, r2);
    }
}
