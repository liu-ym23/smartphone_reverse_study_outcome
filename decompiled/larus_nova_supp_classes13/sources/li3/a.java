package li3;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b {
    public boolean W3;
    public int X3;

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.W3 = true;
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        if (r4.get("default_hide") != null) goto L5;
        return;
    L5:
        if (r4.get("buffer") == null) goto L9;
        this.W3 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r4.get("default_hide"));
        this.X3 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r4.get("buffer"), 0);
        return;
    }

    public final void D1(BaseSlcViewManager<?> r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        if (this.W3 == false) goto L9;
        if (r5 <= getView().getWidth()) goto L7;
        r2.v(r3, r4, r3, r6);
        return;
    L7:
        r2.v(r3, r4, r5, r6);
        return;
    L9:
        if ((this.X3 + r3) >= r5) goto L14;
        if (r5 >= getView().getWidth()) goto L14;
        r2.v(r3, r4, r5, r6);
        return;
    L14:
        if (r3 < getView().getWidth()) goto L16;
        r2.v(r3, r4, r3, r6);
        return;
    L16:
        r2.v(r3, r4, r5, r6);
    }
}
