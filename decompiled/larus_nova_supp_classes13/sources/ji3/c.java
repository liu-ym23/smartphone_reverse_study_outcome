package ji3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends BaseSlcViewManager<m> implements l1.a {
    public long H3;
    public final SlcTemplateContext I3;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onFinish() {
        Object r0 = this.I3.w.g(AnchorV4VM.class);
        if ((r0 instanceof AnchorV4VM) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4VM r1 = (AnchorV4VM) r0;
        if (r1 == null) goto L9;
        AnchorV4VM.refresh$default(r1, false, false, null, 7, null);
        return;
    }

    public c(SlcTemplateContext r3) {
        Intrinsics.checkNotNullParameter(r3, "slcContext");
        super(r3);
        this.I3 = r3;
        this.H3 = System.currentTimeMillis();
    }

    public final View A0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new m(r2);
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((m) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        Object r0 = this.I3.w.g(vg3.h.class);
        Object r2 = null;
        if ((r0 instanceof vg3.h) == true) goto L5;
        r0 = null;
    L5:
        vg3.h r1 = (vg3.h) r0;
        if (r1 == null) goto L8;
        r1.k0(this);
    L8:
        this.H3 = com.bytedance.android.ecom.arch.slice.render.util.b.l(r8.get("expire"), System.currentTimeMillis() / 1000) * 1000;
        ((m) getView()).update(this.H3 - System.currentTimeMillis());
        Object r3 = r8.get("prefix");
        if ((r3 instanceof String) == true) goto L11;
        r3 = null;
    L11:
        String r4 = (String) r3;
        Object r5 = r8.get("prefix_size");
        if ((r5 instanceof Float) == true) goto L14;
        r5 = null;
    L14:
        Float r6 = (Float) r5;
        Object r9 = r8.get("timer_size");
        if ((r9 instanceof Float) == false) goto L18;
        r2 = r9;
    L18:
        Float r7 = (Float) r2;
        m r10 = (m) getView();
        if (r6 == null) goto L21;
        float r11 = r6.floatValue();
    L22:
        if (r7 == null) goto L24;
        float r12 = r7.floatValue();
    L25:
        r10.b(r4, r11, r12);
        return;
    L24:
        r12 = 13.0f;
        goto L25
    L21:
        r11 = 12.0f;
        goto L22
    }

    public final void onTick(long r3) {
        long r4 = this.H3 - System.currentTimeMillis();
        ((m) getView()).update(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(View r3) {
        SlcRoundLinearlayout r4 = (m) r3;
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Object r0 = this.I3.w.g(vg3.h.class);
        if ((r0 instanceof vg3.h) == true) goto L5;
        r0 = null;
    L5:
        vg3.h r1 = (vg3.h) r0;
        if (r1 == null) goto L8;
        r1.A(this);
    L8:
        r4.addOnAttachStateChangeListener(new d(this));
    }
}
