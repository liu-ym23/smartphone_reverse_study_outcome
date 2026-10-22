package com.bytedance.ee.bear.list.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import mc5.u1;
import mc5.v1;

/* JADX INFO: loaded from: classes18.dex */
public final class s0 {
    public static boolean a(Document r100) {
        if (mc5.m.a(r100).P9(r100.f227873d) != null) goto L6;
        mc5.b r101 = u1.c(r100);
        mc5.m.a(r100).Ie(r101);
        return true;
    L6:
        return false;
    }

    public static void e(Document r100) {
        tt5.a.h("InsertDatabaseExecutor", "insertRecent()...");
        v1 r101 = u1.f(r100, 1);
        r101.f513187c = "";
        r101.f513190f = "";
        if (r100.getType() != 16) goto L5;
        r101.f513188d = r100.O;
    L5:
        insert(u1.c(r100), r101);
        if (qc5.a.h() == false) goto L9;
        v1 r102 = u1.f(r100, 14);
        r102.f513187c = "";
        r102.f513190f = "";
        insert(u1.c(r100), r102);
        return;
    }

    public static void f(mc5.b r100) {
        tt5.a.h("InsertDatabaseExecutor", "insertRecent()...");
        v1 r101 = new v1();
        r101.f513186b = 1;
        r101.f513185a = r100.f512887a;
        String r102 = r100.f512901i;
        r101.f513193i = r102;
        r101.f513194j = r102;
        r101.f513195k = r102;
        r101.f513188d = r100.f512890b0;
        insert(r100, r101);
        if (qc5.a.f() == false) goto L6;
        v1 r103 = new v1();
        r103.f513186b = 14;
        r103.f513185a = r100.f512887a;
        String r104 = r100.f512901i;
        r103.f513193i = r104;
        r103.f513194j = r104;
        r103.f513195k = r104;
        r103.f513188d = r100.f512890b0;
        insert(r100, r103);
        return;
    }

    public static boolean b(mc5.b r100, String r101) {
        v1 r102 = new v1();
        r102.f513185a = r100.f512887a;
        r102.f513190f = r101;
        r102.f513186b = 9;
        r102.f513196l = true;
        r102.f513188d = r100.f512890b0;
        long r103 = mc5.m.a(r100).p6(r100, r102);
        tt5.a.h("InsertDatabaseExecutor", "insertOfflineOperate()...result = " + r103);
        if (r103 >= 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean c(mc5.b r100, String r110) {
        tt5.a.h("InsertDatabaseExecutor", "insertOfflineDocToDatabase()...");
        r100.Z = true;
        if (b(r100, r110) == false) goto L13;
        f(r100);
        tt5.a.h("InsertDatabaseExecutor", "insertMine()...");
        v1 r101 = new v1();
        r101.f513186b = 2;
        r101.f513185a = r100.f512887a;
        r101.f513190f = "";
        insert(r100, r101);
        tt5.a.h("InsertDatabaseExecutor", "insertFolder()...parentToken = " + du5.b.g(r110));
        v1 r102 = new v1();
        r102.f513196l = true;
        r102.f513197m = false;
        r102.f513191g = String.valueOf(System.currentTimeMillis() / 1000);
        r102.f513186b = 3;
        r102.f513185a = r100.f512887a;
        r102.f513190f = r110;
        insert(r100, r102);
        if (qc5.a.f() == true) goto L7;
    L12:
        return true;
    L7:
        if (TextUtils.equals("", r110) == false) goto L12;
        if (TextUtils.equals(String.valueOf(0), r100.getType()) == false) goto L11;
        tt5.a.h("InsertDatabaseExecutor", "insertSidebarFolder()...parentToken = " + du5.b.g(r110));
        v1 r103 = new v1();
        r103.f513196l = true;
        r103.f513197m = false;
        r103.f513191g = String.valueOf(System.currentTimeMillis() / 1000);
        r103.f513186b = 16;
        r103.f513185a = r100.f512887a;
        r103.f513190f = r110;
        insert(r100, r103);
        goto L12
    L11:
        tt5.a.h("InsertDatabaseExecutor", "insertSidebarDoc()...parentToken = " + du5.b.g(r110));
        v1 r111 = new v1();
        r111.f513186b = 17;
        r111.f513185a = r100.f512887a;
        r111.f513190f = "";
        insert(r100, r111);
        goto L12
    L13:
        return false;
    }

    public static void d(Document r100, String r101) {
        tt5.a.h("InsertDatabaseExecutor", "insertOnlineDocToDatabase()...");
        r100.f227909y2 = true;
        if (r100.getType() == sbb.e.f541295f.f541317b) goto L5;
        e(r100);
        tt5.a.h("InsertDatabaseExecutor", "insertMine()...");
        v1 r102 = u1.f(r100, 2);
        r102.f513190f = "";
        r102.f513187c = "";
        insert(u1.c(r100), r102);
    L5:
        tt5.a.h("InsertDatabaseExecutor", "insertFolder()...parentToken = " + du5.b.g(r101));
        v1 r103 = u1.f(r100, 3);
        r103.f513190f = r101;
        insert(u1.c(r100), r103);
        if (qc5.a.h() == true) goto L8;
        return;
    L8:
        if (TextUtils.equals("", r101) == false) goto L16;
        tt5.a.h("InsertDatabaseExecutor", "insertSidebar document ()...parentToken = " + du5.b.g(r101));
        if (r100.getType() != 0) goto L12;
        int r104 = 16;
    L13:
        v1 r105 = u1.f(r100, r104);
        r105.f513190f = r101;
        insert(u1.c(r100), r105);
        return;
    L12:
        r104 = 17;
        goto L13
    }

    private static void insert(mc5.b r100, v1 r101) {
        tt5.a.h("InsertDatabaseExecutor", "insert()...listType = " + r101.f513186b + ", result = " + mc5.m.a(r100).p6(r100, r101));
    }
}
