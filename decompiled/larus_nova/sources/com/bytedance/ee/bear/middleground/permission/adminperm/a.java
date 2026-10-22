package com.bytedance.ee.bear.middleground.permission.adminperm;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.middleground.permission.b;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final int a(int r100, int r101) {
        int r102 = b.f233101a;
        if (c.a.f206237a.f("ccm.security.legacy_file_protect_cloud_doc_download") == true) goto L6;
        return r100;
    L6:
        if (r101 == 10) goto L8;
        boolean r103 = true;
    L9:
        tt5.a.b("AdminPermissionProxyImpl", "getModifyEntityPerm permType= " + r100 + ", type= " + r101 + ", isDoc =" + r103);
        if (r100 != 3) goto L12;
        if (r103 == false) goto L29;
        return 24;
    L29:
        return r100;
    L12:
        if (r100 != 4) goto L14;
    L21:
        if (r103 == false) goto L28;
        return 25;
    L28:
        return r100;
    L14:
        if (r100 != 5) goto L16;
        if (r103 == false) goto L27;
        return 26;
    L27:
        return r100;
    L16:
        if (r100 == 6) goto L21;
        return r100;
    L8:
        r103 = false;
        goto L9
    }
}
