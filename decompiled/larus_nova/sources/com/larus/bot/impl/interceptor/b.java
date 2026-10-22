package com.larus.bot.impl.interceptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f319351a = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        String r103 = null;
        if (r100 == null) goto L7;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L7;
        String r105 = r104.getAuthority();
    L8:
        r102.append(r105);
        r101.d("BotUpdateRouterInterceptor", r102.toString());
        int r106 = k0.f375428a;
        if (r100 == null) goto L13;
        Uri r107 = r100.f267530d;
        if (r107 == null) goto L13;
        String r108 = r107.toString();
    L15:
        if (Intrinsics.areEqual(k0.a(r108), "//flow/bot_update") == false) goto L23;
        if (r100 == null) goto L21;
        Uri r109 = r100.f267530d;
        if (r109 == null) goto L21;
        r103 = UriProtector.getQueryParameter(r109, "show_image_guide");
    L21:
        if (Intrinsics.areEqual(r103, "true") == false) goto L23;
        return true;
    L23:
        return false;
    L13:
        r108 = null;
    L7:
        r105 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        String r112 = null;
        if (r111 == null) goto L7;
        Intent r113 = r111.f267528b;
        if (r113 == null) goto L7;
        Bundle r114 = r113.getExtras();
    L8:
        FLogger.f375446a.d("BotUpdateRouterInterceptor", "handleBotUpdate}");
        if (r114 == null) goto L11;
        r112 = r114.getString("bot_id");
    L11:
        String r100 = r112;
        if (o0.d(r100) == false) goto L19;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L20;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new BotUpdateRouterInterceptor$handleBotUpdate$1(this, r100, r101, new l0(r101, 0.0f, false, 6), null), 2, null);
        return true;
    L20:
        return true;
    L19:
        return true;
    L7:
        r114 = null;
        goto L8
    }
}
