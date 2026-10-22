package com.bytedance.ee.bear.list.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.functions.Function;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z0 implements Function<DocumentCreateEntity, DocumentCreateEntity> {
    public final com.bytedance.ee.bear.contract.h0 a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;

    public final Object apply(Object r7) throws Exception {
        DocumentCreateEntity r8 = (DocumentCreateEntity) r7;
        com.bytedance.ee.bear.contract.h0 r0 = this.a;
        if (r0 == null) goto L32;
        AccountService.Account r1 = r0.U5();
        if (r1 == null) goto L32;
        long r2 = System.currentTimeMillis() / 1000;
        Document r3 = new Document();
        r3.a = this.c;
        int r4 = r8.type;
        if (r4 != 0) goto L11;
    L14:
        r3.b = this.b;
    L15:
        r3.d = r8.getObjToken();
        r3.c = r8.getToken();
        r3.p = r8.getUrl();
        r3.j = String.valueOf(r2);
        r3.i = String.valueOf(r2);
        r3.l = String.valueOf(r2);
        r3.N = String.valueOf(r2);
        r3.M = String.valueOf(r2);
        r3.t = this.d;
        String r5 = r1.uid;
        r3.e = r5;
        r3.g = r5;
        String r6 = Locale.CHINESE.getLanguage();
        String r9 = r1.displayName;
        String r10 = r1.cnName;
        r3.r = ou5.a.d(r6, r9, r10, r10);
        String r11 = Locale.ENGLISH.getLanguage();
        String r12 = r1.displayName;
        String r13 = r1.enName;
        r3.s = ou5.a.d(r11, r12, r13, r13);
        r3.f = r1.tenantId;
        r3.p1 = true;
        int r14 = this.e;
        if (r14 == 0) goto L18;
        r3.L1 = r14;
    L20:
        if (TextUtils.isEmpty(r8.title) == true) goto L23;
        r3.a = r8.title;
    L23:
        if (r8.type != 16) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == false) goto L31;
        r3.d = r8.getToken();
        r3.b = 16;
        r3.y1 = r8.objType;
        r3.G1 = r8.objToken;
        String r16 = r8.getSpaceId();
        if (TextUtils.isEmpty(r16) == true) goto L30;
        oj5.d r17 = new oj5.d();
        r17.h(r16);
        r17.j(2);
        r17.i(eu5.b.a().getString(2131888790));
        r17.g(this.a.G2().uid);
        r3.O = GsonProtectorUtils.toJson(new Gson(), r17);
    L30:
        tt5.a.h("InsertDatabaseExecutor", "insertOnlineWikiToDatabase()...");
        r3.y2 = true;
        s0.e(r3);
        goto L32
    L31:
        s0.d(r3, this.d);
        goto L32
    L25:
        r15 = false;
        goto L26
    L18:
        r3.L1 = r8.ownerType;
        goto L20
    L11:
        if (r8.isWiki == true) goto L14;
        r3.b = r4;
    L32:
        return r8;
    }

    public z0(int r2, String r3) {
        this(r2, "", r3);
        this.e = 5;
        tt5.a.h("UpdateCacheFun", "UpdateCacheFun: ownerType:5");
    }

    public z0(int r1, String r2, String r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class);
    }
}
