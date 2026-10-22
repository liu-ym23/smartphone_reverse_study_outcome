package com.bytedance.upc.common.settings;

import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.upc.common.storage.SpStorage;
import ip7.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class UpcOnlineSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f272468a = null;

    static {
        f272468a = LazyKt.lazy(UpcOnlineSettings$mSp$2.INSTANCE);
    }

    public static void a(String r100) {
        ((SpStorage) f272468a.getValue()).getClass();
        if (((SharedPreferences) SpStorage.f272471c.getValue()) != null) goto L5;
    L8:
        boolean r101 = b.f495310a;
        boolean r102 = false;
    L9:
        if (r102 == false) goto L47;
        Iterator r103 = ((ArrayList) SpStorage.f272472d).iterator();     // Catch: Throwable -> L39
    L13:
        if (r103.hasNext() == false) goto L43;
        ((SpStorage.a) r103.next()).onUpdate();     // Catch: Throwable -> L39
    L43:
    L36:
        th = move-exception;
        Log.getStackTraceString(th);
        boolean r104 = b.f495310a;
        return;
    L18:
        if (Intrinsics.areEqual("upc_sdk_settings", "upc_sdk_privacy") == false) goto L27;
        SharedPreferences r105 = (SharedPreferences) SpStorage.f272471c.getValue();     // Catch: Throwable -> L36
        if (r105 == null) goto L42;
        SharedPreferences.Editor r106 = r105.edit();     // Catch: Throwable -> L36
        if (r106 == null) goto L42;
        SharedPreferences.Editor r107 = r106.putString("upc_helios_settings", r100);     // Catch: Throwable -> L36
        if (r107 == null) goto L42;
        r107.commit();     // Catch: Throwable -> L36
    L42:
        return;
    L27:
        if (Intrinsics.areEqual("upc_sdk_settings", "upc_sdk_settings") == false) goto L42;
        SharedPreferences r108 = (SharedPreferences) SpStorage.f272470b.getValue();     // Catch: Throwable -> L36
        if (r108 == null) goto L42;
        SharedPreferences.Editor r109 = r108.edit();     // Catch: Throwable -> L36
        if (r109 == null) goto L42;
        SharedPreferences.Editor r110 = r109.putString("upc_helios_settings", r100);     // Catch: Throwable -> L36
        if (r110 == null) goto L42;
        r110.commit();     // Catch: Throwable -> L36
        goto L42
    L47:
        return;
    L5:
        if (((SharedPreferences) SpStorage.f272470b.getValue()) == null) goto L8;
        r102 = true;
        goto L9
    }
}
