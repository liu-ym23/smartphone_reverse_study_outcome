package com.bytedance.android.shopping.store.router.hybridpage.slice;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.g;
import com.bytedance.android.shopping.store.slicecard.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends j {
    public static vj3.a d;

    public static final class a {
    }

    static {
    }

    public static float j() {
        Configuration r0 = Resources.getSystem().getConfiguration();
        if (r0 == null) goto L5;
        Float r1 = Float.valueOf(r0.fontScale);
    L6:
        float r2 = k.e(r1, 1.0f);
        if (r2 >= 0.0f) goto L9;
    L11:
        vj3.a r3 = d;
        if (r3 == null) goto L16;
        Float r4 = r3.e();
        if (r4 == null) goto L16;
        return r4.floatValue();
    L16:
        return 1.15f;
    L9:
        if (r2 > 1.0f) goto L11;
        return 1.0f;
    L5:
        r1 = null;
        goto L6
    }

    public c() {
    }

    @Override // com.bytedance.android.shopping.store.slicecard.j, com.bytedance.android.shopping.store.slicecard.b
    public final void d(Map<String, ShopSliceItemConfig> r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfigs");
        List<com.bytedance.android.ec.store.setting.k> r1 = HybridPageSlcTemplateManager.a;
        Intrinsics.checkNotNullParameter(r10, "newConfigs");
        Iterator<Map.Entry<String, ShopSliceItemConfig>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L42;
        Map.Entry<String, ShopSliceItemConfig> r0 = r11.next();
        ConcurrentHashMap<String, ShopSliceItemConfig> r2 = HybridPageSlcTemplateManager.e;
        ShopSliceItemConfig r3 = r2.get(r0.getKey());
        if (r3 == null) goto L7;
        ArrayList r4 = new ArrayList();
        r4.addAll(r3.getTemplates());
        Iterator<T> r5 = r0.getValue().getTemplates().iterator();
    L10:
        if (r5.hasNext() == false) goto L41;
        SliceTemplate r6 = (SliceTemplate) r5.next();
        Iterator r7 = r4.iterator();
    L12:
        String r8 = null;
        if (r7.hasNext() == false) goto L17;
        Object r9 = r7.next();
        if (Intrinsics.areEqual(((SliceTemplate) r9).getName(), r6.getName()) == false) goto L12;
    L18:
        SliceTemplate r12 = (SliceTemplate) r9;
        if (r12 == null) goto L20;
        String r13 = r6.getUrl();
        if (r13 == null) goto L24;
        r12.setUrl(r13);
    L24:
        String r14 = r6.getContent();
        if (r14 != null) goto L27;
    L34:
        String r15 = r6.getVersion();
        if (r15 == null) goto L37;
        r12.setVersion(r15);
    L37:
        r12.setType(r6.getType());
        Integer r16 = r6.getSpanSize();
        if (r16 == null) goto L40;
        r12.setSpanSize(Integer.valueOf(r16.intValue()));
    L40:
        r12.setPredictHeight(r6.getPredictHeight());
        goto L10
    L27:
        if (r14.length() <= 0) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L32;
        r8 = r14;
    L32:
        if (r8 == null) goto L34;
        r12.setContent(r8);
        goto L34
    L29:
        r17 = false;
        goto L30
    L20:
        r4.add(r6);
        goto L10
    L17:
        r9 = null;
        goto L18
    L41:
        r3.setTemplates(r4);
        goto L4
    L7:
        r2.put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.slicecard.j
    public final void i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ak3.a.b.a(r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.j, com.bytedance.android.shopping.store.slicecard.b
    public final void b(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        i(r6);
        String r8 = "HybridPage_" + r6.hashCode();
        SlcGeckoTemplateMgr.l.getClass();
        this.b = SlcGeckoTemplateMgr.e(r8, "hybrid_page");
        com.bytedance.android.ecom.slice.ext.template.gecko.c r2 = this.b;
        Intrinsics.checkNotNull(r2);
        com.bytedance.android.ecom.arch.slice.expr.b r3 = r2.c();
        if (r3 != null) goto L5;
        r3 = new com.bytedance.android.ecom.arch.slice.expr.b(null);
    L5:
        SlcRenderContext r9 = new SlcRenderContext(r6, "hybrid_page", new SlcExprContext(r3));
        com.bytedance.android.ecom.slice.ext.template.gecko.c r1 = this.b;
        Intrinsics.checkNotNull(r1);
        r9.a0 = new SlcDefaultTemplateProvider(r1);
        vj3.a r10 = d;
        if (r10 == null) goto L23;
        com.bytedance.android.ecom.arch.slice.render.context.b.a r4 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        Float r5 = r10.a();
        if (r5 == null) goto L10;
        float r11 = r5.floatValue();
    L11:
        float r12 = j();
        float r13 = j();
        r4.getClass();
        r9.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r11, r12, r13);
        Map<String, Object> r14 = r10.c();
        if (r14 == null) goto L14;
        r9.p(r14);
    L14:
        String r15 = r10.f();
        if (r15 == null) goto L17;
        r9.E = r15;
    L17:
        Integer r16 = r10.b();
        if (r16 == null) goto L20;
        r9.k = r16.intValue();
    L20:
        Boolean r17 = r10.d();
        if (r17 == null) goto L23;
        r9.j = r17.booleanValue();
        goto L23
    L10:
        r11 = 375.0f;
    L23:
        r9.o = new g();
        r9.E = "hybrid_page";
        Unit r18 = Unit.INSTANCE;
        this.a = r9;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r19 = this.b;
        if (r19 == null) goto L27;
        r19.b(r9);
        return;
    }
}
