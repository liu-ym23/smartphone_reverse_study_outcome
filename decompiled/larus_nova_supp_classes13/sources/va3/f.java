package va3;

import android.view.animation.Animation;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Animation.AnimationListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ e b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r11) {
        h r12 = this.a;
        int r13 = com.bytedance.commerce.base.view.b.a(r12).indexOf(r12.getCurrentView());
        e r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter("marquee_scroll_action", "name");
        BaseSlcViewManager r1 = r0.getChildAt(r13);
        Object r3 = null;
        if (r1 == null) goto L5;
        Object r2 = r1.o("marquee_scroll_action");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r4 = (String) r2;
        e r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter("marquee_scroll_attrs", "name");
        BaseSlcViewManager r14 = r5.getChildAt(r13);
        if (r14 == null) goto L12;
        Object r15 = r14.o("marquee_scroll_attrs");
    L14:
        if ((r15 instanceof Map) == false) goto L17;
        r3 = r15;
    L17:
        Map r6 = (Map) r3;
        if (r4 != null) goto L20;
    L23:
        boolean r16 = true;
    L24:
        if (r16 == false) goto L26;
        return;
    L26:
        BaseSlcViewManager r17 = SlcViewExtensionsKt.g(this.a);
        if (r17 != null) goto L29;
        return;
    L29:
        if (r6 != null) goto L31;
        r6 = MapsKt.emptyMap();
    L31:
        r17.a.d(new SlcCommonAction(r4, r6), this.a.getCurrentView(), r17.l(), null, null);
        return;
    L20:
        if (r4.length() == 0) goto L23;
        r16 = false;
        goto L24
    L12:
        r15 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public f(h r1, e r2) {
        this.a = r1;
        this.b = r2;
    }
}
