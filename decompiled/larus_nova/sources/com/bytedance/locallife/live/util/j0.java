package com.bytedance.locallife.live.util;

import android.content.res.Resources;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class j0 {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f260706a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f260706a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f260706a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        r102.removeView(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final float b(float r100) {
        Resources r101 = LiveLifeSaaSUtil.p().getResources();
        return (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f;
    }

    public static final int c(int r100) {
        return (int) b(r100);
    }

    public static final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.replace$default(r100, 65509, 165, false, 4, null);
    }

    public static final float e(float r100) {
        Resources r101 = LiveLifeSaaSUtil.p().getResources();
        return (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static final int f(int r100) {
        return (int) e(r100);
    }

    public static final void h(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r100.invoke();
        return;
    L5:
        com.bytedance.locallife.common.utils.k.d(new a(r100));
    }

    public static final boolean g(long r100, String r101) {
        if (s.d(r101) == false) goto L16;
        LiveLocalLifeViewModel.Companion r102 = LiveLocalLifeViewModel.Companion;
        if (r101 != null) goto L7;
        String r103 = "";
    L8:
        r102.getClass();
        LiveLocalLifeViewModel r104 = LiveLocalLifeViewModel.Companion.a(r103);
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        return true;
    L11:
        if (r104.isPreview() != true) goto L13;
        r105 = true;
        goto L14
    L7:
        r103 = r101;
    L16:
        if (r101 != null) goto L18;
        r101 = "";
    L18:
        Room r106 = LiveLocalLifeUtil.d(r101);
        if (r106 != null) goto L21;
        return false;
    L21:
        if (r100 != r106.f162599id) goto L25;
        return true;
    L25:
        return false;
    }
}
