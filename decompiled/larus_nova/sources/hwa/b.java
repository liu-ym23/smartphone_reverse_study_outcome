package hwa;

import android.util.ArrayMap;
import com.ss.android.lark.pb.authorization.CustomizedOperatePermission;
import com.ss.android.lark.pb.authorization.ExtendedOperatePermission;
import com.ss.android.lark.pb.authorization.OperatePermission;
import com.ss.android.lark.pb.authorization.PermissionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static Map<PermissionType, List<OperatePermission>> a(List<OperatePermission> r100) {
        if (nwa.a.a(r100) == false) goto L6;
        return null;
    L6:
        ArrayMap r101 = new ArrayMap();
        Iterator<OperatePermission> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        OperatePermission r103 = r102.next();
        PermissionType r104 = r103.mperm_type;
        List r105 = (List) r101.get(r104);
        if (r105 != null) goto L12;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L12:
        r105.add(r103);
        goto L8
    L13:
        return r101;
    }

    public static Map<PermissionType, List<CustomizedOperatePermission>> b(List<CustomizedOperatePermission> r100) {
        if (nwa.a.a(r100) == false) goto L6;
        return null;
    L6:
        ArrayMap r101 = new ArrayMap();
        Iterator<CustomizedOperatePermission> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        CustomizedOperatePermission r103 = r102.next();
        PermissionType r104 = r103.mperm_type;
        List r105 = (List) r101.get(r104);
        if (r105 != null) goto L12;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L12:
        r105.add(r103);
        goto L8
    L13:
        return r101;
    }

    public static Map<PermissionType, List<ExtendedOperatePermission>> c(List<ExtendedOperatePermission> r100) {
        if (nwa.a.a(r100) == false) goto L6;
        return null;
    L6:
        ArrayMap r101 = new ArrayMap();
        Iterator<ExtendedOperatePermission> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        ExtendedOperatePermission r103 = r102.next();
        PermissionType r104 = r103.mperm_type;
        List r105 = (List) r101.get(r104);
        if (r105 != null) goto L12;
        r105 = new ArrayList();
        r101.put(r104, r105);
    L12:
        r105.add(r103);
        goto L8
    L13:
        return r101;
    }

    public static List<OperatePermission> d(Map<PermissionType, List<OperatePermission>> r100) {
        if (nwa.a.b(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<PermissionType, List<OperatePermission>>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.addAll(r102.next().getValue());
        goto L8
    L10:
        return r101;
    }

    public static List<CustomizedOperatePermission> e(Map<PermissionType, List<CustomizedOperatePermission>> r100) {
        if (nwa.a.b(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<PermissionType, List<CustomizedOperatePermission>>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.addAll(r102.next().getValue());
        goto L8
    L10:
        return r101;
    }

    public static List<ExtendedOperatePermission> f(Map<PermissionType, List<ExtendedOperatePermission>> r100) {
        if (nwa.a.b(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<PermissionType, List<ExtendedOperatePermission>>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.addAll(r102.next().getValue());
        goto L8
    L10:
        return r101;
    }
}
