package com.ss.android.lark.im.sdk;

import com.ss.android.lark.log.Log;
import ikb.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import okb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f425895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f425896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f425897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f425898d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f425899e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f425900f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f425901g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f425902h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f425903i = null;

    public ImSdkProxy() {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f425896b = LazyKt.lazy(r100, ImSdkProxy$innerAppProxy$2.INSTANCE);
        f425897c = LazyKt.lazy(r100, ImSdkProxy$innerConfigProxy$2.INSTANCE);
        f425898d = LazyKt.lazy(r100, ImSdkProxy$innerUserProxy$2.INSTANCE);
        f425899e = LazyKt.lazy(r100, ImSdkProxy$innerImageProxy$2.INSTANCE);
        f425900f = LazyKt.lazy(r100, ImSdkProxy$innerOpenProxy$2.INSTANCE);
        f425901g = LazyKt.lazy(r100, ImSdkProxy$innerMonitorProxy$2.INSTANCE);
        f425902h = LazyKt.lazy(r100, ImSdkProxy$innerStorageProxy$2.INSTANCE);
        f425903i = LazyKt.lazy(r100, ImSdkProxy$innerPhotoProxy$2.INSTANCE);
    }

    @JvmStatic
    public static final okb.a b() {
        return (okb.a) f425896b.getValue();
    }

    @JvmStatic
    public static final okb.b c() {
        return (okb.b) f425897c.getValue();
    }

    @JvmStatic
    public static final f d() {
        return (f) f425903i.getValue();
    }

    @JvmStatic
    public static final okb.h e() {
        return (okb.h) f425898d.getValue();
    }

    public static final void a(String r100) {
        Log.i("ImSdkProxy", "ProxyFactory provides full proxy for ".concat(r100));
    }
}
