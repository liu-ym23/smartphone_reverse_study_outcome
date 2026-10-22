package ns3;

import android.content.Intent;
import android.os.Build;
import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static Intent a(Message r100) {
        int r101 = r100.what;
        String r102 = "intent";
        if (r101 != 100) goto L5;
    L39:
        Object r103 = r100.obj;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 >= 28) goto L46;
        if (r101 != 100) goto L46;
        return (Intent) d27.b.b(r103, "intent");
    L44:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        if (r104 < 28) goto L82;
        if (r101 != 159) goto L83;
        List r105 = (List) d27.b.b(r103, "mActivityCallbacks");     // Catch: IllegalAccessException -> L59
        if (r105 == null) goto L84;
        int r106 = 0;
    L52:
        if (r106 >= r105.size()) goto L86;
        Object r107 = ListProtector.get(r105, r106);     // Catch: IllegalAccessException -> L59
        if (r107 == null) goto L58;
        Intent r108 = (Intent) d27.b.b(r107, "mIntent");     // Catch: IllegalAccessException -> L59
        if (r108 == null) goto L58;
        return r108;
    L58:
        r106 = r106 + 1;
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
        if (r101 == 121) goto L23;
        if (r101 == 159) goto L39;
        switch(r101) {
            case 113: goto L10;
            case 114: goto L23;
            case 115: goto L23;
            default: goto L8;
        };
    L8:
        return null;
    L10:
        if (r101 == 113) goto L14;
        r102 = "";
    L14:
        if (r102.isEmpty() == true) goto L74;
        Object r109 = r100.obj;
        if (r109 == null) goto L75;
        return (Intent) d27.b.b(r109, r102);
    L19:
        th = move-exception;
        th.printStackTrace();
        return null;
    L75:
        return null;
    L74:
        return null;
    L23:
        if (r101 == 114) goto L31;
        if (r101 == 121) goto L31;
        if (r101 != 115) goto L29;
        r102 = "args";
        goto L31
    L29:
        r102 = "";
    L31:
        if (r102.isEmpty() == true) goto L77;
        Object r110 = r100.obj;
        if (r110 == null) goto L78;
        return (Intent) d27.b.b(r110, r102);
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
