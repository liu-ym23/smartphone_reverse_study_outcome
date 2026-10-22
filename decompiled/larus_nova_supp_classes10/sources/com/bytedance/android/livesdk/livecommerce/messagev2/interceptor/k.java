package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.response.ActionType;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a {
    public static final /* synthetic */ int e = 0;

    public static final class a {
        public static ECPromotionInterationData a(ECV2InteractionData.InteractionContent r15) {
            Intrinsics.checkNotNullParameter(r15, "item");
            List<ECV2InteractionData.InteractionElement> r0 = r15.content;
            String r2 = null;
            if (r0 == null) goto L9;
            List<ECV2InteractionData.InteractionElement> r1 = r0;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r4 = r1.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            ECV2InteractionData.InteractionElement r5 = (ECV2InteractionData.InteractionElement) r4.next();
            int r6 = k.e;
            r3.add(b(r5));
            goto L6
        L8:
            ArrayList r8 = r3;
        L10:
            ECV2InteractionData.InteractionContentCheck r7 = r15.check;
            if (r7 == null) goto L13;
            com.bytedance.android.ec.model.live.m r9 = new com.bytedance.android.ec.model.live.m(r7.product_id, r7.index);
        L14:
            Map<String, String> r10 = r15.eventParam;
            ECV2InteractionData.MessageProduct r11 = r15.product;
            if (r11 == null) goto L28;
            ECUrlModel r12 = new ECUrlModel();
            ECV2InteractionData.ProductCover r13 = r11.cover;
            if (r13 == null) goto L19;
            List<String> r14 = r13.urlList;
        L20:
            r12.setUrlList(r14);
            ECV2InteractionData.ProductCover r16 = r11.cover;
            int r17 = 0;
            if (r16 == null) goto L23;
            int r18 = r16.width;
        L24:
            r12.setWidth(r18);
            ECV2InteractionData.ProductCover r19 = r11.cover;
            if (r19 == null) goto L27;
            r17 = r19.height;
        L27:
            r12.setHeight(r17);
            com.bytedance.android.ec.model.live.n r110 = new com.bytedance.android.ec.model.live.n(r12, r11.showIndex, r11.index);
        L29:
            List<ECV2InteractionData.ListTopInteractionRow> r20 = r15.rows;
            if (r20 == null) goto L43;
            List<ECV2InteractionData.ListTopInteractionRow> r21 = r20;
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r23 = r21.iterator();
        L33:
            if (r23.hasNext() == false) goto L42;
            List<ECV2InteractionData.InteractionElement> r24 = ((ECV2InteractionData.ListTopInteractionRow) r23.next()).content;
            if (r24 == null) goto L40;
            List<ECV2InteractionData.InteractionElement> r25 = r24;
            ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
            Iterator<T> r27 = r25.iterator();
        L38:
            if (r27.hasNext() == false) goto L41;
            ECV2InteractionData.InteractionElement r28 = (ECV2InteractionData.InteractionElement) r27.next();
            int r29 = k.e;
            r26.add(b(r28));
        L41:
            r22.add(new com.bytedance.android.ec.model.live.o(r26));
            goto L33
        L40:
            r26 = null;
            goto L41
        L42:
            ArrayList r111 = r22;
        L44:
            ECV2InteractionData.ListAction r30 = r15.action;
            if (r30 == null) goto L53;
            ActionType r31 = ActionType.Biz;
            ECV2InteractionData.BizActionMeta r32 = r30.bizAction;
            if (r32 == null) goto L49;
            String r33 = r32.actionName;
        L50:
            if (r32 == null) goto L52;
            r2 = r32.actionParam;
        L52:
            j0 r112 = new j0(r31, new com.bytedance.android.ec.model.response.c(r33, r2), 12);
        L55:
            return new ECPromotionInterationData(r15.priority, r15.loopCount, r8, r9, r10, r110, r111, r112, r15.bgColors);
        L49:
            r33 = null;
            goto L50
        L53:
            r112 = null;
            goto L55
        L43:
            r111 = null;
            goto L44
        L23:
            r18 = 0;
            goto L24
        L19:
            r14 = null;
            goto L20
        L28:
            r110 = null;
            goto L29
        L13:
            r9 = null;
            goto L14
        L9:
            r8 = null;
            goto L10
        }

        public static com.bytedance.android.ec.model.live.b b(ECV2InteractionData.InteractionElement r35) {
            ECUrlModel r5 = new ECUrlModel();
            ECV2InteractionData.InteractionAvatar r1 = r35.avatars;
            if (r1 == null) goto L5;
            List<String> r2 = r1.urlList;
        L6:
            r5.setUrlList(r2);
            ECV2InteractionData.InteractionAvatar r3 = r35.avatars;
            if (r3 == null) goto L9;
            int r4 = r3.width;
        L10:
            r5.setWidth(r4);
            ECV2InteractionData.InteractionAvatar r6 = r35.avatars;
            if (r6 == null) goto L13;
            int r7 = r6.width;
        L14:
            r5.setHeight(r7);
            int r8 = r35.elementType;
            String r9 = r35.text;
            String r10 = r35.textColor;
            Integer r11 = r35.textSize;
            if (r11 == null) goto L17;
            int r12 = r11.intValue();
        L18:
            int r13 = r35.blankWidth;
            ECV2InteractionData.ElementText r14 = r35.elementTextV2;
            if (r14 == null) goto L21;
            String r15 = r14.text;
        L22:
            if (r14 == null) goto L24;
            String r16 = r14.color;
        L25:
            if (r14 == null) goto L29;
            Long r17 = r14.size;
            if (r17 == null) goto L29;
            Integer r18 = Integer.valueOf((int) r17.longValue());
        L30:
            ECV2InteractionData.ElementText r19 = r35.elementTextV2;
            if (r19 == null) goto L33;
            boolean r110 = r19.bold;
        L34:
            if (r19 != null) goto L36;
        L56:
            ECUrlModel r111 = null;
        L57:
            ECV2InteractionData.ElementText r20 = r35.elementTextV2;
            if (r20 == null) goto L60;
            long r112 = r20.maxWidth;
        L61:
            long r113 = r112;
            if (r20 == null) goto L64;
            boolean r114 = r20.ellipsis;
        L65:
            com.bytedance.android.ec.model.live.l r21 = new com.bytedance.android.ec.model.live.l(r15, r16, r18, r110, r111, r113, r114, 896);
            ECV2InteractionData.ElementBlank r115 = r35.elementBlank;
            if (r115 == null) goto L68;
            int r116 = r115.width;
        L69:
            com.bytedance.android.ec.model.live.d r117 = new com.bytedance.android.ec.model.live.d(r116);
            ECUrlModel r118 = new ECUrlModel();
            ECV2InteractionData.ElementAvatar r119 = r35.elementAvatar;
            if (r119 == null) goto L74;
            ECV2InteractionData.UrlImage r120 = r119.image;
            if (r120 == null) goto L74;
            List<String> r121 = r120.urlList;
        L75:
            r118.setUrlList(r121);
            ECV2InteractionData.ElementAvatar r122 = r35.elementAvatar;
            if (r122 == null) goto L80;
            ECV2InteractionData.UrlImage r123 = r122.image;
            if (r123 == null) goto L80;
            int r124 = r123.width;
        L81:
            r118.setWidth(r124);
            ECV2InteractionData.ElementAvatar r125 = r35.elementAvatar;
            if (r125 == null) goto L86;
            ECV2InteractionData.UrlImage r126 = r125.image;
            if (r126 == null) goto L86;
            int r127 = r126.width;
        L87:
            r118.setHeight(r127);
            Unit r128 = Unit.INSTANCE;
            com.bytedance.android.ec.model.live.c r129 = new com.bytedance.android.ec.model.live.c(r118);
            ECUrlModel r130 = new ECUrlModel();
            ECV2InteractionData.ElementImage r131 = r35.elementImage;
            if (r131 == null) goto L92;
            ECV2InteractionData.UrlImage r132 = r131.image;
            if (r132 == null) goto L92;
            List<String> r133 = r132.urlList;
        L93:
            r130.setUrlList(r133);
            ECV2InteractionData.ElementImage r134 = r35.elementImage;
            if (r134 == null) goto L98;
            ECV2InteractionData.UrlImage r135 = r134.image;
            if (r135 == null) goto L98;
            int r136 = r135.width;
        L99:
            r130.setWidth(r136);
            ECV2InteractionData.ElementImage r137 = r35.elementImage;
            if (r137 == null) goto L104;
            ECV2InteractionData.UrlImage r138 = r137.image;
            if (r138 == null) goto L104;
            int r139 = r138.width;
        L105:
            r130.setHeight(r139);
            ECV2InteractionData.ElementImage r140 = r35.elementImage;
            if (r140 == null) goto L110;
            ECV2InteractionData.ElementImageBubble r141 = r140.bubble;
            if (r141 == null) goto L110;
            com.bytedance.android.ec.model.live.f r0 = new com.bytedance.android.ec.model.live.f(r141.height, r141.borderRadius, r141.backgroundColor, r141.borderColor, r141.text, r141.fontSize, r141.color, r141.horizontalPadding);
        L111:
            com.bytedance.android.ec.model.live.h r142 = new com.bytedance.android.ec.model.live.h(r130, 0, r0);
            ECV2InteractionData.ElementLoopText r22 = r35.elementLoopText;
            if (r22 == null) goto L114;
            List<String> r143 = r22.loopText;
        L115:
            if (r22 == null) goto L117;
            String r144 = r22.textColor;
        L118:
            if (r22 == null) goto L120;
            int r145 = r22.textSize;
        L121:
            if (r22 == null) goto L123;
            boolean r146 = r22.bold;
        L124:
            if (r22 == null) goto L126;
            long r23 = r22.animGap;
        L127:
            int r24 = r12;
            return new com.bytedance.android.ec.model.live.b(r8, r9, r10, r24, r5, r13, r21, r117, r129, r142, new com.bytedance.android.ec.model.live.i(r143, r144, r145, r146, r23), 987904);
        L126:
            r23 = 200;
            goto L127
        L123:
            r146 = false;
            goto L124
        L120:
            r145 = 12;
            goto L121
        L117:
            r144 = null;
            goto L118
        L114:
            r143 = null;
        L110:
            r0 = null;
        L104:
            r139 = 0;
        L98:
            r136 = 0;
        L92:
            r133 = null;
        L86:
            r127 = 0;
        L80:
            r124 = 0;
        L74:
            r121 = null;
            goto L75
        L68:
            r116 = 0;
            goto L69
        L64:
            r114 = false;
            goto L65
        L60:
            r112 = 0;
            goto L61
        L36:
            if (r19.image == null) goto L56;
            ECUrlModel r25 = new ECUrlModel();
            ECV2InteractionData.ElementText r147 = r35.elementTextV2;
            if (r147 == null) goto L42;
            ECV2InteractionData.UrlImage r148 = r147.image;
            if (r148 == null) goto L42;
            List<String> r149 = r148.urlList;
        L43:
            r25.setUrlList(r149);
            ECV2InteractionData.ElementText r150 = r35.elementTextV2;
            if (r150 == null) goto L48;
            ECV2InteractionData.UrlImage r151 = r150.image;
            if (r151 == null) goto L48;
            int r152 = r151.width;
        L49:
            r25.setWidth(r152);
            ECV2InteractionData.ElementText r153 = r35.elementTextV2;
            if (r153 == null) goto L54;
            ECV2InteractionData.UrlImage r154 = r153.image;
            if (r154 == null) goto L54;
            int r155 = r154.width;
        L55:
            r25.setHeight(r155);
            r111 = r25;
        L54:
            r155 = 0;
        L48:
            r152 = 0;
        L42:
            r149 = null;
            goto L43
        L33:
            r110 = false;
        L29:
            r18 = null;
            goto L30
        L24:
            r16 = null;
            goto L25
        L21:
            r15 = null;
            goto L22
        L17:
            r12 = -1;
            goto L18
        L13:
            r7 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public k() {
        super(true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof si2.y) == true) goto L5;
        return false;
    L5:
        si2.y r7 = (si2.y) r6;
        if (r7.msgType != 1) goto L20;
        ECV2InteractionData r0 = r7.interactionData;
        if (r0 == null) goto L19;
        List<ECV2InteractionData.InteractionContent> r1 = r0.contents;
        if (r1 == null) goto L15;
        List<ECV2InteractionData.InteractionContent> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L16;
        r3.add(a.a((ECV2InteractionData.InteractionContent) r4.next()));
    L16:
        lj2.a r8 = (lj2.a) b(lj2.a.class, r7);
        if (r8 == null) goto L19;
        r8.z(r0.full, r3);
        goto L19
    L15:
        r3 = null;
    L19:
        return true;
    L20:
        return false;
    }
}
