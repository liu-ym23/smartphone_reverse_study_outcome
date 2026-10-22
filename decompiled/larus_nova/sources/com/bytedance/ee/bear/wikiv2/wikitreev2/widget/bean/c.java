package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static final boolean c(int r100) {
        if (r100 != (-5)) goto L5;
    L11:
        return true;
    L5:
        if (r100 == (-4)) goto L11;
        if (r100 == (-1)) goto L11;
        if (r100 == 2) goto L11;
        return false;
    }

    public static final boolean a(String r100) {
        return TextUtils.equals("wikiroot%top_cloud_document_token", r100);
    }

    public static final boolean b(j r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f241920h != (-5)) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        VirtualNode.a r102 = VirtualNode.Companion;
        String r103 = r100.f241914b;
        r102.getClass();
        if (VirtualNode.a.a(r103) == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
