package xh0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static final String a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getString");
        StringBuilder r101 = new StringBuilder();
        r101.append("{tag: " + r100.f563847a + ' ');
        r101.append("key: " + r100.f563848b + ' ');
        r101.append("result: " + r100.f563849c + ' ');
        r101.append("reason: " + r100.f563850d + ' ');
        r101.append("toast: " + r100.f563851e + '}');
        return r101.toString();
    }
}
