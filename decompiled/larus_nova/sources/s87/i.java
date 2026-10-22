package s87;

import com.lynx.rts.gen.RendererFunctionNG;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f540985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<RendererFunctionNG> f540986b;

    public final RendererFunctionNG a() {
        RendererFunctionNG r100 = this.f540986b.get();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("RendererFunctionNG has been released".toString());
    }

    public i(long r100) {
        this.f540985a = h.f540984a.getAndIncrement();
        this.f540986b = new AtomicReference(new RendererFunctionNG(r100));
    }
}
