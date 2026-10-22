package zic;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uic.j;

/* JADX INFO: loaded from: classes40.dex */
public abstract class a extends b implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f572352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f572353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f572354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<j> f572355h;

    public a() {
        this.f572352e = true;
        this.f572353f = false;
        this.f572354g = new ArrayList();
        this.f572355h = new ArrayList();
        this.f572352e = true;
    }

    @Override // zic.b, yic.a
    public final void f(c r100) {
        if (this.f572352e == true) goto L5;
        super.f(r100);
        return;
    L5:
        this.f572356a = r100;
    }

    @Override // zic.d
    public final void g(uic.d r100) {
        if (this.f572353f == false) goto L5;
        return;
    L5:
        if (this.f572352e == false) goto L30;
        if (r100 != null) goto L9;
        return;
    L9:
        List<Integer> r101 = this.f572354g;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(Integer.valueOf(r100.getType())) == true) goto L12;
        h();
        r100.getType();
        throw null;
    L12:
        if (this.f572353f == false) goto L14;
    L21:
        Iterator r103 = ((ArrayList) this.f572355h).iterator();
    L23:
        if (r103.hasNext() == false) goto L25;
        j r104 = (j) r103.next();
        goto L23
    L25:
        return;
    L14:
        if (this.f572352e == false) goto L21;
        Context r105 = getContext();
        if (r105 == null) goto L20;
        LayoutInflater.from(r105);
    L20:
        getContext();
        this.f572353f = true;
        goto L21
    }
}
