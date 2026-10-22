package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.common.profilesdk.snapboost.ClassList;
import com.bytedance.common.profilesdk.snapboost.SnapBoost;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.y;
import java.util.concurrent.ExecutorService;
import vn5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SnapBoostTask extends BaseAsyncLaunchTask {

    public class a implements y {
        public final /* synthetic */ Context a;
        public final /* synthetic */ SnapBoostTask b;

        public a(SnapBoostTask r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void f(y.a r2, y.a r3) {
            if (r3.c == true) goto L6;
            Context r4 = this.a;
            SnapBoost.init(r4, DevEnvUtil.isDevelopPackage(r4));
            ExecutorService r5 = CoreThreadPool.getDefault().getFixedThreadPool();
            final SnapBoostTask r6 = this.b;
            r5.execute(new j(r6));
            com.ss.android.lark.appcontext.applifecycle2.api.a.d(this);
            return;
        }
    }

    public SnapBoostTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r9) {
        SnapBoost.init(r9, DevEnvUtil.isDevelopPackage(r9));     // Catch: Throwable -> L5
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L5
        ClassList.PreloadResult r4 = SnapBoost.findClassList("ccmpreloadclass.txt").tryPreloadClasses();     // Catch: Throwable -> L5
        tt5.a.h("SnapBoostTask", "perLoadRet: loaded count:" + r4.getLoadedCount() + ", not found:" + r4.getNotFoundCount() + ", time cost:" + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L5
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new a(this, r9));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SnapBoostTask", "SnapBoostTask execute error!", th, false);
    }
}
