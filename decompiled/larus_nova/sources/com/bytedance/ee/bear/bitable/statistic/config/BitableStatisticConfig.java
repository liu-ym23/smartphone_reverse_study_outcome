package com.bytedance.ee.bear.bitable.statistic.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "ccm_base_performance_config")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/config/BitableStatisticConfig;", "", "<init>", "()V", "disableTrace", "", "getDisableTrace", "()Ljava/lang/Boolean;", "setDisableTrace", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "pointWarningTime", "", "getPointWarningTime", "()Ljava/lang/Integer;", "setPointWarningTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<BitableStatisticConfig> f215651a = null;

    @SerializedName("disable_trace")
    private Boolean disableTrace;

    @SerializedName("point_warning_time")
    private Integer pointWarningTime;

    public static final class a {
    }

    public BitableStatisticConfig() {
    }

    static {
        f215651a = LazyKt.lazy(BitableStatisticConfig$Companion$config$2.INSTANCE);
    }

    public final Boolean a() {
        return this.disableTrace;
    }

    public final Integer b() {
        return this.pointWarningTime;
    }
}
