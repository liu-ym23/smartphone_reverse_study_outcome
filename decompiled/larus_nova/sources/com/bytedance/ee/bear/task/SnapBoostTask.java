package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.common.profilesdk.snapboost.ClassList;
import com.bytedance.common.profilesdk.snapboost.SnapBoost;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.y;
import java.util.concurrent.ExecutorService;
import vn5.j;

/* JADX INFO: loaded from: classes18.dex */
public class SnapBoostTask extends BaseAsyncLaunchTask {

    public class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f238750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SnapBoostTask f238751b;

        public a(SnapBoostTask r100, Context r101) {
            this.f238751b = r100;
            this.f238750a = r101;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(y.a r100, y.a r101) {
            if (r101.f408860c == true) goto L6;
            Context r102 = this.f238750a;
            SnapBoost.init(r102, DevEnvUtil.isDevelopPackage(r102));
            ExecutorService r103 = CoreThreadPool.getDefault().getFixedThreadPool();
            final SnapBoostTask r104 = this.f238751b;
            r103.execute(new j(r104));
            com.ss.android.lark.appcontext.applifecycle2.api.a.d(this);
            return;
        }
    }

    public SnapBoostTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        SnapBoost.init(r100, DevEnvUtil.isDevelopPackage(r100));     // Catch: Throwable -> L5
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L5
        ClassList.PreloadResult r102 = SnapBoost.findClassList("ccmpreloadclass.txt").tryPreloadClasses();     // Catch: Throwable -> L5
        tt5.a.h("SnapBoostTask", "perLoadRet: loaded count:" + r102.getLoadedCount() + ", not found:" + r102.getNotFoundCount() + ", time cost:" + (System.currentTimeMillis() - r101));     // Catch: Throwable -> L5
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new a(this, r100));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SnapBoostTask", "SnapBoostTask execute error!", th, false);
    }
}
