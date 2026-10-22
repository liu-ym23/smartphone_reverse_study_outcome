package com.bytedance.android.shopping.sku.common.function;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.core.gallery2.opt.GalleryViewerV2;
import com.bytedance.android.ec.core.gallery2.opt.ScrollTitleIndicator;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.data.SpecState;
import com.bytedance.android.shopping.sku.common.data.d;
import com.bytedance.android.shopping.sku.common.data.f;
import com.bytedance.android.shopping.sku.common.data.g;
import com.bytedance.android.shopping.sku.common.data.h;
import com.bytedance.android.shopping.sku.common.data.i;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonOnceInTimeHelper;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonPreviewImgFunction {
    public final SkuCommonOnceInTimeHelper a;
    public final com.bytedance.android.ec.core.async.b b;
    public final Activity c;
    public final com.bytedance.android.ec.core.gallery2.opt.b d;
    public final AndroidYaTaInstance e;
    public final e f;
    public final View g;
    public final Function1<Integer, Unit> h;
    public final com.bytedance.android.shopping.sku.common.ability.b i;

    public final void a() {
        SkuCommonLog.c("SkuCommonPreviewImgFunction", "doAction");
        int r0 = g.a;
        List r1 = this.e.p("specs");
        if (r1 == null) goto L8;
        c r2 = (c) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L8;
        Map r3 = r2.s();
        if (r3 == null) goto L8;
    L9:
        h r4 = g.a(r3);
        final Map<String, i> r10 = r4.f();
        Map<String, SpecState> r5 = r4.h();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        Object r6 = null;
        r11.element = null;
        SpecState r7 = r5.get("0");
        if (r7 == null) goto L14;
        String r8 = r7.getSelectedSpecItemId();
        if (r8 == null) goto L14;
        r11.element = r8;
    L14:
        int r9 = f.a;
        AndroidYaTaInstance r12 = this.e;
        Intrinsics.checkNotNullParameter(r12, "yataInstance");
        final ArrayList r13 = new ArrayList();
        Object r14 = r12.i("preview_img_list");
        if ((r14 instanceof List) == true) goto L17;
        r14 = null;
    L17:
        List r15 = (List) r14;
        if (r15 == null) goto L69;
        Iterator r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L69;
        Object r17 = r16.next();
        boolean r18 = r17 instanceof Map;
        if (r18 == true) goto L25;
        Object r19 = null;
    L26:
        Map r20 = (Map) r19;
        if (r20 == null) goto L29;
        Object r21 = r20.get("img");
    L31:
        if ((r21 instanceof Map) == true) goto L33;
        r21 = null;
    L33:
        Map r22 = (Map) r21;
        if (r22 == null) goto L36;
        Object r23 = r22.get("url");
    L38:
        if ((r23 instanceof String) == true) goto L40;
        r23 = null;
    L40:
        String r24 = (String) r23;
        if (r18 == true) goto L43;
        Object r25 = null;
    L44:
        Map r26 = (Map) r25;
        if (r26 == null) goto L47;
        Object r27 = r26.get("spec_name");
    L49:
        if ((r27 instanceof String) == true) goto L51;
        r27 = null;
    L51:
        String r28 = (String) r27;
        if (r18 == true) goto L54;
        r17 = null;
    L54:
        Map r29 = (Map) r17;
        if (r29 == null) goto L57;
        Object r30 = r29.get("spec_item_id");
    L59:
        if ((r30 instanceof String) == true) goto L61;
        r30 = null;
    L61:
        String r31 = (String) r30;
        if (r24 != null) goto L64;
        r24 = "";
    L64:
        if (r28 != null) goto L66;
        r28 = "";
    L66:
        if (r31 != null) goto L68;
        r31 = "";
    L68:
        r13.add(new d(r24, r28, r31));
        goto L21
    L57:
        r30 = null;
        goto L59
    L47:
        r27 = null;
        goto L49
    L43:
        r25 = r17;
        goto L44
    L36:
        r23 = null;
        goto L38
    L29:
        r21 = null;
        goto L31
    L25:
        r19 = r17;
    L69:
        Object r32 = this.f.d().get("cur_pic_spec_item_id");
        if ((r32 instanceof String) == true) goto L72;
        r32 = null;
    L72:
        String r33 = (String) r32;
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = (String) r11.element;
        Iterator r34 = r13.iterator();
        int r35 = 0;
    L74:
        if (r34.hasNext() == false) goto L79;
        if (Intrinsics.areEqual(((d) r34.next()).c, r33) == true) goto L80;
        r35 = r35 + 1;
    L80:
        Integer r36 = Integer.valueOf(r35);
        if (r36.intValue() < 0) goto L83;
        boolean r37 = true;
    L84:
        if (r37 == true) goto L87;
        r36 = null;
    L87:
        if (r36 == null) goto L89;
        int r111 = r36.intValue();
    L90:
        Object r38 = this.f.p(Reflection.getOrCreateKotlinClass(String.class), "next_trigger");
        if ((r38 instanceof String) == true) goto L93;
        r38 = null;
    L93:
        final String r112 = (String) r38;
        Object r39 = this.f.p(Reflection.getOrCreateKotlinClass(String.class), "render_node_key");
        if ((r39 instanceof String) == true) goto L96;
        r39 = null;
    L96:
        final String r113 = (String) r39;
        Activity r40 = this.c;
        com.bytedance.android.ec.core.gallery2.opt.b r41 = this.d;
        Object r42 = this.f.p(Reflection.getOrCreateKotlinClass(Boolean.class), "show_detail_entrance");
        if ((r42 instanceof Boolean) == true) goto L99;
        r42 = null;
    L99:
        boolean r43 = k.i((Boolean) r42);
        Object r44 = this.f.p(Reflection.getOrCreateKotlinClass(String.class), "main_img_url");
        if ((r44 instanceof String) == false) goto L103;
        r6 = r44;
    L103:
        final GalleryViewerV2 r45 = new GalleryViewerV2(r40, r41, r43, (String) r6, 8);
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r47 = r13.iterator();
    L105:
        if (r47.hasNext() == false) goto L107;
        d r48 = (d) r47.next();
        com.bytedance.android.ec.model.k r49 = new com.bytedance.android.ec.model.k();
        r49.b = r48.a;
        r46.add(r49);
        goto L105
    L107:
        r45.a(r46);
        ScrollTitleIndicator r50 = r45.b;
        ArrayList r51 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r52 = r13.iterator();
    L109:
        if (r52.hasNext() == false) goto L111;
        r51.add(((d) r52.next()).b);
        goto L109
    L111:
        r50.setData(r51);
        r45.a.setOnClickDetailButton(new SkuCommonPreviewImgFunction$doAction$$inlined$apply$lambda$1(r45, this, r13, r10, r11, r110, r113, r112));
        r45.setOnPageSelectedListener(new SkuCommonPreviewImgFunction$doAction$$inlined$apply$lambda$2(this, r13, r10, r11, r110, r113, r112));
        r45.show(r111);
        return;
    L89:
        r111 = 0;
        goto L90
    L83:
        r37 = false;
        goto L84
    L79:
        r35 = -1;
    L8:
        r3 = MapsKt.emptyMap();
        goto L9
    }

    public SkuCommonPreviewImgFunction(com.bytedance.android.ec.core.async.b r2, Activity r3, com.bytedance.android.ec.core.gallery2.opt.b r4, AndroidYaTaInstance r5, com.bytedance.kmp.ec.yata.event.core.a r6, View r7, Function1 r8, com.bytedance.android.shopping.sku.common.ability.b r9) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "galleryAbilityProvider");
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "anchorView");
        Intrinsics.checkNotNullParameter(r8, "onPageSelectedListener");
        Intrinsics.checkNotNullParameter(r9, "skuService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.a = new SkuCommonOnceInTimeHelper(r2, 1000);
    }
}
