package com.larksuite.component.ui.toast;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.collection.SieveCacheKt;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.toast.c;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import h08.b;
import h08.d;
import h08.e;
import h08.f;
import h08.g;
import h08.h;
import h08.i;
import h08.j;
import h08.k;
import h08.l;
import h08.m;
import h08.n;
import h08.o;
import h08.p;
import h08.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIToast {
    public static final long DURATION_LONG = 3500;
    public static final int DURATION_MAX = Integer.MAX_VALUE;
    public static final long DURATION_SHORT = 2000;
    private static final String TAG = "LKUIToast";
    public static WeakReference<c> mUdToastRef;
    private static int sBottomMargin;
    private static Handler sHandler;
    private static boolean sIsEnabled;

    public LKUIToast() {
    }

    public static /* synthetic */ void a(Context r100, String r101, int r102, long r103) {
        lambda$show$13(r100, r101, r102, r103);
    }

    public static /* synthetic */ void b(Context r100, CharSequence r101) {
        lambda$showLoading$0(r100, r101);
    }

    public static /* synthetic */ void c(Context r100, String r101, long r102) {
        lambda$showInCenter$10(r100, r101, r102);
    }

    public static /* synthetic */ void d(Context r100, String r101, long r102) {
        lambda$show$11(r100, r101, r102);
    }

    public static void disableToast() {
        sIsEnabled = false;
    }

    public static /* synthetic */ void e(Context r100, CharSequence r101) {
        lambda$loadFail$4(r100, r101);
    }

    public static void enableToast() {
        sIsEnabled = true;
    }

    public static /* synthetic */ void f(Context r100, String r101, int r102) {
        lambda$show$8(r100, r101, r102);
    }

    public static /* synthetic */ void g(Context r100, CharSequence r101) {
        lambda$loadSuccess$2(r100, r101);
    }

    public static /* synthetic */ void h() {
        lambda$cancelLoading$1();
    }

    public static /* synthetic */ void i(Context r100, String r101) {
        lambda$showInCenter$7(r100, r101);
    }

    public static /* synthetic */ void j(Context r100, String r101) {
        lambda$show$6(r100, r101);
    }

    public static /* synthetic */ void k(Context r100, int r101) {
        lambda$loadFail$5(r100, r101);
    }

    public static /* synthetic */ void l(Context r100, String r101, long r102) {
        lambda$showInCenter$12(r100, r101, r102);
    }

    public static /* synthetic */ void m(Context r100, String r101, long r102) {
        lambda$show$9(r100, r101, r102);
    }

    public static /* synthetic */ void n(Context r100, int r101) {
        lambda$loadSuccess$3(r100, r101);
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
        sBottomMargin = 0;
        sIsEnabled = true;
    }

    public static void cancelLoading() {
        runOnUiThread(new n());
    }

    public static RotateAnimation getRotateAnimation() {
        RotateAnimation r100 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r100.setInterpolator(new LinearInterpolator());
        r100.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r100.setRepeatCount(-1);
        r100.setRepeatMode(1);
        return r100;
    }

    private static boolean isDisabled() {
        return !sIsEnabled;
    }

    private static /* synthetic */ void lambda$cancelLoading$1() {
        WeakReference<c> r100 = mUdToastRef;
        if (r100 != null) goto L5;
        return;
    L5:
        c r101 = r100.get();
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        mUdToastRef = null;
    }

    public static CharSequence nullIsEmpty(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    private static void runOnUiThread(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        sHandler.post(r100);
    }

    public static void setBottomMargin(int r100) {
        sBottomMargin = r100;
    }

    private static /* synthetic */ void lambda$loadFail$4(Context r100, CharSequence r101) {
        WeakReference<c> r102 = mUdToastRef;
        if (r102 != null) goto L5;
        showFail(r100, r101);
        return;
    L5:
        c r103 = r102.get();
        if (r103 != null) goto L8;
    L10:
        showFail(r100, r101);
        return;
    L8:
        if (r103.isShowing() == false) goto L10;
        r103.setText(nullIsEmpty(r101));
        r103.setIcon(R.drawable.ud_icon_more_close_outlined);
        sHandler.postDelayed(new o(r103), 2000);
    }

    private static /* synthetic */ void lambda$loadFail$5(Context r100, int r101) {
        loadFail(r100, r100.getString(r101));
    }

    private static /* synthetic */ void lambda$loadSuccess$2(Context r100, CharSequence r101) {
        WeakReference<c> r102 = mUdToastRef;
        if (r102 != null) goto L5;
        showSuccess(r100, r101);
        return;
    L5:
        c r103 = r102.get();
        if (r103 != null) goto L8;
    L10:
        showSuccess(r100, r101);
        return;
    L8:
        if (r103.isShowing() == false) goto L10;
        r103.setText(nullIsEmpty(r101));
        r103.setIcon(R.drawable.ud_icon_yes_outlined);
        sHandler.postDelayed(new o(r103), 2000);
    }

    private static /* synthetic */ void lambda$loadSuccess$3(Context r100, int r101) {
        loadSuccess(r100, r100.getString(r101));
    }

    private static /* synthetic */ void lambda$show$6(Context r100, String r101) {
        UDToast.show(r100, nullIsEmpty(r101).toString());
    }

    private static void lambda$showInCenter$7(Context r100, String r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(nullIsEmpty(r101));
        r102.f285429b.c(17, 0, 0);
        r102.a().show();
    }

    private static /* synthetic */ void lambda$showLoading$0(Context r100, CharSequence r101) {
        WeakReference<c> r102 = mUdToastRef;
        if (r102 != null) goto L5;
        showPermanentLoading(r100, r101);
        return;
    L5:
        c r103 = r102.get();
        if (r103 != null) goto L8;
    L10:
        showPermanentLoading(r100, r101);
        return;
    L8:
        if (r103.isShowing() == false) goto L10;
        r103.setText(nullIsEmpty(r101));
    }

    public static void loadFail(final Context r100, final int r101) {
        runOnUiThread(new l(r100, r101));
    }

    public static void loadSuccess(final Context r100, final int r101) {
        runOnUiThread(new h08.c(r100, r101));
    }

    public static b newGlobal(Context r100, String r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(nullIsEmpty(r101));
        return new b(r100, r102);
    }

    public static b newGlobalInCenter(Context r100, String r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(nullIsEmpty(r101));
        r102.f285429b.c(17, 0, 0);
        return new b(r100, r102);
    }

    public static void show(final Context r100, final String r101) {
        if (r100 != null) goto L4;
    L8:
        isDisabled();
        return;
    L4:
        if (isDisabled() == true) goto L8;
        runOnUiThread(new g(r100, r101));
    }

    private static void showFail(Context r100, CharSequence r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(nullIsEmpty(r101));
        r102.d(R.drawable.ud_icon_more_close_outlined);
        r102.a().show();
    }

    public static void showInCenter(final Context r100, final String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new p(r100, r101));
        return;
    }

    public static void showLoading(final Context r100, final CharSequence r101) {
        runOnUiThread(new i(r100, r101));
    }

    private static void showPermanentLoading(Context r100, CharSequence r101) {
        CircularProgressDrawable r102 = new CircularProgressDrawable(r100);
        r102.setStyle(1);
        r102.setColorSchemeColors(new int[]{UDColorUtils.getColor(r100, R.color.static_white)});
        r102.setStrokeCap(Paint.Cap.ROUND);
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.e(r102);
        r103.f285429b.f417630d = SieveCacheKt.NodeLinkMask;
        com.ss.android.lark.compose.foundation.toast.g r104 = r103.a();
        mUdToastRef = new WeakReference(r104);
        r104.show();
    }

    private static void showSuccess(Context r100, CharSequence r101) {
        UDToast.a r102 = UDToast.build(r100);
        r102.g(nullIsEmpty(r101));
        r102.d(R.drawable.ud_icon_yes_outlined);
        r102.a().show();
    }

    public static void loadFail(final Context r100, final CharSequence r101) {
        runOnUiThread(new m(r100, r101));
    }

    public static void loadSuccess(final Context r100, final CharSequence r101) {
        runOnUiThread(new d(r100, r101));
    }

    public static void show(Context r100, int r101) {
        show(r100, r100.getString(r101));
    }

    public static void showInCenter(Context r100, int r101) {
        showInCenter(r100, r100.getString(r101));
    }

    public static void showLoading(Context r100, int r101) {
        showLoading(r100, r100.getString(r101));
    }

    private static void lambda$show$11(Context r100, String r101, long r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.f285429b.f417630d = r102;
        r103.a().show();
    }

    private static /* synthetic */ void lambda$show$8(Context r100, String r101, int r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.d(r102);
        r103.a().show();
    }

    private static void lambda$show$9(Context r100, String r101, long r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.f285429b.f417630d = r102;
        r103.a().show();
    }

    private static void lambda$showInCenter$10(Context r100, String r101, long r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.f285429b.f417630d = r102;
        r103.a().show();
    }

    private static void lambda$showInCenter$12(Context r100, String r101, long r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r101));
        r103.f285429b.c(17, 0, 0);
        r103.f285429b.f417630d = r102;
        r103.a().show();
    }

    public static b newGlobal(Context r100, int r101, String r102) {
        UDToast.a r103 = UDToast.build(r100);
        r103.g(nullIsEmpty(r102));
        r103.d(r101);
        return new b(r100, r103);
    }

    public static b newGlobalInCenter(Context r100, String r101, int r102) {
        return newGlobalInCenter(r100, r101);
    }

    public static void show(final Context r100, final String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L12;
        if (r102 == false) goto L8;
        final long r103 = -2;
    L9:
        runOnUiThread(new j(r100, r101, r103));
        return;
    L8:
        r103 = -1;
        goto L9
    }

    public static void showInCenter(final Context r100, final String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L12;
        if (r102 == false) goto L8;
        final long r103 = -2;
    L9:
        runOnUiThread(new q(r100, r101, r103));
        return;
    L8:
        r103 = -1;
        goto L9
    }

    public static b newGlobal(Context r100, String r101, int r102) {
        return newGlobal(r100, r101);
    }

    public static void show(final Context r100, final int r101, final String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new k(r100, r102, r101));
        return;
    }

    public static void showInCenter(final Context r100, final String r101, final long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new e(r100, r101, r102));
        return;
    }

    public static void show(final Context r100, final String r101, final long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new h(r100, r101, r102));
        return;
    }

    public static void showInCenter(Context r100, int r101, long r102) {
        showInCenter(r100, r100.getString(r101), r102);
    }

    public static void show(Context r100, int r101, int r102) {
        show(r100, r101, r100.getString(r102));
    }

    public static void showInCenter(Context r100, int r101, boolean r102) {
        showInCenter(r100, r100.getString(r101), r102);
    }

    public static void show(Context r100, int r101, long r102) {
        show(r100, r100.getString(r101), r102);
    }

    public static void show(Context r100, int r101, boolean r102) {
        show(r100, r100.getString(r101), r102);
    }

    private static void lambda$show$13(Context r100, String r101, int r102, long r103) {
        UDToast.a r104 = UDToast.build(r100);
        r104.g(nullIsEmpty(r101));
        r104.d(r102);
        r104.f285429b.f417630d = r103;
        r104.a().show();
    }

    public static void show(final Context r100, final int r101, final String r102, final long r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDisabled() == true) goto L9;
        runOnUiThread(new f(r100, r102, r101, r110));
        return;
    }

    public static void show(Context r100, int r101, int r102, long r103) {
        show(r100, r101, r100.getString(r102), r103);
    }
}
