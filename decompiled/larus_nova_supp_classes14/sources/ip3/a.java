package ip3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final int a;
    public final String b;
    public final Map<String, String> c;
    public final String d;
    public final String e;
    public final int f;

    public a(int r2, String r3, Map<String, String> r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "uniqueId");
        Intrinsics.checkNotNullParameter(r4, "dynamicInsertData");
        Intrinsics.checkNotNullParameter(r5, "surroundedProductIds");
        Intrinsics.checkNotNullParameter(r6, "categoryId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
