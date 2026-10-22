package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SliceUpdateEvent extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public static final Map<String, r> d = null;
    public static final Companion e = null;

    public static final class Companion {
        public Companion() {
        }

        public static SlcCommonAction a(String r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "sliceId");
            Intrinsics.checkNotNullParameter(r5, "inComingData");
            return new SlcCommonAction(ActionType.SLICE_UPDATE.getType(), MapsKt.mapOf(new Pair[]{TuplesKt.to("slice_id", r4), TuplesKt.to("incoming_data", r5)}));
        }

        public final void update(String r4, final r r5) {
            Intrinsics.checkNotNullParameter(r4, "sliceId");
            Intrinsics.checkNotNullParameter(r5, "slice");
            Map<String, r> r0 = SliceUpdateEvent.d;
            Function1<Map.Entry<? extends String, ? extends r>, Boolean> r1 = new SliceUpdateEvent$Companion$update$1(r5);
            CollectionsKt.removeAll(((LinkedHashMap) r0).entrySet(), r1);
            r0.put(r4, r5);
        }
    }

    static {
        e = new Companion();
        d = new LinkedHashMap();
    }

    public SliceUpdateEvent(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.SLICE_UPDATE.getType());
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r7, fc3.a r8, fc3.c r9, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "actionContext");
        Intrinsics.checkNotNullParameter(r9, "handleActionParams");
        Intrinsics.checkNotNullParameter(r10, "completion");
        String r11 = com.bytedance.android.shopping.commentv3.event_chain.g.b(r7);
        if (r11 != null) goto L6;
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "slice update failed, slice id is empty", null, null, 57));
        return;
    L6:
        Map<?, ?> r13 = com.bytedance.android.shopping.commentv3.event_chain.g.a(r7);
        if (r13 != null) goto L10;
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "slice update failed, incoming data is empty", null, null, 57));
        return;
    L10:
        r r15 = (r) ((LinkedHashMap) d).get(r11);
        if (r15 != null) goto L14;
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "slice update failed, slice template view info is empty", null, null, 57));
        return;
    L14:
        Map r0 = r15.b.j;
        if (r0 == null) goto L17;
        Object r1 = r0.get("data");
    L19:
        if ((r1 instanceof Map) == true) goto L21;
        r1 = null;
    L21:
        Map r2 = (Map) r1;
        LinkedHashMap r3 = new LinkedHashMap();
        if (r2 == null) goto L27;
        Iterator r4 = r2.entrySet().iterator();
    L25:
        if (r4.hasNext() == false) goto L27;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.put(String.valueOf(r5.getKey()), r5.getValue());
    L27:
        Iterator<Map.Entry<?, ?>> r17 = r13.entrySet().iterator();
    L29:
        if (r17.hasNext() == false) goto L31;
        Map.Entry<?, ?> r6 = r17.next();
        r3.put(String.valueOf(r6.getKey()), r6.getValue());
        goto L29
    L31:
        r15.a(SliceRender.a(r3), r11);
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L17:
        r1 = null;
        goto L19
    }
}
