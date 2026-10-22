package y68;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements ca9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2a.d f566398a;

    public d() {
        this.f566398a = new f2a.d("ScreenShare", "Capture");
    }

    @Override // ca9.c
    public final void a(String r100, String r101, List<String> r102, final Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
        f2a.c r104 = this.f566398a.b(r100);
        f2a.g r105 = r104.f475230c;
        r105.f475256d = r101;
        r105.f475254b = r102;
        r104.f(new a(r103));
        f2a.c.c(r104, null, 15);
    }

    @Override // ca9.c
    public final void b(String r100, String r101, List<String> r102, final Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
        f2a.c r104 = this.f566398a.a(r100);
        f2a.g r105 = r104.f475230c;
        r105.f475256d = r101;
        r105.f475254b = r102;
        r104.f(new b(r103));
        f2a.c.c(r104, null, 15);
    }

    @Override // ca9.c
    public final void c(String r100, String r101, List<String> r102, final Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
        f2a.c r104 = this.f566398a.c(r100);
        f2a.g r105 = r104.f475230c;
        r105.f475256d = r101;
        r105.f475254b = r102;
        r104.f(new c(r103));
        f2a.c.c(r104, null, 15);
    }
}
