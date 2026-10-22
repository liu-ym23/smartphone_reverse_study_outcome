package com.bytedance.applet.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.AppletPayType;
import com.bytedance.ai.bridge.service.IHostPaymentDepend;
import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import com.bytedance.router.SmartRouter;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.TouristManager;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 implements IHostPaymentDepend {

    public static final class a {
    }

    public static final class b extends ClickableSpan {
        public final /* synthetic */ Context a;

        public b(Context r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            com.bytedance.router.i r5 = SmartRouter.buildRoute(this.a, "//flow/webview");
            Bundle r0 = new Bundle();
            Lazy r1 = com.larus.platform.service.l0.a;
            IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r2 == null) goto L5;
            r2.M();
            String r3 = "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html";
        L6:
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r0.putString("link_url", r3);
            r5.c.putExtras(r0);
            r5.d();
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r4) {
            Intrinsics.checkNotNullParameter(r4, "ds");
            r4.setUnderlineText(false);
            Context r0 = this.a;
            r4.setColor(ContextCompat.getColor(r0, v19.c.b(2130972079, r0, 2131103136)));
        }
    }

    public static final class c implements com.larus.login.api.b0 {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void a(DouYinBindStatus r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "status");
            if (r1 != DouYinBindStatus.ALREADY_BOUND) goto L5;
        L8:
            this.a.invoke(Boolean.TRUE);
            return;
        L5:
            if (r1 == DouYinBindStatus.SUCCESS) goto L8;
            this.a.invoke(Boolean.FALSE);
        }
    }

    static {
    }

    public g0() {
    }

    public static SpannableStringBuilder a(Context r5, String r6) {
        String r0 = ContextCompat.getString(r5, 2131906798);
        SpannableString r1 = new SpannableString(r0);
        r1.setSpan(new b(r5), 0, r0.length(), 33);
        r1.setSpan(new StyleSpan(1), 0, r0.length(), 33);
        SpannableStringBuilder r7 = new SpannableStringBuilder();
        r7.append(r6);
        r7.append(r1);
        return r7;
    }

    public final void openDyPay(final FragmentActivity r3, final String r4, final OnPayOrderResultCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "callback");
        new Handler(Looper.getMainLooper()).post(new c0(r3, r4, r5));
    }

    public final void preparePaymentAuthorization(FragmentActivity r25, Bundle r26, Map<String, ? extends Object> r27, Function1<? super Boolean, Unit> r28) {
        Intrinsics.checkNotNullParameter(r25, "activity");
        Intrinsics.checkNotNullParameter(r27, "traceInfo");
        Intrinsics.checkNotNullParameter(r28, "callback");
        if (TouristManager.a.f() == false) goto L6;
        r28.invoke(Boolean.FALSE);
        return;
    L6:
        Lazy r2 = CommonDouYinLoginKV.a;
        if (CommonDouYinLoginKV.b() == true) goto L9;
        com.larus.login.api.i r3 = new com.larus.login.api.i(2131239969, 2131239970, ContextCompat.getString(r25, 2131909266), a(r25, ContextCompat.getString(r25, 2131909261)), ContextCompat.getString(r25, 2131909258), null, false, null, null, false, 32672);
    L10:
        com.larus.login.api.i r10 = r3;
        com.larus.login.api.i r23 = new com.larus.login.api.i(2131239970, null, ContextCompat.getString(r25, 2131909267), a(r25, ContextCompat.getString(r25, 2131909262)), ContextCompat.getString(r25, 2131909260), ContextCompat.getString(r25, 2131909259), false, null, null, false, 32706);
        CommonDouYinLoginUtil r20 = CommonDouYinLoginUtil.a;
        if (r27.containsKey("widgetId") == false) goto L13;
        String r4 = "chat";
    L14:
        c r7 = new c(r28);
        if (r26 != null) goto L17;
        Bundle r9 = new Bundle();
    L18:
        com.larus.login.api.k0 r21 = new com.larus.login.api.k0(r25, r4, "doubao_apps_pay", null, false, false, r7, r27, r9, r10, r23, 500, new com.larus.login.api.d(false, 3), null, null, null, null, 122888);
        r20.getClass();
        CommonDouYinLoginUtil.s(r21);
        return;
    L17:
        r9 = r26;
        goto L18
    L13:
        r4 = "doubao_apps_detail";
        goto L14
    L9:
        r3 = null;
        goto L10
    }

    public final void createPayOrder(final FragmentActivity r19, final String r20, final AppletPayType r21, Map<String, ? extends Object> r22, final OnPayOrderResultCallback r23) {
        Intrinsics.checkNotNullParameter(r19, "activity");
        Intrinsics.checkNotNullParameter(r20, "data");
        Intrinsics.checkNotNullParameter(r21, "type");
        Intrinsics.checkNotNullParameter(r22, "traceInfo");
        Intrinsics.checkNotNullParameter(r23, "callback");
        Lazy r0 = CommonDouYinLoginKV.a;
        if (CommonDouYinLoginKV.b() == true) goto L5;
        com.larus.login.api.i r1 = new com.larus.login.api.i(2131239969, 2131239970, ContextCompat.getString(r19, 2131909266), a(r19, ContextCompat.getString(r19, 2131909261)), ContextCompat.getString(r19, 2131909258), null, false, null, null, false, 32672);
    L6:
        final com.larus.login.api.i r2 = r1;
        new Handler(Looper.getMainLooper()).post(new d0(r2, r23, r19, r20, r21));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
