package ih3;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements t83.a {
    public static final c b = null;
    public final /* synthetic */ t83.a a;

    @Override // t83.a
    public final void a(String r2, String r3, boolean r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "shareContent");
        Intrinsics.checkNotNullParameter(r3, "shareObject");
        this.a.a(r2, r3, r4, r5);
    }

    @Override // t83.a
    public final String b() {
        return this.a.b();
    }

    @Override // t83.a
    public final void c() {
        this.a.c();
    }

    static {
        b = new c();
    }

    public c() {
        this.a = g.b.Q();
    }
}
