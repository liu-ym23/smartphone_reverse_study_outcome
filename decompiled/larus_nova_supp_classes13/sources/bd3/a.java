package bd3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.e;
import com.bytedance.android.shopping.deepfeed.slice.view.indicator.DeepFeedSlcIndicatorView;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressBar;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<DeepFeedSlcIndicatorView> implements e {
    public final SlcTemplateContext H3;

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.e
    public final void reset() {
        DeepFeedSlcIndicatorView r0 = (DeepFeedSlcIndicatorView) k1();
        if (r0 == null) goto L6;
        r0.S5();
        return;
    }

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
        this.H3 = r2;
    }

    public final void H0(Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r14, "props");
        Object r1 = r14.get("count");
        Object r3 = null;
        if ((r1 instanceof Number) == true) goto L5;
        r1 = null;
    L5:
        Number r2 = (Number) r1;
        if (r2 == null) goto L8;
        int r4 = r2.intValue();
    L9:
        Object r5 = r14.get("videoDuration");
        if ((r5 instanceof Number) == true) goto L12;
        r5 = null;
    L12:
        Number r6 = (Number) r5;
        if (r6 == null) goto L15;
        int r7 = r6.intValue();
    L16:
        Object r8 = r14.get("type");
        if ((r8 instanceof String) == true) goto L19;
        r8 = null;
    L19:
        String r9 = (String) r8;
        if (r9 != null) goto L22;
        String r10 = "image";
    L23:
        Object r11 = r14.get("vidTag");
        if ((r11 instanceof String) == true) goto L26;
        r11 = null;
    L26:
        String r12 = (String) r11;
        if (r12 != null) goto L29;
        r12 = "";
    L29:
        String r13 = r12;
        Double r15 = Double.valueOf(2.0d);
        Object r16 = r14.get("lineWidth");
        if ((r16 instanceof Double) == false) goto L33;
        r3 = r16;
    L33:
        Double r17 = (Double) r3;
        if (r17 == null) goto L37;
        r15 = r17;
    L37:
        c r18 = new c(r10, r7, r4, r13, r15.doubleValue());
        DeepFeedSlcIndicatorView r19 = (DeepFeedSlcIndicatorView) k1();
        if (r19 == null) goto L68;
        Intrinsics.checkNotNullParameter(r18, "props");
        c r20 = r19.f;
        Intrinsics.checkNotNullParameter(r20, "props");
        if (Intrinsics.areEqual(r18.a, r20.a) == true) goto L42;
    L48:
        boolean r0 = false;
    L49:
        if (r0 == true) goto L68;
        String r21 = r18.getType();
        int r22 = r21.hashCode();
        if (r22 == 108124) goto L60;
        if (r22 == 112202875) goto L57;
    L62:
        r19.d = "image";
        r19.a.setVisibility(0);
        ExtensionsKt.gone(r19.e);
    L63:
        r19.c = r18.b;
        int r23 = r18.c;
        if (r23 > 0) goto L66;
        ExtensionsKt.gone(r19.a);
    L67:
        double r24 = r18.e;
        ViewGroup.LayoutParams r25 = r19.e.getLayoutParams();
        int r26 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r25.height = com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(r24));
        r19.a.getLayoutParams().height = com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(r24));
        r19.f = r18;
        goto L68
    L66:
        r19.a.setup(r23);
        goto L67
    L57:
        if (r21.equals("video") == false) goto L62;
        r19.d = r21;
        ExtensionsKt.gone(r19.a);
        r19.e.setVisibility(0);
        goto L63
    L60:
        if (r21.equals("mix") == false) goto L62;
        r19.d = r21;
        r19.a.setVisibility(0);
        r19.e.setVisibility(4);
        goto L63
    L42:
        if (r18.b != r20.b) goto L48;
        if (r18.c != r20.c) goto L48;
        if (Intrinsics.areEqual(r18.d, r20.d) == false) goto L48;
        r0 = true;
    L68:
        this.H3.s(e.class, this);
        return;
    L22:
        r10 = r9;
        goto L23
    L15:
        r7 = 0;
        goto L16
    L8:
        r4 = 0;
        goto L9
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.e
    public final void b(float r3) {
        DeepFeedSlcIndicatorView r0 = (DeepFeedSlcIndicatorView) k1();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        ProductCardProgressIndicator r2 = r0.a;
        r2.j = r3;
        r2.invalidate();
        return;
    L10:
        VideoProgressBar r4 = r0.e;
        r4.getClass();
        r4.c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r3, 1.0f), 0.0f);
        r4.invalidate();
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.e
    public final void g(boolean r2) {
        DeepFeedSlcIndicatorView r3 = (DeepFeedSlcIndicatorView) k1();
        if (r3 == null) goto L6;
        r3.setFillCurrent(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m1(View r2) {
        Intrinsics.checkNotNullParameter((DeepFeedSlcIndicatorView) r2, "contentView");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.deepfeed.slice.view.indicator.DeepFeedSlcIndicatorView] */
    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new DeepFeedSlcIndicatorView(r5, null, 6, 0);
        SlcTemplateContext r6 = this.H3;
        Intrinsics.checkNotNullParameter(r6, "ctx");
        r0.g = r6;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.slice.view.indicator.DeepFeedSlcIndicatorView] */
    @Override // com.bytedance.android.shopping.deepfeed.slice.service.e
    public final void k(int r4, int r5, boolean r6) {
        ?? r0 = (DeepFeedSlcIndicatorView) k1();
        if (r0 == 0) goto L13;
        if (r6 == false) goto L6;
        r0.a.b(r4, 0.0f);
        return;
    L6:
        r0.a.b(r4, 1.0f);
        if (Intrinsics.areEqual(r0.d, "mix") == false) goto L15;
        if (r4 == 0) goto L10;
        return;
    L10:
        if (r5 != 1) goto L17;
        r0.postDelayed(new b(r0, r4), 100);
        return;
    L17:
        return;
    L15:
        return;
    }
}
