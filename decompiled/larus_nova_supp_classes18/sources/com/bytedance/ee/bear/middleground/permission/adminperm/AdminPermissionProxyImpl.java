package com.bytedance.ee.bear.middleground.permission.adminperm;

import com.bytedance.ee.bear.middleground_permission_export.model.b;
import eu5.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AdminPermissionProxyImpl implements b {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public AdminPermissionProxyImpl() {
        this.a = LazyKt.lazy(new AdminPermissionProxyImpl$canShowInDebug$2(this));
    }

    public static int d(int r1) {
        if (r1 != e.g.b) goto L6;
        return 6;
    L6:
        if (r1 != e.h.b) goto L9;
        return 7;
    L9:
        if (r1 != e.k.b) goto L12;
        return 9;
    L12:
        if (r1 != e.l.b) goto L15;
        return 10;
    L15:
        if (r1 != e.i.b) goto L17;
        return 8;
    L17:
        return 1;
    }

    public final boolean c(int r8) {
        if (c.e() == false) goto L6;
        return true;
    L6:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L8;
        return false;
    L8:
        Integer r1 = null;
        com.bytedance.ee.bear.middleground.permission.audit.e r4 = (com.bytedance.ee.bear.middleground.permission.audit.e) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.audit.e.class, null, null, 6);     // Catch: Throwable -> L11
    L13:
        if (r4 == null) goto L15;
        r1 = Integer.valueOf(r4.c(r8));
    L15:
        StringBuilder r5 = new StringBuilder("syncCheckAuthority, auditManager is null = ");
        if (r4 != null) goto L18;
        boolean r6 = true;
    L19:
        r5.append(r6);
        r5.append(",permissionType =");
        r5.append(r8);
        r5.append(", result = ");
        r5.append(r1);
        tt5.a.h("AdminPermissionProxyImpl", r5.toString());
        if (r1 != null) goto L23;
    L25:
        if (r1 != null) goto L28;
    L30:
        if (r1 != null) goto L33;
    L35:
        if (r1 != null) goto L38;
    L40:
        if (r1 == null) goto L49;
        r1.intValue();
        return true;
    L49:
        return true;
    L38:
        if (r1.intValue() != 2) goto L40;
        return true;
    L33:
        if (r1.intValue() != 4) goto L35;
    L34:
        return false;
    L28:
        if (r1.intValue() != 1) goto L30;
    L23:
        if (r1.intValue() != 0) goto L25;
        return true;
    L18:
        r6 = false;
    L11:
        th = move-exception;
        tt5.a.e("AdminPermissionProxyImpl", "getAuditManagerFailed", th, false);
        r4 = null;
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.b
    public final boolean a(int r1, String r2) {
        d(r1);
        return c(13);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.b
    public final boolean b(int r1, String r2) {
        d(r1);
        return c(3);
    }
}
