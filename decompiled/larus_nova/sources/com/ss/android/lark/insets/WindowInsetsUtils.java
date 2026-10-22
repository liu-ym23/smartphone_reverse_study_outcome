package com.ss.android.lark.insets;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class WindowInsetsUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427723a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f427724a;

        public a(View r100) {
            this.f427724a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f427724a.requestApplyInsets();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f427725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f427726b;

        public b(View r100, View r101) {
            this.f427725a = r100;
            this.f427726b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f427726b.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setBackgroundColor(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, com.ss.android.lark.insets.j] */
    @JvmStatic
    public static final f a(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.findViewById(R.id.content);
        Map<Integer, WeakReference<j>> r101 = e.f427749r;
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Window r102 = r100.getWindow();
        if (r102 == null) goto L5;
        e.a.a(r102);
        int r103 = h.f427764q;
        return h.a.a(r102);
    L5:
        int r104 = r100.hashCode();
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        Map<Integer, WeakReference<j>> r106 = e.f427749r;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        WeakReference r108 = (WeakReference) r107.get(Integer.valueOf(r104));
        if (r108 == null) goto L8;
        T r109 = (j) r108.get();
    L9:
        r105.element = r109;
        if (r109 != 0) goto L13;
        r105.element = new j();
        r100.setOnShowListener(new d(r100, r105, r104));
        r106.put(Integer.valueOf(r104), new WeakReference(r105.element));
    L13:
        return (f) r105.element;
    L8:
        r109 = 0;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.ss.android.lark.insets.j] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @JvmStatic
    public static final f b(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Map<Integer, j> r101 = FragmentWindowInsetsHandler.f427716p;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L10;
        final int r102 = r100.hashCode();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        Map<Integer, j> r104 = FragmentWindowInsetsHandler.f427716p;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        ?? r106 = r105.get(Integer.valueOf(r102));
        r103.element = r106;
        if (r106 != 0) goto L9;
        r103.element = new j();
        r104.put(Integer.valueOf(r102), (j) r103.element);
        r100.getLifecycle().addObserver(new FragmentWindowInsetsHandler$Companion$obtainHandler$1(r100, r102, r103));
    L9:
        return (f) r103.element;
    L10:
        return ((FragmentWindowInsetsHandler.InsetsHandlerHolder) new ViewModelProvider(r100, new FragmentWindowInsetsHandler$Companion$obtainHandlerCreated$1(r100)).get(FragmentWindowInsetsHandler.InsetsHandlerHolder.class)).getInsetsHandler();
    }

    @JvmStatic
    public static final h c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = com.ss.android.lark.insets.b.f427731a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        r100.findViewById(R.id.content);     // Catch: NullPointerException -> L5
    L11:
        int r102 = h.f427764q;
        return h.a.a(r100.getWindow());
    L5:
        View r103 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L10:
        r103.findViewById(R.id.content);
        goto L11
    }

    @JvmStatic
    public static final void d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        h r101 = c(r100);
        r101.f(false);
        r101.o(false);
        r101.c(false);
    }

    @JvmStatic
    public static final void e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        h(r100.getWindow(), c(r100));
    }

    @JvmStatic
    public static final void f(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        boolean r101 = false;
        WindowCompat.setDecorFitsSystemWindows(r100.getWindow(), false);
        int r102 = Build.VERSION.SDK_INT;
        if (29 <= r102) goto L5;
    L7:
        if (r101 == false) goto L10;
        r100.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        return;
    L10:
        return;
    L5:
        if (r102 >= 35) goto L7;
        r101 = true;
        goto L7
    }

    @JvmStatic
    public static final void h(Window r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r101, "insetsHandler");
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 35) goto L5;
        r100.setStatusBarColor(0);
        r100.setNavigationBarColor(0);
    L5:
        View r103 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L10:
        OneShotPreDrawListener.add(r103, new b(r103, r103));
        if (r102 < 29) goto L13;
        r100.setNavigationBarContrastEnforced(false);
        r100.setStatusBarContrastEnforced(false);
    L13:
        r101.b(0);
        r101.i(0);
    }

    @JvmStatic
    public static final void g(View r100, final boolean r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == true) goto L7;
        if (r102 == true) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(r100, null);
        return;
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(r100, new WindowInsetsUtils$setViewFitSystemWindow$1(r101, r102));
        if (r100.isAttachedToWindow() == false) goto L10;
        r100.requestApplyInsets();
        return;
    L10:
        r100.post(new a(r100));
    }
}
