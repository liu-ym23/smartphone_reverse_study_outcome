package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.manager.DecisionLogManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.q;
import i8b.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends i8b.a {

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    @Override // i8b.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
    }

    public k(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        super(r100);
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof t) == false) goto L29;
        List r111 = (List) ((t) r110).f440413a;
        if (r111.isEmpty() == true) goto L79;
        ArrayList r100 = new ArrayList();
        Iterator r112 = r111.iterator();
    L9:
        if (r112.hasNext() == false) goto L26;
        ValidateLogInfo r101 = (ValidateLogInfo) r112.next();
        LinkedList<String> r102 = r101.getPolicySetKeys();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();
        String r106 = (String) r105;
        List<String> r113 = w4c.c.a().k0();
        if (r113 == null) goto L16;
        boolean r107 = r113.contains(r106);
    L17:
        if (r107 == true) goto L12;
        r103.add(r105);
        goto L12
    L16:
        r107 = false;
        goto L17
    L20:
        if ((!r103.isEmpty()) == false) goto L22;
        oe6.a r108 = new oe6.a(r101.getUk(), r103, String.valueOf(System.currentTimeMillis()));
    L23:
        if (r108 == null) goto L9;
        r100.add(r108);
        goto L9
    L22:
        r108 = null;
        goto L23
    L26:
        if ((!r100.isEmpty()) == false) goto L75;
        int r114 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_LogReportService", "[report log], report log, log is " + com.ss.android.lark.security.compliance.infra.util.f.c(r100));
        ke6.d.f503032a.getClass();
        Intrinsics.checkNotNullParameter(r100, "evaluateInfoList");
        DecisionLogManager.f(r100);
        return;
    L75:
        return;
    L79:
        return;
    L29:
        if ((r110 instanceof i8b.j) == false) goto L77;
        List r115 = (List) ((i8b.j) r110).f440413a;
        if (r115.isEmpty() == true) goto L80;
        ArrayList r109 = new ArrayList();
        Iterator r116 = r115.iterator();
    L35:
        if (r116.hasNext() == false) goto L52;
        ValidateLogInfo r117 = (ValidateLogInfo) r116.next();
        LinkedList<String> r118 = r117.getPolicySetKeys();
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L38:
        if (r120.hasNext() == false) goto L46;
        Object r121 = r120.next();
        String r122 = (String) r121;
        List<String> r123 = w4c.c.a().j0();
        if (r123 == null) goto L42;
        boolean r124 = r123.contains(r122);
    L43:
        if (r124 == true) goto L38;
        r119.add(r121);
        goto L38
    L42:
        r124 = false;
        goto L43
    L46:
        if ((!r119.isEmpty()) == false) goto L48;
        oe6.a r125 = new oe6.a(r117.getUk(), r119, String.valueOf(System.currentTimeMillis()));
    L49:
        if (r125 == null) goto L35;
        r109.add(r125);
        goto L35
    L48:
        r125 = null;
        goto L49
    L52:
        if ((!r109.isEmpty()) == false) goto L78;
        int r126 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_LogReportService", "delete log, log is " + com.ss.android.lark.security.compliance.infra.util.f.c(r109));
        ke6.d.f503032a.getClass();
        Intrinsics.checkNotNullParameter(r109, "evaluateInfoList");
        DecisionLogManager.a(r109);
        return;
    L78:
        return;
    L80:
        return;
    }
}
