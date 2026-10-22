package com.ss.android.lark.chameleon;

import android.content.Context;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonJsRuntime;", "", "run", "", "registerService", "service", "Lcom/ss/android/lark/chameleon/AbsChameleonService;", "init", "mContext", "Landroid/content/Context;", "url", "", "bizType", "Lcom/ss/android/lark/chameleon/ChameleonBizType;", MapMonitorConst.EVENT_DESTROY, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AbsChameleonJsRuntime {
    void destroy();

    void init(Context r100, String r101, ChameleonBizType r102);

    void registerService(AbsChameleonService r100);

    void run();
}
