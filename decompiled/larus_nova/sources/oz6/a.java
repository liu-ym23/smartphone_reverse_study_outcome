package oz6;

import android.view.animation.Interpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<InterfaceC7134a> f527196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f527197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends xz6.a<K>> f527198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f527199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xz6.c<A> f527200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xz6.a<K> f527201f;

    /* JADX INFO: renamed from: oz6.a$a, reason: collision with other inner class name */
    public interface InterfaceC7134a {
        void a();
    }

    public abstract A f(xz6.a<K> r100, float r101);

    public void g() {
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f527196a).size()) goto L6;
        ((InterfaceC7134a) ListProtector.get(this.f527196a, r100)).a();
        r100 = r100 + 1;
        goto L4
    }

    public final xz6.a<K> b() {
        xz6.a<K> r100 = this.f527201f;
        if (r100 == null) goto L13;
        float r101 = this.f527199d;
        if (r101 >= r100.b()) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L13;
        return this.f527201f;
    L7:
        if (r101 >= r100.a()) goto L9;
        r102 = true;
    L13:
        List<? extends xz6.a<K>> r103 = this.f527198c;
        xz6.a<K> r104 = (xz6.a) ListProtector.get(r103, r103.size() - 1);
        if (this.f527199d >= r104.b()) goto L27;
        int r105 = this.f527198c.size();
    L16:
        r105 = r105 - 1;
        if (r105 < 0) goto L27;
        r104 = (xz6.a) ListProtector.get(this.f527198c, r105);
        float r106 = this.f527199d;
        if (r106 >= r104.b()) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == false) goto L16;
    L21:
        if (r106 >= r104.a()) goto L23;
        r107 = true;
    L27:
        this.f527201f = r104;
        return r104;
    }

    public float c() {
        if (this.f527198c.isEmpty() == false) goto L5;
        return 1.0f;
    L5:
        List<? extends xz6.a<K>> r100 = this.f527198c;
        return ((xz6.a) ListProtector.get(r100, r100.size() - 1)).a();
    }

    public final float d() {
        if (this.f527197b == false) goto L5;
        return 0.0f;
    L5:
        xz6.a<K> r100 = b();
        if (r100.f565529d != null) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return 0.0f;
    L12:
        return (this.f527199d - r100.b()) / (r100.a() - r100.b());
    L8:
        r101 = false;
        goto L9
    }

    public A e() {
        xz6.a<K> r100 = b();
        Interpolator r101 = b().f565529d;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        float r103 = 0.0f;
    L10:
        return f(r100, r103);
    L8:
        r103 = r101.getInterpolation(d());
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public a(List<? extends xz6.a<K>> r100) {
        this.f527196a = new ArrayList();
        this.f527197b = false;
        this.f527199d = 0.0f;
        this.f527198c = r100;
    }

    public final void a(InterfaceC7134a r100) {
        ((ArrayList) this.f527196a).add(r100);
    }

    public void h(float r100) {
        if (this.f527198c.isEmpty() == false) goto L5;
        float r101 = 0.0f;
    L7:
        if (r100 >= r101) goto L13;
        if (this.f527198c.isEmpty() == false) goto L11;
        r100 = 0.0f;
    L16:
        if (r100 != this.f527199d) goto L18;
        return;
    L18:
        this.f527199d = r100;
        g();
        return;
    L11:
        r100 = ((xz6.a) ListProtector.get(this.f527198c, 0)).b();
        goto L16
    L13:
        if (r100 <= c()) goto L16;
        r100 = c();
        goto L16
    L5:
        r101 = ((xz6.a) ListProtector.get(this.f527198c, 0)).b();
        goto L7
    }

    public final void i(xz6.c<A> r100) {
        xz6.c<A> r101 = this.f527200e;
        if (r101 == null) goto L5;
        r101.getClass();
    L5:
        this.f527200e = r100;
    }
}
