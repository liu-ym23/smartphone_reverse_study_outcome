package com.bytedance.ee.bear.more.protocol3.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public abstract class v extends com.bytedance.ee.bear.more.protocol3.h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f234849l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f234850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Function0<Unit>> f234851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Function0<Unit>> f234852k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public void d() {
        this.f234850i = 1;
        Iterator<T> r100 = this.f234851j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final void i() {
        this.f234850i = 2;
        Iterator<T> r100 = this.f234852k.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    }

    public v() {
        this.f234851j = new ArrayList();
        this.f234852k = new ArrayList();
    }

    public final void j(Function0<Unit> r100, Function0<Unit> r101) {
        int r102 = this.f234850i;
        if (r102 < 2) goto L6;
        return;
    L6:
        if (r102 < 1) goto L9;
        if (r100 == null) goto L11;
        r100.invoke();
    L11:
        if (r101 == null) goto L14;
        ((ArrayList) this.f234852k).add(r101);
        return;
    L14:
        return;
    L9:
        if (r100 == null) goto L11;
        ((ArrayList) this.f234851j).add(r100);
        goto L11
    }
}
