package com.bytedance.android.shopping.store.slicecard;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class j implements b {
    public SlcRenderContext a;
    public com.bytedance.android.ecom.slice.ext.template.gecko.c b;
    public final Map<String, Object> c;

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final void g() {
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final Map<String, Object> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.c);
        return r0;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final void e() {
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        com.bytedance.android.ecom.slice.ext.template.gecko.c r1 = this.b;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.b = null;
        this.a = null;
        c.a.clear();
        dm.a.a("ShopSliceService").i("destroyContext");
    }

    public j() {
        this.c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public SlcRenderContext getContext() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final void c(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        this.c.putAll(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public void d(Map<String, ShopSliceItemConfig> r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfigs");
        ECShopABSettings.k.getClass();
        if (((Boolean) ECShopABSettings.j.getValue()).booleanValue() == false) goto L11;
        Iterator<Map.Entry<String, ShopSliceItemConfig>> r1 = r10.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Iterator<SliceTemplate> r3 = r1.next().getValue().getTemplates().iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        r3.next().setContent(null);
    L11:
        com.bytedance.android.ec.store.setting.j r2 = ShopSlcTemplateManager.a;
        Intrinsics.checkNotNullParameter(r10, "newConfigs");
        Iterator<Map.Entry<String, ShopSliceItemConfig>> r11 = r10.entrySet().iterator();
    L13:
        if (r11.hasNext() == false) goto L52;
        Map.Entry<String, ShopSliceItemConfig> r0 = r11.next();
        ConcurrentHashMap<String, ShopSliceItemConfig> r4 = ShopSlcTemplateManager.i;
        ShopSliceItemConfig r5 = r4.get(r0.getKey());
        if (r5 == null) goto L16;
        ArrayList r6 = new ArrayList();
        r6.addAll(r5.getTemplates());
        Iterator<T> r7 = r0.getValue().getTemplates().iterator();
    L19:
        if (r7.hasNext() == false) goto L51;
        SliceTemplate r8 = (SliceTemplate) r7.next();
        Iterator r9 = r6.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        Object r12 = r9.next();
        if (Intrinsics.areEqual(((SliceTemplate) r12).getName(), r8.getName()) == false) goto L22;
    L27:
        SliceTemplate r13 = (SliceTemplate) r12;
        if (r13 == null) goto L29;
        String r14 = r8.getUrl();
        if (r14 == null) goto L33;
        r13.setUrl(r14);
    L33:
        String r15 = r8.getContent();
        if (r15 != null) goto L36;
    L44:
        String r16 = r8.getVersion();
        if (r16 == null) goto L47;
        r13.setVersion(r16);
    L47:
        r13.setType(r8.getType());
        Integer r17 = r8.getSpanSize();
        if (r17 == null) goto L50;
        r13.setSpanSize(Integer.valueOf(r17.intValue()));
    L50:
        r13.setPredictHeight(r8.getPredictHeight());
        goto L19
    L36:
        if (r15.length() <= 0) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == true) goto L42;
        r15 = null;
    L42:
        if (r15 == null) goto L44;
        r13.setContent(r15);
        goto L44
    L38:
        r18 = false;
        goto L39
    L29:
        r6.add(r8);
        goto L19
    L26:
        r12 = null;
        goto L27
    L51:
        r5.setTemplates(r6);
        goto L13
    L16:
        r4.put(r0.getKey(), r0.getValue());
        goto L13
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final void f(com.bytedance.android.ecom.arch.slice.render.context.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L9;
        nq.a.a();
        ArrayList r1 = r0.n;
        if (r1 != null) goto L7;
        r1 = new ArrayList();
        r0.n = r1;
    L7:
        r1.add(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public final void h(com.bytedance.android.ecom.arch.slice.render.context.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L8;
        nq.a.a();
        ArrayList r1 = r0.n;
        if (r1 == null) goto L9;
        r1.remove(r2);
        return;
    L9:
        return;
    }

    public void i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        h.b.a(r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.b
    public void b(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        i(r6);
        dm.a.a("ShopSliceService").i("initRenderContext");
        String r0 = "Shop_" + r6.hashCode();
        SlcGeckoTemplateMgr.l.getClass();
        this.b = SlcGeckoTemplateMgr.e(r0, "ec_shop");
        com.bytedance.android.ecom.slice.ext.template.gecko.c r3 = this.b;
        Intrinsics.checkNotNull(r3);
        com.bytedance.android.ecom.arch.slice.expr.b r4 = r3.c();
        if (r4 != null) goto L5;
        r4 = new com.bytedance.android.ecom.arch.slice.expr.b(null);
    L5:
        SlcRenderContext r1 = new SlcRenderContext(r6, "ec_shop", new SlcExprContext(r4));
        com.bytedance.android.ecom.slice.ext.template.gecko.c r2 = this.b;
        Intrinsics.checkNotNull(r2);
        r1.a0 = new SlcDefaultTemplateProvider(r2);
        if (ECStoreFoldPhoneHelper.d() == false) goto L8;
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        r1.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(-1.0f, 1.0f, 1.0f);
    L10:
        r1.o = new g();
        r1.E = "ec_shop";
        Unit r8 = Unit.INSTANCE;
        this.a = r1;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r9 = this.b;
        if (r9 == null) goto L14;
        r9.b(r1);
        return;
    L14:
        return;
    L8:
        if (r7 == false) goto L10;
        com.bytedance.android.ecom.arch.slice.render.context.b.a r10 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        float r11 = o.a;
        r10.getClass();
        r1.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(375.0f, r11, r11);
        goto L10
    }
}
