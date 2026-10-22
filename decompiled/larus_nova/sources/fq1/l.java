package fq1;

import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "functionName");
        if (v.a() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("SaaS does not have this network request:".concat(r100));
    }
}
