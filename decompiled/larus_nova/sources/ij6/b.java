package ij6;

import kotlin.jvm.internal.Intrinsics;
import qi6.e;

/* JADX INFO: loaded from: classes19.dex */
public class b extends yi6.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f490071f;

    public static final class a {
    }

    static {
    }

    @Override // qi6.f
    public final String getName() {
        return this.f490071f;
    }

    @Override // yi6.a, qi6.f
    public void i() {
        e.f(this);
    }

    @Override // yi6.a, qi6.f
    public void init() {
        e.a(this);
    }

    @Override // yi6.a, qi6.f
    public final void pause() {
        e.b(this);
    }

    @Override // yi6.a, qi6.f
    public void release() {
        e.d(this);
    }

    @Override // yi6.a, qi6.f
    public final void resume() {
        e.e(this);
    }

    @Override // yi6.a, qi6.f
    public void stop() {
        e.g(this);
    }

    public b(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
        this.f490071f = "VideoPublishCaptureNode";
    }

    @Override // yi6.a, qi6.f
    public final void m(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        e.c(this, r100);
    }
}
