package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ShopSlcCardFactory {
    public final SlcRenderContext a;

    public ShopSlcCardFactory(SlcRenderContext r1) {
        this.a = r1;
    }

    public r b(SliceItemType r5) {
        Intrinsics.checkNotNullParameter(r5, "itemType");
        boolean r0 = true;
        r r6 = f(ShopSlcTemplateManager.a(r5, 1));
        if (r6 != null) goto L9;
        dm.a.b r1 = dm.a.a("ShopSlcProductCardFactory");
        StringBuilder r2 = new StringBuilder("createDoubleCard, viewInfo is null, context is null = ");
        if (this.a == null) goto L8;
        r0 = false;
    L8:
        r2.append(r0);
        r1.b(r2.toString(), null);
    L9:
        return r6;
    }

    public final r c(final String r2) {
        return d("createHeaderCard", new ShopSlcCardFactory$createHeaderCard$1(r2));
    }

    public r e(SliceItemType r4) {
        Intrinsics.checkNotNullParameter(r4, "itemType");
        r r5 = f(ShopSlcTemplateManager.a(r4, 2));
        if (r5 != null) goto L9;
        dm.a.b r0 = dm.a.a("ShopSlcProductCardFactory");
        StringBuilder r1 = new StringBuilder("createSingleCard, viewInfo is null, context is null = ");
        if (this.a != null) goto L7;
        boolean r2 = true;
    L8:
        r1.append(r2);
        r0.b(r1.toString(), null);
        goto L9
    L7:
        r2 = false;
    L9:
        return r5;
    }

    public final r f(SliceTemplate r7) {
        if (r7 == null) goto L8;
        String r0 = r7.getContent();
        if (r0 == null) goto L8;
        r r1 = i(r0, r7);
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (r7 == null) goto L10;
        String r2 = r7.getUrl();
    L11:
        if (r7 == null) goto L13;
        String r3 = r7.getName();
    L14:
        if (r7 == null) goto L16;
        String r8 = r7.getVersion();
    L17:
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        boolean r4 = false;
        if (r2 != null) goto L22;
    L25:
        boolean r5 = true;
    L26:
        if (r5 == true) goto L35;
        if (r3 != null) goto L29;
    L30:
        r4 = true;
    L31:
        if (r4 == false) goto L33;
        return null;
    L33:
        return h(r2, r3, r8);
    L29:
        if (r3.length() != 0) goto L31;
    L35:
        return null;
    L22:
        if (r2.length() == 0) goto L25;
        r5 = false;
        goto L26
    L16:
        r8 = null;
        goto L17
    L13:
        r3 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    }

    public final r g(final String r2) {
        return d("createTopInfoCard", new ShopSlcCardFactory$createTopInfoCard$1(r2));
    }

    public final r a(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "itemType");
        com.bytedance.android.ec.store.setting.j r1 = ShopSlcTemplateManager.a;
        Intrinsics.checkNotNullParameter(r8, "itemType");
        boolean r2 = false;
        if (ECShopABSettings.getEC_SHOP_CARD_PACK_FORCE_LOCAL() != 1) goto L46;
        ShopSliceItemConfig r0 = ShopSlcTemplateManager.i.get(r8);
        if (r0 == null) goto L20;
        Iterator<T> r3 = r0.getTemplates().iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        Integer r5 = ((SliceTemplate) r4).getSpanSize();
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L8;
    L19:
        SliceTemplate r7 = (SliceTemplate) r4;
    L21:
        SliceTemplate r10 = new SliceTemplate();
        if (r7 == null) goto L24;
        String r11 = r7.getName();
    L25:
        r10.setName(r11);
        if (r7 == null) goto L28;
        String r12 = r7.getUrl();
    L29:
        r10.setUrl(r12);
        if (r7 == null) goto L32;
        String r13 = r7.getVersion();
    L33:
        r10.setVersion(r13);
        if (r7 == null) goto L36;
        int r14 = r7.getType();
    L37:
        r10.setType(r14);
        if (r7 == null) goto L40;
        Integer r15 = r7.getSpanSize();
    L41:
        r10.setSpanSize(r15);
        if (r7 == null) goto L44;
        double r16 = r7.getPredictHeight();
    L45:
        r10.setPredictHeight(r16);
    L64:
        SliceTemplate r17 = r10;
    L66:
        r r18 = f(r17);
        if (r18 != null) goto L72;
        dm.a.b r19 = dm.a.a("ShopSlcProductCardFactory");
        StringBuilder r20 = new StringBuilder("createCommonCard:");
        r20.append(r8);
        r20.append(", viewInfo is null, context is null = ");
        if (this.a != null) goto L71;
        r2 = true;
    L71:
        r20.append(r2);
        r19.b(r20.toString(), null);
    L72:
        return r18;
    L44:
        r16 = 0.0d;
        goto L45
    L40:
        r15 = null;
        goto L41
    L36:
        r14 = SliceTemplateType.GECKO.getType();
        goto L37
    L32:
        r13 = null;
        goto L33
    L28:
        r12 = null;
        goto L29
    L24:
        r11 = null;
        goto L25
    L13:
        if (r5.intValue() != r9) goto L15;
        r6 = true;
        goto L16
    L18:
        r4 = null;
        goto L19
    L20:
        r7 = null;
        goto L21
    L46:
        ShopSliceItemConfig r21 = ShopSlcTemplateManager.i.get(r8);
        if (r21 == null) goto L65;
        Iterator<T> r22 = r21.getTemplates().iterator();
    L50:
        if (r22.hasNext() == false) goto L60;
        Object r23 = r22.next();
        Integer r24 = ((SliceTemplate) r23).getSpanSize();
        if (r24 != null) goto L55;
    L57:
        boolean r25 = false;
    L58:
        if (r25 == false) goto L50;
    L61:
        r17 = (SliceTemplate) r23;
        if (r17 != null) goto L66;
        r10 = (SliceTemplate) CollectionsKt.firstOrNull(r21.getTemplates());
        goto L64
    L55:
        if (r24.intValue() != r9) goto L57;
        r25 = true;
        goto L58
    L60:
        r23 = null;
        goto L61
    L65:
        r17 = null;
        goto L66
    }

    public final r d(String r3, Function0<SliceTemplate> r4) {
        r r5 = f((SliceTemplate) r4.invoke());
        if (r5 != null) goto L9;
        dm.a.b r0 = dm.a.a("ShopSlcProductCardFactory");
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        r1.append(", viewInfo is null, context is null = ");
        if (this.a != null) goto L7;
        boolean r6 = true;
    L8:
        r1.append(r6);
        r0.b(r1.toString(), null);
        goto L9
    L7:
        r6 = false;
    L9:
        return r5;
    }

    public final r i(String r10, SliceTemplate r11) {
        Intrinsics.checkNotNullParameter(r10, "templateJson");
        Intrinsics.checkNotNullParameter(r11, "templateInfo");
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L17;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        int r3 = t0.a;     // Catch: Throwable -> L6
        Object r12 = Result.constructor-impl((SlcElement) t0.a.b.fromJson(r10, SlcElement.class));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r12) == false) goto L11;
        r12 = null;
    L11:
        SlcElement r13 = (SlcElement) r12;
        r11.setSlcElement(r13);
        if (r13 == null) goto L18;
        SliceRender r1 = SliceRender.o;
        p r8 = new p(r11.getUrl(), r11.getName(), String.valueOf(r11.getVersion()), null, 120);
        r1.getClass();
        r.d.getClass();
        return r.a.a(r0, r13, r8);
    L18:
        return null;
    L6:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L17:
        return null;
    }

    public final r h(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "version");
        com.bytedance.android.ecom.arch.slice.render.i r0 = new com.bytedance.android.ecom.arch.slice.render.i(r2, r3, r4);
        SlcRenderContext r5 = this.a;
        if (r5 == null) goto L6;
        KProperty[] r6 = SlcRenderContext.n0;
        return r5.c(r0, null);
    L6:
        return null;
    }
}
