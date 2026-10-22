package com.bytedance.android.shopping.hybrid.bridges;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECShopSharedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSharedMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECShopSharedMethod() {
        this.e = "shareShop";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r5 = r10.optString("uid", "");
        String r6 = r10.optString("sec_uid", "");
        String r8 = r10.optString("nickname", "");
        String r12 = r10.optString("avatar_medium", "");
        if (r5 == null) goto L20;
        if (r6 == null) goto L20;
        if (r8 == null) goto L20;
        if (r12 == null) goto L20;
        ECUrlModel r7 = new ECUrlModel();
        r7.setUrlList(CollectionsKt.listOf(r12));
        Activity r3 = ECAppInfoService.e.getCurrentActivity();
        if (r3 == null) goto L17;
        Window r13 = r3.getWindow();
        if (r13 == null) goto L17;
        View r14 = r13.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r15 = ThreadMethodProxy.currentThread();
        if (r15 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r15, "getDecorView");
    L18:
        View r4 = r14;
        ih3.f r2 = ih3.f.b;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r4);
        r2.c(r3, r4, r5, r6, r7, r8);
        return;
    L17:
        r14 = null;
    L20:
        JSONObject r16 = new JSONObject();
        r16.put("code", 0);
        Unit r0 = Unit.INSTANCE;
        r11.a(r16);
    }
}
