package com.bytedance.geckox;

import android.content.Context;
import android.util.Log;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.n;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f245076a = null;

        static {
            f245076a = new b();
        }
    }

    public b() {
    }

    public static GeckoGlobalConfig a() {
        GlobalManager.f250642k.a();
        return GlobalManager.f250638g;
    }

    public static GlobalConfigSettings b() {
        GlobalManager.f250642k.a();
        if (GlobalManager.f250634c.get() == true) goto L7;
        return null;
    L7:
        return GlobalSettingsManager.f250833a;
    }

    public static boolean c() {
        GlobalManager.f250642k.a();
        if (GlobalManager.f250634c.get() == false) goto L5;
        GlobalConfigSettings r100 = GlobalSettingsManager.f250833a;
    L6:
        if (r100 == null) goto L17;
        GlobalConfigSettings.ReqMeta r101 = r100.getReqMeta$geckox_noasanRelease();
        if (r101 == null) goto L17;
        if (GlobalManager.f250639h == true) goto L12;
    L14:
        boolean r102 = false;
    L15:
        GlobalManager.f250639h = r102;
        goto L17
    L12:
        if (r101.getEnable() == false) goto L14;
        r102 = true;
    L17:
        return GlobalManager.f250639h;
    L5:
        r100 = null;
        goto L6
    }

    public Context getContext() {
        return GlobalManager.f250642k.getContext();
    }

    public static void e(IGeckoRegister r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        GlobalManager.f250642k.a();
        if (GlobalManager.f250634c.get() == true) goto L7;
        GeckoLogger.d("register gecko,global gecko has not been initialized");
        ((CopyOnWriteArrayList) n.f250677c).add(r100);
        return;
    L7:
        n.b(r100, true);
    }

    public static void d(String r100, String r101) {
        GlobalManager r102 = GlobalManager.f250642k;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L38:
        GeckoLogger.w("gecko register failed, accessKey: " + r100 + ", root dir: " + r101);
        return;
    L8:
        if (r101.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L38;
        if (AppSettingsManager.b.f245071a.a() == false) goto L19;
        r102.a();
        if (GlobalManager.f250638g != null) goto L18;
        GeckoLogger.d("globalConfig is null when tryMigrateRes, cache accessKey: " + r100 + ", dir: " + r101);
        ((ConcurrentHashMap) GlobalManager.f250636e).put(r100, r101);
        return;
    L18:
        GlobalManager.e(r100, r101);
        return;
    L19:
        ConcurrentHashMap r105 = (ConcurrentHashMap) GlobalManager.f250635d;
        String r106 = (String) r105.get(r100);
        if (r106 != null) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == false) goto L36;
        r105.put(r100, r101);
        if (GlobalManager.f250633b.get() == false) goto L30;
        com.bytedance.iesgurd.meta.a.d(r100, r101);
    L30:
        GeckoLogger.d("gecko register root dir, accessKey:" + r100 + ", root dir:" + r101);
        GeckoGlobalConfig r108 = GlobalManager.f250638g;
        if (r108 != null) goto L33;
        return;
    L33:
        if (StringsKt.startsWith$default(r101, r108.getContext().getFilesDir().getAbsolutePath(), false, 2, null) == true) goto L43;
        EventSubType r109 = EventSubType.EXTERNAL_DIR;
        JSONObject r110 = new JSONObject();
        r110.put("sub_type", r109.getType());
        r110.put("access_key", r100);
        r110.put("extra", r101);
        y86.a.c("geckosdk_event_message", r110);
        return;
    L43:
        return;
    L36:
        if ((!Intrinsics.areEqual(r106, r101)) == false) goto L45;
        String r111 = "oldPath: " + r106 + ", newPath: " + r101 + ", stackTrace: " + Log.getStackTraceString(new Throwable());
        GeckoLogger.d("registerAccessKey2Dir error for ak: " + r100 + ", " + r111);
        int r112 = y86.a.f566911a;
        y86.a.a(EventSubType.DIFFERENT_PATH_FOR_AK, r111, r100);
        return;
    L45:
        return;
    L22:
        if (r106.length() == 0) goto L25;
        r107 = false;
        goto L26
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }
}
