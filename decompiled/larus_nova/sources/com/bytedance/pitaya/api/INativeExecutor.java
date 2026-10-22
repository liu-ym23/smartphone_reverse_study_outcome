package com.bytedance.pitaya.api;

import com.bytedance.pitaya.api.bean.PTYNativeTaskConfig;
import com.bytedance.pitaya.api.bean.PTYNativeTaskData;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/bytedance/pitaya/api/INativeExecutor;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "releaseNativeEngine", "", "businessName", "", "runNativeTask", "input", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskData;", "taskConfig", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "resultCallback", "Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface INativeExecutor extends ReflectionCall {
    void releaseNativeEngine(String r100);

    void runNativeTask(String r100, PTYNativeTaskData r101, PTYNativeTaskConfig r102, PTYTaskResultCallback r103);
}
