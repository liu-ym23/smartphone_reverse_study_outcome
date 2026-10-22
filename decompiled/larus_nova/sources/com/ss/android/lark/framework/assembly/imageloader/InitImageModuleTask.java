package com.ss.android.lark.framework.assembly.imageloader;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.abtest.feature.launch.LaunchAbTestConfig;
import com.ss.android.lark.image.i;
import com.ss.android.lark.log.Log;
import iua.a;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class InitImageModuleTask extends AbstractLaunchTask {
    public InitImageModuleTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        List<a<?>> r101 = LaunchAbTestConfig.f408536a;
        if (((Boolean) LaunchAbTestConfig.f408538c.getValue()).booleanValue() == true) goto L6;
        Log.i("ImageModuleProvider", "preLoad");
        i.a();
        return;
    }
}
