package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.larksuite.component.universe_design.notice.UDNotice;
import i75.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r7 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r6;
        a r0 = this.a;
        boolean r1 = r7.a;
        r0.o = r1;
        r0.g(r1, r7.b);
        a r2 = this.a;
        String r3 = r7.b;
        DLPRiskBannerView r4 = r2.h;
        if (r4 == null) goto L5;
        boolean r5 = h.e(r3);
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r2.d((LinearLayout.LayoutParams) r8, r5, r2.o);
    L5:
        a r9 = this.a;
        String r10 = r7.b;
        UDNotice r11 = r9.k;
        if (r11 == null) goto L9;
        boolean r12 = h.e(r10);
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r9.d((LinearLayout.LayoutParams) r13, r12, r9.o);
        return;
    }
}
