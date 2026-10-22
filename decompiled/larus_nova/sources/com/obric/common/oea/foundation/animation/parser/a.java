package com.obric.common.oea.foundation.animation.parser;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import bja.b;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fja.d;
import fja.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f396386a = 0;

    static {
    }

    public static d a(com.obric.common.oea.foundation.animation.builder.a r110, View r111, List r112, Function3 r113, final Function2 r114) {
        Intrinsics.checkNotNullParameter(r110, "animConfig");
        Intrinsics.checkNotNullParameter(r112, "animationCommands");
        ArrayList r100 = new ArrayList();
        Iterator r101 = r112.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(((dja.a) r101.next()).a());
        goto L4
    L6:
        if (r111 == null) goto L19;
        ArrayList<d> r102 = b.f19265a;
        Intrinsics.checkNotNullParameter(r111, "view");
        bja.a<?> r103 = b.f19266b.get(r111);
        if (r103 == null) goto L10;
        float r104 = r103.f19264k;
    L11:
        Iterator r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        bja.a<?> r106 = (bja.a) r105.next();
        if (r106.f19262i != null) goto L17;
        mja.a.C6822a r107 = mja.a.f514263a;
        mja.a.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r104);
        r106.f19262i = Float.valueOf(r104);
    L18:
        ArrayList<d> r108 = b.f19265a;
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r106, "animationInfo");
        b.f19266b.put(r111, r106);
        goto L13
    L17:
        mja.a.C6822a r109 = mja.a.f514263a;
        mja.a.a("AnimatableSubmitter", "指定了初始速度，" + r106.f19262i);
        goto L18
    L10:
        r104 = 0.0f;
    L19:
        final d r115 = new d();
        ArrayList<d> r116 = b.f19265a;
        Intrinsics.checkNotNullParameter(r115, "animationManager");
        ArrayList<d> r117 = b.f19265a;
        r117.add(r115);
        mja.a.C6822a r118 = mja.a.f514263a;
        String r119 = "addAnimationManager, size: " + r117.size();
        Intrinsics.checkNotNullParameter("AnimationLifecycleListener", "tag");
        Intrinsics.checkNotNullParameter(r119, "msg");
        if (mja.a.f514263a == null) goto L22;
        Intrinsics.checkNotNullParameter("AnimationLifecycleListener", "tag");
        Intrinsics.checkNotNullParameter(r119, "msg");
    L22:
        Function2<Boolean, Throwable, Unit> r120 = new AnimatableSubmitter$animate$2(r114, r115);
        Intrinsics.checkNotNullParameter(r110, "animConfig");
        Intrinsics.checkNotNullParameter(r100, "animationInfos");
        float r121 = r110.f396360d;
        boolean r122 = r110.f396361e;
        RunMode r123 = r110.f396357a;
        float r124 = r110.f396359c;
        RepeatMode r125 = r110.f396358b;
        if ((!Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread())) == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new e(r115, r121, r122, r111, r123, r124, r125, r100, r113, r120));
    L26:
        return r115;
    L25:
        r115.b(r121, r122, r111, r123, r124, r125, r100, r113, r120);
        goto L26
    }
}
