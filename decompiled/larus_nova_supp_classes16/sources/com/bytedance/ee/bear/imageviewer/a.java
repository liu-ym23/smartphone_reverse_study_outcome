package com.bytedance.ee.bear.imageviewer;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a {
    public final Map<String, com.bytedance.ee.bear.browser.plugin.s> a;
    public final Map<String, WeakReference<Fragment>> b;

    public a() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final void i(FragmentManager r5, String r6) {
        com.bytedance.ee.bear.browser.plugin.s r0 = (com.bytedance.ee.bear.browser.plugin.s) ((HashMap) this.a).remove(r6);
        if (r5 == null) goto L5;
        Fragment r1 = r5.findFragmentByTag(r6);
    L6:
        WeakReference r7 = (WeakReference) ((HashMap) this.b).remove(r6);
        if (r1 != null) goto L10;
        if (r7 == null) goto L10;
        r1 = (Fragment) r7.get();
    L10:
        if (r1 == null) goto L20;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5 != r1.getFragmentManager()) goto L22;
        FragmentTransaction r8 = r5.beginTransaction();
        if (r0 == null) goto L18;
        r8.setCustomAnimations(r0.a, r0.b, r0.c, r0.d);
    L18:
        r8.remove(r1).commitAllowingStateLoss();
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final FragmentTransaction j(FragmentManager r4, com.bytedance.ee.bear.browser.plugin.s r5, boolean r6, String r7) {
        if (r4 != null) goto L5;
        return null;
    L5:
        FragmentTransaction r8 = r4.beginTransaction();
        if (r6 == false) goto L8;
        r8.setCustomAnimations(0, r5.b, 0, r5.d);
    L9:
        ((HashMap) this.a).put(r7, r5);
        return r8;
    L8:
        r8.setCustomAnimations(r5.a, r5.b, r5.c, r5.d);
        goto L9
    }
}
