package com.ss.android.lark.framework.assembly.soloader;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import com.larksuite.framework.launch.task.AsyncLaunchTask;

/* JADX INFO: loaded from: classes36.dex */
public class InitSoLoaderTask extends AsyncLaunchTask {
    public InitSoLoaderTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        SoLoader.init(r100, false);
    }
}
