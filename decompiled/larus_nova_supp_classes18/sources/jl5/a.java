package jl5;

import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a() {
        User r0 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r0 == null) goto L5;
        String r1 = r0.getSession();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final String b() {
        User r0 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r0 == null) goto L5;
        String r1 = r0.userId;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean c() {
        User r0 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Tenant r1 = r0.tenant;
        if (r1 == null) goto L7;
        String r2 = r1.tenantId;
    L8:
        int r3 = com.ss.android.lark.passport.signinsdk_api.contants.a.a;
        if (Intrinsics.areEqual(r2, "1") != true) goto L11;
        return true;
    L7:
        r2 = null;
    L11:
        return false;
    }

    @JvmStatic
    public static final int d() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).oldSdkEnv();
    }
}
