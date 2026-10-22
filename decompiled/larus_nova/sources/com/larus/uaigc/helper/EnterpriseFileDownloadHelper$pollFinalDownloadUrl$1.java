package com.larus.uaigc.helper;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.helper.EnterpriseFileDownloadHelper", f = "EnterpriseFileDownloadHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {106, 132}, m = "pollFinalDownloadUrl", n = {DBDefinition.TASK_ID, PerfLog.PARAM_KEY_CONTEXT_ID, "maxPollCount", "pollIntervalMs", MapMonitorConst.ATTEMPT, DBDefinition.TASK_ID, PerfLog.PARAM_KEY_CONTEXT_ID, "maxPollCount", "pollIntervalMs"}, s = {"L$0", "L$1", "I$0", "J$0", "I$2", "L$0", "L$1", "I$0", "J$0"})
public final class EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterpriseFileDownloadHelper this$0;

    public EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1(EnterpriseFileDownloadHelper r100, Continuation<? super EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        EnterpriseFileDownloadHelper r101 = this.this$0;
        EnterpriseFileDownloadHelper r102 = EnterpriseFileDownloadHelper.f372995a;
        return r101.b(null, null, this);
    }
}
