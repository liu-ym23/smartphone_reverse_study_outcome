package com.bytedance.salamander.anniex;

import android.util.Pair;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class SLHybridSettingsFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a6 f267912a;

    public SLHybridSettingsFetcher(a6 r100) {
        Intrinsics.checkNotNullParameter(r100, "settingsConfig");
        this.f267912a = r100;
    }

    public final void b(final b6 r110) {
        StringBuilder r100 = new StringBuilder();
        a6 r101 = this.f267912a;
        a6 r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");
        r101 = null;
    L5:
        r100.append(r101.f267957b);
        r100.append("/monitor_web/settings/hybrid-settings");
        String r103 = r100.toString();
        final LinkedHashMap r104 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r104, "Content-Type", "application/json");
        BDNetworkTagManager r105 = BDNetworkTagManager.getInstance();
        if (r105 == null) goto L8;
        Pair<String, String> r106 = r105.buildBDNetworkTag(new com.bytedance.anniex.bd.foundation.impl.k());
    L9:
        if (r106 != null) goto L11;
    L15:
        LinkedHashMap r107 = new LinkedHashMap();
    L16:
        com.bytedance.rts.foundation.m.d(r107, new SLHybridSettingsFetcher$generateHeaders$1(r104));
        LinkedHashMap r108 = new LinkedHashMap();
        a6 r109 = this.f267912a;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");
    L20:
        com.bytedance.rts.foundation.m.e(r108, "aid", r102.f267956a);
        com.bytedance.rts.foundation.m.e(r108, "os", r102.f267958c);
        com.bytedance.rts.foundation.m.e(r108, "os_version", r102.f267959d);
        com.bytedance.rts.foundation.m.e(r108, "install_id", r102.f267960e);
        com.bytedance.rts.foundation.m.e(r108, "device_id", r102.f267961f);
        com.bytedance.rts.foundation.m.e(r108, "channel", r102.f267962g);
        com.bytedance.rts.foundation.m.e(r108, "version_code", r102.f267963h);
        com.bytedance.rts.foundation.m.e(r108, "update_version_code", r102.f267964i);
        com.bytedance.rts.foundation.m.e(r108, EffectConfiguration.KEY_REGION, r102.f267965j);
        com.bytedance.rts.foundation.m.e(r108, "language", r102.f267966k);
        com.bytedance.rts.foundation.m.e(r108, "device_model", r102.f267967l);
        com.bytedance.rts.foundation.m.e(r108, "sdk_version", r102.f267968m);
        com.bytedance.rts.foundation.m.e(r108, "device_brand", r102.f267969n);
        com.bytedance.anniex.bd.foundation.impl.f.f190143a.c(new lr3.c(r103, "POST", r104, r108, 12), new SLHybridSettingsFetcher$performFetch$1(r110));
        return;
    L19:
        r102 = r109;
        goto L20
    L11:
        if (r106.first == null) goto L15;
        if (r106.second == null) goto L15;
        r107 = new LinkedHashMap();
        Object r111 = r106.first;
        Intrinsics.checkNotNull(r111);
        Object r112 = r106.second;
        Intrinsics.checkNotNull(r112);
        com.bytedance.rts.foundation.m.e(r107, r111, r112);
        goto L16
    L8:
        r106 = null;
        goto L9
    }

    public final void a(Function1<? super JSONObject, Unit> r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onSuccess");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        b6 r102 = new b6(r100, r101);
        b(r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Function1<? super Throwable, Unit> r103 = r102.f267985b;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.foundation.RTSErrorKt.RTSError }");
        r103.invoke(th);
    }
}
