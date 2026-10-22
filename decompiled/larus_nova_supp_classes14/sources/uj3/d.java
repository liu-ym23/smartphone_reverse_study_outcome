package uj3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.entity.Module;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sj3.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.android.shopping.store.hybridproduct.extension.d {
    public static final a k = null;
    public ECUrlModel a;
    public ECUrlModel b;
    public n c;
    public n d;
    public n e;
    public ECUrlModel f;
    public sj3.d g;
    public Map<String, String> h;
    public Map<String, String> i;
    public Map<String, String> j;

    public static final class a {
        public a() {
        }

        public static d a(Module r3) {
            Intrinsics.checkNotNullParameter(r3, "module");
            sj3.e r0 = (sj3.e) GsonProtectorUtils.fromJson(new Gson(), r3.getData(), sj3.e.class);
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(r0, "dto");
            d r1 = new d();
            r1.a = r0.b();
            r1.b = r0.a();
            r1.c = r0.i();
            r1.d = r0.g();
            r1.e = r0.h();
            r1.f = r0.e();
            r1.g = r0.c();
            r1.h = r0.f();
            r1.j = r0.d();
            r3.getName();
            r1.i = r3.getModuleExtra();
            return r1;
        L5:
            ECExceptionMonitor.c("transFromShopMemberModule error moduleData:{" + r3.getData() + '}');
            return new d();
        }
    }

    public d() {
    }

    public final int modelType() {
        return 20;
    }

    static {
        k = new a();
    }
}
