package nz4;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements MenuItem.b {
    public final MenuItem.b a;
    public long b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public o(com.bytedance.ee.bear.doc.structure.pad.container.g r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        this.a = r2;
        this.c = 500;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r6, View r7) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.b;
        this.b = r0;
        if (r2 <= this.c) goto L5;
        this.a.a(r6, r7);
        return;
    L5:
        tt5.a.k("SafeClickListener", "So fast click , ignored !");
    }
}
