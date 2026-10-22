package zp;

import com.bytedance.android.ecom.arch.expr.error.SlcExprException;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f573175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573176b;

    public e(String r100) {
        this.f573176b = r100;
    }

    @Override // zp.b
    public final Object a(a r100, List<? extends Object> r101) {
        if (this.f573175a != null) goto L10;
        if (r100 == null) goto L9;
        b r102 = r100.a(this.f573176b);
        if (r102 == null) goto L9;
        this.f573175a = r102;
    L9:
        throw new SlcExprException("eval_unknown_function", "unknown function:" + this.f573176b);
    L10:
        b r103 = this.f573175a;
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103.a(r100, r101);
    }
}
