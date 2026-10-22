package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.content.Context;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.helper.AosEnterDyPlayerToastHelper;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AccountUsageHintHelper {
    public static final Lazy a = null;

    public AccountUsageHintHelper() {
    }

    static {
        a = LazyKt.lazy(AccountUsageHintHelper$useInteractionHint$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static void b(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "ctx");
        AoLogger.g("AccountUsageHintHelper", new Object[]{"tryShowInteractionAccountUsageHint call"});
        if (a() == true) goto L5;
    L37:
        AoLogger.c("AccountUsageHintHelper", new Object[]{"setting disable for interaction hint, skip. hint=" + a()});
        return;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f == true) goto L37;
        d14.a r1 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r2 = b14.a.a(k34.b.class).getAccessToken();
        if (r2 == null) goto L10;
        String r4 = r2.b;
    L11:
        if (r4 != null) goto L13;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L21;
        AoLogger.c("AccountUsageHintHelper", new Object[]{"no openid, skip"});
        return;
    L21:
        String r3 = p0.a(r2.c);
        if (r3 != null) goto L24;
    L27:
        boolean r6 = true;
    L28:
        if (r6 == false) goto L30;
        AoLogger.c("AccountUsageHintHelper", new Object[]{"no name, skip"});
        return;
    L30:
        ConcurrentHashMap r7 = FrequencyLimitationUtils.a;
        FrequencyLimitationUtils.b r8 = FrequencyLimitationUtils.a("account_usage_" + r4, 1);
        if (r8.getCount() < 1) goto L33;
        AoLogger.c("AccountUsageHintHelper", new Object[]{"account usage hint displayed, skip"});
        return;
    L33:
        FrequencyLimitationUtils.b r9 = FrequencyLimitationUtils.a("interaction_hint_" + r4, 0);
        if (r9.getCount() < 1) goto L36;
        AoLogger.c("AccountUsageHintHelper", new Object[]{"account usage hint while interaction displayed, skip"});
        return;
    L36:
        ToastUtils.d(r11, y54.a.a().getString(2131894136, new Object[]{r3}), 0, new ToastUtils.a());
        r8.a();
        r9.a();
        return;
    L24:
        if (r3.length() == 0) goto L27;
        r6 = false;
        goto L28
    L13:
        if (r4.length() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 != true) goto L18;
        r5 = true;
        goto L19
    L15:
        r10 = false;
        goto L16
    L10:
        r4 = null;
        goto L11
    }

    public static void c(Activity r4) {
        boolean r0 = true;
        AoLogger.g("AccountUsageHintHelper", new Object[]{"tryShowPlayerAccountUsageHint call"});
        if (a() == false) goto L5;
    L19:
        AoLogger.c("AccountUsageHintHelper", new Object[]{"setting enable for interaction hint, skip. hint=" + a()});
        return;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f == true) goto L19;
        Lazy r1 = AosEnterDyPlayerToastHelper.a;
        d14.a r2 = b14.a.a;
        if (b14.a.a(k34.b.class).isLogin() == false) goto L23;
        com.bytedance.awemeopen.bizmodels.user.c r3 = b14.a.a(k34.b.class).getAccessToken();
        Intrinsics.checkNotNull(r3);
        String r5 = r3.c;
        if (r5 != null) goto L13;
    L16:
        if (r0 == false) goto L18;
        b14.a.a(k34.b.class).u(new com.bytedance.awemeopen.apps.framework.framework.viewpager.helper.a(r4));
        return;
    L18:
        AosEnterDyPlayerToastHelper.a(r4, r5);
        return;
    L13:
        if (r5.length() == 0) goto L16;
        r0 = false;
        goto L16
    }
}
