package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class f extends DependencyNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f399802m;

    public f(WidgetRun r100) {
        super(r100);
        if ((r100 instanceof k) == false) goto L5;
        this.f399758e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.f399758e = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void c(int r100) {
        if (this.f399763j == false) goto L5;
        return;
    L5:
        this.f399763j = true;
        this.f399760g = r100;
        Iterator r101 = ((ArrayList) this.f399764k).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        d r102 = (d) r101.next();
        r102.update(r102);
        goto L7
    }
}
