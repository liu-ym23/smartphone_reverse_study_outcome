package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 {
    public final Map<String, Object> a;
    public SlcContext b;
    public final s c;

    public final Map<String, Object> a() {
        Pair[] r0 = new Pair[7];
        int r2 = 0;
        r0[0] = TuplesKt.to("index", Integer.valueOf(this.c.getCurrentPosition()));
        r0[1] = TuplesKt.to("full_mode", Boolean.valueOf(this.c.isExpanded()));
        r0[2] = TuplesKt.to("big_screen_device", Boolean.valueOf(!com.bytedance.android.shopping.anchorv3.detail.utils.a.a()));
        if (com.bytedance.android.shopping.anchorv4.experiment.h.a() == false) goto L5;
        boolean r1 = false;
    L6:
        r0[3] = TuplesKt.to("special_size", Boolean.valueOf(r1));
        int r3 = this.c.getCurrentPosition();
        if (this.c.h00() == true) goto L15;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (this.c.aN(r4) == false) goto L13;
        r5 = r5 + 1;
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        r3 = r3 - r5;
    L15:
        r0[4] = TuplesKt.to("header_index", Integer.valueOf(r3));
        int r6 = this.c.G7();
        if (this.c.h00() == true) goto L24;
        int r7 = 0;
    L18:
        if (r2 >= r6) goto L23;
        if (this.c.aN(r2) == false) goto L22;
        r7 = r7 + 1;
    L22:
        r2 = r2 + 1;
        goto L18
    L23:
        r6 = r6 - r7;
    L24:
        r0[5] = TuplesKt.to("header_pre_index", Integer.valueOf(r6));
        r0[6] = TuplesKt.to("header_is_expand", Boolean.valueOf(this.c.h00()));
        return MapsKt.mapOf(r0);
    L5:
        r1 = this.c.i();
        goto L6
    }

    public d0(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        this.c = r2;
        this.a = new LinkedHashMap();
    }

    public final c0 b(String r4, com.bytedance.android.ecom.arch.slice.g r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r0 = ((LinkedHashMap) this.a).get(r4);
        if ((r0 instanceof SlcTemplateViewHelper) == true) goto L5;
        r0 = null;
    L5:
        SlcTemplateViewHelper r1 = (SlcTemplateViewHelper) r0;
        if (r1 != null) goto L11;
        SlcContext r2 = this.b;
        if (r2 == null) goto L11;
        if (r5 == null) goto L11;
        r1 = new SlcTemplateViewHelper(null);
        r1.f(r2);
        r1.b(r5, a(), null);
        this.a.put(r4, r1);
        boolean r6 = false;
    L12:
        if (r1 != null) goto L14;
        return null;
    L14:
        return new c0(r1, r6);
    L11:
        r6 = true;
        goto L12
    }

    public final com.bytedance.android.ecom.arch.slice.render.r c(String r6, SlcElement r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Object r0 = ((LinkedHashMap) this.a).get(r6);
        if ((r0 instanceof com.bytedance.android.ecom.arch.slice.render.r) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.ecom.arch.slice.render.r r1 = (com.bytedance.android.ecom.arch.slice.render.r) r0;
        if (r1 != null) goto L12;
        SlcContext r2 = this.b;
        if (r2 == null) goto L13;
        if (r7 == null) goto L14;
        SliceRender r3 = SliceRender.o;
        com.bytedance.android.ecom.arch.slice.render.q r4 = new com.bytedance.android.ecom.arch.slice.render.q("pdp_header_component", 14);
        r3.getClass();
        com.bytedance.android.ecom.arch.slice.render.r.a r5 = com.bytedance.android.ecom.arch.slice.render.r.d;
        r5.getClass();
        com.bytedance.android.ecom.arch.slice.render.p r8 = r4.b();
        r5.getClass();
        com.bytedance.android.ecom.arch.slice.render.r r9 = com.bytedance.android.ecom.arch.slice.render.r.a.a(r2, r7, r8);
        this.a.put(r6, r9);
        return r9;
    L14:
        return r1;
    L13:
        return r1;
    L12:
        return r1;
    }

    public final void d(IAction r8, View r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "action");
        int r0 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, this.b, r8, r9, r10);
    }
}
