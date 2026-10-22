package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements b<HeaderSliceModel> {
    public HeaderSliceModel a;
    public r b;
    public SlcTemplateViewHelper c;
    public final s d;

    public static final class a implements Runnable {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void d(boolean r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void f(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void h(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onDestroy() {
    }

    public final void b() {
        Map<String, Object> r1 = null;
        if (this.c == null) goto L11;
        HeaderSliceModel r0 = this.a;
        if (r0 == null) goto L18;
        com.bytedance.android.ecom.arch.slice.g r2 = r0.getGeckoSlice();
        if (r2 == null) goto L19;
        SlcTemplateViewHelper r3 = this.c;
        if (r3 == null) goto L20;
        r3.b(r2, this.d.yd().a(), null);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r r4 = this.b;
        HeaderSliceModel r5 = this.a;
        if (r5 == null) goto L14;
        r1 = r5.getSliceTemplateData();
    L14:
        if (r4 == null) goto L22;
        if (r1 == null) goto L23;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(r1);
        r6.putAll(this.d.yd().a());
        Unit r7 = Unit.INSTANCE;
        r4.a(MapsKt.mapOf(TuplesKt.to("data", r6)), this.d.rR().getSessionId());
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void e() {
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void o() {
        b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void a(boolean r3) {
        SlcTemplateViewHelper r0 = this.c;
        if (r0 == null) goto L12;
        SlcTemplateView r1 = r0.b;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getVisibility() != 0) goto L14;
        if (r3 == false) goto L10;
        ViewExtensionsKt.c(r1, false, 3);
        return;
    L10:
        ViewExtensionsKt.i(r1);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onPageSelected(int r2) {
        Lazy r3 = UIUtils.a;
        UIUtils.c().post(new a(this));
    }

    public i(Context r2, s r3, HeaderPendantModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "pendantModel");
        this.d = r3;
        PendantType r5 = PendantType.TYPE_NATIVE;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r1, int r2, Integer r3) {
        HeaderSliceModel r4 = (HeaderSliceModel) r1;
    }
}
