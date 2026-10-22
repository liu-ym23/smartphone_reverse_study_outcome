package com.larus.shortcuts.impl.dynamic;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.platform.service.AccountService;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes31.dex */
public final class DynamicShortcutsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f369229a = 0;

    static {
    }

    public static void a() {
        FLogger.f375446a.e("DynamicShortcutsManager", "clear shortcut");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DynamicShortcutsManager$clearShortcuts$1(null), 3, null);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static ShortcutInfo b(tw9.a r100) {
        if (r100.f() != null) goto L8;
        if (r100.f547801a != null) goto L8;
        return null;
    L8:
        if (r100.d() != null) goto L10;
    L24:
        return null;
    L10:
        if (r100.c() == null) goto L24;
        if (r100.g() == null) goto L24;
        AppHost.Companion r101 = AppHost.f326268a;
        Context r102 = r101.getApplication().getApplicationContext();
        HomeService r103 = HomeService.f344094a;
        Intrinsics.checkNotNull(r102);
        String r104 = r103.A(r102);
        if (r104 != null) goto L17;
        return null;
    L17:
        ShortcutInfo.Builder r105 = new ShortcutInfo.Builder(r102, r100.b()).setActivity(new ComponentName(r102.getPackageName(), r104));
        String r106 = r100.d();
        Intrinsics.checkNotNull(r106);
        ShortcutInfo.Builder r107 = r105.setShortLabel(r106);
        String r108 = r100.c();
        Intrinsics.checkNotNull(r108);
        ShortcutInfo.Builder r109 = r107.setLongLabel(r108).setRank(r100.e());
        Integer r110 = r100.f();
        if (r110 == null) goto L21;
        int r111 = r110.intValue();
        Icon r112 = Icon.createWithResource(r101.getApplication(), r111);
        if (r112 == null) goto L21;
    L22:
        ShortcutInfo.Builder r113 = r109.setIcon(r112);
        int r114 = ShortcutCommonUtil.f369227a;
        String r115 = r100.g();
        Intrinsics.checkNotNull(r115);
        return r113.setIntent(ShortcutCommonUtil.b(r115)).build();
    L21:
        r112 = Icon.createWithBitmap(r100.f547801a);
        goto L22
    }

    public static void c(List r100) {
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L6;
        FLogger.f375446a.i("DynamicShortcutsManager", "real set up shortcut error, no login");
        return;
    L6:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("real set up shortcut, count = ");
        ArrayList r103 = (ArrayList) r100;
        r102.append(r103.size());
        r101.i("DynamicShortcutsManager", r102.toString());
        if (r103.size() != 0) goto L16;
        a();
        return;
    L16:
        ShortcutManager r104 = (ShortcutManager) AppHost.f326268a.getApplication().getApplicationContext().getSystemService("shortcut");     // Catch: Exception -> L12
        if (r104 == null) goto L18;
        r104.setDynamicShortcuts(r100);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("DynamicShortcutsManager", "setup shortcut exception: " + e.getMessage());
    }
}
