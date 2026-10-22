package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ecom.arch.slice.render.elements.b<e> {
    public String H3;
    public Map<String, ? extends Object> I3;
    public com.bytedance.android.shopping.deepfeed.slice.service.a J3;

    public d(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.H3 = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final void H0(Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        Map<String, ? extends Object> r1 = null;
        if (this.J3 != null) goto L12;
        c r0 = new c(this);
        Object r2 = ((BaseSlcViewManager) this).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L8;
        r2 = null;
    L8:
        com.bytedance.android.shopping.deepfeed.slice.service.b r3 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r2;
        if (r3 == null) goto L11;
        r3.K(r0);
    L11:
        this.J3 = r0;
    L12:
        ?? r4 = 0;
        r4 = 0;
        o1(r15, "loop", 0);
        Object r5 = r15.get("autoPlay");
        if ((r5 instanceof Boolean) == false) goto L16;
        r4 = ((Boolean) r5).booleanValue();
    L28:
        Object r6 = r15.get("src");
        if ((r6 instanceof String) == true) goto L31;
        r6 = null;
    L31:
        String r7 = (String) r6;
        String r8 = "";
        if (r7 != null) goto L34;
        r7 = "";
    L34:
        Object r9 = r15.get("type");
        if ((r9 instanceof String) == true) goto L37;
        r9 = null;
    L37:
        String r10 = (String) r9;
        if (r10 != null) goto L41;
        r10 = "";
    L41:
        if (StringsKt.isBlank(r10) == false) goto L43;
        r10 = "net";
    L43:
        Object r11 = r15.get("android_url");
        if ((r11 instanceof String) == true) goto L46;
        r11 = null;
    L46:
        String r12 = (String) r11;
        if (r12 != null) goto L49;
        r12 = "";
    L49:
        o1(r15, "play", o1(r15, "play", r4));
        Object r13 = r15.get("modifyParams");
        if ((r13 instanceof Map) == true) goto L52;
        r13 = null;
    L52:
        Map r14 = (Map) r13;
        if (r14 != null) goto L55;
        Map r16 = MapsKt.emptyMap();
    L70:
        Object r17 = r15.get("animationEndAction");
        if ((r17 instanceof String) == false) goto L76;
        if ((true ^ StringsKt.isBlank((CharSequence) r17)) == false) goto L76;
        Pair r18 = TuplesKt.to(r17, null);
    L109:
        if (r18 == null) goto L114;
        String r19 = (String) r18.getFirst();
        if (r19 == null) goto L114;
        r8 = r19;
    L114:
        this.H3 = r8;
        if (r18 == null) goto L117;
        r1 = (Map) r18.getSecond();
    L117:
        this.I3 = r1;
        if (((e) k1()) == null) goto L135;
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r12, "androidUrl");
        Intrinsics.checkNotNullParameter(r7, "src");
        Intrinsics.checkNotNullParameter(r16, "modifyParams");
        return;
    L135:
        return;
    L76:
        if ((r17 instanceof Map) == true) goto L78;
        r17 = null;
    L78:
        Map r110 = (Map) r17;
        if (r110 == null) goto L86;
        Object r20 = r110.get("type");
        if ((r20 instanceof String) == true) goto L84;
        r20 = null;
    L84:
        String r21 = (String) r20;
        if (r21 == null) goto L86;
        Object r111 = r110.get("fields");
        if ((r111 instanceof Map) == true) goto L90;
        r111 = null;
    L90:
        Map r112 = (Map) r111;
        if (r112 == null) goto L107;
        Set r113 = r112.entrySet();
        if (r113 == null) goto L107;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L96:
        if (r115.hasNext() == false) goto L106;
        Map.Entry r116 = (Map.Entry) r115.next();
        Object r117 = r116.getKey();
        Object r118 = r116.getValue();
        if ((r117 instanceof String) == true) goto L100;
        r117 = null;
    L100:
        String r119 = (String) r117;
        if (r119 == null) goto L103;
        Pair r120 = TuplesKt.to(r119, r118);
    L104:
        if (r120 == null) goto L96;
        r114.add(r120);
        goto L96
    L103:
        r120 = null;
        goto L104
    L106:
        Map r121 = MapsKt.toMap(r114);
    L108:
        r18 = TuplesKt.to(r21, r121);
    L107:
        r121 = null;
    L86:
        r18 = null;
        goto L109
    L55:
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator r22 = r14.entrySet().iterator();
    L57:
        if (r22.hasNext() == false) goto L69;
        Map.Entry r123 = (Map.Entry) r22.next();
        Object r124 = r123.getKey();
        Object r125 = r123.getValue();
        if ((r124 instanceof String) == true) goto L61;
        r124 = null;
    L61:
        String r126 = (String) r124;
        if (r126 == null) goto L57;
        if (r125 == null) goto L57;
        String r127 = r125.toString();
        if (r127 == null) goto L57;
        r122.put(r126, r127);
        goto L57
    L69:
        r16 = r122;
        goto L70
    L16:
        if ((r5 instanceof Integer) == false) goto L19;
        r4 = Intrinsics.areEqual(r5, 1);
        goto L28
    L19:
        if ((r5 instanceof Long) == false) goto L22;
        r4 = Intrinsics.areEqual(r5, 1L);
        goto L28
    L22:
        if ((r5 instanceof String) == false) goto L28;
        if (Intrinsics.areEqual(r5, "1") == false) goto L26;
    L27:
        r4 = 1;
        goto L28
    L26:
        if (StringsKt.equals((String) r5, "true", true) == false) goto L28;
        goto L27
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        final e r0 = new e(r2);
        r0.setOnAnimationEndListener(new DeepFeedSlcLottieManager$onCreateContentView$$inlined$apply$lambda$1(r0, this));
        return r0;
    }

    public static int o1(Map r0, String r1, int r2) {
        Object r3 = r0.get(r1);
        if ((r3 instanceof Integer) == false) goto L6;
        return ((Number) r3).intValue();
    L6:
        if ((r3 instanceof Long) == false) goto L9;
        return (int) ((Number) r3).longValue();
    L9:
        if ((r3 instanceof Float) == false) goto L12;
        return (int) ((Number) r3).floatValue();
    L12:
        if ((r3 instanceof Double) == false) goto L15;
        return (int) ((Number) r3).doubleValue();
    L15:
        if ((r3 instanceof String) == false) goto L24;
        Integer r4 = StringsKt.toIntOrNull((String) r3);
        if (r4 != null) goto L19;
        return r2;
    L19:
        return r4.intValue();
    L24:
        return r2;
    }
}
