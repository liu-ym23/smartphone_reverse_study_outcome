package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ConfigMode;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements b<HeaderPendantLynx>, k {
    public HeaderPendantLynx a;
    public l b;
    public final d c;
    public boolean d;
    public final Context e;
    public final s f;
    public final HeaderPendantModel g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void a(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void d(boolean r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void e() {
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final void i() {
        l r0 = this.b;
        if (r0 == null) goto L8;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L8;
        if (r1.getVisibility() != 8) goto L8;
        return;
    L8:
        l r2 = this.b;
        if (r2 == null) goto L29;
        View r3 = r2.getHybridView();
        if (r3 == null) goto L30;
        ConfigMode r4 = this.g.getConfig();
        Boolean r5 = null;
        if (r4 == null) goto L15;
        Boolean r6 = r4.getHideFullMode();
    L16:
        ConfigMode r7 = this.g.getConfig();
        if (r7 == null) goto L20;
        r5 = r7.getHideHalfMode();
    L20:
        if (this.f.isExpanded() == false) goto L22;
        boolean r8 = Intrinsics.areEqual(r6, Boolean.TRUE);
    L23:
        if (r8 == false) goto L25;
        int r9 = 4;
    L26:
        r3.setVisibility(r9);
        return;
    L25:
        r9 = 0;
        goto L26
    L22:
        r8 = Intrinsics.areEqual(r5, Boolean.TRUE);
        goto L23
    L15:
        r6 = null;
        goto L16
    L30:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onDestroy() {
        l r0 = this.b;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void o() {
        i();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void f(boolean r3) {
        JSONObject r0 = new JSONObject();
        if (r3 == false) goto L5;
        String r4 = "0";
    L6:
        r0.put("video_state", r4);
        r0.put("identifier", AnchorV4DataManager.d);
        Unit r5 = Unit.INSTANCE;
        l r6 = this.b;
        if (r6 == null) goto L10;
        r6.sendJsEvent("pdp_header_video_start_change", r0);
        return;
    L10:
        return;
    L5:
        r4 = "1";
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void h(boolean r3) {
        JSONObject r0 = new JSONObject();
        r0.put("combination_status", r3 ? 1 : 0);
        r0.put("identifier", AnchorV4DataManager.d);
        Unit r4 = Unit.INSTANCE;
        l r5 = this.b;
        if (r5 == null) goto L6;
        r5.sendJsEvent("pdp_update_lynx_data", r0);
        return;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        this.c.setLoadSuccess(true);
        HeaderPendantLynx r0 = this.a;
        if (r0 == null) goto L29;
        ConfigMode r1 = r0.getConfig();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getFontScale() != true) goto L31;
        HeaderPendantLynx r2 = this.a;
        if (r2 == null) goto L13;
        ConfigMode r3 = r2.getConfig();
        if (r3 == null) goto L13;
        Float r5 = r3.getFontScaleMaxRatio();
    L14:
        if (r5 == null) goto L21;
        HeaderPendantLynx r6 = this.a;
        if (r6 == null) goto L20;
        ConfigMode r7 = r6.getConfig();
        if (r7 == null) goto L20;
        Float r8 = r7.getFontScaleMaxRatio();
    L22:
        Lazy r9 = LargeFontModeUtil.a;
        if ((r4 instanceof LynxView) == true) goto L25;
        r4 = null;
    L25:
        LynxView r10 = (LynxView) r4;
        if (r8 == null) goto L32;
        r8.floatValue();
        return;
    L32:
        return;
    L20:
        r8 = null;
        goto L22
    L21:
        r8 = Float.valueOf(LargeFontModeUtil.a());
    L13:
        r5 = null;
        goto L14
    L31:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onPageSelected(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("page_index", r3);
        r0.put("identifier", AnchorV4DataManager.d);
        Unit r4 = Unit.INSTANCE;
        l r5 = this.b;
        if (r5 == null) goto L6;
        r5.sendJsEvent("pdp_header_page_index_update", r0);
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

    public e(Context r2, s r3, HeaderPendantModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "pendantModel");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        PendantType r5 = PendantType.TYPE_NATIVE;
        d r6 = new d(r2);
        this.c = r6;
        this.d = true;
        w.a r0 = w.b;
        boolean r7 = r3.rR().d();
        r0.getClass();
        if (w.a.b(r2, r7) == false) goto L6;
        r6.setPadding(0, com.bytedance.android.shopping.extensions.b.b(10), 0, 0);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r1, int r2, Integer r3) {
        HeaderPendantLynx r4 = (HeaderPendantLynx) r1;
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }
}
