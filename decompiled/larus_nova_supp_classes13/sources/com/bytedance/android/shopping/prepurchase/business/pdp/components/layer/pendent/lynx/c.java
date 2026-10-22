package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantGravity;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.i;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public PendantContainerVO a;
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> b;
    public float c;
    public String d;
    public final String e;
    public final FrameLayout f;
    public final com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.b g;

    public static final class a {
    }

    public static final class b implements k {
        public final /* synthetic */ LynxElementVO a;

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public b(LynxElementVO r1) {
            this.a = r1;
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            ConfigModel r0 = this.a.getConfig();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getFontScale() == true) goto L7;
            return;
        L7:
            if (this.a.getConfig().getFontScaleMaxRatio() != null) goto L9;
        L11:
            LargeFontModeUtil.a();
        L13:
            if ((r3 instanceof LynxView) == true) goto L15;
            r3 = null;
        L15:
            LynxView r4 = (LynxView) r3;
            return;
        L9:
            if (LargeFontModeUtil.a() <= 1) goto L11;
            this.a.getConfig().getFontScaleMaxRatio().floatValue();
            goto L13
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

    static {
    }

    public final void e() {
        if (this.a != null) goto L5;
        return;
    L5:
        e r0 = this.g.b();
        if (r0.a <= 0) goto L8;
    L57:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L51
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r2 = this.b.entrySet().iterator();     // Catch: Throwable -> L51
    L16:
        if (r2.hasNext() == false) goto L49;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r3 = r2.next();     // Catch: Throwable -> L51
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r4 = r3.getValue();     // Catch: Throwable -> L51
        PendantGravity r5 = null;
        if (r4 == null) goto L22;
        View r6 = r4.a;     // Catch: Throwable -> L51
        if (r6 == null) goto L22;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();     // Catch: Throwable -> L51
    L24:
        if ((r7 instanceof FrameLayout.LayoutParams) == true) goto L26;
        r7 = null;
    L26:
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;     // Catch: Throwable -> L51
        if (r8 == null) goto L16;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r9 = r3.getValue();     // Catch: Throwable -> L51
        if (r9 == null) goto L31;
        LynxElementVO r10 = r9.f;     // Catch: Throwable -> L51
    L32:
        if (r10 == null) goto L34;
        r5 = r10.getGravity();     // Catch: Throwable -> L51
    L34:
        if (r5 == null) goto L16;
        int r11 = d.b[r5.ordinal()];     // Catch: Throwable -> L51
        if (r11 != 1) goto L39;
        int r12 = r10.getUseBottomMargin();     // Catch: Throwable -> L51
        int r13 = r10.getUseLeftMargin();     // Catch: Throwable -> L51
        r8.bottomMargin = r0.d + r12;     // Catch: Throwable -> L51
        r8.gravity = 8388691;     // Catch: Throwable -> L51
        r8.leftMargin = r0.a + r13;     // Catch: Throwable -> L51
        goto L16
    L39:
        if (r11 != 2) goto L41;
        int r14 = r10.getUseTopMargin() + r0.b;     // Catch: Throwable -> L51
        int r15 = r10.getUseRightMargin() + r0.c;     // Catch: Throwable -> L51
        r8.topMargin = r14;     // Catch: Throwable -> L51
        r8.gravity = 8388661;     // Catch: Throwable -> L51
        r8.rightMargin = r15;     // Catch: Throwable -> L51
        goto L16
    L41:
        if (r11 != 3) goto L43;
        r8.bottomMargin = r0.d + r10.getUseBottomMargin();     // Catch: Throwable -> L51
        r8.rightMargin = r0.c + r10.getUseRightMargin();     // Catch: Throwable -> L51
        r8.gravity = 8388693;     // Catch: Throwable -> L51
        goto L16
    L43:
        if (r11 != 4) goto L16;
        r8.topMargin = r10.getUseTopMargin() + r0.b;     // Catch: Throwable -> L51
        r8.leftMargin = r10.getUseLeftMargin() + r0.a;     // Catch: Throwable -> L51
        r8.gravity = 8388659;     // Catch: Throwable -> L51
        goto L16
    L31:
        r10 = null;
    L22:
        r7 = null;
        goto L24
    L49:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L79;
        ECExceptionMonitor.e(r17);
        return;
    L79:
        return;
    L51:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L8:
        if (r0.b > 0) goto L57;
        if (r0.c > 0) goto L57;
        if (r0.d > 0) goto L57;
    }

    public final void b(LynxElementVO r13) {
        if (r13 == null) goto L71;
        String r0 = r13.getSchema();
        if (r0 != null) goto L6;
        return;
    L6:
        if (a2.b(r0) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L73;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r1 = this.b.get(r0);
        if (r1 == null) goto L24;
        FrameLayout r3 = this.f;
        View r4 = r1.a;
        if (r3 == null) goto L16;
        if (r4 == null) goto L16;
        f(r3, r4, d(this, r13.getWidth()), d(this, r13.getHeight()));
        a(r13, r4);
    L16:
        r1.f = r13;
        if (r13.getQueryData() != null) goto L19;
        return;
    L19:
        l r2 = r1.b;
        if (r2 == null) goto L22;
        r2.updateData(r13.getQueryData());
        Unit r5 = Unit.INSTANCE;
    L23:
        if (r5 == null) goto L24;
        return;
    L22:
        r5 = null;
    L24:
        Uri.Builder r6 = UriProtector.parse(r0).buildUpon();
        Map r7 = r13.getQueryData();
        if (r7 == null) goto L30;
        Iterator r8 = r7.entrySet().iterator();
    L28:
        if (r8.hasNext() == false) goto L30;
        Map.Entry r9 = (Map.Entry) r8.next();
        r6.appendQueryParameter((String) r9.getKey(), String.valueOf(r9.getValue()));
    L30:
        r6.appendQueryParameter("identifier", this.e);
        r6.appendQueryParameter("send_visible_event", "1");
        JSONObject r10 = z1.g(r13.getMegaData());
        if (r10 == null) goto L47;
        Map r11 = r13.getLocation();
        if (r11 == null) goto L35;
        Object r12 = r11.get("anchor_parent_view_key");
    L37:
        if ((r12 instanceof String) == true) goto L39;
        r12 = null;
    L39:
        String r14 = (String) r12;
        Map r15 = r13.getLocation();
        if (r15 == null) goto L42;
        Object r16 = r15.get("anchor_view_key");
    L44:
        if ((r16 instanceof String) == true) goto L46;
        r16 = null;
    L46:
        KtSafeMethodExtensionKt.safePut(r10, "config", c(r14, (String) r16));
        goto L47
    L42:
        r16 = null;
        goto L44
    L35:
        r12 = null;
    L47:
        String r17 = UUID.randomUUID().toString();
        HashMap r18 = j.a;
        j.h(r17, r10);
        r6.appendQueryParameter("mega_object_id", r17);
        l r19 = this.g.a(this.f.getContext(), r6.build().toString(), new b(r13));
        if (r19 == null) goto L75;
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r20 = this.b;
        View r21 = r19.getHybridView();
        if (r21 == null) goto L67;
        f(this.f, r21, d(this, r13.getWidth()), d(this, r13.getHeight()));
        a(r13, r21);
        PendantGravity r22 = r13.getGravity();
        if (r22 == null) goto L66;
        int r23 = d.a[r22.ordinal()];
        if (r23 != 1) goto L56;
        d2.a(r21, r13.getUseBottomMargin());
        d2.c(r21, r13.getUseLeftMargin());
        d2.b(r21, 8388691);
        goto L66
    L56:
        if (r23 != 2) goto L58;
        d2.f(r21, r13.getUseTopMargin());
        d2.e(r21, r13.getUseRightMargin());
        d2.b(r21, 8388661);
        goto L66
    L58:
        if (r23 != 3) goto L60;
        d2.a(r21, r13.getUseBottomMargin());
        d2.e(r21, r13.getUseRightMargin());
        d2.b(r21, 8388693);
        goto L66
    L60:
        if (r23 != 4) goto L66;
        d2.f(r21, r13.getUseTopMargin());
        d2.c(r21, r13.getUseLeftMargin());
        d2.b(r21, 8388659);
    L66:
        Unit r24 = Unit.INSTANCE;
        View r25 = r21;
    L68:
        r20.put(r0, new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c(r25, r19, r13.getLynxId(), r13.getState(), r13));
        Unit r110 = Unit.INSTANCE;
        return;
    L67:
        r25 = null;
        goto L68
    L75:
        return;
    L73:
        return;
    }

    public static int d(c r1, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.a r2) {
        r1.getClass();
        if (r2 == null) goto L5;
        Integer r3 = r2.getType();
    L6:
        if (r3 != null) goto L9;
    L15:
        if (r3 != null) goto L18;
    L20:
        if (r3 != null) goto L23;
    L25:
        if (r3 != null) goto L28;
    L30:
        return -2;
    L28:
        if (r3.intValue() != 3) goto L30;
        return -1;
    L23:
        if (r3.intValue() != 2) goto L25;
    L18:
        if (r3.intValue() != 1) goto L20;
    L9:
        if (r3.intValue() != 0) goto L15;
        Integer r4 = r2.b;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L32:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5));
    L13:
        r5 = 0;
        goto L32
    L5:
        r3 = null;
        goto L6
    }

    public final void a(LynxElementVO r2, View r3) {
        if (ECSettingKeys.z0() == false) goto L14;
        Map r4 = r2.getLocation();
        if (r4 == null) goto L7;
        Object r5 = r4.get("anchor_parent_view_key");
    L9:
        if (Intrinsics.areEqual(r5, "bottom_nav_slice") == false) goto L11;
        float r6 = this.c;
    L12:
        r3.setTranslationY(r6);
        return;
    L11:
        r6 = 0.0f;
        goto L12
    L7:
        r5 = null;
        goto L9
    }

    public final JSONObject c(String r9, String r10) {
        JSONObject r0 = new JSONObject();
        if (r9 == null) goto L33;
        if (r10 == null) goto L33;
        int r1 = r9.hashCode();
        if (r1 == 989642338) goto L14;
        if (r1 == 1362196748) goto L11;
    L16:
        i r11 = null;
    L18:
        if (r11 == null) goto L21;
        int[] r2 = r11.getLocationOnScreen();
        if (r2 == null) goto L21;
    L22:
        ArrayList r3 = new ArrayList(r2.length);
        int r4 = r2.length;
        int r5 = 0;
        int r6 = 0;
    L23:
        if (r6 >= r4) goto L25;
        r3.add(Integer.valueOf(UIUtils.px2dip(this.f.getContext(), r2[r6])));
        r6 = r6 + 1;
        goto L23
    L25:
        KtSafeMethodExtensionKt.safePut(r0, "anchor_view_location", CollectionsKt.toList(r3).toString());
        int[] r12 = new int[2];
        Context r7 = this.f.getContext();
        if (r11 == null) goto L28;
        int r8 = r11.getWidth();
    L29:
        r12[0] = UIUtils.px2dip(r7, r8);
        Context r13 = this.f.getContext();
        if (r11 == null) goto L32;
        r5 = r11.getHeight();
    L32:
        r12[1] = UIUtils.px2dip(r13, r5);
        KtSafeMethodExtensionKt.safePut(r0, "anchor_view_size", ArraysKt.toList(r12).toString());
        goto L33
    L28:
        r8 = 0;
    L21:
        r2 = new int[]{0, 0};
        goto L22
    L11:
        if (r9.equals("top_nav_slice") == false) goto L16;
        r11 = this.g.e(r10);
        goto L18
    L14:
        if (r9.equals("bottom_nav_slice") == false) goto L16;
        r11 = this.g.c(r10);
    L33:
        return r0;
    }

    public final void g(int r7, int r8) {
        if (this.a != null) goto L21;
        return;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r1 = this.b.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r1.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r2 = r1.next().getValue();     // Catch: Throwable -> L15
        if (r2 == null) goto L7;
        l r3 = r2.b;     // Catch: Throwable -> L15
        if (r3 == null) goto L7;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r4, "identifier", this.e);     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r4, "width", Integer.valueOf(com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r7))));     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r4, "height", Integer.valueOf(com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r8))));     // Catch: Throwable -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r3.sendJsEvent("pdp_screen_size_change", r4);     // Catch: Throwable -> L15
        goto L7
    L13:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L30;
        ECExceptionMonitor.e(r10);
        return;
    L30:
        return;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public c(String r2, FrameLayout r3, LynxPendentComponent.a r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "pendentContainer");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = new ConcurrentHashMap();
    }

    public static void f(ViewGroup r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        if (r3.getParent() == null) goto L9;
        ViewParent r0 = r3.getParent();
        if (r0 == null) goto L8;
        ((ViewGroup) r0).removeView(r3);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        ViewGroup.LayoutParams r1 = r3.getLayoutParams();
        if (r1 != null) goto L12;
        r1 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        r1.width = r4;
        r1.height = r5;
        Unit r6 = Unit.INSTANCE;
        r3.setLayoutParams(r1);
        r2.addView(r3);
    }
}
