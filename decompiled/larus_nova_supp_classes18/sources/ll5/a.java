package ll5;

import cj5.b;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "objToken");
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        e r0 = e.a.a;
        Boolean r1 = Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.f());
        if (r1.booleanValue() == false) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L10;
        r1.booleanValue();
        tt5.a.k("DlpUtil", "getDlpErrorCode, isDlpPermEnable: false");
        return 0;
    L10:
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r2 == null) goto L13;
        String r3 = r2.tenantId;
    L15:
        if (r3 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L45;
        if (r12 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L45;
        if (Intrinsics.areEqual(r3, r12) == false) goto L34;
        tt5.a.d("DlpUtil", "getDlpErrorCode, tenantId same as self: " + r12);
        return 0;
    L34:
        int r14 = ((d) org.koin.java.a.c(d.class, null, null, 6)).e(r13, sbb.e.l.b, "CCM_CONTENT_COPY", "", "");
        if (r14 != 1) goto L37;
        return 900099002;
    L37:
        if (r14 != 2) goto L39;
        return 900099004;
    L39:
        if (r14 != 3) goto L49;
        return -900099004;
    L49:
        return 0;
    L24:
        if (r12.length() == 0) goto L27;
        r7 = false;
    L45:
        tt5.a.d("DlpUtil", "getDlpErrorCode, tenantId invalid, selfTenantId: " + r3 + ", tenantId: " + r12);
        return 0;
    L17:
        if (r3.length() == 0) goto L20;
        r6 = false;
        goto L21
    L13:
        r3 = null;
        goto L15
    }
}
