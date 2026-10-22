package com.bytedance.ee.bear.docshost;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements mw4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, mw4.a.InterfaceC6863a> f218476a;

    @Override // mw4.a
    public final void c() {
        Iterator r100 = ((ConcurrentHashMap) this.f218476a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((mw4.a.InterfaceC6863a) ((Map.Entry) r100.next()).getValue()).onChanged();
        goto L4
    }

    @Override // mw4.a
    public final boolean isNightMode() {
        Context r100 = AppLifecycle.a.f408803a.f();
        Application r101 = LarkContext.getApplication();
        if (r100 != null) goto L7;
        r100 = r101;
    L7:
        return h18.f.a(r100);
    }

    public a() {
        this.f218476a = new ConcurrentHashMap();
    }

    @Override // mw4.a
    public final void a(mw4.a.InterfaceC6863a r100) {
        Map<String, mw4.a.InterfaceC6863a> r101 = this.f218476a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.remove(r100.getClass().getSimpleName());
    }

    @Override // mw4.a
    public final void b(mw4.a.InterfaceC6863a r100) {
        Map<String, mw4.a.InterfaceC6863a> r101 = this.f218476a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100.getClass().getSimpleName(), r100);
    }
}
