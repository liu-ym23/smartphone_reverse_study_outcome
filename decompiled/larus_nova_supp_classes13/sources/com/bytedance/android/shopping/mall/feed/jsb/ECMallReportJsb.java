package com.bytedance.android.shopping.mall.feed.jsb;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.BstUtilsNewKt;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallReportJsb extends qf3.e {
    public static final /* synthetic */ int f = 0;
    public final Lazy d;
    public final String e;

    public static final class a {
        public static void a(Map r12, qf3.d r13) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "mallJsbContext");
            Object r2 = r12.get("eventName");
            Object r4 = null;
            if ((r2 instanceof String) == true) goto L5;
            r2 = null;
        L5:
            String r6 = (String) r2;
            Object r3 = r12.get("index");
            if ((r3 instanceof Integer) == true) goto L8;
            r3 = null;
        L8:
            Integer r5 = (Integer) r3;
            if (r5 == null) goto L11;
            int r9 = r5.intValue();
        L12:
            Object r7 = r12.get("trackDataKey");
            if ((r7 instanceof String) == true) goto L15;
            r7 = null;
        L15:
            String r8 = (String) r7;
            boolean r10 = true;
            if (r6 != null) goto L18;
        L21:
            boolean r11 = true;
        L22:
            if (r11 == true) goto L137;
            if (r8 != null) goto L25;
        L28:
            boolean r14 = true;
        L29:
            if (r14 == true) goto L139;
            ECHybridListEngine r15 = r13.b.J;
            if (r15 == null) goto L138;
            Intrinsics.checkNotNullParameter(r6, "event");
            Intrinsics.checkNotNullParameter(r8, "combinedDataId");
            if (r6.length() != 0) goto L36;
            boolean r16 = true;
        L37:
            if (r16 == false) goto L39;
        L104:
            com.bytedance.android.ec.hybrid.list.entity.c r17 = null;
        L105:
            if (r17 == null) goto L140;
            LinkedHashMap r1 = new LinkedHashMap();
            Map r18 = r17.b;
            if (r18 == null) goto L110;
            r1.putAll(r18);
        L110:
            r13.b.j0.a(new com.bytedance.android.shopping.api.mall.common.feed.help.f(r6, r17.c, r1, r9, null, null));
            Object r19 = r12.get("params");
            if ((r19 instanceof Map) == false) goto L114;
            r4 = r19;
        L114:
            Map r20 = (Map) r4;
            if (r20 == null) goto L117;
            r1.putAll(r20);
        L117:
            r12.put("params", r1);
            return;
        L140:
            return;
        L39:
            if (r8.length() == 0) goto L42;
            r10 = false;
        L42:
            if (r10 == true) goto L104;
            com.bytedance.android.ec.hybrid.list.entity.k r21 = r15.c.g;
            if (r21 == null) goto L104;
            ArrayList r22 = r21.c;
            if (r22 == null) goto L104;
            Iterator r23 = r22.iterator();
        L50:
            if (r23.hasNext() == false) goto L104;
            ArrayList r24 = ((com.bytedance.android.ec.hybrid.list.entity.i) r23.next()).i;
            if (r24 == null) goto L50;
            Iterator r25 = r24.iterator();
        L55:
            if (r25.hasNext() == false) goto L63;
            Object r26 = r25.next();
            com.bytedance.android.ec.hybrid.list.entity.n r27 = ((ECHybridListItemVO) r26).o;
            if (r27 == null) goto L59;
            String r28 = r27.h;
        L61:
            if (Intrinsics.areEqual(r28, r8) == false) goto L55;
        L64:
            ECHybridListItemVO r29 = (ECHybridListItemVO) r26;
            if (r29 == null) goto L50;
            com.bytedance.android.ec.hybrid.list.entity.n r30 = r29.o;
            if (r30 == null) goto L104;
            Intrinsics.checkNotNullParameter(r6, "eventName");
            List r31 = r30.e;
            if (r31 == null) goto L80;
            Iterator r32 = r31.iterator();
        L72:
            if (r32.hasNext() == false) goto L76;
            Object r33 = r32.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.c) r33).a, r6) == false) goto L72;
        L77:
            r17 = (com.bytedance.android.ec.hybrid.list.entity.c) r33;
            if (r17 == null) goto L80;
        L76:
            r33 = null;
        L80:
            List r34 = r30.g;
            if (r34 == null) goto L92;
            Iterator r35 = r34.iterator();
        L84:
            if (r35.hasNext() == false) goto L88;
            Object r36 = r35.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.c) r36).a, r6) == false) goto L84;
        L89:
            r17 = (com.bytedance.android.ec.hybrid.list.entity.c) r36;
            if (r17 == null) goto L92;
        L88:
            r36 = null;
        L92:
            List r37 = r30.c;
            if (r37 == null) goto L104;
            Iterator r38 = r37.iterator();
        L96:
            if (r38.hasNext() == false) goto L100;
            Object r39 = r38.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.c) r39).a, r6) == false) goto L96;
        L101:
            r17 = (com.bytedance.android.ec.hybrid.list.entity.c) r39;
            if (r17 == null) goto L104;
        L100:
            r39 = null;
            goto L101
        L59:
            r28 = null;
            goto L61
        L63:
            r26 = null;
            goto L64
        L36:
            r16 = false;
            goto L37
        L138:
            return;
        L139:
            return;
        L25:
            if (r8.length() == 0) goto L28;
            r14 = false;
            goto L29
        L137:
            return;
        L18:
            if (r6.length() == 0) goto L21;
            r11 = false;
            goto L22
        L11:
            r9 = -2;
            goto L12
        }
    }

    static {
    }

    public final String getName() {
        return this.e;
    }

    public ECMallReportJsb(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = LazyKt.lazy(ECMallReportJsb$optFpsSetting$2.INSTANCE);
        this.e = "ec.mallReport";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r5, IBDXBridgeContext r6, Map<String, ? extends Object> r7, Map<String, Object> r8) {
        Intrinsics.checkNotNullParameter(r5, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "result");
        ECMallFeed.f r9 = r5.b.A1;
        if (r9.isAttached() == false) goto L43;
        if (r7.isEmpty() == true) goto L43;
        if (r7.get("eventName") == null) goto L43;
        if (TypeIntrinsics.isMutableMap(r7) == true) goto L13;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(r7);
        r7 = r1;
    L13:
        a.a(r7, r5);
        Map<String, Object> r10 = r9.getGlobalProps();
        Object r2 = r10.get("video_guide_mall");
        if (r2 == null) goto L16;
        String r3 = r2.toString();
    L17:
        String r4 = com.bytedance.android.shopping.api.mall.common.tools.b0.k(r3);
        if (r4 == null) goto L20;
        r7.put("video_guide_mall", r4);
    L20:
        View r11 = r6.getEngineView();
        if (r11 != null) goto L23;
        ExtKt.b("NativeMallHomePage", "engineView is null");
    L23:
        Object r0 = r7.get("eventName");
        if ((r0 instanceof String) == true) goto L27;
        r0 = null;
    L27:
        if ((!Intrinsics.areEqual((String) r0, "click_product")) == false) goto L34;
        ECMallFeed.ReportAbility r12 = r5.b.j0;
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L32;
        r10 = null;
    L32:
        k93.g.a.a(r12, r7, r10, null, 12);
    L41:
        return qf3.e.f(this);
    L34:
        if (BstUtilsNewKt.a(r7, r11, ((Boolean) this.d.getValue()).booleanValue(), r10, r5) == true) goto L41;
        ECMallFeed.ReportAbility r13 = r5.b.j0;
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L39;
        r10 = null;
    L39:
        k93.g.a.a(r13, r7, r10, null, 12);
        goto L41
    L16:
        r3 = null;
    L43:
        return qf3.e.c("container is not attached or params is empty or eventName is null");
    }
}
