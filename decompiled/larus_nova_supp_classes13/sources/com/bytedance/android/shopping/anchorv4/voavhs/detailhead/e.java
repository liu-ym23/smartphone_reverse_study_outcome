package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AnchorV4DetailHeadView a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ TabLayout.Tab c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        TabLayout.Tab r11 = this.c;
        if (r11 == null) goto L5;
        r11.select();
    L5:
        int r12 = b.a;
        AnchorV4DetailHeadView r13 = this.a;
        t r0 = r13.n;
        d r14 = r13.o;
        if (r14 == null) goto L8;
        DetailCombinePropertiesComponent r15 = r14.f;
    L9:
        String r16 = b.b(r15);
        Intrinsics.checkNotNullParameter(r16, "tabType");
        if (r0 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r0, "product_feature_tab_click", MapsKt.mapOf(TuplesKt.to("tab_type", r16)), false, null, null, null, null, 252);
        return;
    L13:
        return;
    L8:
        r15 = null;
        goto L9
    }

    public e(AnchorV4DetailHeadView r1, ArrayList r2, TabLayout.Tab r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
