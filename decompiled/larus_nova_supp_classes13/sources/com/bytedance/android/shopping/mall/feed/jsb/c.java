package com.bytedance.android.shopping.mall.feed.jsb;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public c(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall_card_visible";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r17, IBDXBridgeContext r18, Map<String, ? extends Object> r19, Map<String, Object> r20) {
        Intrinsics.checkNotNullParameter(r17, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "result");
        Object r1 = r19.get("checkCards");
        if ((r1 instanceof List) == true) goto L5;
        r1 = null;
    L5:
        List r2 = (List) r1;
        LinkedHashMap r4 = new LinkedHashMap();
        if (r2 == null) goto L144;
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L144;
        Map r6 = (Map) r3.next();
        Object r8 = r6.get("itemId");
        if ((r8 instanceof String) == true) goto L13;
        r8 = null;
    L13:
        String r9 = (String) r8;
        String r10 = "";
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        Object r11 = r6.get("type");
        if ((r11 instanceof String) == true) goto L19;
        r11 = null;
    L19:
        String r12 = (String) r11;
        if (r12 == null) goto L23;
        r10 = r12;
    L23:
        int r13 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Object r7 = r6.get("offset");
        if ((r7 instanceof Integer) == true) goto L26;
        r7 = null;
    L26:
        Integer r14 = (Integer) r7;
        int r15 = 0;
        if (r14 == null) goto L29;
        int r16 = r14.intValue();
    L30:
        int r21 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r16));
        if (Intrinsics.areEqual(r9, "host") == true) goto L32;
        ECMallFeed r110 = r17.b;
        float r22 = r21;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r9, "itemId");
        ECHybridListEngine r23 = r110.J;
        if (r23 == null) goto L78;
        BaseViewHolder r24 = r23.f(null, r9);
    L80:
        if (r24 == null) goto L82;
    L84:
        if (r24 != null) goto L86;
        Boolean r25 = Boolean.FALSE;
    L134:
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L137;
        r15 = 1;
    L141:
        r4.put(r9, Integer.valueOf(r15));
        goto L9
    L137:
        if (Intrinsics.areEqual(r25, Boolean.FALSE) == true) goto L141;
        if (r25 != null) goto L143;
        r15 = -1;
        goto L141
    L143:
        throw new NoWhenBranchMatchedException();
    L86:
        ViewParent r111 = ((RecyclerView.ViewHolder) r24).itemView.getParent();
        if ((r111 instanceof RecyclerView) == true) goto L89;
        r111 = null;
    L89:
        RecyclerView r112 = (RecyclerView) r111;
        if (r112 == null) goto L160;
        int r113 = r110.k();
        switch(r10.hashCode()) {
            case -1901805651: goto L123;
            case -793888825: goto L114;
            case -327053987: goto L105;
            case 466743410: goto L96;
            default: goto L161;
        };
    L161:
        r25 = null;
        goto L134
    L96:
        if (r10.equals("visible") == true) goto L98;
        r25 = null;
        goto L134
    L98:
        if ((((RecyclerView.ViewHolder) r24).itemView.getTop() + r22) >= r113) goto L100;
    L102:
        boolean r26 = false;
    L103:
        r25 = Boolean.valueOf(r26);
        goto L134
    L100:
        if (((RecyclerView.ViewHolder) r24).itemView.getBottom() >= r112.getHeight()) goto L102;
        r26 = true;
        goto L103
    L105:
        if (r10.equals("topVisible") == true) goto L107;
        r25 = null;
        goto L134
    L107:
        if ((((RecyclerView.ViewHolder) r24).itemView.getTop() + r22) > r113) goto L109;
    L111:
        boolean r27 = false;
    L112:
        r25 = Boolean.valueOf(r27);
        goto L134
    L109:
        if ((((RecyclerView.ViewHolder) r24).itemView.getTop() + r22) >= r112.getHeight()) goto L111;
        r27 = true;
        goto L112
    L114:
        if (r10.equals("bottomVisible") == true) goto L116;
        r25 = null;
        goto L134
    L116:
        if (((RecyclerView.ViewHolder) r24).itemView.getBottom() > r113) goto L118;
    L120:
        boolean r28 = false;
    L121:
        r25 = Boolean.valueOf(r28);
        goto L134
    L118:
        if (((RecyclerView.ViewHolder) r24).itemView.getBottom() >= r112.getHeight()) goto L120;
        r28 = true;
        goto L121
    L123:
        if (r10.equals("invisible") == true) goto L125;
        r25 = null;
        goto L134
    L125:
        if (((RecyclerView.ViewHolder) r24).itemView.getBottom() >= r113) goto L127;
    L130:
        boolean r29 = true;
    L131:
        r25 = Boolean.valueOf(r29);
        goto L134
    L127:
        if ((((RecyclerView.ViewHolder) r24).itemView.getTop() + r22) > r112.getHeight()) goto L130;
        r29 = false;
        goto L131
    L160:
        r25 = null;
        goto L134
    L82:
        if (Intrinsics.areEqual(r10, "invisible") == false) goto L84;
        r25 = Boolean.TRUE;
        goto L134
    L78:
        r24 = null;
        goto L80
    L32:
        ECMallFeed r30 = r17.b;
        float r31 = r21;
        ECHybridListEngine r32 = r30.J;
        if (r32 == null) goto L74;
        int r33 = r32.b.getChildCount();
        int r114 = 0;
    L35:
        if (r114 >= r33) goto L45;
        View r115 = r32.b.getChildAt(r114);
        if (r115 == null) goto L44;
        RecyclerView.ViewHolder r116 = r32.b.getChildViewHolder(r115);
        if ((r116 instanceof BaseViewHolder) == true) goto L41;
        r116 = null;
    L41:
        BaseViewHolder r117 = (BaseViewHolder) r116;
        if (r117 == null) goto L44;
    L46:
        if (r117 == null) goto L74;
        int r34 = r117.getAdapterPosition();
        if (r31 != 0.0f) goto L65;
        if (r34 <= 0) goto L65;
        ECHybridListEngine r35 = r30.J;
        if (r35 == null) goto L65;
        ECHybridRecyclerView r36 = r35.b;
        if (r36 == null) goto L65;
        BaseViewHolder r37 = r36.findViewHolderForAdapterPosition(r34 - 1);
        if (r37 == null) goto L65;
        if ((r37 instanceof BaseViewHolder) == false) goto L65;
        ECHybridListItemVO r38 = r37.c;
        if (r38 == null) goto L61;
        String r39 = r38.r;
    L63:
        if (Intrinsics.areEqual(r39, "favorite_section") == false) goto L65;
    L73:
        r15 = 1;
        goto L74
    L61:
        r39 = null;
    L65:
        ECHybridListItemVO r40 = r117.c;
        if (r40 == null) goto L68;
        String r41 = r40.r;
    L70:
        if (Intrinsics.areEqual(r41, "favorite_section") == false) goto L74;
        if ((((RecyclerView.ViewHolder) r117).itemView.getY() + r31) >= r30.k()) goto L74;
    L68:
        r41 = null;
    L44:
        r114 = r114 + 1;
        goto L35
    L45:
        r117 = null;
    L74:
        r4.put("host", Integer.valueOf(r15));
        goto L9
    L29:
        r16 = 0;
    L144:
        r20.put("result", r4);
        return qf3.e.f(this);
    }
}
