package com.bytedance.ee.bear.middleground.permission.adminperm;

import com.bytedance.ee.bear.middleground_permission_export.model.b;
import eu5.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class AdminPermissionProxyImpl implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f232864b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f232865a;

    public static final class a {
    }

    static {
    }

    public AdminPermissionProxyImpl() {
        this.f232865a = LazyKt.lazy(new AdminPermissionProxyImpl$canShowInDebug$2(this));
    }

    public static int d(int r100) {
        if (r100 != e.f541296g.f541317b) goto L6;
        return 6;
    L6:
        if (r100 != e.f541297h.f541317b) goto L9;
        return 7;
    L9:
        if (r100 != e.f541300k.f541317b) goto L12;
        return 9;
    L12:
        if (r100 != e.f541301l.f541317b) goto L15;
        return 10;
    L15:
        if (r100 != e.f541298i.f541317b) goto L17;
        return 8;
    L17:
        return 1;
    }

    public final boolean c(int r100) {
        if (c.e() == false) goto L6;
        return true;
    L6:
        if (((Boolean) this.f232865a.getValue()).booleanValue() == false) goto L8;
        return false;
    L8:
        Integer r101 = null;
        com.bytedance.ee.bear.middleground.permission.audit.e r102 = (com.bytedance.ee.bear.middleground.permission.audit.e) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.audit.e.class, null, null, 6);     // Catch: Throwable -> L11
    L13:
        if (r102 == null) goto L15;
        r101 = Integer.valueOf(r102.c(r100));
    L15:
        StringBuilder r103 = new StringBuilder("syncCheckAuthority, auditManager is null = ");
        if (r102 != null) goto L18;
        boolean r104 = true;
    L19:
        r103.append(r104);
        r103.append(",permissionType =");
        r103.append(r100);
        r103.append(", result = ");
        r103.append(r101);
        tt5.a.h("AdminPermissionProxyImpl", r103.toString());
        if (r101 != null) goto L23;
    L25:
        if (r101 != null) goto L28;
    L30:
        if (r101 != null) goto L33;
    L35:
        if (r101 != null) goto L38;
    L40:
        if (r101 == null) goto L49;
        r101.intValue();
        return true;
    L49:
        return true;
    L38:
        if (r101.intValue() != 2) goto L40;
        return true;
    L33:
        if (r101.intValue() != 4) goto L35;
    L34:
        return false;
    L28:
        if (r101.intValue() != 1) goto L30;
    L23:
        if (r101.intValue() != 0) goto L25;
        return true;
    L18:
        r104 = false;
    L11:
        th = move-exception;
        tt5.a.e("AdminPermissionProxyImpl", "getAuditManagerFailed", th, false);
        r102 = null;
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.b
    public final boolean a(int r100, String r101) {
        d(r100);
        return c(13);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.b
    public final boolean b(int r100, String r101) {
        d(r100);
        return c(3);
    }
}
