package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedRepHelpKt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final int b() {
        return ((Number) a.getValue()).intValue();
    }

    static {
        a = LazyKt.lazy(DeepFeedRepHelpKt$skeletonTime$2.INSTANCE);
        b = LazyKt.lazy(DeepFeedRepHelpKt$rebuildFix$2.INSTANCE);
    }

    public static final String a(InFeedProductV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$constructFilter");
        e1 r0 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r3);
        if (r0 == null) goto L21;
        String r1 = r0.c();
        if (r1 == null) goto L21;
        e1 r4 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r3);
        if (r4 == null) goto L10;
        String r5 = r4.a();
        if (r5 == null) goto L10;
    L12:
        if (r5.length() != 0) goto L14;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L20;
        return "1_".concat(r1);
    L20:
        return "1_" + r1 + ",2_" + r5;
    L14:
        r2 = false;
    L10:
        r5 = "";
    L21:
        e1 r6 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r3);
        if (r6 == null) goto L27;
        String r7 = r6.a();
        if (r7 != null) goto L26;
        return null;
    L26:
        return "2_".concat(r7);
    L27:
        return null;
    }
}
