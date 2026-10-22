package com.bytedance.timon_monitor_api;

import com.bytedance.timonbase.ITMBusinessService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/bytedance/timon_monitor_api/IMonitorDynamicBusiness;", "Lcom/bytedance/timonbase/ITMBusinessService;", "addInterceptPipelineSystem", "", "block", "Lkotlin/Function1;", "Lcom/bytedance/timonbase/pipeline/TimonPipeline;", "addInterceptReportPipelineSystem", "addReplacePipelineSystem", "addReplaceReportPipelineSystem", "executeIntercept", "executeReplace", "timon-monitor-api_release"}, k = 1, mv = {1, 1, 16})
public interface IMonitorDynamicBusiness extends ITMBusinessService {
    void addInterceptPipelineSystem(Function1<? super TimonPipeline, Unit> r100);

    void addInterceptReportPipelineSystem(Function1<? super TimonPipeline, Unit> r100);

    void addReplacePipelineSystem(Function1<? super TimonPipeline, Unit> r100);

    void addReplaceReportPipelineSystem(Function1<? super TimonPipeline, Unit> r100);

    /* synthetic */ String businessName();

    void executeIntercept();

    void executeReplace();
}
