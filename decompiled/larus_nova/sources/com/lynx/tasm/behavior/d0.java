package com.lynx.tasm.behavior;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class d0 extends e0 implements EventEmitter.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList<u> f382001v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WeakReference<LynxContext> f382002w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final WeakReference<JSProxy> f382003x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f382004y;

    public LynxContext getContext() {
        return this.f382002w.get();
    }

    @Override // com.lynx.tasm.behavior.e0
    public final void i() {
        if (this.f382011f == true) goto L7;
        LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView not draw");
        return;
    L7:
        if (f() != null) goto L10;
        LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView is null");
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(new b0(this));
    }

    public final u m(int r100) {
        Iterator<u> r101 = this.f382001v.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = r101.next();
        if (r102.f382317a != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public d0(LynxContext r100, JSProxy r101) {
        super("Lynx.IntersectionObserver");
        TraceEvent.beginSection("LynxIntersectionObserverManager initialized");
        this.f382002w = new WeakReference(r100);
        this.f382006a = new WeakReference(r100.getUIBody());
        this.f382003x = new WeakReference(r101);
        this.f382001v = new ArrayList();
        this.f382004y = false;
        TraceEvent.endSection("LynxIntersectionObserverManager initialized");
    }

    @Override // com.lynx.tasm.EventEmitter.c
    public final void a(EventEmitter.LynxEventType r100, LynxEvent r101) {
        if (this.f382001v.size() != 0) goto L6;
        return;
    L6:
        if (r100 != EventEmitter.LynxEventType.kLynxEventTypeLayoutEvent) goto L9;
    L16:
        boolean r102 = true;
    L18:
        if (r102 == true) goto L20;
        return;
    L20:
        UIThreadUtils.runOnUiThreadImmediately(new b0(this));
        return;
    L9:
        if (r100 != EventEmitter.LynxEventType.kLynxEventTypeCustomEvent) goto L17;
        String r103 = r101.getName();
        if (GXViewKey.VIEW_TYPE_CONTAINER_SCROLL.equals(r103) == true) goto L16;
        if ("scrolltoupper".equals(r103) == true) goto L16;
        if ("scrolltolower".equals(r103) == true) goto L16;
    L17:
        r102 = false;
        goto L18
    }
}
