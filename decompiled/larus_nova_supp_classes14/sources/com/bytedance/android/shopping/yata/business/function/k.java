package com.bytedance.android.shopping.yata.business.function;

import android.view.View;
import com.bytedance.android.shopping.buynow.yata.abilities.BuyNowUIAbility;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.a {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public k(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r23, final Function1 r24) {
        Intrinsics.checkNotNullParameter(r23, "input");
        Intrinsics.checkNotNullParameter(r24, "chainNextCallback");
        Map r1 = this.a.c().a(r23);
        if (r1 == null) goto L5;
        Object r2 = r1.get("position");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        final String r15 = (String) r2;
        if (r1 == null) goto L12;
        Object r3 = r1.get("scroll_node");
    L14:
        if ((r3 instanceof Map) == true) goto L16;
        r3 = null;
    L16:
        Map r4 = (Map) r3;
        if (r4 == null) goto L19;
        Object r5 = r4.get("view_code");
    L21:
        if ((r5 instanceof String) == true) goto L23;
        r5 = null;
    L23:
        String r6 = (String) r5;
        if (r4 == null) goto L26;
        Object r7 = r4.get("slice_key");
    L28:
        if ((r7 instanceof String) == true) goto L30;
        r7 = null;
    L30:
        String r8 = (String) r7;
        if (r4 == null) goto L33;
        Object r9 = r4.get("match_vo");
    L35:
        if ((r9 instanceof Map) == true) goto L37;
        r9 = null;
    L37:
        Map r10 = (Map) r9;
        if (r1 == null) goto L40;
        Object r11 = r1.get("offset");
    L42:
        if ((r11 instanceof Map) == true) goto L44;
        r11 = null;
    L44:
        final Map r14 = (Map) r11;
        if (r1 == null) goto L47;
        Object r12 = r1.get("item_node");
    L49:
        if ((r12 instanceof Map) == true) goto L51;
        r12 = null;
    L51:
        final Map r13 = (Map) r12;
        final Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = this.a.b().f(r6);
        if (this.a.d().b((View) r16.element) == false) goto L55;
        r16.element = this.a.c().e(r6);
    L55:
        if (this.a.d().b((View) r16.element) == false) goto L58;
        r16.element = this.a.c().g(r6);
    L58:
        if (this.a.d().b((View) r16.element) == false) goto L65;
        r16.element = this.a.b().b(r10);
        if (this.a.d().d((View) r16.element) == false) goto L65;
        if (this.a.d().d(r8) == false) goto L65;
        r16.element = this.a.r().a((View) r16.element, r8);
    L65:
        if (this.a.d().b((View) r16.element) == false) goto L68;
        ll3.b.a(this.a, "selfScrollComponentToPosition", "target view is empty", r23);
        int r0 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r24.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "target view is empty", null, null, 57));
        return;
    L68:
        BuyNowUIAbility r17 = this.a.b();
        if (r13 == null) goto L71;
        Object r18 = r13.get("match_vo");
    L73:
        if ((r18 instanceof Map) == true) goto L75;
        r18 = null;
    L75:
        Pair r19 = r17.e((Map) r18);
        if (this.a.d().b(r19) == false) goto L79;
        ll3.b.a(this.a, "selfScrollComponentToPosition", "target Item Node is not found", r23);
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r24.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "target Item Node is not found", null, null, 57));
        return;
    L79:
        if (r19 == null) goto L83;
        Integer r21 = (Integer) r19.getFirst();
        if (r21 == null) goto L83;
        int r22 = r21.intValue();
    L84:
        if (r19 == null) goto L87;
        String r25 = (String) r19.getSecond();
    L87:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{ScrollPosition.POSITION_BOTTOM, ScrollPosition.POSITION_TOP, ScrollPosition.POSITION_VERTICAL_CENTER, ScrollPosition.POSITION_LEFT, ScrollPosition.POSITION_RIGHT, ScrollPosition.POSITION_HORIZONTAL_CENTER}), r15) == false) goto L110;
        BuyNowUIAbility r26 = this.a.b();
        if (r13 == null) goto L91;
        Object r27 = r13.get("match_vo");
    L93:
        if ((r27 instanceof Map) == true) goto L95;
        r27 = null;
    L95:
        View r110 = r26.b((Map) r27);
        if (r110 == null) goto L107;
        if (r13 == null) goto L99;
        Object r28 = r13.get("slice_key");
    L101:
        if ((r28 instanceof String) == true) goto L103;
        r28 = null;
    L103:
        String r29 = (String) r28;
        if (this.a.d().d(r29) == false) goto L106;
        this.a.b().i((View) r16.element, this.a.r().a(r110, r29), null, r14, r15, new SelfScrollComponentToPositionFunction$onExecuteAsync$1(r24));
    L111:
        int r30 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r24.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L106:
        this.a.b().i((View) r16.element, r110, null, r14, r15, new SelfScrollComponentToPositionFunction$onExecuteAsync$2(r24));
        goto L111
    L99:
        r28 = null;
        goto L101
    L107:
        if (r22 <= 0) goto L109;
        this.a.b().i((View) r16.element, null, Integer.valueOf(r22), r14, r15, new SelfScrollComponentToPositionFunction$onExecuteAsync$3(this, r13, r16, r14, r15, r24));
        goto L111
    L109:
        ll3.b.a(this.a, "selfScrollComponentToPosition", "sliceView is not found", r23);
        int r31 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r24.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "sliceView is not found", null, null, 57));
        goto L111
    L91:
        r27 = null;
        goto L93
    L110:
        ll3.b.a(this.a, "selfScrollComponentToPosition", "position is not support", r23);
    L83:
        r22 = -1;
        goto L84
    L71:
        r18 = null;
        goto L73
    L47:
        r12 = null;
        goto L49
    L40:
        r11 = null;
        goto L42
    L33:
        r9 = null;
        goto L35
    L26:
        r7 = null;
        goto L28
    L19:
        r5 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
