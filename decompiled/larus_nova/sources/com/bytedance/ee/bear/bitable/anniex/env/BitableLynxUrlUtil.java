package com.bytedance.ee.bear.bitable.anniex.env;

import com.bytedance.ee.bear.bitable.anniex.host.d;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableLynxUrlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<com.bytedance.ee.bear.bitable.anniex.host.c> f206713a;

    public static final class a {
    }

    static {
    }

    public BitableLynxUrlUtil(int r100) {
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "runtimeHostProvider");
        this.f206713a = r101;
    }

    public final String a(int r100) {
        com.bytedance.ee.bear.bitable.anniex.host.c r101 = this.f206713a.invoke();
        Map<Integer, String> r102 = c.f206717a;
        BitableLynxUrlUtil$getBundlePath$1 r103 = new BitableLynxUrlUtil$getBundlePath$1(r101);
        Intrinsics.checkNotNullParameter(r103, "getAvailability");
        if ((r103.invoke(Integer.valueOf(r100)) instanceof d.a) == true) goto L6;
        return null;
    L6:
        return c.f206717a.get(Integer.valueOf(r100));
    }
}
