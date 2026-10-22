package com.ss.android.lark.chat.api.service.track.sample;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public final class ReadSampleReportConfig implements Serializable {

    @JSONField(name = "max_chat_member_count")
    public Integer maxChatMemberCount;

    @JSONField(name = "read_count_lower_threshold")
    public Integer readCountLowerThreshold;

    @JSONField(name = "read_count_upper_fact")
    public Float readCountUpperFact;

    @JSONField(name = "report_time_internal_ms")
    public Long reportTimeIntervalInMs;

    @JSONField(name = "steady_state_period_s")
    public Long steadyStatePeriodInSeconds;

    @JSONField(name = "sync_msg_dep_latency_ms")
    public Long syncMsgDepLatencyInMs;

    public ReadSampleReportConfig() {
        this.reportTimeIntervalInMs = 0L;
        this.steadyStatePeriodInSeconds = 0L;
        this.maxChatMemberCount = 0;
        this.readCountLowerThreshold = 0;
        this.readCountUpperFact = Float.valueOf(1.0f);
        this.syncMsgDepLatencyInMs = 0L;
    }

    public ReadSampleReportConfig(Long r100, Long r101, Integer r102, Integer r103, Float r104, Long r105) {
        this.reportTimeIntervalInMs = r100;
        this.steadyStatePeriodInSeconds = r101;
        this.maxChatMemberCount = r102;
        this.readCountLowerThreshold = r103;
        this.readCountUpperFact = r104;
        this.syncMsgDepLatencyInMs = r105;
    }
}
