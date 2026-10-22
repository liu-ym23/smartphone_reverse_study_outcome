package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExpressNodeType f547594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f547595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f547596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f547597d;

    public final boolean b() {
        ExpressNodeType r100 = this.f547594a;
        if (r100 != ExpressNodeType.OPERATOR_COMPARE) goto L5;
    L10:
        return true;
    L5:
        if (r100 == ExpressNodeType.OPERATOR_AND) goto L10;
        if (r100 == ExpressNodeType.OPERATOR_OR) goto L10;
        return false;
    }

    public final boolean c() {
        ExpressNodeType r100 = this.f547594a;
        if (r100 != ExpressNodeType.PARAM) goto L5;
    L16:
        return true;
    L5:
        if (r100 == ExpressNodeType.CONST_LONG) goto L16;
        if (r100 == ExpressNodeType.CONST_DOUBLE) goto L16;
        if (r100 == ExpressNodeType.CONST_FLOAT) goto L16;
        if (r100 == ExpressNodeType.CONST_INT) goto L16;
        if (r100 == ExpressNodeType.CONST_BOOLEAN) goto L16;
        return false;
    }

    public final boolean a() {
        if (b() == true) goto L5;
    L10:
        return true;
    L5:
        if (this.f547596c != null) goto L7;
    L9:
        return false;
    L7:
        if (this.f547597d == null) goto L9;
        goto L9
    }

    public final ExpressNodeType getType() {
        return this.f547594a;
    }

    public b(ExpressNodeType r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f547594a = r100;
        this.f547595b = r101;
        this.f547596c = null;
        this.f547597d = null;
    }
}
