package v7b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public abstract class s implements com.ss.android.lark.coremd.ext.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Object, Object> f553567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f553568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f553569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f553570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f553571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f553572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<x> f553573i;

    public abstract void c(f0 r100);

    public abstract s h();

    public String o() {
        return "";
    }

    public final List<x> j() {
        List<x> r100 = this.f553573i;
        if (r100 == null) goto L6;
        return Collections.unmodifiableList(r100);
    L6:
        return Collections.emptyList();
    }

    public final void p() {
        s r100 = this.f553571g;
        if (r100 == null) goto L5;
        r100.f553572h = this.f553572h;
    L8:
        s r101 = this.f553572h;
        if (r101 == null) goto L11;
        r101.f553571g = r100;
    L14:
        this.f553568d = null;
        this.f553572h = null;
        this.f553571g = null;
        return;
    L11:
        s r102 = this.f553568d;
        if (r102 == null) goto L14;
        r102.f553570f = r100;
        goto L14
    L5:
        s r103 = this.f553568d;
        if (r103 == null) goto L8;
        r103.f553569e = this.f553572h;
        goto L8
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + o() + com.alipay.sdk.m.u.i.f25855d;
    }

    public s() {
        this.f553567c = new HashMap();
        this.f553568d = null;
        this.f553569e = null;
        this.f553570f = null;
        this.f553571g = null;
        this.f553572h = null;
        this.f553573i = null;
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f553567c;
    }

    public s i() {
        return this.f553568d;
    }

    public final void e(s r100) {
        r100.p();
        r100.m(this);
        s r101 = this.f553570f;
        if (r101 == null) goto L5;
        r101.f553572h = r100;
        r100.f553571g = r101;
        this.f553570f = r100;
        return;
    L5:
        this.f553569e = r100;
        this.f553570f = r100;
    }

    public final void k(s r100) {
        r100.p();
        s r101 = this.f553572h;
        r100.f553572h = r101;
        if (r101 == null) goto L5;
        r101.f553571g = r100;
    L5:
        r100.f553571g = this;
        this.f553572h = r100;
        s r102 = this.f553568d;
        r100.f553568d = r102;
        if (r100.f553572h != null) goto L9;
        r102.f553570f = r100;
        return;
    }

    public final void l(s r100) {
        r100.p();
        s r101 = this.f553571g;
        r100.f553571g = r101;
        if (r101 == null) goto L5;
        r101.f553572h = r100;
    L5:
        r100.f553572h = this;
        this.f553571g = r100;
        s r102 = this.f553568d;
        r100.f553568d = r102;
        if (r100.f553571g != null) goto L9;
        r102.f553569e = r100;
        return;
    }

    public void m(s r100) {
        this.f553568d = r100;
    }

    public final void n(List<x> r100) {
        if (r100.isEmpty() == false) goto L5;
        this.f553573i = null;
        return;
    L5:
        this.f553573i = new ArrayList(r100);
    }
}
