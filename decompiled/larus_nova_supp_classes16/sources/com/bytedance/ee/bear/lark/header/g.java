package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.ConnectionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements j {
    public final Map<i, Integer> a;
    public d b;
    public Context c;
    public final Fragment d;
    public LiveData<ConnectionService.NetworkState> e;

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("HomePageHeaderManager", "destroy()...");
        Iterator r0 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).destroy();
        goto L4
    L6:
        ((LinkedHashMap) this.a).clear();
        Lazy r1 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == true) goto L11;
        LiveData<ConnectionService.NetworkState> r2 = this.e;
        if (r2 == null) goto L16;
        r2.removeObservers(this.d);
    L16:
        pd5.a.c(this.b);
        return;
    L11:
        LifecycleOwner r3 = this.c;
        if ((r3 instanceof LifecycleOwner) == false) goto L16;
        LiveData<ConnectionService.NetworkState> r4 = this.e;
        if (r4 == null) goto L16;
        r4.removeObservers(r3);
        goto L16
    }

    public final <T extends i> T e(Class<T> r5) {
        Iterator r0 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        T r1 = (T) r0.next();
        if (r1.getClass().getName().equals(r5.getName()) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ee.bear.lark.header.d] */
    public final void f(final ViewGroup r5) {
        tt5.a.h("HomePageHeaderManager", "init()...");
        this.c = r5.getContext();
        final ArrayList r0 = new ArrayList(this.a.size());
        Iterator r1 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        i r2 = (i) r1.next();
        if (r2.a() == true) goto L7;
        r0.add(r2);
        goto L4
    L7:
        d(r2, r5);
        goto L4
    L9:
        this.b = new d(this, r0, r5);
        pd5.a.a(this.b);
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r3) {
        Iterator r0 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).setUserVisibleHint(r3);
        goto L4
    }

    public g(h r4, Fragment r5) {
        LinkedHashMap r0 = new LinkedHashMap(6);
        this.a = r0;
        tt5.a.h("HomePageHeaderManager", "HomePageHeaderManager()...");
        this.d = r5;
        if (r4 == null) goto L6;
        r0.putAll(r4.getHeaders());
        return;
    }

    public final void d(i r5, ViewGroup r6) {
        tt5.a.h("HomePageHeaderManager", "addHeaderAndInitData()...header = " + r5);
        if (r5 != null) goto L5;
    L15:
        tt5.a.h("HomePageHeaderManager", "header already added, return");
        return;
    L5:
        if (r5.isAdded() == true) goto L15;
        Integer r0 = (Integer) ((LinkedHashMap) this.a).get(r5);
        View r1 = r5.createView(r6.getContext());
        if (r1 == null) goto L17;
        if (r0 != null) goto L11;
    L12:
        r0 = Integer.valueOf(r6.getChildCount());
    L13:
        r6.addView(r1, r0.intValue());
        r5.c(r6.getContext());
        return;
    L11:
        if (r0.intValue() <= r6.getChildCount()) goto L13;
    }
}
