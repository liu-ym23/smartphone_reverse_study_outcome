package com.bytedance.ee.bear.middleground.permission.adminperm;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.middleground.permission.b;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final int a(int r3, int r4) {
        int r0 = b.a;
        if (c.a.a.f("ccm.security.legacy_file_protect_cloud_doc_download") == true) goto L6;
        return r3;
    L6:
        if (r4 == 10) goto L8;
        boolean r1 = true;
    L9:
        tt5.a.b("AdminPermissionProxyImpl", "getModifyEntityPerm permType= " + r3 + ", type= " + r4 + ", isDoc =" + r1);
        if (r3 != 3) goto L12;
        if (r1 == false) goto L29;
        return 24;
    L29:
        return r3;
    L12:
        if (r3 != 4) goto L14;
    L21:
        if (r1 == false) goto L28;
        return 25;
    L28:
        return r3;
    L14:
        if (r3 != 5) goto L16;
        if (r1 == false) goto L27;
        return 26;
    L27:
        return r3;
    L16:
        if (r3 == 6) goto L21;
        return r3;
    L8:
        r1 = false;
        goto L9
    }
}
