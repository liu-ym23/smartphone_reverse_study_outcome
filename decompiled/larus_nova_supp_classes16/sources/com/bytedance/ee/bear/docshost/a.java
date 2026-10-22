package com.bytedance.ee.bear.docshost;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements mw4.a {
    public final Map<String, mw4.a.InterfaceC0257a> a;

    @Override // mw4.a
    public final void c() {
        Iterator r0 = ((ConcurrentHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((mw4.a.InterfaceC0257a) ((Map.Entry) r0.next()).getValue()).onChanged();
        goto L4
    }

    @Override // mw4.a
    public final boolean isNightMode() {
        Context r0 = AppLifecycle.a.a.f();
        Application r1 = LarkContext.getApplication();
        if (r0 != null) goto L7;
        r0 = r1;
    L7:
        return h18.f.a(r0);
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }

    @Override // mw4.a
    public final void a(mw4.a.InterfaceC0257a r2) {
        Map<String, mw4.a.InterfaceC0257a> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.remove(r2.getClass().getSimpleName());
    }

    @Override // mw4.a
    public final void b(mw4.a.InterfaceC0257a r3) {
        Map<String, mw4.a.InterfaceC0257a> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r3.getClass().getSimpleName(), r3);
    }
}
