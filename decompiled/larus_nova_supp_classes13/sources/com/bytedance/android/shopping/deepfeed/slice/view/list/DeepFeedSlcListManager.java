package com.bytedance.android.shopping.deepfeed.slice.view.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.widget.banner.PrimeHorizontalRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcListManager extends com.bytedance.android.ecom.arch.slice.render.elements.b<DeepFeedSlcList> {
    public boolean H3;
    public Map<String, ? extends Object> I3;

    public final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DeepFeedSlcListManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static c o1(Map r12) {
        Object r0 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Boolean r1 = Boolean.FALSE;
        Object r2 = r12.get("visible");
        if ((r2 instanceof Boolean) == true) goto L8;
        r2 = null;
    L8:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L11;
        r3 = r1;
    L11:
        boolean r4 = r3.booleanValue();
        Object r5 = r12.get("loopScroll");
        if ((r5 instanceof Boolean) == true) goto L14;
        r5 = null;
    L14:
        Boolean r6 = (Boolean) r5;
        if (r6 != null) goto L17;
        r6 = r1;
    L17:
        boolean r7 = r6.booleanValue();
        Object r8 = r12.get("overScrollAction");
        if ((r8 instanceof Map) == true) goto L20;
        r8 = null;
    L20:
        Map r9 = (Map) r8;
        if (r9 == null) goto L23;
        Object r10 = r9.get("type");
    L24:
        String r11 = (String) r10;
        String r13 = "";
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        if (r9 == null) goto L30;
        Object r14 = r9.get("fields");
    L32:
        if ((r14 instanceof Map) == true) goto L34;
        r14 = null;
    L34:
        Map r15 = (Map) r14;
        Object r16 = r12.get("slideAction");
        if ((r16 instanceof Map) == true) goto L37;
        r16 = null;
    L37:
        Map r17 = (Map) r16;
        if (r17 == null) goto L40;
        Object r18 = r17.get("type");
    L42:
        if ((r18 instanceof String) == true) goto L44;
        r18 = null;
    L44:
        String r19 = (String) r18;
        if (r19 == null) goto L48;
        r13 = r19;
    L48:
        if (r17 == null) goto L50;
        Object r20 = r17.get("fields");
    L52:
        if ((r20 instanceof Map) == true) goto L54;
        r20 = null;
    L54:
        Map r21 = (Map) r20;
        Boolean r22 = Boolean.TRUE;
        Object r23 = r12.get("footer");
        if ((r23 instanceof Boolean) == true) goto L57;
        r23 = null;
    L57:
        Boolean r24 = (Boolean) r23;
        if (r24 == null) goto L61;
        r22 = r24;
    L61:
        boolean r25 = r22.booleanValue();
        Object r26 = r12.get("scrollToIndex");
        if ((r26 instanceof Number) == true) goto L64;
        r26 = null;
    L64:
        Number r27 = (Number) r26;
        if (r27 == null) goto L67;
        Integer r28 = Integer.valueOf(r27.intValue());
    L68:
        Object r110 = r12.get("syncSelectedToState");
        if ((r110 instanceof Boolean) == true) goto L71;
        r110 = null;
    L71:
        Boolean r111 = (Boolean) r110;
        if (r111 != null) goto L74;
        r111 = r1;
    L74:
        boolean r112 = r111.booleanValue();
        Object r113 = r12.get("keepPositionOnStop");
        if ((r113 instanceof Boolean) == false) goto L78;
        r0 = r113;
    L78:
        Boolean r29 = (Boolean) r0;
        if (r29 == null) goto L83;
        r1 = r29;
    L83:
        return new c(r4, r7, r25, new Pair(r11, r15), new Pair(r13, r21), r28, r112, r1.booleanValue());
    L67:
        r28 = null;
        goto L68
    L50:
        r20 = null;
        goto L52
    L40:
        r18 = null;
        goto L42
    L30:
        r14 = null;
        goto L32
    L23:
        r10 = null;
        goto L24
    }

    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
        this.I3 = r2;
        if (this.H3 == false) goto L10;
        c r3 = o1(r2);
        if (r3 == null) goto L11;
        DeepFeedSlcList r0 = (DeepFeedSlcList) k1();
        if (r0 == null) goto L12;
        r0.E(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList] */
    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r3 = null;
        ?? r0 = new DeepFeedSlcList(r5, null, 6, 0);
        SlcTemplateContext r6 = ((BaseSlcViewManager) this).a;
        Intrinsics.checkNotNullParameter(r6, "templateCtx");
        r0.k = r6;
        Object r7 = r6.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r7 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L6;
        r3 = r7;
    L6:
        com.bytedance.android.shopping.deepfeed.slice.service.b r4 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r3;
        DeepFeedProductOverScrollPagerSnapHelper r8 = r0.f;
        r8.a = new com.bytedance.android.shopping.deepfeed.slice.view.list.a(r0);
        return r0;
    }

    public final void w0(final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCtx");
        DeepFeedSlcList r0 = (DeepFeedSlcList) k1();
        RecyclerView.Adapter r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r2 = r0.getAdapter();
    L7:
        if ((r2 instanceof DeepFeedSlcListAdapter) == false) goto L10;
        r1 = r2;
    L10:
        final DeepFeedSlcListAdapter r3 = (DeepFeedSlcListAdapter) r1;
        if (r3 != null) goto L13;
        return;
    L13:
        PrimeHorizontalRecyclerView r5 = (DeepFeedSlcList) k1();
        if (r5 == null) goto L28;
        Function0<Unit> r6 = new DeepFeedSlcListManager$onAfterBindSelf$doUpdate$1(r3, r4);
        if (r5.isComputingLayout() != true) goto L18;
        r5.post(new a(r6));
    L20:
        if (this.H3 == true) goto L26;
        c r7 = o1(this.I3);
        if (r7 == null) goto L26;
        DeepFeedSlcList r8 = (DeepFeedSlcList) k1();
        if (r8 == null) goto L26;
        r8.E(r7);
    L26:
        this.H3 = true;
        return;
    L18:
        r6.invoke();
        goto L20
    L28:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void y0(SlcElement r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        List r5 = r4.getElements();
        DeepFeedSlcList r0 = (DeepFeedSlcList) k1();
        if (r0 == null) goto L8;
        r0.setAdapter(new DeepFeedSlcListAdapter(((BaseSlcViewManager) this).a, r5));
        return;
    }
}
