package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.ECMallBtmTipDialog;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static void b(Context r2, boolean r3) {
        HybridAppInfoService r0 = HybridAppInfoService.p;
        if (HybridAppInfoService.h() == false) goto L17;
        if (r3 == false) goto L18;
        l.a.getClass();
        if (r0.isLocalTest() == false) goto L19;
        if (r2 == null) goto L20;
        AppCompatDialog r4 = new ECMallBtmTipDialog(r2);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static String a(String r10, Map r11, PageFinder r12, Context r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "scheme");
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r12, "pageFinder");
        boolean r2 = true;
        Uri r4 = null;
        String r5 = null;
        Uri r6 = UriProtector.parse(r10);     // Catch: Exception -> L30
        JSONObject r7 = new JSONObject(r11);     // Catch: Exception -> L43
        JSONObject r8 = r7.optJSONObject("bcm");     // Catch: Exception -> L43
        String r9 = r7.optString("btm");     // Catch: Exception -> L43
        if (r9 != null) goto L7;
    L10:
        boolean r15 = true;
    L11:
        if (r15 == false) goto L13;
    L27:
        Logger.d("puffone-BtmOpenSchemeHelper.appendBtmToken()", "btm is empty");     // Catch: Exception -> L43
        b(r13, r14);     // Catch: Exception -> L43
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r10, null, r11));     // Catch: Exception -> L43
        return r10;
    L13:
        if (Intrinsics.areEqual(r9, "null") == true) goto L27;
        BtmSDK r16 = BtmSDK.INSTANCE;     // Catch: Exception -> L43
        BcmParams.Companion.getClass();     // Catch: Exception -> L43
        String r17 = r16.createJumpSourceBtmToken(r9, r12, BcmParams.a.b(r8));     // Catch: Exception -> L43
        if (r17 != null) goto L44;
    L21:
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
        b(r13, r14);     // Catch: Exception -> L26
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r10, r17, r11));     // Catch: Exception -> L26
    L24:
        Logger.d("puffone-BtmOpenSchemeHelper.appendBtmToken()", "token:" + r17);     // Catch: Exception -> L26
    L32:
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r10, r17, r11));
        if (r6 == null) goto L49;
        if (r17 != null) goto L36;
    L39:
        if (r2 == false) goto L42;
        return r10;
    L42:
        return r6.buildUpon().appendQueryParameter("source_btm_token", r17).build().toString();
    L36:
        if (r17.length() == 0) goto L39;
        r2 = false;
        goto L39
    L49:
        return r10;
    L26:
        r5 = r17;
        goto L29
    L44:
        if (r17.length() == 0) goto L21;
        r18 = false;
        goto L22
    L7:
        if (r9.length() == 0) goto L10;
        r15 = false;
    L29:
        r17 = r5;
        r4 = r6;
    L31:
        Logger.d("puffone-BtmOpenSchemeHelper.appendBtmToken()", "handle btm token error");
        r6 = r4;
    L30:
        r17 = null;
        goto L31
    }
}
