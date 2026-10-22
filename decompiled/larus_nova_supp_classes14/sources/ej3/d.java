package ej3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.hybridproduct.dto.Position;
import dj3.h;
import dj3.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.android.shopping.store.hybridproduct.extension.d {
    public static final a l = null;
    public Double a;
    public String b;
    public String c;
    public Integer d;
    public ECUrlModel e;
    public Position f;
    public Double g;
    public String h;
    public Integer i;
    public l j;
    public h k;

    public static final class a {
        public a() {
        }

        public static d a(dj3.e r4) {
            Intrinsics.checkNotNullParameter(r4, "dto");
            d r0 = new d();
            r0.a = r4.c();
            r0.b = r4.j();
            r0.c = r4.k();
            r0.d = r4.b();
            r0.e = r4.d();
            Position.a r1 = Position.Companion;
            Integer r2 = r4.f();
            r1.getClass();
            if (r2 != null) goto L6;
        L8:
            if (r2 != null) goto L11;
        L13:
            if (r2 != null) goto L16;
        L18:
            if (r2 != null) goto L21;
        L23:
            Position r3 = Position.LEFT;
        L24:
            r0.f = r3;
            r0.g = r4.e();
            r0.k = r4.a();
            if (r0.f != Position.BOTTOM) goto L27;
            r0.h = r4.g();
            r0.j = r4.i();
            r0.i = r4.h();
        L27:
            return r0;
        L21:
            if (r2.intValue() != 4) goto L23;
            r3 = Position.BOTTOM;
            goto L24
        L16:
            if (r2.intValue() != 3) goto L18;
            r3 = Position.TOP;
            goto L24
        L11:
            if (r2.intValue() != 2) goto L13;
            r3 = Position.RIGHT;
            goto L24
        L6:
            if (r2.intValue() != 1) goto L8;
            r3 = Position.LEFT;
            goto L24
        }
    }

    public d() {
    }

    public final int modelType() {
        return -1;
    }

    static {
        l = new a();
    }
}
