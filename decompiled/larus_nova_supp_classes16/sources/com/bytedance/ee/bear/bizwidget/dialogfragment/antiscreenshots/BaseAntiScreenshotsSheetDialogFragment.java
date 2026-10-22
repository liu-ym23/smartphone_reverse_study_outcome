package com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.g;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/IAntiScreenshotsConfig;", "<init>", "()V", "antiScreenshotsDelegate", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/delegate/DialogFragmentAntiScreenshotsDelegate;", "DP_11", "", "getDP_11", "()I", "insetsBgDrawable", "Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "getInsetsBgDrawable", "()Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "insetsBgDrawable$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onDestroy", "onDoCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getContext", "Landroid/content/Context;", "resetNavigationBarColor", "navigationBarColor", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseAntiScreenshotsSheetDialogFragment extends BaseForsetiCompatBottomSheetDialogFragment implements com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a {
    public final d f;
    public final int g;
    public final Lazy h;

    public static final class a {
        @JvmStatic
        public static boolean a(int r9) {
            if ((((double) 1) - ((((((double) Color.red(r9)) * 0.299d) + (((double) Color.green(r9)) * 0.587d)) + (((double) Color.blue(r9)) * 0.114d)) / ((double) 255))) < 0.5d) goto L7;
            return false;
        L7:
            return true;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseAntiScreenshotsSheetDialogFragment c;
        public final /* synthetic */ int d;

        public b(View r1, View r2, BaseAntiScreenshotsSheetDialogFragment r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            this.b.setBackground((g) this.c.h.getValue());
            WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this.b);
            if (r0 == null) goto L5;
            Insets r1 = r0.getInsets(WindowInsetsCompat.Type.systemBars());
        L6:
            ((g) this.c.h.getValue()).a(r1);
            g r2 = (g) this.c.h.getValue();
            r2.g = this.d;
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a
    public final boolean Cl() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View V90(LayoutInflater r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return null;
    }

    public BaseAntiScreenshotsSheetDialogFragment() {
        this.f = new d(this);
        this.g = n.d(11);
        this.h = LazyKt.lazy(BaseAntiScreenshotsSheetDialogFragment$insetsBgDrawable$2.INSTANCE);
    }

    public Context getContext() {
        Context r0 = super/*androidx.fragment.app.Fragment*/.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        d r0 = this.f;
        MutableLiveData<Integer> r1 = r0.c;
        if (r1 == null) goto L6;
        r1.removeObserver(r0.d);
        return;
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        d r0 = this.f;
        MutableLiveData<Integer> r1 = r0.c;
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        r0.b(r3);
        return;
    L7:
        r3 = -1;
        goto L8
    }

    public static View X90(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void Y90(int r4) {
        int r5 = UIUtils.getColor(getActivity(), r4);
        Dialog r0 = getDialog();
        int r1 = WindowInsetsUtils.a;
        if (r0 == null) goto L8;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L8;
        WindowInsetsUtils.h(r2, WindowInsetsUtils.a(r0));
    L8:
        Dialog r3 = getDialog();
        if (r3 == null) goto L13;
        Window r6 = r3.getWindow();
        if (r6 == null) goto L13;
        View r7 = r6.findViewById(2131367728);
    L14:
        if (r7 == null) goto L16;
        OneShotPreDrawListener.add(r7, new b(r7, r7, this, r5));
    L16:
        Dialog r8 = getDialog();
        if (r8 == null) goto L26;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L27;
        X90(r9).setSystemUiVisibility(1280);
        r9.addFlags(ShareItemModel.SRC_TINT_UNDEFINED);
        if (Build.VERSION.SDK_INT < 23) goto L28;
        WindowInsetsControllerCompat r10 = WindowCompat.getInsetsController(r9, X90(r9));
        if (r10 == null) goto L29;
        r10.setAppearanceLightNavigationBars(a.a(r5));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L13:
        r7 = null;
        goto L14
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.f.a();
    }
}
