package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import android.content.Context;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.utils.gallery.k;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends t96.a {
    public final Context c;

    public e(Context r3) {
        Intrinsics.checkNotNullParameter("mediaPreview", "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        super("mediaPreview");
        this.c = r3;
    }

    public final void b(EventContext r31, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r32) {
        Intrinsics.checkNotNullParameter(r31, "eventContext");
        Intrinsics.checkNotNullParameter(r32, "completion");
        int r2 = h.a;
        Map r0 = r31.k;
        if (r0 != null) goto L5;
        h r3 = null;
    L68:
        if (r3 == null) goto L81;
        int r1 = k.a;
        Context r4 = this.c;
        List<fj.d> r5 = r3.c();
        if (r5 != null) goto L72;
        r5 = CollectionsKt.emptyList();
    L72:
        List<String> r6 = r3.b();
        if (r6 != null) goto L75;
        r6 = CollectionsKt.emptyList();
    L75:
        List r7 = CollectionsKt.emptyList();
        Integer r8 = r3.a();
        if (r8 == null) goto L78;
        int r9 = r8.intValue();
    L79:
        k.a(r4, r5, r6, r7, r9, true);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r32.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L78:
        r9 = 0;
        goto L79
    L81:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r32.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "eventFields is null", null, null, 57));
        return;
    L5:
        ArrayList r12 = new ArrayList();
        Object r13 = r0.get("video");
        if ((r13 instanceof Map) == true) goto L8;
        r13 = null;
    L8:
        Map r14 = (Map) r13;
        if (r14 == null) goto L52;
        Object r15 = r14.get("main_url");
        if ((r15 instanceof String) == true) goto L14;
        r15 = null;
    L14:
        String r16 = (String) r15;
        if (r16 == null) goto L52;
        Object r17 = r14.get("backup_url");
        if ((r17 instanceof String) == true) goto L20;
        r17 = null;
    L20:
        String r18 = (String) r17;
        Object r19 = r14.get("vid");
        if ((r19 instanceof String) == true) goto L23;
        r19 = null;
    L23:
        String r110 = (String) r19;
        if (r110 == null) goto L52;
        Object r20 = r14.get("width");
        if ((r20 instanceof Double) == true) goto L29;
        r20 = null;
    L29:
        Double r21 = (Double) r20;
        if (r21 == null) goto L52;
        long r111 = (long) r21.doubleValue();
        Object r22 = r14.get("height");
        if ((r22 instanceof Double) == true) goto L34;
        r22 = null;
    L34:
        Double r23 = (Double) r22;
        if (r23 == null) goto L52;
        long r112 = (long) r23.doubleValue();
        Object r24 = r14.get("duration");
        if ((r24 instanceof Double) == true) goto L39;
        r24 = null;
    L39:
        Double r25 = (Double) r24;
        if (r25 == null) goto L52;
        long r26 = (long) r25.doubleValue();
        Object r27 = r14.get("poster_url");
        if ((r27 instanceof String) == true) goto L44;
        r27 = null;
    L44:
        String r113 = (String) r27;
        Object r28 = r14.get("need_add_cookie");
        if ((r28 instanceof Boolean) == true) goto L47;
        r28 = null;
    L47:
        Boolean r29 = (Boolean) r28;
        if (r29 == null) goto L50;
        boolean r210 = r29.booleanValue();
    L51:
        fj.d r30 = new fj.d(r16, r18, r110, r111, r112, r26, r113, false, false, false, false, false, null, r210, 0, null, null, 122752);
    L53:
        if (r30 == null) goto L55;
        r12.add(r30);
    L55:
        Object r33 = r0.get("media_type");
        if ((r33 instanceof String) == true) goto L58;
        r33 = null;
    L58:
        String r34 = (String) r33;
        Object r35 = r0.get("image_url_array");
        if ((r35 instanceof List) == true) goto L61;
        r35 = null;
    L61:
        List r36 = (List) r35;
        Object r37 = r0.get("image_index");
        if ((r37 instanceof Integer) == true) goto L64;
        r37 = null;
    L64:
        Integer r38 = (Integer) r37;
        Object r39 = r0.get(SimilarProductParam.ENTER_FROM);
        if ((r39 instanceof Integer) == true) goto L67;
        r39 = null;
    L67:
        r3 = new h(r34, r12, r36, r38, (Integer) r39);
        goto L68
    L50:
        r210 = false;
    L52:
        r30 = null;
        goto L53
    }
}
