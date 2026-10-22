package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends b {
    public e(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "targetView");
        List r8 = r6.getActions();
        List r0 = r8;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L27;
        v r9 = this.a;
        if (r9 == null) goto L14;
        r9.dispose();
    L14:
        this.a = null;
        Iterator r10 = r8.iterator();
        e r11 = this;
    L16:
        if (r10.hasNext() == false) goto L26;
        IAction r3 = (IAction) r10.next();
        String r4 = r3.getType();
        v r5 = d.a(r4, this.c);
        if (r5 != null) goto L20;
        r5 = this.c.r(r4);
    L20:
        if (r5 == null) goto L16;
        Map r12 = r3.getParams();
        if (r12 == null) goto L25;
        r5.b(r12);
    L25:
        r11.a(r5);
        r11 = r5;
        goto L16
    L26:
        return false;
    L27:
        Map r13 = r6.getParams();
        if (r13 == null) goto L30;
        Object r14 = r13.get("actions");
    L32:
        if ((r14 instanceof List) == true) goto L34;
        r14 = null;
    L34:
        List r15 = (List) r14;
        List r16 = r15;
        if (r16 != null) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L58;
        if (r13 == null) goto L57;
        Object r18 = r13.get("params");
        if (r18 == null) goto L57;
        if ((r18 instanceof Map) == true) goto L49;
        r18 = null;
    L49:
        Map r19 = (Map) r18;
        if (r19 == null) goto L52;
        Object r20 = r19.get("actions");
    L54:
        if ((r20 instanceof List) == true) goto L56;
        r20 = null;
    L56:
        r15 = (List) r20;
        goto L58
    L52:
        r20 = null;
    L57:
        r15 = null;
    L58:
        List r21 = r15;
        if (r21 != null) goto L61;
    L64:
        if (r1 == false) goto L66;
        return false;
    L66:
        v r22 = this.a;
        if (r22 == null) goto L69;
        r22.dispose();
    L69:
        this.a = null;
        Iterator r23 = r15.iterator();
        e r24 = this;
    L71:
        if (r23.hasNext() == false) goto L99;
        Map r25 = (Map) r23.next();
        Object r26 = r25.get("disable");
        if ((r26 instanceof Boolean) == true) goto L75;
        r26 = null;
    L75:
        Boolean r27 = (Boolean) r26;
        if (r27 == null) goto L78;
        boolean r28 = r27.booleanValue();
    L79:
        if (r28 == true) goto L71;
        Object r29 = r25.get("type");
        if ((r29 instanceof String) == true) goto L84;
        r29 = null;
    L84:
        String r30 = (String) r29;
        if (r30 == null) goto L71;
        v r31 = d.a(r30, this.c);
        if (r31 != null) goto L90;
        r31 = this.c.r(r30);
    L90:
        if (r31 == null) goto L71;
        Object r32 = r25.get("fields");
        if ((r32 instanceof Map) == true) goto L95;
        r32 = null;
    L95:
        Map r33 = (Map) r32;
        if (r33 == null) goto L98;
        r31.b(r33);
    L98:
        r24.a(r31);
        r24 = r31;
        goto L71
    L78:
        r28 = false;
        goto L79
    L99:
        return false;
    L61:
        if (r21.isEmpty() == true) goto L64;
        r1 = false;
        goto L64
    L37:
        if (r16.isEmpty() == true) goto L40;
        r17 = false;
        goto L41
    L30:
        r14 = null;
        goto L32
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }
}
