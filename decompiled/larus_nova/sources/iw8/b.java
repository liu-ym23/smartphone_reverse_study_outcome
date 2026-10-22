package iw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f496236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f496237b;

    public b() {
        this(20);
    }

    public b(int r100) {
        this.f496236a = new a(r100);
    }

    public final void a(io.noties.markwon.ext.onetex.b r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        a r102 = this.f496236a;
        String r103 = r100.f561116a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "urlKey");
        Intrinsics.checkNotNullParameter(r100, "drawable");
        r102.put(new c(r103, r101), r100);
    }
}
