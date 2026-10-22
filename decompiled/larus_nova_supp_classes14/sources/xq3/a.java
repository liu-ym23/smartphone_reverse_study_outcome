package xq3;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.h0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.window.api.IECWindowService;
import com.bytedance.android.ec.window.base.preload.WindowDomainPreloadConfig;
import com.bytedance.android.ec.window.base.setting.ECWindowSettings;
import com.bytedance.android.window.shop.innerflow.c;
import com.bytedance.android.window.shop.prefetch.ECWindowNetPreLoadManager;
import com.bytedance.android.window.shop.router.ECWindowRouter;
import com.bytedance.android.window.shop.search.router.ECWindowSearchRouter;
import com.google.gson.JsonElement;
import java.util.Iterator;
import java.util.List;
import jj4.b;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements IECWindowService {
    public final void onStoreEntranceShow() {
        ECWindowNetPreLoadManager r0 = (ECWindowNetPreLoadManager) ECWindowNetPreLoadManager.b.getValue();
        r0.getClass();
        if ((System.currentTimeMillis() - r0.a) <= 90000) goto L30;
        r0.a = System.currentTimeMillis();
        Lazy r1 = ECWindowSettings.a;
        int r2 = p.a;
        Unit r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        b r5 = b.b;     // Catch: Throwable -> L7
        Object r6 = jj4.a.a("ec_shop_domain_preload_config", JsonElement.class, null, false);     // Catch: Throwable -> L7
    L11:
        JsonElement r7 = (JsonElement) r6;
        if (r7 == null) goto L31;
        int r8 = t0.a;     // Catch: Throwable -> L22
        List r9 = ((WindowDomainPreloadConfig) t0.a.a.fromJson(r7, WindowDomainPreloadConfig.class)).getShopCoreHost();     // Catch: Throwable -> L22
        if (r9 == null) goto L20;
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L22
    L17:
        if (r10.hasNext() == false) goto L19;
        h0.a((String) r10.next());     // Catch: Throwable -> L22
        goto L17
    L19:
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.constructor-impl(r3);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L31:
        return;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == false) goto L11;
        r6 = null;
        goto L11
    }

    public a() {
        bf.a.a(new ECWindowRouter());
        bf.a.a(new ECWindowSearchRouter());
        bf.a.a(new c());
    }
}
