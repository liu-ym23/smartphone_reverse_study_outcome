package xx4;

import com.alibaba.fastjson.JSON;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.ss.android.lark.jsruntime.vmsdk.c {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static final void a(b r2, String r3, String r4) {
        r2.getClass();
        Object r5 = JSON.parseObject(r4).get("code");     // Catch: Exception -> L9
        if (r5 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5, 0) == true) goto L15;
        tt5.a.d("JSRuntimeRequestDelegate", "onResponse Error：url:" + du5.b.k(r3) + " code:" + r5);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        tt5.a.d("JSRuntimeRequestDelegate", "checkResponse Exception:" + e.getMessage());
    }
}
