package com.bytedance.locallife.pdp.container.view.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<l, LynxLoader>> f261285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<l, LynxLoader>> f261286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<l> f261287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f261288d;

    public final void a() {
        ((ArrayList) this.f261288d).clear();
        Iterator<T> r100 = this.f261285a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LynxLoader) ((Pair) r100.next()).getSecond()).cancel();
        goto L4
    L6:
        Iterator<T> r101 = this.f261286b.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((LynxLoader) ((Pair) r101.next()).getSecond()).cancel();
        goto L8
    L10:
        ((ArrayList) this.f261286b).clear();
        ((ArrayList) this.f261285a).clear();
        ((ArrayList) this.f261287c).clear();
    }

    public a() {
        this.f261285a = new ArrayList();
        this.f261286b = new ArrayList();
        this.f261287c = new ArrayList();
        this.f261288d = new ArrayList();
    }

    public final void b(l r100, LynxLoader r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "loader");
        List<Pair<l, LynxLoader>> r102 = this.f261285a;
        ArrayList r103 = (ArrayList) r102;
        r103.remove(new Pair(r100, r101));
        List<Pair<l, LynxLoader>> r104 = this.f261286b;
        ArrayList r105 = (ArrayList) r104;
        r105.remove(new Pair(r100, r101));
    }
}
