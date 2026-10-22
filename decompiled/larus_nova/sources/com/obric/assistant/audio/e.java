package com.obric.assistant.audio;

import android.media.AudioManager;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f385649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f385650b = null;

    static {
        f385649a = LazyKt.lazy(new d());
        f385650b = SetsKt.setOf(new String[]{"com.qti.phone", "com.android.phone", "com.android.server.telecom"});
    }

    public static Object a() {
        Lazy r100 = f385649a;
        if (((AudioManager) r100.getValue()) != null) goto L6;
        return null;
    L6:
        Method r101 = AudioManager.class.getMethod("getCurrentAudioFocusOwner", new Class[0]);
        r101.setAccessible(true);
        return r101.invoke((AudioManager) r100.getValue(), new Object[0]);
    }

    public static String b() {
        FLogger.f375446a.i("CurrentAudioFocusManager", "getCurrentFocusOwner");
        Object r100 = "";
        if (d() == true) goto L19;
        return "";
    L19:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Object r102 = a();     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        String r103 = "";
    L9:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L16;
        r100 = r104;
    L18:
        return (String) r100;
    L16:
        FLogger.f375446a.i("CurrentAudioFocusManager", "getCurrentFocusOwner error: " + r105.getMessage());
        goto L18
    L8:
        r103 = c(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean d() {
        AudioManager.class.getMethod("getCurrentAudioFocusOwner", new Class[0]);     // Catch: Exception -> L5
        FLogger.f375446a.i("CurrentAudioFocusManager", "isCustomRomSupported: true");     // Catch: Exception -> L5
        return true;
    L5:
        FLogger.f375446a.i("CurrentAudioFocusManager", "isCustomRomSupported: false");
        return false;
    }

    public static String c(Object r100) {
        Method r101 = r100.getClass().getMethod("getPackageName", new Class[0]);
        r101.setAccessible(true);
        Object r102 = r101.invoke(r100, new Object[0]);
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        FLogger.f375446a.i("CurrentAudioFocusManager", "getPackageName: ".concat(r103));
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
