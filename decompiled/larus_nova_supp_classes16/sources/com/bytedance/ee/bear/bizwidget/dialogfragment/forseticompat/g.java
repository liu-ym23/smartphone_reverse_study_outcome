package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public static sa5.b a(FragmentActivity r3, Fragment r4) {
        boolean r0 = ForsetiHelper.s(r4);
        if (r0 == false) goto L7;
        sa5.b r1 = (sa5.b) sa5.m.a.b(ForsetiHelper.g(r4), sa5.b.class);
        if (r1 != null) goto L10;
        r1 = (sa5.b) sa5.m.a.a(r3, sa5.b.class);
    L10:
        if (r1 != null) goto L13;
        tt5.a.d("ForsetiBackPressDispatcher", "BackPressDispatcher is null! forseti:" + r0 + " sourceFragment:" + r4);
        return null;
    L13:
        return r1;
    L7:
        r1 = (sa5.b) sa5.m.a.a(r3, sa5.b.class);
        if (r1 != null) goto L10;
        r1 = (sa5.b) sa5.m.a.b(r4, sa5.b.class);
        goto L10
    }
}
