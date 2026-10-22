package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.animation.TimeInterpolator;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sob.f;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f430255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f430256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TransitionSet f430257c;

    public c(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "rootContainer");
        this.f430255a = r100;
        this.f430256b = new ArrayList();
        this.f430257c = new TransitionSet();
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionInfo");
        r100.invoke(this.f430257c);
    }

    public static void a(c r100, ConstraintLayout r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "endElementsStateConfig");
        d r103 = new d(r101);
        r102.invoke(r103);
        ((ArrayList) r100.f430256b).add(r103);
    }

    public static void c(c r100, final Function1 r101, final Function1 r102, long r103, TimeInterpolator r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = 150;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = new LinearInterpolator();
    L14:
        Intrinsics.checkNotNullParameter(r104, "interpolator");
        final TransitionSet r106 = r100.f430257c;
        r106.addListener(new MotionScene$executeMotion$lambda$3$$inlined$doOnEnd$1(r106, r102, r106));
        r106.addListener(new MotionScene$executeMotion$lambda$3$$inlined$doOnStart$1(r106, r101, r106));
        r106.setDuration(r103);
        r106.setInterpolator(r104);
        TransitionManager.beginDelayedTransition(r100.f430255a, r100.f430257c);
        ArrayList<Transition> r107 = e.f430261a;
        final TransitionSet r108 = r100.f430257c;
        ViewGroup r109 = r100.f430255a;
        Intrinsics.checkNotNullParameter(r108, "task");
        Intrinsics.checkNotNullParameter(r109, "sceneRoot");
        Iterator<Transition> r110 = e.f430261a.iterator();
    L16:
        if (r110.hasNext() == false) goto L26;
        Transition r111 = r110.next();
        int r112 = f.f542817a;
        Object[] r113 = {r109};
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter("forceToEnd", "methodName");
        Intrinsics.checkNotNullParameter(r113, "args");
        Method r114 = f.a(r111.getClass(), r113);     // Catch: Exception -> L24
        if (r114 == null) goto L21;
        r114.setAccessible(true);     // Catch: Exception -> L24
    L21:
        if (r114 == null) goto L16;
        r114.invoke(r111, Arrays.copyOf(r113, 1));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w("ReflectUtil", "couldn't invoke forceToEnd on " + r111 + ", " + e);
        goto L16
    L26:
        ArrayList<Transition> r115 = e.f430261a;
        r115.clear();
        r115.add(r108);
        r108.addListener(new TransitionTaskController$whenPostTask$$inlined$doOnEnd$1(r108, r108));
        Iterator r116 = ((ArrayList) r100.f430256b).iterator();
    L28:
        if (r116.hasNext() == false) goto L30;
        d r117 = (d) r116.next();
        d.b(r117);
        r117.f430260c.applyTo(r117.f430258a);
        goto L28
    }
}
