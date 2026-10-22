package com.bytedance.ee.bear.imageviewer;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.ee.bear.browser.plugin.s> f226804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, WeakReference<Fragment>> f226805b;

    public a() {
        this.f226804a = new HashMap();
        this.f226805b = new HashMap();
    }

    public final void i(FragmentManager r100, String r101) {
        com.bytedance.ee.bear.browser.plugin.s r102 = (com.bytedance.ee.bear.browser.plugin.s) ((HashMap) this.f226804a).remove(r101);
        if (r100 == null) goto L5;
        Fragment r103 = r100.findFragmentByTag(r101);
    L6:
        WeakReference r104 = (WeakReference) ((HashMap) this.f226805b).remove(r101);
        if (r103 != null) goto L10;
        if (r104 == null) goto L10;
        r103 = (Fragment) r104.get();
    L10:
        if (r103 == null) goto L20;
        if (r100 != null) goto L13;
        return;
    L13:
        if (r100 != r103.getFragmentManager()) goto L22;
        FragmentTransaction r105 = r100.beginTransaction();
        if (r102 == null) goto L18;
        r105.setCustomAnimations(r102.f216644a, r102.f216645b, r102.f216646c, r102.f216647d);
    L18:
        r105.remove(r103).commitAllowingStateLoss();
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final FragmentTransaction j(FragmentManager r100, com.bytedance.ee.bear.browser.plugin.s r101, boolean r102, String r103) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FragmentTransaction r104 = r100.beginTransaction();
        if (r102 == false) goto L8;
        r104.setCustomAnimations(0, r101.f216645b, 0, r101.f216647d);
    L9:
        ((HashMap) this.f226804a).put(r103, r101);
        return r104;
    L8:
        r104.setCustomAnimations(r101.f216644a, r101.f216645b, r101.f216646c, r101.f216647d);
        goto L9
    }
}
