package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/LynxCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxCardView extends FrameLayout implements ActionHubAccessor {
    public l a;
    public String b;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a c;

    public LynxCardView(Context r4) {
        this(r4, null, 0, 14);
    }

    public LynxCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public LynxCardView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.c = r2;
    }

    public LynxCardView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.c = null;
        this.b = "";
    }

    public static void a(LynxCardView r19, LynxCardComponent r20, boolean r21, int r22) {
        boolean r2 = false;
        if ((r22 & 4) == 0) goto L5;
        boolean r0 = false;
    L6:
        if (r20 != null) goto L8;
        r19.setVisibility(8);
        return;
    L8:
        r19.getClass();
        String r3 = r20.getData();
        if (r3 == null) goto L13;
        JSONObject r4 = k.w(r3);
        if (r4 == null) goto L13;
        Map<String, Object> r7 = com.bytedance.android.shopping.hybrid.a.b(r4);
    L14:
        String r5 = r20.getSchema();
        if (r5 == null) goto L93;
        Uri.Builder r6 = UriProtector.parse(r5).buildUpon();
        if (r7 == null) goto L22;
        Iterator<Map.Entry<String, Object>> r8 = r7.entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        Map.Entry<String, Object> r9 = r8.next();
        r6.appendQueryParameter(r9.getKey(), r9.getValue().toString());
    L22:
        String r10 = AnchorV4DataManager.d;
        if (r10 == null) goto L25;
        r6.appendQueryParameter("identifier", r10);
    L25:
        String r11 = r6.build().toString();
        l r12 = r19.a;
        int r15 = -2;
        if (r12 == null) goto L67;
        if (r19.b.length() <= 0) goto L30;
        boolean r1 = true;
    L31:
        if (r1 == true) goto L90;
    L46:
        r12.renderTemplate(r11, r7);
        View r13 = r12.getHybridView();
        if (r13 == null) goto L54;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L54;
        if (r14.height != (-2)) goto L54;
        r2 = true;
    L54:
        if (r2 == r20.getWrapContent()) goto L86;
        View r16 = r12.getHybridView();
        if (r16 == null) goto L86;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r20.getWrapContent() == true) goto L65;
        int r18 = r20.getHeight();
        if (r18 != null) goto L64;
        r18 = 60;
    L64:
        r15 = com.bytedance.android.shopping.extensions.b.b(r18);
    L65:
        r17.height = r15;
        Unit r23 = Unit.INSTANCE;
        r16.setLayoutParams(r17);
    L86:
        r19.b = r11;
        return;
    L90:
        Uri r24 = UriProtector.parse(r19.b);     // Catch: Exception -> L40
        Uri r25 = UriProtector.parse(r11);     // Catch: Exception -> L40
        if (Intrinsics.areEqual(r24.getScheme(), r25.getScheme()) == true) goto L36;
    L42:
        boolean r26 = false;
    L43:
        if (r26 == false) goto L46;
        if (r7 == null) goto L46;
        r12.updateData(r7);
        goto L86
    L36:
        if (Intrinsics.areEqual(r24.getAuthority(), r25.getAuthority()) == false) goto L42;
        if (Intrinsics.areEqual(r24.getPath(), r25.getPath()) == false) goto L42;
        r26 = true;
    L40:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L42
    L30:
        r1 = false;
        goto L31
    L67:
        if ((r19.getContext() instanceof Activity) == false) goto L69;
        Context r27 = r19.getContext();
    L72:
        l r28 = ECLiveHybridUtil.b(r27, r11, r7, null, new b(r7, r0), null, null, false, null, null, false, 4072);
        r19.a = r28;
        w.a.e(w.b, r28, r27, null, 12);
        if (r20.getWrapContent() == false) goto L75;
        int r110 = -2;
    L80:
        l r29 = r19.a;
        if (r29 == null) goto L85;
        View r30 = r29.getHybridView();
        if (r30 == null) goto L85;
        r19.addView(r30, new FrameLayout.LayoutParams(-1, r110));
    L85:
        Unit r31 = Unit.INSTANCE;
        goto L86
    L75:
        int r32 = r20.getHeight();
        if (r32 != null) goto L79;
        r32 = 60;
    L79:
        r110 = com.bytedance.android.shopping.extensions.b.b(r32);
        goto L80
    L69:
        Context r33 = r19.getContext();
        if (r33 == null) goto L88;
        r27 = ((ContextThemeWrapper) r33).getBaseContext();
        goto L72
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    L93:
        return;
    L13:
        r7 = null;
        goto L14
    L5:
        r0 = r21;
        goto L6
    }
}
