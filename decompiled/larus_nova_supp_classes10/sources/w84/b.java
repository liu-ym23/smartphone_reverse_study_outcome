package w84;

import kotlin.jvm.internal.Intrinsics;
import x84.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static float a(com.bytedance.bdnavigationsdk.pojo.a r5, com.bytedance.bdnavigationsdk.pojo.a r6) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "target");
        return (float) com.bytedance.bdnavigationsdk.utils.b.a(x84.d.c(new f(r5.b, r5.a), new f(r6.b, r6.a), "meters"), 2);
    }
}
