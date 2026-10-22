package kk5;

import com.bytedance.ee.bear.document.SubStrategyType;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.w4;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v4 f503803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static v4 f503804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static v4 f503805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static w4 f503806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<SubStrategyType, v4> f503807e = null;

    static {
        f503807e = new LinkedHashMap();
    }

    public static final w4 b(ik5.a r100) {
        if (f503806d != null) goto L10;
        v4 r101 = r100.a5(sbb.e.f541298i);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.document.IDocumentRouterOpenStrategy");
        w4 r102 = (w4) r101;
        f503806d = r102;
        SubStrategyType[] r103 = SubStrategyType.values();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        SubStrategyType r106 = r103[r105];
        Map<SubStrategyType, v4> r107 = f503807e;
        if (((LinkedHashMap) r107).get(r106) != null) goto L9;
        r107.put(r106, r102.a(r106));
    L9:
        r105 = r105 + 1;
    L10:
        w4 r108 = f503806d;
        if (r108 != null) goto L17;
        v4 r109 = r100.a5(sbb.e.f541298i);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.ee.bear.document.IDocumentRouterOpenStrategy");
        return (w4) r109;
    L17:
        return r108;
    }

    public static final v4 a(ik5.a r100, SubStrategyType r101) {
        b(r100);
        v4 r102 = (v4) ((LinkedHashMap) f503807e).get(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return b(r100).a(r101);
    }
}
