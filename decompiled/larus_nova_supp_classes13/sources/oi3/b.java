package oi3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewGroupManager<c> {
    public c V3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        SlcRoundFrameLayout r0 = new c(r3);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return r0;
    }

    public final void H0(Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "props");
        Object r1 = r11.get("animates");
        Object r3 = null;
        if ((r1 instanceof List) == true) goto L5;
        r1 = null;
    L5:
        List r2 = (List) r1;
        if (r2 == null) goto L50;
        List r4 = r2;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L31;
        Map r7 = (Map) r6.next();
        Object r8 = r7.get("scale_x");
        if ((r8 instanceof Number) == true) goto L13;
        r8 = null;
    L13:
        Number r9 = (Number) r8;
        float r10 = 1.0f;
        if (r9 == null) goto L16;
        float r12 = r9.floatValue();
    L17:
        Object r13 = r7.get("scale_y");
        if ((r13 instanceof Number) == true) goto L20;
        r13 = null;
    L20:
        Number r14 = (Number) r13;
        if (r14 == null) goto L23;
        r10 = r14.floatValue();
    L23:
        Object r15 = r7.get("animate_time");
        if ((r15 instanceof Number) == true) goto L26;
        r15 = null;
    L26:
        Number r16 = (Number) r15;
        if (r16 == null) goto L29;
        float r17 = r16.floatValue();
    L30:
        r5.add(new a(r12, r10, r17));
        goto L9
    L29:
        r17 = 0.1f;
        goto L30
    L16:
        r12 = 1.0f;
        goto L17
    L31:
        c r18 = this.V3;
        if (r18 == null) goto L51;
        Object r19 = r11.get("animating");
        if ((r19 instanceof Boolean) == false) goto L37;
        r3 = r19;
    L37:
        Boolean r20 = (Boolean) r3;
        if (r20 == null) goto L40;
        boolean r21 = r20.booleanValue();
    L41:
        Intrinsics.checkNotNullParameter(r5, "animates");
        if (r21 == true) goto L44;
        return;
    L44:
        if (r18.c == true) goto L53;
        r18.b(0, r5);
        return;
    L53:
        return;
    L40:
        r21 = false;
        goto L41
    L51:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(View r2) {
        c r3 = (c) r2;
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        this.V3 = r3;
    }
}
