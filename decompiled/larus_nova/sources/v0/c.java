package v0;

import com.airbnb.lottie.o;

/* JADX INFO: loaded from: classes28.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f552291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f552292b;

    public c() {
        this.f552291a = new b();
        this.f552292b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(o r100) {
        this.f552291a = new b();
        this.f552292b = null;
        this.f552292b = r100;
    }

    public T a(b<T> r100) {
        return this.f552292b;
    }

    public final T b(float r100, float r101, T r102, T r103, float r104, float r105, float r106) {
        b<T> r107 = this.f552291a;
        r107.f552288a = r100;
        r107.f552289b = r102;
        r107.f552290c = r103;
        return a(r107);
    }
}
