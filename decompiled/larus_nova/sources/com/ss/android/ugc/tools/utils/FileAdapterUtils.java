package com.ss.android.ugc.tools.utils;

import android.app.Application;
import android.net.Uri;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class FileAdapterUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f454852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xhc.a f454853b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f454854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, Boolean> f454855d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final FileAdapterUtils f454856e = null;

    public interface a {
    }

    static {
        f454852a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(FileAdapterUtils.class, "application", "getApplication()Landroid/app/Application;", 0))};
        f454856e = new FileAdapterUtils();
        f454853b = new xhc.a(FileAdapterUtils$application$2.INSTANCE);
        new String[]{LoadParams.ImageFormat.PNG, "jpg", LoadParams.ImageFormat.JPEG, "bmp", "heif", "heic", "ico"};
        new String[]{"gif", "webp"};
        new LruCache(200);
        new LruCache(200);
        f454855d = new LruCache(200);
    }

    public FileAdapterUtils() {
    }

    public final Application a() {
        return (Application) f454853b.getValue(this, f454852a[0]);
    }

    @JvmStatic
    public static final void c() {
        if (f454856e.a() == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("invalid application info to set AdapterAndroidRUtils.application");
    }

    @JvmStatic
    public static final boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L20;
        return false;
    L20:
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L19
        if (r102 == null) goto L14;
        String r103 = r102.getScheme();     // Catch: Exception -> L19
    L15:
        if (Intrinsics.areEqual("content", r103) == false) goto L18;
        return true;
    L14:
        r103 = null;
    L18:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
