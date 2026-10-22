package gh3;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int b = 0;
    public final HashMap<String, String> a;

    public static final class a {
    }

    static {
    }

    public f() {
        this.a = new HashMap();
    }

    public static void a(f r1, String r2, String r3) {
        HashMap<String, String> r4 = r1.a;
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L8:
        r3 = "";
    L9:
        r4.put(r2, r3);
        return;
    L5:
        if (TextUtils.equals("null", r3) == true) goto L8;
        Intrinsics.checkNotNull(r3);
        goto L9
    }
}
