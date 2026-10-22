package cd3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.a<SlcScrollingView> {
    public String W3;
    public Map<String, ? extends Object> X3;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a() {
            b r0 = this.a;
            if (((SlcScrollingView) r0.I1()).a == true) goto L20;
            SlcScrollingView r1 = (SlcScrollingView) r0.I1();
            if (r1.getChildCount() == 0) goto L21;
            r1.c();
            int r2 = r1.getChildAt(0).getMeasuredWidth();
            if (r1.getWidth() <= 0) goto L11;
            int r3 = r1.getWidth();
        L12:
            if (r2 <= r3) goto L22;
            r1.a = true;
            long r4 = r1.f;
            if (r4 <= 0) goto L17;
            r1.postDelayed(new e(r1, r2, r3), r4);
            return;
        L17:
            r1.a(r2, r3);
            return;
        L22:
            return;
        L11:
            r3 = r1.getMeasuredWidth();
            goto L12
        L21:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
        this.W3 = "";
    }

    public final void H0(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        Object r0 = r6.get("indexChanged");
        Object r2 = null;
        if ((r0 instanceof Boolean) == true) goto L5;
        r0 = null;
    L5:
        Boolean r1 = (Boolean) r0;
        if (r1 != null) goto L8;
    L10:
        Object r3 = r6.get("scrollEndAction");
        if ((r3 instanceof Map) == true) goto L13;
        r3 = null;
    L13:
        Map r4 = (Map) r3;
        if (r4 == null) goto L25;
        Object r5 = r4.get("type");
        if ((r5 instanceof String) == true) goto L18;
        r5 = null;
    L18:
        String r7 = (String) r5;
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        this.W3 = r7;
        Object r8 = r4.get("fields");
        if ((r8 instanceof Map) == true) goto L24;
        r8 = null;
    L24:
        this.X3 = (Map) r8;
    L25:
        Object r9 = r6.get("scrollingSpeed");
        if ((r9 instanceof Number) == true) goto L28;
        r9 = null;
    L28:
        Number r10 = (Number) r9;
        if (r10 == null) goto L31;
        ((SlcScrollingView) I1()).setScrollingSpeed(r10.floatValue());
    L31:
        Object r11 = r6.get("waitDuration");
        if ((r11 instanceof Number) == true) goto L34;
        r11 = null;
    L34:
        Number r12 = (Number) r11;
        if (r12 == null) goto L37;
        ((SlcScrollingView) I1()).setWaitDuration(r12.longValue());
    L37:
        Object r13 = r6.get("startDelay");
        if ((r13 instanceof Number) == false) goto L41;
        r2 = r13;
    L41:
        Number r14 = (Number) r2;
        if (r14 == null) goto L45;
        ((SlcScrollingView) I1()).setStartDelay(r14.longValue());
        return;
    L45:
        return;
    L8:
        if (r1.booleanValue() == false) goto L10;
        ((SlcScrollingView) I1()).post(new a(this));
        goto L10
    }

    public final ViewGroup K1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        SlcScrollingView r0 = new SlcScrollingView(r5, null, 6, 0);
        r0.setOnScrollAnimationEndListener(new cd3.a(this, r0));
        return r0;
    }
}
