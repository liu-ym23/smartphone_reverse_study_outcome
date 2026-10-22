package ad3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementViewManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends SlcAsyncImageElementViewManager implements com.bytedance.android.shopping.deepfeed.slice.service.c {
    public final SlcTemplateContext c4;

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.c
    public final Pair<Integer, Integer> a() {
        Object r0 = getView();
        if ((r0 instanceof b) == true) goto L5;
        r0 = null;
    L5:
        b r1 = (b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return TuplesKt.to(Integer.valueOf(r1.getCurrentTopMargin()), Integer.valueOf(r1.getCurrentTopMax()));
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
        this.c4 = r2;
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new b(this.c4, r3);
    }

    public final void H0(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        super.H0(r6);
        Object r0 = r6.get("targetTopOffset");
        Object r2 = null;
        if ((r0 instanceof Number) == true) goto L5;
        r0 = null;
    L5:
        Number r1 = (Number) r0;
        if (r1 == null) goto L13;
        double r3 = r1.doubleValue();
        Object r4 = getView();
        if ((r4 instanceof b) == true) goto L10;
        r4 = null;
    L10:
        b r5 = (b) r4;
        if (r5 == null) goto L13;
        r5.setMaxMargin(r3);
    L13:
        Object r7 = r6.get("startOffset");
        if ((r7 instanceof Number) == true) goto L16;
        r7 = null;
    L16:
        Number r8 = (Number) r7;
        if (r8 == null) goto L24;
        double r9 = r8.doubleValue();
        Object r10 = getView();
        if ((r10 instanceof b) == true) goto L21;
        r10 = null;
    L21:
        b r11 = (b) r10;
        if (r11 == null) goto L24;
        r11.setStartMargin(r9);
    L24:
        Object r12 = this.c4.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r12 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L27;
        r12 = null;
    L27:
        com.bytedance.android.shopping.deepfeed.slice.service.b r13 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r12;
        if (r13 == null) goto L40;
        int r14 = r13.L();
        View r15 = getView();
        if ((r15 instanceof b) == false) goto L33;
        r2 = r15;
    L33:
        b r16 = (b) r2;
        if (r16 == null) goto L41;
        r16.f = r14;
        if (r14 != 1) goto L38;
        r16.c(r16.e);
        return;
    L38:
        r16.c(r16.d);
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.c
    public final void m(int r3) {
        Object r0 = getView();
        if ((r0 instanceof b) == true) goto L5;
        r0 = null;
    L5:
        b r1 = (b) r0;
        if (r1 == null) goto L9;
        r1.c(r3);
        return;
    }

    public final SlcAsyncImageElementView q1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new b(this.c4, r3);
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        ((BaseSlcViewManager) this).a.s(com.bytedance.android.shopping.deepfeed.slice.service.c.class, this);
    }
}
