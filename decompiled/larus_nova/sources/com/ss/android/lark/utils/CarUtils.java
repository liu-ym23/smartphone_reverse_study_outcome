package com.ss.android.lark.utils;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class CarUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f444655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444656b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f444657c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f444658d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f444659e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f444660f = null;

    static {
        f444655a = new String[]{"leo", "niobox", "NIO"};
        Lazy r100 = LazyKt.lazy(CarUtils$manufacturer$2.INSTANCE);
        f444656b = r100;
        Lazy r101 = LazyKt.lazy(CarUtils$characteristics$2.INSTANCE);
        f444657c = r101;
        Lazy r102 = LazyKt.lazy(CarUtils$model$2.INSTANCE);
        f444658d = r102;
        f444659e = LazyKt.lazy(CarUtils$dependency$2.INSTANCE);
        Lazy r103 = LazyKt.lazy(CarUtils$channel$2.INSTANCE);
        f444660f = r103;
        Log.i("CarUtils", "manufacturer: " + ((String) r100.getValue()) + ", characteristics: " + ((String) r101.getValue()) + ", model: " + ((String) r102.getValue()) + ", channel: " + ((String) r103.getValue()));
    }

    public static boolean b() {
        if (((v28.b) f444659e.getValue()).isDisableCarAdapt() == false) goto L6;
        Log.i("CarUtils", "disable car adapt by fg");
        return false;
    L6:
        String[] r100 = {"NIO"};
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        if (StringsKt.equals(r100[r102], (String) f444656b.getValue(), true) == true) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L29;
        String[] r104 = f444655a;
        int r105 = r104.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L21;
        if (StringsKt.equals(r104[r106], (String) f444658d.getValue(), true) == true) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L30;
        return true;
    L30:
        return false;
    L21:
        r107 = false;
        goto L22
    L29:
        return false;
    L13:
        r103 = false;
        goto L14
    }

    public static boolean c() {
        if (((v28.b) f444659e.getValue()).isDisableCarAdapt() == false) goto L6;
        Log.i("CarUtils", "disable car adapt by fg");
        return false;
    L6:
        String[] r100 = {"Xiaomi"};
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        if (StringsKt.equals(r100[r102], (String) f444656b.getValue(), true) == true) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L30;
        String[] r104 = {"automotive", "auto,nosdcard"};
        int r105 = 0;
    L17:
        if (r105 >= 2) goto L22;
        if (StringsKt.equals(r104[r105], (String) f444657c.getValue(), true) == true) goto L20;
        r105 = r105 + 1;
        goto L17
    L20:
        boolean r106 = true;
    L23:
        if (r106 == false) goto L31;
        return true;
    L31:
        return false;
    L22:
        r106 = false;
        goto L23
    L30:
        return false;
    L13:
        r103 = false;
        goto L14
    }

    public static boolean a() {
        if (c() == false) goto L5;
    L7:
        return true;
    L5:
        if (b() == true) goto L7;
        return false;
    }
}
