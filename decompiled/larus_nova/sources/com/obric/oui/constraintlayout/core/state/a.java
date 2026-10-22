package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f399687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, sla.a> f399688b;

    public a update() {
        ConstraintWidget r100 = this.f399687a;
        if (r100 == null) goto L11;
        r100.u();
        this.f399687a.v();
        this.f399687a.u();
        this.f399687a.v();
        a r101 = this.f399687a.f399721k;
        if (r101 == null) goto L11;
        this.f399688b.clear();
        Iterator<sla.a> r102 = r101.f399688b.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        sla.a r103 = r102.next();
        this.f399688b.put(r103.f542505a, new sla.a(r103));
    L11:
        return this;
    }

    public a(ConstraintWidget r100) {
        this.f399687a = null;
        this.f399688b = new HashMap();
        this.f399687a = r100;
    }

    public a update(ConstraintWidget r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.f399687a = r100;
        update();
        return this;
    }
}
