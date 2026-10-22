package com.bytedance.pitaya.api;

import android.content.Context;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.pitaya.api.bean.PTYCleanStrategy;
import com.bytedance.pitaya.api.bean.PTYNativeTaskConfig;
import com.bytedance.pitaya.api.bean.PTYNativeTaskData;
import com.bytedance.pitaya.api.bean.PTYRequestConfig;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\tH&J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u001f\u001a\u00020\tH&J*\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H&J.\u0010'\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010#\u001a\u00020)2\u0006\u0010%\u001a\u00020&H&J\"\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\u0010\u000e\u001a\u0004\u0018\u00010-H&J\u0010\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u00063"}, d2 = {"Lcom/bytedance/pitaya/api/IPitayaCore;", "Lcom/bytedance/pitaya/api/PitayaFE;", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "cleanStorage", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "callback", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "downloadPackage", "businessName", "packageCallback", "Lcom/bytedance/pitaya/api/PTYPackageCallback;", "isPreloadReady", "", "isReady", "preDownloadAllPackage", "queryPackage", "releaseAllEngines", "releaseEngine", "releaseNativeEngine", "requestUpdate", "requestConfig", "Lcom/bytedance/pitaya/api/bean/PTYRequestConfig;", "requestUpdateAll", "runNativeTask", "input", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskData;", "taskConfig", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "resultCallback", "Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "runTask", "Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "Lcom/bytedance/pitaya/api/bean/PTYTaskConfig;", LynxTemplateRender.RENDER_PHASE_SETUP, "ptySetupInfo", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "Lcom/bytedance/pitaya/api/PTYSetupCallback;", "socketLogError", "content", "socketLogInfo", "socketLogWarn", "stopAllDownloadTask", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IPitayaCore extends PitayaFE {

    /* JADX INFO: loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IPitayaCore r100, String r101, PTYTaskData r102, PTYTaskResultCallback r110) {
            r100.runTask(r101, r102, new PTYTaskConfig(false, null, 0.0f, 7, null), r110);
        }
    }

    void cleanStorage(Context r100, PTYCleanStrategy r101, PTYNormalCallback r102);

    void downloadPackage(String r100, PTYPackageCallback r101);

    String getAid();

    boolean isPreloadReady();

    boolean isReady();

    void preDownloadAllPackage();

    void queryPackage(String r100, PTYPackageCallback r101);

    void releaseAllEngines();

    void releaseEngine(String r100);

    void releaseNativeEngine(String r100);

    void requestUpdate(String r100, PTYRequestConfig r101, PTYPackageCallback r102);

    void requestUpdateAll();

    void runNativeTask(String r100, PTYNativeTaskData r101, PTYNativeTaskConfig r102, PTYTaskResultCallback r103);

    void runTask(String r100, PTYTaskData r101, PTYTaskConfig r102, PTYTaskResultCallback r103);

    void setAid(String r100);

    void setup(Context r100, PTYSetupInfo r101, PTYSetupCallback r102);

    void socketLogError(String r100);

    void socketLogInfo(String r100);

    void socketLogWarn(String r100);

    void stopAllDownloadTask();
}
