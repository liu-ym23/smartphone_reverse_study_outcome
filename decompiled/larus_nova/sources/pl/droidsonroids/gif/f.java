package pl.droidsonroids.gif;

import java.io.IOException;
import pl.droidsonroids.gif.f;

/* JADX INFO: loaded from: classes41.dex */
public abstract class f<T extends f<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j.b f529728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f529729b;

    public final d a() throws IOException {
        j.b r100 = this.f529728a;
        if (r100 == null) goto L7;
        g r101 = this.f529729b;
        GifInfoHandle r102 = r100.a();
        r102.A(r101.f529730a, false);
        return new d(r102);
    L7:
        throw new NullPointerException("Source is not set");
    }

    public f() {
        this.f529729b = new g();
    }
}
