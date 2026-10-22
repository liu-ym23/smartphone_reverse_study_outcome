package com.ss.android.lark.featuregating.nouser;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class InitSettingsFGTask extends AsyncLaunchTask {
    public InitSettingsFGTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        IGetDataCallback<Map<String, Boolean>> r101 = new AnonymousClass1(this);
        Log.i("InitSettingsFGTask", "fetchAndUpdateSettingsFGData call");
        FeatureGatingModule.getDependency().ic(r100, r101);
    }
}
