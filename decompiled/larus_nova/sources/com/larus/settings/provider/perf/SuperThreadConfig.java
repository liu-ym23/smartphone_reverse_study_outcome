package com.larus.settings.provider.perf;

import com.google.gson.annotations.SerializedName;
import com.larus.im.internal.network.proto2.AvCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/perf/SuperThreadConfig;", "", "enableType", "", "enablePriority", "", "enableTransformName", "resourceDredgeConfig", "threadCountConfig", "", "keepAliveTimeConfig", "maxBlockTime", "monitorConfig", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getEnableType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnablePriority", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableTransformName", "getResourceDredgeConfig", "getThreadCountConfig", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKeepAliveTimeConfig", "getMaxBlockTime", "getMonitorConfig", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuperThreadConfig {

    @SerializedName("enable_priority")
    private final Boolean enablePriority;

    @SerializedName("enable_transform_name")
    private final Boolean enableTransformName;

    @SerializedName("enable_type")
    private final Integer enableType;

    @SerializedName("keep_alive_time_config")
    private final Integer keepAliveTimeConfig;

    @SerializedName("max_block_time")
    private final Long maxBlockTime;

    @SerializedName("monitor_config")
    private final Integer monitorConfig;

    @SerializedName("resource_dredge_config")
    private final Integer resourceDredgeConfig;

    @SerializedName("thread_count_config")
    private final Long threadCountConfig;

    public SuperThreadConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final Boolean getEnablePriority() {
        return this.enablePriority;
    }

    public final Boolean getEnableTransformName() {
        return this.enableTransformName;
    }

    public final Integer getEnableType() {
        return this.enableType;
    }

    public final Integer getKeepAliveTimeConfig() {
        return this.keepAliveTimeConfig;
    }

    public final Long getMaxBlockTime() {
        return this.maxBlockTime;
    }

    public final Integer getMonitorConfig() {
        return this.monitorConfig;
    }

    public final Integer getResourceDredgeConfig() {
        return this.resourceDredgeConfig;
    }

    public final Long getThreadCountConfig() {
        return this.threadCountConfig;
    }

    public SuperThreadConfig(Integer r100, Boolean r101, Boolean r102, Integer r103, Long r104, Integer r105, Long r106, Integer r107) {
        this.enableType = r100;
        this.enablePriority = r101;
        this.enableTransformName = r102;
        this.resourceDredgeConfig = r103;
        this.threadCountConfig = r104;
        this.keepAliveTimeConfig = r105;
        this.maxBlockTime = r106;
        this.monitorConfig = r107;
    }

    public /* synthetic */ SuperThreadConfig(Integer r110, Boolean r111, Boolean r112, Integer r113, Long r114, Integer r115, Long r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r100 = 11;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Boolean r101 = Boolean.TRUE;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r103 = 1010101010;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Long r104 = 10054864050550L;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r105 = 60060060;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Long r106 = 5000L;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r107 = Integer.valueOf(AvCmd.CommandEventType.SPEECH_ONLY_VALUE);
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
