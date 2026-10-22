package com.larksuite.component.blockit.props;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, WeakReference<PropsView>> f283112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<a>> f283113b;

    public d() {
        this.f283112a = new ConcurrentHashMap();
        this.f283113b = new ConcurrentHashMap();
    }

    public final void a(String r100, PropsView r101, a r102) {
        if (r101 == null) goto L4;
        Map<String, WeakReference<PropsView>> r103 = this.f283112a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r100, new WeakReference(r101));
    L4:
        if (r102 == null) goto L10;
        List r105 = (List) ((ConcurrentHashMap) this.f283113b).get(r100);
        if (r105 != null) goto L8;
        r105 = new ArrayList();
    L8:
        r105.add(r102);
        ((ConcurrentHashMap) this.f283113b).put(r100, r105);
        return;
    }
}
