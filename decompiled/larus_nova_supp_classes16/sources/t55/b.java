package t55;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import jg5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(int r3) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r0 = e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.e() == true) goto L5;
        return false;
    L5:
        if (r3 != 202) goto L10;
        Toast.showFailureText(eu5.b.a, 2131887246);
        return true;
    L10:
        return false;
    }

    public static boolean b(u55.b r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.b.a.isCopyAuthByKp() == false) goto L8;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r3 = e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.a() == false) goto L8;
        return true;
    }
}
