package kk5;

import com.bytedance.ee.bear.document.SubStrategyType;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.w4;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static v4 a;
    public static v4 b;
    public static v4 c;
    public static w4 d;
    public static final Map<SubStrategyType, v4> e = null;

    static {
        e = new LinkedHashMap();
    }

    public static final w4 b(ik5.a r8) {
        if (d != null) goto L10;
        w4 r0 = r8.a5(sbb.e.i);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.document.IDocumentRouterOpenStrategy");
        w4 r1 = r0;
        d = r1;
        SubStrategyType[] r2 = SubStrategyType.values();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        SubStrategyType r5 = r2[r4];
        Map<SubStrategyType, v4> r6 = e;
        if (((LinkedHashMap) r6).get(r5) != null) goto L9;
        r6.put(r5, r1.a(r5));
    L9:
        r4 = r4 + 1;
    L10:
        w4 r7 = d;
        if (r7 != null) goto L17;
        w4 r9 = r8.a5(sbb.e.i);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.document.IDocumentRouterOpenStrategy");
        return r9;
    L17:
        return r7;
    }

    public static final v4 a(ik5.a r1, SubStrategyType r2) {
        b(r1);
        v4 r0 = (v4) ((LinkedHashMap) e).get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b(r1).a(r2);
    }
}
