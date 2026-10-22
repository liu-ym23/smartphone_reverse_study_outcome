package e06;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.AppOpsManagerCompat;
import com.bytedance.helios.common.utils.PermissionUtils;
import com.bytedance.helios.sdk.p;
import hz5.k;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f470641a = null;

    static {
        f470641a = new ConcurrentHashMap();
    }

    public static void c() {
        Iterator r100 = ((ConcurrentHashMap) f470641a).keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        b((String) r100.next());
        goto L4
    }

    public static void b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        ((ConcurrentHashMap) f470641a).put(r100, -3);
        return;
    L11:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static int a(Context r100, String r101) {
        if (p.f245593n.e() == false) goto L7;
        Integer r102 = (Integer) ((ConcurrentHashMap) f470641a).get(r101);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L9:
        if (r103 != (-3)) goto L28;
        int r104 = PermissionUtils.f245390a;
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L26:
        r103 = 0;
    L27:
        ((ConcurrentHashMap) f470641a).put(r101, Integer.valueOf(r103));
        k.b("EventPermissionUtils", "checkSelfPermission: " + r101 + " -> status=" + r103);
    L29:
        return r103;
    L14:
        if (r100.checkPermission(r101, Process.myPid(), Process.myUid()) != (-1)) goto L16;
        r103 = -1;
        goto L27
    L16:
        String r105 = AppOpsManagerCompat.permissionToOp(r101);
        if (r105 == null) goto L26;
        int r106 = Build.VERSION.SDK_INT;
        AppOpsManager r107 = (AppOpsManager) r100.getSystemService("appops");
        if (r107 == null) goto L26;
        if (r106 < 29) goto L23;
        int r108 = r107.unsafeCheckOpNoThrow(r105, Process.myUid(), r100.getPackageName());
    L24:
        if (r108 == 0) goto L26;
        r103 = -2;
        goto L27
    L23:
        r108 = r107.checkOpNoThrow(r105, Process.myUid(), r100.getPackageName());
        goto L24
    L28:
        k.b("EventPermissionUtils", "checkSelfPermission: " + r101 + " -> used cache, status=" + r103);
    L7:
        r103 = -3;
        goto L9
    }
}
