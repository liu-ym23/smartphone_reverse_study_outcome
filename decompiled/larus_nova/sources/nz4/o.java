package nz4;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements MenuItem.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem.b f521411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f521412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f521413c;

    public static final class a {
    }

    static {
    }

    public o(com.bytedance.ee.bear.doc.structure.pad.container.g r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.f521411a = r100;
        this.f521413c = 500;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r100, View r101) {
        long r102 = System.currentTimeMillis();
        long r103 = r102 - this.f521412b;
        this.f521412b = r102;
        if (r103 <= this.f521413c) goto L5;
        this.f521411a.a(r100, r101);
        return;
    L5:
        tt5.a.k("SafeClickListener", "So fast click , ignored !");
    }
}
