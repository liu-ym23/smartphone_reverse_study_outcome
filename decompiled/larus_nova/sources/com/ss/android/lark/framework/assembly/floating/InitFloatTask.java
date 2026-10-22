package com.ss.android.lark.framework.assembly.floating;

import android.app.Application;
import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import xfb.b;

/* JADX INFO: loaded from: classes36.dex */
public class InitFloatTask extends AbstractLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<xfb.a.InterfaceC8230a, y> f425648c;

    public class a implements tfb.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitFloatTask f425649a;

        public a(InitFloatTask r100) {
            this.f425649a = r100;
        }
    }

    public InitFloatTask() {
        this.f425648c = new ConcurrentHashMap();
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        if (z.e(r100) == true) goto L5;
        return;
    L5:
        Application r101 = (Application) r100;
        a r102 = new a(this);
        tfb.a.b r103 = tfb.a.f545789a;
        Intrinsics.checkNotNullParameter(r101, "application");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        if (tfb.a.f545790b.compareAndSet(false, true) == false) goto L11;
        tfb.a.f545791c = r102;
        tfb.a.c r104 = xfb.a.f563552a;
        Intrinsics.checkNotNullParameter(r101, "application");
        r101.registerActivityLifecycleCallbacks(new b());
        tfb.a.c r105 = xfb.a.f563552a;
        if (r105 == null) goto L12;
        xfb.a.b r106 = xfb.a.f563554c;
        com.ss.android.lark.framework.assembly.floating.a r107 = new com.ss.android.lark.framework.assembly.floating.a();
        AppLifecycle.a.f408803a.c(r107);
        ((ConcurrentHashMap) ((a) r105).f425649a.f425648c).put(r106, r107);
        return;
    L12:
        return;
    }
}
