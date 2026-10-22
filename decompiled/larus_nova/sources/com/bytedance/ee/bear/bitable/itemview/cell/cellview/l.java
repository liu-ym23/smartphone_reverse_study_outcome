package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements fc5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f213880a = null;

    static {
        f213880a = new l();
    }

    public l() {
    }

    @Override // fc5.d
    public final boolean a(String r100) {
        t45.c r101 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.record.fix.addbaseurl.onpaste") == false) goto L17;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        BearUrl r103 = r101.Z(r100);
        if (com.bytedance.ee.bear.bitable.utils.b.b(r103) == true) goto L15;
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L17;
    L11:
        if (s45.a.d(r103.f222571l) == false) goto L13;
        r104 = true;
    L15:
        return false;
    L17:
        return r101.v6(r100);
    }
}
