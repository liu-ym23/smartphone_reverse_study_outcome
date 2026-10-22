package jf3;

import com.bytedance.android.shopping.api.mall.opt.ECMallPopupRenderOptConfig;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements b {
    public final Function0<String> a;
    public final Function0<Unit> b;

    @Override // jf3.b
    public final void b(boolean r1) {
    }

    @Override // jf3.b
    public final void d() {
    }

    @Override // jf3.b
    public final void e() {
    }

    @Override // jf3.b
    public final void f() {
    }

    @Override // jf3.b
    public final void c() {
        this.b.invoke();
    }

    @Override // jf3.b
    public final void g() {
        this.b.invoke();
    }

    @Override // jf3.b
    public final void a(boolean r4) {
        if (r4 == false) goto L26;
        ECMallPopupRenderOptConfig.a r5 = ECMallPopupRenderOptConfig.Companion;
        String r0 = (String) this.a.invoke();
        r5.getClass();
        int r1 = 0;
        if (r0 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L25;
        List<String> r3 = ECMallPopupRenderOptConfig.a.a().getEnabledPages();
        if (r3 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L24;
        List<String> r7 = ECMallPopupRenderOptConfig.a.a().getEnabledPages();
        if (r7 == null) goto L25;
        if (r7.contains(r0) != true) goto L25;
    L24:
        r1 = ECMallPopupRenderOptConfig.a.a().getPageCardStrategy();
        goto L25
    L15:
        if (r3.isEmpty() == true) goto L18;
        r6 = false;
    L25:
        if (r1 > 0) goto L26;
        return;
    L6:
        if (r0.length() == 0) goto L9;
        r2 = false;
    L26:
        this.b.invoke();
    }

    public d(Function0<String> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "pageNameProvider");
        Intrinsics.checkNotNullParameter(r3, "handlePageCardViewCreate");
        this.a = r2;
        this.b = r3;
    }
}
