package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.a<HeaderSliceModel> {
    public View a;
    public SlcTemplateViewHelper b;
    public final s c;

    public static final class a implements com.bytedance.android.ecom.arch.slice.render.b {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void a(r r4) {
            Intrinsics.checkNotNullParameter(r4, "actionInfo");
            IAction r0 = r4.a;
            View r5 = r4.d;
            this.a.c.yd().d(r0, r5, null);
        }
    }

    public i(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        this.c = r2;
    }

    public final void b(HeaderSliceModel r5, int r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if (r7 != null) goto L5;
        String r8 = "head-cell-" + r6;
    L6:
        SlcTemplateView r9 = null;
        this.b = null;
        if (r5.getGeckoSlice() == null) goto L16;
        c0 r10 = this.c.yd().b(r8, r5.getGeckoSlice());
        if (r10 == null) goto L24;
        SlcTemplateViewHelper r0 = r10.a;
        this.b = r0;
        SlcTemplateView r1 = r0.b;
        if (r1 == null) goto L13;
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r11 = Unit.INSTANCE;
        r9 = r1;
    L13:
        this.a = r9;
        if (r10.b == false) goto L25;
        SlcTemplateViewHelper.c(r10.a, r5.getGeckoSlice(), this.c.yd().a(), 4);
        return;
    L25:
        return;
    L24:
        return;
    L16:
        com.bytedance.android.ecom.arch.slice.render.r r12 = this.c.yd().c(r8, r5.getSliceTemplate());
        if (r12 == null) goto L22;
        View r13 = r12.c;
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r2 = Unit.INSTANCE;
        this.a = r13;
        Map<String, Object> r14 = r5.getSliceTemplateData();
        if (r14 == null) goto L21;
        r12.a(MapsKt.mapOf(TuplesKt.to("data", r14)), this.c.rR().getSessionId());
    L21:
        r12.b(new a(this));
        return;
    L22:
        this.a = null;
        return;
    L5:
        r8 = "head-cell-" + r6 + '-' + r7;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r1, int r2, Integer r3) {
        b((HeaderSliceModel) r1, r2, r3);
    }
}
