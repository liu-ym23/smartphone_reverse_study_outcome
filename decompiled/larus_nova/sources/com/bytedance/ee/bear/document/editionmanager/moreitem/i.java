package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements com.bytedance.ee.bear.more.protocol3.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f219645a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r100 = this.f219645a.c();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.m() == false) goto L7;
        return false;
    L7:
        if (z05.i.b(r100.i()) == false) goto L30;
        String r101 = r100.getToken();
        Map<String, z05.g> r102 = z05.f.f569616a;
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((ConcurrentHashMap) z05.f.f569616a).values().iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        z05.g r105 = (z05.g) r104.next();
        if (r101.equals(r105.f569623g) == false) goto L11;
        r103.add(r105);
        goto L11
    L16:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        r103.sort(new z05.e());
    L19:
        if (r103.size() <= 0) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    }

    public i(g r100) {
        this.f219645a = r100;
    }
}
