package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetRun f399806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<WidgetRun> f399807b;

    public l(WidgetRun r100) {
        this.f399806a = null;
        this.f399807b = new ArrayList();
        this.f399806a = r100;
    }

    public static long a(DependencyNode r100, long r101) {
        WidgetRun r102 = r100.f399757d;
        if ((r102 instanceof j) == false) goto L5;
        return r101;
    L5:
        int r103 = ((ArrayList) r100.f399764k).size();
        int r104 = 0;
        long r105 = r101;
    L6:
        if (r104 >= r103) goto L15;
        d r106 = (d) ListProtector.get(r100.f399764k, r104);
        if ((r106 instanceof DependencyNode) == false) goto L13;
        DependencyNode r107 = (DependencyNode) r106;
        if (r107.f399757d == r102) goto L13;
        r105 = Math.min(r105, a(r107, ((long) r107.f399759f) + r101));
    L13:
        r104 = r104 + 1;
        goto L6
    L15:
        if (r100 != r102.f399775i) goto L22;
        long r108 = r102.i();
        long r109 = r101 - r108;
        return Math.min(Math.min(r105, a(r102.f399774h, r109)), r109 - ((long) r102.f399774h.f399759f));
    L22:
        return r105;
    }

    public static long b(DependencyNode r100, long r101) {
        WidgetRun r102 = r100.f399757d;
        if ((r102 instanceof j) == false) goto L5;
        return r101;
    L5:
        int r103 = ((ArrayList) r100.f399764k).size();
        int r104 = 0;
        long r105 = r101;
    L6:
        if (r104 >= r103) goto L15;
        d r106 = (d) ListProtector.get(r100.f399764k, r104);
        if ((r106 instanceof DependencyNode) == false) goto L13;
        DependencyNode r107 = (DependencyNode) r106;
        if (r107.f399757d == r102) goto L13;
        r105 = Math.max(r105, b(r107, ((long) r107.f399759f) + r101));
    L13:
        r104 = r104 + 1;
        goto L6
    L15:
        if (r100 != r102.f399774h) goto L22;
        long r108 = r102.i();
        long r109 = r101 + r108;
        return Math.max(Math.max(r105, b(r102.f399775i, r109)), r109 - ((long) r102.f399775i.f399759f));
    L22:
        return r105;
    }
}
