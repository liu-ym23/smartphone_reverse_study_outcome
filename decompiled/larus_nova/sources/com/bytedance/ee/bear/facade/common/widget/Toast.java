package com.bytedance.ee.bear.facade.common.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SieveCacheKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.Contexts;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            if (r101 == Lifecycle.Event.ON_DESTROY) goto L5;
            return;
        L5:
            if (r100 != Toast.access$000().get()) goto L11;
            Toast.access$100();
            r100.getLifecycle().removeObserver(this);
            Toast.access$000().clear();
            if (Toast.access$200() != this) goto L12;
            Toast.access$202(null);
            return;
        L12:
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h08.b f226570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f226571b;

        public b() {
            this.f226571b = new AtomicBoolean();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f226572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f226573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f226574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f226575d;

        public c(int r100, int r101, int r102, int r103) {
            this.f226572a = r100;
            this.f226573b = r101;
            this.f226574c = r102;
            this.f226575d = r103;
        }
    }

    public Toast() {
    }

    public static /* synthetic */ void a() {
        lambda$cancel$5();
    }

    public static /* synthetic */ void b(Context r100, CharSequence r101, c r102, boolean r103) {
        lambda$initAndShowToast$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ void c() {
        lambda$cancelLoading$1();
    }

    public static /* synthetic */ void d() {
        lambda$show$4();
    }

    public static /* synthetic */ void e(Context r100, CharSequence r101) {
        lambda$showLoading$0(r100, r101);
    }

    public static /* synthetic */ void f(Context r100, CharSequence r101, c r102, boolean r103) {
        lambda$initAndShowToast$2(r100, r101, r102, r103);
    }

    static {
        loadingTimeOutRunable = new c0();
        sLoadingToastLifecycleOwner = new WeakReference(null);
    }

    public static void cancel() {
        com.bytedance.ee.util.ui.j.f(new d0());
    }

    private static void cancelBeforeToast() {
        b r100 = sToastWrapper;
        if (r100 == null) goto L8;
        h08.b r101 = r100.f226570a;
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    }

    public static void cancelLoading() {
        com.bytedance.ee.util.ui.j.e(loadingTimeOutRunable);
        com.bytedance.ee.util.ui.j.f(new b0());
    }

    private static void lambda$cancel$5() {
        b r100 = sToastWrapper;
        if (r100 == null) goto L8;
        h08.b r101 = r100.f226570a;
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    }

    private static /* synthetic */ void lambda$show$4() {
        b r100 = sToastWrapper;
        if (r100 == null) goto L8;
        h08.b r101 = r100.f226570a;
        if (r101 == null) goto L9;
        r101.c();
        return;
    L9:
        return;
    }

    private static void releaseLoadingToast() {
        com.bytedance.ee.util.ui.j.e(loadingTimeOutRunable);
        com.larksuite.component.universe_design.toast.c r100 = sLoadingToast;
        if (r100 == null) goto L6;
        r100.cancel();
        sLoadingToast = null;
        return;
    }

    public static void show() {
        com.bytedance.ee.util.ui.j.f(new x());
    }

    private static void unregisterLoadingToastLifecycleCallbacks() {
        LifecycleOwner r100 = sLoadingToastLifecycleOwner.get();
        if (r100 != null) goto L5;
    L7:
        sLoadingToastLifecycleOwner.clear();
        sLoadingToastLifecycleObserver = null;
        return;
    L5:
        if (sLoadingToastLifecycleObserver == null) goto L7;
        r100.getLifecycle().removeObserver(sLoadingToastLifecycleObserver);
        goto L7
    }

    private static boolean useUDLoadingToast() {
        return !com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm_mobile_ccm_at_doubao_reverse_in_feishu", false);
    }

    public static int getFailureIcon() {
        if (en4.a.l() == false) goto L5;
        return R.drawable.office_toast_icon_failure;
    L5:
        return R.drawable.facade_widget_toast_ic_failure;
    }

    public static int getSuccessIcon() {
        if (en4.a.l() == false) goto L5;
        return R.drawable.office_toast_icon_success;
    L5:
        return R.drawable.facade_widget_toast_ic_success;
    }

    public static int getWarningIcon() {
        if (en4.a.l() == false) goto L5;
        return R.drawable.office_toast_icon_warning;
    L5:
        return R.drawable.ud_icon_warning_outlined;
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

    public static /* synthetic */ LifecycleEventObserver access$202(LifecycleEventObserver r100) {
        sLoadingToastLifecycleObserver = r100;
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void registerLoadingToastLifecycleCallbacks(Activity r100) {
        unregisterLoadingToastLifecycleCallbacks();
        if ((r100 instanceof LifecycleOwner) == true) goto L5;
        return;
    L5:
        LifecycleOwner r101 = (LifecycleOwner) r100;
        a r102 = new a();
        r101.getLifecycle().addObserver(r102);
        sLoadingToastLifecycleOwner = new WeakReference(r101);
        sLoadingToastLifecycleObserver = r102;
    }

    private static void lambda$showLoading$0(Context r100, CharSequence r101) {
        Activity r102 = Contexts.findActivity(r100);
        if (r102 != null) goto L5;
    L9:
        if (r102 == null) goto L11;
        r100 = r102;
    L11:
        if (r102 == null) goto L13;
        registerLoadingToastLifecycleCallbacks(r102);
    L13:
        UDLoadingDrawable r103 = new UDLoadingDrawable(r100);
        if (AppInfoUtils.f().booleanValue() == false) goto L16;
        r103.setColorSchemeColors(new int[]{UDColorUtils.getColor(r100, R.color.icon_n1)});
    L16:
        UDToast.a r104 = UDToast.build(r100);
        if (r101 != null) goto L19;
        String r105 = "";
    L20:
        r104.g(r105);
        r104.e(r103);
        r104.f285429b.f417630d = SieveCacheKt.NodeLinkMask;
        com.ss.android.lark.compose.foundation.toast.g r106 = r104.a();
        sLoadingToast = r106;
        r106.show();
        return;
    L19:
        r105 = r101.toString();
        goto L20
    L5:
        if (r102.isFinishing() == false) goto L7;
        return;
    L7:
        if (r102.isDestroyed() == false) goto L9;
    }

    private static void setToastIcon(h08.b r100, int r101) {
        if (en4.a.l() == false) goto L12;
        if (r101 != (-1)) goto L6;
        r100.getClass();
        return;
    L6:
        com.ss.android.lark.compose.foundation.toast.g r102 = r100.f483449a;
        if (r102 != null) goto L11;
        UDToast.a r103 = r100.f483450b;
        if (r103 == null) goto L22;
        FlowToast.a r104 = r103.f285429b;
        r104.f417629c = UDIconUtils.getIconDrawable(r104.f417627a, r101);
        return;
    L22:
        return;
    L11:
        r102.setIcon(r101);
        return;
    L12:
        if (r101 != (-1)) goto L14;
        r100.getClass();
        return;
    L14:
        com.ss.android.lark.compose.foundation.toast.g r105 = r100.f483449a;
        if (r105 != null) goto L19;
        UDToast.a r106 = r100.f483450b;
        if (r106 == null) goto L26;
        r106.d(r101);
        return;
    L26:
        return;
    L19:
        r105.setIcon(r101);
    }

    public static void showFailureText(Context r100, int r101) {
        showFailureText(r100, r100.getString(r101), 0);
    }

    public static void showLoading(final Context r100, final CharSequence r101) {
        cancelLoading();
        cancelBeforeToast();
        if (r100 != null) goto L6;
        return;
    L6:
        if (useUDLoadingToast() == false) goto L8;
        com.bytedance.ee.util.ui.j.f(new y(r100, r101));
        return;
    L8:
        LKUIToast.showLoading(r100, r101);
    }

    public static void showSuccessText(Context r100, int r101) {
        showSuccessText(r100, r100.getString(r101), 0);
    }

    public static void showText(Context r100, int r101) {
        showText(r100, r100.getString(r101), 0);
    }

    public static void showWarningText(Context r100, int r101) {
        showWarningText(r100, r100.getString(r101), 0);
    }

    public static void updateLoading(Context r100, CharSequence r101) {
        if (useUDLoadingToast() == false) goto L5;
        showLoading(r100, r101);
        return;
    L5:
        LKUIToast.showLoading(r100, r101);
    }

    public static UDToast.a setToastIcon(UDToast.a r100, Drawable r101) {
        if (en4.a.l() == false) goto L5;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        FlowToast.a r102 = r100.f285429b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        r102.f417629c = r101;
    L6:
        return r100;
    L5:
        r100.e(r101);
        goto L6
    }

    public static void showFailureText(Context r100, CharSequence r101) {
        showFailureText(r100, r101, 0);
    }

    public static void showSuccessText(Context r100, CharSequence r101) {
        showSuccessText(r100, r101, 0);
    }

    public static void showText(Context r100, CharSequence r101) {
        showText(r100, r101, 0);
    }

    public static UDToast.a setToastIcon(UDToast.a r100, int r101) {
        if (en4.a.l() == false) goto L5;
        FlowToast.a r102 = r100.f285429b;
        r102.f417629c = UDIconUtils.getIconDrawable(r102.f417627a, r101);
    L6:
        return r100;
    L5:
        r100.d(r101);
        goto L6
    }

    public static void showCenterToast(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(-1, 17, 0, r102), false);
    }

    public static void showFailureText(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(getFailureIcon(), 0, 0, r102), false);
    }

    public static void showFailureTextWithMargin(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(getFailureIcon(), 0, 0, r102), false);
    }

    public static void showLoading(Activity r100, CharSequence r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        showLoading(r100, r101);
        com.bytedance.ee.util.ui.j.d(loadingTimeOutRunable, r102);
    }

    public static void showSuccessText(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(getSuccessIcon(), 0, 0, r102), false);
    }

    public static void showSuccessTextWithMargin(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(getSuccessIcon(), 0, 0, r102), false);
    }

    public static void showText(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(-1, 0, 0, r102), false);
    }

    public static void showWarningText(Context r100, CharSequence r101, int r102) {
        initAndShowToast(r100, r101, new c(getWarningIcon(), 0, 0, r102), false);
    }

    private static void doInitAndShowToast(Context r100, CharSequence r101, c r102, boolean r103) {
        cancelBeforeToast();
        cancelLoading();
        String r104 = r101.toString();
        b r105 = new b();
        r105.f226570a = LKUIToast.newGlobal(r100.getApplicationContext(), r104.toString());
        r105.f226571b.set(r103);
        sToastWrapper = r105;
        final h08.b r106 = r105.f226570a;
        int r107 = r102.f226575d;
        if (r106.f483449a != null) goto L7;
        UDToast.a r108 = r106.f483450b;
        if (r108 == null) goto L8;
        r108.f285429b.f417630d = r107;
    L8:
        int r109 = r102.f226572a;
        if (r109 == (-1)) goto L12;
        setToastIcon(sToastWrapper.f226570a, kac.a.b(r109));
    L12:
        if (r102.f226573b != 80) goto L20;
        int r110 = r102.f226574c;
        if (r110 == 0) goto L20;
        h08.b r111 = sToastWrapper.f226570a;
        if (r111.f483449a != null) goto L20;
        UDToast.a r112 = r111.f483450b;
        if (r112 == null) goto L20;
        r112.f285429b.c(80, 0, r110);
    L20:
        int r113 = r102.f226573b;
        if (r113 != 17) goto L23;
    L24:
        h08.b r114 = sToastWrapper.f226570a;
        if (r114.f483449a != null) goto L29;
        UDToast.a r115 = r114.f483450b;
        if (r115 == null) goto L29;
        r115.f285429b.c(r113, 0, 0);
    L29:
        sToastWrapper.f226570a.c();
        return;
    L23:
        if (r113 != 48) goto L29;
    L7:
        h08.b.f483448d.postDelayed(new h08.a(r106), r107);
        goto L8
    }

    private static void initAndShowToast(final Context r100, final CharSequence r101, final c r102, final boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        b r104 = sToastWrapper;
        if (r104 != null) goto L7;
    L11:
        com.bytedance.ee.util.ui.j.f(new a0(r100, r101, r102, r103));
        return;
    L7:
        if (r104.f226570a == null) goto L11;
        if (r104.f226571b.get() == false) goto L11;
        Runnable r105 = new z(r100, r101, r102, r103);
        Handler r106 = com.bytedance.ee.util.ui.j.f243162a;
        Looper.getMainLooper();
        Looper.myLooper();
        com.bytedance.ee.util.ui.j.d(r105, 1000);
    }

    private static /* synthetic */ void lambda$initAndShowToast$2(Context r100, CharSequence r101, c r102, boolean r103) {
        doInitAndShowToast(r100, r101, r102, r103);
    }

    private static /* synthetic */ void lambda$initAndShowToast$3(Context r100, CharSequence r101, c r102, boolean r103) {
        doInitAndShowToast(r100, r101, r102, r103);
    }

    public static void showText(Context r100, CharSequence r101, int r102, boolean r103) {
        initAndShowToast(r100, r101, new c(-1, 0, 0, r102), r103);
    }

    public static void showToastWithBottomMargin(Context r100, CharSequence r101, int r102, int r103) {
        initAndShowToast(r100, r101, new c(-1, 80, r102, r103), false);
    }
}
