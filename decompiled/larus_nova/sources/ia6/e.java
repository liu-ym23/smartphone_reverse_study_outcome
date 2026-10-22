package ia6;

import com.bytedance.kmp.ecom.arch.expr.error.SlcExprException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f488925b;

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        this.f488924a = r100;
    }

    @Override // ia6.b
    public final Object a(a r100, List<? extends Object> r101) {
        if (this.f488925b != null) goto L10;
        if (r100 == null) goto L9;
        b r102 = r100.a(this.f488924a);
        if (r102 == null) goto L9;
        this.f488925b = r102;
    L9:
        throw new SlcExprException("eval_unknown_function", "unknown function:" + this.f488924a);
    L10:
        b r103 = this.f488925b;
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103.a(r100, r101);
    }
}
