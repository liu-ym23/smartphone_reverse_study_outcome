package com.ss.android.ugc.tools;

import android.app.Application;
import com.google.gson.Gson;
import com.ss.android.ugc.tools.utils.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import xhc.a;
import xhc.b;

/* JADX INFO: loaded from: classes40.dex */
public final class CukaieManifest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f454795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f454796b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f454797c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f454798d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f454799e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CukaieManifest f454800f = null;

    static {
        f454795a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendContext", "getBackendContext()Landroid/app/Application;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendDebug", "getBackendDebug()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendGson", "getBackendGson()Lcom/google/gson/Gson;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendMob", "getBackendMob()Lcom/ss/android/ugc/tools/mob/IMob;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendMonitor", "getBackendMonitor()Lcom/ss/android/ugc/tools/monitor/IMonitor;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CukaieManifest.class, "backendLogger", "getBackendLogger()Lcom/ss/android/ugc/tools/utils/IToolsLogger;", 0))};
        f454800f = new CukaieManifest();
        f454796b = new a(CukaieManifest$backendContext$2.INSTANCE);
        f454797c = new a(CukaieManifest$backendDebug$2.INSTANCE);
        f454798d = new a(CukaieManifest$backendGson$2.INSTANCE);
        Intrinsics.checkNotNullParameter(CukaieManifest$backendMob$2.INSTANCE, "initializer");
        b r100 = b.f563918a;
        Intrinsics.checkNotNullParameter(CukaieManifest$backendMonitor$2.INSTANCE, "initializer");
        b r101 = b.f563918a;
        f454799e = new a(CukaieManifest$backendLogger$2.INSTANCE);
    }

    public CukaieManifest() {
    }

    public static final Application a() {
        CukaieManifest r100 = f454800f;
        r100.getClass();
        return (Application) f454796b.getValue(r100, f454795a[0]);
    }

    public static final Gson b() {
        CukaieManifest r100 = f454800f;
        r100.getClass();
        return (Gson) f454798d.getValue(r100, f454795a[2]);
    }

    public static final g c() {
        CukaieManifest r100 = f454800f;
        r100.getClass();
        return (g) f454799e.getValue(r100, f454795a[5]);
    }
}
