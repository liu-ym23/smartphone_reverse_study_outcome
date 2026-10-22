package com.ss.android.lark.chat.api.service.track.sample;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public final class ReactionSampleReportConfig implements Serializable {

    @JSONField(name = "max_chat_member_count")
    public Integer maxChatMemberCount;

    @JSONField(name = "quantile_count")
    public Integer quantileCount;

    @JSONField(name = "report_time_internal_ms")
    public Long reportTimeIntervalInMs;

    @JSONField(name = "steady_state_period_s")
    public Long steadyStatePeriodInSeconds;

    @JSONField(name = "sync_msg_dep_latency_ms")
    public Long syncMsgDepLatencyInMs;

    public ReactionSampleReportConfig() {
        this.reportTimeIntervalInMs = 0L;
        this.steadyStatePeriodInSeconds = 0L;
        this.maxChatMemberCount = 0;
        this.quantileCount = 0;
        this.syncMsgDepLatencyInMs = 0L;
    }

    public ReactionSampleReportConfig(Long r100, Long r101, Integer r102, Integer r103, Long r104) {
        this.reportTimeIntervalInMs = r100;
        this.steadyStatePeriodInSeconds = r101;
        this.maxChatMemberCount = r102;
        this.quantileCount = r103;
        this.syncMsgDepLatencyInMs = r104;
    }
}
