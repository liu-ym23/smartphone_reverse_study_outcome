package ns3;

import android.content.Intent;
import android.os.Build;
import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static Intent a(Message r7) {
        int r0 = r7.what;
        String r3 = "intent";
        if (r0 != 100) goto L5;
    L39:
        Object r8 = r7.obj;
        int r5 = Build.VERSION.SDK_INT;
        if (r5 >= 28) goto L46;
        if (r0 != 100) goto L46;
        return (Intent) d27.b.b(r8, "intent");
    L44:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        if (r5 < 28) goto L82;
        if (r0 != 159) goto L83;
        List r9 = (List) d27.b.b(r8, "mActivityCallbacks");     // Catch: IllegalAccessException -> L59
        if (r9 == null) goto L84;
        int r1 = 0;
    L52:
        if (r1 >= r9.size()) goto L86;
        Object r2 = ListProtector.get(r9, r1);     // Catch: IllegalAccessException -> L59
        if (r2 == null) goto L58;
        Intent r4 = (Intent) d27.b.b(r2, "mIntent");     // Catch: IllegalAccessException -> L59
        if (r4 == null) goto L58;
        return r4;
    L58:
        r1 = r1 + 1;
        goto L52
    L86:
        return null;
    L84:
        return null;
    L59:
        e = move-exception;
        e.printStackTrace();
        return null;
    L83:
        return null;
    L82:
        return null;
    L5:
        if (r0 == 121) goto L23;
        if (r0 == 159) goto L39;
        switch(r0) {
            case 113: goto L10;
            case 114: goto L23;
            case 115: goto L23;
            default: goto L8;
        };
    L8:
        return null;
    L10:
        if (r0 == 113) goto L14;
        r3 = "";
    L14:
        if (r3.isEmpty() == true) goto L74;
        Object r10 = r7.obj;
        if (r10 == null) goto L75;
        return (Intent) d27.b.b(r10, r3);
    L19:
        th = move-exception;
        th.printStackTrace();
        return null;
    L75:
        return null;
    L74:
        return null;
    L23:
        if (r0 == 114) goto L31;
        if (r0 == 121) goto L31;
        if (r0 != 115) goto L29;
        r3 = "args";
        goto L31
    L29:
        r3 = "";
    L31:
        if (r3.isEmpty() == true) goto L77;
        Object r11 = r7.obj;
        if (r11 == null) goto L78;
        return (Intent) d27.b.b(r11, r3);
    L36:
        th = move-exception;
        th.printStackTrace();
        return null;
    L78:
        return null;
    L77:
        return null;
    }
}
