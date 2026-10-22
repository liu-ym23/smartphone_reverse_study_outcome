package q9;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Pair;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import com.bytedance.android.annie.container.fragment.q;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // q9.b
    public final boolean isPermissionAllGranted(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r102 = com.bytedance.android.annie.bridge.method.permission.c.f38773a;
        String[] r103 = (String[]) Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, ComplianceResult.JsonKey.PERMISSIONS);
        Pair r104 = com.bytedance.android.annie.bridge.method.permission.c.e(r100, (String[]) Arrays.copyOf(r103, r103.length));
        if ((!((List) r104.second).isEmpty()) == true) goto L16;
        Iterator r105 = ((List) r104.first).iterator();
    L7:
        if (r105.hasNext() == false) goto L23;
        String r106 = (String) r105.next();
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L7;
    L11:
        if (ContextCompat.checkSelfPermission(r100, r106) == 0) goto L14;
        r107 = false;
        goto L15
    L23:
        return true;
    L16:
        return false;
    }

    @Override // q9.b
    public final void n(Activity r110, q r111, c r112, String... r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r113, "permission");
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r100 = com.bytedance.android.annie.bridge.method.permission.c.f38773a;
        String[] r114 = (String[]) Arrays.copyOf(r113, r113.length);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, ComplianceResult.JsonKey.PERMISSIONS);
        com.bytedance.android.annie.bridge.method.permission.c.f38774b = new LinkedHashSet();
        com.bytedance.android.annie.bridge.method.permission.c.f38775c = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.f38776d = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.f38777e = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.f38778f = new ArrayList();
        Pair r101 = com.bytedance.android.annie.bridge.method.permission.c.e(r110, (String[]) Arrays.copyOf(r114, r114.length));
        LinkedHashSet<String> r102 = com.bytedance.android.annie.bridge.method.permission.c.f38774b;
        ArrayList<String> r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r102 = null;
    L5:
        r102.addAll((Collection) r101.first);
        ArrayList<String> r104 = com.bytedance.android.annie.bridge.method.permission.c.f38777e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r104 = null;
    L8:
        r104.addAll((Collection) r101.second);
        boolean r105 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        ArrayList<String> r115 = com.bytedance.android.annie.bridge.method.permission.c.f38776d;
        if (r115 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r115 = null;
    L13:
        LinkedHashSet<String> r116 = com.bytedance.android.annie.bridge.method.permission.c.f38774b;
        if (r116 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r116 = null;
    L16:
        r115.addAll(r116);
    L48:
        LinkedHashMap r117 = new LinkedHashMap();
        ArrayList<String> r118 = com.bytedance.android.annie.bridge.method.permission.c.f38776d;
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r118 = null;
    L51:
        Iterator<T> r119 = r118.iterator();
    L53:
        if (r119.hasNext() == false) goto L55;
        r117.put((String) r119.next(), PermissionStatus.PERMITTED);
        goto L53
    L55:
        ArrayList<String> r120 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r120 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r120 = null;
    L58:
        Iterator<T> r121 = r120.iterator();
    L60:
        if (r121.hasNext() == false) goto L62;
        r117.put((String) r121.next(), PermissionStatus.UNDETERMINED);
        goto L60
    L62:
        ArrayList<String> r122 = com.bytedance.android.annie.bridge.method.permission.c.f38777e;
        if (r122 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r122 = null;
    L65:
        Iterator<T> r123 = r122.iterator();
    L67:
        if (r123.hasNext() == false) goto L77;
        String r124 = (String) r123.next();
        r117.put(r124, PermissionStatus.DENIED);
        ArrayList<String> r106 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r106 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r106 = null;
    L72:
        if (r106.contains(r124) == false) goto L67;
        ArrayList<String> r107 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r107 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r107 = null;
    L76:
        r107.remove(r124);
        goto L67
    L77:
        ArrayList<String> r125 = com.bytedance.android.annie.bridge.method.permission.c.f38778f;
        if (r125 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDeniedForever");
        r125 = null;
    L80:
        Iterator<T> r126 = r125.iterator();
    L82:
        if (r126.hasNext() == false) goto L84;
        r117.put((String) r126.next(), PermissionStatus.DENIED);
        goto L82
    L84:
        if (r112 == null) goto L113;
        ArrayList<String> r127 = com.bytedance.android.annie.bridge.method.permission.c.f38777e;
        if (r127 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r127 = null;
    L89:
        if (r127.isEmpty() == false) goto L97;
        ArrayList<String> r128 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r128 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
    L95:
        if (r103.isEmpty() == false) goto L97;
        r105 = true;
        goto L97
    L93:
        r103 = r128;
    L97:
        r112.onResult(r105, r117);
        return;
    L113:
        return;
    L17:
        LinkedHashSet<String> r108 = com.bytedance.android.annie.bridge.method.permission.c.f38774b;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r108 = null;
    L20:
        Iterator<String> r109 = r108.iterator();
    L22:
        if (r109.hasNext() == false) goto L39;
        String r129 = r109.next();
        if (Build.VERSION.SDK_INT >= 23) goto L26;
    L29:
        boolean r130 = true;
    L30:
        if (r130 == true) goto L31;
        ArrayList<String> r131 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r131 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r131 = null;
    L38:
        r131.add(r129);
        goto L22
    L31:
        ArrayList<String> r132 = com.bytedance.android.annie.bridge.method.permission.c.f38776d;
        if (r132 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r132 = null;
    L34:
        r132.add(r129);
        goto L22
    L26:
        if (ContextCompat.checkSelfPermission(r110, r129) == 0) goto L29;
        r130 = false;
        goto L30
    L39:
        ArrayList<String> r133 = com.bytedance.android.annie.bridge.method.permission.c.f38775c;
        if (r133 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r133 = null;
    L43:
        if ((!r133.isEmpty()) == false) goto L48;
        if (r111 == null) goto L47;
        r111.requestPermissionsProxy(r114, 200);
        goto L48
    L47:
        ActivityCompat.requestPermissions(r110, r114, 200);
        goto L48
    }
}
