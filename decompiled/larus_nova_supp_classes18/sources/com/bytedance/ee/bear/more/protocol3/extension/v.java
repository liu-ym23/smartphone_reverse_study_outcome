package com.bytedance.ee.bear.more.protocol3.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class v extends com.bytedance.ee.bear.more.protocol3.h {
    public static final /* synthetic */ int l = 0;
    public int i;
    public final List<Function0<Unit>> j;
    public final List<Function0<Unit>> k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public void d() {
        this.i = 1;
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final void i() {
        this.i = 2;
        Iterator<T> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    }

    public v() {
        this.j = new ArrayList();
        this.k = new ArrayList();
    }

    public final void j(Function0<Unit> r3, Function0<Unit> r4) {
        int r0 = this.i;
        if (r0 < 2) goto L6;
        return;
    L6:
        if (r0 < 1) goto L9;
        if (r3 == null) goto L11;
        r3.invoke();
    L11:
        if (r4 == null) goto L14;
        ((ArrayList) this.k).add(r4);
        return;
    L14:
        return;
    L9:
        if (r3 == null) goto L11;
        ((ArrayList) this.j).add(r3);
        goto L11
    }
}
