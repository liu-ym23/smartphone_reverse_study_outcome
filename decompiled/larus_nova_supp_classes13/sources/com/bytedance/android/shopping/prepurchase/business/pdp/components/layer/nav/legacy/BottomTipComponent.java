package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.widget.LinearLayout;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.anchorv4.bottom.BottomTipMeta;
import com.bytedance.android.shopping.anchorv4.bottom.widget.CenteredTextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomTipComponent implements l1.a {
    public BottomTipMeta a;
    public final CenteredTextWithOneIconElementView b;
    public final LynxCardView c;
    public final LinearLayout d;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ BottomTipComponent c;
        public final /* synthetic */ LynxCardComponent d;

        @Override // java.lang.Runnable
        public final void run() {
            LynxCardView r0 = this.c.c;
            LynxCardComponent r1 = this.d;
            if (LargeFontModeUtil.a() <= 1.0f) goto L5;
            boolean r2 = true;
        L6:
            LynxCardView.a(r0, r1, r2, 2);
            return;
        L5:
            r2 = false;
            goto L6
        }

        public a(BottomTipComponent r1, LynxCardComponent r2) {
            this.c = r1;
            this.d = r2;
            super("lynxTipView.bind");
        }
    }

    public final void onFinish() {
    }

    public final void onStart() {
    }

    public BottomTipComponent(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "llTips");
        this.d = r2;
        this.b = r2.findViewById(2131362757);
        this.c = (LynxCardView) r2.findViewById(2131362752);
    }

    public final void onTick(long r5) {
        int r0 = c2.h;
        c2 r6 = c2.a.a(this.b.getContext(), r5, false);
        Object r7 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        BottomTipMeta r2 = this.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        String r3 = r2.getCountDownTemplate();     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        if (StringsKt.contains$default(r3, "%s", false, 2, null) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        String r8 = String.format(r3, Arrays.copyOf(new Object[]{r6.g}, 1));     // Catch: Throwable -> L16
    L14:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r9) == true) goto L22;
        r7 = r9;
    L22:
        String r10 = (String) r7;
        if (r10 != null) goto L25;
        return;
    L25:
        this.b.b(r10);
        return;
    L13:
        r8 = null;
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void a(TextWithOneIconElement r4, LynxCardComponent r5, final BottomTipMeta r6, final d r7) {
        Intrinsics.checkNotNullParameter(r7, "anchorV4VM");
        if (r4 != null) goto L7;
        if (r5 != null) goto L7;
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        return;
    L7:
        if (r4 != null) goto L10;
        this.b.setVisibility(8);
    L10:
        if (r5 != null) goto L34;
        this.c.setVisibility(8);
        if (r4 != null) goto L14;
        return;
    L14:
        this.a = r6;
        this.b.setVisibility(0);
        Boolean r8 = null;
        if (r6 == null) goto L24;
        final String r0 = r6.getTipUrl();
        if (r0 == null) goto L24;
        if (com.bytedance.android.shopping.extensions.k.c(r0) == true) goto L22;
        r0 = null;
    L22:
        if (r0 == null) goto L24;
        this.b.setOnClickListener(new BottomTipComponent$initComponent$$inlined$let$lambda$1(r0, this, r7, r6));
        r7.d(new BottomTipComponent$initComponent$$inlined$let$lambda$2(this, r7, r6));
    L24:
        if (r6 == null) goto L26;
        r7.d(new BottomTipComponent$initComponent$$inlined$let$lambda$3(r7, r6));
    L26:
        this.b.a(r4);
        if (r6 == null) goto L30;
        r8 = Boolean.valueOf(r6.getDisplayAsCountDown());
    L30:
        if (com.bytedance.android.shopping.extensions.k.i(r8) == false) goto L43;
        r7.A(this);
        return;
    L43:
        return;
    L34:
        if (PdpPerfOpt.e() == false) goto L36;
        r7.W(new a(this, r5));
    L41:
        this.c.setVisibility(0);
        return;
    L36:
        LynxCardView r9 = this.c;
        if (LargeFontModeUtil.a() <= 1.0f) goto L39;
        boolean r10 = true;
    L40:
        LynxCardView.a(r9, r5, r10, 2);
        goto L41
    L39:
        r10 = false;
        goto L40
    }
}
