package com.bytedance.android.shopping.store.arch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.LynxView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nj.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreFoldPhoneHelper {
    public static final Lazy a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/arch/ECStoreFoldPhoneHelper$a;", "", "", "", "ignoreList", "[Ljava/lang/String;", "getIgnoreList", "()[Ljava/lang/String;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("ignore_list")
        private final String[] ignoreList;

        public a() {
            this.ignoreList = new String[0];
        }
    }

    public static d e() {
        return (d) a.getValue();
    }

    static {
        a = LazyKt.lazy(ECStoreFoldPhoneHelper$service$2.INSTANCE);
        new AtomicInteger();
    }

    public static boolean d() {
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == true) goto L10;
        d r1 = e();
        if (r1 == null) goto L8;
        r1.h();
    L8:
        return false;
    L10:
        return g();
    }

    public static boolean g() {
        ECAppInfoService r0 = ECAppInfoService.e;
        boolean r2 = false;
        if (we.a.a == false) goto L47;
        com.bytedance.android.shopping.store.arch.a r1 = com.bytedance.android.shopping.store.arch.a.g;
        Context r3 = r0.getApplicationContext();
        r1.getClass();
        if (r3 == null) goto L56;
        Boolean r4 = com.bytedance.android.shopping.store.arch.a.a;
        if (r4 != null) goto L53;
        Context r5 = r3.getApplicationContext();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L41
        String r7 = Build.BRAND;     // Catch: Throwable -> L41
        if (StringsKt.equals(r7, "huawei", true) == false) goto L21;
        if (r5.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L16;
    L26:
        r2 = true;
    L39:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L41
    L43:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L46;
        r8 = r9;
    L46:
        boolean r10 = ((Boolean) r8).booleanValue();
        com.bytedance.android.shopping.store.arch.a.a = Boolean.valueOf(r10);
        return r10;
    L16:
        if (com.bytedance.android.shopping.store.arch.a.b.contains(Build.DEVICE) == true) goto L26;
        if (com.bytedance.android.shopping.store.arch.a.c.contains(Build.MODEL) == false) goto L39;
    L21:
        if (StringsKt.equals(r7, "honor", true) == false) goto L28;
        if (r5.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == true) goto L26;
        if (com.bytedance.android.shopping.store.arch.a.d.contains(Build.DEVICE) == false) goto L39;
    L28:
        if (StringsKt.equals(r7, "oppo", true) == false) goto L31;
        r2 = com.bytedance.android.shopping.store.arch.a.b();     // Catch: Throwable -> L41
        goto L39
    L31:
        if (StringsKt.equals(r7, "vivo", true) == false) goto L34;
        Class r11 = com.bytedance.android.shopping.store.arch.a.a("android.util.FtDeviceInfo");     // Catch: Throwable -> L41
        r2 = Intrinsics.areEqual(r11.getMethod("getDeviceType", new Class[0]).invoke(r11, new Object[0]), "foldable");     // Catch: Throwable -> L41
        goto L39
    L34:
        if (StringsKt.equals(r7, "xiaomi", true) == false) goto L37;
        r2 = com.bytedance.android.shopping.store.arch.a.d();     // Catch: Throwable -> L41
        goto L39
    L37:
        if (StringsKt.equals(r7, "samsung", true) == false) goto L39;
        r2 = com.bytedance.android.shopping.store.arch.a.c();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L53:
        return r4.booleanValue();
    L56:
        return false;
    L47:
        d r13 = e();
        if (r13 == null) goto L55;
        r13.isFold();
        return false;
    L55:
        return false;
    }

    public static void a(Fragment r1) {
        if (r1 == null) goto L7;
        d r0 = e();
        if (r0 == null) goto L8;
        r1.requireActivity();
        r0.m();
        return;
    L8:
        return;
    }

    public static String b(String r1) {
        if (d() == false) goto L7;
        d r0 = e();
        if (r0 == null) goto L7;
        r0.a();
    L7:
        return r1;
    }

    public static void c(Fragment r1) {
        if (r1 == null) goto L7;
        d r0 = e();
        if (r0 == null) goto L8;
        r1.requireActivity();
        r0.n();
        return;
    L8:
        return;
    }

    public static void f(Fragment r3) {
        if (d() == false) goto L23;
        IBinder r0 = null;
        if (r3 == null) goto L7;
        Context r1 = r3.getContext();
    L8:
        if (r3 == null) goto L10;
        View r4 = r3.getView();
    L11:
        if (r1 == null) goto L13;
        Object r2 = r1.getSystemService("input_method");
    L15:
        if ((r2 instanceof InputMethodManager) == true) goto L17;
        r2 = null;
    L17:
        InputMethodManager r5 = (InputMethodManager) r2;
        if (r5 == null) goto L24;
        if (r4 == null) goto L21;
        r0 = r4.getWindowToken();
    L21:
        r5.hideSoftInputFromWindow(r0, 0);
        return;
    L24:
        return;
    L13:
        r2 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    L7:
        r1 = null;
        goto L8
    }

    public static boolean h(Activity r0) {
        d r1 = e();
        if (r1 == null) goto L7;
        r1.l();
        return false;
    L7:
        return false;
    }

    public static void i(View r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        if (d() == false) goto L24;
        boolean r0 = r5 instanceof LynxView;
        if (r0 == false) goto L25;
        Point r1 = l0.f(((LynxView) r5).getContext());
        if (r1 == null) goto L9;
        Integer r3 = Integer.valueOf(r1.x);
    L10:
        if (r1 == null) goto L12;
        Integer r2 = Integer.valueOf(r1.y);
    L13:
        if (r3 == null) goto L26;
        if (r2 == null) goto L27;
        d r4 = e();
        if (r4 == null) goto L18;
        r4.a();
    L18:
        if (r0 == true) goto L20;
        r5 = null;
    L20:
        LynxView r6 = (LynxView) r5;
        if (r6 == null) goto L28;
        r6.updateScreenMetrics(r3.intValue(), r2.intValue());
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        r2 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    L25:
        return;
    }
}
