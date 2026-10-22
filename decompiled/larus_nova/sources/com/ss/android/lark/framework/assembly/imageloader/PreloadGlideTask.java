package com.ss.android.lark.framework.assembly.imageloader;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.larksuite.framework.launch.task.AsyncLaunchTask;

/* JADX INFO: loaded from: classes36.dex */
public class PreloadGlideTask extends AsyncLaunchTask {
    public PreloadGlideTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Glide.get(r100);
    }
}
