package jl5;

import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yzb.b;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f499529a = 0;

    static {
    }

    @JvmStatic
    public static final String a() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 == null) goto L5;
        String r101 = r100.getSession();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final String b() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 == null) goto L5;
        String r101 = r100.userId;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean c() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Tenant r101 = r100.tenant;
        if (r101 == null) goto L7;
        String r102 = r101.tenantId;
    L8:
        int r103 = com.ss.android.lark.passport.signinsdk_api.contants.a.f438069a;
        if (Intrinsics.areEqual(r102, "1") != true) goto L11;
        return true;
    L7:
        r102 = null;
    L11:
        return false;
    }

    @JvmStatic
    public static final int d() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).oldSdkEnv();
    }
}
