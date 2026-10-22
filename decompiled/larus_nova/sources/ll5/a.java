package ll5;

import cj5.b;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509677a = 0;

    static {
    }

    public static int a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "objToken");
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        e r100 = e.a.f499003a;
        Boolean r101 = Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.f());
        if (r101.booleanValue() == false) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L10;
        r101.booleanValue();
        tt5.a.k("DlpUtil", "getDlpErrorCode, isDlpPermEnable: false");
        return 0;
    L10:
        AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r102 == null) goto L13;
        String r103 = r102.tenantId;
    L15:
        if (r103 != null) goto L17;
    L20:
        boolean r104 = true;
    L21:
        if (r104 == true) goto L45;
        if (r110 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == true) goto L45;
        if (Intrinsics.areEqual(r103, r110) == false) goto L34;
        tt5.a.d("DlpUtil", "getDlpErrorCode, tenantId same as self: " + r110);
        return 0;
    L34:
        int r112 = ((d) org.koin.java.a.c(d.class, null, null, 6)).e(r111, sbb.e.f541301l.f541317b, "CCM_CONTENT_COPY", "", "");
        if (r112 != 1) goto L37;
        return 900099002;
    L37:
        if (r112 != 2) goto L39;
        return 900099004;
    L39:
        if (r112 != 3) goto L49;
        return -900099004;
    L49:
        return 0;
    L24:
        if (r110.length() == 0) goto L27;
        r105 = false;
    L45:
        tt5.a.d("DlpUtil", "getDlpErrorCode, tenantId invalid, selfTenantId: " + r103 + ", tenantId: " + r110);
        return 0;
    L17:
        if (r103.length() == 0) goto L20;
        r104 = false;
        goto L21
    L13:
        r103 = null;
        goto L15
    }
}
