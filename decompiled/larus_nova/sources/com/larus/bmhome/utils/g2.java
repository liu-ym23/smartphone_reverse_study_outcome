package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes26.dex */
public final class g2 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f315017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f315018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f315019c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r100 = this.f315017a;
        if (r100 == null) goto L5;
        r100.getViewTreeObserver().removeOnPreDrawListener(this);
    L5:
        this.f315018b.set(true);
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L14;
        r101.r();
        mc9.a.f513246a.j(this.f315019c);
        Iterator<f2.b> r102 = f2.f315012d.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        r102.next().b();     // Catch: Throwable -> L13
    L14:
        return true;
    }

    public g2(View r100, AtomicBoolean r101, String r102) {
        this.f315017a = r100;
        this.f315018b = r101;
        this.f315019c = r102;
    }
}
