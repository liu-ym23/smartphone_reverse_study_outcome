package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RightTagEventParam;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d2 {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ ql.a a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(ql.a r1, com.bytedance.android.ec.common.api.jump.model.a r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            int r0 = d2.a;
            ql.a r1 = this.a;
            com.bytedance.android.ec.common.api.jump.model.a r7 = this.b;
            String r8 = this.c;
            String r9 = this.d;
            String r10 = this.e;
            Map r2 = r1.getRitTag();
            if (r2 == null) goto L15;
            Iterator r11 = r2.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L15;
            Map.Entry r3 = (Map.Entry) r11.next();
            String r4 = (String) r3.getKey();
            Iterator r12 = ((List) r3.getValue()).iterator();
        L9:
            if (r12.hasNext() == false) goto L6;
            RitTagTrack r5 = ((ECRitTag) r12.next()).getTagTrack();
            if (r5 == null) goto L9;
            if (r5.getVisibile() == false) goto L9;
            d2.d(r7, r8, r5, r1, r9, r10);
        L15:
            List r6 = r1.getBenefitLabels();
            if (r6 == null) goto L25;
            Iterator r13 = r6.iterator();
        L19:
            if (r13.hasNext() == false) goto L25;
            RitTagTrack r14 = ((PromotionBenefitLabel) r13.next()).getTagTrack();
            if (r14 == null) goto L19;
            if (r14.getVisibile() == false) goto L19;
            d2.d(r7, r8, r14, r1, r9, r10);
        L25:
            RitTagTrack r15 = r1.getUpIconTagTrack();
            if (r15 != null) goto L28;
        L30:
            ECCurrentPromotion.PopBackground r16 = r1.getBackground();
            if (r16 == null) goto L53;
            RitTagTrack r17 = r16.tagTrack;
            if (r17 != null) goto L35;
            return;
        L35:
            if (r17.getVisibile() == false) goto L55;
            d2.d(r7, r8, r17, r1, r9, r10);
            return;
        L55:
            return;
        L53:
            return;
        L28:
            if (r15.getVisibile() == false) goto L30;
            d2.d(r7, r8, r15, r1, r9, r10);
            goto L30
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ RitTagTrack c;
        public final /* synthetic */ ql.a d;
        public final /* synthetic */ rh2.b e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public b(com.bytedance.android.ec.common.api.jump.model.a r1, String r2, RitTagTrack r3, ql.a r4, rh2.b r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("product_tag_show", this.a);
            r0.c("tag_show_scene", "live");
            r0.c("tag_show_page_position", this.b);
            RightTagEventParam r1 = this.c.getEventParam();
            String r2 = "";
            if (r1 == null) goto L6;
            String r3 = r1.getProductTag();
            if (r3 == null) goto L6;
        L7:
            r0.c("product_tag", r3);
            ql.a r4 = this.d;
            if (r4 == null) goto L11;
            String r5 = r4.getProductId();
            if (r5 == null) goto L11;
        L12:
            r0.c("product_id", r5);
            RightTagEventParam r6 = this.c.getEventParam();
            if (r6 == null) goto L18;
            String r7 = r6.getProductTagText();
            if (r7 == null) goto L18;
            r2 = r7;
        L18:
            r0.c("product_tag_text", r2);
            if (this.e == null) goto L21;
            String r8 = "1";
        L22:
            r0.c("is_ecom_new", r8);
            r0.j(this.f, this.g);
            return;
        L21:
            r8 = BDLocationException.ERROR_TIMEOUT;
        L11:
            r5 = "";
        L6:
            r3 = "";
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static Pair a(ql.a r10) {
        Intrinsics.checkNotNullParameter(r10, "promotion");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Map r2 = r10.getRitTag();
        if (r2 == null) goto L13;
        Iterator r3 = r2.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r3.next();
        String r5 = (String) r4.getKey();
        Iterator r6 = ((List) r4.getValue()).iterator();
    L9:
        if (r6.hasNext() == false) goto L6;
        RitTagTrack r7 = ((ECRitTag) r6.next()).getTagTrack();
        if (r7 == null) goto L9;
        b(r7, r0, r1);
    L13:
        List r8 = r10.getBenefitLabels();
        if (r8 == null) goto L21;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L21;
        RitTagTrack r11 = ((PromotionBenefitLabel) r9.next()).getTagTrack();
        if (r11 == null) goto L17;
        b(r11, r0, r1);
    L21:
        RitTagTrack r12 = r10.getUpIconTagTrack();
        if (r12 == null) goto L24;
        b(r12, r0, r1);
    L24:
        ECCurrentPromotion.PopBackground r13 = r10.getBackground();
        if (r13 == null) goto L30;
        RitTagTrack r14 = r13.tagTrack;
        if (r14 == null) goto L30;
        b(r14, r0, r1);
    L30:
        if ((r10 instanceof ECUIPromotionV2) == false) goto L53;
        Map r15 = r10.getEventParams();
        if (r15 == null) goto L53;
        String r16 = (String) r15.get("tag_code_list");
        if (r16 == null) goto L53;
        String r17 = StringsKt.removeSurrounding(r16, "[", "]");
        if (r17 == null) goto L53;
        List r18 = StringsKt.split$default(r17, new String[]{","}, false, 0, 6, null);
        if (r18 == null) goto L53;
        ArrayList r19 = new ArrayList();
        Iterator r110 = r18.iterator();
    L41:
        if (r110.hasNext() == false) goto L48;
        Object r20 = r110.next();
        if (((String) r20).length() <= 0) goto L45;
        boolean r21 = true;
    L46:
        if (r21 == false) goto L41;
        r19.add(r20);
        goto L41
    L45:
        r21 = false;
        goto L46
    L48:
        Iterator r111 = r19.iterator();
    L50:
        if (r111.hasNext() == false) goto L53;
        r0.add((String) r111.next());
    L53:
        return new Pair(r0, r1);
    }

    public static void b(RitTagTrack r1, ArrayList r2, ArrayList r3) {
        if (r1.getVisibile() == false) goto L13;
        String r0 = r1.getTagCode();
        if (r0 == null) goto L14;
        r2.add(r0);
        RightTagEventParam r4 = r1.getEventParam();
        if (r4 == null) goto L10;
        String r5 = r4.getProductTagText();
        if (r5 == null) goto L10;
    L11:
        r3.add(r0 + ':' + r5);
        return;
    L10:
        r5 = "";
        goto L11
    L14:
        return;
    }

    public static void c(ql.a r7, com.bytedance.android.ec.common.api.jump.model.a r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "promotion");
        Intrinsics.checkNotNullParameter(r8, "promotionParams");
        Intrinsics.checkNotNullParameter(r9, "tagShowPagePosition");
        oh.a.c("reportPromotionProductTagShow", new a(r7, r8, r9, r10, r11));
    }

    public static void d(com.bytedance.android.ec.common.api.jump.model.a r9, String r10, RitTagTrack r11, ql.a r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        Intrinsics.checkNotNullParameter(r10, "tagShowPagePosition");
        Intrinsics.checkNotNullParameter(r11, "tagTrack");
        oh.a.c("sendProductTagShowEvent", new b(r9, r10, r11, r12, (rh2.b) r9.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class)), r13, r14));
    }
}
