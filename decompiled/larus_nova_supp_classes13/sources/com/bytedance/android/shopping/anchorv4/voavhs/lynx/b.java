package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements k {
    public final /* synthetic */ a a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public b(a r1) {
        this.a = r1;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        ComponentDTO r0 = this.a.f;
        if (r0 == null) goto L35;
        VO r1 = r0.getVo();
        if (r1 == null) goto L36;
        ConfigModel r2 = r1.getConfig();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getFontScale() != true) goto L38;
        ComponentDTO r3 = this.a.f;
        if (r3 == null) goto L17;
        VO r5 = r3.getVo();
        if (r5 == null) goto L17;
        ConfigModel r6 = r5.getConfig();
        if (r6 == null) goto L17;
        Float r7 = r6.getFontScaleMaxRatio();
    L18:
        if (r7 == null) goto L27;
        ComponentDTO r8 = this.a.f;
        if (r8 == null) goto L26;
        VO r9 = r8.getVo();
        if (r9 == null) goto L26;
        ConfigModel r10 = r9.getConfig();
        if (r10 == null) goto L26;
        Float r11 = r10.getFontScaleMaxRatio();
    L28:
        Lazy r12 = LargeFontModeUtil.a;
        if ((r4 instanceof LynxView) == true) goto L31;
        r4 = null;
    L31:
        LynxView r13 = (LynxView) r4;
        if (r11 == null) goto L39;
        r11.floatValue();
        return;
    L39:
        return;
    L26:
        r11 = null;
        goto L28
    L27:
        r11 = Float.valueOf(LargeFontModeUtil.a());
    L17:
        r7 = null;
        goto L18
    L38:
        return;
    L36:
        return;
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onLoadFailed(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }
}
