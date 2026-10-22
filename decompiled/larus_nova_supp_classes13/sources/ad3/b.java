package ad3;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends SlcAsyncImageElementView {
    public final a b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final SlcTemplateContext g;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.addOnPreDrawListener(this.b);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.removeOnPreDrawListener(this.b);
    L8:
        super.onDetachedFromWindow();
    }

    public final int getCurrentTopMargin() {
        return this.c;
    }

    public final int getCurrentTopMax() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(int r3) {
        int r0 = this.c;
        if (r0 != r3) goto L6;
        return;
    L6:
        if (r0 == this.d) goto L8;
    L10:
        this.c = r3;
        setTranslationY(r3);
        return;
    L8:
        if (this.f != 2) goto L10;
    }

    public final void setMaxMargin(double r1) {
        this.d = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r1));
    }

    public final void setStartMargin(double r1) {
        this.e = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r1));
    }

    public b(SlcTemplateContext r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "templateCtx");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 0);
        this.g = r3;
        this.b = new a(this);
        this.f = 1;
    }
}
