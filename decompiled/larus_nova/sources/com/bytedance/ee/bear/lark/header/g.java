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

/* JADX INFO: loaded from: classes16.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<i, Integer> f227384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f227385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f227386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f227387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f227388e;

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("HomePageHeaderManager", "destroy()...");
        Iterator r100 = ((LinkedHashMap) this.f227384a).keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((i) r100.next()).destroy();
        goto L4
    L6:
        ((LinkedHashMap) this.f227384a).clear();
        Lazy r101 = FGDowngradeHelper.f216485a;
        if (FGDowngradeHelper.b() == true) goto L11;
        LiveData<ConnectionService.NetworkState> r102 = this.f227388e;
        if (r102 == null) goto L16;
        r102.removeObservers(this.f227387d);
    L16:
        pd5.a.c(this.f227385b);
        return;
    L11:
        Object r103 = this.f227386c;
        if ((r103 instanceof LifecycleOwner) == false) goto L16;
        LiveData<ConnectionService.NetworkState> r104 = this.f227388e;
        if (r104 == null) goto L16;
        r104.removeObservers((LifecycleOwner) r103);
        goto L16
    }

    public final <T extends i> T e(Class<T> r100) {
        Iterator r101 = ((LinkedHashMap) this.f227384a).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        T r102 = (T) r101.next();
        if (r102.getClass().getName().equals(r100.getName()) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ee.bear.lark.header.d] */
    public final void f(final ViewGroup r100) {
        tt5.a.h("HomePageHeaderManager", "init()...");
        this.f227386c = r100.getContext();
        final ArrayList r101 = new ArrayList(this.f227384a.size());
        Iterator r102 = ((LinkedHashMap) this.f227384a).keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        i r103 = (i) r102.next();
        if (r103.a() == true) goto L7;
        r101.add(r103);
        goto L4
    L7:
        d(r103, r100);
        goto L4
    L9:
        this.f227385b = new d(this, r101, r100);
        pd5.a.a(this.f227385b);
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
        Iterator r101 = ((LinkedHashMap) this.f227384a).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((i) r101.next()).setUserVisibleHint(r100);
        goto L4
    }

    public g(h r100, Fragment r101) {
        LinkedHashMap r102 = new LinkedHashMap(6);
        this.f227384a = r102;
        tt5.a.h("HomePageHeaderManager", "HomePageHeaderManager()...");
        this.f227387d = r101;
        if (r100 == null) goto L6;
        r102.putAll(r100.getHeaders());
        return;
    }

    public final void d(i r100, ViewGroup r101) {
        tt5.a.h("HomePageHeaderManager", "addHeaderAndInitData()...header = " + r100);
        if (r100 != null) goto L5;
    L15:
        tt5.a.h("HomePageHeaderManager", "header already added, return");
        return;
    L5:
        if (r100.isAdded() == true) goto L15;
        Integer r102 = (Integer) ((LinkedHashMap) this.f227384a).get(r100);
        View r103 = r100.createView(r101.getContext());
        if (r103 == null) goto L17;
        if (r102 != null) goto L11;
    L12:
        r102 = Integer.valueOf(r101.getChildCount());
    L13:
        r101.addView(r103, r102.intValue());
        r100.c(r101.getContext());
        return;
    L11:
        if (r102.intValue() <= r101.getChildCount()) goto L13;
    }
}
