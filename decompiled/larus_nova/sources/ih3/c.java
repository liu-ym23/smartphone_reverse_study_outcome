package ih3;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements t83.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f489801b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t83.a f489802a;

    @Override // t83.a
    public final void a(String r100, String r101, boolean r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "shareContent");
        Intrinsics.checkNotNullParameter(r101, "shareObject");
        this.f489802a.a(r100, r101, r102, r103);
    }

    @Override // t83.a
    public final String b() {
        return this.f489802a.b();
    }

    @Override // t83.a
    public final void c() {
        this.f489802a.c();
    }

    static {
        f489801b = new c();
    }

    public c() {
        this.f489802a = g.f489807b.Q();
    }
}
