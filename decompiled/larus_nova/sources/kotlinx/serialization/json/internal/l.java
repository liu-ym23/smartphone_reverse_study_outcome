package kotlinx.serialization.json.internal;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f505443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f505444b;

    public void a() {
        this.f505444b = true;
    }

    public void b() {
        this.f505444b = false;
    }

    public void c() {
        this.f505444b = false;
    }

    public void k() {
    }

    public void l() {
    }

    public l(q r100) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        this.f505443a = r100;
        this.f505444b = true;
    }

    public void d(byte r100) {
        this.f505443a.writeLong(r100);
    }

    public final void e(char r100) {
        this.f505443a.a(r100);
    }

    public void f(int r100) {
        this.f505443a.writeLong(r100);
    }

    public void g(long r100) {
        this.f505443a.writeLong(r100);
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f505443a.b(r100);
    }

    public void i(short r100) {
        this.f505443a.writeLong(r100);
    }

    public void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f505443a.c(r100);
    }
}
