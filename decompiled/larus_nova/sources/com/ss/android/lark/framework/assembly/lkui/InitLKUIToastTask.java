package com.ss.android.lark.framework.assembly.lkui;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.t;
import com.ss.android.lark.appcontext.applifecycle.w;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class InitLKUIToastTask extends AbstractLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f425653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f425654d;

    public class a implements t {
        public a() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.t
        public final void a(Activity r100) {
            Log.i("InitLKUIToastTask", "onBackToFrontEvent");
            LKUIToast.enableToast();
        }
    }

    public class b implements w {
        public b() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.w
        public final void a(Class r100) {
            Log.i("InitLKUIToastTask", "onFrontToBackEvent");
            LKUIToast.disableToast();
        }
    }

    public InitLKUIToastTask() {
        this.f425653c = new a();
        this.f425654d = new b();
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        a r101 = this.f425653c;
        if (r101 != null) goto L5;
        List<t> r102 = LifecycleHandler.f408816a;
    L6:
        b r103 = this.f425654d;
        if (r103 == null) goto L11;
        ((CopyOnWriteArrayList) LifecycleHandler.f408817b).add(r103);
        return;
    L11:
        return;
    L5:
        ((CopyOnWriteArrayList) LifecycleHandler.f408816a).add(r101);
        goto L6
    }
}
