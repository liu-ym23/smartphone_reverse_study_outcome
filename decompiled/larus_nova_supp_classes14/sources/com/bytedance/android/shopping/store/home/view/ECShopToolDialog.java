package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopToolDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopToolDialog extends BottomSheetDialog {
    public ViewGroup a;
    public final ECStoreViewModel b;
    public final b c;
    public final List<com.bytedance.android.ec.model.h> d;

    public static final class a {
    }

    public static final class b {
        public String a;
        public String b;

        public b() {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ECShopToolDialog a;

        public c(ECShopToolDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.shopping.store.home.view.ECShopToolDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        ad.a.a(this, null);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        ad.a.b(this);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static View I0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int J0(int r3) {
        Resources r0 = th.a.e(getContext(), true).getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public final void onCreate(Bundle r17) {
        super.onCreate(r17);
        int r1 = ad.a.a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.l(this, "a1.b6269", false);
        Window r2 = getWindow();
        if (r2 == null) goto L5;
        r2.clearFlags(67108864);
        r2.addFlags(Integer.MIN_VALUE);
        I0(r2).setSystemUiVisibility(I0(r2).getSystemUiVisibility() | 1280);
        r2.setStatusBarColor(0);
    L5:
        ImageView r3 = (ImageView) findViewById(2131370865);
        if (r3 == null) goto L8;
        r3.setOnClickListener(new c(this));
    L8:
        this.a = (ViewGroup) findViewById(2131370855);
        b r4 = this.c;
        String r5 = r4.b;
        int r6 = 1;
        if (r5 != null) goto L11;
    L14:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L32;
        String r8 = r4.a;
        if (r8 != null) goto L20;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == true) goto L32;
        if (Intrinsics.areEqual(r4.b, "\"null\"") == true) goto L32;
        ViewGroup r10 = this.a;
        if (r10 == null) goto L35;
        ECLynxCard r11 = new ECLynxCard();
        r10.setVisibility(0);
        Map<String, Object> r12 = this.b.getMetaInfo(null);
        JsonObject r13 = new JsonObject();
        r13.addProperty("coupon_data", r4.b);
        Context r14 = getContext();
        String r15 = r4.a;
        Intrinsics.checkNotNull(r15);
        ECLynxLoadParam.a r16 = new ECLynxLoadParam.a(r14, r15, r10);
        r16.j(2000);
        r16.j = com.bytedance.android.ec.hybrid.list.util.k.d(r13);
        d r18 = new d(r11);
        Intrinsics.checkNotNullParameter(r18, "lifecycle");
        r16.o = r18;
        r16.h(this.b.getSceneId());
        r16.e(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("meta_info", MapsKt.toMap(r12))}));
        r11.j(new ECLynxLoadParam(r16));
    L35:
        LinearLayout r19 = (LinearLayout) findViewById(2131370856);
        Iterator<T> r20 = this.d.iterator();
        int r21 = 0;
    L37:
        if (r20.hasNext() == false) goto L65;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        com.bytedance.android.ec.model.h r24 = (com.bytedance.android.ec.model.h) r22;
        if (r19 == null) goto L44;
        LinearLayout r25 = new LinearLayout(getContext());
        r25.setOrientation(r6);
        r25.setGravity(16);
        r25.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Configuration r110 = new Configuration(r25.getContext().getResources().getConfiguration());
        r110.uiMode = 16 | (r110.uiMode & (-49));
        Context r111 = r25.getContext().createConfigurationContext(r110);
        NewMiraResourcesManager.getInstance().install(r111);
        ImageView r112 = new ImageView(r111);
        r112.setImageResource(r24.b);
        r112.setLayoutParams(new LinearLayout.LayoutParams(J0(48), J0(48)));
        r25.addView(r112);
        TextView r113 = new TextView(th.a.e(r25.getContext(), r6));
        r113.setText(r24.d);
        r113.setTextSize(11.0f);
        r113.setGravity(r6);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-1, -2);
        r114.topMargin = J0(10);
        Unit r115 = Unit.INSTANCE;
        r113.setLayoutParams(r114);
        r113.setTextColor(th.a.e(r113.getContext(), r6).getResources().getColor(2131105610));
        r25.addView(r113);
        r25.setOnClickListener(new com.bytedance.android.shopping.store.home.view.c(this, r24));
        r19.addView(r25);
    L44:
        Map r26 = BtmSDK.INSTANCE.createReportParams("a1.b6269.c25145.d289907", PageFinder.via(r19));
        ArrayList r116 = new ArrayList(r26.size());
        Iterator r27 = r26.entrySet().iterator();
    L46:
        if (r27.hasNext() == false) goto L48;
        Map.Entry r117 = (Map.Entry) r27.next();
        r116.add(TuplesKt.to(r117.getKey(), String.valueOf(r117.getValue())));
        goto L46
    L48:
        Map<String, String> r28 = MapsKt.toMap(r116);
        ECStoreViewModel r118 = this.b;
        Pair<String, String>[] r119 = new Pair[r6];
        ToolType.a r120 = ToolType.Companion;
        int r29 = r24.getType();
        r120.getClass();
        ToolType[] r121 = ToolType.values();
        int r122 = r121.length;
        int r123 = 0;
    L49:
        if (r123 >= r122) goto L57;
        ToolType r124 = r121[r123];
        if (r124.getType() != r29) goto L53;
        boolean r30 = true;
    L54:
        if (r30 == true) goto L58;
        r123 = r123 + 1;
    L58:
        if (r124 != null) goto L60;
        r124 = ToolType.UNKNOWN;
    L60:
        r119[0] = TuplesKt.to("entry_name", f.a(r124));
        r118.doEventAction("shop_tools_panel_entrance_show", r28, r119);
        if (r21 == CollectionsKt.getLastIndex(this.d)) goto L64;
        if (r19 == null) goto L64;
        Space r31 = new Space(getContext());
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(J0(0), J0(0));
        r32.weight = 1.0f;
        Unit r33 = Unit.INSTANCE;
        r31.setLayoutParams(r32);
        r19.addView(r31);
    L64:
        r21 = r23;
        r6 = 1;
        goto L37
    L53:
        r30 = false;
        goto L54
    L57:
        r124 = null;
        goto L58
    L65:
        return;
    L20:
        if (r8.length() == 0) goto L23;
        r9 = false;
    L32:
        ViewGroup r34 = this.a;
        if (r34 == null) goto L35;
        r34.setVisibility(8);
        goto L35
    L11:
        if (r5.length() == 0) goto L14;
        r7 = false;
        goto L16
    }

    public ECShopToolDialog(Context r2, ECStoreViewModel r3, b r4, List<com.bytedance.android.ec.model.h> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "couponData");
        Intrinsics.checkNotNullParameter(r5, "entryList");
        super(r2, 2131953787);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        setContentView(2131560847);
        setCancelable(true);
    }
}
