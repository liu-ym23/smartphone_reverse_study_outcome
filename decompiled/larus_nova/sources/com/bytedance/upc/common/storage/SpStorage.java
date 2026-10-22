package com.bytedance.upc.common.storage;

import android.content.SharedPreferences;
import android.util.Log;
import ip7.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class SpStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f272469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f272470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f272471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<a> f272472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SpStorage f272473e = null;

    public interface a {
        boolean onUpdate();
    }

    public SpStorage() {
    }

    static {
        f272473e = new SpStorage();
        f272469a = LazyKt.lazy(SpStorage$mContext$2.INSTANCE);
        f272470b = LazyKt.lazy(SpStorage$mSettingsSpStorage$2.INSTANCE);
        f272471c = LazyKt.lazy(SpStorage$mPrivacySpStorage$2.INSTANCE);
        f272472d = new ArrayList();
    }

    public static void a(String r100, long r101) {
        Lazy r102 = f272471c;
        if (((SharedPreferences) r102.getValue()) != null) goto L5;
    L8:
        boolean r103 = b.f495310a;
        boolean r104 = false;
    L9:
        if (r104 == true) goto L33;
        return;
    L33:
    L30:
        th = move-exception;
        Log.getStackTraceString(th);
        boolean r105 = b.f495310a;
        return;
    L12:
        if (Intrinsics.areEqual("upc_sdk_settings", "upc_sdk_privacy") == false) goto L21;
        SharedPreferences r106 = (SharedPreferences) r102.getValue();     // Catch: Throwable -> L30
        if (r106 == null) goto L34;
        SharedPreferences.Editor r107 = r106.edit();     // Catch: Throwable -> L30
        if (r107 == null) goto L35;
        SharedPreferences.Editor r108 = r107.putLong(r100, r101);     // Catch: Throwable -> L30
        if (r108 == null) goto L36;
        r108.commit();     // Catch: Throwable -> L30
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        if (Intrinsics.areEqual("upc_sdk_settings", "upc_sdk_settings") == false) goto L38;
        SharedPreferences r109 = (SharedPreferences) f272470b.getValue();     // Catch: Throwable -> L30
        if (r109 == null) goto L39;
        SharedPreferences.Editor r110 = r109.edit();     // Catch: Throwable -> L30
        if (r110 == null) goto L40;
        SharedPreferences.Editor r111 = r110.putLong(r100, r101);     // Catch: Throwable -> L30
        if (r111 == null) goto L41;
        r111.commit();     // Catch: Throwable -> L30
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L5:
        if (((SharedPreferences) f272470b.getValue()) == null) goto L8;
        r104 = true;
        goto L9
    }
}
