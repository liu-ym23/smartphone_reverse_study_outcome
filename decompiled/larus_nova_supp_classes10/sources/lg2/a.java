package lg2;

import com.bytedance.android.livesdk.config.h41;
import com.bytedance.android.livesdk.config.i41;
import com.bytedance.android.livesdk.config.o10;
import com.bytedance.android.livesdk.config.p10;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final i41 a = null;
    public static final h41 b = null;

    static {
        a = (i41) p10.a.getValue();
        b = (h41) o10.a.getValue();
    }

    public static boolean a(String r1, String r2, boolean r3) {
        if (r3 == false) goto L5;
        return false;
    L5:
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r2 != null) goto L9;
        return false;
    L9:
        String r4 = r1 + "_" + r2;
        if (a.c() == 0) goto L18;
        List r5 = b.h();
        if (r5 == null) goto L14;
        boolean r6 = r5.contains(r4);
    L15:
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L14:
        r6 = false;
        goto L15
    L18:
        return false;
    }

    @JvmStatic
    public static final boolean b(String r1, String r2, boolean r3) {
        if (r3 == false) goto L5;
        return false;
    L5:
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r2 != null) goto L9;
        return false;
    L9:
        String r4 = r1 + "_" + r2;
        i41 r5 = a;
        if (r5.c() != 0) goto L12;
        return false;
    L12:
        if (r5.f().contains(r4) == false) goto L16;
        return true;
    L16:
        return false;
    }
}
