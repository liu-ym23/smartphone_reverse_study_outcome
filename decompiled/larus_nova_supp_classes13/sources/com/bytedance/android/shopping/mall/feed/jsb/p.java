package com.bytedance.android.shopping.mall.feed.jsb;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public p(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallGetCardPosition";
    }

    public final Map<String, Object> g(Map<String, ? extends Object> r18, IBDXBridgeContext r19) {
        LinkedHashMap r1 = new LinkedHashMap();
        Object r2 = r18.get("target");
        Object r4 = null;
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        Object r5 = r18.get("sectionID");
        if ((r5 instanceof String) == true) goto L8;
        r5 = null;
    L8:
        String r6 = (String) r5;
        Object r7 = r18.get("itemID");
        if ((r7 instanceof String) == true) goto L11;
        r7 = null;
    L11:
        String r8 = (String) r7;
        Object r9 = r18.get("index");
        if ((r9 instanceof Integer) == true) goto L14;
        r9 = null;
    L14:
        Integer r10 = (Integer) r9;
        Set<String> r11 = n.a;
        if (CollectionsKt.contains(r11, r3) == true) goto L21;
        if (r6 == null) goto L19;
        if (r8 != null) goto L21;
        if (r10 != null) goto L21;
    L19:
        r1.put("code", 0);
        r1.put("data", MapsKt.mapOf(TuplesKt.to("err_message", "target=" + r3 + ",sectionID=" + r6 + ", itemID=" + r8 + ",index=" + r10)));
        return r1;
    L21:
        Object r12 = r18.get("elementName");
        if ((r12 instanceof String) == true) goto L24;
        r12 = null;
    L24:
        String r13 = (String) r12;
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        ECMallFeed r14 = this.c.b;
        ECMallFeed.f r15 = r14.A1;
        ECHybridListEngine r16 = r14.J;
        if (CollectionsKt.contains(r11, r3) == false) goto L30;
        View r17 = r15.yZ(r3, r13);
    L73:
        Resources r20 = Resources.getSystem();
        float r21 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).density;
        if (r21 <= 0) goto L95;
        if (r17 == null) goto L95;
        Object r0 = r18.get("coordinate");
        if ((r0 instanceof Integer) == false) goto L80;
        r4 = r0;
    L80:
        Integer r22 = (Integer) r4;
        if (r22 == null) goto L83;
        int r23 = r22.intValue();
    L84:
        int[] r24 = new int[2];
        r17.getLocationOnScreen(r24);
        int r25 = r24[0];
        int r26 = r24[1];
        int r27 = r17.getWidth() + r25;
        int r28 = r17.getHeight() + r26;
        LinkedHashMap r29 = new LinkedHashMap();
        float r30 = r25 / r21;
        r29.put("left", String.valueOf(r30));
        float r31 = r26 / r21;
        r29.put("top", String.valueOf(r31));
        float r32 = r27 / r21;
        r29.put("right", String.valueOf(r32));
        float r33 = r28 / r21;
        r29.put("bottom", String.valueOf(r33));
        r1.put("code", 1);
        if (r23 == 0) goto L94;
        int[] r34 = new int[2];
        if (r19 == null) goto L92;
        View r35 = r19.getEngineView();
        if (r35 == null) goto L92;
        r35.getLocationOnScreen(r34);
        float r36 = r34[0] / r21;
        float r37 = r34[1] / r21;
        Unit r38 = Unit.INSTANCE;
    L93:
        LinkedHashMap r39 = new LinkedHashMap();
        r39.put("left", String.valueOf(r30 - r36));
        r39.put("top", String.valueOf(r31 - r37));
        r39.put("right", String.valueOf(r32 - r36));
        r39.put("bottom", String.valueOf(r33 - r37));
        Unit r40 = Unit.INSTANCE;
        r29 = r39;
    L92:
        r36 = 0.0f;
        r37 = 0.0f;
    L94:
        r1.put("data", r29);
    L96:
        return r1;
    L83:
        r23 = 0;
    L95:
        r1.put("code", 1);
        LinkedHashMap r41 = new LinkedHashMap();
        r41.put("err_message", "can't find view");
        Unit r42 = Unit.INSTANCE;
        r1.put("data", r41);
        goto L96
    L30:
        if (r8 == null) goto L38;
        if (r16 == null) goto L33;
        BaseViewHolder r43 = r16.e(r6, r8);
    L34:
        if (r43 == null) goto L36;
        View r44 = ((RecyclerView.ViewHolder) r43).itemView;
    L37:
        Pair r45 = TuplesKt.to(r43, r44);
    L47:
        qj.b r46 = (BaseViewHolder) r45.component1();
        r17 = (View) r45.component2();
        if (r13.length() <= 0) goto L50;
        boolean r47 = true;
    L51:
        if (r47 == false) goto L56;
        if ((r46 instanceof ECLynxCardHolder) == false) goto L56;
        r17 = r46.k4(r13);
    L56:
        if (r13.length() <= 0) goto L58;
        boolean r48 = true;
    L59:
        if (r48 == false) goto L64;
        if ((r46 instanceof HeaderCardViewHolder) == false) goto L64;
        r17 = r46.k4(r13);
    L64:
        if (r13.length() <= 0) goto L66;
        boolean r49 = true;
    L67:
        if (r49 == false) goto L73;
        if ((r46 instanceof qj.b) == false) goto L73;
        r46.a();
        throw null;
    L66:
        r49 = false;
        goto L67
    L58:
        r48 = false;
        goto L59
    L50:
        r47 = false;
        goto L51
    L36:
        r44 = null;
        goto L37
    L33:
        r43 = null;
        goto L34
    L38:
        if (r10 == null) goto L46;
        if (r16 == null) goto L41;
        BaseViewHolder r50 = r16.g(r6, r10.intValue());
    L42:
        if (r50 == null) goto L44;
        View r51 = ((RecyclerView.ViewHolder) r50).itemView;
    L45:
        r45 = TuplesKt.to(r50, r51);
        goto L47
    L44:
        r51 = null;
        goto L45
    L41:
        r50 = null;
        goto L42
    L46:
        r45 = TuplesKt.to(null, null);
        goto L47
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r4, Map<String, ? extends Object> r5, IDLXBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r5.isEmpty() == false) goto L5;
        Map<String, ? extends Object> r7 = new LinkedHashMap();
        r7.put("code", 0);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("err_message", "params is empty");
        Unit r1 = Unit.INSTANCE;
        r7.put("data", r0);
    L6:
        Logger.d("ec.mallGetCardPosition", "获取卡片位置" + r7);
        r6.invoke(r7);
        a(r5, r7);
        return;
    L5:
        r7 = g(r5, r4);
        goto L6
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return qf3.e.f(this);
    }
}
