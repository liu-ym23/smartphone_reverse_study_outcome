package j01;

import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.live.revenue.platform.trace.api.TraceDSLMaker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@TraceDSLMaker
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o97.a f496788a;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496788a.f522480h = r100;
    }

    public final void b(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "index");
        this.f496788a.f522484l = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496788a.f522476d = r100;
    }

    public final void d(ProductId r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        o97.a r101 = this.f496788a;
        r101.f522477e = r100.getString();
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496788a.f522479g = r100;
    }

    public final void f(int r100) {
        o97.a r101 = this.f496788a;
        r101.f522482j = Integer.valueOf(r100);
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "step");
        this.f496788a.f522478f = r100;
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496788a.f522475c = r100;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496788a.f522481i = r100;
    }

    public e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        this.f496788a = new o97.a(r100, r101);
    }
}
