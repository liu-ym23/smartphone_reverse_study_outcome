package com.ss.android.lark.audio;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audio.config.ChangeModeConfig;
import com.ss.android.lark.audio.config.DeviceMatcher;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final boolean a() {
        ChangeModeConfig r100 = (ChangeModeConfig) SettingManager.getInstance().get(ChangeModeConfig.class);
        boolean r101 = false;
        if (r100 != null) goto L6;
        Log.w("ChangeModeUtil", "playerConfig == null");
        return false;
    L6:
        List<com.ss.android.lark.audio.config.a> r102 = r100.a();
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        List r103 = CollectionsKt.filterNotNull(r102);
        if (r103.isEmpty() == false) goto L13;
        Log.w("ChangeModeUtil", "devices is empty");
        return false;
    L13:
        DeviceMatcher r104 = new DeviceMatcher();
        List r105 = r103;
        if ((r105 instanceof Collection) == true) goto L16;
    L18:
        Iterator r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L52;
        com.ss.android.lark.audio.config.a r107 = (com.ss.android.lark.audio.config.a) r106.next();
        Intrinsics.checkNotNullParameter(r107, "device");
        Map<String, String> r108 = r107.a();
        if (r108 != null) goto L24;
    L27:
        boolean r109 = true;
    L29:
        if (r109 == false) goto L32;
        Log.w("DeviceMatcher", "invalid device config");
    L31:
        boolean r110 = false;
    L50:
        if (r110 == false) goto L20;
        r101 = true;
        goto L52
    L32:
        Iterator<Map.Entry<String, String>> r111 = r108.entrySet().iterator();
    L34:
        if (r111.hasNext() == false) goto L49;
        Map.Entry<String, String> r112 = r111.next();
        String r113 = r112.getKey();
        String r114 = r112.getValue();
        Function1<String, Boolean> r115 = r104.f408971a.get(r113);
        if (r115 == null) goto L37;
        if (r114 != null) goto L40;
    L43:
        boolean r116 = true;
    L44:
        if (r116 == true) goto L45;
        if (r115.invoke(r114).booleanValue() == true) goto L34;
    L45:
        Log.w("DeviceMatcher", "property value is empty for key:" + r113);
        goto L31
    L40:
        if (r114.length() == 0) goto L43;
        r116 = false;
        goto L44
    L37:
        Log.w("DeviceMatcher", "unsupported property:" + r113);
        goto L31
    L49:
        r110 = true;
        goto L50
    L24:
        if (r108.isEmpty() == true) goto L27;
        r109 = false;
    L52:
        Log.i("ChangeModeUtil", "shouldReduceChangeMode:" + r101);
        return r101;
    L16:
        if (r105.isEmpty() == false) goto L18;
        goto L18
    }
}
