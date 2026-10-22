package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends FrameLayout {
    public l a;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b b;
    public String c;
    public View d;
    public final e e;

    public final void a(a r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        String r0 = r13.b;
        if (r0 == null) goto L48;
        int r1 = p73.c.d;
        StringBuilder r2 = new StringBuilder("AnchorV4LynxNodeView getPreloadLynxCard: componentId：");
        ComponentDTO r3 = r13.f;
        View r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.getComponentId();
    L9:
        r2.append(r5);
        r2.append(", lynxAddress：");
        r2.append(r13.b);
        p73.c.a.a(r2.toString());
        String r6 = r13.b;
        Context r7 = getContext();
        Intrinsics.checkNotNullParameter(r6, "schema");
        Intrinsics.checkNotNullParameter(r7, "context");
        JSONObject r8 = k.w(r13.c);
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(this, FreqActions.ACTION_VIEW);
        if (this.e.S(new p73.d(r6, r7, this, r8, r13, null, this.e.d()), r13.identifier()) != null) goto L47;
        removeAllViews();
        View r9 = this.d;
        if (r9 == null) goto L14;
        addView(r9);
    L14:
        StringBuilder r10 = new StringBuilder("AnchorV4LynxNodeView loadNormalLynxCard, componentId：");
        ComponentDTO r11 = r13.f;
        if (r11 == null) goto L17;
        String r12 = r11.getComponentId();
    L18:
        r10.append(r12);
        r10.append(", lynxAddress：");
        r10.append(r13.b);
        p73.c.a.a(r10.toString());
        String r14 = UriProtector.getQueryParameter(UriProtector.parse(r0), "url");
        if (r14 == null) goto L48;
        if (k.c(r14) == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L48;
        String r15 = UriProtector.parse(r14).buildUpon().build().toString();
        JSONObject r16 = k.w(r13.c);
        if (r16 == null) goto L29;
        r16.put("identifier", AnchorV4DataManager.d);
    L30:
        JSONObject r17 = r13.d;
        l r18 = this.a;
        if (r18 != null) goto L33;
        JSONObject r19 = new JSONObject();
        r19.put("module_param", r16);
        r19.put("mob_data", r17);
        this.a = this.e.U(getContext(), r15, com.bytedance.android.shopping.hybrid.a.b(r19), this, new b(r13));
        Unit r20 = Unit.INSTANCE;
    L43:
        this.c = r15;
        l r21 = this.a;
        if (r21 == null) goto L46;
        r4 = r21.getHybridView();
    L46:
        this.d = r4;
        goto L47
    L33:
        if (this.c.length() <= 0) goto L35;
        boolean r22 = true;
    L36:
        if (r22 == true) goto L38;
    L41:
        JSONObject r23 = new JSONObject();
        r23.put("module_param", r16);
        r23.put("mob_data", r17);
        Unit r24 = Unit.INSTANCE;
        r18.renderTemplate(r15, com.bytedance.android.shopping.hybrid.a.b(r23));
        goto L43
    L38:
        if (Intrinsics.areEqual(this.c, r15) == false) goto L41;
        if (r16 == null) goto L41;
        JSONObject r25 = new JSONObject();
        r25.put("module_param", r16);
        r25.put("mob_data", r17);
        Unit r26 = Unit.INSTANCE;
        r18.updateData(com.bytedance.android.shopping.hybrid.a.b(r25));
        goto L43
    L35:
        r22 = false;
        goto L36
    L29:
        r16 = null;
        goto L30
    L17:
        r12 = null;
    L47:
        int r27 = q.a;
        q.a(this, r13.g, this.b, 8, 0, CollectionsKt.listOf(new Integer[]{0, 0, 0, 0}));
        goto L48
    L8:
        r5 = null;
    L48:
        Unit r110 = Unit.INSTANCE;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.b.e(r2);
        super.draw(r2);
        this.b.d(r2);
    }

    public c(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r3, "depend");
        if (r2 == null) goto L7;
        super(r2);
        this.e = r3;
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r4 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.b = r4;
        this.c = "";
        r4.f(new Radius(8, 8, 8, 8));
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.b.c(r1, r2);
    }
}
