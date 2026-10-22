package xx4;

import com.alibaba.fastjson.JSON;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.ss.android.lark.jsruntime.vmsdk.c {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static final void a(b r100, String r101, String r102) {
        r100.getClass();
        Object r103 = JSON.parseObject(r102).get("code");     // Catch: Exception -> L9
        if (r103 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r103, 0) == true) goto L15;
        tt5.a.d("JSRuntimeRequestDelegate", "onResponse Error：url:" + du5.b.k(r101) + " code:" + r103);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        tt5.a.d("JSRuntimeRequestDelegate", "checkResponse Exception:" + e.getMessage());
    }
}
