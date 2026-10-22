package gg3;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(e r1) {
        if (r1 == null) goto L8;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r2 = r1.g();
        if (r2 == null) goto L8;
        Map r3 = r2.g();
        if (r3 == null) goto L8;
        Object r4 = r3.get("chunk_index");
    L10:
        return Intrinsics.areEqual(r4, 0);
    L8:
        r4 = null;
        goto L10
    }
}
