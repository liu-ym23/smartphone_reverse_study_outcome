package com.bytedance.ee.bear.facade.common.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.Contexts;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Toast {
    public static final int CUSTOM_TOAST_BOTTOM_MARGIN_VALUE = 128;
    private static final int DEFAULT_BOTTOM_MARGIN_VALUE = 0;
    private static final int DEFAULT_IMAGE_RES_ID = -1;
    private static final int DURATION_MAX = Integer.MAX_VALUE;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final long WAITING_TIME = 1000;
    private static final Runnable loadingTimeOutRunable = null;
    private static com.larksuite.component.universe_design.toast.c sLoadingToast;
    private static LifecycleEventObserver sLoadingToastLifecycleObserver;
    private static WeakReference<LifecycleOwner> sLoadingToastLifecycleOwner;
    private static b sToastWrapper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public class a implements LifecycleEventObserver {
        public a() {
        }

        public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            if (r3 == Lifecycle.Event.ON_DESTROY) goto L5;
            return;
        L5:
            if (r2 != Toast.access$000().get()) goto L11;
            Toast.access$100();
            r2.getLifecycle().removeObserver(this);
            Toast.access$000().clear();
            if (Toast.access$200() != this) goto L12;
            Toast.access$202(null);
            return;
        L12:
            return;
        }
    }

    public static class b {
        public h08.b a;
        public final AtomicBoolean b;

        public b() {
            this.b = new AtomicBoolean();
        }
    }

    public static class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public c(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public Toast() {
    }

    public static /* synthetic */ void a() {
        lambda$cancel$5();
    }

    public static /* synthetic */ void b(Context r0, CharSequence r1, c r2, boolean r3) {
        lambda$initAndShowToast$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void c() {
        lambda$cancelLoading$1();
    }

    public static /* synthetic */ void d() {
        lambda$show$4();
    }

    public static /* synthetic */ void e(Context r0, CharSequence r1) {
        lambda$showLoading$0(r0, r1);
    }

    public static /* synthetic */ void f(Context r0, CharSequence r1, c r2, boolean r3) {
        lambda$initAndShowToast$2(r0, r1, r2, r3);
    }

    static {
        loadingTimeOutRunable = new c0();
        sLoadingToastLifecycleOwner = new WeakReference(null);
    }

    public static void cancel() {
        com.bytedance.ee.util.ui.j.f(new d0());
    }

    private static void cancelBeforeToast() {
        b r0 = sToastWrapper;
        if (r0 == null) goto L8;
        h08.b r1 = r0.a;
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    }

    public static void cancelLoading() {
        com.bytedance.ee.util.ui.j.e(loadingTimeOutRunable);
        com.bytedance.ee.util.ui.j.f(new b0());
    }

    private static void lambda$cancel$5() {
        b r0 = sToastWrapper;
        if (r0 == null) goto L8;
        h08.b r1 = r0.a;
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    }

    private static /* synthetic */ void lambda$show$4() {
        b r0 = sToastWrapper;
        if (r0 == null) goto L8;
        h08.b r1 = r0.a;
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    private static void releaseLoadingToast() {
        com.bytedance.ee.util.ui.j.e(loadingTimeOutRunable);
        com.larksuite.component.universe_design.toast.c r0 = sLoadingToast;
        if (r0 == null) goto L6;
        r0.cancel();
        sLoadingToast = null;
        return;
    }

    public static void show() {
        com.bytedance.ee.util.ui.j.f(new x());
    }

    private static void unregisterLoadingToastLifecycleCallbacks() {
        LifecycleOwner r0 = sLoadingToastLifecycleOwner.get();
        if (r0 != null) goto L5;
    L7:
        sLoadingToastLifecycleOwner.clear();
        sLoadingToastLifecycleObserver = null;
        return;
    L5:
        if (sLoadingToastLifecycleObserver == null) goto L7;
        r0.getLifecycle().removeObserver(sLoadingToastLifecycleObserver);
        goto L7
    }

    private static boolean useUDLoadingToast() {
        return !com.bytedance.ee.bear.appsetting.c.a.a.i("ccm_mobile_ccm_at_doubao_reverse_in_feishu", false);
    }

    public static int getFailureIcon() {
        if (en4.a.l() == false) goto L5;
        return 2131244774;
    L5:
        return 2131235330;
    }

    public static int getSuccessIcon() {
        if (en4.a.l() == false) goto L5;
        return 2131244775;
    L5:
        return 2131235331;
    }

    public static int getWarningIcon() {
        if (en4.a.l() == false) goto L5;
        return 2131244776;
    L5:
        return 2131256189;
    }

    private static /* synthetic */ void lambda$cancelLoading$1() {
        if (useUDLoadingToast() == false) goto L5;
        unregisterLoadingToastLifecycleCallbacks();
        releaseLoadingToast();
        return;
    L5:
        LKUIToast.cancelLoading();
    }

    public static /* synthetic */ WeakReference access$000() {
        return sLoadingToastLifecycleOwner;
    }

    public static /* synthetic */ void access$100() {
        releaseLoadingToast();
    }

    public static /* synthetic */ LifecycleEventObserver access$200() {
        return sLoadingToastLifecycleObserver;
    }

    public static /* synthetic */ LifecycleEventObserver access$202(LifecycleEventObserver r0) {
        sLoadingToastLifecycleObserver = r0;
        return r0;
    }

    private static void registerLoadingToastLifecycleCallbacks(Activity r2) {
        unregisterLoadingToastLifecycleCallbacks();
        if ((r2 instanceof LifecycleOwner) == true) goto L5;
        return;
    L5:
        LifecycleOwner r3 = (LifecycleOwner) r2;
        a r0 = new a();
        r3.getLifecycle().addObserver(r0);
        sLoadingToastLifecycleOwner = new WeakReference(r3);
        sLoadingToastLifecycleObserver = r0;
    }

    private static void lambda$showLoading$0(Context r4, CharSequence r5) {
        Activity r0 = Contexts.findActivity(r4);
        if (r0 != null) goto L5;
    L9:
        if (r0 == null) goto L11;
        r4 = r0;
    L11:
        if (r0 == null) goto L13;
        registerLoadingToastLifecycleCallbacks(r0);
    L13:
        UDLoadingDrawable r1 = new UDLoadingDrawable(r4);
        if (AppInfoUtils.f().booleanValue() == false) goto L16;
        r1.setColorSchemeColors(new int[]{UDColorUtils.getColor(r4, 2131102418)});
    L16:
        UDToast.a r6 = UDToast.build(r4);
        if (r5 != null) goto L19;
        String r7 = "";
    L20:
        r6.g(r7);
        r6.e(r1);
        r6.b.d = 2147483647L;
        com.ss.android.lark.compose.foundation.toast.g r8 = r6.a();
        sLoadingToast = r8;
        r8.show();
        return;
    L19:
        r7 = r5.toString();
        goto L20
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == false) goto L9;
    }

    private static void setToastIcon(h08.b r2, int r3) {
        if (en4.a.l() == false) goto L12;
        if (r3 != (-1)) goto L6;
        r2.getClass();
        return;
    L6:
        com.ss.android.lark.compose.foundation.toast.g r0 = r2.a;
        if (r0 != null) goto L11;
        UDToast.a r4 = r2.b;
        if (r4 == null) goto L22;
        FlowToast.a r5 = r4.b;
        r5.c = UDIconUtils.getIconDrawable(r5.a, r3);
        return;
    L22:
        return;
    L11:
        r0.setIcon(r3);
        return;
    L12:
        if (r3 != (-1)) goto L14;
        r2.getClass();
        return;
    L14:
        com.ss.android.lark.compose.foundation.toast.g r1 = r2.a;
        if (r1 != null) goto L19;
        UDToast.a r6 = r2.b;
        if (r6 == null) goto L26;
        r6.d(r3);
        return;
    L26:
        return;
    L19:
        r1.setIcon(r3);
    }

    public static void showFailureText(Context r1, int r2) {
        showFailureText(r1, r1.getString(r2), 0);
    }

    public static void showLoading(final Context r1, final CharSequence r2) {
        cancelLoading();
        cancelBeforeToast();
        if (r1 != null) goto L6;
        return;
    L6:
        if (useUDLoadingToast() == false) goto L8;
        com.bytedance.ee.util.ui.j.f(new y(r1, r2));
        return;
    L8:
        LKUIToast.showLoading(r1, r2);
    }

    public static void showSuccessText(Context r1, int r2) {
        showSuccessText(r1, r1.getString(r2), 0);
    }

    public static void showText(Context r1, int r2) {
        showText(r1, r1.getString(r2), 0);
    }

    public static void showWarningText(Context r1, int r2) {
        showWarningText(r1, r1.getString(r2), 0);
    }

    public static void updateLoading(Context r1, CharSequence r2) {
        if (useUDLoadingToast() == false) goto L5;
        showLoading(r1, r2);
        return;
    L5:
        LKUIToast.showLoading(r1, r2);
    }

    public static UDToast.a setToastIcon(UDToast.a r2, Drawable r3) {
        if (en4.a.l() == false) goto L5;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "value");
        FlowToast.a r1 = r2.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.c = r3;
    L6:
        return r2;
    L5:
        r2.e(r3);
        goto L6
    }

    public static void showFailureText(Context r1, CharSequence r2) {
        showFailureText(r1, r2, 0);
    }

    public static void showSuccessText(Context r1, CharSequence r2) {
        showSuccessText(r1, r2, 0);
    }

    public static void showText(Context r1, CharSequence r2) {
        showText(r1, r2, 0);
    }

    public static UDToast.a setToastIcon(UDToast.a r2, int r3) {
        if (en4.a.l() == false) goto L5;
        FlowToast.a r0 = r2.b;
        r0.c = UDIconUtils.getIconDrawable(r0.a, r3);
    L6:
        return r2;
    L5:
        r2.d(r3);
        goto L6
    }

    public static void showCenterToast(Context r4, CharSequence r5, int r6) {
        initAndShowToast(r4, r5, new c(-1, 17, 0, r6), false);
    }

    public static void showFailureText(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(getFailureIcon(), 0, 0, r5), false);
    }

    public static void showFailureTextWithMargin(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(getFailureIcon(), 0, 0, r5), false);
    }

    public static void showLoading(Activity r0, CharSequence r1, long r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        showLoading(r0, r1);
        com.bytedance.ee.util.ui.j.d(loadingTimeOutRunable, r2);
    }

    public static void showSuccessText(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(getSuccessIcon(), 0, 0, r5), false);
    }

    public static void showSuccessTextWithMargin(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(getSuccessIcon(), 0, 0, r5), false);
    }

    public static void showText(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(-1, 0, 0, r5), false);
    }

    public static void showWarningText(Context r3, CharSequence r4, int r5) {
        initAndShowToast(r3, r4, new c(getWarningIcon(), 0, 0, r5), false);
    }

    private static void doInitAndShowToast(Context r2, CharSequence r3, c r4, boolean r5) {
        cancelBeforeToast();
        cancelLoading();
        String r6 = r3.toString();
        b r0 = new b();
        r0.a = LKUIToast.newGlobal(r2.getApplicationContext(), r6.toString());
        r0.b.set(r5);
        sToastWrapper = r0;
        h08.b r7 = r0.a;
        int r8 = r4.d;
        if (r7.a != null) goto L7;
        UDToast.a r9 = r7.b;
        if (r9 == null) goto L8;
        r9.b.d = r8;
    L8:
        int r10 = r4.a;
        if (r10 == (-1)) goto L12;
        setToastIcon(sToastWrapper.a, kac.a.b(r10));
    L12:
        if (r4.b != 80) goto L20;
        int r11 = r4.c;
        if (r11 == 0) goto L20;
        h08.b r1 = sToastWrapper.a;
        if (r1.a != null) goto L20;
        UDToast.a r12 = r1.b;
        if (r12 == null) goto L20;
        r12.b.c(80, 0, r11);
    L20:
        int r13 = r4.b;
        if (r13 != 17) goto L23;
    L24:
        h08.b r14 = sToastWrapper.a;
        if (r14.a != null) goto L29;
        UDToast.a r16 = r14.b;
        if (r16 == null) goto L29;
        r16.b.c(r13, 0, 0);
    L29:
        sToastWrapper.a.c();
        return;
    L23:
        if (r13 != 48) goto L29;
    L7:
        h08.b.d.postDelayed(new h08.a(r7), r8);
        goto L8
    }

    private static void initAndShowToast(final Context r2, final CharSequence r3, final c r4, final boolean r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        b r0 = sToastWrapper;
        if (r0 != null) goto L7;
    L11:
        com.bytedance.ee.util.ui.j.f(new a0(r2, r3, r4, r5));
        return;
    L7:
        if (r0.a == null) goto L11;
        if (r0.b.get() == false) goto L11;
        Runnable r1 = new z(r2, r3, r4, r5);
        Handler r6 = com.bytedance.ee.util.ui.j.a;
        Looper.getMainLooper();
        Looper.myLooper();
        com.bytedance.ee.util.ui.j.d(r1, WAITING_TIME);
    }

    private static /* synthetic */ void lambda$initAndShowToast$2(Context r0, CharSequence r1, c r2, boolean r3) {
        doInitAndShowToast(r0, r1, r2, r3);
    }

    private static /* synthetic */ void lambda$initAndShowToast$3(Context r0, CharSequence r1, c r2, boolean r3) {
        doInitAndShowToast(r0, r1, r2, r3);
    }

    public static void showText(Context r3, CharSequence r4, int r5, boolean r6) {
        initAndShowToast(r3, r4, new c(-1, 0, 0, r5), r6);
    }

    public static void showToastWithBottomMargin(Context r3, CharSequence r4, int r5, int r6) {
        initAndShowToast(r3, r4, new c(-1, 80, r5, r6), false);
    }
}
