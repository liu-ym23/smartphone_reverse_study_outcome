package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECTagListView> {
    public float H3;
    public Map<String, ? extends Object> I3;

    public static final class a {
    }

    static {
    }

    public final gk3.a o1() {
        SlcTemplateContext r0 = ((BaseSlcViewManager) this).a;
        String r1 = r0.g;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Object r2 = r0.o(r1);
        if ((r2 instanceof gk3.a) == true) goto L9;
        r2 = null;
    L9:
        return (gk3.a) r2;
    }

    public i(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r0 = r12.entrySet().iterator();
        Float r1 = null;
        Map<String, ? extends Object> r2 = null;
    L7:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<String, ? extends Object> r3 = r0.next();
        String r4 = r3.getKey();
        if (r4.hashCode() != (-764061149)) goto L7;
        if (r4.equals("tag_list") == false) goto L7;
        Object r5 = r3.getValue();
        if (r5 == null) goto L17;
        r2 = (Map) r5;
        goto L7
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    L19:
        if ((!Intrinsics.areEqual(r2, this.I3)) == false) goto L52;
        this.I3 = r2;
        ECTagListDTO r6 = new ECTagListDTO(r2);
        gk3.a r7 = o1();
        if (r7 == null) goto L23;
        com.bytedance.android.ec.store.view.j r8 = r7.f(r6, k1());
    L24:
        ECTagListView r9 = k1();
        if (r9 == null) goto L43;
        if (r8 == null) goto L28;
        String r10 = r8.a;
    L29:
        r6.setScene(r10);
        Unit r11 = Unit.INSTANCE;
        if (r8 == null) goto L32;
        Integer r13 = r8.b;
    L33:
        if (r8 == null) goto L35;
        Map r14 = r8.c;
    L36:
        if (r8 == null) goto L38;
        Function0 r15 = r8.d;
    L39:
        if (r8 == null) goto L41;
        xm.c r16 = r8.e;
    L42:
        ECTagListView.c(r9, r6, r13, r14, r15, r16, null, 32);
        goto L43
    L41:
        r16 = null;
        goto L42
    L38:
        r15 = null;
        goto L39
    L35:
        r14 = null;
        goto L36
    L32:
        r13 = null;
        goto L33
    L28:
        r10 = null;
    L43:
        gk3.a r17 = o1();
        if (r17 == null) goto L46;
        r17.e((ECTagListView) k1(), r6);
    L46:
        ECTagListView r18 = k1();
        if (r18 == null) goto L49;
        r18.k(this.H3);
    L49:
        ECTagListView r19 = k1();
        if (r19 == null) goto L52;
        r19.post(new j(this));
        goto L52
    L23:
        r8 = null;
    L52:
        Object r110 = r12.get("color_animation_percent");
        if (r110 == null) goto L55;
        r1 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r110);
    L55:
        if (r1 != null) goto L57;
        return;
    L57:
        if ((!Intrinsics.areEqual(r1, this.H3)) == false) goto L71;
        dm.a.a("ShopTagListViewManager").a("updateColorPercent: " + r1);
        this.H3 = r1.floatValue();
        ECTagListView r111 = k1();
        if (r111 == null) goto L72;
        r111.k(this.H3);
        return;
    L72:
        return;
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new ECTagListView(r5, null, 6, 0);
    }
}
