package com.ss.android.lark.framework.assembly.rxjava;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.b;
import com.ss.android.lark.utils.rxjava.f;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Properties;
import kjb.a;

/* JADX INFO: loaded from: classes36.dex */
public class InitRxJavaTask extends AsyncLaunchTask {
    public InitRxJavaTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        RxJavaPlugins.setErrorHandler(new f(DevEnvUtil.isDevelopPackage(b.f285948a)));
        Properties r101 = System.getProperties();
        r101.setProperty("rx2.purge-enabled", "false");
        r101.setProperty("rx2.io-keep-alive-time", "300");
        RxJavaPlugins.setScheduleHandler(new a());
    }
}
