package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.res.Resources;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.slice.PdpSliceRegister;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.google.gson.internal.LinkedTreeMap;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vg3.f0;
import vg3.o;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.b implements DynamicFeatureComponent.b {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j c;

    public final class a implements com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a {
        public final /* synthetic */ k a;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a
        public final String b() {
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
            w r2 = (w) this.a.c.getService(w.class);     // Catch: Throwable -> L14
            if (r2 == null) goto L8;
            LinkedTreeMap<String, Object> r3 = r2.getTrackMeta();     // Catch: Throwable -> L14
            if (r3 == null) goto L8;
            Object r4 = r3.get("product_type");     // Catch: Throwable -> L14
        L10:
            if ((r4 instanceof String) == true) goto L12;
            r4 = null;
        L12:
            Object r5 = Result.constructor-impl((String) r4);     // Catch: Throwable -> L14
        L17:
            if (Result.isFailure-impl(r5) == true) goto L21;
            r0 = r5;
        L21:
            return (String) r0;
        L8:
            r4 = null;
        L14:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a
        public final w a() {
            return (w) this.a.c.getService(w.class);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a
        public final String getLogId() {
            return this.a.b.d().getData().d();
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a
        public final PageFinder getPageFinder() {
            return this.a.b.a().getPageFinder();
        }

        public a(k r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.a
        public final void openSchema(String r3) {
            Intrinsics.checkNotNullParameter(r3, "url");
            f0 r0 = (f0) this.a.c.getService(f0.class);
            if (r0 == null) goto L6;
            r0.openSchema(r3);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final void g8() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final void getBiz() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final void getChannel() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final void k8() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent.b
    public final boolean a() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.b)).b.a;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final com.bytedance.android.ecom.arch.slice.render.context.b d8() {
        boolean r1 = true;
        if (com.bytedance.android.shopping.anchorv4.experiment.h.e == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L12;
        float r2 = 375.0f;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) this.b.f().b).b.a == false) goto L10;
        Resources r0 = Resources.getSystem();
        int r3 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
        Resources r4 = Resources.getSystem();
        r2 = 375.0f * (RangesKt.coerceAtMost(r3, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels) / this.b.getContainerAbility().i7().a);
    L10:
        com.bytedance.android.ecom.arch.slice.render.context.b.a r5 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        float r6 = LargeFontModeUtil.a();
        float r7 = LargeFontModeUtil.a();
        r5.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r2, r6, r7);
    L12:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final l e8() {
        return new l(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final j h8() {
        return new j(this.b, new a(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final com.bytedance.android.shopping.anchorv4.voavhs.j j8() {
        o r0 = (o) this.c.getService(o.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEnable() == true) goto L7;
        return null;
    L7:
        return new com.bytedance.android.shopping.anchorv4.voavhs.j();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final Function0<com.bytedance.android.ecom.slice.ext.template.gecko.g> i8() {
        return PdpSliceRegister.a();
    }

    public k(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2, com.bytedance.android.shopping.prepurchase.arch.container.component.j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        super(r2);
        this.b = r2;
        this.c = r3;
    }
}
