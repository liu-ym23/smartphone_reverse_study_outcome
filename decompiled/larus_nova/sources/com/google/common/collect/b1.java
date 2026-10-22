package com.google.common.collect;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
public final class b1 extends AbstractIterator<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterator f275428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.n f275429d;

    @Override // com.google.common.collect.AbstractIterator
    @CheckForNull
    public final Object a() {
    L3:
        if (this.f275428c.hasNext() == false) goto L7;
        Object r100 = this.f275428c.next();
        if (this.f275429d.apply(r100) == false) goto L3;
        return r100;
    L7:
        this.f274902a = AbstractIterator.State.DONE;
        return null;
    }

    public b1(Iterator r100, com.google.common.base.n r101) {
        this.f275428c = r100;
        this.f275429d = r101;
    }
}
