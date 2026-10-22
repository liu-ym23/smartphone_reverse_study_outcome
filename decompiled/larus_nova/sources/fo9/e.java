package fo9;

import com.larus.office.permission.DocPermissionData;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.office.permission.VisibilityStatus;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {
    public static final boolean a(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DocPermissionData r101 = r100.getPermissions();
        if (r101 == null) goto L5;
        boolean r102 = r101.getEditable();
    L6:
        if (r102 == false) goto L8;
    L11:
        return true;
    L8:
        if (e(r100) == true) goto L11;
        if (b(r100) == true) goto L11;
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static final boolean b(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DocPermissionData r101 = r100.getPermissions();
        if (r101 == null) goto L5;
        boolean r102 = r101.isManager();
    L6:
        if (r102 == false) goto L8;
    L9:
        return true;
    L8:
        if (e(r100) == true) goto L9;
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static final boolean c(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DocPermissionData r101 = r100.getPermissions();
        if (r101 == null) goto L5;
        boolean r102 = r101.getReadable();
    L6:
        if (r102 == false) goto L8;
    L13:
        return true;
    L8:
        if (a(r100) == true) goto L13;
        if (e(r100) == true) goto L13;
        if (b(r100) == true) goto L13;
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static final boolean d(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        h r101 = r100.getPublicPermissions();
        if (r101 == null) goto L7;
        Boolean r102 = r101.f478186b;
        if (r102 == null) goto L7;
        boolean r103 = r102.booleanValue();
    L8:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("isDeleted: publicIsDeleted=");
        h r106 = r100.getPublicPermissions();
        if (r106 == null) goto L11;
        Boolean r107 = r106.f478186b;
    L12:
        r105.append(r107);
        r105.append(", result=");
        r105.append(r103);
        r104.i("OfficePermissionFullData", r105.toString());
        return r103;
    L11:
        r107 = null;
    L7:
        r103 = false;
        goto L8
    }

    public static final boolean e(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DocPermissionData r101 = r100.getPermissions();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isOwner();
    }

    public static final boolean f(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibilityStatus() != VisibilityStatus.NORMAL.getValue()) goto L5;
        return true;
    L5:
        return false;
    }
}
