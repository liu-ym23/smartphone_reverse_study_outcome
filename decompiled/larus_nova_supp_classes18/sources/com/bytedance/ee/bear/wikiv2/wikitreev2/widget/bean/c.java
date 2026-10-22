package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final boolean c(int r1) {
        if (r1 != (-5)) goto L5;
    L11:
        return true;
    L5:
        if (r1 == (-4)) goto L11;
        if (r1 == (-1)) goto L11;
        if (r1 == 2) goto L11;
        return false;
    }

    public static final boolean a(String r1) {
        return TextUtils.equals("wikiroot%top_cloud_document_token", r1);
    }

    public static final boolean b(j r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.h != (-5)) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L14;
        VirtualNode.a r2 = VirtualNode.Companion;
        String r5 = r4.b;
        r2.getClass();
        if (VirtualNode.a.a(r5) == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L7:
        r1 = false;
        goto L8
    }
}
