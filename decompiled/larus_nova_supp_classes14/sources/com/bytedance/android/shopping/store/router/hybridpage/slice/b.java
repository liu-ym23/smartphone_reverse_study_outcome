package com.bytedance.android.shopping.store.router.hybridpage.slice;

import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends ShopSlcCardFactory {
    public b(SlcRenderContext r1) {
        super(r1);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory
    public final r b(SliceItemType r7) {
        Intrinsics.checkNotNullParameter(r7, "itemType");
        List<k> r1 = HybridPageSlcTemplateManager.a;
        Intrinsics.checkNotNullParameter(r7, "itemType");
        boolean r0 = true;
        SliceTemplate r8 = HybridPageSlcTemplateManager.a(r7.getType(), 1);
        if (r8 == null) goto L8;
        String r3 = r8.getContent();
        if (r3 == null) goto L8;
        r r4 = i(r3, r8);
        if (r4 == null) goto L8;
    L35:
        if (r4 != null) goto L41;
        dm.a.b r9 = dm.a.a("HybridPageSlcProductCardFactory");
        StringBuilder r5 = new StringBuilder("createDoubleCard, viewInfo is null, context is null = ");
        if (this.a == null) goto L40;
        r0 = false;
    L40:
        r5.append(r0);
        r9.b(r5.toString(), null);
    L41:
        return r4;
    L8:
        if (r8 == null) goto L10;
        String r6 = r8.getUrl();
    L11:
        if (r8 == null) goto L13;
        String r10 = r8.getName();
    L14:
        if (r8 == null) goto L16;
        String r11 = r8.getVersion();
    L17:
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        if (r6 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L34;
        if (r10 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == true) goto L34;
        r4 = h(r6, r10, r11);
        goto L35
    L28:
        if (r10.length() == 0) goto L31;
        r13 = false;
    L34:
        r4 = null;
        goto L35
    L21:
        if (r6.length() == 0) goto L24;
        r12 = false;
        goto L25
    L16:
        r11 = null;
        goto L17
    L13:
        r10 = null;
        goto L14
    L10:
        r6 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory
    public final r e(SliceItemType r7) {
        Intrinsics.checkNotNullParameter(r7, "itemType");
        List<k> r1 = HybridPageSlcTemplateManager.a;
        Intrinsics.checkNotNullParameter(r7, "itemType");
        SliceTemplate r8 = HybridPageSlcTemplateManager.a(r7.getType(), 2);
        boolean r2 = false;
        if (r8 == null) goto L8;
        String r3 = r8.getContent();
        if (r3 == null) goto L8;
        r r4 = i(r3, r8);
        if (r4 == null) goto L8;
    L35:
        if (r4 != null) goto L40;
        dm.a.b r9 = dm.a.a("HybridPageSlcProductCardFactory");
        StringBuilder r5 = new StringBuilder("createSingleCard, viewInfo is null, context is null = ");
        if (this.a != null) goto L39;
        r2 = true;
    L39:
        r5.append(r2);
        r9.b(r5.toString(), null);
    L40:
        return r4;
    L8:
        if (r8 == null) goto L10;
        String r6 = r8.getUrl();
    L11:
        if (r8 == null) goto L13;
        String r10 = r8.getName();
    L14:
        if (r8 == null) goto L16;
        String r11 = r8.getVersion();
    L17:
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        if (r6 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L34;
        if (r10 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == true) goto L34;
        r4 = h(r6, r10, r11);
        goto L35
    L28:
        if (r10.length() == 0) goto L31;
        r13 = false;
    L34:
        r4 = null;
        goto L35
    L21:
        if (r6.length() == 0) goto L24;
        r12 = false;
        goto L25
    L16:
        r11 = null;
        goto L17
    L13:
        r10 = null;
        goto L14
    L10:
        r6 = null;
        goto L11
    }
}
