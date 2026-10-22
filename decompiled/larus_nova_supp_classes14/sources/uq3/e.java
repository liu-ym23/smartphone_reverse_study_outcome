package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int h = 0;
    public String a;
    public ECUrlModel b;
    public List<? extends ECUrlModel> c;
    public String d;
    public String e;
    public Integer f;
    public String g;

    public static final class a {
        public static e a(com.bytedance.android.window.shop.repository.dto.n r2) {
            Intrinsics.checkNotNullParameter(r2, "dto");
            e r0 = new e();
            r0.a = r2.e();
            r0.b = r2.c();
            r0.c = r2.d();
            r0.d = r2.g();
            r0.e = r2.f();
            r0.f = r2.a();
            r0.g = r2.b();
            return r0;
        }
    }

    static {
    }

    public e() {
    }
}
