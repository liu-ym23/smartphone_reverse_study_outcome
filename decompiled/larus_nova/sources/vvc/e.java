package vvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.internal.h;
import org.commonmark.internal.m;
import org.commonmark.node.Block;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<wvc.e> f557404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<xvc.a> f557405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f557406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f557407d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<wvc.e> f557408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<xvc.a> f557409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<f> f557410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Set<Class<? extends Block>> f557411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f557412e;

        public a() {
            this.f557408a = new ArrayList();
            this.f557409b = new ArrayList();
            this.f557410c = new ArrayList();
            this.f557411d = h.f525688p;
        }

        public final void a(wvc.b r100) {
            ((ArrayList) this.f557408a).add(r100);
        }

        public final void b(Iterable r100) {
            if (r100 == null) goto L11;
            Iterator r101 = r100.iterator();
        L5:
            if (r101.hasNext() == false) goto L9;
            pvc.a r102 = (pvc.a) r101.next();
            if ((r102 instanceof b) == false) goto L5;
            ((b) r102).a(this);
            goto L5
        L9:
            return;
        L11:
            throw new NullPointerException("extensions must not be null");
        }
    }

    public interface b extends pvc.a {
        void a(a r100);
    }

    public e(a r100) {
        List<wvc.e> r101 = r100.f557408a;
        Set<Class<? extends Block>> r102 = r100.f557411d;
        Set<Class<? extends Block>> r103 = h.f525688p;
        ArrayList r104 = new ArrayList();
        r104.addAll(r101);
        Iterator<Class<? extends Block>> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Class<? extends Block> r106 = r105.next();
        r104.add(h.f525689q.get(r106));
        goto L4
    L6:
        this.f557404a = r104;
        c r107 = r100.f557412e;
        if (r107 != null) goto L10;
        r107 = new d();
    L10:
        this.f557406c = r107;
        this.f557407d = r100.f557410c;
        List<xvc.a> r108 = r100.f557409b;
        this.f557405b = r108;
        r107.a(new m(r108, Collections.emptyMap()));
    }

    public final uvc.b a(String r100) {
        if (r100 == null) goto L36;
        h r101 = new h(this.f557404a, this.f557406c, this.f557405b);
        int r102 = 0;
    L4:
        int r103 = r100.length();
        int r104 = r102;
    L6:
        if (r104 >= r103) goto L11;
        char r105 = r100.charAt(r104);
        if (r105 == '\n') goto L12;
        if (r105 == '\r') goto L12;
        r104 = r104 + 1;
    L12:
        if (r104 == (-1)) goto L21;
        r101.i(r100.substring(r102, r104));
        r102 = r104 + 1;
        if (r102 >= r100.length()) goto L4;
        if (r100.charAt(r104) != '\r') goto L4;
        if (r100.charAt(r102) != '\n') goto L4;
        r102 = r104 + 2;
        goto L4
    L21:
        if (r100.length() <= 0) goto L26;
        if (r102 != 0) goto L24;
    L25:
        r101.i(r100.substring(r102));
        goto L26
    L24:
        if (r102 < r100.length()) goto L25;
    L26:
        r101.f(r101.f525703n);
        m r106 = new m(r101.f525700k, r101.f525702m);
        vvc.a r107 = r101.f525699j.a(r106);
        Iterator<wvc.d> r108 = r101.f525704o.iterator();
    L28:
        if (r108.hasNext() == false) goto L30;
        r108.next().g(r107);
        goto L28
    L30:
        uvc.b r109 = r101.f525701l.f525687a;
        Iterator r110 = ((ArrayList) this.f557407d).iterator();
    L32:
        if (r110.hasNext() == false) goto L34;
        r109 = ((f) r110.next()).a(r109);
        goto L32
    L34:
        return r109;
    L11:
        r104 = -1;
        goto L12
    L36:
        throw new NullPointerException("input must not be null");
    }
}
