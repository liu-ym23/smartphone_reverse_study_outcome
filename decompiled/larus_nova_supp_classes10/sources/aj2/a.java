package aj2;

import com.bytedance.android.ec.core.opt.ab.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static boolean a() {
        if (c.f() != 2) goto L5;
    L10:
        return true;
    L5:
        if (c.f() == 4) goto L10;
        if (c.f() == 6) goto L10;
        return false;
    }

    static {
    }
}
