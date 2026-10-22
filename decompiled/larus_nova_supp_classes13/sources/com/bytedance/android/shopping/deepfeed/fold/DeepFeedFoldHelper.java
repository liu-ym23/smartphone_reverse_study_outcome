package com.bytedance.android.shopping.deepfeed.fold;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import nj.d;
import tc3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedFoldHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(DeepFeedFoldHelper$service$2.INSTANCE);
    }

    public static boolean f() {
        d r0 = (d) a.getValue();
        if (r0 == null) goto L7;
        r0.isFold();
        return false;
    L7:
        return false;
    }

    public static boolean a() {
        Integer r0 = a.a().i();
        if (r0 != null) goto L6;
    L8:
        e();
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        f();
        goto L8
    }

    public static boolean d() {
        Integer r0 = a.a().i();
        if (r0 != null) goto L6;
    L7:
        Integer r1 = a.a().i();
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.intValue() != 2) goto L15;
    L12:
        f();
        return false;
    L15:
        return false;
    L6:
        if (r0.intValue() == 1) goto L12;
        goto L7
    }

    public static boolean e() {
        Integer r0 = a.a().i();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != 2) goto L10;
        f();
        return false;
    L10:
        return false;
    }

    public static boolean b(Activity r0) {
        d r1 = (d) a.getValue();
        if (r1 == null) goto L7;
        r1.l();
        return false;
    L7:
        return false;
    }

    public static int c(Context r0) {
        f();
        return ToolsKt.o(r0);
    }
}
