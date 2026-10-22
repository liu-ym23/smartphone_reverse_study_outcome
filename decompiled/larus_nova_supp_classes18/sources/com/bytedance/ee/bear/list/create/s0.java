package com.bytedance.ee.bear.list.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import mc5.u1;
import mc5.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0 {
    public static boolean a(Document r2) {
        if (mc5.m.a(r2).P9(r2.d) != null) goto L6;
        mc5.b r0 = u1.c(r2);
        mc5.m.a(r2).Ie(r0);
        return true;
    L6:
        return false;
    }

    public static void e(Document r4) {
        tt5.a.h("InsertDatabaseExecutor", "insertRecent()...");
        v1 r0 = u1.f(r4, 1);
        r0.c = "";
        r0.f = "";
        if (r4.getType() != 16) goto L5;
        r0.d = r4.O;
    L5:
        insert(u1.c(r4), r0);
        if (qc5.a.h() == false) goto L9;
        v1 r1 = u1.f(r4, 14);
        r1.c = "";
        r1.f = "";
        insert(u1.c(r4), r1);
        return;
    }

    public static void f(mc5.b r2) {
        tt5.a.h("InsertDatabaseExecutor", "insertRecent()...");
        v1 r0 = new v1();
        r0.b = 1;
        r0.a = r2.a;
        String r1 = r2.i;
        r0.i = r1;
        r0.j = r1;
        r0.k = r1;
        r0.d = r2.b0;
        insert(r2, r0);
        if (qc5.a.f() == false) goto L6;
        v1 r3 = new v1();
        r3.b = 14;
        r3.a = r2.a;
        String r4 = r2.i;
        r3.i = r4;
        r3.j = r4;
        r3.k = r4;
        r3.d = r2.b0;
        insert(r2, r3);
        return;
    }

    public static boolean b(mc5.b r4, String r5) {
        v1 r0 = new v1();
        r0.a = r4.a;
        r0.f = r5;
        r0.b = 9;
        r0.l = true;
        r0.d = r4.b0;
        long r1 = mc5.m.a(r4).p6(r4, r0);
        tt5.a.h("InsertDatabaseExecutor", "insertOfflineOperate()...result = " + r1);
        if (r1 >= 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean c(mc5.b r9, String r10) {
        tt5.a.h("InsertDatabaseExecutor", "insertOfflineDocToDatabase()...");
        r9.Z = true;
        if (b(r9, r10) == false) goto L13;
        f(r9);
        tt5.a.h("InsertDatabaseExecutor", "insertMine()...");
        v1 r2 = new v1();
        r2.b = 2;
        r2.a = r9.a;
        r2.f = "";
        insert(r9, r2);
        tt5.a.h("InsertDatabaseExecutor", "insertFolder()...parentToken = " + du5.b.g(r10));
        v1 r3 = new v1();
        r3.l = true;
        r3.m = false;
        r3.g = String.valueOf(System.currentTimeMillis() / 1000);
        r3.b = 3;
        r3.a = r9.a;
        r3.f = r10;
        insert(r9, r3);
        if (qc5.a.f() == true) goto L7;
    L12:
        return true;
    L7:
        if (TextUtils.equals("", r10) == false) goto L12;
        if (TextUtils.equals(String.valueOf(0), r9.getType()) == false) goto L11;
        tt5.a.h("InsertDatabaseExecutor", "insertSidebarFolder()...parentToken = " + du5.b.g(r10));
        v1 r1 = new v1();
        r1.l = true;
        r1.m = false;
        r1.g = String.valueOf(System.currentTimeMillis() / 1000);
        r1.b = 16;
        r1.a = r9.a;
        r1.f = r10;
        insert(r9, r1);
        goto L12
    L11:
        tt5.a.h("InsertDatabaseExecutor", "insertSidebarDoc()...parentToken = " + du5.b.g(r10));
        v1 r11 = new v1();
        r11.b = 17;
        r11.a = r9.a;
        r11.f = "";
        insert(r9, r11);
        goto L12
    L13:
        return false;
    }

    public static void d(Document r4, String r5) {
        tt5.a.h("InsertDatabaseExecutor", "insertOnlineDocToDatabase()...");
        r4.y2 = true;
        if (r4.getType() == sbb.e.f.b) goto L5;
        e(r4);
        tt5.a.h("InsertDatabaseExecutor", "insertMine()...");
        v1 r1 = u1.f(r4, 2);
        r1.f = "";
        r1.c = "";
        insert(u1.c(r4), r1);
    L5:
        tt5.a.h("InsertDatabaseExecutor", "insertFolder()...parentToken = " + du5.b.g(r5));
        v1 r2 = u1.f(r4, 3);
        r2.f = r5;
        insert(u1.c(r4), r2);
        if (qc5.a.h() == true) goto L8;
        return;
    L8:
        if (TextUtils.equals("", r5) == false) goto L16;
        tt5.a.h("InsertDatabaseExecutor", "insertSidebar document ()...parentToken = " + du5.b.g(r5));
        if (r4.getType() != 0) goto L12;
        int r0 = 16;
    L13:
        v1 r3 = u1.f(r4, r0);
        r3.f = r5;
        insert(u1.c(r4), r3);
        return;
    L12:
        r0 = 17;
        goto L13
    }

    private static void insert(mc5.b r3, v1 r4) {
        tt5.a.h("InsertDatabaseExecutor", "insert()...listType = " + r4.b + ", result = " + mc5.m.a(r3).p6(r3, r4));
    }
}
