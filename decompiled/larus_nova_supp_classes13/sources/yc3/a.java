package yc3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.deepfeed.slice.view.adaptive.AdaptiveHelpParams;
import com.bytedance.android.shopping.deepfeed.slice.view.adaptive.SlcAdaptiveView;
import com.facebook.yoga.YogaMeasureMode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.a<SlcAdaptiveView> {
    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Object r3 = r2.get("notifyTag");
        if ((r3 instanceof Boolean) == true) goto L5;
        r3 = null;
    L5:
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        ((SlcAdaptiveView) I1()).g = r5;
        return;
    L8:
        r5 = false;
        goto L9
    }

    public final void I0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "styles");
        Object r3 = r2.get("align_items");
        if ((r3 instanceof String) == true) goto L5;
        r3 = null;
    L5:
        String r4 = (String) r3;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        switch(r4.hashCode()) {
            case -1364013995: goto L24;
            case -46581362: goto L21;
            case 100571: goto L18;
            case 109757538: goto L15;
            case 1742952711: goto L12;
            default: goto L34;
        };
    L34:
        return;
    L12:
        if (r4.equals("flex-end") == false) goto L27;
    L19:
        ((SlcAdaptiveView) I1()).setGravity(80);
        return;
    L27:
        return;
    L15:
        if (r4.equals("start") == false) goto L28;
    L22:
        ((SlcAdaptiveView) I1()).setGravity(48);
        return;
    L28:
        return;
    L18:
        if (r4.equals("end") == true) goto L19;
        return;
    L21:
        if (r4.equals("flex-start") == true) goto L22;
        return;
    L24:
        if (r4.equals("center") == false) goto L33;
        ((SlcAdaptiveView) I1()).setGravity(17);
        return;
    }

    public final ViewGroup K1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        SlcAdaptiveView r0 = new SlcAdaptiveView(r5, null, 6, 0);
        SlcTemplateContext r6 = ((BaseSlcViewManager) this).a;
        Intrinsics.checkNotNullParameter(r6, "ctx");
        r0.j = r6;
        return r0;
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.w0(r2);
    }

    public final void F0(int r1, int r2, int r3, int r4) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager*/.F0(r1, r2, r3, r4);
    }

    public final long u0(float r11, YogaMeasureMode r12, float r13, YogaMeasureMode r14) {
        Intrinsics.checkNotNullParameter(r12, "widthMode");
        Intrinsics.checkNotNullParameter(r14, "heightMode");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L46;
        BaseSlcViewManager r4 = getChildAt(r3);
        Object r5 = null;
        if (r4 == null) goto L7;
        Object r6 = r4.o("priority");
    L9:
        if ((r6 instanceof Number) == true) goto L11;
        r6 = null;
    L11:
        Number r7 = (Number) r6;
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        if (r4 == null) goto L17;
        Object r9 = r4.o("tagData");
    L19:
        if ((r9 instanceof String) == true) goto L21;
        r9 = null;
    L21:
        String r10 = (String) r9;
        if (r10 != null) goto L24;
        r10 = "";
    L24:
        if (r4 == null) goto L26;
        Object r15 = r4.o("gravity");
    L28:
        if ((r15 instanceof String) == false) goto L31;
        r5 = r15;
    L31:
        String r16 = (String) r5;
        if (r16 != null) goto L34;
        r16 = "left";
    L34:
        String r17 = r16.toLowerCase();
        if (r17.hashCode() == 108511772) goto L38;
    L40:
        AdaptiveHelpParams.Gravity r18 = AdaptiveHelpParams.Gravity.LEFT;
    L41:
        if (r4 == null) goto L45;
        View r19 = r4.getView();
        if (r19 == null) goto L45;
        r0.put(r19, new AdaptiveHelpParams(r8, r10, r18));
    L45:
        r3 = r3 + 1;
        goto L3
    L38:
        if (r17.equals("right") == false) goto L40;
        r18 = AdaptiveHelpParams.Gravity.RIGHT;
        goto L41
    L26:
        r15 = null;
        goto L28
    L17:
        r9 = null;
        goto L19
    L14:
        r8 = 0;
        goto L15
    L7:
        r6 = null;
        goto L9
    L46:
        SlcAdaptiveView r2 = (SlcAdaptiveView) I1();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "priorities");
        r2.a = r0;
        return super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager*/.u0(r11, r12, r13, r14);
    }

    public final void v(int r1, int r2, int r3, int r4) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r1, r2, r3, r4);
    }

    public final void D1(BaseSlcViewManager<?> r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        r2.v(r3, r4, r5, r6);
    }
}
