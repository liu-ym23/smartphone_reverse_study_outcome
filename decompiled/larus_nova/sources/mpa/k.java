package mpa;

import com.lynx.rts.gen.RendererFunctionNG;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f514757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<RendererFunctionNG> f514758b;

    public final RendererFunctionNG a() {
        RendererFunctionNG r100 = this.f514758b.get();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("RendererFunctionNG has been released".toString());
    }

    public k(long r100) {
        this.f514757a = j.f514756a.getAndIncrement();
        this.f514758b = new AtomicReference(new RendererFunctionNG(r100));
    }
}
