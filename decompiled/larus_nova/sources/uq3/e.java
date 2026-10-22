package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f551217h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f551218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECUrlModel f551219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends ECUrlModel> f551220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f551221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f551222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f551223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f551224g;

    public static final class a {
        public static e a(com.bytedance.android.window.shop.repository.dto.n r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            e r101 = new e();
            r101.f551218a = r100.e();
            r101.f551219b = r100.c();
            r101.f551220c = r100.d();
            r101.f551221d = r100.g();
            r101.f551222e = r100.f();
            r101.f551223f = r100.a();
            r101.f551224g = r100.b();
            return r101;
        }
    }

    static {
    }

    public e() {
    }
}
