package jf3;

import com.bytedance.android.shopping.api.mall.opt.ECMallPopupRenderOptConfig;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f498877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f498878b;

    @Override // jf3.b
    public final void b(boolean r100) {
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
        this.f498878b.invoke();
    }

    @Override // jf3.b
    public final void g() {
        this.f498878b.invoke();
    }

    @Override // jf3.b
    public final void a(boolean r100) {
        if (r100 == false) goto L26;
        ECMallPopupRenderOptConfig.a r101 = ECMallPopupRenderOptConfig.Companion;
        String r102 = this.f498877a.invoke();
        r101.getClass();
        int r103 = 0;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L25;
        List<String> r105 = ECMallPopupRenderOptConfig.a.a().getEnabledPages();
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L24;
        List<String> r107 = ECMallPopupRenderOptConfig.a.a().getEnabledPages();
        if (r107 == null) goto L25;
        if (r107.contains(r102) != true) goto L25;
    L24:
        r103 = ECMallPopupRenderOptConfig.a.a().getPageCardStrategy();
        goto L25
    L15:
        if (r105.isEmpty() == true) goto L18;
        r106 = false;
    L25:
        if (r103 > 0) goto L26;
        return;
    L6:
        if (r102.length() == 0) goto L9;
        r104 = false;
    L26:
        this.f498878b.invoke();
    }

    public d(Function0<String> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "pageNameProvider");
        Intrinsics.checkNotNullParameter(r101, "handlePageCardViewCreate");
        this.f498877a = r100;
        this.f498878b = r101;
    }
}
