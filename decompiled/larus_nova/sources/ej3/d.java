package ej3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.hybridproduct.dto.Position;
import dj3.h;
import dj3.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f472844l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f472845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f472846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f472847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f472848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECUrlModel f472849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Position f472850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Double f472851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f472852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f472853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f472854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f472855k;

    public static final class a {
        public a() {
        }

        public static d a(dj3.e r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            d r101 = new d();
            r101.f472845a = r100.c();
            r101.f472846b = r100.j();
            r101.f472847c = r100.k();
            r101.f472848d = r100.b();
            r101.f472849e = r100.d();
            Position.a r102 = Position.Companion;
            Integer r103 = r100.f();
            r102.getClass();
            if (r103 != null) goto L6;
        L8:
            if (r103 != null) goto L11;
        L13:
            if (r103 != null) goto L16;
        L18:
            if (r103 != null) goto L21;
        L23:
            Position r104 = Position.LEFT;
        L24:
            r101.f472850f = r104;
            r101.f472851g = r100.e();
            r101.f472855k = r100.a();
            if (r101.f472850f != Position.BOTTOM) goto L27;
            r101.f472852h = r100.g();
            r101.f472854j = r100.i();
            r101.f472853i = r100.h();
        L27:
            return r101;
        L21:
            if (r103.intValue() != 4) goto L23;
            r104 = Position.BOTTOM;
            goto L24
        L16:
            if (r103.intValue() != 3) goto L18;
            r104 = Position.TOP;
            goto L24
        L11:
            if (r103.intValue() != 2) goto L13;
            r104 = Position.RIGHT;
            goto L24
        L6:
            if (r103.intValue() != 1) goto L8;
            r104 = Position.LEFT;
            goto L24
        }
    }

    public d() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return -1;
    }

    static {
        f472844l = new a();
    }
}
